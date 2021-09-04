package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;

public class Shrubland extends ExtendedBiome {
    public Shrubland() {
        super(BiomeTemperature.WARM, +30D);
        this.setGrassColour(10595616);
        this.setName("Shrubland");
    }
}
