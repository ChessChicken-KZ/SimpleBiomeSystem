package kz.chesschicken.biomesystem.mixin.server;

import kz.chesschicken.biomesystem.common.MapContainer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.level.storage.LevelStorage;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.SERVER)
@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Inject(method = "prepareLevel", at = @At("HEAD"))
    private void injectInvokeConfig(LevelStorage arg, String levelName, long seed, CallbackInfo ci)
    {
        MapContainer.INSTANCE.parseServerConfig();
    }
}
