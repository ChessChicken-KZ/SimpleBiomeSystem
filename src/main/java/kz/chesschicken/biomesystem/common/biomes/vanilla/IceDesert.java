package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import kz.chesschicken.biomesystem.mixin.AccessorBiome;

public class IceDesert extends ExtendedBiome {
    public IceDesert() {
        super(BiomeTemperature.EXTREME_COLD, -40D);
        this.setGrassColour(16772499);
        this.setName("Ice Desert");
        this.setSnowy();
        ((AccessorBiome)this).invokerSetRainless();
        this.setFoliageColour(12899129);
    }
}
