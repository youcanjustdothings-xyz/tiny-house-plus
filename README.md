# Tiny House Plus

A minimal mod for Slay the Spire that enhances the Tiny House relic.

## Features

- **Extra Random Common Relic** - Whenever you select Tiny House as your boss relic reward, you'll receive an additional random common relic

Note: This is a minimal, functionality-focused mod. The relic keeps its original name, description, and appearance for maximum stability and compatibility.

## Installation

1. Make sure you have **ModTheSpire** and **BaseMod** installed via Steam Workshop
2. Copy `TinyHousePlus.jar` from the `target` folder to your Slay the Spire mods directory:
   ```
   D:\steam_games\steamapps\common\SlayTheSpire\mods\
   ```
3. Launch Slay the Spire through ModTheSpire
4. Enable "Tiny House Plus" in the mod list
5. Start the game and enjoy!

## Building from Source

Requirements:
- JDK 8
- Maven

Build command:
```bash
mvn clean package
```

The compiled JAR will be in the `target` directory.

## How It Works

The mod uses SpirePatch to modify the existing Tiny House relic:
- Patches the constructor to change the name and description
- Patches the `onEquip()` method to grant an extra random common relic
- Patches the `renderInTopPanel()` method to scale the image by 1.5x

This approach ensures compatibility with other mods that might interact with Tiny House.

## Compatibility

- Requires ModTheSpire 3.6.0+
- Requires BaseMod
- Compatible with Slay the Spire (January 2019 version and later)

