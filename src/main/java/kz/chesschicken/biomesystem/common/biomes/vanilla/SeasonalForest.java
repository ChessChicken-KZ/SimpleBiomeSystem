package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;

public class SeasonalForest extends ExtendedBiome {
    public SeasonalForest() {
        super(BiomeType.WARM, +15D);
        this.setGrassColour(10215459);
        this.setName("Seasonal Forest");
    }
}
