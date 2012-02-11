// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, World, Block, BlockMycelium, 
//            WorldGenBigMushroom, WorldGenerator

public class BlockMushroom extends BlockFlower
{

    protected BlockMushroom(int i, int j)
    {
        super(i, j);
        float f = 0.2F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        func_253_b(true);
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(random.nextInt(25) == 0)
        {
            byte byte0 = 4;
            int l = 5;
            for(int i1 = i - byte0; i1 <= i + byte0; i1++)
            {
                for(int k1 = k - byte0; k1 <= k + byte0; k1++)
                {
                    for(int i2 = j - 1; i2 <= j + 1; i2++)
                    {
                        if(world.func_600_a(i1, i2, k1) == field_376_bc && --l <= 0)
                        {
                            return;
                        }
                    }

                }

            }

            int j1 = (i + random.nextInt(3)) - 1;
            int l1 = (j + random.nextInt(2)) - random.nextInt(2);
            int j2 = (k + random.nextInt(3)) - 1;
            for(int k2 = 0; k2 < 4; k2++)
            {
                if(world.func_20084_d(j1, l1, j2) && func_223_g(world, j1, l1, j2))
                {
                    i = j1;
                    j = l1;
                    k = j2;
                }
                j1 = (i + random.nextInt(3)) - 1;
                l1 = (j + random.nextInt(2)) - random.nextInt(2);
                j2 = (k + random.nextInt(3)) - 1;
            }

            if(world.func_20084_d(j1, l1, j2) && func_223_g(world, j1, l1, j2))
            {
                world.func_690_d(j1, l1, j2, field_376_bc);
            }
        }
    }

    protected boolean func_269_b(int i)
    {
        return Block.field_343_p[i];
    }

    public boolean func_223_g(World world, int i, int j, int k)
    {
        if(j < 0 || j >= world.field_35472_c)
        {
            return false;
        } else
        {
            int l = world.func_600_a(i, j - 1, k);
            return l == Block.field_40199_bz.field_376_bc || world.func_28104_m(i, j, k) < 13 && func_269_b(l);
        }
    }

    public boolean func_35293_c(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k);
        world.func_634_a(i, j, k, 0);
        WorldGenBigMushroom worldgenbigmushroom = null;
        if(field_376_bc == Block.field_415_ag.field_376_bc)
        {
            worldgenbigmushroom = new WorldGenBigMushroom(0);
        } else
        if(field_376_bc == Block.field_414_ah.field_376_bc)
        {
            worldgenbigmushroom = new WorldGenBigMushroom(1);
        }
        if(worldgenbigmushroom == null || !worldgenbigmushroom.func_516_a(world, random, i, j, k))
        {
            world.func_643_a(i, j, k, field_376_bc, l);
            return false;
        } else
        {
            return true;
        }
    }
}
