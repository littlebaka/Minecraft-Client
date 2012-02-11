// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IEnchantmentModifier, Enchantment, DamageSource, Empty3

final class EnchantmentModifierDamage
    implements IEnchantmentModifier
{

    public int field_40246_a;
    public DamageSource field_40245_b;

    private EnchantmentModifierDamage()
    {
    }

    public void func_40244_a(Enchantment enchantment, int i)
    {
        field_40246_a += enchantment.func_40497_a(i, field_40245_b);
    }

    EnchantmentModifierDamage(Empty3 empty3)
    {
        this();
    }
}
