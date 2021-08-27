package kz.chesschicken.biomesystem.biomes.vanilla;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;

public class Swampland extends ExtendedBiome {
    public Swampland(int i) {
        super(i);
        this.setGrassColour(522674);
        this.setName("Swampland");
        this.setFoliageColour(9154376);

        this.setTemperature(0.8F);
        this.setHumidity(0.9F);
    }
}
