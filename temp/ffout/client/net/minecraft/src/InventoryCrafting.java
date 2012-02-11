// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, Container, EntityPlayer

public class InventoryCrafting
    implements IInventory
{

    private ItemStack field_840_a[];
    private int field_21104_b;
    private Container field_841_c;

    public InventoryCrafting(Container container, int i, int j)
    {
        int k = i * j;
        field_840_a = new ItemStack[k];
        field_841_c = container;
        field_21104_b = i;
    }

    public int func_469_c()
    {
        return field_840_a.length;
    }

    public ItemStack func_468_c(int i)
    {
        if(i >= func_469_c())
        {
            return null;
        } else
        {
            return field_840_a[i];
        }
    }

    public ItemStack func_21103_b(int i, int j)
    {
        if(i < 0 || i >= field_21104_b)
        {
            return null;
        } else
        {
            int k = i + j * field_21104_b;
            return func_468_c(k);
        }
    }

    public String func_471_d()
    {
        return "Crafting";
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(field_840_a[i] != null)
        {
            if(field_840_a[i].field_1615_a <= j)
            {
                ItemStack itemstack = field_840_a[i];
                field_840_a[i] = null;
                field_841_c.func_1103_a(this);
                return itemstack;
            }
            ItemStack itemstack1 = field_840_a[i].func_1085_a(j);
            if(field_840_a[i].field_1615_a == 0)
            {
                field_840_a[i] = null;
            }
            field_841_c.func_1103_a(this);
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        field_840_a[i] = itemstack;
        field_841_c.func_1103_a(this);
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
