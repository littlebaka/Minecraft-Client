// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType, DamageSource

public class EnchantmentProtection extends Enchantment
{

    private static final String field_40520_w[] = {
        "all", "fire", "fall", "explosion", "projectile"
    };
    private static final int field_40524_x[] = {
        1, 10, 5, 5, 3
    };
    private static final int field_40523_y[] = {
        16, 8, 6, 8, 6
    };
    private static final int field_40522_z[] = {
        20, 12, 10, 12, 15
    };
    public final int field_40521_v;

    public EnchantmentProtection(int i, int j, int k)
    {
        super(i, j, EnumEnchantmentType.armor);
        field_40521_v = k;
        if(k == 2)
        {
            field_40515_t = EnumEnchantmentType.armor_feet;
        }
    }

    public int func_40492_a(int i)
    {
        return field_40524_x[field_40521_v] + (i - 1) * field_40523_y[field_40521_v];
    }

    public int func_40489_b(int i)
    {
        return func_40492_a(i) + field_40522_z[field_40521_v];
    }

    public int func_40491_a()
    {
        return 4;
    }

    public int func_40497_a(int i, DamageSource damagesource)
    {
        if(damagesource.func_35529_d())
        {
            return 0;
        }
        int j = (6 + i * i) / 2;
        if(field_40521_v == 0)
        {
            return j;
        }
        if(field_40521_v == 1 && damagesource.func_40543_k())
        {
            return j;
        }
        if(field_40521_v == 2 && damagesource == DamageSource.field_35549_h)
        {
            return j * 2;
        }
        if(field_40521_v == 3 && damagesource == DamageSource.field_35548_k)
        {
            return j;
        }
        if(field_40521_v == 4 && damagesource.func_40547_b())
        {
            return j;
        } else
        {
            return 0;
        }
    }

    public String func_40488_d()
    {
        return (new StringBuilder()).append("enchantment.protect.").append(field_40520_w[field_40521_v]).toString();
    }

    public boolean func_40496_a(Enchantment enchantment)
    {
        if(enchantment instanceof EnchantmentProtection)
        {
            EnchantmentProtection enchantmentprotection = (EnchantmentProtection)enchantment;
            if(enchantmentprotection.field_40521_v == field_40521_v)
            {
                return false;
            }
            return field_40521_v == 2 || enchantmentprotection.field_40521_v == 2;
        } else
        {
            return super.func_40496_a(enchantment);
        }
    }

}
