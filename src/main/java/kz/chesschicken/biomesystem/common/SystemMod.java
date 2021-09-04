package kz.chesschicken.biomesystem.common;

import kz.chesschicken.biomesystem.common.biomes.vanilla.*;
import kz.chesschicken.biomesystem.common.event.ExtendedBiomeRegisterEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.core.Logger;

public class SystemMod {

    @Entrypoint.Logger
    public static Logger LOGGER = Null.get();


    @SuppressWarnings("unused")
    @EventListener(priority = ListenerPriority.HIGHEST)
    public void registerVanillaBiomes(ExtendedBiomeRegisterEvent event)
    {
        event.register(Identifier.of("minecraft:rainforest"), new Rainforest());
        event.register(Identifier.of("minecraft:swampland"), new Swampland());
        event.register(Identifier.of("minecraft:seasonal_forest"), new SeasonalForest());
        event.register(Identifier.of("minecraft:forest"), new Forest());
        event.register(Identifier.of("minecraft:savanna"), new Savanna());
        event.register(Identifier.of("minecraft:shrubland"), new Shrubland());
        event.register(Identifier.of("minecraft:taiga"), new Taiga());
        event.register(Identifier.of("minecraft:desert"), new Desert());
        event.register(Identifier.of("minecraft:plains"), new Plains());
        event.register(Identifier.of("minecraft:ice_desert"), new IceDesert());
        event.register(Identifier.of("minecraft:tundra"), new Tundra());
    }
}
