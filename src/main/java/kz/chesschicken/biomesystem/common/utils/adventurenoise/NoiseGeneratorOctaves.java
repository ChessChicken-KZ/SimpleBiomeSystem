package kz.chesschicken.biomesystem.common.utils.adventurenoise;

import net.minecraft.util.maths.MathHelper;
import net.minecraft.util.noise.PerlinOctaveNoise;

import java.util.Arrays;
import java.util.Random;

public class NoiseGeneratorOctaves extends PerlinOctaveNoise
{
    private final NoiseGeneratorPerlin[] collection;
    private final int octaves;

    public NoiseGeneratorOctaves(Random random, int octaves)
    {
        super(random, octaves);
        this.octaves = octaves;
        this.collection = new NoiseGeneratorPerlin[octaves];

        for (int i = 0; i < octaves; i++) {
            collection[i] = new NoiseGeneratorPerlin(random);
        }
    }

    public double[] sample(double[] array, double i1, double i2, double i3, int p1, int p2, int p3, double l1, double l2, double l3) {
        if (array == null) {
            array = new double[p1 * p2 * p3];
        } else {
            Arrays.fill(array, 0.0D);
        }

        double d = 1.0D;

        for (int j = 0; j < octaves; j++) {
            double d1 = i1 * d * l1;
            double d2 = i2 * d * l2;
            double d3 = i3 * d * l3;
            long l = MathHelper.floor(d1);
            long l0 = MathHelper.floor(d3);
            d1 -= l;
            d3 -= l0;
            l %= 0x1000000L;
            l0 %= 0x1000000L;
            d1 += l;
            d3 += l0;
            collection[j].sample(array, d1, d2, d3, p1, p2, p3, l1 * d, l2 * d, l3 * d, d);
            d /= 2D;
        }

        return array;
    }

    public double[] sample(double[] array, int i1, int i3, int p1, int p3, double par6, double l1, double l3) {
        return this.sample(array, i1, 10, i3, p1, 1, p3, l1, 1.0D, l3);
    }
}
