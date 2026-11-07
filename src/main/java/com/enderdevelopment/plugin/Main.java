package com.enderdevelopment.plugin;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class Main extends JavaPlugin implements Listener {
    private static final int TRIDENT_COUNT = 150;
    private static final double CIRCLE_RADIUS = 4.0;
    private static final String ROD_NAME = "trident";

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onFishingRodPull(PlayerFishEvent event) {
        if (event.getState() != PlayerFishEvent.State.REEL_IN) {
            return;
        }

        Player player = event.getPlayer();
        if (!isNamedFishingRod(player.getInventory().getItemInMainHand())
                && !isNamedFishingRod(player.getInventory().getItemInOffHand())) {
            return;
        }

        Location center = player.getLocation().clone().add(0.0, 1.0, 0.0);
        for (int index = 0; index < TRIDENT_COUNT; index++) {
            double angle = (Math.PI * 2.0 * index) / TRIDENT_COUNT;
            Location spawnLocation = center.clone().add(
                    Math.cos(angle) * CIRCLE_RADIUS,
                    0.0,
                    Math.sin(angle) * CIRCLE_RADIUS);
            Trident trident = (Trident) player.getWorld().spawnEntity(spawnLocation, EntityType.TRIDENT);
            trident.setShooter(player);
            trident.setVelocity(new Vector(Math.cos(angle), 0.0, Math.sin(angle)).multiply(0.8));
        }
    }

    private boolean isNamedFishingRod(ItemStack item) {
        if (item == null || item.getType() != Material.FISHING_ROD) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        if (meta == null || !meta.hasDisplayName()) {
            return false;
        }

        String name = PlainTextComponentSerializer.plainText().serialize(meta.displayName());
        return ROD_NAME.equalsIgnoreCase(name.trim());
    }
}
