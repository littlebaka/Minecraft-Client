// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, EntityPlayer, ItemStack, Block, 
//            AchievementList, Item, IInventory, InventoryPlayer

public class SlotCrafting extends Slot
{

    private final IInventory field_1125_c;
    private EntityPlayer field_25015_e;

    public SlotCrafting(EntityPlayer entityplayer, IInventory iinventory, IInventory iinventory1, int i, int j, int k)
    {
        super(iinventory1, i, j, k);
        field_25015_e = entityplayer;
        field_1125_c = iinventory;
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        return false;
    }

    public void func_4103_a(ItemStack itemstack)
    {
        itemstack.func_28155_b(field_25015_e.field_615_ag, field_25015_e);
        if(itemstack.field_1617_c == Block.field_387_az.field_376_bc)
        {
            field_25015_e.func_25058_a(AchievementList.field_25197_d, 1);
        } else
        if(itemstack.field_1617_c == Item.field_218_r.field_291_aS)
        {
            field_25015_e.func_25058_a(AchievementList.field_27387_i, 1);
        } else
        if(itemstack.field_1617_c == Block.field_445_aC.field_376_bc)
        {
            field_25015_e.func_25058_a(AchievementList.field_27386_j, 1);
        } else
        if(itemstack.field_1617_c == Item.field_249_L.field_291_aS)
        {
            field_25015_e.func_25058_a(AchievementList.field_27384_l, 1);
        } else
        if(itemstack.field_1617_c == Item.field_242_S.field_291_aS)
        {
            field_25015_e.func_25058_a(AchievementList.field_27383_m, 1);
        } else
        if(itemstack.field_1617_c == Item.field_21022_aX.field_291_aS)
        {
            field_25015_e.func_25058_a(AchievementList.field_27382_n, 1);
        } else
        if(itemstack.field_1617_c == Item.field_214_v.field_291_aS)
        {
            field_25015_e.func_25058_a(AchievementList.field_27381_o, 1);
        } else
        if(itemstack.field_1617_c == Item.field_220_p.field_291_aS)
        {
            field_25015_e.func_25058_a(AchievementList.field_27378_r, 1);
        } else
        if(itemstack.field_1617_c == Block.field_40210_bF.field_376_bc)
        {
            field_25015_e.func_25058_a(AchievementList.field_40458_D, 1);
        } else
        if(itemstack.field_1617_c == Block.field_407_ao.field_376_bc)
        {
            field_25015_e.func_25058_a(AchievementList.field_40460_F, 1);
        }
        for(int i = 0; i < field_1125_c.func_469_c(); i++)
        {
            ItemStack itemstack1 = field_1125_c.func_468_c(i);
            if(itemstack1 == null)
            {
                continue;
            }
            field_1125_c.func_473_a(i, 1);
            if(!itemstack1.func_1091_a().func_21014_i())
            {
                continue;
            }
            ItemStack itemstack2 = new ItemStack(itemstack1.func_1091_a().func_21016_h());
            if(itemstack1.func_1091_a().func_46059_i(itemstack1) && field_25015_e.field_778_b.func_504_a(itemstack2))
            {
                continue;
            }
            if(field_1125_c.func_468_c(i) == null)
            {
                field_1125_c.func_472_a(i, itemstack2);
            } else
            {
                field_25015_e.func_449_a(itemstack2);
            }
        }

    }
}
