// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Material, Block, 
//            BlockGrass

public class WorldGenSand extends WorldGenerator
{

    private int field_35264_a;
    private int field_35263_b;

    public WorldGenSand(int i, int j)
    {
        field_35264_a = j;
        field_35263_b = i;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        if(world.func_599_f(i, j, k) != Material.field_1332_f)
        {
            return false;
        }
        int l = random.nextInt(field_35263_b - 2) + 2;
        byte byte0 = 2;
        for(int i1 = i - l; i1 <= i + l; i1++)
        {
            for(int j1 = k - l; j1 <= k + l; j1++)
            {
                int k1 = i1 - i;
                int l1 = j1 - k;
                if(k1 * k1 + l1 * l1 > l * l)
                {
                    continue;
                }
                for(int i2 = j - byte0; i2 <= j + byte0; i2++)
                {
                    int j2 = world.func_600_a(i1, i2, j1);
                    if(j2 == Block.field_336_w.field_376_bc || j2 == Block.field_337_v.field_376_bc)
                    {
                        world.func_634_a(i1, i2, j1, field_35264_a);
                    }
                }

            }

        }

        return true;
    }
}
