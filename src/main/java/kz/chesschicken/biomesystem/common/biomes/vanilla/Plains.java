package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;

public class Plains extends ExtendedBiome {
    public Plains() {
        super(BiomeType.WARM, +30D);
        this.setGrassColour(16767248);
        this.setName("Plains");
    }
}
