package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.SimpleBiomeSystemMod;
import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.utils.math.FloatFinder;

import java.util.Map;
import java.util.TreeMap;

public class BiomeFinder {
    private static Map<Float, ExtendedBiome> shit;
    private static Float[] temperatureList;

    public static ExtendedBiome getBiome(float temp, float humid)
    {
        if(shit == null)
        {
            System.out.println("SIZE: " + SimpleBiomeSystemMod.biomeList[0].biomeName);
            shit = new TreeMap<>();
            for(int i = 0; i < SimpleBiomeSystemMod.biomeList.length; i++) {
                if(SimpleBiomeSystemMod.biomeList[i] != null)
                    shit.put(SimpleBiomeSystemMod.biomeList[i].temperature, SimpleBiomeSystemMod.biomeList[i]);
            }

            temperatureList = shit.keySet().toArray(new Float[0]);
        }

        ExtendedBiome getting = shit.get(FloatFinder.fastNearestFloat(temperatureList, temp));
        System.out.println("Biome: " + getting.biomeName);
        return getting;
    }

    public static void cleanUp()
    {
        shit.clear();
        temperatureList = null;
    }
}
