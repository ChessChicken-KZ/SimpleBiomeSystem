package kz.chesschicken.biomesystem.mixin.client;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.InGame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGame.class)
public class MixinInGame {

    @Shadow private Minecraft minecraft;

    @Inject(method = "renderHud", at = @At("TAIL"))
    private void showBiome(float f, boolean flag, int i, int j, CallbackInfo ci)
    {
        if (this.minecraft.options.debugHud && FabricLoader.getInstance().isDevelopmentEnvironment()) {
            this.minecraft.textRenderer.drawTextWithShadow("Biome: " + (this.minecraft.level.getBiomeSource().getBiome((int) this.minecraft.player.x, (int) this.minecraft.player.z).biomeName), 5, 105, 0xFFFFFF);
            this.minecraft.textRenderer.drawTextWithShadow("Temperature: " + (this.minecraft.level.getBiomeSource().getTemperature((int) this.minecraft.player.x, (int) this.minecraft.player.z)), 5, 115, 0xFFFFFF);

        }
    }
}
