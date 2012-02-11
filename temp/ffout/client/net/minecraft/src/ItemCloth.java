// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, BlockCloth, ItemDye, 
//            ItemStack

public class ItemCloth extends ItemBlock
{

    public ItemCloth(int i)
    {
        super(i);
        func_21013_d(0);
        func_21015_a(true);
    }

    public int func_27009_a(int i)
    {
        return Block.field_419_ac.func_232_a(2, BlockCloth.func_21034_c(i));
    }

    public int func_21012_a(int i)
    {
        return i;
    }

    public String func_21011_b(ItemStack itemstack)
    {
        return (new StringBuilder()).append(super.func_20009_a()).append(".").append(ItemDye.field_21023_a[BlockCloth.func_21034_c(itemstack.func_21181_i())]).toString();
    }
}
