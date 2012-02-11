// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, AxisAlignedBB, 
//            Vec3D, MovingObjectPosition

public class BlockTorch extends Block
{

    protected BlockTorch(int i, int j)
    {
        super(i, j, Material.field_1324_n);
        func_253_b(true);
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
        return 2;
    }

    private boolean func_31032_h(World world, int i, int j, int k)
    {
        if(world.func_41082_b(i, j, k, true))
        {
            return true;
        } else
        {
            int l = world.func_600_a(i, j, k);
            return l == Block.field_4057_ba.field_376_bc || l == Block.field_40207_bC.field_376_bc;
        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        if(world.func_41082_b(i - 1, j, k, true))
        {
            return true;
        }
        if(world.func_41082_b(i + 1, j, k, true))
        {
            return true;
        }
        if(world.func_41082_b(i, j, k - 1, true))
        {
            return true;
        }
        if(world.func_41082_b(i, j, k + 1, true))
        {
            return true;
        }
        return func_31032_h(world, i, j - 1, k);
    }

    public void func_258_d(World world, int i, int j, int k, int l)
    {
        int i1 = world.func_602_e(i, j, k);
        if(l == 1 && func_31032_h(world, i, j - 1, k))
        {
            i1 = 5;
        }
        if(l == 2 && world.func_41082_b(i, j, k + 1, true))
        {
            i1 = 4;
        }
        if(l == 3 && world.func_41082_b(i, j, k - 1, true))
        {
            i1 = 3;
        }
        if(l == 4 && world.func_41082_b(i + 1, j, k, true))
        {
            i1 = 2;
        }
        if(l == 5 && world.func_41082_b(i - 1, j, k, true))
        {
            i1 = 1;
        }
        world.func_691_b(i, j, k, i1);
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        super.func_208_a(world, i, j, k, random);
        if(world.func_602_e(i, j, k) == 0)
        {
            func_235_e(world, i, j, k);
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        if(world.func_41082_b(i - 1, j, k, true))
        {
            world.func_691_b(i, j, k, 1);
        } else
        if(world.func_41082_b(i + 1, j, k, true))
        {
            world.func_691_b(i, j, k, 2);
        } else
        if(world.func_41082_b(i, j, k - 1, true))
        {
            world.func_691_b(i, j, k, 3);
        } else
        if(world.func_41082_b(i, j, k + 1, true))
        {
            world.func_691_b(i, j, k, 4);
        } else
        if(func_31032_h(world, i, j - 1, k))
        {
            world.func_691_b(i, j, k, 5);
        }
        func_271_h(world, i, j, k);
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(func_271_h(world, i, j, k))
        {
            int i1 = world.func_602_e(i, j, k);
            boolean flag = false;
            if(!world.func_41082_b(i - 1, j, k, true) && i1 == 1)
            {
                flag = true;
            }
            if(!world.func_41082_b(i + 1, j, k, true) && i1 == 2)
            {
                flag = true;
            }
            if(!world.func_41082_b(i, j, k - 1, true) && i1 == 3)
            {
                flag = true;
            }
            if(!world.func_41082_b(i, j, k + 1, true) && i1 == 4)
            {
                flag = true;
            }
            if(!func_31032_h(world, i, j - 1, k) && i1 == 5)
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

    private boolean func_271_h(World world, int i, int j, int k)
    {
        if(!func_243_a(world, i, j, k))
        {
            if(world.func_600_a(i, j, k) == field_376_bc)
            {
                func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
                world.func_690_d(i, j, k, 0);
            }
            return false;
        } else
        {
            return true;
        }
    }

    public MovingObjectPosition func_255_a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        int l = world.func_602_e(i, j, k) & 7;
        float f = 0.15F;
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
            float f1 = 0.1F;
            func_213_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 0.6F, 0.5F + f1);
        }
        return super.func_255_a(world, i, j, k, vec3d, vec3d1);
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k);
        double d = (float)i + 0.5F;
        double d1 = (float)j + 0.7F;
        double d2 = (float)k + 0.5F;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        if(l == 1)
        {
            world.func_694_a("smoke", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", d - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 2)
        {
            world.func_694_a("smoke", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", d + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 3)
        {
            world.func_694_a("smoke", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", d, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        } else
        if(l == 4)
        {
            world.func_694_a("smoke", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", d, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        } else
        {
            world.func_694_a("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
            world.func_694_a("flame", d, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}
