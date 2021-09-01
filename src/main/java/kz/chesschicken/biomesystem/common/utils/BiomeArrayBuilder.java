package kz.chesschicken.biomesystem.common.utils;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.event.ExtendedBiomeRegisterEvent;
import kz.chesschicken.biomesystem.common.utils.math.FloatFinder;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Map;
import java.util.TreeMap;

public class BiomeArrayBuilder {

    private Map<Float, ExtendedBiome> temporaryList;
    private Float[] temperatureList;

    /**
     * A special method, returning Biome from an float value.
     * @param temp Temperature (float value).
     * @return Biome.
     */
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

    public static BiomeArrayBuilder INSTANCE = new BiomeArrayBuilder();
}
