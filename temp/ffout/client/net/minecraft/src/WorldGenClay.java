// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, Block, World, Material

public class WorldGenClay extends WorldGenerator
{

    private int field_867_a;
    private int field_866_b;

    public WorldGenClay(int i)
    {
        field_867_a = Block.field_424_aX.field_376_bc;
        field_866_b = i;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        if(world.func_599_f(i, j, k) != Material.field_1332_f)
        {
            return false;
        }
        int l = random.nextInt(field_866_b - 2) + 2;
        int i1 = 1;
        for(int j1 = i - l; j1 <= i + l; j1++)
        {
            for(int k1 = k - l; k1 <= k + l; k1++)
            {
                int l1 = j1 - i;
                int i2 = k1 - k;
                if(l1 * l1 + i2 * i2 > l * l)
                {
                    continue;
                }
                for(int j2 = j - i1; j2 <= j + i1; j2++)
                {
                    int k2 = world.func_600_a(j1, j2, k1);
                    if(k2 == Block.field_336_w.field_376_bc || k2 == Block.field_424_aX.field_376_bc)
                    {
                        world.func_634_a(j1, j2, k1, field_867_a);
                    }
                }

            }

        }

        return true;
    }
}
