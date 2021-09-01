package kz.chesschicken.biomesystem.mixin.client.render;

import net.minecraft.block.Grass;
import net.minecraft.level.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Grass.class)
public class MixinGrass {
    @Inject(method = "getColourMultiplier", at = @At("HEAD"), cancellable = true)
    private void injectGetNewGrassColorMultiplier(BlockView tileView, int x, int y, int z, CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(tileView.getBiomeSource().getBiomes(x, z, 1, 1)[0].grassColour);
    }
}
