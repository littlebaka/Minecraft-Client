// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, Item, 
//            ItemStack, EntityPlayer, Entity

public class BlockRedstoneOre extends Block
{

    private boolean field_468_a;

    public BlockRedstoneOre(int i, int j, boolean flag)
    {
        super(i, j, Material.field_1334_d);
        if(flag)
        {
            func_253_b(true);
        }
        field_468_a = flag;
    }

    public int func_4025_d()
    {
        return 30;
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_320_h(world, i, j, k);
        super.func_233_b(world, i, j, k, entityplayer);
    }

    public void func_254_a(World world, int i, int j, int k, Entity entity)
    {
        func_320_h(world, i, j, k);
        super.func_254_a(world, i, j, k, entity);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_320_h(world, i, j, k);
        return super.func_250_a(world, i, j, k, entityplayer);
    }

    private void func_320_h(World world, int i, int j, int k)
    {
        func_319_i(world, i, j, k);
        if(field_376_bc == Block.field_433_aO.field_376_bc)
        {
            world.func_690_d(i, j, k, Block.field_432_aP.field_376_bc);
        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(field_376_bc == Block.field_432_aP.field_376_bc)
        {
            world.func_690_d(i, j, k, Block.field_433_aO.field_376_bc);
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_309_aA.field_291_aS;
    }

    public int func_40198_a(int i, Random random)
    {
        return func_229_a(random) + random.nextInt(i + 1);
    }

    public int func_229_a(Random random)
    {
        return 4 + random.nextInt(2);
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        if(field_468_a)
        {
            func_319_i(world, i, j, k);
        }
    }

    private void func_319_i(World world, int i, int j, int k)
    {
        Random random = world.field_1037_n;
        double d = 0.0625D;
        for(int l = 0; l < 6; l++)
        {
            double d1 = (float)i + random.nextFloat();
            double d2 = (float)j + random.nextFloat();
            double d3 = (float)k + random.nextFloat();
            if(l == 0 && !world.func_601_g(i, j + 1, k))
            {
                d2 = (double)(j + 1) + d;
            }
            if(l == 1 && !world.func_601_g(i, j - 1, k))
            {
                d2 = (double)(j + 0) - d;
            }
            if(l == 2 && !world.func_601_g(i, j, k + 1))
            {
                d3 = (double)(k + 1) + d;
            }
            if(l == 3 && !world.func_601_g(i, j, k - 1))
            {
                d3 = (double)(k + 0) - d;
            }
            if(l == 4 && !world.func_601_g(i + 1, j, k))
            {
                d1 = (double)(i + 1) + d;
            }
            if(l == 5 && !world.func_601_g(i - 1, j, k))
            {
                d1 = (double)(i + 0) - d;
            }
            if(d1 < (double)i || d1 > (double)(i + 1) || d2 < 0.0D || d2 > (double)(j + 1) || d3 < (double)k || d3 > (double)(k + 1))
            {
                world.func_694_a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected ItemStack func_41049_c_(int i)
    {
        return new ItemStack(Block.field_433_aO);
    }
}
