// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            NoiseGenerator

public class NoiseGeneratorPerlin extends NoiseGenerator
{

    private int field_1189_d[];
    public double field_1188_a;
    public double field_1187_b;
    public double field_1190_c;

    public NoiseGeneratorPerlin()
    {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random random)
    {
        field_1189_d = new int[512];
        field_1188_a = random.nextDouble() * 256D;
        field_1187_b = random.nextDouble() * 256D;
        field_1190_c = random.nextDouble() * 256D;
        for(int i = 0; i < 256; i++)
        {
            field_1189_d[i] = i;
        }

        for(int j = 0; j < 256; j++)
        {
            int k = random.nextInt(256 - j) + j;
            int l = field_1189_d[j];
            field_1189_d[j] = field_1189_d[k];
            field_1189_d[k] = l;
            field_1189_d[j + 256] = field_1189_d[j];
        }

    }

    public final double func_804_b(double d, double d1, double d2)
    {
        return d1 + d * (d2 - d1);
    }

    public final double func_4110_a(int i, double d, double d1)
    {
        int j = i & 0xf;
        double d2 = (double)(1 - ((j & 8) >> 3)) * d;
        double d3 = j >= 4 ? j != 12 && j != 14 ? d1 : d : 0.0D;
        return ((j & 1) != 0 ? -d2 : d2) + ((j & 2) != 0 ? -d3 : d3);
    }

    public final double func_803_a(int i, double d, double d1, double d2)
    {
        int j = i & 0xf;
        double d3 = j >= 8 ? d1 : d;
        double d4 = j >= 4 ? j != 12 && j != 14 ? d2 : d : d1;
        return ((j & 1) != 0 ? -d3 : d3) + ((j & 2) != 0 ? -d4 : d4);
    }

    public void func_805_a(double ad[], double d, double d1, double d2, 
            int i, int j, int k, double d3, double d4, 
            double d5, double d6)
    {
        if(j == 1)
        {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            double d8 = 0.0D;
            double d10 = 0.0D;
            int j3 = 0;
            double d12 = 1.0D / d6;
            for(int i4 = 0; i4 < i; i4++)
            {
                double d14 = d + (double)i4 * d3 + field_1188_a;
                int j4 = (int)d14;
                if(d14 < (double)j4)
                {
                    j4--;
                }
                int k4 = j4 & 0xff;
                d14 -= j4;
                double d17 = d14 * d14 * d14 * (d14 * (d14 * 6D - 15D) + 10D);
                for(int l4 = 0; l4 < k; l4++)
                {
                    double d19 = d2 + (double)l4 * d5 + field_1190_c;
                    int j5 = (int)d19;
                    if(d19 < (double)j5)
                    {
                        j5--;
                    }
                    int l5 = j5 & 0xff;
                    d19 -= j5;
                    double d21 = d19 * d19 * d19 * (d19 * (d19 * 6D - 15D) + 10D);
                    int l = field_1189_d[k4] + 0;
                    int j1 = field_1189_d[l] + l5;
                    int k1 = field_1189_d[k4 + 1] + 0;
                    int l1 = field_1189_d[k1] + l5;
                    double d9 = func_804_b(d17, func_4110_a(field_1189_d[j1], d14, d19), func_803_a(field_1189_d[l1], d14 - 1.0D, 0.0D, d19));
                    double d11 = func_804_b(d17, func_803_a(field_1189_d[j1 + 1], d14, 0.0D, d19 - 1.0D), func_803_a(field_1189_d[l1 + 1], d14 - 1.0D, 0.0D, d19 - 1.0D));
                    double d23 = func_804_b(d21, d9, d11);
                    ad[j3++] += d23 * d12;
                }

            }

            return;
        }
        int i1 = 0;
        double d7 = 1.0D / d6;
        int i2 = -1;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        double d13 = 0.0D;
        double d15 = 0.0D;
        double d16 = 0.0D;
        double d18 = 0.0D;
        for(int i5 = 0; i5 < i; i5++)
        {
            double d20 = d + (double)i5 * d3 + field_1188_a;
            int k5 = (int)d20;
            if(d20 < (double)k5)
            {
                k5--;
            }
            int i6 = k5 & 0xff;
            d20 -= k5;
            double d22 = d20 * d20 * d20 * (d20 * (d20 * 6D - 15D) + 10D);
            for(int j6 = 0; j6 < k; j6++)
            {
                double d24 = d2 + (double)j6 * d5 + field_1190_c;
                int k6 = (int)d24;
                if(d24 < (double)k6)
                {
                    k6--;
                }
                int l6 = k6 & 0xff;
                d24 -= k6;
                double d25 = d24 * d24 * d24 * (d24 * (d24 * 6D - 15D) + 10D);
                for(int i7 = 0; i7 < j; i7++)
                {
                    double d26 = d1 + (double)i7 * d4 + field_1187_b;
                    int j7 = (int)d26;
                    if(d26 < (double)j7)
                    {
                        j7--;
                    }
                    int k7 = j7 & 0xff;
                    d26 -= j7;
                    double d27 = d26 * d26 * d26 * (d26 * (d26 * 6D - 15D) + 10D);
                    if(i7 == 0 || k7 != i2)
                    {
                        i2 = k7;
                        int j2 = field_1189_d[i6] + k7;
                        int k2 = field_1189_d[j2] + l6;
                        int l2 = field_1189_d[j2 + 1] + l6;
                        int i3 = field_1189_d[i6 + 1] + k7;
                        int k3 = field_1189_d[i3] + l6;
                        int l3 = field_1189_d[i3 + 1] + l6;
                        d13 = func_804_b(d22, func_803_a(field_1189_d[k2], d20, d26, d24), func_803_a(field_1189_d[k3], d20 - 1.0D, d26, d24));
                        d15 = func_804_b(d22, func_803_a(field_1189_d[l2], d20, d26 - 1.0D, d24), func_803_a(field_1189_d[l3], d20 - 1.0D, d26 - 1.0D, d24));
                        d16 = func_804_b(d22, func_803_a(field_1189_d[k2 + 1], d20, d26, d24 - 1.0D), func_803_a(field_1189_d[k3 + 1], d20 - 1.0D, d26, d24 - 1.0D));
                        d18 = func_804_b(d22, func_803_a(field_1189_d[l2 + 1], d20, d26 - 1.0D, d24 - 1.0D), func_803_a(field_1189_d[l3 + 1], d20 - 1.0D, d26 - 1.0D, d24 - 1.0D));
                    }
                    double d28 = func_804_b(d27, d13, d15);
                    double d29 = func_804_b(d27, d16, d18);
                    double d30 = func_804_b(d25, d28, d29);
                    ad[i1++] += d30 * d7;
                }

            }

        }

    }
}
