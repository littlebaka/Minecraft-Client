// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World

public class BlockMycelium extends Block
{

    protected BlockMycelium(int i)
    {
        super(i, Material.field_28130_b);
        field_378_bb = 77;
        func_253_b(true);
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1)
        {
            return 78;
        }
        return i != 0 ? 77 : 2;
    }

    public int func_211_a(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return 78;
        }
        if(l == 0)
        {
            return 2;
        }
        Material material = iblockaccess.func_599_f(i, j + 1, k);
        return material != Material.field_1319_s && material != Material.field_1318_t ? 77 : 68;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.field_1026_y)
        {
            return;
        }
        if(world.func_618_j(i, j + 1, k) < 4 && Block.field_341_r[world.func_600_a(i, j + 1, k)] > 2)
        {
            world.func_690_d(i, j, k, Block.field_336_w.field_376_bc);
        } else
        if(world.func_618_j(i, j + 1, k) >= 9)
        {
            for(int l = 0; l < 4; l++)
            {
                int i1 = (i + random.nextInt(3)) - 1;
                int j1 = (j + random.nextInt(5)) - 3;
                int k1 = (k + random.nextInt(3)) - 1;
                int l1 = world.func_600_a(i1, j1 + 1, k1);
                if(world.func_600_a(i1, j1, k1) == Block.field_336_w.field_376_bc && world.func_618_j(i1, j1 + 1, k1) >= 4 && Block.field_341_r[l1] <= 2)
                {
                    world.func_690_d(i1, j1, k1, field_376_bc);
                }
            }

        }
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        super.func_247_b(world, i, j, k, random);
        if(random.nextInt(10) == 0)
        {
            world.func_694_a("townaura", (float)i + random.nextFloat(), (float)j + 1.1F, (float)k + random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Block.field_336_w.func_240_a(0, random, j);
    }
}
