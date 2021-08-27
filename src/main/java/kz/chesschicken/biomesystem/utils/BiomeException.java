package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.ModInit;

public class BiomeException extends RuntimeException
{
    public BiomeException(ExtendedBiome n)
    {
        super("The biome with id " + n.id + " is already registered (" + ModInit.biomeList[n.id].biomeName + "), but biome (" + n.biomeName + ") tried to register with identical id.");
    }
}
