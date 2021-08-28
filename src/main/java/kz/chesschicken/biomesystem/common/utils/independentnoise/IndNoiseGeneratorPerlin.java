package kz.chesschicken.biomesystem.common.utils.independentnoise;

import net.minecraft.util.noise.Noise;

import java.util.Random;

public class IndNoiseGeneratorPerlin extends Noise {
    private final int[] permutations;
    public double xCoord;
    public double yCoord;
    public double zCoord;

    @SuppressWarnings("StatementWithEmptyBody")
    public IndNoiseGeneratorPerlin(Random random) {
        this.permutations = new int[512];
        this.xCoord = random.nextDouble() * 256.0D;
        this.yCoord = random.nextDouble() * 256.0D;
        this.zCoord = random.nextDouble() * 256.0D;

        int j;

        for(j = 0; j < 256; this.permutations[j] = j++) {
        }

        for(j = 0; j < 256; ++j) {
            int k = random.nextInt(256 - j) + j;
            int l = this.permutations[j];
            this.permutations[j] = this.permutations[k];
            this.permutations[k] = l;
            this.permutations[j + 256] = this.permutations[j];
        }

    }

    public double generateNoise(double d, double d1, double d2) {
        double d3 = d + this.xCoord;
        double d4 = d1 + this.yCoord;
        double d5 = d2 + this.zCoord;
        int i = (int)d3;
        int j = (int)d4;
        int k = (int)d5;
        if (d3 < (double)i) {
            --i;
        }

        if (d4 < (double)j) {
            --j;
        }

        if (d5 < (double)k) {
            --k;
        }

        int l = i & 255;
        int i1 = j & 255;
        int j1 = k & 255;
        d3 -= i;
        d4 -= j;
        d5 -= k;
        double d6 = d3 * d3 * d3 * (d3 * (d3 * 6.0D - 15.0D) + 10.0D);
        double d7 = d4 * d4 * d4 * (d4 * (d4 * 6.0D - 15.0D) + 10.0D);
        double d8 = d5 * d5 * d5 * (d5 * (d5 * 6.0D - 15.0D) + 10.0D);
        int k1 = this.permutations[l] + i1;
        int l1 = this.permutations[k1] + j1;
        int i2 = this.permutations[k1 + 1] + j1;
        int j2 = this.permutations[l + 1] + i1;
        int k2 = this.permutations[j2] + j1;
        int l2 = this.permutations[j2 + 1] + j1;
        return this.lerp(d8, this.lerp(d7, this.lerp(d6, this.gradient(this.permutations[l1], d3, d4, d5), this.gradient(this.permutations[k2], d3 - 1.0D, d4, d5)), this.lerp(d6, this.gradient(this.permutations[i2], d3, d4 - 1.0D, d5), this.gradient(this.permutations[l2], d3 - 1.0D, d4 - 1.0D, d5))), this.lerp(d7, this.lerp(d6, this.gradient(this.permutations[l1 + 1], d3, d4, d5 - 1.0D), this.gradient(this.permutations[k2 + 1], d3 - 1.0D, d4, d5 - 1.0D)), this.lerp(d6, this.gradient(this.permutations[i2 + 1], d3, d4 - 1.0D, d5 - 1.0D), this.gradient(this.permutations[l2 + 1], d3 - 1.0D, d4 - 1.0D, d5 - 1.0D))));
    }

    public final double lerp(double d, double d1, double d2) {
        return d1 + d * (d2 - d1);
    }

    public final double func_4110_a(int i, double d, double d1) {
        int j = i & 15;
        double d2 = (double)(1 - ((j & 8) >> 3)) * d;
        double d3 = j >= 4 ? (j != 12 && j != 14 ? d1 : d) : 0.0D;
        return ((j & 1) != 0 ? -d2 : d2) + ((j & 2) != 0 ? -d3 : d3);
    }

    public final double gradient(int i, double d, double d1, double d2) {
        int j = i & 15;
        double d3 = j >= 8 ? d1 : d;
        double d4 = j >= 4 ? (j != 12 && j != 14 ? d2 : d) : d1;
        return ((j & 1) != 0 ? -d3 : d3) + ((j & 2) != 0 ? -d4 : d4);
    }

    public double sample(double d, double d1) {
        return this.generateNoise(d, d1, 0.0D);
    }

    public void sample(double[] ad, double d, double d1, double d2, int i, int j, int k, double d3, double d4, double d5, double d6) {
        int var10001;
        double d15;
        double d18;
        int l4;
        double d20;
        int j5;
        int i6;
        double d22;
        int l;
        int k6;
        double d26;
        if (j == 1) {
            int j3 = 0;
            double d12 = 1.0D / d6;

            for(int i4 = 0; i4 < i; ++i4) {
                d15 = (d + (double)i4) * d3 + this.xCoord;
                int j4 = (int)d15;
                if (d15 < (double)j4) {
                    --j4;
                }

                int k4 = j4 & 255;
                d15 -= j4;
                d18 = d15 * d15 * d15 * (d15 * (d15 * 6.0D - 15.0D) + 10.0D);

                for(l4 = 0; l4 < k; ++l4) {
                    d20 = (d2 + (double)l4) * d5 + this.zCoord;
                    j5 = (int)d20;
                    if (d20 < (double)j5) {
                        --j5;
                    }

                    i6 = j5 & 255;
                    d20 -= j5;
                    d22 = d20 * d20 * d20 * (d20 * (d20 * 6.0D - 15.0D) + 10.0D);
                    l = this.permutations[k4];
                    int j1 = this.permutations[l] + i6;
                    int k1 = this.permutations[k4 + 1];
                    k6 = this.permutations[k1] + i6;
                    double d9 = this.lerp(d18, this.func_4110_a(this.permutations[j1], d15, d20), this.gradient(this.permutations[k6], d15 - 1.0D, 0.0D, d20));
                    double d11 = this.lerp(d18, this.gradient(this.permutations[j1 + 1], d15, 0.0D, d20 - 1.0D), this.gradient(this.permutations[k6 + 1], d15 - 1.0D, 0.0D, d20 - 1.0D));
                    d26 = this.lerp(d22, d9, d11);
                    var10001 = j3++;
                    ad[var10001] += d26 * d12;
                }
            }

        } else {
            int i1 = 0;
            double d7 = 1.0D / d6;
            int i2 = -1;
            double d13 = 0.0D;
            d15 = 0.0D;
            double d16 = 0.0D;
            d18 = 0.0D;

            for(l4 = 0; l4 < i; ++l4) {
                d20 = (d + (double)l4) * d3 + this.xCoord;
                j5 = (int)d20;
                if (d20 < (double)j5) {
                    --j5;
                }

                i6 = j5 & 255;
                d20 -= j5;
                d22 = d20 * d20 * d20 * (d20 * (d20 * 6.0D - 15.0D) + 10.0D);

                for(l = 0; l < k; ++l) {
                    double d24 = (d2 + (double)l) * d5 + this.zCoord;
                    k6 = (int)d24;
                    if (d24 < (double)k6) {
                        --k6;
                    }

                    int l6 = k6 & 255;
                    d24 -= k6;
                    double d25 = d24 * d24 * d24 * (d24 * (d24 * 6.0D - 15.0D) + 10.0D);

                    for(int i7 = 0; i7 < j; ++i7) {
                        d26 = (d1 + (double)i7) * d4 + this.yCoord;
                        int j7 = (int)d26;
                        if (d26 < (double)j7) {
                            --j7;
                        }

                        int k7 = j7 & 255;
                        d26 -= j7;
                        double d27 = d26 * d26 * d26 * (d26 * (d26 * 6.0D - 15.0D) + 10.0D);
                        if (i7 == 0 || k7 != i2) {
                            i2 = k7;
                            int j2 = this.permutations[i6] + k7;
                            int k2 = this.permutations[j2] + l6;
                            int l2 = this.permutations[j2 + 1] + l6;
                            int i3 = this.permutations[i6 + 1] + k7;
                            int k3 = this.permutations[i3] + l6;
                            int l3 = this.permutations[i3 + 1] + l6;
                            d13 = this.lerp(d22, this.gradient(this.permutations[k2], d20, d26, d24), this.gradient(this.permutations[k3], d20 - 1.0D, d26, d24));
                            d15 = this.lerp(d22, this.gradient(this.permutations[l2], d20, d26 - 1.0D, d24), this.gradient(this.permutations[l3], d20 - 1.0D, d26 - 1.0D, d24));
                            d16 = this.lerp(d22, this.gradient(this.permutations[k2 + 1], d20, d26, d24 - 1.0D), this.gradient(this.permutations[k3 + 1], d20 - 1.0D, d26, d24 - 1.0D));
                            d18 = this.lerp(d22, this.gradient(this.permutations[l2 + 1], d20, d26 - 1.0D, d24 - 1.0D), this.gradient(this.permutations[l3 + 1], d20 - 1.0D, d26 - 1.0D, d24 - 1.0D));
                        }

                        double d28 = this.lerp(d27, d13, d15);
                        double d29 = this.lerp(d27, d16, d18);
                        double d30 = this.lerp(d25, d28, d29);
                        var10001 = i1++;
                        ad[var10001] += d30 * d7;
                    }
                }
            }

        }
    }
}
