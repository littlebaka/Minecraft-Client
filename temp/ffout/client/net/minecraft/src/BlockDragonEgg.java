// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockSand, 
//            EntityFallingSand, EntityPlayer

public class BlockDragonEgg extends Block
{

    public BlockDragonEgg(int i, int j)
    {
        super(i, j, Material.field_41056_z);
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        world.func_22136_c(i, j, k, field_376_bc, func_4025_d());
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        world.func_22136_c(i, j, k, field_376_bc, func_4025_d());
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        func_41055_g(world, i, j, k);
    }

    private void func_41055_g(World world, int i, int j, int k)
    {
        int l = i;
        int i1 = j;
        int j1 = k;
        if(BlockSand.func_316_a_(world, l, i1 - 1, j1) && i1 >= 0)
        {
            byte byte0 = 32;
            if(BlockSand.field_466_a || !world.func_640_a(i - byte0, j - byte0, k - byte0, i + byte0, j + byte0, k + byte0))
            {
                world.func_690_d(i, j, k, 0);
                for(; BlockSand.func_316_a_(world, i, j - 1, k) && j > 0; j--) { }
                if(j > 0)
                {
                    world.func_690_d(i, j, k, field_376_bc);
                }
            } else
            {
                EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, field_376_bc);
                world.func_674_a(entityfallingsand);
            }
        }
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_41054_h(world, i, j, k);
        return true;
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        func_41054_h(world, i, j, k);
    }

    private void func_41054_h(World world, int i, int j, int k)
    {
        if(world.func_600_a(i, j, k) != field_376_bc)
        {
            return;
        }
        if(world.field_1026_y)
        {
            return;
        }
        for(int l = 0; l < 1000; l++)
        {
            int i1 = (i + world.field_1037_n.nextInt(16)) - world.field_1037_n.nextInt(16);
            int j1 = (j + world.field_1037_n.nextInt(8)) - world.field_1037_n.nextInt(8);
            int k1 = (k + world.field_1037_n.nextInt(16)) - world.field_1037_n.nextInt(16);
            if(world.func_600_a(i1, j1, k1) == 0)
            {
                world.func_688_b(i1, j1, k1, field_376_bc, world.func_602_e(i, j, k));
                world.func_690_d(i, j, k, 0);
                char c = '\200';
                for(int l1 = 0; l1 < c; l1++)
                {
                    double d = world.field_1037_n.nextDouble();
                    float f = (world.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                    float f1 = (world.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                    float f2 = (world.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                    double d1 = (double)i1 + (double)(i - i1) * d + (world.field_1037_n.nextDouble() - 0.5D) * 1.0D + 0.5D;
                    double d2 = ((double)j1 + (double)(j - j1) * d + world.field_1037_n.nextDouble() * 1.0D) - 0.5D;
                    double d3 = (double)k1 + (double)(k - k1) * d + (world.field_1037_n.nextDouble() - 0.5D) * 1.0D + 0.5D;
                    world.func_694_a("portal", d1, d2, d3, f, f1, f2);
                }

                return;
            }
        }

    }

    public int func_4025_d()
    {
        return 3;
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        return super.func_243_a(world, i, j, k);
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
        return 27;
    }
}
