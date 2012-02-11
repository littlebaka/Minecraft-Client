// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, World, Material, IBlockAccess, 
//            RailLogic, AxisAlignedBB, Vec3D, MovingObjectPosition

public class BlockRail extends Block
{

    private final boolean field_27045_a;

    public static final boolean func_27040_h(World world, int i, int j, int k)
    {
        int l = world.func_600_a(i, j, k);
        return l == Block.field_440_aH.field_376_bc || l == Block.field_9261_T.field_376_bc || l == Block.field_9260_U.field_376_bc;
    }

    public static final boolean func_27041_c(int i)
    {
        return i == Block.field_440_aH.field_376_bc || i == Block.field_9261_T.field_376_bc || i == Block.field_9260_U.field_376_bc;
    }

    protected BlockRail(int i, int j, boolean flag)
    {
        super(i, j, Material.field_1324_n);
        field_27045_a = flag;
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_27042_h()
    {
        return field_27045_a;
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public MovingObjectPosition func_255_a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        func_238_a(world, i, j, k);
        return super.func_255_a(world, i, j, k, vec3d, vec3d1);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        if(l >= 2 && l <= 5)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        } else
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }
    }

    public int func_232_a(int i, int j)
    {
        if(field_27045_a)
        {
            if(field_376_bc == Block.field_9261_T.field_376_bc && (j & 8) == 0)
            {
                return field_378_bb - 16;
            }
        } else
        if(j >= 6)
        {
            return field_378_bb - 16;
        }
        return field_378_bb;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_210_f()
    {
        return 9;
    }

    public int func_229_a(Random random)
    {
        return 1;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return world.func_28100_h(i, j - 1, k);
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        if(!world.field_1026_y)
        {
            func_4031_h(world, i, j, k, true);
            if(field_376_bc == Block.field_9261_T.field_376_bc)
            {
                func_226_a(world, i, j, k, field_376_bc);
            }
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int i1 = world.func_602_e(i, j, k);
        int j1 = i1;
        if(field_27045_a)
        {
            j1 &= 7;
        }
        boolean flag = false;
        if(!world.func_28100_h(i, j - 1, k))
        {
            flag = true;
        }
        if(j1 == 2 && !world.func_28100_h(i + 1, j, k))
        {
            flag = true;
        }
        if(j1 == 3 && !world.func_28100_h(i - 1, j, k))
        {
            flag = true;
        }
        if(j1 == 4 && !world.func_28100_h(i, j, k - 1))
        {
            flag = true;
        }
        if(j1 == 5 && !world.func_28100_h(i, j, k + 1))
        {
            flag = true;
        }
        if(flag)
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
        } else
        if(field_376_bc == Block.field_9261_T.field_376_bc)
        {
            boolean flag1 = world.func_625_o(i, j, k) || world.func_625_o(i, j + 1, k);
            flag1 = flag1 || func_27044_a(world, i, j, k, i1, true, 0) || func_27044_a(world, i, j, k, i1, false, 0);
            boolean flag2 = false;
            if(flag1 && (i1 & 8) == 0)
            {
                world.func_691_b(i, j, k, j1 | 8);
                flag2 = true;
            } else
            if(!flag1 && (i1 & 8) != 0)
            {
                world.func_691_b(i, j, k, j1);
                flag2 = true;
            }
            if(flag2)
            {
                world.func_611_g(i, j - 1, k, field_376_bc);
                if(j1 == 2 || j1 == 3 || j1 == 4 || j1 == 5)
                {
                    world.func_611_g(i, j + 1, k, field_376_bc);
                }
            }
        } else
        if(l > 0 && Block.field_345_n[l].func_209_d() && !field_27045_a && RailLogic.func_791_a(new RailLogic(this, world, i, j, k)) == 3)
        {
            func_4031_h(world, i, j, k, false);
        }
    }

    private void func_4031_h(World world, int i, int j, int k, boolean flag)
    {
        if(world.field_1026_y)
        {
            return;
        } else
        {
            (new RailLogic(this, world, i, j, k)).func_792_a(world.func_625_o(i, j, k), flag);
            return;
        }
    }

    private boolean func_27044_a(World world, int i, int j, int k, int l, boolean flag, int i1)
    {
        if(i1 >= 8)
        {
            return false;
        }
        int j1 = l & 7;
        boolean flag1 = true;
        switch(j1)
        {
        case 0: // '\0'
            if(flag)
            {
                k++;
            } else
            {
                k--;
            }
            break;

        case 1: // '\001'
            if(flag)
            {
                i--;
            } else
            {
                i++;
            }
            break;

        case 2: // '\002'
            if(flag)
            {
                i--;
            } else
            {
                i++;
                j++;
                flag1 = false;
            }
            j1 = 1;
            break;

        case 3: // '\003'
            if(flag)
            {
                i--;
                j++;
                flag1 = false;
            } else
            {
                i++;
            }
            j1 = 1;
            break;

        case 4: // '\004'
            if(flag)
            {
                k++;
            } else
            {
                k--;
                j++;
                flag1 = false;
            }
            j1 = 0;
            break;

        case 5: // '\005'
            if(flag)
            {
                k++;
                j++;
                flag1 = false;
            } else
            {
                k--;
            }
            j1 = 0;
            break;
        }
        if(func_27043_a(world, i, j, k, flag, i1, j1))
        {
            return true;
        }
        return flag1 && func_27043_a(world, i, j - 1, k, flag, i1, j1);
    }

    private boolean func_27043_a(World world, int i, int j, int k, boolean flag, int l, int i1)
    {
        int j1 = world.func_600_a(i, j, k);
        if(j1 == Block.field_9261_T.field_376_bc)
        {
            int k1 = world.func_602_e(i, j, k);
            int l1 = k1 & 7;
            if(i1 == 1 && (l1 == 0 || l1 == 4 || l1 == 5))
            {
                return false;
            }
            if(i1 == 0 && (l1 == 1 || l1 == 2 || l1 == 3))
            {
                return false;
            }
            if((k1 & 8) != 0)
            {
                if(world.func_625_o(i, j, k) || world.func_625_o(i, j + 1, k))
                {
                    return true;
                } else
                {
                    return func_27044_a(world, i, j, k, k1, flag, l + 1);
                }
            }
        }
        return false;
    }

    public int func_31029_h()
    {
        return 0;
    }

    static boolean func_27039_a(BlockRail blockrail)
    {
        return blockrail.field_27045_a;
    }
}
