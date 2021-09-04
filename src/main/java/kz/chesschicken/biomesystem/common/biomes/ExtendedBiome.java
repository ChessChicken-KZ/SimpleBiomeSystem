package kz.chesschicken.biomesystem.common.biomes;

import net.minecraft.block.BlockBase;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.gen.Cave;
import net.minecraft.level.gen.OverworldCave;

import java.util.Map;
import java.util.TreeMap;

public class ExtendedBiome extends Biome {
    public static enum BiomeType
    {
        EXTREME_COLD(Double.NEGATIVE_INFINITY, -40D),
        COLD(-40D, 0D),
        WARM(0D, 40D),
        EXTREME_WARM(40D, Double.POSITIVE_INFINITY);

        public final double min;
        public final double max;
        public final Map<Double, ExtendedBiome> biomeList;
        BiomeType(double min, double max)
        {
            this.min = min;
            this.max = max;
            this.biomeList = new TreeMap<>();
        }

        public static BiomeType getByTemp(double f)
        {
            if(f <= EXTREME_COLD.max)
                return EXTREME_COLD;
            if(f <= COLD.max)
                return COLD;
            if(f <= WARM.max)
                return WARM;

            return EXTREME_WARM;
        }
    }

    protected final BiomeType biomeType;
    public double temperature;
    public int undergroundID = BlockBase.STONE.id;

    public byte stoneBlockMeta = 0;
    public byte topTileMeta = 0;
    public byte underTileMeta = 0;

    protected Cave caveGen = new OverworldCave();

    public ExtendedBiome(BiomeType type, double temperature) {
        super();
        this.biomeType = type;
        this.biomeType.biomeList.put(temperature, this);
    }

    public BiomeType getTemperatureRange() {
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
