package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;

public class Plains extends ExtendedBiome {
    public Plains() {
        super(BiomeTemperature.WARM, +30D);
        this.setGrassColour(16767248);
        this.setName("Plains");
    }
}
