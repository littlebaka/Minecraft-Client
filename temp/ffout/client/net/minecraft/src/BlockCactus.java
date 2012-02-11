// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, AxisAlignedBB, 
//            DamageSource, Entity

public class BlockCactus extends Block
{

    protected BlockCactus(int i, int j)
    {
        super(i, j, Material.field_1317_u);
        func_253_b(true);
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.func_20084_d(i, j + 1, k))
        {
            int l;
            for(l = 1; world.func_600_a(i, j - l, k) == field_376_bc; l++) { }
            if(l < 3)
            {
                int i1 = world.func_602_e(i, j, k);
                if(i1 == 15)
                {
                    world.func_690_d(i, j + 1, k, field_376_bc);
                    world.func_691_b(i, j, k, 0);
                } else
                {
                    world.func_691_b(i, j, k, i1 + 1);
                }
            }
        }
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        float f = 0.0625F;
        return AxisAlignedBB.func_1161_b((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 1) - f, (float)(k + 1) - f);
    }

    public AxisAlignedBB func_246_f(World world, int i, int j, int k)
    {
        float f = 0.0625F;
        return AxisAlignedBB.func_1161_b((float)i + f, j, (float)k + f, (float)(i + 1) - f, j + 1, (float)(k + 1) - f);
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb - 1;
        }
        if(i == 0)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public int func_210_f()
    {
        return 13;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        if(!super.func_243_a(world, i, j, k))
        {
            return false;
        } else
        {
            return func_223_g(world, i, j, k);
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(!func_223_g(world, i, j, k))
        {
            func_259_b_(world, i, j, k, world.func_602_e(i, j, k), 0);
            world.func_690_d(i, j, k, 0);
        }
    }

    public boolean func_223_g(World world, int i, int j, int k)
    {
        if(world.func_599_f(i - 1, j, k).func_878_a())
        {
            return false;
        }
        if(world.func_599_f(i + 1, j, k).func_878_a())
        {
            return false;
        }
        if(world.func_599_f(i, j, k - 1).func_878_a())
        {
            return false;
        }
        if(world.func_599_f(i, j, k + 1).func_878_a())
        {
            return false;
        } else
        {
            int l = world.func_600_a(i, j - 1, k);
            return l == Block.field_425_aW.field_376_bc || l == Block.field_393_F.field_376_bc;
        }
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
        entity.func_396_a(DamageSource.field_35537_g, 1);
    }
}
