# Minecraft Plugin: Trident Ring

Trident Ring is a Minecraft server plugin for Paper that detects when a player reels in a fishing rod named `trident` and summons 150 launched tridents in a circular ring around the player.

## Install

1. Build the plugin with Java 21 and Maven:
   ```bash
   mvn package
   ```
2. Copy the generated `target/plugin.jar` file to your Paper server's `plugins` directory.
3. Start or restart the server.
4. Confirm that the plugin loads successfully.

Requirements:

- Paper Minecraft 1.21.11 or a compatible 1.21 server
- Java 21

## Use

1. Obtain a fishing rod.
2. Rename it to `trident` using an anvil.
3. Hold the named fishing rod in your main hand or off hand.
4. Cast the fishing rod.
5. Reel it in successfully.

When the reel-in event occurs, the plugin spawns 150 tridents around the player in a circle with a 4-block radius. The tridents appear one block above the player's location and travel outward from the circle.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/e22c438b-4f07-4b5b-96fb-eb9ff68d0ae4?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=e22c438b-4f07-4b5b-96fb-eb9ff68d0ae4
