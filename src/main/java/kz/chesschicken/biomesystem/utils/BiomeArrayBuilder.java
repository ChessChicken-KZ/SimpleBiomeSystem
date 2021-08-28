package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.event.ExtendedBiomeRegisterEvent;
import kz.chesschicken.biomesystem.utils.math.FloatFinder;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Map;
import java.util.TreeMap;

public class BiomeArrayBuilder {

    private Map<Float, ExtendedBiome> temporaryList;
    private Float[] temperatureList;

    public ExtendedBiome getBiome(float temp)
    {
        if(temporaryList == null)
        {
            temporaryList = new TreeMap<>();

            for(Identifier id : ExtendedBiomeRegisterEvent.REGISTRY_LIST.keySet()) {
                temporaryList.put(ExtendedBiomeRegisterEvent.REGISTRY_LIST.get(id).temperature, ExtendedBiomeRegisterEvent.REGISTRY_LIST.get(id));
            }

            temperatureList = temporaryList.keySet().toArray(new Float[0]);
        }

        return temporaryList.get(FloatFinder.fastNearestFloat(temperatureList, temp));
    }

    public void cleanUp()
    {
        //temporaryList.clear();
        //temperatureList = null;
    }

    public static BiomeArrayBuilder INSTANCE = new BiomeArrayBuilder();
}
