// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, AxisAlignedBB, IBlockAccess, 
//            World

public class BlockFence extends Block
{

    public BlockFence(int i, int j)
    {
        super(i, j, Material.field_1335_c);
    }

    public BlockFence(int i, int j, Material material)
    {
        super(i, j, material);
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return super.func_243_a(world, i, j, k);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        boolean flag = func_35303_f(world, i, j, k - 1);
        boolean flag1 = func_35303_f(world, i, j, k + 1);
        boolean flag2 = func_35303_f(world, i - 1, j, k);
        boolean flag3 = func_35303_f(world, i + 1, j, k);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        if(flag)
        {
            f2 = 0.0F;
        }
        if(flag1)
        {
            f3 = 1.0F;
        }
        if(flag2)
        {
            f = 0.0F;
        }
        if(flag3)
        {
            f1 = 1.0F;
        }
        return AxisAlignedBB.func_1161_b((float)i + f, j, (float)k + f2, (float)i + f1, (float)j + 1.5F, (float)k + f3);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        boolean flag = func_35303_f(iblockaccess, i, j, k - 1);
        boolean flag1 = func_35303_f(iblockaccess, i, j, k + 1);
        boolean flag2 = func_35303_f(iblockaccess, i - 1, j, k);
        boolean flag3 = func_35303_f(iblockaccess, i + 1, j, k);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        if(flag)
        {
            f2 = 0.0F;
        }
        if(flag1)
        {
            f3 = 1.0F;
        }
        if(flag2)
        {
            f = 0.0F;
        }
        if(flag3)
        {
            f1 = 1.0F;
        }
        func_213_a(f, 0.0F, f2, f1, 1.0F, f3);
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
        return 11;
    }

    public boolean func_35303_f(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_600_a(i, j, k);
        if(l == field_376_bc || l == Block.field_35277_bw.field_376_bc)
        {
            return true;
        }
        Block block = Block.field_345_n[l];
        if(block != null && block.field_356_bn.func_28126_h() && block.func_242_c())
        {
            return block.field_356_bn != Material.field_4261_w;
        } else
        {
            return false;
        }
    }
}
