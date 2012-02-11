// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item

public class BlockBookshelf extends Block
{

    public BlockBookshelf(int i, int j)
    {
        super(i, j, Material.field_1335_c);
    }

    public int func_218_a(int i)
    {
        if(i <= 1)
        {
            return 4;
        } else
        {
            return field_378_bb;
        }
    }

    public int func_229_a(Random random)
    {
        return 3;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_4028_aJ.field_291_aS;
    }
}
