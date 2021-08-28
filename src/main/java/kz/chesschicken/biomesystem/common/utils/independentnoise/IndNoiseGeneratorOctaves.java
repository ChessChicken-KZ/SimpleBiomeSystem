package kz.chesschicken.biomesystem.common.utils.independentnoise;

import net.minecraft.util.noise.PerlinOctaveNoise;

import java.util.Arrays;
import java.util.Random;

public class IndNoiseGeneratorOctaves extends PerlinOctaveNoise {
    private final IndNoiseGeneratorPerlin[] generatorCollection;
    private final int octaves;

    public IndNoiseGeneratorOctaves(Random random, int i) {
        super(random, i);
        this.octaves = i;
        this.generatorCollection = new IndNoiseGeneratorPerlin[i];
        for (int j = 0; j < i; j++)
            this.generatorCollection[j] = new IndNoiseGeneratorPerlin(random);
    }

    public double sample(double d, double d1) {
        double d2 = 0.0D;
        double d3 = 1.0D;
        for (int i = 0; i < this.octaves; i++) {
            d2 += this.generatorCollection[i].sample(d * d3, d1 * d3) / d3;
            d3 /= 2.0D;
        }
        return d2;
    }

    public double[] sample(double[] ad, double d, double d1, double d2, int i, int j, int k, double d3, double d4, double d5) {
        if (ad == null) {
            ad = new double[i * j * k];
        } else {
            Arrays.fill(ad, 0.0D);
        }
        double d6 = 1.0D;
        for (int i1 = 0; i1 < this.octaves; i1++) {
            this.generatorCollection[i1].sample(ad, d, d1, d2, i, j, k, d3 * d6, d4 * d6, d5 * d6, d6);
            d6 /= 2.0D;
        }
        return ad;
    }

    public double[] sample(double[] ad, int i, int j, int k, int l, double d, double d1, double d2) {
        return sample(ad, i, 10.0D, j, k, 1, l, d, 1.0D, d1);
    }
}