// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, SlotFurnace, InventoryPlayer, 
//            ICrafting, TileEntityFurnace, ItemStack, EntityPlayer

public class ContainerFurnace extends Container
{

    private TileEntityFurnace field_20127_a;
    private int field_20126_b;
    private int field_20129_c;
    private int field_20128_h;

    public ContainerFurnace(InventoryPlayer inventoryplayer, TileEntityFurnace tileentityfurnace)
    {
        field_20126_b = 0;
        field_20129_c = 0;
        field_20128_h = 0;
        field_20127_a = tileentityfurnace;
        func_20117_a(new Slot(tileentityfurnace, 0, 56, 17));
        func_20117_a(new Slot(tileentityfurnace, 1, 56, 53));
        func_20117_a(new SlotFurnace(inventoryplayer.field_844_g, tileentityfurnace, 2, 116, 35));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                func_20117_a(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            func_20117_a(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }

    }

    public void func_20114_a()
    {
        super.func_20114_a();
        for(int i = 0; i < field_20121_g.size(); i++)
        {
            ICrafting icrafting = (ICrafting)field_20121_g.get(i);
            if(field_20126_b != field_20127_a.field_834_d)
            {
                icrafting.func_20158_a(this, 0, field_20127_a.field_834_d);
            }
            if(field_20129_c != field_20127_a.field_832_b)
            {
                icrafting.func_20158_a(this, 1, field_20127_a.field_832_b);
            }
            if(field_20128_h != field_20127_a.field_835_c)
            {
                icrafting.func_20158_a(this, 2, field_20127_a.field_835_c);
            }
        }

        field_20126_b = field_20127_a.field_834_d;
        field_20129_c = field_20127_a.field_832_b;
        field_20128_h = field_20127_a.field_835_c;
    }

    public void func_20112_a(int i, int j)
    {
        if(i == 0)
        {
            field_20127_a.field_834_d = j;
        }
        if(i == 1)
        {
            field_20127_a.field_832_b = j;
        }
        if(i == 2)
        {
            field_20127_a.field_835_c = j;
        }
    }

    public boolean func_20120_b(EntityPlayer entityplayer)
    {
        return field_20127_a.func_20070_a_(entityplayer);
    }

    public ItemStack func_27279_a(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_20122_e.get(i);
        if(slot != null && slot.func_20005_c())
        {
            ItemStack itemstack1 = slot.func_777_b();
            itemstack = itemstack1.func_1102_e();
            if(i == 2)
            {
                if(!func_28125_a(itemstack1, 3, 39, true))
                {
                    return null;
                }
            } else
            if(i >= 3 && i < 30)
            {
                if(!func_28125_a(itemstack1, 30, 39, false))
                {
                    return null;
                }
            } else
            if(i >= 30 && i < 39)
            {
                if(!func_28125_a(itemstack1, 3, 30, false))
                {
                    return null;
                }
            } else
            if(!func_28125_a(itemstack1, 3, 39, false))
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
