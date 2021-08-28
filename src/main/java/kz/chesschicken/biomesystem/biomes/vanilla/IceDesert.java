package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.mixin.AccessorBiome;

public class IceDesert extends ExtendedBiome {
    public IceDesert() {
        super();
        this.setGrassColour(16772499);
        this.setName("Ice Desert");
        this.setSnowy();
        ((AccessorBiome)this).invokerSetRainless();
        this.setFoliageColour(12899129);

        this.setTemperature(0.0F);
        this.setHumidity(0.0F);
    }
}
