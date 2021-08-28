package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.common.biomes.ExtendedBiome;
import kz.chesschicken.biomesystem.common.utils.BiomeArrayBuilder;
import kz.chesschicken.biomesystem.common.utils.InstanceHelper;
import kz.chesschicken.biomesystem.common.utils.worldnoise.ILevelNoise;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.chunk.Chunk;
import net.minecraft.level.source.OverworldLevelSource;
import net.minecraft.util.noise.PerlinOctaveNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(OverworldLevelSource.class)
public abstract class MixinOverworldLevelSource {

    @Unique
    private boolean areAffected(byte b) {
        return b == (byte) BlockBase.STONE.id || b == (byte) BlockBase.DIRT.id || b == (byte) BlockBase.GRASS.id;
    }

    @Unique
    private void fastApplyMeta(Chunk chunk, int h, byte q) {
        chunk.field_967 = true;
        {
            int j1 = h >> 1;
            if((h & 1) == 0)
                chunk.field_957.field_2103[j1] = (byte)(chunk.field_957.field_2103[j1] & 0xf0 | q & 0xf);
            else
                chunk.field_957.field_2103[j1] = (byte)(chunk.field_957.field_2103[j1] & 0xf | (q & 0xf) << 4);
        }
    }


    @Shadow private Random rand;

    @Shadow private PerlinOctaveNoise upperInterpolationNoise;

    @Shadow private PerlinOctaveNoise lowerInterpolationNoise;

    @Shadow private PerlinOctaveNoise interpolationNoise;

    @Shadow private PerlinOctaveNoise beachNoise;

    @Shadow public PerlinOctaveNoise biomeNoise;

    @Shadow private PerlinOctaveNoise surfaceDepthNoise;

    @Shadow public PerlinOctaveNoise depthNoise;

    @Shadow public PerlinOctaveNoise treeNoise;

    @Shadow private double[] noises;

    @Shadow protected abstract double[] calculateNoise(double[] noises, int chunkX, int chunkY, int chunkZ, int noiseResolutionX, int noiseResolutionY, int noiseResolutionZ);

    @Shadow private Level level;

    @Inject(method = "<init>", at = @At("TAIL"), cancellable = true)
    private void injectReplaceOctaves(Level level, long seed, CallbackInfo ci)
    {
        this.upperInterpolationNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 16);
        this.lowerInterpolationNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 16);
        this.interpolationNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 8);
        this.beachNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 4);
        this.surfaceDepthNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 4);
        this.biomeNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 10);
        this.depthNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 16);
        this.treeNoise = InstanceHelper.generateNoiseInstance(((ILevelNoise)level.getProperties()).getNoiseEnum().perlinOctaves, this.rand, 8);
    }

    @Unique
    private void shapeChunk(int chunkX, int chunkZ, byte[] tiles, Biome[] biomes, double[] temperatures, Chunk chunk)
    {
        byte var6 = 4;
        byte var7 = 64;
        int var8 = var6 + 1;
        byte var9 = 17;
        int var10 = var6 + 1;
        this.noises = this.calculateNoise(this.noises, chunkX * var6, 0, chunkZ * var6, var8, var9, var10);

        for(int var11 = 0; var11 < var6; ++var11) {
            for(int var12 = 0; var12 < var6; ++var12) {
                for(int var13 = 0; var13 < 16; ++var13) {
                    double var14 = 0.125D;
                    double var16 = this.noises[((var11) * var10 + var12) * var9 + var13];
                    double var18 = this.noises[((var11) * var10 + var12 + 1) * var9 + var13];
                    double var20 = this.noises[((var11 + 1) * var10 + var12) * var9 + var13];
                    double var22 = this.noises[((var11 + 1) * var10 + var12 + 1) * var9 + var13];
                    double var24 = (this.noises[((var11) * var10 + var12) * var9 + var13 + 1] - var16) * var14;
                    double var26 = (this.noises[((var11) * var10 + var12 + 1) * var9 + var13 + 1] - var18) * var14;
                    double var28 = (this.noises[((var11 + 1) * var10 + var12) * var9 + var13 + 1] - var20) * var14;
                    double var30 = (this.noises[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 1] - var22) * var14;

                    for(int var32 = 0; var32 < 8; ++var32) {
                        double var33 = 0.25D;
                        double var35 = var16;
                        double var37 = var18;
                        double var39 = (var20 - var16) * var33;
                        double var41 = (var22 - var18) * var33;

                        for(int var43 = 0; var43 < 4; ++var43) {
                            int var44 = var43 + var11 * 4 << 11 | var12 * 4 << 7 | var13 * 8 + var32;
                            short var45 = 128;
                            double var46 = 0.25D;
                            double var48 = var35;
                            double var50 = (var37 - var35) * var46;

                            for(int var52 = 0; var52 < 4; ++var52) {
                                double var53 = temperatures[(var11 * 4 + var43) * 16 + var12 * 4 + var52];
                                int var55 = 0;
                                if (var13 * 8 + var32 < var7) {
                                    if (var53 < 0.5D && var13 * 8 + var32 >= var7 - 1) {
                                        var55 = BlockBase.ICE.id;
                                    } else {
                                        var55 = BlockBase.STILL_WATER.id;
                                    }
                                }

                                ExtendedBiome biome = BiomeArrayBuilder.INSTANCE.getBiome((float)var53);

                                if (var48 > 0.0D) {
                                    var55 = biome.undergroundID;
                                }

                                tiles[var44] = (byte)var55;

                                if(areAffected(tiles[var44]))
                                {
                                    fastApplyMeta(chunk, var44, (byte) biome.stoneBlockMeta);
                                }

                                var44 += var45;
                                var48 += var50;
                            }

                            var35 += var39;
                            var37 += var41;
                        }

                        var16 += var24;
                        var18 += var26;
                        var20 += var28;
                        var22 += var30;
                    }
                }
            }
        }
    }

    @Redirect(method = "getChunk", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/level/source/OverworldLevelSource;shapeChunk(II[B[Lnet/minecraft/level/biome/Biome;[D)V"))
    private void injectCallNew(OverworldLevelSource overworldLevelSource, int chunkX, int chunkZ, byte[] tiles, Biome[] biomes, double[] temperatures)
    {
        this.shapeChunk(chunkX, chunkZ, tiles, biomes, temperatures, new Chunk(this.level, new byte['耀'], chunkX, chunkZ));
    }

}
