// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class WorldGenGlowStone2 extends WorldGenerator
{

    public WorldGenGlowStone2()
    {
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        if(!world.func_20084_d(i, j, k))
        {
            return false;
        }
        if(world.func_600_a(i, j + 1, k) != Block.field_4053_bc.field_376_bc)
        {
            return false;
        }
        world.func_690_d(i, j, k, Block.field_4049_be.field_376_bc);
        for(int l = 0; l < 1500; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = j - random.nextInt(12);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(world.func_600_a(i1, j1, k1) != 0)
            {
                continue;
            }
            int l1 = 0;
            for(int i2 = 0; i2 < 6; i2++)
            {
                int j2 = 0;
                if(i2 == 0)
                {
                    j2 = world.func_600_a(i1 - 1, j1, k1);
                }
                if(i2 == 1)
                {
                    j2 = world.func_600_a(i1 + 1, j1, k1);
                }
                if(i2 == 2)
                {
                    j2 = world.func_600_a(i1, j1 - 1, k1);
                }
                if(i2 == 3)
                {
                    j2 = world.func_600_a(i1, j1 + 1, k1);
                }
                if(i2 == 4)
                {
                    j2 = world.func_600_a(i1, j1, k1 - 1);
                }
                if(i2 == 5)
                {
                    j2 = world.func_600_a(i1, j1, k1 + 1);
                }
                if(j2 == Block.field_4049_be.field_376_bc)
                {
                    l1++;
                }
            }

            if(l1 == 1)
            {
                world.func_690_d(i1, j1, k1, Block.field_4049_be.field_376_bc);
            }
        }

        return true;
    }
}
