package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;

public class SeasonalForest extends ExtendedBiome {
    public SeasonalForest(int i) {
        super(i);
        this.setGrassColour(10215459);
        this.setName("Seasonal Forest");

        this.setTemperature(0.7F);
        this.setHumidity(0.8F);
    }
}
