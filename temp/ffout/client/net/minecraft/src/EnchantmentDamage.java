// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType, EntityLiving, EnumCreatureAttribute

public class EnchantmentDamage extends Enchantment
{

    private static final String field_40525_w[] = {
        "all", "undead", "arthropods"
    };
    private static final int field_40529_x[] = {
        1, 5, 5
    };
    private static final int field_40528_y[] = {
        16, 8, 8
    };
    private static final int field_40527_z[] = {
        20, 20, 20
    };
    public final int field_40526_v;

    public EnchantmentDamage(int i, int j, int k)
    {
        super(i, j, EnumEnchantmentType.weapon);
        field_40526_v = k;
    }

    public int func_40492_a(int i)
    {
        return field_40529_x[field_40526_v] + (i - 1) * field_40528_y[field_40526_v];
    }

    public int func_40489_b(int i)
    {
        return func_40492_a(i) + field_40527_z[field_40526_v];
    }

    public int func_40491_a()
    {
        return 5;
    }

    public int func_40490_a(int i, EntityLiving entityliving)
    {
        if(field_40526_v == 0)
        {
            return i * 3;
        }
        if(field_40526_v == 1 && entityliving.func_40124_t() == EnumCreatureAttribute.UNDEAD)
        {
            return i * 4;
        }
        if(field_40526_v == 2 && entityliving.func_40124_t() == EnumCreatureAttribute.ARTHROPOD)
        {
            return i * 4;
        } else
        {
            return 0;
        }
    }

    public String func_40488_d()
    {
        return (new StringBuilder()).append("enchantment.damage.").append(field_40525_w[field_40526_v]).toString();
    }

    public boolean func_40496_a(Enchantment enchantment)
    {
        return !(enchantment instanceof EnchantmentDamage);
    }

}
