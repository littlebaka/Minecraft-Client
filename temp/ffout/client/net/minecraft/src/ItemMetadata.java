// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block

public class ItemMetadata extends ItemBlock
{

    private Block field_35437_a;

    public ItemMetadata(int i, Block block)
    {
        super(i);
        field_35437_a = block;
        func_21013_d(0);
        func_21015_a(true);
    }

    public int func_27009_a(int i)
    {
        return field_35437_a.func_232_a(2, i);
    }

    public int func_21012_a(int i)
    {
        return i;
    }
}
