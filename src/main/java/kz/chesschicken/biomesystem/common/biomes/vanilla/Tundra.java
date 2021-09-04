package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;

public class Tundra extends ExtendedBiome {
    public Tundra() {
        super(BiomeType.COLD, -20D);
        this.setGrassColour(5762041);
        this.setName("Tundra");
        this.setSnowy();
        this.setFoliageColour(12899129);
    }
}
