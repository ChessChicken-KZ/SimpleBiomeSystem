package kz.chesschicken.biomesystem.common.utils;

import kz.chesschicken.biomesystem.common.utils.adventurenoise.NoiseGeneratorOctaves;
import kz.chesschicken.biomesystem.common.utils.independentnoise.IndNoiseGeneratorOctaves;
import kz.chesschicken.biomesystem.common.utils.independentnoise.IndNoiseGeneratorSimplex;
import net.minecraft.util.noise.PerlinOctaveNoise;
import net.minecraft.util.noise.SimplexOctaveNoise;


//TODO: Use this somewhere.
public enum NoiseEnum {

    VANILLA("VANILLA", PerlinOctaveNoise.class, SimplexOctaveNoise.class),
    ADVENTURE("ADVENTURE", NoiseGeneratorOctaves.class, SimplexOctaveNoise.class),
    INDEPENDENT("INDEPENDENT", IndNoiseGeneratorOctaves.class, IndNoiseGeneratorSimplex.class);

    public final Class<? extends PerlinOctaveNoise> perlinOctaves;
    public final Class<? extends SimplexOctaveNoise> simplex;
    public final String noiseName;
    NoiseEnum(String name, Class<? extends PerlinOctaveNoise> perlinOctaves, Class<? extends SimplexOctaveNoise> simplex)
    {
        this.noiseName = name;
        this.perlinOctaves = perlinOctaves;
        this.simplex = simplex;
    }

    public static NoiseEnum getByName(String s)
    {
        s = s.toUpperCase();

        for(NoiseEnum noiseEnum : NoiseEnum.values())
        {
            if(noiseEnum.noiseName.equals(s))
                return noiseEnum;
        }

        return null;
    }

}
