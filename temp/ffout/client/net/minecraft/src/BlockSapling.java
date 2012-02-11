// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, World, WorldGenTaiga2, WorldGenForest, 
//            WorldGenTrees, WorldGenBigTree, WorldGenerator

public class BlockSapling extends BlockFlower
{

    protected BlockSapling(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
        if(world.field_1026_y)
        {
            return;
        }
        super.func_208_a(world, i, j, k, random);
        if(world.func_618_j(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int l = world.func_602_e(i, j, k);
            if((l & 8) == 0)
            {
                world.func_691_b(i, j, k, l | 8);
            } else
            {
                func_21028_c(world, i, j, k, random);
            }
        }
    }

    public int func_232_a(int i, int j)
    {
        j &= 3;
        if(j == 1)
        {
            return 63;
        }
        if(j == 2)
        {
            return 79;
        } else
        {
            return super.func_232_a(i, j);
        }
    }

    public void func_21028_c(World world, int i, int j, int k, Random random)
    {
        int l = world.func_602_e(i, j, k) & 3;
        world.func_634_a(i, j, k, 0);
        Object obj = null;
        if(l == 1)
        {
            obj = new WorldGenTaiga2(true);
        } else
        if(l == 2)
        {
            obj = new WorldGenForest(true);
        } else
        {
            obj = new WorldGenTrees(true);
            if(random.nextInt(10) == 0)
            {
                obj = new WorldGenBigTree(true);
            }
        }
        if(!((WorldGenerator) (obj)).func_516_a(world, random, i, j, k))
        {
            world.func_643_a(i, j, k, field_376_bc, l);
        }
    }

    protected int func_21025_b(int i)
    {
        return i & 3;
    }
}
