package kz.chesschicken.biomesystem.event;

import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import net.mine_diver.unsafeevents.Event;
import net.modificationstation.stationapi.api.registry.Identifier;

import java.util.Map;
import java.util.TreeMap;

public class ExtendedBiomeRegisterEvent extends Event {
    public static Map<Identifier, ExtendedBiome> REGISTRY_LIST = new TreeMap<>();

    public void register(Identifier identifier, ExtendedBiome extendedBiome)
    {
        REGISTRY_LIST.put(identifier, extendedBiome);
    }

    @Override
    protected int getEventID() {
        return ID;
    }

    public static final int ID = NEXT_ID.incrementAndGet();
}
