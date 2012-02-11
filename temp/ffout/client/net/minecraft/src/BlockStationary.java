// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFluid, Material, World, Block, 
//            BlockFire

public class BlockStationary extends BlockFluid
{

    protected BlockStationary(int i, Material material)
    {
        super(i, material);
        func_253_b(false);
        if(material == Material.field_1331_g)
        {
            func_253_b(true);
        }
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        super.func_226_a(world, i, j, k, l);
        if(world.func_600_a(i, j, k) == field_376_bc)
        {
            func_30004_j(world, i, j, k);
        }
    }

    private void func_30004_j(World world, int i, int j, int k)
    {
        int l = world.func_602_e(i, j, k);
        world.field_1043_h = true;
        world.func_643_a(i, j, k, field_376_bc - 1, l);
        world.func_701_b(i, j, k, i, j, k);
        world.func_22136_c(i, j, k, field_376_bc - 1, func_4025_d());
        world.field_1043_h = false;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(field_356_bn == Material.field_1331_g)
        {
            int l = random.nextInt(3);
            for(int i1 = 0; i1 < l; i1++)
            {
                i += random.nextInt(3) - 1;
                j++;
                k += random.nextInt(3) - 1;
                int j1 = world.func_600_a(i, j, k);
                if(j1 == 0)
                {
                    if(func_301_k(world, i - 1, j, k) || func_301_k(world, i + 1, j, k) || func_301_k(world, i, j, k - 1) || func_301_k(world, i, j, k + 1) || func_301_k(world, i, j - 1, k) || func_301_k(world, i, j + 1, k))
                    {
                        world.func_690_d(i, j, k, Block.field_402_as.field_376_bc);
                        return;
                    }
                    continue;
                }
                if(Block.field_345_n[j1].field_356_bn.func_880_c())
                {
                    return;
                }
            }

        }
    }

    private boolean func_301_k(World world, int i, int j, int k)
    {
        return world.func_599_f(i, j, k).func_876_e();
    }
}
