package kz.chesschicken.biomesystem.common.biomes.vanilla;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;

public class Plains extends ExtendedBiome {
    public Plains() {
        super();
        this.setGrassColour(16767248);
        this.setName("Plains");

        this.setTemperature(0.8F);
        this.setHumidity(0.4F);
    }
}
