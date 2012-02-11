// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            Item, AxisAlignedBB, EntityPlayer, Vec3D, 
//            MovingObjectPosition

public class BlockDoor extends Block
{

    protected BlockDoor(int i, Material material)
    {
        super(i, material);
        field_378_bb = 97;
        if(material == Material.field_1333_e)
        {
            field_378_bb++;
        }
        float f = 0.5F;
        float f1 = 1.0F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public int func_232_a(int i, int j)
    {
        if(i == 0 || i == 1)
        {
            return field_378_bb;
        }
        int k = func_312_c(j);
        if((k == 0 || k == 2) ^ (i <= 3))
        {
            return field_378_bb;
        }
        int l = k / 2 + (i & 1 ^ k);
        l += (j & 4) / 4;
        int i1 = field_378_bb - (j & 8) * 2;
        if((l & 1) != 0)
        {
            i1 = -i1;
        }
        return i1;
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
        return 7;
    }

    public AxisAlignedBB func_246_f(World world, int i, int j, int k)
    {
        func_238_a(world, i, j, k);
        return super.func_246_f(world, i, j, k);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        func_238_a(world, i, j, k);
        return super.func_221_d(world, i, j, k);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        func_313_b(func_312_c(iblockaccess.func_602_e(i, j, k)));
    }

    public void func_313_b(int i)
    {
        float f = 0.1875F;
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        if(i == 0)
        {
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(i == 1)
        {
            func_213_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(i == 2)
        {
            func_213_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(i == 3)
        {
            func_213_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_250_a(world, i, j, k, entityplayer);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(field_356_bn == Material.field_1333_e)
        {
            return true;
        }
        int l = world.func_602_e(i, j, k);
        if((l & 8) != 0)
        {
            if(world.func_600_a(i, j - 1, k) == field_376_bc)
            {
                func_250_a(world, i, j - 1, k, entityplayer);
            }
            return true;
        }
        if(world.func_600_a(i, j + 1, k) == field_376_bc)
        {
            world.func_691_b(i, j + 1, k, (l ^ 4) + 8);
        }
        world.func_691_b(i, j, k, l ^ 4);
        world.func_701_b(i, j - 1, k, i, j, k);
        world.func_28107_a(entityplayer, 1003, i, j, k, 0);
        return true;
    }

    public void func_311_a(World world, int i, int j, int k, boolean flag)
    {
        int l = world.func_602_e(i, j, k);
        if((l & 8) != 0)
        {
            if(world.func_600_a(i, j - 1, k) == field_376_bc)
            {
                func_311_a(world, i, j - 1, k, flag);
            }
            return;
        }
        boolean flag1 = (world.func_602_e(i, j, k) & 4) > 0;
        if(flag1 == flag)
        {
            return;
        }
        if(world.func_600_a(i, j + 1, k) == field_376_bc)
        {
            world.func_691_b(i, j + 1, k, (l ^ 4) + 8);
        }
        world.func_691_b(i, j, k, l ^ 4);
        world.func_701_b(i, j - 1, k, i, j, k);
        world.func_28107_a(null, 1003, i, j, k, 0);
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        int i1 = world.func_602_e(i, j, k);
        if((i1 & 8) != 0)
        {
            if(world.func_600_a(i, j - 1, k) != field_376_bc)
            {
                world.func_690_d(i, j, k, 0);
            }
            if(l > 0 && l != field_376_bc)
            {
                func_226_a(world, i, j - 1, k, l);
            }
        } else
        {
            boolean flag = false;
            if(world.func_600_a(i, j + 1, k) != field_376_bc)
            {
                world.func_690_d(i, j, k, 0);
                flag = true;
            }
            if(!world.func_28100_h(i, j - 1, k))
            {
                world.func_690_d(i, j, k, 0);
                flag = true;
                if(world.func_600_a(i, j + 1, k) == field_376_bc)
                {
                    world.func_690_d(i, j + 1, k, 0);
                }
            }
            if(flag)
            {
                if(!world.field_1026_y)
                {
                    func_259_b_(world, i, j, k, i1, 0);
                }
            } else
            {
                boolean flag1 = world.func_625_o(i, j, k) || world.func_625_o(i, j + 1, k);
                if((flag1 || l > 0 && Block.field_345_n[l].func_209_d() || l == 0) && l != field_376_bc)
                {
                    func_311_a(world, i, j, k, flag1);
                }
            }
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        if((i & 8) != 0)
        {
            return 0;
        }
        if(field_356_bn == Material.field_1333_e)
        {
            return Item.field_252_az.field_291_aS;
        } else
        {
            return Item.field_265_at.field_291_aS;
        }
    }

    public MovingObjectPosition func_255_a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        func_238_a(world, i, j, k);
        return super.func_255_a(world, i, j, k, vec3d, vec3d1);
    }

    public int func_312_c(int i)
    {
        if((i & 4) == 0)
        {
            return i - 1 & 3;
        } else
        {
            return i & 3;
        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        if(j >= world.field_35472_c - 1)
        {
            return false;
        } else
        {
            return world.func_28100_h(i, j - 1, k) && super.func_243_a(world, i, j, k) && super.func_243_a(world, i, j + 1, k);
        }
    }

    public static boolean func_27047_e(int i)
    {
        return (i & 4) != 0;
    }

    public int func_31029_h()
    {
        return 1;
    }
}
