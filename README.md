# SimpleBiomeSystem

SimpleBiomeSystem - noises and new biome system. Mostly works as API.

## Using this API

### Adding to build.gradle
Firstly, add jitpack.io repository.
```groovy
repositories {
    maven {
        url 'https://jitpack.io'
    }
}
```

Then `modImplementation` this API as shown below:
```groovy
dependencies {
    implementation 'com.github.ChessChicken-KZ:SimpleBiomeSystem:d2044715d2'
}
```

For other builds, [visit this website](https://jitpack.io/#ChessChicken-KZ/SimpleBiomeSystem).

### Using this API
1. Create any class biome that extends `ExtendedBiome`.

In `super`, for the `type` put any of the enums inside `BiomeTemperature` class, depending on what climate does your biome appear. 

For `temp` put temperature in `double` value (if you want to put cool temperature, don't use `-` in double. For this, use `BiomeTemperature.COLD` or `BiomeTemperature.EXTREME_COLD` enums).

Example below:

```java
public class BiomeExample extends ExtendedBiome {
    public BiomeExample() {
        super(BiomeTemperature.COLD, 20D); //meaning it usually spawns in -20, cold region.
    }
}
```

2. Put other properties inside your biome class.

Example below:
```java
public class BiomeExample extends ExtendedBiome {
    public BiomeExample() {
        /*
         * Initializing.
         */
        super(BiomeTemperature.COLD, 20D);

        /*
         * Minecraft feature, set name of the biome.
         * Default value: null
         */
        this.setName("My cool biome!");

        /*
         * Minecraft feature, set the biome's grass color in int value.
         * Default value: 0
         */
        this.setGrassColour(7647092);

        /*
         * Minecraft feature, set the biome's foliage color in int value.
         * Default value: 5169201
         */
        this.setFoliageColour(7647092);

        /*
         * Minecraft feature, allowing to add entity spawn in the biome.
         */
        //Normal spawn.
        this.creatures.add(new EntityEntry(/* entity class */ Wolf.class, /* rarity */ 2));
        //Spawn in the night or dark places.
        this.monsters.add(new EntityEntry(/* entity class */ ZombiePigman.class, /* rarity */ 4));
        //Spawn in the water.
        this.waterCreatures.add(new EntityEntry(/* entity class */ Squid.class, /* rarity */ 4));

        /*
         * API feature, the tree density property. Higher the value - more trees. Use negative values to stop tree generation.
         * Default value: 0
         */
        this.setTreeDensity(4);

        /*
         * Minecraft feature, allowing to put custom top tile id.
         * Default value: (byte) BlockBase.GRASS.id
         */
        this.topTileId = (byte) BlockBase.WOOL.id;

        /*
         * API feature, allowing to put custom top tile metadata.
         * Default value: 0
         */
        this.topTileMeta = (byte) 1;

        /*
         * Minecraft feature, allowing to put custom under tile id.
         * Default value: (byte) BlockBase.DIRT.id
         */
        this.underTileId = (byte) BlockBase.DIAMOND_BLOCK.id;

        /*
         * API feature, allowing to put custom under tile metadata.
         * Default value: 0
         */
        this.underTileMeta = (byte) 0;

        /*
         * API feature, allowing to set custom stone block id.
         * Default value: (byte) BlockBase.STONE.id
         */
        this.undergroundID = (byte) BlockBase.STONE.id;

        /*
         * API feature, allowing to set custom stone block metadata.
         * Default value: 0
         */
        this.stoneBlockMeta = (byte) 0;
    }
}
```

3. Register your biome through event bus.

Example below:
```java
/*
 * Do not forget to add this class into entrypoints, see stationapi-example-mod for more information.
 */
public class BiomeListenerExample {

    /*
     * ModID instance.
     */
    @Entrypoint.ModID
    public static ModID modID = Null.get();

    /*
     * Event method.
     */
    @EventListener
    public void registerBiomes(ExtendedBiomeRegisterEvent event)
    {
        /* Use this method for registering biomes. */
        event.register( /* identifier of biome */ Identifier.of(modID, "my_biome"), /* biome instance */ new BiomeExample());
        
        /*
         * Use this method to replace vanilla/custom biomes.
         * 
         * Use with caution!
         * Sometimes you should put @EventListener's priority to LOWEST, so all biomes could be initialized. 
         */
        event.replace(/* modID instance. */ modID, /* identifier of original biome */ Identifier.of("minecraft:swampland"), /* new biome instance */ new BiomeExample());
    }

}
```

## Setup

For mod/gradle setup instructions, please refer to [BIN-fabric-example-mod](https://github.com/calmilamsy/BIN-fabric-example-mod).

## License

The project is under [MIT Licence](https://raw.githubusercontent.com/ChessChicken-KZ/SimpleBiomeSystem/local/LICENSE). Feel free to look at it.
