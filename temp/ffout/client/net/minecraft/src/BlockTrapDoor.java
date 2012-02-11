// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            AxisAlignedBB, EntityPlayer, Vec3D, MovingObjectPosition

public class BlockTrapDoor extends Block
{

    protected BlockTrapDoor(int i, Material material)
    {
        super(i, material);
        field_378_bb = 84;
        if(material == Material.field_1333_e)
        {
            field_378_bb++;
        }
        float f = 0.5F;
        float f1 = 1.0F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
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
        return 0;
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
        func_28043_c(iblockaccess.func_602_e(i, j, k));
    }

    public void func_237_e()
    {
        float f = 0.1875F;
        func_213_a(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
    }

    public void func_28043_c(int i)
    {
        float f = 0.1875F;
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
        if(func_28041_d(i))
        {
            if((i & 3) == 0)
            {
                func_213_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
            if((i & 3) == 1)
            {
                func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
            if((i & 3) == 2)
            {
                func_213_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
            if((i & 3) == 3)
            {
                func_213_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
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
        } else
        {
            int l = world.func_602_e(i, j, k);
            world.func_691_b(i, j, k, l ^ 4);
            world.func_28107_a(entityplayer, 1003, i, j, k, 0);
            return true;
        }
    }

    public void func_28042_a(World world, int i, int j, int k, boolean flag)
    {
        int l = world.func_602_e(i, j, k);
        boolean flag1 = (l & 4) > 0;
        if(flag1 == flag)
        {
            return;
        } else
        {
            world.func_691_b(i, j, k, l ^ 4);
            world.func_28107_a(null, 1003, i, j, k, 0);
            return;
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int i1 = world.func_602_e(i, j, k);
        int j1 = i;
        int k1 = k;
        if((i1 & 3) == 0)
        {
            k1++;
        }
        if((i1 & 3) == 1)
        {
            k1--;
        }
        if((i1 & 3) == 2)
        {
            j1++;
        }
        if((i1 & 3) == 3)
        {
            j1--;
        }
        if(!func_41052_f(world.func_600_a(j1, j, k1)))
        {
            world.func_690_d(i, j, k, 0);
            func_259_b_(world, i, j, k, i1, 0);
        }
        boolean flag = world.func_625_o(i, j, k);
        if(flag || l > 0 && Block.field_345_n[l].func_209_d() || l == 0)
        {
            func_28042_a(world, i, j, k, flag);
        }
    }

    public MovingObjectPosition func_255_a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        func_238_a(world, i, j, k);
        return super.func_255_a(world, i, j, k, vec3d, vec3d1);
    }

    public void func_258_d(World world, int i, int j, int k, int l)
    {
        byte byte0 = 0;
        if(l == 2)
        {
            byte0 = 0;
        }
        if(l == 3)
        {
            byte0 = 1;
        }
        if(l == 4)
        {
            byte0 = 2;
        }
        if(l == 5)
        {
            byte0 = 3;
        }
        world.func_691_b(i, j, k, byte0);
    }

    public boolean func_28030_e(World world, int i, int j, int k, int l)
    {
        if(l == 0)
        {
            return false;
        }
        if(l == 1)
        {
            return false;
        }
        if(l == 2)
        {
            k++;
        }
        if(l == 3)
        {
            k--;
        }
        if(l == 4)
        {
            i++;
        }
        if(l == 5)
        {
            i--;
        }
        return func_41052_f(world.func_600_a(i, j, k));
    }

    public static boolean func_28041_d(int i)
    {
        return (i & 4) != 0;
    }

    private static boolean func_41052_f(int i)
    {
        if(i <= 0)
        {
            return false;
        } else
        {
            Block block = Block.field_345_n[i];
            return block != null && block.field_356_bn.func_28126_h() && block.func_242_c() || block == Block.field_4049_be;
        }
    }
}
