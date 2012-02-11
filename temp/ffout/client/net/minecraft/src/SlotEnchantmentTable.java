// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            InventoryBasic, ContainerEnchantment

class SlotEnchantmentTable extends InventoryBasic
{

    final ContainerEnchantment field_40070_a; /* synthetic field */

    SlotEnchantmentTable(ContainerEnchantment containerenchantment, String s, int i)
    {
        field_40070_a = containerenchantment;
        super(s, i);
    }

    public int func_470_e()
    {
        return 1;
    }

    public void func_474_j_()
    {
        super.func_474_j_();
        field_40070_a.func_1103_a(this);
    }
}
