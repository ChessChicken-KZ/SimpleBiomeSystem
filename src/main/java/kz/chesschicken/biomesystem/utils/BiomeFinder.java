package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.utils.math.FloatFinder;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Map;
import java.util.TreeMap;

public class BiomeFinder {
    public Map<Identifier, ExtendedBiome> REGISTRY_LIST = new TreeMap<>();

    private Map<Float, ExtendedBiome> temporaryList;
    private Float[] temperatureList;

    public ExtendedBiome getBiome(float temp, float humid)
    {
        if(temporaryList == null)
        {
            temporaryList = new TreeMap<>();

            for(Identifier id : REGISTRY_LIST.keySet()) {
                temporaryList.put(REGISTRY_LIST.get(id).temperature, REGISTRY_LIST.get(id));
            }


            temperatureList = temporaryList.keySet().toArray(new Float[0]);
        }

        return temporaryList.get(FloatFinder.fastNearestFloat(temperatureList, temp));
    }

    public void cleanUp()
    {
        temporaryList.clear();
        temperatureList = null;
    }

    public static BiomeFinder INSTANCE = new BiomeFinder();
}
