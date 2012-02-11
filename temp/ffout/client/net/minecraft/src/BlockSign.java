// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, IBlockAccess, TileEntity, 
//            Item, World, AxisAlignedBB

public class BlockSign extends BlockContainer
{

    private Class field_455_a;
    private boolean field_454_b;

    protected BlockSign(int i, Class class1, boolean flag)
    {
        super(i, Material.field_1335_c);
        field_454_b = flag;
        field_378_bb = 4;
        field_455_a = class1;
        float f = 0.25F;
        float f1 = 1.0F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
    }

    public AxisAlignedBB func_246_f(World world, int i, int j, int k)
    {
        func_238_a(world, i, j, k);
        return super.func_246_f(world, i, j, k);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        if(field_454_b)
        {
            return;
        }
        int l = iblockaccess.func_602_e(i, j, k);
        float f = 0.28125F;
        float f1 = 0.78125F;
        float f2 = 0.0F;
        float f3 = 1.0F;
        float f4 = 0.125F;
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if(l == 2)
        {
            func_213_a(f2, f, 1.0F - f4, f3, f1, 1.0F);
        }
        if(l == 3)
        {
            func_213_a(f2, f, 0.0F, f3, f1, f4);
        }
        if(l == 4)
        {
            func_213_a(1.0F - f4, f, f2, 1.0F, f1, f3);
        }
        if(l == 5)
        {
            func_213_a(0.0F, f, f2, f4, f1, f3);
        }
    }

    public int func_210_f()
    {
        return -1;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public TileEntity func_283_a_()
    {
        try
        {
            return (TileEntity)field_455_a.newInstance();
        }
        catch(Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_267_as.field_291_aS;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        boolean flag = false;
        if(field_454_b)
        {
            if(!world.func_599_f(i, j - 1, k).func_878_a())
            {
                flag = true;
            }
        } else
        {
            int i1 = world.func_602_e(i, j, k);
            flag = true;
            if(i1 == 2 && world.func_599_f(i, j, k + 1).func_878_a())
            {
                flag = false;
            }
            if(i1 == 3 && world.func_599_f(i, j, k - 1).func_878_a())
            {
                flag = false;
            }
            if(i1 == 4 && world.func_599_f(i + 1, j, k).func_878_a())
            {
                flag = false;
            }
            if(i1 == 5 && world.func_599_f(i - 1, j, k).func_878_a())
            {
                flag = false;
            }
        }
        if(flag)
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
        }
        super.func_226_a(world, i, j, k, l);
    }
}
