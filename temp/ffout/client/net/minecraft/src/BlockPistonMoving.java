// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, World, TileEntityPiston, 
//            Block, Facing, AxisAlignedBB, IBlockAccess, 
//            TileEntity, EntityPlayer

public class BlockPistonMoving extends BlockContainer
{

    public BlockPistonMoving(int i)
    {
        super(i, Material.field_31067_B);
        func_222_c(-1F);
    }

    public TileEntity func_283_a_()
    {
        return null;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        TileEntity tileentity = world.func_603_b(i, j, k);
        if(tileentity != null && (tileentity instanceof TileEntityPiston))
        {
            ((TileEntityPiston)tileentity).func_31011_l();
        } else
        {
            super.func_214_b(world, i, j, k);
        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return false;
    }

    public boolean func_28030_e(World world, int i, int j, int k, int l)
    {
        return false;
    }

    public int func_210_f()
    {
        return -1;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(!world.field_1026_y && world.func_603_b(i, j, k) == null)
        {
            world.func_690_d(i, j, k, 0);
            return true;
        } else
        {
            return false;
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        return 0;
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        if(world.field_1026_y)
        {
            return;
        }
        TileEntityPiston tileentitypiston = func_31034_c(world, i, j, k);
        if(tileentitypiston == null)
        {
            return;
        } else
        {
            Block.field_345_n[tileentitypiston.func_31016_a()].func_259_b_(world, i, j, k, tileentitypiston.func_479_f(), 0);
            return;
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(!world.field_1026_y)
        {
            if(world.func_603_b(i, j, k) != null);
        }
    }

    public static TileEntity func_31036_a(int i, int j, int k, boolean flag, boolean flag1)
    {
        return new TileEntityPiston(i, j, k, flag, flag1);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        TileEntityPiston tileentitypiston = func_31034_c(world, i, j, k);
        if(tileentitypiston == null)
        {
            return null;
        }
        float f = tileentitypiston.func_31008_a(0.0F);
        if(tileentitypiston.func_31015_b())
        {
            f = 1.0F - f;
        }
        return func_31035_a(world, i, j, k, tileentitypiston.func_31016_a(), f, tileentitypiston.func_31009_d());
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        TileEntityPiston tileentitypiston = func_31034_c(iblockaccess, i, j, k);
        if(tileentitypiston != null)
        {
            Block block = Block.field_345_n[tileentitypiston.func_31016_a()];
            if(block == null || block == this)
            {
                return;
            }
            block.func_238_a(iblockaccess, i, j, k);
            float f = tileentitypiston.func_31008_a(0.0F);
            if(tileentitypiston.func_31015_b())
            {
                f = 1.0F - f;
            }
            int l = tileentitypiston.func_31009_d();
            field_370_bf = block.field_370_bf - (double)((float)Facing.field_31056_b[l] * f);
            field_368_bg = block.field_368_bg - (double)((float)Facing.field_31059_c[l] * f);
            field_366_bh = block.field_366_bh - (double)((float)Facing.field_31058_d[l] * f);
            field_364_bi = block.field_364_bi - (double)((float)Facing.field_31056_b[l] * f);
            field_362_bj = block.field_362_bj - (double)((float)Facing.field_31059_c[l] * f);
            field_360_bk = block.field_360_bk - (double)((float)Facing.field_31058_d[l] * f);
        }
    }

    public AxisAlignedBB func_31035_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        if(l == 0 || l == field_376_bc)
        {
            return null;
        }
        AxisAlignedBB axisalignedbb = Block.field_345_n[l].func_221_d(world, i, j, k);
        if(axisalignedbb == null)
        {
            return null;
        } else
        {
            axisalignedbb.field_1698_a -= (float)Facing.field_31056_b[i1] * f;
            axisalignedbb.field_1703_d -= (float)Facing.field_31056_b[i1] * f;
            axisalignedbb.field_1697_b -= (float)Facing.field_31059_c[i1] * f;
            axisalignedbb.field_1702_e -= (float)Facing.field_31059_c[i1] * f;
            axisalignedbb.field_1704_c -= (float)Facing.field_31058_d[i1] * f;
            axisalignedbb.field_1701_f -= (float)Facing.field_31058_d[i1] * f;
            return axisalignedbb;
        }
    }

    private TileEntityPiston func_31034_c(IBlockAccess iblockaccess, int i, int j, int k)
    {
        TileEntity tileentity = iblockaccess.func_603_b(i, j, k);
        if(tileentity != null && (tileentity instanceof TileEntityPiston))
        {
            return (TileEntityPiston)tileentity;
        } else
        {
            return null;
        }
    }
}
