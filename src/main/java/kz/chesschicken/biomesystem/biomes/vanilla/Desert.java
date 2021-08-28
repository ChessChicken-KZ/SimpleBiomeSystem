package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.mixin.AccessorBiome;

public class Desert extends ExtendedBiome {
    public Desert() {
        super();
        this.setGrassColour(16421912);
        this.setName("Desert");
        ((AccessorBiome)this).invokerSetRainless();

        this.setTemperature(2.0F);
        this.setHumidity(0.0F);
    }
}
