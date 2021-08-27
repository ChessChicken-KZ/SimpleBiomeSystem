package kz.chesschicken.biomesystem.utils;

import net.minecraft.util.noise.PerlinNoise;

import java.util.Random;

public class NoiseGeneratorPerlin extends PerlinNoise
{
    private final int[] permutations;
    public double x;
    public double y;
    public double z;

    public NoiseGeneratorPerlin(Random random)
    {
        permutations = new int[512];
        x = random.nextDouble() * 256D;
        y = random.nextDouble() * 256D;
        z = random.nextDouble() * 256D;

        for (int i = 0; i < 256; i++) {
            permutations[i] = i;
        }

        for (int j = 0; j < 256; j++) {
            int k = random.nextInt(256 - j) + j;
            int l = permutations[j];
            permutations[j] = permutations[k];
            permutations[k] = l;
            permutations[j + 256] = permutations[j];
        }
    }

    public final double linearI(double par1, double par3, double par5)
    {
        return par3 + par1 * (par5 - par3);
    }

    public final double func_4110_a(int i, double d1, double d2)
    {
        int t = i & 0xf;
        double v1 = (double)(1 - ((t & 8) >> 3)) * d1;
        double v2 = t >= 4 ? t != 12 && t != 14 ? d2 : d1 : 0.0D;
        return ((t & 1) != 0 ? -v1 : v1) + ((t & 2) != 0 ? -v2 : v2);
    }

    public final double gradient(int par1, double par2, double par4, double par6)
    {
        int i = par1 & 0xf;
        double d = i >= 8 ? par4 : par2;
        double d1 = i >= 4 ? i != 12 && i != 14 ? par6 : par2 : par4;
        return ((i & 1) != 0 ? -d : d) + ((i & 2) != 0 ? -d1 : d1);
    }

    public void sample(double[] array, double d1, double d2, double d3, int par8, int par9, int par10, double d4, double d5, double d6, double d7)
    {
        if (par9 == 1)
        {
            int step = 0;
            double tv1 = 1.0D / d7;

            for (int j3 = 0; j3 < par8; j3++)
            {
                double d17 = d1 + (double)j3 * d4 + x;
                int k3 = (int)d17;

                if (d17 < (double)k3)
                {
                    k3--;
                }

                int l3 = k3 & 0xff;
                d17 -= k3;
                double d10 = d17 * d17 * d17 * (d17 * (d17 * 6D - 15D) + 10D);

                for (int i4 = 0; i4 < par10; i4++)
                {
                    double d12 = d3 + (double)i4 * d6 + z;
                    int k4 = (int)d12;

                    if (d12 < (double)k4)
                    {
                        k4--;
                    }

                    int i5 = k4 & 0xff;
                    d12 -= k4;
                    double d14 = d12 * d12 * d12 * (d12 * (d12 * 6D - 15D) + 10D);
                    int i = permutations[l3];
                    int k = permutations[i] + i5;
                    int l = permutations[l3 + 1];
                    int i1 = permutations[l] + i5;
                    double lerp1 = linearI(d10, func_4110_a(permutations[k], d17, d12), gradient(permutations[i1], d17 - 1.0D, 0.0D, d12));
                    double lerp2 = linearI(d10, gradient(permutations[k + 1], d17, 0.0D, d12 - 1.0D), gradient(permutations[i1 + 1], d17 - 1.0D, 0.0D, d12 - 1.0D));
                    double lerp3 = linearI(d14, lerp1, lerp2);
                    array[step++] += lerp3 * tv1;
                }
            }

            return;
        }

        int j = 0;
        double d = 1.0D / d7;
        int j1 = -1;
        double d1_6 = 0.0D;
        double d8 = 0.0D;
        double d9 = 0.0D;
        double d11 = 0.0D;

        for (int j4 = 0; j4 < par8; j4++)
        {
            double d13 = d1 + (double)j4 * d4 + x;
            int l4 = (int)d13;

            if (d13 < (double)l4)
            {
                l4--;
            }

            int j5 = l4 & 0xff;
            d13 -= l4;
            double d15 = d13 * d13 * d13 * (d13 * (d13 * 6D - 15D) + 10D);

            for (int k5 = 0; k5 < par10; k5++)
            {
                double d17 = d3 + (double)k5 * d6 + z;
                int l5 = (int)d17;

                if (d17 < (double)l5)
                {
                    l5--;
                }

                int i6 = l5 & 0xff;
                d17 -= l5;
                double d18 = d17 * d17 * d17 * (d17 * (d17 * 6D - 15D) + 10D);

                for (int j6 = 0; j6 < par9; j6++)
                {
                    double d19 = d2 + (double)j6 * d5 + y;
                    int k6 = (int)d19;

                    if (d19 < (double)k6)
                    {
                        k6--;
                    }

                    int l6 = k6 & 0xff;
                    d19 -= k6;
                    double d20 = d19 * d19 * d19 * (d19 * (d19 * 6D - 15D) + 10D);

                    if (j6 == 0 || l6 != j1)
                    {
                        j1 = l6;
                        int k1 = permutations[j5] + l6;
                        int l1 = permutations[k1] + i6;
                        int i2 = permutations[k1 + 1] + i6;
                        int j2 = permutations[j5 + 1] + l6;
                        int l2 = permutations[j2] + i6;
                        int i3 = permutations[j2 + 1] + i6;
                        d1_6 = linearI(d15, gradient(permutations[l1], d13, d19, d17), gradient(permutations[l2], d13 - 1.0D, d19, d17));
                        d8 = linearI(d15, gradient(permutations[i2], d13, d19 - 1.0D, d17), gradient(permutations[i3], d13 - 1.0D, d19 - 1.0D, d17));
                        d9 = linearI(d15, gradient(permutations[l1 + 1], d13, d19, d17 - 1.0D), gradient(permutations[l2 + 1], d13 - 1.0D, d19, d17 - 1.0D));
                        d11 = linearI(d15, gradient(permutations[i2 + 1], d13, d19 - 1.0D, d17 - 1.0D), gradient(permutations[i3 + 1], d13 - 1.0D, d19 - 1.0D, d17 - 1.0D));
                    }

                    double lerp1 = linearI(d20, d1_6, d8);
                    double lerp2 = linearI(d20, d9, d11);
                    double lerp3 = linearI(d18, lerp1, lerp2);
                    array[j++] += lerp3 * d;
                }
            }
        }
    }
}
