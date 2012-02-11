// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, IBlockAccess, World, Material, 
//            AxisAlignedBB

public class BlockPane extends Block
{

    private int field_35300_a;
    private final boolean field_40213_b;

    protected BlockPane(int i, int j, int k, Material material, boolean flag)
    {
        super(i, j, material);
        field_35300_a = k;
        field_40213_b = flag;
    }

    public int func_240_a(int i, Random random, int j)
    {
        if(!field_40213_b)
        {
            return 0;
        } else
        {
            return super.func_240_a(i, random, j);
        }
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
        return 18;
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.func_600_a(i, j, k);
        if(i1 == field_376_bc)
        {
            return false;
        } else
        {
            return super.func_260_c(iblockaccess, i, j, k, l);
        }
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        boolean flag = func_35298_d(world.func_600_a(i, j, k - 1));
        boolean flag1 = func_35298_d(world.func_600_a(i, j, k + 1));
        boolean flag2 = func_35298_d(world.func_600_a(i - 1, j, k));
        boolean flag3 = func_35298_d(world.func_600_a(i + 1, j, k));
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            func_213_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(flag2 && !flag3)
        {
            func_213_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(!flag2 && flag3)
        {
            func_213_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            func_213_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(flag && !flag1)
        {
            func_213_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(!flag && flag1)
        {
            func_213_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        }
    }

    public void func_237_e()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = func_35298_d(iblockaccess.func_600_a(i, j, k - 1));
        boolean flag1 = func_35298_d(iblockaccess.func_600_a(i, j, k + 1));
        boolean flag2 = func_35298_d(iblockaccess.func_600_a(i - 1, j, k));
        boolean flag3 = func_35298_d(iblockaccess.func_600_a(i + 1, j, k));
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            f = 0.0F;
            f1 = 1.0F;
        } else
        if(flag2 && !flag3)
        {
            f = 0.0F;
        } else
        if(!flag2 && flag3)
        {
            f1 = 1.0F;
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            f2 = 0.0F;
            f3 = 1.0F;
        } else
        if(flag && !flag1)
        {
            f2 = 0.0F;
        } else
        if(!flag && flag1)
        {
            f3 = 1.0F;
        }
        func_213_a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public int func_35299_s()
    {
        return field_35300_a;
    }

    public final boolean func_35298_d(int i)
    {
        return Block.field_343_p[i] || i == field_376_bc || i == Block.field_382_N.field_376_bc;
    }
}
