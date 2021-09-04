package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;

public class Swampland extends ExtendedBiome {
    public Swampland() {
        super(BiomeTemperature.WARM, 25D);
        this.setGrassColour(522674);
        this.setName("Swampland");
        this.setFoliageColour(9154376);
        this.setTreeDensity(1);
    }
}
