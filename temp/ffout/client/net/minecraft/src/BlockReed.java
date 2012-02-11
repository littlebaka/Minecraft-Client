// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockGrass, 
//            Item, AxisAlignedBB

public class BlockReed extends Block
{

    protected BlockReed(int i, int j)
    {
        super(i, Material.field_1329_i);
        field_378_bb = j;
        float f = 0.375F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        func_253_b(true);
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.func_20084_d(i, j + 1, k))
        {
            int l;
            for(l = 1; world.func_600_a(i, j - l, k) == field_376_bc; l++) { }
            if(l < 3)
            {
                int i1 = world.func_602_e(i, j, k);
                if(i1 == 15)
                {
                    world.func_690_d(i, j + 1, k, field_376_bc);
                    world.func_691_b(i, j, k, 0);
                } else
                {
                    world.func_691_b(i, j, k, i1 + 1);
                }
            }
        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        int l = world.func_600_a(i, j - 1, k);
        if(l == field_376_bc)
        {
            return true;
        }
        if(l != Block.field_337_v.field_376_bc && l != Block.field_336_w.field_376_bc && l != Block.field_393_F.field_376_bc)
        {
            return false;
        }
        if(world.func_599_f(i - 1, j - 1, k) == Material.field_1332_f)
        {
            return true;
        }
        if(world.func_599_f(i + 1, j - 1, k) == Material.field_1332_f)
        {
            return true;
        }
        if(world.func_599_f(i, j - 1, k - 1) == Material.field_1332_f)
        {
            return true;
        }
        return world.func_599_f(i, j - 1, k + 1) == Material.field_1332_f;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        func_303_h(world, i, j, k);
    }

    protected final void func_303_h(World world, int i, int j, int k)
    {
        if(!func_223_g(world, i, j, k))
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
        }
    }

    public boolean func_223_g(World world, int i, int j, int k)
    {
        return func_243_a(world, i, j, k);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_302_aH.field_291_aS;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_210_f()
    {
        return 1;
    }
}
