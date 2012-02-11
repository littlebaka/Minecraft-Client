// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            AxisAlignedBB, EntityPlayer, FoodStats

public class BlockCake extends Block
{

    protected BlockCake(int i, int j)
    {
        super(i, j, Material.field_21150_y);
        func_253_b(true);
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.func_602_e(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        func_213_a(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    public void func_237_e()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        func_213_a(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.func_1161_b((float)i + f1, j, (float)k + f, (float)(i + 1) - f, ((float)j + f2) - f, (float)(k + 1) - f);
    }

    public AxisAlignedBB func_246_f(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.func_1161_b((float)i + f1, j, (float)k + f, (float)(i + 1) - f, (float)j + f2, (float)(k + 1) - f);
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1)
        {
            return field_378_bb;
        }
        if(i == 0)
        {
            return field_378_bb + 3;
        }
        if(j > 0 && i == 4)
        {
            return field_378_bb + 2;
        } else
        {
            return field_378_bb + 1;
        }
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb;
        }
        if(i == 0)
        {
            return field_378_bb + 3;
        } else
        {
            return field_378_bb + 1;
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

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_21029_c(world, i, j, k, entityplayer);
        return true;
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_21029_c(world, i, j, k, entityplayer);
    }

    private void func_21029_c(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(entityplayer.func_35197_b(false))
        {
            entityplayer.func_35191_at().func_35771_a(2, 0.1F);
            int l = world.func_602_e(i, j, k) + 1;
            if(l >= 6)
            {
                world.func_690_d(i, j, k, 0);
            } else
            {
                world.func_691_b(i, j, k, l);
                world.func_21115_j(i, j, k);
            }
        }
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
        return world.func_599_f(i, j - 1, k).func_878_a();
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return 0;
    }
}
