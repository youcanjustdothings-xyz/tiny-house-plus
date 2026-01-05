# Tiny House Plus

A minimal Slay the Spire mod that enhances the Tiny House boss relic by granting an additional random common relic when picked.

## Features

**Extra Random Common Relic** - When you select Tiny House as your boss relic reward, you automatically receive one additional random common relic on top of the original benefits (50 gold, potion, full heal, and +5 max HP).

This is a functionality-focused mod with minimal changes - the relic keeps its original name, description, and appearance for maximum stability and compatibility with other mods.

## Installation

### Prerequisites
- **ModTheSpire** - Install from Steam Workshop
- **BaseMod** - Install from Steam Workshop

### Steps
1. Download `TinyHousePlus.jar` from releases (or build from source)
2. Copy the JAR file to your Slay the Spire mods directory:
   - Windows: `[Steam Directory]\steamapps\common\SlayTheSpire\mods\`
   - Mac: `~/Library/Application Support/Steam/steamapps/common/SlayTheSpire/mods/`
   - Linux: `~/.local/share/Steam/steamapps/common/SlayTheSpire/mods/`
3. Launch Slay the Spire through ModTheSpire
4. Enable "Tiny House Plus" in the mod list
5. Play and enjoy your bonus relic!

## Building from Source

### Requirements
- JDK 8
- Maven 3.x

### Configure Your Paths
Edit `pom.xml` and update the dependency paths to match your Slay the Spire installation:
- `desktop-1.0.jar` - Main game JAR
- `ModTheSpire.jar` - Usually in Steam Workshop folder
- `BaseMod.jar` - Usually in Steam Workshop folder

### Build
```bash
mvn clean package
```

The compiled JAR will be in the `target/` directory.

## Technical Details

This mod uses a single `@SpirePostfixPatch` on the `TinyHouse.onEquip()` method to grant the extra relic immediately when Tiny House is obtained. The implementation:
- Calls `AbstractDungeon.returnRandomRelic(RelicTier.COMMON)` to get a random common relic
- Uses `instantObtain()` to add it directly to the player's inventory
- Avoids concurrent modification issues by not spawning pickable objects

## Compatibility

- **Requires**: ModTheSpire 3.6.0+, BaseMod
- **Compatible with**: Slay the Spire (January 2019 build and later)
- **Mod compatibility**: High - uses minimal patching, should work with most other mods

## License

Free to use and modify.
