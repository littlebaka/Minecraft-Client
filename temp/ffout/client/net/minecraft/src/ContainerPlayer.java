// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, Slot, SlotArmor, CraftingManager, 
//            IInventory, EntityPlayer, ItemStack

public class ContainerPlayer extends Container
{

    public InventoryCrafting field_1620_a;
    public IInventory field_1619_b;
    public boolean field_20124_c;

    public ContainerPlayer(InventoryPlayer inventoryplayer)
    {
        this(inventoryplayer, true);
    }

    public ContainerPlayer(InventoryPlayer inventoryplayer, boolean flag)
    {
        field_1620_a = new InventoryCrafting(this, 2, 2);
        field_1619_b = new InventoryCraftResult();
        field_20124_c = false;
        field_20124_c = flag;
        func_20117_a(new SlotCrafting(inventoryplayer.field_844_g, field_1620_a, field_1619_b, 0, 144, 36));
        for(int i = 0; i < 2; i++)
        {
            for(int i1 = 0; i1 < 2; i1++)
            {
                func_20117_a(new Slot(field_1620_a, i1 + i * 2, 88 + i1 * 18, 26 + i * 18));
            }

        }

        for(int j = 0; j < 4; j++)
        {
            int j1 = j;
            func_20117_a(new SlotArmor(this, inventoryplayer, inventoryplayer.func_469_c() - 1 - j, 8, 8 + j * 18, j1));
        }

        for(int k = 0; k < 3; k++)
        {
            for(int k1 = 0; k1 < 9; k1++)
            {
                func_20117_a(new Slot(inventoryplayer, k1 + (k + 1) * 9, 8 + k1 * 18, 84 + k * 18));
            }

        }

        for(int l = 0; l < 9; l++)
        {
            func_20117_a(new Slot(inventoryplayer, l, 8 + l * 18, 142));
        }

        func_1103_a(field_1620_a);
    }

    public void func_1103_a(IInventory iinventory)
    {
        field_1619_b.func_472_a(0, CraftingManager.func_1120_a().func_21188_a(field_1620_a));
    }

    public void func_1104_a(EntityPlayer entityplayer)
    {
        super.func_1104_a(entityplayer);
        for(int i = 0; i < 4; i++)
        {
            ItemStack itemstack = field_1620_a.func_468_c(i);
            if(itemstack != null)
            {
                entityplayer.func_449_a(itemstack);
                field_1620_a.func_472_a(i, null);
            }
        }

    }

    public boolean func_20120_b(EntityPlayer entityplayer)
    {
        return true;
    }

    public ItemStack func_27279_a(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_20122_e.get(i);
        if(slot != null && slot.func_20005_c())
        {
            ItemStack itemstack1 = slot.func_777_b();
            itemstack = itemstack1.func_1102_e();
            if(i == 0)
            {
                if(!func_28125_a(itemstack1, 9, 45, true))
                {
                    return null;
                }
            } else
            if(i >= 9 && i < 36)
            {
                if(!func_28125_a(itemstack1, 36, 45, false))
                {
                    return null;
                }
            } else
            if(i >= 36 && i < 45)
            {
                if(!func_28125_a(itemstack1, 9, 36, false))
                {
                    return null;
                }
            } else
            if(!func_28125_a(itemstack1, 9, 45, false))
            {
                return null;
            }
            if(itemstack1.field_1615_a == 0)
            {
                slot.func_776_b(null);
            } else
            {
                slot.func_779_d();
            }
            if(itemstack1.field_1615_a != itemstack.field_1615_a)
            {
                slot.func_4103_a(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }
}
