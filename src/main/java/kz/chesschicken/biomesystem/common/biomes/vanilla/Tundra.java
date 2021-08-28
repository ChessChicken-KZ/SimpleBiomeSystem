package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;

public class Tundra extends ExtendedBiome {
    public Tundra() {
        super();
        this.setGrassColour(5762041);
        this.setName("Tundra");
        this.setSnowy();
        this.setFoliageColour(12899129);

        this.setTemperature(0.3F);
        this.setHumidity(0.8F);
    }
}
