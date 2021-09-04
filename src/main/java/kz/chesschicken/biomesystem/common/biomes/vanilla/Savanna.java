package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;

public class Savanna extends ExtendedBiome {
    public Savanna() {
        super(BiomeTemperature.WARM, 40D);
        this.setGrassColour(14278691);
        this.setName("Savanna");
        this.setTreeDensity(3);
    }
}
