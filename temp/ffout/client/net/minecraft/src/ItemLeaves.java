// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, BlockLeaves, ColorizerFoliage

public class ItemLeaves extends ItemBlock
{

    public ItemLeaves(int i)
    {
        super(i);
        func_21013_d(0);
        func_21015_a(true);
    }

    public int func_21012_a(int i)
    {
        return i | 4;
    }

    public int func_27009_a(int i)
    {
        return Block.field_384_L.func_232_a(0, i);
    }

    public int func_27010_f(int i, int j)
    {
        if((i & 1) == 1)
        {
            return ColorizerFoliage.func_21175_a();
        }
        if((i & 2) == 2)
        {
            return ColorizerFoliage.func_21174_b();
        } else
        {
            return ColorizerFoliage.func_31073_c();
        }
    }
}
