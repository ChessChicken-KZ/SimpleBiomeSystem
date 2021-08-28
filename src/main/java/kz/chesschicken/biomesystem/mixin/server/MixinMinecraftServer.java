package kz.chesschicken.biomesystem.mixin.server;

import kz.chesschicken.biomesystem.server.MapContainer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.level.storage.LevelStorage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.SERVER)
@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
    @Shadow public ServerLevel[] levels;

    @Inject(method = "prepareLevel", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/ServerPlayerConnectionManager;method_564([Lnet/minecraft/server/level/ServerLevel;)V",
            shift = At.Shift.BEFORE
    ))
    private void prepareConfig(LevelStorage arg, String levelName, long seed, CallbackInfo ci)
    {
        MapContainer.INSTANCE.parseServerConfig(this.levels[0]);
    }
}
