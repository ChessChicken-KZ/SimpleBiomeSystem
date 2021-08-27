package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.utils.independentnoise.NoiseGeneratorOctaves2;
import net.minecraft.level.Level;
import net.minecraft.level.gen.BiomeSource;
import net.minecraft.util.noise.SimplexOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BiomeSource.class)
public class MixinBiomeSource {

    @Shadow private SimplexOctaveNoise temperatureNoise;

    @Shadow private SimplexOctaveNoise rainfallNoise;

    @Shadow private SimplexOctaveNoise detailNoise;

    @Inject(method = "<init>(Lnet/minecraft/level/Level;)V", at = @At("TAIL"))
    private void callNewSimplex(Level level, CallbackInfo ci)
    {
        this.temperatureNoise = new NoiseGeneratorOctaves2(new Random(level.getSeed() * 9871L), 4);
        this.rainfallNoise = new NoiseGeneratorOctaves2(new Random(level.getSeed() * 39811L), 4);
        this.detailNoise = new NoiseGeneratorOctaves2(new Random(level.getSeed() * 543321L), 2);
    }
}
