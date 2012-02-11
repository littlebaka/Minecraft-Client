// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AxisAlignedBB, World, 
//            Entity

public class BlockFarmland extends Block
{

    protected BlockFarmland(int i)
    {
        super(i, Material.field_1336_b);
        field_378_bb = 87;
        func_253_b(true);
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        func_256_d(255);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return AxisAlignedBB.func_1161_b(i + 0, j + 0, k + 0, i + 1, j + 1, k + 1);
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1 && j > 0)
        {
            return field_378_bb - 1;
        }
        if(i == 1)
        {
            return field_378_bb;
        } else
        {
            return 2;
        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(func_274_i(world, i, j, k) || world.func_27167_r(i, j + 1, k))
        {
            world.func_691_b(i, j, k, 7);
        } else
        {
            int l = world.func_602_e(i, j, k);
            if(l > 0)
            {
                world.func_691_b(i, j, k, l - 1);
            } else
            if(!func_275_h(world, i, j, k))
            {
                world.func_690_d(i, j, k, Block.field_336_w.field_376_bc);
            }
        }
    }

    public void func_43001_a(World world, int i, int j, int k, Entity entity, float f)
    {
        if(world.field_1037_n.nextFloat() < f - 0.5F)
        {
            world.func_690_d(i, j, k, Block.field_336_w.field_376_bc);
        }
    }

    private boolean func_275_h(World world, int i, int j, int k)
    {
        int l = 0;
        for(int i1 = i - l; i1 <= i + l; i1++)
        {
            for(int j1 = k - l; j1 <= k + l; j1++)
            {
                int k1 = world.func_600_a(i1, j + 1, j1);
                if(k1 == Block.field_447_aA.field_376_bc || k1 == Block.field_35283_bu.field_376_bc || k1 == Block.field_35284_bt.field_376_bc)
                {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean func_274_i(World world, int i, int j, int k)
    {
        for(int l = i - 4; l <= i + 4; l++)
        {
            for(int i1 = j; i1 <= j + 1; i1++)
            {
                for(int j1 = k - 4; j1 <= k + 4; j1++)
                {
                    if(world.func_599_f(l, i1, j1) == Material.field_1332_f)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        super.func_226_a(world, i, j, k, l);
        Material material = world.func_599_f(i, j + 1, k);
        if(material.func_878_a())
        {
            world.func_690_d(i, j, k, Block.field_336_w.field_376_bc);
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_336_w.func_240_a(0, random, j);
    }
}
