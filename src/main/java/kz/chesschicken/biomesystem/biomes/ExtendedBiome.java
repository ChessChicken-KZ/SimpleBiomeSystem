package kz.chesschicken.biomesystem.biomes;

import net.minecraft.level.biome.Biome;
import net.minecraft.level.gen.Cave;
import net.minecraft.level.gen.OverworldCave;

public class ExtendedBiome extends Biome {
    public final int id;
    public float temperature;
    public float humidity;
    public int stoneBlockID = 1;
    protected Cave caveGen = new OverworldCave();

    public ExtendedBiome(int i) {
        super();
        this.id = i;
    }


    public ExtendedBiome setTemperature(float f) {
        this.temperature = f;
        return this;
    }

    public ExtendedBiome setHumidity(float f) {
        this.humidity = f;
        return this;
    }

    public ExtendedBiome setUndergroundBlock(int i) {
        this.stoneBlockID = i;
        return this;
    }

    public ExtendedBiome setCaveGenerator(Cave c) {
        this.caveGen = c;
        return this;
    }

    public Cave getCaveGenerator() {
        return this.caveGen;
    }


}
