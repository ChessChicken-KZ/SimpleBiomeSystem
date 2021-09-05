import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityEntry;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.entity.monster.ZombiePigman;
import net.minecraft.entity.swimming.Squid;

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
