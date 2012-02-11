// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentArrowKnockback extends Enchantment
{

    public EnchantmentArrowKnockback(int i, int j)
    {
        super(i, j, EnumEnchantmentType.bow);
        func_40494_a("arrowKnockback");
    }

    public int func_40492_a(int i)
    {
        return 12 + (i - 1) * 20;
    }

    public int func_40489_b(int i)
    {
        return func_40492_a(i) + 25;
    }

    public int func_40491_a()
    {
        return 2;
    }
}
