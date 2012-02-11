// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockFlower

public class WorldGenDeadBush extends WorldGenerator
{

    private int field_28058_a;

    public WorldGenDeadBush(int i)
    {
        field_28058_a = i;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        for(int l = 0; ((l = world.func_600_a(i, j, k)) == 0 || l == Block.field_384_L.field_376_bc) && j > 0; j--) { }
        for(int i1 = 0; i1 < 4; i1++)
        {
            int j1 = (i + random.nextInt(8)) - random.nextInt(8);
            int k1 = (j + random.nextInt(4)) - random.nextInt(4);
            int l1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(world.func_20084_d(j1, k1, l1) && ((BlockFlower)Block.field_345_n[field_28058_a]).func_223_g(world, j1, k1, l1))
            {
                world.func_634_a(j1, k1, l1, field_28058_a);
            }
        }

        return true;
    }
}
