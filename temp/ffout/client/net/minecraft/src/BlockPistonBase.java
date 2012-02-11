// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Facing, EntityPlayer, 
//            World, TileEntityPiston, BlockPistonMoving, IBlockAccess, 
//            MathHelper, BlockContainer, BlockPistonExtension, EntityLiving, 
//            AxisAlignedBB

public class BlockPistonBase extends Block
{

    private boolean field_31049_a;
    private static boolean field_31048_b;

    public BlockPistonBase(int i, int j, boolean flag)
    {
        super(i, j, Material.field_31067_B);
        field_31049_a = flag;
        func_4024_a(field_9251_h);
        func_222_c(0.5F);
    }

    public int func_31040_i()
    {
        return !field_31049_a ? 107 : 106;
    }

    public int func_232_a(int i, int j)
    {
        int k = func_31044_d(j);
        if(k > 5)
        {
            return field_378_bb;
        }
        if(i == k)
        {
            if(func_31046_e(j) || field_370_bf > 0.0D || field_368_bg > 0.0D || field_366_bh > 0.0D || field_364_bi < 1.0D || field_362_bj < 1.0D || field_360_bk < 1.0D)
            {
                return 110;
            } else
            {
                return field_378_bb;
            }
        }
        return i != Facing.field_31057_a[k] ? 108 : 109;
    }

    public int func_210_f()
    {
        return 16;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return false;
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = func_31039_c(world, i, j, k, (EntityPlayer)entityliving);
        world.func_691_b(i, j, k, l);
        if(!world.field_1026_y && !field_31048_b)
        {
            func_31043_h(world, i, j, k);
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(!world.field_1026_y && !field_31048_b)
        {
            func_31043_h(world, i, j, k);
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        if(!world.field_1026_y && world.func_603_b(i, j, k) == null && !field_31048_b)
        {
            func_31043_h(world, i, j, k);
        }
    }

    private void func_31043_h(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        int i1 = func_31044_d(l);
        boolean flag = func_31041_f(world, i, j, k, i1);
        if(l == 7)
        {
            return;
        }
        if(flag && !func_31046_e(l))
        {
            if(func_31045_h(world, i, j, k, i1))
            {
                world.func_635_c(i, j, k, i1 | 8);
                world.func_21116_c(i, j, k, 0, i1);
            }
        } else
        if(!flag && func_31046_e(l))
        {
            world.func_635_c(i, j, k, i1);
            world.func_21116_c(i, j, k, 1, i1);
        }
    }

    private boolean func_31041_f(World world, int i, int j, int k, int l)
    {
        if(l != 0 && world.func_706_k(i, j - 1, k, 0))
        {
            return true;
        }
        if(l != 1 && world.func_706_k(i, j + 1, k, 1))
        {
            return true;
        }
        if(l != 2 && world.func_706_k(i, j, k - 1, 2))
        {
            return true;
        }
        if(l != 3 && world.func_706_k(i, j, k + 1, 3))
        {
            return true;
        }
        if(l != 5 && world.func_706_k(i + 1, j, k, 5))
        {
            return true;
        }
        if(l != 4 && world.func_706_k(i - 1, j, k, 4))
        {
            return true;
        }
        if(world.func_706_k(i, j, k, 0))
        {
            return true;
        }
        if(world.func_706_k(i, j + 2, k, 1))
        {
            return true;
        }
        if(world.func_706_k(i, j + 1, k - 1, 2))
        {
            return true;
        }
        if(world.func_706_k(i, j + 1, k + 1, 3))
        {
            return true;
        }
        if(world.func_706_k(i - 1, j + 1, k, 4))
        {
            return true;
        }
        return world.func_706_k(i + 1, j + 1, k, 5);
    }

    public void func_21024_a(World world, int i, int j, int k, int l, int i1)
    {
        field_31048_b = true;
        int j1 = i1;
        if(l == 0)
        {
            if(func_31047_i(world, i, j, k, j1))
            {
                world.func_691_b(i, j, k, j1 | 8);
                world.func_684_a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "tile.piston.out", 0.5F, world.field_1037_n.nextFloat() * 0.25F + 0.6F);
            } else
            {
                world.func_635_c(i, j, k, j1);
            }
        } else
        if(l == 1)
        {
            TileEntity tileentity = world.func_603_b(i + Facing.field_31056_b[j1], j + Facing.field_31059_c[j1], k + Facing.field_31058_d[j1]);
            if(tileentity != null && (tileentity instanceof TileEntityPiston))
            {
                ((TileEntityPiston)tileentity).func_31011_l();
            }
            world.func_643_a(i, j, k, Block.field_9268_ac.field_376_bc, j1);
            world.func_654_a(i, j, k, BlockPistonMoving.func_31036_a(field_376_bc, j1, j1, false, true));
            if(field_31049_a)
            {
                int k1 = i + Facing.field_31056_b[j1] * 2;
                int l1 = j + Facing.field_31059_c[j1] * 2;
                int i2 = k + Facing.field_31058_d[j1] * 2;
                int j2 = world.func_600_a(k1, l1, i2);
                int k2 = world.func_602_e(k1, l1, i2);
                boolean flag = false;
                if(j2 == Block.field_9268_ac.field_376_bc)
                {
                    TileEntity tileentity1 = world.func_603_b(k1, l1, i2);
                    if(tileentity1 != null && (tileentity1 instanceof TileEntityPiston))
                    {
                        TileEntityPiston tileentitypiston = (TileEntityPiston)tileentity1;
                        if(tileentitypiston.func_31009_d() == j1 && tileentitypiston.func_31015_b())
                        {
                            tileentitypiston.func_31011_l();
                            j2 = tileentitypiston.func_31016_a();
                            k2 = tileentitypiston.func_479_f();
                            flag = true;
                        }
                    }
                }
                if(!flag && j2 > 0 && func_31042_a(j2, world, k1, l1, i2, false) && (Block.field_345_n[j2].func_31029_h() == 0 || j2 == Block.field_9255_Z.field_376_bc || j2 == Block.field_9259_V.field_376_bc))
                {
                    i += Facing.field_31056_b[j1];
                    j += Facing.field_31059_c[j1];
                    k += Facing.field_31058_d[j1];
                    world.func_643_a(i, j, k, Block.field_9268_ac.field_376_bc, k2);
                    world.func_654_a(i, j, k, BlockPistonMoving.func_31036_a(j2, k2, j1, false, false));
                    field_31048_b = false;
                    world.func_690_d(k1, l1, i2, 0);
                    field_31048_b = true;
                } else
                if(!flag)
                {
                    field_31048_b = false;
                    world.func_690_d(i + Facing.field_31056_b[j1], j + Facing.field_31059_c[j1], k + Facing.field_31058_d[j1], 0);
                    field_31048_b = true;
                }
            } else
            {
                field_31048_b = false;
                world.func_690_d(i + Facing.field_31056_b[j1], j + Facing.field_31059_c[j1], k + Facing.field_31058_d[j1], 0);
                field_31048_b = true;
            }
            world.func_684_a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "tile.piston.in", 0.5F, world.field_1037_n.nextFloat() * 0.15F + 0.6F);
        }
        field_31048_b = false;
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        if(func_31046_e(l))
        {
            switch(func_31044_d(l))
            {
            case 0: // '\0'
                func_213_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 1: // '\001'
                func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;

            case 2: // '\002'
                func_213_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;

            case 3: // '\003'
                func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;

            case 4: // '\004'
                func_213_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 5: // '\005'
                func_213_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
                break;
            }
        } else
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void func_237_e()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
    }

    public boolean func_242_c()
    {
        return false;
    }

    public static int func_31044_d(int i)
    {
        return i & 7;
    }

    public static boolean func_31046_e(int i)
    {
        return (i & 8) != 0;
    }

    private static int func_31039_c(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(MathHelper.func_1112_e((float)entityplayer.field_611_ak - (float)i) < 2.0F && MathHelper.func_1112_e((float)entityplayer.field_609_am - (float)k) < 2.0F)
        {
            double d = (entityplayer.field_610_al + 1.8200000000000001D) - (double)entityplayer.field_9292_aO;
            if(d - (double)j > 2D)
            {
                return 1;
            }
            if((double)j - d > 0.0D)
            {
                return 0;
            }
        }
        int l = MathHelper.func_1108_b((double)((entityplayer.field_605_aq * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
            return 2;
        }
        if(l == 1)
        {
            return 5;
        }
        if(l == 2)
        {
            return 3;
        }
        return l != 3 ? 0 : 4;
    }

    private static boolean func_31042_a(int i, World world, int j, int k, int l, boolean flag)
    {
        if(i == Block.field_405_aq.field_376_bc)
        {
            return false;
        }
        if(i == Block.field_9255_Z.field_376_bc || i == Block.field_9259_V.field_376_bc)
        {
            if(func_31046_e(world.func_602_e(j, k, l)))
            {
                return false;
            }
        } else
        {
            if(Block.field_345_n[i].func_31031_m() == -1F)
            {
                return false;
            }
            if(Block.field_345_n[i].func_31029_h() == 2)
            {
                return false;
            }
            if(!flag && Block.field_345_n[i].func_31029_h() == 1)
            {
                return false;
            }
        }
        return !(Block.field_345_n[i] instanceof BlockContainer);
    }

    private static boolean func_31045_h(World world, int i, int j, int k, int l)
    {
        int i1 = i + Facing.field_31056_b[l];
        int j1 = j + Facing.field_31059_c[l];
        int k1 = k + Facing.field_31058_d[l];
        int l1 = 0;
        do
        {
            if(l1 >= 13)
            {
                break;
            }
            if(j1 <= 0 || j1 >= world.field_35472_c - 1)
            {
                return false;
            }
            int i2 = world.func_600_a(i1, j1, k1);
            if(i2 == 0)
            {
                break;
            }
            if(!func_31042_a(i2, world, i1, j1, k1, true))
            {
                return false;
            }
            if(Block.field_345_n[i2].func_31029_h() == 1)
            {
                break;
            }
            if(l1 == 12)
            {
                return false;
            }
            i1 += Facing.field_31056_b[l];
            j1 += Facing.field_31059_c[l];
            k1 += Facing.field_31058_d[l];
            l1++;
        } while(true);
        return true;
    }

    private boolean func_31047_i(World world, int i, int j, int k, int l)
    {
        int i1 = i + Facing.field_31056_b[l];
        int j1 = j + Facing.field_31059_c[l];
        int k1 = k + Facing.field_31058_d[l];
        int l1 = 0;
        do
        {
            if(l1 >= 13)
            {
                break;
            }
            if(j1 <= 0 || j1 >= world.field_35472_c - 1)
            {
                return false;
            }
            int j2 = world.func_600_a(i1, j1, k1);
            if(j2 == 0)
            {
                break;
            }
            if(!func_31042_a(j2, world, i1, j1, k1, true))
            {
                return false;
            }
            if(Block.field_345_n[j2].func_31029_h() == 1)
            {
                Block.field_345_n[j2].func_259_b_(world, i1, j1, k1, world.func_602_e(i1, j1, k1), 0);
                world.func_690_d(i1, j1, k1, 0);
                break;
            }
            if(l1 == 12)
            {
                return false;
            }
            i1 += Facing.field_31056_b[l];
            j1 += Facing.field_31059_c[l];
            k1 += Facing.field_31058_d[l];
            l1++;
        } while(true);
        int l2;
        for(; i1 != i || j1 != j || k1 != k; k1 = l2)
        {
            int i2 = i1 - Facing.field_31056_b[l];
            int k2 = j1 - Facing.field_31059_c[l];
            l2 = k1 - Facing.field_31058_d[l];
            int i3 = world.func_600_a(i2, k2, l2);
            int j3 = world.func_602_e(i2, k2, l2);
            if(i3 == field_376_bc && i2 == i && k2 == j && l2 == k)
            {
                world.func_643_a(i1, j1, k1, Block.field_9268_ac.field_376_bc, l | (field_31049_a ? 8 : 0));
                world.func_654_a(i1, j1, k1, BlockPistonMoving.func_31036_a(Block.field_9269_aa.field_376_bc, l | (field_31049_a ? 8 : 0), l, true, false));
            } else
            {
                world.func_643_a(i1, j1, k1, Block.field_9268_ac.field_376_bc, j3);
                world.func_654_a(i1, j1, k1, BlockPistonMoving.func_31036_a(i3, j3, l, true, false));
            }
            i1 = i2;
            j1 = k2;
        }

        return true;
    }
}
