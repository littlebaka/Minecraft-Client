// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentOxygen extends Enchantment
{

    public EnchantmentOxygen(int i, int j)
    {
        super(i, j, EnumEnchantmentType.armor_head);
        func_40494_a("oxygen");
    }

    public int func_40492_a(int i)
    {
        return 10 * i;
    }

    public int func_40489_b(int i)
    {
        return func_40492_a(i) + 30;
    }

    public int func_40491_a()
    {
        return 3;
    }
}
