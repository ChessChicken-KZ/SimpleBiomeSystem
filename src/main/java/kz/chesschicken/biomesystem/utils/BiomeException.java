package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.SimpleBiomeSystemMod;
import kz.chesschicken.biomesystem.biomes.ExtendedBiome;

public class BiomeException extends RuntimeException
{
    public BiomeException(ExtendedBiome n)
    {
        super("The biome with id " + n.id + " is already registered (" + SimpleBiomeSystemMod.biomeList[n.id].biomeName + "), but biome (" + n.biomeName + ") tried to register with identical id.");
    }
}
