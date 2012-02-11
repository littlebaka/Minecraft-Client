// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, Slot, CraftingManager, IInventory, 
//            World, EntityPlayer, Block, ItemStack

public class ContainerWorkbench extends Container
{

    public InventoryCrafting field_1622_a;
    public IInventory field_1621_b;
    private World field_20133_c;
    private int field_20132_h;
    private int field_20131_i;
    private int field_20130_j;

    public ContainerWorkbench(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
        field_1622_a = new InventoryCrafting(this, 3, 3);
        field_1621_b = new InventoryCraftResult();
        field_20133_c = world;
        field_20132_h = i;
        field_20131_i = j;
        field_20130_j = k;
        func_20117_a(new SlotCrafting(inventoryplayer.field_844_g, field_1622_a, field_1621_b, 0, 124, 35));
        for(int l = 0; l < 3; l++)
        {
            for(int k1 = 0; k1 < 3; k1++)
            {
                func_20117_a(new Slot(field_1622_a, k1 + l * 3, 30 + k1 * 18, 17 + l * 18));
            }

        }

        for(int i1 = 0; i1 < 3; i1++)
        {
            for(int l1 = 0; l1 < 9; l1++)
            {
                func_20117_a(new Slot(inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18, 84 + i1 * 18));
            }

        }

        for(int j1 = 0; j1 < 9; j1++)
        {
            func_20117_a(new Slot(inventoryplayer, j1, 8 + j1 * 18, 142));
        }

        func_1103_a(field_1622_a);
    }

    public void func_1103_a(IInventory iinventory)
    {
        field_1621_b.func_472_a(0, CraftingManager.func_1120_a().func_21188_a(field_1622_a));
    }

    public void func_1104_a(EntityPlayer entityplayer)
    {
        super.func_1104_a(entityplayer);
        if(field_20133_c.field_1026_y)
        {
            return;
        }
        for(int i = 0; i < 9; i++)
        {
            ItemStack itemstack = field_1622_a.func_468_c(i);
            if(itemstack != null)
            {
                entityplayer.func_449_a(itemstack);
            }
        }

    }

    public boolean func_20120_b(EntityPlayer entityplayer)
    {
        if(field_20133_c.func_600_a(field_20132_h, field_20131_i, field_20130_j) != Block.field_387_az.field_376_bc)
        {
            return false;
        }
        return entityplayer.func_360_d((double)field_20132_h + 0.5D, (double)field_20131_i + 0.5D, (double)field_20130_j + 0.5D) <= 64D;
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
                if(!func_28125_a(itemstack1, 10, 46, true))
                {
                    return null;
                }
            } else
            if(i >= 10 && i < 37)
            {
                if(!func_28125_a(itemstack1, 37, 46, false))
                {
                    return null;
                }
            } else
            if(i >= 37 && i < 46)
            {
                if(!func_28125_a(itemstack1, 10, 37, false))
                {
                    return null;
                }
            } else
            if(!func_28125_a(itemstack1, 10, 46, false))
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
