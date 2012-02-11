// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, IInvBasic, EntityPlayer

public class InventoryBasic
    implements IInventory
{

    private String field_20072_a;
    private int field_20071_b;
    private ItemStack field_20074_c[];
    private List field_20073_d;

    public InventoryBasic(String s, int i)
    {
        field_20072_a = s;
        field_20071_b = i;
        field_20074_c = new ItemStack[i];
    }

    public ItemStack func_468_c(int i)
    {
        return field_20074_c[i];
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(field_20074_c[i] != null)
        {
            if(field_20074_c[i].field_1615_a <= j)
            {
                ItemStack itemstack = field_20074_c[i];
                field_20074_c[i] = null;
                func_474_j_();
                return itemstack;
            }
            ItemStack itemstack1 = field_20074_c[i].func_1085_a(j);
            if(field_20074_c[i].field_1615_a == 0)
            {
                field_20074_c[i] = null;
            }
            func_474_j_();
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        field_20074_c[i] = itemstack;
        if(itemstack != null && itemstack.field_1615_a > func_470_e())
        {
            itemstack.field_1615_a = func_470_e();
        }
        func_474_j_();
    }

    public int func_469_c()
    {
        return field_20071_b;
    }

    public String func_471_d()
    {
        return field_20072_a;
    }

    public int func_470_e()
    {
        return 64;
    }

    public void func_474_j_()
    {
        if(field_20073_d != null)
        {
            for(int i = 0; i < field_20073_d.size(); i++)
            {
                ((IInvBasic)field_20073_d.get(i)).func_20134_a(this);
            }

        }
    }

    public boolean func_20070_a_(EntityPlayer entityplayer)
    {
        return true;
    }

    public void func_35142_x_()
    {
    }

    public void func_35141_y_()
    {
    }
}
