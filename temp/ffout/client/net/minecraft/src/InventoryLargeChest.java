// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, EntityPlayer

public class InventoryLargeChest
    implements IInventory
{

    private String field_837_a;
    private IInventory field_836_b;
    private IInventory field_838_c;

    public InventoryLargeChest(String s, IInventory iinventory, IInventory iinventory1)
    {
        field_837_a = s;
        if(iinventory == null)
        {
            iinventory = iinventory1;
        }
        if(iinventory1 == null)
        {
            iinventory1 = iinventory;
        }
        field_836_b = iinventory;
        field_838_c = iinventory1;
    }

    public int func_469_c()
    {
        return field_836_b.func_469_c() + field_838_c.func_469_c();
    }

    public String func_471_d()
    {
        return field_837_a;
    }

    public ItemStack func_468_c(int i)
    {
        if(i >= field_836_b.func_469_c())
        {
            return field_838_c.func_468_c(i - field_836_b.func_469_c());
        } else
        {
            return field_836_b.func_468_c(i);
        }
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(i >= field_836_b.func_469_c())
        {
            return field_838_c.func_473_a(i - field_836_b.func_469_c(), j);
        } else
        {
            return field_836_b.func_473_a(i, j);
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        if(i >= field_836_b.func_469_c())
        {
            field_838_c.func_472_a(i - field_836_b.func_469_c(), itemstack);
        } else
        {
            field_836_b.func_472_a(i, itemstack);
        }
    }

    public int func_470_e()
    {
        return field_836_b.func_470_e();
    }

    public void func_474_j_()
    {
        field_836_b.func_474_j_();
        field_838_c.func_474_j_();
    }

    public boolean func_20070_a_(EntityPlayer entityplayer)
    {
        return field_836_b.func_20070_a_(entityplayer) && field_838_c.func_20070_a_(entityplayer);
    }

    public void func_35142_x_()
    {
        field_836_b.func_35142_x_();
        field_838_c.func_35142_x_();
    }

    public void func_35141_y_()
    {
        field_836_b.func_35141_y_();
        field_838_c.func_35141_y_();
    }
}
