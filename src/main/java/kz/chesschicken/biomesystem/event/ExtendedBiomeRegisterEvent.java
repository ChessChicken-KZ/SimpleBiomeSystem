package kz.chesschicken.biomesystem.event;

import kz.chesschicken.biomesystem.SimpleBiomeSystemMod;
import kz.chesschicken.biomesystem.biomes.ExtendedBiome;
import net.mine_diver.unsafeevents.Event;
import net.modificationstation.stationapi.api.registry.Identifier;

public class ExtendedBiomeRegisterEvent extends Event {

    public void register(Identifier identifier, ExtendedBiome extendedBiome)
    {
        SimpleBiomeSystemMod.REGISTRY_LIST.put(identifier, extendedBiome);
    }

    @Override
    protected int getEventID() {
        return ID;
    }

    public static final int ID = NEXT_ID.incrementAndGet();
}
