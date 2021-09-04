package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;

public class SeasonalForest extends ExtendedBiome {
    public SeasonalForest() {
        super(BiomeTemperature.WARM, +15D);
        this.setGrassColour(10215459);
        this.setName("Seasonal Forest");
    }
}
