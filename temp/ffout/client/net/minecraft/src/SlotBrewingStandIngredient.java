// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, Item, ItemStack, ContainerBrewingStand, 
//            IInventory

class SlotBrewingStandIngredient extends Slot
{

    final ContainerBrewingStand field_40442_a; /* synthetic field */

    public SlotBrewingStandIngredient(ContainerBrewingStand containerbrewingstand, IInventory iinventory, int i, int j, int k)
    {
        field_40442_a = containerbrewingstand;
        super(iinventory, i, j, k);
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        if(itemstack != null)
        {
            return Item.field_233_c[itemstack.field_1617_c].func_40406_n();
        } else
        {
            return false;
        }
    }

    public int func_4104_e()
    {
        return 64;
    }
}
