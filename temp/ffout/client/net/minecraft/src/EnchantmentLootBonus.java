// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentLootBonus extends Enchantment
{

    protected EnchantmentLootBonus(int i, int j, EnumEnchantmentType enumenchantmenttype)
    {
        super(i, j, enumenchantmenttype);
        func_40494_a("lootBonus");
        if(enumenchantmenttype == EnumEnchantmentType.digger)
        {
            func_40494_a("lootBonusDigger");
        }
    }

    public int func_40492_a(int i)
    {
        return 20 + (i - 1) * 12;
    }

    public int func_40489_b(int i)
    {
        return super.func_40492_a(i) + 50;
    }

    public int func_40491_a()
    {
        return 3;
    }

    public boolean func_40496_a(Enchantment enchantment)
    {
        return super.func_40496_a(enchantment) && enchantment.field_40516_s != field_40519_p.field_40516_s;
    }
}
