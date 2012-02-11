// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, MathHelper, World, Block

public class WorldGenMinable extends WorldGenerator
{

    private int field_884_a;
    private int field_883_b;

    public WorldGenMinable(int i, int j)
    {
        field_884_a = i;
        field_883_b = j;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        float f = random.nextFloat() * 3.141593F;
        double d = (float)(i + 8) + (MathHelper.func_1106_a(f) * (float)field_883_b) / 8F;
        double d1 = (float)(i + 8) - (MathHelper.func_1106_a(f) * (float)field_883_b) / 8F;
        double d2 = (float)(k + 8) + (MathHelper.func_1114_b(f) * (float)field_883_b) / 8F;
        double d3 = (float)(k + 8) - (MathHelper.func_1114_b(f) * (float)field_883_b) / 8F;
        double d4 = (j + random.nextInt(3)) - 2;
        double d5 = (j + random.nextInt(3)) - 2;
        for(int l = 0; l <= field_883_b; l++)
        {
            double d6 = d + ((d1 - d) * (double)l) / (double)field_883_b;
            double d7 = d4 + ((d5 - d4) * (double)l) / (double)field_883_b;
            double d8 = d2 + ((d3 - d2) * (double)l) / (double)field_883_b;
            double d9 = (random.nextDouble() * (double)field_883_b) / 16D;
            double d10 = (double)(MathHelper.func_1106_a(((float)l * 3.141593F) / (float)field_883_b) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.func_1106_a(((float)l * 3.141593F) / (float)field_883_b) + 1.0F) * d9 + 1.0D;
            int i1 = MathHelper.func_1108_b(d6 - d10 / 2D);
            int j1 = MathHelper.func_1108_b(d7 - d11 / 2D);
            int k1 = MathHelper.func_1108_b(d8 - d10 / 2D);
            int l1 = MathHelper.func_1108_b(d6 + d10 / 2D);
            int i2 = MathHelper.func_1108_b(d7 + d11 / 2D);
            int j2 = MathHelper.func_1108_b(d8 + d10 / 2D);
            for(int k2 = i1; k2 <= l1; k2++)
            {
                double d12 = (((double)k2 + 0.5D) - d6) / (d10 / 2D);
                if(d12 * d12 >= 1.0D)
                {
                    continue;
                }
                for(int l2 = j1; l2 <= i2; l2++)
                {
                    double d13 = (((double)l2 + 0.5D) - d7) / (d11 / 2D);
                    if(d12 * d12 + d13 * d13 >= 1.0D)
                    {
                        continue;
                    }
                    for(int i3 = k1; i3 <= j2; i3++)
                    {
                        double d14 = (((double)i3 + 0.5D) - d8) / (d10 / 2D);
                        if(d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && world.func_600_a(k2, l2, i3) == Block.field_338_u.field_376_bc)
                        {
                            world.func_634_a(k2, l2, i3, field_884_a);
                        }
                    }

                }

            }

        }

        return true;
    }
}
