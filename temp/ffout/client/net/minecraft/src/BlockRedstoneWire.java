// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, ChunkPosition, 
//            Item, IBlockAccess, Direction, AxisAlignedBB

public class BlockRedstoneWire extends Block
{

    private boolean field_453_a;
    private Set field_21031_b;

    public BlockRedstoneWire(int i, int j)
    {
        super(i, j, Material.field_1324_n);
        field_453_a = true;
        field_21031_b = new HashSet();
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public int func_232_a(int i, int j)
    {
        return field_378_bb;
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
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
        return 5;
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return 0x800000;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return world.func_28100_h(i, j - 1, k);
    }

    private void func_280_h(World world, int i, int j, int k)
    {
        func_21030_a(world, i, j, k, i, j, k);
        ArrayList arraylist = new ArrayList(field_21031_b);
        field_21031_b.clear();
        for(int l = 0; l < arraylist.size(); l++)
        {
            ChunkPosition chunkposition = (ChunkPosition)arraylist.get(l);
            world.func_611_g(chunkposition.field_1111_a, chunkposition.field_1110_b, chunkposition.field_1112_c, field_376_bc);
        }

    }

    private void func_21030_a(World world, int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = world.func_602_e(i, j, k);
        int l1 = 0;
        field_453_a = false;
        boolean flag = world.func_625_o(i, j, k);
        field_453_a = true;
        if(flag)
        {
            l1 = 15;
        } else
        {
            for(int i2 = 0; i2 < 4; i2++)
            {
                int k2 = i;
                int i3 = k;
                if(i2 == 0)
                {
                    k2--;
                }
                if(i2 == 1)
                {
                    k2++;
                }
                if(i2 == 2)
                {
                    i3--;
                }
                if(i2 == 3)
                {
                    i3++;
                }
                if(k2 != l || j != i1 || i3 != j1)
                {
                    l1 = func_281_g(world, k2, j, i3, l1);
                }
                if(world.func_28100_h(k2, j, i3) && !world.func_28100_h(i, j + 1, k))
                {
                    if(k2 != l || j + 1 != i1 || i3 != j1)
                    {
                        l1 = func_281_g(world, k2, j + 1, i3, l1);
                    }
                    continue;
                }
                if(!world.func_28100_h(k2, j, i3) && (k2 != l || j - 1 != i1 || i3 != j1))
                {
                    l1 = func_281_g(world, k2, j - 1, i3, l1);
                }
            }

            if(l1 > 0)
            {
                l1--;
            } else
            {
                l1 = 0;
            }
        }
        if(k1 != l1)
        {
            world.field_1043_h = true;
            world.func_691_b(i, j, k, l1);
            world.func_701_b(i, j, k, i, j, k);
            world.field_1043_h = false;
            for(int j2 = 0; j2 < 4; j2++)
            {
                int l2 = i;
                int j3 = k;
                int k3 = j - 1;
                if(j2 == 0)
                {
                    l2--;
                }
                if(j2 == 1)
                {
                    l2++;
                }
                if(j2 == 2)
                {
                    j3--;
                }
                if(j2 == 3)
                {
                    j3++;
                }
                if(world.func_28100_h(l2, j, j3))
                {
                    k3 += 2;
                }
                int l3 = 0;
                l3 = func_281_g(world, l2, j, j3, -1);
                l1 = world.func_602_e(i, j, k);
                if(l1 > 0)
                {
                    l1--;
                }
                if(l3 >= 0 && l3 != l1)
                {
                    func_21030_a(world, l2, j, j3, i, j, k);
                }
                l3 = func_281_g(world, l2, k3, j3, -1);
                l1 = world.func_602_e(i, j, k);
                if(l1 > 0)
                {
                    l1--;
                }
                if(l3 >= 0 && l3 != l1)
                {
                    func_21030_a(world, l2, k3, j3, i, j, k);
                }
            }

            if(k1 < l1 || l1 == 0)
            {
                field_21031_b.add(new ChunkPosition(i, j, k));
                field_21031_b.add(new ChunkPosition(i - 1, j, k));
                field_21031_b.add(new ChunkPosition(i + 1, j, k));
                field_21031_b.add(new ChunkPosition(i, j - 1, k));
                field_21031_b.add(new ChunkPosition(i, j + 1, k));
                field_21031_b.add(new ChunkPosition(i, j, k - 1));
                field_21031_b.add(new ChunkPosition(i, j, k + 1));
            }
        }
    }

    private void func_282_i(World world, int i, int j, int k)
    {
        if(world.func_600_a(i, j, k) != field_376_bc)
        {
            return;
        } else
        {
            world.func_611_g(i, j, k, field_376_bc);
            world.func_611_g(i - 1, j, k, field_376_bc);
            world.func_611_g(i + 1, j, k, field_376_bc);
            world.func_611_g(i, j, k - 1, field_376_bc);
            world.func_611_g(i, j, k + 1, field_376_bc);
            world.func_611_g(i, j - 1, k, field_376_bc);
            world.func_611_g(i, j + 1, k, field_376_bc);
            return;
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        if(world.field_1026_y)
        {
            return;
        }
        func_280_h(world, i, j, k);
        world.func_611_g(i, j + 1, k, field_376_bc);
        world.func_611_g(i, j - 1, k, field_376_bc);
        func_282_i(world, i - 1, j, k);
        func_282_i(world, i + 1, j, k);
        func_282_i(world, i, j, k - 1);
        func_282_i(world, i, j, k + 1);
        if(world.func_28100_h(i - 1, j, k))
        {
            func_282_i(world, i - 1, j + 1, k);
        } else
        {
            func_282_i(world, i - 1, j - 1, k);
        }
        if(world.func_28100_h(i + 1, j, k))
        {
            func_282_i(world, i + 1, j + 1, k);
        } else
        {
            func_282_i(world, i + 1, j - 1, k);
        }
        if(world.func_28100_h(i, j, k - 1))
        {
            func_282_i(world, i, j + 1, k - 1);
        } else
        {
            func_282_i(world, i, j - 1, k - 1);
        }
        if(world.func_28100_h(i, j, k + 1))
        {
            func_282_i(world, i, j + 1, k + 1);
        } else
        {
            func_282_i(world, i, j - 1, k + 1);
        }
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        super.func_214_b(world, i, j, k);
        if(world.field_1026_y)
        {
            return;
        }
        world.func_611_g(i, j + 1, k, field_376_bc);
        world.func_611_g(i, j - 1, k, field_376_bc);
        world.func_611_g(i + 1, j, k, field_376_bc);
        world.func_611_g(i - 1, j, k, field_376_bc);
        world.func_611_g(i, j, k + 1, field_376_bc);
        world.func_611_g(i, j, k - 1, field_376_bc);
        func_280_h(world, i, j, k);
        func_282_i(world, i - 1, j, k);
        func_282_i(world, i + 1, j, k);
        func_282_i(world, i, j, k - 1);
        func_282_i(world, i, j, k + 1);
        if(world.func_28100_h(i - 1, j, k))
        {
            func_282_i(world, i - 1, j + 1, k);
        } else
        {
            func_282_i(world, i - 1, j - 1, k);
        }
        if(world.func_28100_h(i + 1, j, k))
        {
            func_282_i(world, i + 1, j + 1, k);
        } else
        {
            func_282_i(world, i + 1, j - 1, k);
        }
        if(world.func_28100_h(i, j, k - 1))
        {
            func_282_i(world, i, j + 1, k - 1);
        } else
        {
            func_282_i(world, i, j - 1, k - 1);
        }
        if(world.func_28100_h(i, j, k + 1))
        {
            func_282_i(world, i, j + 1, k + 1);
        } else
        {
            func_282_i(world, i, j - 1, k + 1);
        }
    }

    private int func_281_g(World world, int i, int j, int k, int l)
    {
        if(world.func_600_a(i, j, k) != field_376_bc)
        {
            return l;
        }
        int i1 = world.func_602_e(i, j, k);
        if(i1 > l)
        {
            return i1;
        } else
        {
            return l;
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int i1 = world.func_602_e(i, j, k);
        boolean flag = func_243_a(world, i, j, k);
        if(!flag)
        {
            func_259_b_(world, i, j, k, i1, 0);
            world.func_690_d(i, j, k, 0);
        } else
        {
            func_280_h(world, i, j, k);
        }
        super.func_226_a(world, i, j, k, l);
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_309_aA.field_291_aS;
    }

    public boolean func_228_c(World world, int i, int j, int k, int l)
    {
        if(!field_453_a)
        {
            return false;
        } else
        {
            return func_231_b(world, i, j, k, l);
        }
    }

    public boolean func_231_b(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(!field_453_a)
        {
            return false;
        }
        if(iblockaccess.func_602_e(i, j, k) == 0)
        {
            return false;
        }
        if(l == 1)
        {
            return true;
        }
        boolean flag = func_41053_d(iblockaccess, i - 1, j, k, 1) || !iblockaccess.func_28100_h(i - 1, j, k) && func_41053_d(iblockaccess, i - 1, j - 1, k, -1);
        boolean flag1 = func_41053_d(iblockaccess, i + 1, j, k, 3) || !iblockaccess.func_28100_h(i + 1, j, k) && func_41053_d(iblockaccess, i + 1, j - 1, k, -1);
        boolean flag2 = func_41053_d(iblockaccess, i, j, k - 1, 2) || !iblockaccess.func_28100_h(i, j, k - 1) && func_41053_d(iblockaccess, i, j - 1, k - 1, -1);
        boolean flag3 = func_41053_d(iblockaccess, i, j, k + 1, 0) || !iblockaccess.func_28100_h(i, j, k + 1) && func_41053_d(iblockaccess, i, j - 1, k + 1, -1);
        if(!iblockaccess.func_28100_h(i, j + 1, k))
        {
            if(iblockaccess.func_28100_h(i - 1, j, k) && func_41053_d(iblockaccess, i - 1, j + 1, k, -1))
            {
                flag = true;
            }
            if(iblockaccess.func_28100_h(i + 1, j, k) && func_41053_d(iblockaccess, i + 1, j + 1, k, -1))
            {
                flag1 = true;
            }
            if(iblockaccess.func_28100_h(i, j, k - 1) && func_41053_d(iblockaccess, i, j + 1, k - 1, -1))
            {
                flag2 = true;
            }
            if(iblockaccess.func_28100_h(i, j, k + 1) && func_41053_d(iblockaccess, i, j + 1, k + 1, -1))
            {
                flag3 = true;
            }
        }
        if(!flag2 && !flag1 && !flag && !flag3 && l >= 2 && l <= 5)
        {
            return true;
        }
        if(l == 2 && flag2 && !flag && !flag1)
        {
            return true;
        }
        if(l == 3 && flag3 && !flag && !flag1)
        {
            return true;
        }
        if(l == 4 && flag && !flag2 && !flag3)
        {
            return true;
        }
        return l == 5 && flag1 && !flag2 && !flag3;
    }

    public boolean func_209_d()
    {
        return field_453_a;
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k);
        if(l > 0)
        {
            double d = (double)i + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.20000000000000001D;
            double d1 = (float)j + 0.0625F;
            double d2 = (double)k + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.20000000000000001D;
            float f = (float)l / 15F;
            float f1 = f * 0.6F + 0.4F;
            if(l == 0)
            {
                f1 = 0.0F;
            }
            float f2 = f * f * 0.7F - 0.5F;
            float f3 = f * f * 0.6F - 0.7F;
            if(f2 < 0.0F)
            {
                f2 = 0.0F;
            }
            if(f3 < 0.0F)
            {
                f3 = 0.0F;
            }
            world.func_694_a("reddust", d, d1, d2, f1, f2, f3);
        }
    }

    public static boolean func_279_b(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.func_600_a(i, j, k);
        if(i1 == Block.field_394_aw.field_376_bc)
        {
            return true;
        }
        if(i1 == 0)
        {
            return false;
        }
        if(i1 == Block.field_22021_bh.field_376_bc || i1 == Block.field_22020_bi.field_376_bc)
        {
            int j1 = iblockaccess.func_602_e(i, j, k);
            return l == (j1 & 3) || l == Direction.field_22279_b[j1 & 3];
        }
        return Block.field_345_n[i1].func_209_d() && l != -1;
    }

    public static boolean func_41053_d(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(func_279_b(iblockaccess, i, j, k, l))
        {
            return true;
        }
        int i1 = iblockaccess.func_600_a(i, j, k);
        if(i1 == Block.field_22020_bi.field_376_bc)
        {
            int j1 = iblockaccess.func_602_e(i, j, k);
            return l == (j1 & 3);
        } else
        {
            return false;
        }
    }
}
