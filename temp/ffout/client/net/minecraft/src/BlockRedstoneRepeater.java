// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, IBlockAccess, 
//            EntityLiving, MathHelper, Item, EntityPlayer

public class BlockRedstoneRepeater extends Block
{

    public static final double field_22024_a[] = {
        -0.0625D, 0.0625D, 0.1875D, 0.3125D
    };
    private static final int field_22023_b[] = {
        1, 2, 3, 4
    };
    private final boolean field_22025_c;

    protected BlockRedstoneRepeater(int i, boolean flag)
    {
        super(i, 6, Material.field_1324_n);
        field_22025_c = flag;
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        if(!world.func_28100_h(i, j - 1, k))
        {
            return false;
        } else
        {
            return super.func_243_a(world, i, j, k);
        }
    }

    public boolean func_223_g(World world, int i, int j, int k)
    {
        if(!world.func_28100_h(i, j - 1, k))
        {
            return false;
        } else
        {
            return super.func_223_g(world, i, j, k);
        }
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k);
        boolean flag = func_22022_g(world, i, j, k, l);
        if(field_22025_c && !flag)
        {
            world.func_688_b(i, j, k, Block.field_22021_bh.field_376_bc, l);
        } else
        if(!field_22025_c)
        {
            world.func_688_b(i, j, k, Block.field_22020_bi.field_376_bc, l);
            if(!flag)
            {
                int i1 = (l & 0xc) >> 2;
                world.func_22136_c(i, j, k, Block.field_22020_bi.field_376_bc, field_22023_b[i1] * 2);
            }
        }
    }

    public int func_232_a(int i, int j)
    {
        if(i == 0)
        {
            return !field_22025_c ? 115 : 99;
        }
        if(i == 1)
        {
            return !field_22025_c ? 131 : 147;
        } else
        {
            return 5;
        }
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return l != 0 && l != 1;
    }

    public int func_210_f()
    {
        return 15;
    }

    public int func_218_a(int i)
    {
        return func_232_a(i, 0);
    }

    public boolean func_228_c(World world, int i, int j, int k, int l)
    {
        return func_231_b(world, i, j, k, l);
    }

    public boolean func_231_b(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(!field_22025_c)
        {
            return false;
        }
        int i1 = iblockaccess.func_602_e(i, j, k) & 3;
        if(i1 == 0 && l == 3)
        {
            return true;
        }
        if(i1 == 1 && l == 4)
        {
            return true;
        }
        if(i1 == 2 && l == 2)
        {
            return true;
        }
        return i1 == 3 && l == 5;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(!func_223_g(world, i, j, k))
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
            return;
        }
        int i1 = world.func_602_e(i, j, k);
        boolean flag = func_22022_g(world, i, j, k, i1);
        int j1 = (i1 & 0xc) >> 2;
        if(field_22025_c && !flag)
        {
            world.func_22136_c(i, j, k, field_376_bc, field_22023_b[j1] * 2);
        } else
        if(!field_22025_c && flag)
        {
            world.func_22136_c(i, j, k, field_376_bc, field_22023_b[j1] * 2);
        }
    }

    private boolean func_22022_g(World world, int i, int j, int k, int l)
    {
        int i1 = l & 3;
        switch(i1)
        {
        case 0: // '\0'
            return world.func_706_k(i, j, k + 1, 3) || world.func_600_a(i, j, k + 1) == Block.field_394_aw.field_376_bc && world.func_602_e(i, j, k + 1) > 0;

        case 2: // '\002'
            return world.func_706_k(i, j, k - 1, 2) || world.func_600_a(i, j, k - 1) == Block.field_394_aw.field_376_bc && world.func_602_e(i, j, k - 1) > 0;

        case 3: // '\003'
            return world.func_706_k(i + 1, j, k, 5) || world.func_600_a(i + 1, j, k) == Block.field_394_aw.field_376_bc && world.func_602_e(i + 1, j, k) > 0;

        case 1: // '\001'
            return world.func_706_k(i - 1, j, k, 4) || world.func_600_a(i - 1, j, k) == Block.field_394_aw.field_376_bc && world.func_602_e(i - 1, j, k) > 0;
        }
        return false;
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        int l = world.func_602_e(i, j, k);
        int i1 = (l & 0xc) >> 2;
        i1 = i1 + 1 << 2 & 0xc;
        world.func_691_b(i, j, k, i1 | l & 3);
        return true;
    }

    public boolean func_209_d()
    {
        return true;
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = ((MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 0.5D) & 3) + 2) % 4;
        world.func_691_b(i, j, k, l);
        boolean flag = func_22022_g(world, i, j, k, l);
        if(flag)
        {
            world.func_22136_c(i, j, k, field_376_bc, 1);
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        world.func_611_g(i + 1, j, k, field_376_bc);
        world.func_611_g(i - 1, j, k, field_376_bc);
        world.func_611_g(i, j, k + 1, field_376_bc);
        world.func_611_g(i, j, k - 1, field_376_bc);
        world.func_611_g(i, j - 1, k, field_376_bc);
        world.func_611_g(i, j + 1, k, field_376_bc);
    }

    public void func_252_b(World world, int i, int j, int k, int l)
    {
        if(field_22025_c)
        {
            world.func_611_g(i, j + 1, k, field_376_bc);
        }
        super.func_252_b(world, i, j, k, l);
    }

    public boolean func_217_b()
    {
        return false;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_22018_aZ.field_291_aS;
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        if(!field_22025_c)
        {
            return;
        }
        int l = world.func_602_e(i, j, k);
        double d = (double)((float)i + 0.5F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d1 = (double)((float)j + 0.4F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d2 = (double)((float)k + 0.5F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        if(random.nextInt(2) == 0)
        {
            switch(l & 3)
            {
            case 0: // '\0'
                d4 = -0.3125D;
                break;

            case 2: // '\002'
                d4 = 0.3125D;
                break;

            case 3: // '\003'
                d3 = -0.3125D;
                break;

            case 1: // '\001'
                d3 = 0.3125D;
                break;
            }
        } else
        {
            int i1 = (l & 0xc) >> 2;
            switch(l & 3)
            {
            case 0: // '\0'
                d4 = field_22024_a[i1];
                break;

            case 2: // '\002'
                d4 = -field_22024_a[i1];
                break;

            case 3: // '\003'
                d3 = field_22024_a[i1];
                break;

            case 1: // '\001'
                d3 = -field_22024_a[i1];
                break;
            }
        }
        world.func_694_a("reddust", d + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
    }

}
