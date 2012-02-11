// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, IBlockAccess, World, 
//            Block, BlockFire, Entity, AxisAlignedBB

public class BlockPortal extends BlockBreakable
{

    public BlockPortal(int i, int j)
    {
        super(i, j, Material.field_4260_x, false);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        if(iblockaccess.func_600_a(i - 1, j, k) == field_376_bc || iblockaccess.func_600_a(i + 1, j, k) == field_376_bc)
        {
            float f = 0.5F;
            float f2 = 0.125F;
            func_213_a(0.5F - f, 0.0F, 0.5F - f2, 0.5F + f, 1.0F, 0.5F + f2);
        } else
        {
            float f1 = 0.125F;
            float f3 = 0.5F;
            func_213_a(0.5F - f1, 0.0F, 0.5F - f3, 0.5F + f1, 1.0F, 0.5F + f3);
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

    public boolean func_4032_a_(World world, int i, int j, int k)
    {
        int l = 0;
        int i1 = 0;
        if(world.func_600_a(i - 1, j, k) == Block.field_405_aq.field_376_bc || world.func_600_a(i + 1, j, k) == Block.field_405_aq.field_376_bc)
        {
            l = 1;
        }
        if(world.func_600_a(i, j, k - 1) == Block.field_405_aq.field_376_bc || world.func_600_a(i, j, k + 1) == Block.field_405_aq.field_376_bc)
        {
            i1 = 1;
        }
        if(l == i1)
        {
            return false;
        }
        if(world.func_600_a(i - l, j, k - i1) == 0)
        {
            i -= l;
            k -= i1;
        }
        for(int j1 = -1; j1 <= 2; j1++)
        {
            for(int l1 = -1; l1 <= 3; l1++)
            {
                boolean flag = j1 == -1 || j1 == 2 || l1 == -1 || l1 == 3;
                if((j1 == -1 || j1 == 2) && (l1 == -1 || l1 == 3))
                {
                    continue;
                }
                int j2 = world.func_600_a(i + l * j1, j + l1, k + i1 * j1);
                if(flag)
                {
                    if(j2 != Block.field_405_aq.field_376_bc)
                    {
                        return false;
                    }
                    continue;
                }
                if(j2 != 0 && j2 != Block.field_402_as.field_376_bc)
                {
                    return false;
                }
            }

        }

        world.field_1043_h = true;
        for(int k1 = 0; k1 < 2; k1++)
        {
            for(int i2 = 0; i2 < 3; i2++)
            {
                world.func_690_d(i + l * k1, j + i2, k + i1 * k1, Block.field_4047_bf.field_376_bc);
            }

        }

        world.field_1043_h = false;
        return true;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        int i1 = 0;
        int j1 = 1;
        if(world.func_600_a(i - 1, j, k) == field_376_bc || world.func_600_a(i + 1, j, k) == field_376_bc)
        {
            i1 = 1;
            j1 = 0;
        }
        int k1;
        for(k1 = j; world.func_600_a(i, k1 - 1, k) == field_376_bc; k1--) { }
        if(world.func_600_a(i, k1 - 1, k) != Block.field_405_aq.field_376_bc)
        {
            world.func_690_d(i, j, k, 0);
            return;
        }
        int l1;
        for(l1 = 1; l1 < 4 && world.func_600_a(i, k1 + l1, k) == field_376_bc; l1++) { }
        if(l1 != 3 || world.func_600_a(i, k1 + l1, k) != Block.field_405_aq.field_376_bc)
        {
            world.func_690_d(i, j, k, 0);
            return;
        }
        boolean flag = world.func_600_a(i - 1, j, k) == field_376_bc || world.func_600_a(i + 1, j, k) == field_376_bc;
        boolean flag1 = world.func_600_a(i, j, k - 1) == field_376_bc || world.func_600_a(i, j, k + 1) == field_376_bc;
        if(flag && flag1)
        {
            world.func_690_d(i, j, k, 0);
            return;
        }
        if((world.func_600_a(i + i1, j, k + j1) != Block.field_405_aq.field_376_bc || world.func_600_a(i - i1, j, k - j1) != field_376_bc) && (world.func_600_a(i - i1, j, k - j1) != Block.field_405_aq.field_376_bc || world.func_600_a(i + i1, j, k + j1) != field_376_bc))
        {
            world.func_690_d(i, j, k, 0);
            return;
        } else
        {
            return;
        }
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(iblockaccess.func_600_a(i, j, k) == field_376_bc)
        {
            return false;
        }
        boolean flag = iblockaccess.func_600_a(i - 1, j, k) == field_376_bc && iblockaccess.func_600_a(i - 2, j, k) != field_376_bc;
        boolean flag1 = iblockaccess.func_600_a(i + 1, j, k) == field_376_bc && iblockaccess.func_600_a(i + 2, j, k) != field_376_bc;
        boolean flag2 = iblockaccess.func_600_a(i, j, k - 1) == field_376_bc && iblockaccess.func_600_a(i, j, k - 2) != field_376_bc;
        boolean flag3 = iblockaccess.func_600_a(i, j, k + 1) == field_376_bc && iblockaccess.func_600_a(i, j, k + 2) != field_376_bc;
        boolean flag4 = flag || flag1;
        boolean flag5 = flag2 || flag3;
        if(flag4 && l == 4)
        {
            return true;
        }
        if(flag4 && l == 5)
        {
            return true;
        }
        if(flag5 && l == 2)
        {
            return true;
        }
        return flag5 && l == 3;
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public int func_234_g()
    {
        return 1;
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
        if(entity.field_616_af == null && entity.field_617_ae == null)
        {
            entity.func_4039_q();
        }
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        if(random.nextInt(100) == 0)
        {
            world.func_684_a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "portal.portal", 0.5F, random.nextFloat() * 0.4F + 0.8F);
        }
        for(int l = 0; l < 4; l++)
        {
            double d = (float)i + random.nextFloat();
            double d1 = (float)j + random.nextFloat();
            double d2 = (float)k + random.nextFloat();
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = random.nextInt(2) * 2 - 1;
            d3 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            if(world.func_600_a(i - 1, j, k) == field_376_bc || world.func_600_a(i + 1, j, k) == field_376_bc)
            {
                d2 = (double)k + 0.5D + 0.25D * (double)i1;
                d5 = random.nextFloat() * 2.0F * (float)i1;
            } else
            {
                d = (double)i + 0.5D + 0.25D * (double)i1;
                d3 = random.nextFloat() * 2.0F * (float)i1;
            }
            world.func_694_a("portal", d, d1, d2, d3, d4, d5);
        }

    }
}
