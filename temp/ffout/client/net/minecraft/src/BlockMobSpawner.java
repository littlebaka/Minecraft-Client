// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, TileEntityMobSpawner, TileEntity

public class BlockMobSpawner extends BlockContainer
{

    protected BlockMobSpawner(int i, int j)
    {
        super(i, j, Material.field_1334_d);
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityMobSpawner();
    }

    public int func_240_a(int i, Random random, int j)
    {
        return 0;
    }

    public int func_229_a(Random random)
    {
        return 0;
    }

    public boolean func_217_b()
    {
        return false;
    }
}
