// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentFireAspect extends Enchantment
{

    protected EnchantmentFireAspect(int i, int j)
    {
        super(i, j, EnumEnchantmentType.weapon);
        func_40494_a("fire");
    }

    public int func_40492_a(int i)
    {
        return 10 + 20 * (i - 1);
    }

    public int func_40489_b(int i)
    {
        return super.func_40492_a(i) + 50;
    }

    public int func_40491_a()
    {
        return 2;
    }
}
