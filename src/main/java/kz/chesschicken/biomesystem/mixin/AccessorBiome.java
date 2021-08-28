package kz.chesschicken.biomesystem.mixin;

import net.minecraft.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Biome.class)
public interface AccessorBiome {
    @SuppressWarnings("UnusedReturnValue")
    @Invoker("setRainless")
    Biome invokerSetRainless();

    @Accessor("biomes")
    static Biome[] accessorBiomes() {
        return new Biome[0];
    }
}
