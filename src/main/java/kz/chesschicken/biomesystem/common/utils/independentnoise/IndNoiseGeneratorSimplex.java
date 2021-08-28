package kz.chesschicken.biomesystem.common.utils.independentnoise;

import net.minecraft.util.noise.SimplexOctaveNoise;

import java.util.Arrays;
import java.util.Random;

public class IndNoiseGeneratorSimplex extends SimplexOctaveNoise {
    private final IndNoiseGenerator[] collection;
    private final int octaves;

    public IndNoiseGeneratorSimplex(Random random, int i) {
        super(random, i);
        this.octaves = i;
        this.collection = new IndNoiseGenerator[i];
        for (int j = 0; j < i; j++)
            this.collection[j] = new IndNoiseGenerator(random);
    }

    public double[] sample(double[] ad, double d, double d1, int i, int j, double d2, double d3, double d4) {
        return sample(ad, d, d1, i, j, d2, d3, d4, 0.5D);
    }

    public double[] sample(double[] ad, double d, double d1, int i, int j, double d2, double d3, double d4, double d5) {
        d2 /= 1.5D;
        d3 /= 1.5D;
        if (ad == null || ad.length < i * j) {
            ad = new double[i * j];
        } else {
            Arrays.fill(ad, 0.0D);
        }
        double d6 = 1.0D;
        double d7 = 1.0D;
        for (int l = 0; l < this.octaves; l++) {
            this.collection[l].sample(ad, d, d1, i, j, d2 * d7, d3 * d7, 0.55D / d6);
            d7 *= d4;
            d6 *= d5;
        }
        return ad;
    }
}

