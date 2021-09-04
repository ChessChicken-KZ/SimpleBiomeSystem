package kz.chesschicken.biomesystem.common.utils;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.math.ArraySearch;

public class BiomeArrayBuilder {


    /**
     * A special method, returning Biome from an float value.
     * @param temp Temperature (double value).
     * @return Biome.
     */
    public ExtendedBiome getBiome(double temp)
    {
        return ExtendedBiome.BiomeType.getByTemp(temp).biomeList.get(ArraySearch.fastNearestDouble(ExtendedBiome.BiomeType.getByTemp(temp).biomeList.keySet().toArray(new Double[0]), temp));
    }

    public static BiomeArrayBuilder INSTANCE = new BiomeArrayBuilder();

    public void cleanUp() {
    }
}
