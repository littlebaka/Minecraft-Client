// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, EntityPlayer, ItemStack, Item, 
//            AchievementList, IInventory

public class SlotFurnace extends Slot
{

    private EntityPlayer field_27011_d;

    public SlotFurnace(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
    {
        super(iinventory, i, j, k);
        field_27011_d = entityplayer;
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        return false;
    }

    public void func_4103_a(ItemStack itemstack)
    {
        itemstack.func_28155_b(field_27011_d.field_615_ag, field_27011_d);
        if(itemstack.field_1617_c == Item.field_223_m.field_291_aS)
        {
            field_27011_d.func_25058_a(AchievementList.field_27385_k, 1);
        }
        if(itemstack.field_1617_c == Item.field_4020_aT.field_291_aS)
        {
            field_27011_d.func_25058_a(AchievementList.field_27380_p, 1);
        }
        super.func_4103_a(itemstack);
    }
}
