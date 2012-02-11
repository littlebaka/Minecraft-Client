// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item

public class BlockClay extends Block
{

    public BlockClay(int i, int j)
    {
        super(i, j, Material.field_1316_v);
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_303_aG.field_291_aS;
    }

    public int func_229_a(Random random)
    {
        return 4;
    }
}
