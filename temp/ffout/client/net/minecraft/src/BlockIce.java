// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, World, Block, 
//            EnumSkyBlock, IBlockAccess, EntityPlayer, ItemStack

public class BlockIce extends BlockBreakable
{

    public BlockIce(int i, int j)
    {
        super(i, j, Material.field_1320_r, false);
        field_355_bo = 0.98F;
        func_253_b(true);
    }

    public int func_234_g()
    {
        return 1;
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.func_260_c(iblockaccess, i, j, k, 1 - l);
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.func_220_a_(world, entityplayer, i, j, k, l);
        Material material = world.func_599_f(i, j - 1, k);
        if(material.func_880_c() || material.func_879_d())
        {
            world.func_690_d(i, j, k, Block.field_401_B.field_376_bc);
        }
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.func_641_a(EnumSkyBlock.Block, i, j, k) > 11 - Block.field_341_r[field_376_bc])
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, Block.field_399_C.field_376_bc);
        }
    }

    public int func_31029_h()
    {
        return 0;
    }

    protected ItemStack func_41049_c_(int i)
    {
        return null;
    }
}
