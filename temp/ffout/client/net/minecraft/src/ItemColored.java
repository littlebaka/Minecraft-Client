// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, ItemStack

public class ItemColored extends ItemBlock
{

    private final Block field_35436_a;
    private String field_41034_b[];

    public ItemColored(int i, boolean flag)
    {
        super(i);
        field_35436_a = Block.field_345_n[func_35435_b()];
        if(flag)
        {
            func_21013_d(0);
            func_21015_a(true);
        }
    }

    public int func_27010_f(int i, int j)
    {
        return field_35436_a.func_31030_b(i);
    }

    public int func_27009_a(int i)
    {
        return field_35436_a.func_232_a(0, i);
    }

    public int func_21012_a(int i)
    {
        return i;
    }

    public ItemColored func_41033_a(String as[])
    {
        field_41034_b = as;
        return this;
    }

    public String func_21011_b(ItemStack itemstack)
    {
        if(field_41034_b == null)
        {
            return super.func_21011_b(itemstack);
        }
        int i = itemstack.func_21181_i();
        if(i >= 0 && i < field_41034_b.length)
        {
            return (new StringBuilder()).append(super.func_21011_b(itemstack)).append(".").append(field_41034_b[i]).toString();
        } else
        {
            return super.func_21011_b(itemstack);
        }
    }
}
