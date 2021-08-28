package kz.chesschicken.biomesystem.mixin;

import kz.chesschicken.biomesystem.common.MapContainer;
import kz.chesschicken.biomesystem.common.utils.worldnoise.ILevelNoise;
import net.minecraft.level.Level;
import net.minecraft.level.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Dimension.class)
public class MixinDimension {

    @Inject(method = "initDimension", at = @At("HEAD"))
    private void injectSetNoiseEnum(Level level, CallbackInfo ci)
    {
        if(MapContainer.INSTANCE.CURRENT_ENUM != null) {
            ((ILevelNoise) level.getProperties()).setNoiseEnum(MapContainer.INSTANCE.CURRENT_ENUM);
            MapContainer.INSTANCE.CURRENT_ENUM = null;
        }
    }
}
