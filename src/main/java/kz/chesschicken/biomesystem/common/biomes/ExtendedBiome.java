package kz.chesschicken.biomesystem.common.biomes;

import kz.chesschicken.biomesystem.common.utils.BiomeTemperature;
import net.minecraft.block.BlockBase;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.gen.Cave;
import net.minecraft.level.gen.OverworldCave;

public class ExtendedBiome extends Biome {

    protected final BiomeTemperature biomeType;
    public double temperature;
    public int undergroundID = BlockBase.STONE.id;

    public byte stoneBlockMeta = 0;
    public byte topTileMeta = 0;
    public byte underTileMeta = 0;

    protected Cave caveGen = new OverworldCave();

    public ExtendedBiome(BiomeTemperature type, double temperature) {
        super();
        this.biomeType = type;
        this.biomeType.biomeList.put(temperature, this);
    }

    /**
     * Get the {@link BiomeTemperature} enum of the biome.
     * @return Temperature enum from {@link BiomeTemperature}.
     */
    public BiomeTemperature getTemperatureRange() {
        return this.biomeType;
    }

    /**
     * Get the temperature of the biome.
     * @return Biome temperature value.
     */
    public double getTemperature() {
        return this.temperature;
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
