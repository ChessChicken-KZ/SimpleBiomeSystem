package kz.chesschicken.biomesystem.common.biomes;

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

    /**
     * Set the temperature of the biome.
     * @param f Temperature (float value).
     * @return Biome instance.
     */
    public ExtendedBiome setTemperature(float f) {
        this.temperature = f;
        return this;
    }

    /**
     * Get the temperature of the biome.
     * @return Biome temperature value.
     */
    public float getTemperature() {
        return this.temperature;
    }

    /**
     * Set the humidity of the biome.
     * @param f Humidity (float value).
     * @return Biome instance.
     */
    public ExtendedBiome setHumidity(float f) {
        this.humidity = f;
        return this;
    }

    /**
     * Get the humidity of the biome.
     * @return Biome humidity value.
     */
    public float getHumidity() {
        return this.humidity;
    }

    /**
     * Set the underground block meta of the biome.
     * Default value: 0.
     * @param i Metadata
     * @return Biome instance.
     */
    public ExtendedBiome setUndergroundBlockMeta(int i) {
        this.stoneBlockMeta = i;
        return this;
    }

    /**
     * Get the underground block meta of the biome.
     * @return Underground block meta value.
     */
    public int getUndergroundBlockMeta() {
        return this.stoneBlockMeta;
    }

    /**
     * Set the underground block of the biome.
     * Default value: 1.
     * @param i ID
     * @return Biome instance.
     */
    public ExtendedBiome setUndergroundBlockID(int i) {
        this.undergroundID = i;
        return this;
    }

    /**
     * Get the underground block of the biome.
     * @return Underground block ID value.
     */
    public int getUndergroundBlockID() {
        return this.undergroundID;
    }

    /**
     * W.I.P.
     * Set the cave generator of the biome.
     * @param c Cave Generator instance.
     * @return Biome instance.
     */
    public ExtendedBiome setCaveGenerator(Cave c) {
        this.caveGen = c;
        return this;
    }

    /**
     * W.I.P.
     * Get the cave generator of the biome.
     * @return Cave generator instance.
     */
    public Cave getCaveGenerator() {
        return this.caveGen;
    }


}
