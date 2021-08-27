package kz.chesschicken.biomesystem.mixin;

import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Biome.class)
public interface AccessorBiome {
    @Invoker("setRainless")
    public Biome invoker_setRainless();
}
