package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.biomesystem.mixin.AccessorBiome;
import net.minecraft.block.BlockBase;

public class Desert extends ExtendedBiome {
    public Desert() {
        super(BiomeTemperature.EXTREME_WARM, 50D);
        this.setGrassColour(16421912);
        this.setName("Desert");
        ((AccessorBiome)this).invokerSetRainless();
        this.setTreeDensity(-20);
        this.topTileId = (byte) BlockBase.SAND.id;
        this.underTileId = (byte) BlockBase.SANDSTONE.id;
    }
}
