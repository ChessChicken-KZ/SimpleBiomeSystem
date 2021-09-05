import kz.chesschicken.biomesystem.common.event.ExtendedBiomeRegisterEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class BiomeListenerExample {

    /*
     * ModID instance.
     */
    @Entrypoint.ModID
    public static ModID modID = Null.get();

    /*
     * Event method.
     */
    @EventListener
    public void registerBiomes(ExtendedBiomeRegisterEvent event)
    {
        /* Use this method for registering biomes. */
        event.register( /* identifier of biome */ Identifier.of(modID, "my_biome"), /* biome instance */ new BiomeExample());

        /*
         * Use this method to replace vanilla/custom biomes.
         *
         * Use with caution!
         * Sometimes you should put @EventListener's priority to LOWEST, so all biomes could be initialized.
         */
        event.replace(/* modID instance. */ modID, /* identifier of original biome */ Identifier.of("minecraft:swampland"), /* biome instance */ new BiomeExample());
    }

}
