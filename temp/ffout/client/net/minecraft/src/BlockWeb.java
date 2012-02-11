// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Entity, Item, 
//            World, AxisAlignedBB

public class BlockWeb extends Block
{

    public BlockWeb(int i, int j)
    {
        super(i, j, Material.field_31068_A);
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
        entity.func_35112_o();
    }

    public boolean func_217_b()
    {
        return false;
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
    }

    public int func_210_f()
    {
        return 1;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_253_I.field_291_aS;
    }
}
