package kz.chesschicken.biomesystem.common.utils;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.math.ArraySearch;

import java.util.Map;
import java.util.TreeMap;

public enum BiomeTemperature {
    EXTREME_COLD(Double.NEGATIVE_INFINITY, -40D),
    COLD(-40D, 0D),
    WARM(0D, 40D),
    EXTREME_WARM(40D, Double.POSITIVE_INFINITY);

    public final double min;
    public final double max;
    public final Map<Double, ExtendedBiome> biomeList = new TreeMap<>();

    BiomeTemperature(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public static BiomeTemperature getByTemp(double f) {
        if (f <= EXTREME_COLD.max)
            return EXTREME_COLD;
        if (f <= COLD.max)
            return COLD;
        if (f <= WARM.max)
            return WARM;

        return EXTREME_WARM;
    }

    /**
     * A special method, returning Biome from an float value.
     * @param temp Temperature (double value).
     * @return Biome.
     */
    public static ExtendedBiome getExtendedBiome(double temp)
    {
        return getByTemp(temp).biomeList.get(ArraySearch.fastNearestDouble(getByTemp(temp).biomeList.keySet().toArray(new Double[0]), temp));
    }
}
