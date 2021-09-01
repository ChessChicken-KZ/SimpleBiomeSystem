package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.common.SystemMod;
import kz.chesschicken.biomesystem.common.event.ExtendedBiomeRegisterEvent;
import kz.chesschicken.biomesystem.common.utils.BiomeArrayBuilder;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.StationAPI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Biome.class)
public class MixinBiome {

    @Inject(method = "getClimateBiome", at = @At("HEAD"), cancellable = true)
    private static void injectNewClimateBiomes(float temperature, float rainfall, CallbackInfoReturnable<Biome> cir)
    {
        cir.setReturnValue(BiomeArrayBuilder.INSTANCE.getBiome(temperature));
        cir.cancel();
    }

    @Inject(method = "getBiome", at = @At("HEAD"), cancellable = true)
    private static void injectNewClimateBiomes1(double temperature, double d1, CallbackInfoReturnable<Biome> cir)
    {
        cir.setReturnValue(BiomeArrayBuilder.INSTANCE.getBiome((float) temperature));
        cir.cancel();
    }

    @Inject(method = "createBiomeArray", at = @At("TAIL"))
    private static void injectCleanUp(CallbackInfo ci)
    {
        BiomeArrayBuilder.INSTANCE.cleanUp();
    }

    @Inject(method = "createBiomeArray", at = @At("HEAD"))
    private static void injectPostEvent(CallbackInfo ci)
    {
        SystemMod.LOGGER.info("Accepting biomes for list.");
        StationAPI.EVENT_BUS.post(new ExtendedBiomeRegisterEvent());
        SystemMod.LOGGER.info("Total biomes count: " + ExtendedBiomeRegisterEvent.REGISTRY_LIST.size());
    }
}
