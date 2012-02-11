// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, EntityPlayer

public class InventoryCraftResult
    implements IInventory
{

    private ItemStack field_818_a[];

    public InventoryCraftResult()
    {
        field_818_a = new ItemStack[1];
    }

    public int func_469_c()
    {
        return 1;
    }

    public ItemStack func_468_c(int i)
    {
        return field_818_a[i];
    }

    public String func_471_d()
    {
        return "Result";
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(field_818_a[i] != null)
        {
            ItemStack itemstack = field_818_a[i];
            field_818_a[i] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        field_818_a[i] = itemstack;
    }

    public int func_470_e()
    {
        return 64;
    }

    public void func_474_j_()
    {
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
