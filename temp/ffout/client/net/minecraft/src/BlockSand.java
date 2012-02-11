// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityFallingSand, 
//            BlockFire

public class BlockSand extends Block
{

    public static boolean field_466_a = false;

    public BlockSand(int i, int j)
    {
        super(i, j, Material.field_1325_m);
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
        func_315_h(world, i, j, k);
    }

    private void func_315_h(World world, int i, int j, int k)
    {
        int l = i;
        int i1 = j;
        int j1 = k;
        if(func_316_a_(world, l, i1 - 1, j1) && i1 >= 0)
        {
            byte byte0 = 32;
            if(field_466_a || !world.func_640_a(i - byte0, j - byte0, k - byte0, i + byte0, j + byte0, k + byte0))
            {
                world.func_690_d(i, j, k, 0);
                for(; func_316_a_(world, i, j - 1, k) && j > 0; j--) { }
                if(j > 0)
                {
                    world.func_690_d(i, j, k, field_376_bc);
                }
            } else
            if(!world.field_1026_y)
            {
                EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, field_376_bc);
                world.func_674_a(entityfallingsand);
            }
        }
    }

    public int func_4025_d()
    {
        return 3;
    }

    public static boolean func_316_a_(World world, int i, int j, int k)
    {
        int l = world.func_600_a(i, j, k);
        if(l == 0)
        {
            return true;
        }
        if(l == Block.field_402_as.field_376_bc)
        {
            return true;
        }
        Material material = Block.field_345_n[l].field_356_bn;
        if(material == Material.field_1332_f)
        {
            return true;
        }
        return material == Material.field_1331_g;
    }

}
