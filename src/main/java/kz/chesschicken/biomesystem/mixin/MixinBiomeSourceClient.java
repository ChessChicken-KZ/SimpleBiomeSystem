package kz.chesschicken.biomesystem.mixin;

import net.minecraft.level.gen.BiomeSource;
import net.minecraft.util.noise.SimplexOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BiomeSource.class)
public class MixinBiomeSourceClient {
    @Shadow public double[] temperatureNoises;

    @Shadow private SimplexOctaveNoise temperatureNoise;

    @Inject(method = "getTemperature", at = @At("HEAD"), cancellable = true)
    private void injectNewTemperatureMeasure(int x, int z, CallbackInfoReturnable<Double> cir)
    {
        this.temperatureNoises = this.temperatureNoise.sample(this.temperatureNoises, x, z, 1, 1, 0.02500000037252903D, 0.02500000037252903D, 0.5D);

        for(int i = 0; i < this.temperatureNoises.length; i++)
        {
            this.temperatureNoises[i] = Math.floor(this.temperatureNoises[i] * 1000) / 100;
        }

        cir.setReturnValue(this.temperatureNoises[0]);
        cir.cancel();
    }
}
