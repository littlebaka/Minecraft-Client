// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, Item, ItemPotion, 
//            AchievementList, EntityPlayer, ContainerBrewingStand, IInventory

class SlotBrewingStandPotion extends Slot
{

    private EntityPlayer field_40440_f;
    final ContainerBrewingStand field_40441_a; /* synthetic field */

    public SlotBrewingStandPotion(ContainerBrewingStand containerbrewingstand, EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
    {
        field_40441_a = containerbrewingstand;
        super(iinventory, i, j, k);
        field_40440_f = entityplayer;
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        return itemstack != null && (itemstack.field_1617_c == Item.field_40413_bs.field_291_aS || itemstack.field_1617_c == Item.field_40416_bt.field_291_aS);
    }

    public int func_4104_e()
    {
        return 1;
    }

    public void func_4103_a(ItemStack itemstack)
    {
        if(itemstack.field_1617_c == Item.field_40413_bs.field_291_aS && itemstack.func_21181_i() > 0)
        {
            field_40440_f.func_25058_a(AchievementList.field_40461_A, 1);
        }
        super.func_4103_a(itemstack);
    }
}
