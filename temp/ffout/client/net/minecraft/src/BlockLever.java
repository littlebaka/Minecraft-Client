// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, IBlockAccess, 
//            AxisAlignedBB, EntityPlayer

public class BlockLever extends Block
{

    protected BlockLever(int i, int j)
    {
        super(i, j, Material.field_1324_n);
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
        return 12;
    }

    public boolean func_28030_e(World world, int i, int j, int k, int l)
    {
        if(l == 1 && world.func_28100_h(i, j - 1, k))
        {
            return true;
        }
        if(l == 2 && world.func_28100_h(i, j, k + 1))
        {
            return true;
        }
        if(l == 3 && world.func_28100_h(i, j, k - 1))
        {
            return true;
        }
        if(l == 4 && world.func_28100_h(i + 1, j, k))
        {
            return true;
        }
        return l == 5 && world.func_28100_h(i - 1, j, k);
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        if(world.func_28100_h(i - 1, j, k))
        {
            return true;
        }
        if(world.func_28100_h(i + 1, j, k))
        {
            return true;
        }
        if(world.func_28100_h(i, j, k - 1))
        {
            return true;
        }
        if(world.func_28100_h(i, j, k + 1))
        {
            return true;
        }
        return world.func_28100_h(i, j - 1, k);
    }

    public void func_258_d(World world, int i, int j, int k, int l)
    {
        int i1 = world.func_602_e(i, j, k);
        int j1 = i1 & 8;
        i1 &= 7;
        i1 = -1;
        if(l == 1 && world.func_28100_h(i, j - 1, k))
        {
            i1 = 5 + world.field_1037_n.nextInt(2);
        }
        if(l == 2 && world.func_28100_h(i, j, k + 1))
        {
            i1 = 4;
        }
        if(l == 3 && world.func_28100_h(i, j, k - 1))
        {
            i1 = 3;
        }
        if(l == 4 && world.func_28100_h(i + 1, j, k))
        {
            i1 = 2;
        }
        if(l == 5 && world.func_28100_h(i - 1, j, k))
        {
            i1 = 1;
        }
        if(i1 == -1)
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
            return;
        } else
        {
            world.func_691_b(i, j, k, i1 + j1);
            return;
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(func_267_h(world, i, j, k))
        {
            int i1 = world.func_602_e(i, j, k) & 7;
            boolean flag = false;
            if(!world.func_28100_h(i - 1, j, k) && i1 == 1)
            {
                flag = true;
            }
            if(!world.func_28100_h(i + 1, j, k) && i1 == 2)
            {
                flag = true;
            }
            if(!world.func_28100_h(i, j, k - 1) && i1 == 3)
            {
                flag = true;
            }
            if(!world.func_28100_h(i, j, k + 1) && i1 == 4)
            {
                flag = true;
            }
            if(!world.func_28100_h(i, j - 1, k) && i1 == 5)
            {
                flag = true;
            }
            if(!world.func_28100_h(i, j - 1, k) && i1 == 6)
            {
                flag = true;
            }
            if(flag)
            {
                func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
                world.func_690_d(i, j, k, 0);
            }
        }
    }

    private boolean func_267_h(World world, int i, int j, int k)
    {
        if(!func_243_a(world, i, j, k))
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
            return false;
        } else
        {
            return true;
        }
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k) & 7;
        float f = 0.1875F;
        if(l == 1)
        {
            func_213_a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
        } else
        if(l == 2)
        {
            func_213_a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
        } else
        if(l == 3)
        {
            func_213_a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
        } else
        if(l == 4)
        {
            func_213_a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
        } else
        {
            float f1 = 0.25F;
            func_213_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.6F, 0.5F + f1);
        }
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_250_a(world, i, j, k, entityplayer);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        int l = world.func_602_e(i, j, k);
        int i1 = l & 7;
        int j1 = 8 - (l & 8);
        world.func_691_b(i, j, k, i1 + j1);
        world.func_701_b(i, j, k, i, j, k);
        world.func_684_a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.click", 0.3F, j1 <= 0 ? 0.5F : 0.6F);
        world.func_611_g(i, j, k, field_376_bc);
        if(i1 == 1)
        {
            world.func_611_g(i - 1, j, k, field_376_bc);
        } else
        if(i1 == 2)
        {
            world.func_611_g(i + 1, j, k, field_376_bc);
        } else
        if(i1 == 3)
        {
            world.func_611_g(i, j, k - 1, field_376_bc);
        } else
        if(i1 == 4)
        {
            world.func_611_g(i, j, k + 1, field_376_bc);
        } else
        {
            world.func_611_g(i, j - 1, k, field_376_bc);
        }
        return true;
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        if((l & 8) > 0)
        {
            world.func_611_g(i, j, k, field_376_bc);
            int i1 = l & 7;
            if(i1 == 1)
            {
                world.func_611_g(i - 1, j, k, field_376_bc);
            } else
            if(i1 == 2)
            {
                world.func_611_g(i + 1, j, k, field_376_bc);
            } else
            if(i1 == 3)
            {
                world.func_611_g(i, j, k - 1, field_376_bc);
            } else
            if(i1 == 4)
            {
                world.func_611_g(i, j, k + 1, field_376_bc);
            } else
            {
                world.func_611_g(i, j - 1, k, field_376_bc);
            }
        }
        super.func_214_b(world, i, j, k);
    }

    public boolean func_231_b(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return (iblockaccess.func_602_e(i, j, k) & 8) > 0;
    }

    public boolean func_228_c(World world, int i, int j, int k, int l)
    {
        int i1 = world.func_602_e(i, j, k);
        if((i1 & 8) == 0)
        {
            return false;
        }
        int j1 = i1 & 7;
        if(j1 == 6 && l == 1)
        {
            return true;
        }
        if(j1 == 5 && l == 1)
        {
            return true;
        }
        if(j1 == 4 && l == 2)
        {
            return true;
        }
        if(j1 == 3 && l == 3)
        {
            return true;
        }
        if(j1 == 2 && l == 4)
        {
            return true;
        }
        return j1 == 1 && l == 5;
    }

    public boolean func_209_d()
    {
        return true;
    }
}
