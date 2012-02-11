// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class WorldGenLiquids extends WorldGenerator
{

    private int field_4157_a;

    public WorldGenLiquids(int i)
    {
        field_4157_a = i;
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        if(world.func_600_a(i, j + 1, k) != Block.field_338_u.field_376_bc)
        {
            return false;
        }
        if(world.func_600_a(i, j - 1, k) != Block.field_338_u.field_376_bc)
        {
            return false;
        }
        if(world.func_600_a(i, j, k) != 0 && world.func_600_a(i, j, k) != Block.field_338_u.field_376_bc)
        {
            return false;
        }
        int l = 0;
        if(world.func_600_a(i - 1, j, k) == Block.field_338_u.field_376_bc)
        {
            l++;
        }
        if(world.func_600_a(i + 1, j, k) == Block.field_338_u.field_376_bc)
        {
            l++;
        }
        if(world.func_600_a(i, j, k - 1) == Block.field_338_u.field_376_bc)
        {
            l++;
        }
        if(world.func_600_a(i, j, k + 1) == Block.field_338_u.field_376_bc)
        {
            l++;
        }
        int i1 = 0;
        if(world.func_20084_d(i - 1, j, k))
        {
            i1++;
        }
        if(world.func_20084_d(i + 1, j, k))
        {
            i1++;
        }
        if(world.func_20084_d(i, j, k - 1))
        {
            i1++;
        }
        if(world.func_20084_d(i, j, k + 1))
        {
            i1++;
        }
        if(l == 3 && i1 == 1)
        {
            world.func_690_d(i, j, k, field_4157_a);
            world.field_4214_a = true;
            Block.field_345_n[field_4157_a].func_208_a(world, i, j, k, random);
            world.field_4214_a = false;
        }
        return true;
    }
}
