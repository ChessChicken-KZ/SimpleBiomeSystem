package kz.chesschicken.biomesystem.common.event;

import kz.chesschicken.biomesystem.common.SystemMod;
import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import net.mine_diver.unsafeevents.Event;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;

import java.util.Map;
import java.util.TreeMap;

public class ExtendedBiomeRegisterEvent extends Event {
    public static Map<Identifier, ExtendedBiome> REGISTRY_LIST = new TreeMap<>();

    /**
     * Allows you to register biome to {@link ExtendedBiomeRegisterEvent#REGISTRY_LIST} map.
     * @param identifier Identifier of biome.
     * @param extendedBiome Biome instance.
     */
    public void register(Identifier identifier, ExtendedBiome extendedBiome)
    {
        REGISTRY_LIST.put(identifier, extendedBiome);
    }

    /**
     * Allows you to replace registered biome in {@link ExtendedBiomeRegisterEvent#REGISTRY_LIST}.
     * @param modID ModID of mod that replaces biome.
     * @param identifier Biome to replace.
     * @param extendedBiome New biome instance.
     */
    public void replace(ModID modID, Identifier identifier, ExtendedBiome extendedBiome)
    {
        if(REGISTRY_LIST.containsKey(identifier)) {
            REGISTRY_LIST.replace(identifier, extendedBiome);
            return;
        }
        SystemMod.LOGGER.error("Could not find any " + identifier.toString() + " to replace!");
        REGISTRY_LIST.put(Identifier.of(modID, identifier.id), extendedBiome);
    }

    @Override
    protected int getEventID() {
        return ID;
    }

    public static final int ID = NEXT_ID.incrementAndGet();
}
