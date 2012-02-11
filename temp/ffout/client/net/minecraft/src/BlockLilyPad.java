// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BlockFlower, AxisAlignedBB, Block, World, 
//            Material, IBlockAccess

public class BlockLilyPad extends BlockFlower
{

    protected BlockLilyPad(int i, int j)
    {
        super(i, j);
        float f = 0.5F;
        float f1 = 0.015625F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public int func_210_f()
    {
        return 23;
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return AxisAlignedBB.func_1161_b((double)i + field_370_bf, (double)j + field_368_bg, (double)k + field_366_bh, (double)i + field_364_bi, (double)j + field_362_bj, (double)k + field_360_bk);
    }

    public int func_35274_i()
    {
        return 0x208030;
    }

    public int func_31030_b(int i)
    {
        return 0x208030;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return super.func_243_a(world, i, j, k);
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return 0x208030;
    }

    protected boolean func_269_b(int i)
    {
        return i == Block.field_399_C.field_376_bc;
    }

    public boolean func_223_g(World world, int i, int j, int k)
    {
        if(j < 0 || j >= world.field_35472_c)
        {
            return false;
        } else
        {
            return world.func_599_f(i, j - 1, k) == Material.field_1332_f && world.func_602_e(i, j - 1, k) == 0;
        }
    }
}
