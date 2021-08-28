package kz.chesschicken.biomesystem;

import kz.chesschicken.biomesystem.biomes.vanilla.*;
import kz.chesschicken.biomesystem.event.ExtendedBiomeRegisterEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class SimpleBiomeSystemMod {

    @Entrypoint.ModID
    public static ModID modID = Null.get();

    @EventListener
    public void registerVanillaBiomes(ExtendedBiomeRegisterEvent event)
    {
        System.out.println("HELLO WORLD!");
        event.register(Identifier.of(modID, "rainforest"), new Rainforest());
        event.register(Identifier.of(modID, "swampland"), new Swampland());
        event.register(Identifier.of(modID, "seasonal_forest"), new SeasonalForest());
        event.register(Identifier.of(modID, "forest"), new Forest());
        event.register(Identifier.of(modID, "savanna"), new Savanna());

        event.register(Identifier.of(modID, "shrubland"), new Shrubland());
        event.register(Identifier.of(modID, "taiga"), new Taiga());
        event.register(Identifier.of(modID, "desert"), new Desert());
        event.register(Identifier.of(modID, "plains"), new Plains());
        event.register(Identifier.of(modID, "ice_desert"), new IceDesert());
        event.register(Identifier.of(modID, "tundra"), new Tundra());

    }
}
