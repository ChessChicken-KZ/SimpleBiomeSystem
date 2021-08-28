package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.utils.math.FloatFinder;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Map;
import java.util.TreeMap;

public class BiomeFinder {
    public static Map<Identifier, ExtendedBiome> list = new TreeMap<>();

    private static Map<Float, ExtendedBiome> shit;
    private static Float[] temperatureList;

    public static ExtendedBiome getBiome(float temp, float humid)
    {
        if(shit == null)
        {
            shit = new TreeMap<>();

            for(Identifier id : list.keySet()) {
                shit.put(list.get(id).temperature, list.get(id));
            }


            temperatureList = shit.keySet().toArray(new Float[0]);
        }

        return shit.get(FloatFinder.fastNearestFloat(temperatureList, temp));
    }

    public static void cleanUp()
    {
        shit.clear();
        temperatureList = null;
    }
}
