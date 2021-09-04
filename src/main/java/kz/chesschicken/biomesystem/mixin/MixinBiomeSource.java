package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.common.utils.InstanceHelper;
import kz.chesschicken.biomesystem.common.utils.worldnoise.ILevelNoise;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.gen.BiomeSource;
import net.minecraft.util.noise.SimplexOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(BiomeSource.class)
public class MixinBiomeSource {

    @Shadow private SimplexOctaveNoise temperatureNoise;

    @Shadow private SimplexOctaveNoise rainfallNoise;

    @Shadow private SimplexOctaveNoise detailNoise;

    @Shadow public double[] temperatureNoises;

    @Shadow public double[] rainfallNoises;

    @Shadow public double[] detailNoises;

    @Inject(method = "<init>(Lnet/minecraft/level/Level;)V", at = @At("TAIL"))
    private void injectReplaceSimplexNoises(Level level, CallbackInfo ci)
    {
        this.temperatureNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().simplex, new Random(level.getSeed() * 9871L), 4);
        this.rainfallNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().simplex, new Random(level.getSeed() * 39811L), 4);
        this.detailNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().simplex, new Random(level.getSeed() * 543321L), 2);
    }

    @Inject(method = "getBiomes([Lnet/minecraft/level/biome/Biome;IIII)[Lnet/minecraft/level/biome/Biome;",
            at = @At("HEAD"), cancellable = true)
    private void injectNewBiomeTable(Biome[] biomes, int x, int z, int xSize, int zSize, CallbackInfoReturnable<Biome[]> cir)
    {
        if (biomes == null || biomes.length < xSize * zSize)
            biomes = new Biome[xSize * zSize];


        this.temperatureNoises = this.temperatureNoise.sample(this.temperatureNoises, x, z, xSize, xSize, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.rainfallNoises = this.rainfallNoise.sample(this.rainfallNoises, x, z, xSize, xSize, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
        this.detailNoises = this.detailNoise.sample(this.detailNoises, x, z, xSize, xSize, 0.25D, 0.25D, 0.5882352941176471D);
        int q = 0;

        for(int ix = 0; ix < xSize; ++ix) {
            for(int iz = 0; iz < zSize; ++iz) {
                double detail = this.detailNoises[q] * 1.1D + 0.5D;
                double temp = (this.temperatureNoises[q] * 0.15D + 0.7D) * (1.0D - 0.01D) + detail * 0.01D;
                double rainf = (this.rainfallNoises[q] * 0.15D + 0.5D) * (1.0D - 0.002D) + detail * 0.002D;
                temp = 1.0D - (1.0D - temp) * (1.0D - temp);

                if(x + ((int) temp) > 0 && temp < 0.5D)
                {
                    temp += 0.4D;
                }

                if(x - ((int) temp) <= 0 && temp > 0.7D)
                {
                    temp -= 0.3D;
                }

                temp = Math.floor(temp * 1000) / 100;

                this.temperatureNoises[q] = temp;
                this.rainfallNoises[q] = rainf;
                biomes[q++] = Biome.getBiome(temp, rainf);
            }
        }

        cir.setReturnValue(biomes);
        cir.cancel();
    }

    @Inject(method = "getTemperatures", at = @At("TAIL"), cancellable = true)
    private void injectNewTemperatureData(double[] temperatures, int x, int z, int xSize, int zSize, CallbackInfoReturnable<double[]> cir)
    {
        if (temperatures == null || temperatures.length < xSize * zSize)
            temperatures = new double[xSize * zSize];


        temperatures = this.temperatureNoise.sample(temperatures, x, z, xSize, zSize, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.detailNoises = this.detailNoise.sample(this.detailNoises, x, z, xSize, zSize, 0.25D, 0.25D, 0.5882352941176471D);
        int q = 0;

        for(int ix = 0; ix < xSize; ++ix) {
            for(int iz = 0; iz < zSize; ++iz) {
                double detail = this.detailNoises[q] * 1.1D + 0.5D;
                double temp = (temperatures[q] * 0.15D + 0.7D) * (1.0D - 0.01D) + detail * 0.01D;
                temp = 1.0D - (1.0D - temp) * (1.0D - temp);

                if(x + ((int) temp) > 0 && temp < 0.5D)
                {
                    temp += 0.4D;
                }

                if(x - ((int) temp) <= 0 && temp > 0.7D)
                {
                    temp -= 0.3D;
                }

                temperatures[q++] = Math.floor(temp * 1000) / 100;
            }
        }

        cir.setReturnValue(temperatures);
        cir.cancel();
    }

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
