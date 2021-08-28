package kz.chesschicken.biomesystem.biomes;

import net.minecraft.block.BlockBase;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.gen.Cave;
import net.minecraft.level.gen.OverworldCave;

public class ExtendedBiome extends Biome {
    public float temperature;
    public float humidity;
    public int undergroundID = BlockBase.STONE.id;
    public int stoneBlockMeta = 0;
    protected Cave caveGen = new OverworldCave();

    public ExtendedBiome() {
        super();
    }


    public ExtendedBiome setTemperature(float f) {
        this.temperature = f;
        return this;
    }

    public ExtendedBiome setHumidity(float f) {
        this.humidity = f;
        return this;
    }

    public ExtendedBiome setUndergroundBlockMeta(int i) {
        this.stoneBlockMeta = i;
        return this;
    }

    public ExtendedBiome setUndergroundBlockID(int i) {
        this.undergroundID = i;
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
