package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.event.ExtendedBiomeRegisterEvent;
import kz.chesschicken.biomesystem.utils.BiomeFinder;
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
        rainfall *= temperature;

        cir.setReturnValue(BiomeFinder.getBiome(temperature, rainfall));
        cir.cancel();
    }

    @Inject(method = "createBiomeArray", at = @At("TAIL"))
    private static void injectCleanUp(CallbackInfo ci)
    {
       BiomeFinder.cleanUp();
    }

    @Inject(method = "createBiomeArray", at = @At("HEAD"))
    private static void injectPostEvent(CallbackInfo ci)
    {
        StationAPI.EVENT_BUS.post(new ExtendedBiomeRegisterEvent());
    }
}
