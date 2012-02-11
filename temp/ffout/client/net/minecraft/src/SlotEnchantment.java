// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ContainerEnchantment, IInventory, ItemStack

class SlotEnchantment extends Slot
{

    final ContainerEnchantment field_40443_a; /* synthetic field */

    SlotEnchantment(ContainerEnchantment containerenchantment, IInventory iinventory, int i, int j, int k)
    {
        field_40443_a = containerenchantment;
        super(iinventory, i, j, k);
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        return true;
    }
}
