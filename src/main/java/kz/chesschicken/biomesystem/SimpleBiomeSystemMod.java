package kz.chesschicken.biomesystem;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.biomes.vanilla.*;
import kz.chesschicken.biomesystem.event.ExtendedBiomeRegisterEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.core.Logger;

import java.util.Map;
import java.util.TreeMap;

public class SimpleBiomeSystemMod {
    public static Map<Identifier, ExtendedBiome> REGISTRY_LIST = new TreeMap<>();

    @Entrypoint.Logger
    public static Logger LOGGER = Null.get();

    @Entrypoint.ModID
    public static ModID MODID = Null.get();

    @EventListener
    public void registerVanillaBiomes(ExtendedBiomeRegisterEvent event)
    {
        event.register(Identifier.of(MODID, "rainforest"), new Rainforest());
        event.register(Identifier.of(MODID, "swampland"), new Swampland());
        event.register(Identifier.of(MODID, "seasonal_forest"), new SeasonalForest());
        event.register(Identifier.of(MODID, "forest"), new Forest());
        event.register(Identifier.of(MODID, "savanna"), new Savanna());
        event.register(Identifier.of(MODID, "shrubland"), new Shrubland());
        event.register(Identifier.of(MODID, "taiga"), new Taiga());
        event.register(Identifier.of(MODID, "desert"), new Desert());
        event.register(Identifier.of(MODID, "plains"), new Plains());
        event.register(Identifier.of(MODID, "ice_desert"), new IceDesert());
        event.register(Identifier.of(MODID, "tundra"), new Tundra());

    }
}
