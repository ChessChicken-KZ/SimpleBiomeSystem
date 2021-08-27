package kz.chesschicken.biomesystem.utils;

import kz.chesschicken.biomesystem.utils.adventurenoise.NoiseGeneratorOctaves;
import kz.chesschicken.biomesystem.utils.independentnoise.IndNoiseGeneratorOctaves;
import kz.chesschicken.biomesystem.utils.independentnoise.IndNoiseGeneratorSimplex;
import net.minecraft.util.noise.PerlinOctaveNoise;
import net.minecraft.util.noise.SimplexOctaveNoise;


public enum NoiseEnum {

    VANILLA(PerlinOctaveNoise.class, SimplexOctaveNoise.class),
    ADVENTURE(NoiseGeneratorOctaves.class, SimplexOctaveNoise.class),
    INDEPENDENT(IndNoiseGeneratorOctaves.class, IndNoiseGeneratorSimplex.class);

    public final Class<? extends PerlinOctaveNoise> perlinOctaves;
    public final Class<? extends SimplexOctaveNoise> simplex;
    NoiseEnum(Class<? extends PerlinOctaveNoise> perlinOctaves, Class<? extends SimplexOctaveNoise> simplex)
    {
        this.perlinOctaves = perlinOctaves;
        this.simplex = simplex;
    }

    //TODO: Remove hardcoded values.
    @SuppressWarnings("unused")
    public static NoiseEnum CURRENT_ENUM = INDEPENDENT;
}
