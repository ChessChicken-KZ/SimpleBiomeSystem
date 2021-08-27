package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.utils.independentnoise.IndNoiseGeneratorOctaves;
import net.minecraft.level.Level;
import net.minecraft.level.source.OverworldLevelSource;
import net.minecraft.util.noise.PerlinOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(OverworldLevelSource.class)
public class MixinOverworldLevelSource {
    @Shadow private Random rand;

    @Shadow private PerlinOctaveNoise upperInterpolationNoise;

    @Shadow private PerlinOctaveNoise lowerInterpolationNoise;

    @Shadow private PerlinOctaveNoise interpolationNoise;

    @Shadow private PerlinOctaveNoise beachNoise;

    @Shadow public PerlinOctaveNoise biomeNoise;

    @Shadow private PerlinOctaveNoise surfaceDepthNoise;

    @Shadow public PerlinOctaveNoise depthNoise;

    @Shadow public PerlinOctaveNoise treeNoise;

    @Inject(method = "<init>", at = @At("TAIL"), cancellable = true)
    private void setupNewNoise(Level level, long seed, CallbackInfo ci)
    {
        this.upperInterpolationNoise = new IndNoiseGeneratorOctaves(this.rand, 16);
        this.lowerInterpolationNoise = new IndNoiseGeneratorOctaves(this.rand, 16);
        this.interpolationNoise = new IndNoiseGeneratorOctaves(this.rand, 8);
        this.beachNoise = new IndNoiseGeneratorOctaves(this.rand, 4);
        this.surfaceDepthNoise = new IndNoiseGeneratorOctaves(this.rand, 4);
        this.biomeNoise = new IndNoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new IndNoiseGeneratorOctaves(this.rand, 16);
        this.treeNoise = new IndNoiseGeneratorOctaves(this.rand, 8);
    }
}
