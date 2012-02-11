// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, EntityPlayer

public class TileEntityDispenser extends TileEntity
    implements IInventory
{

    private ItemStack field_21102_a[];
    private Random field_21101_b;

    public TileEntityDispenser()
    {
        field_21102_a = new ItemStack[9];
        field_21101_b = new Random();
    }

    public int func_469_c()
    {
        return 9;
    }

    public ItemStack func_468_c(int i)
    {
        return field_21102_a[i];
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(field_21102_a[i] != null)
        {
            if(field_21102_a[i].field_1615_a <= j)
            {
                ItemStack itemstack = field_21102_a[i];
                field_21102_a[i] = null;
                func_474_j_();
                return itemstack;
            }
            ItemStack itemstack1 = field_21102_a[i].func_1085_a(j);
            if(field_21102_a[i].field_1615_a == 0)
            {
                field_21102_a[i] = null;
            }
            func_474_j_();
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public ItemStack func_21100_b()
    {
        int i = -1;
        int j = 1;
        for(int k = 0; k < field_21102_a.length; k++)
        {
            if(field_21102_a[k] != null && field_21101_b.nextInt(j++) == 0)
            {
                i = k;
            }
        }

        if(i >= 0)
        {
            return func_473_a(i, 1);
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        field_21102_a[i] = itemstack;
        if(itemstack != null && itemstack.field_1615_a > func_470_e())
        {
            itemstack.field_1615_a = func_470_e();
        }
        func_474_j_();
    }

    public String func_471_d()
    {
        return "Trap";
    }

    public void func_482_a(NBTTagCompound nbttagcompound)
    {
        super.func_482_a(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.func_753_l("Items");
        field_21102_a = new ItemStack[func_469_c()];
        for(int i = 0; i < nbttaglist.func_740_c(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_741_a(i);
            int j = nbttagcompound1.func_746_c("Slot") & 0xff;
            if(j >= 0 && j < field_21102_a.length)
            {
                field_21102_a[j] = ItemStack.func_35864_a(nbttagcompound1);
            }
        }

    }

    public void func_481_b(NBTTagCompound nbttagcompound)
    {
        super.func_481_b(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_21102_a.length; i++)
        {
            if(field_21102_a[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_761_a("Slot", (byte)i);
                field_21102_a[i].func_1086_a(nbttagcompound1);
                nbttaglist.func_742_a(nbttagcompound1);
            }
        }

        nbttagcompound.func_762_a("Items", nbttaglist);
    }

    public int func_470_e()
    {
        return 64;
    }

    public boolean func_20070_a_(EntityPlayer entityplayer)
    {
        if(field_824_e.func_603_b(field_823_f, field_822_g, field_821_h) != this)
        {
            return false;
        }
        return entityplayer.func_360_d((double)field_823_f + 0.5D, (double)field_822_g + 0.5D, (double)field_821_h + 0.5D) <= 64D;
    }

    public void func_35142_x_()
    {
    }

    public void func_35141_y_()
    {
    }
}
