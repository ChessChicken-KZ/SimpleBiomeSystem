package kz.chesschicken.biomesystem;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.biomes.vanilla.*;
import kz.chesschicken.biomesystem.utils.BiomeException;
import net.fabricmc.api.ModInitializer;

public class ModInit implements ModInitializer {
    public static ExtendedBiome[] biomeList = new ExtendedBiome[4096];

    public static void addBiome(ExtendedBiome extendedBiome) {
        if(biomeList[extendedBiome.id] == null) {
            biomeList[extendedBiome.id] = extendedBiome;
        } else throw new BiomeException(extendedBiome);
    }

    public static void overrideBiome(ExtendedBiome extendedBiome) {
        biomeList[extendedBiome.id] = extendedBiome;
    }

    @Override
    public void onInitialize() {
        addBiome(new Rainforest(0));
        addBiome(new Swampland(1));
        addBiome(new SeasonalForest(2));
        addBiome(new Forest(3));
        addBiome(new Savanna(4));
        addBiome(new Shrubland(5));
        addBiome(new Taiga(6));
        addBiome(new Desert(7));
        addBiome(new Plains(8));
        addBiome(new IceDesert(9));
        addBiome(new Tundra(10));
        addBiome(new Hell(11));
        addBiome(new Sky(12));
    }
}
