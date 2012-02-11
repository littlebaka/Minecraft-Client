// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, World, AxisAlignedBB, 
//            IBlockAccess, EntityLiving, MathHelper, EntityPlayer

public class BlockFenceGate extends Block
{

    public BlockFenceGate(int i, int j)
    {
        super(i, j, Material.field_1335_c);
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        if(!world.func_599_f(i, j - 1, k).func_878_a())
        {
            return false;
        } else
        {
            return super.func_243_a(world, i, j, k);
        }
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        if(func_35291_d(l))
        {
            return null;
        }
        if(l == 2 || l == 0)
        {
            return AxisAlignedBB.func_1161_b(i, j, (float)k + 0.375F, i + 1, (float)j + 1.5F, (float)k + 0.625F);
        } else
        {
            return AxisAlignedBB.func_1161_b((float)i + 0.375F, j, k, (float)i + 0.625F, (float)j + 1.5F, k + 1);
        }
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = func_35290_f(iblockaccess.func_602_e(i, j, k));
        if(l == 2 || l == 0)
        {
            func_213_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
        } else
        {
            func_213_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
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
        return 21;
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = (MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 0.5D) & 3) % 4;
        world.func_691_b(i, j, k, l);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        int l = world.func_602_e(i, j, k);
        if(func_35291_d(l))
        {
            world.func_691_b(i, j, k, l & -5);
        } else
        {
            int i1 = (MathHelper.func_1108_b((double)((entityplayer.field_605_aq * 4F) / 360F) + 0.5D) & 3) % 4;
            int j1 = func_35290_f(l);
            if(j1 == (i1 + 2) % 4)
            {
                l = i1;
            }
            world.func_691_b(i, j, k, l | 4);
        }
        world.func_28107_a(entityplayer, 1003, i, j, k, 0);
        return true;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int i1 = world.func_602_e(i, j, k);
        boolean flag = world.func_625_o(i, j, k);
        if(flag || l > 0 && Block.field_345_n[l].func_209_d() || l == 0)
        {
            if(flag && !func_35291_d(i1))
            {
                world.func_691_b(i, j, k, i1 | 4);
                world.func_28107_a(null, 1003, i, j, k, 0);
            } else
            if(!flag && func_35291_d(i1))
            {
                world.func_691_b(i, j, k, i1 & -5);
                world.func_28107_a(null, 1003, i, j, k, 0);
            }
        }
    }

    public static boolean func_35291_d(int i)
    {
        return (i & 4) != 0;
    }

    public static int func_35290_f(int i)
    {
        return i & 3;
    }
}
