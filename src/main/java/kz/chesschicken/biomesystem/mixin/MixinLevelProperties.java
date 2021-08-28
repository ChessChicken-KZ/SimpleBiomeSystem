package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.common.utils.NoiseEnum;
import kz.chesschicken.biomesystem.common.utils.worldnoise.ILevelNoise;
import net.minecraft.level.LevelProperties;
import net.minecraft.util.io.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelProperties.class)
public class MixinLevelProperties implements ILevelNoise {
    @Unique
    private NoiseEnum noiseEnum;

    @Inject(method = "updateProperties", at = @At("TAIL"))
    private void injectSetNoise(CompoundTag worldTag, CompoundTag playerTag, CallbackInfo ci)
    {
        worldTag.put("noisetype", noiseEnum.name().toUpperCase());
    }

    @Inject(method = "<init>(Lnet/minecraft/util/io/CompoundTag;)V", at = @At("TAIL"))
    private void injectGetNoise(CompoundTag worldTag, CallbackInfo ci)
    {
        if(worldTag.getString("noisetype").length() > 0)
            this.noiseEnum = NoiseEnum.getByName(worldTag.getString("noisetype"));

    }

    @Inject(method = "<init>(Lnet/minecraft/level/LevelProperties;)V", at = @At("TAIL"))
    private void injectGetNoise1(LevelProperties levelProperties, CallbackInfo ci)
    {
        if(((ILevelNoise)levelProperties).getNoiseEnum() != null)
            this.noiseEnum = ((ILevelNoise)levelProperties).getNoiseEnum();
        else
            this.noiseEnum = NoiseEnum.VANILLA;
    }

    @Override
    public NoiseEnum getNoiseEnum() {
        return this.noiseEnum;
    }

    @Override
    public void setNoiseEnum(NoiseEnum noiseEnum) {
        this.noiseEnum = noiseEnum;
    }
}
