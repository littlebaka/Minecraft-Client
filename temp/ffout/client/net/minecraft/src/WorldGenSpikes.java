// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, EntityEnderCrystal, 
//            Entity

public class WorldGenSpikes extends WorldGenerator
{

    private int field_40197_a;

    public WorldGenSpikes(int i)
    {
        field_40197_a = i;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        if(!world.func_20084_d(i, j, k) || world.func_600_a(i, j - 1, k) != field_40197_a)
        {
            return false;
        }
        int l = random.nextInt(32) + 6;
        int i1 = random.nextInt(4) + 1;
        for(int j1 = i - i1; j1 <= i + i1; j1++)
        {
            for(int l1 = k - i1; l1 <= k + i1; l1++)
            {
                int j2 = j1 - i;
                int l2 = l1 - k;
                if(j2 * j2 + l2 * l2 <= i1 * i1 + 1 && world.func_600_a(j1, j - 1, l1) != field_40197_a)
                {
                    return false;
                }
            }

        }

        for(int k1 = j; k1 < j + l && k1 < world.field_35472_c; k1++)
        {
            for(int i2 = i - i1; i2 <= i + i1; i2++)
            {
                for(int k2 = k - i1; k2 <= k + i1; k2++)
                {
                    int i3 = i2 - i;
                    int j3 = k2 - k;
                    if(i3 * i3 + j3 * j3 <= i1 * i1 + 1)
                    {
                        world.func_690_d(i2, k1, k2, Block.field_405_aq.field_376_bc);
                    }
                }

            }

        }

        EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(world);
        entityendercrystal.func_365_c((float)i + 0.5F, j + l, (float)k + 0.5F, random.nextFloat() * 360F, 0.0F);
        world.func_674_a(entityendercrystal);
        world.func_690_d(i, j + l, k, Block.field_403_A.field_376_bc);
        return true;
    }
}
