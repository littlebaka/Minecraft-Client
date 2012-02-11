// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item

public class BlockMelon extends Block
{

    protected BlockMelon(int i)
    {
        super(i, Material.field_4261_w);
        field_378_bb = 136;
    }

    public int func_232_a(int i, int j)
    {
        return i != 1 && i != 0 ? 136 : 137;
    }

    public int func_218_a(int i)
    {
        return i != 1 && i != 0 ? 136 : 137;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_35421_bg.field_291_aS;
    }

    public int func_229_a(Random random)
    {
        return 3 + random.nextInt(5);
    }

    public int func_40198_a(int i, Random random)
    {
        int j = func_229_a(random) + random.nextInt(1 + i);
        if(j > 9)
        {
            j = 9;
        }
        return j;
    }
}
