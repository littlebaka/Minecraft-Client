// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, ItemStack, 
//            World

public class BlockStep extends Block
{

    public static final String field_22037_a[] = {
        "stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick"
    };
    private boolean field_20922_a;

    public BlockStep(int i, boolean flag)
    {
        super(i, 6, Material.field_1334_d);
        field_20922_a = flag;
        if(!flag)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else
        {
            field_343_p[i] = true;
        }
        func_256_d(255);
    }

    public int func_232_a(int i, int j)
    {
        if(j == 0)
        {
            return i > 1 ? 5 : 6;
        }
        if(j == 1)
        {
            if(i == 0)
            {
                return 208;
            }
            return i != 1 ? 192 : 176;
        }
        if(j == 2)
        {
            return 4;
        }
        if(j == 3)
        {
            return 16;
        }
        if(j == 4)
        {
            return Block.field_409_am.field_378_bb;
        }
        if(j == 5)
        {
            return Block.field_35285_bn.field_378_bb;
        } else
        {
            return 6;
        }
    }

    public int func_218_a(int i)
    {
        return func_232_a(i, 0);
    }

    public boolean func_217_b()
    {
        return field_20922_a;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_410_al.field_376_bc;
    }

    public int func_229_a(Random random)
    {
        return !field_20922_a ? 1 : 2;
    }

    protected int func_21025_b(int i)
    {
        return i;
    }

    public boolean func_242_c()
    {
        return field_20922_a;
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(this != Block.field_410_al)
        {
            super.func_260_c(iblockaccess, i, j, k, l);
        }
        if(l == 1)
        {
            return true;
        }
        if(!super.func_260_c(iblockaccess, i, j, k, l))
        {
            return false;
        }
        if(l == 0)
        {
            return true;
        } else
        {
            return iblockaccess.func_600_a(i, j, k) != field_376_bc;
        }
    }

    protected ItemStack func_41049_c_(int i)
    {
        return new ItemStack(Block.field_410_al.field_376_bc, 1, i);
    }

}
