// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, World, 
//            Item, ItemPotion, PotionHelper, NBTTagCompound, 
//            NBTTagList, EntityPlayer

public class TileEntityBrewingStand extends TileEntity
    implements IInventory
{

    private ItemStack field_40058_a[];
    private int field_40056_b;
    private int field_40057_c;
    private int field_40055_d;

    public TileEntityBrewingStand()
    {
        field_40058_a = new ItemStack[4];
    }

    public String func_471_d()
    {
        return "Brewing Stand";
    }

    public int func_469_c()
    {
        return field_40058_a.length;
    }

    public void func_475_b()
    {
        if(field_40056_b > 0)
        {
            field_40056_b--;
            if(field_40056_b == 0)
            {
                func_40052_p();
                func_474_j_();
            } else
            if(!func_40050_o())
            {
                field_40056_b = 0;
                func_474_j_();
            } else
            if(field_40055_d != field_40058_a[3].field_1617_c)
            {
                field_40056_b = 0;
                func_474_j_();
            }
        } else
        if(func_40050_o())
        {
            field_40056_b = 400;
            field_40055_d = field_40058_a[3].field_1617_c;
        }
        int i = func_40054_n();
        if(i != field_40057_c)
        {
            field_40057_c = i;
            field_824_e.func_691_b(field_823_f, field_822_g, field_821_h, i);
        }
        super.func_475_b();
    }

    public int func_40053_g()
    {
        return field_40056_b;
    }

    private boolean func_40050_o()
    {
        if(field_40058_a[3] == null || field_40058_a[3].field_1615_a <= 0)
        {
            return false;
        }
        ItemStack itemstack = field_40058_a[3];
        if(!Item.field_233_c[itemstack.field_1617_c].func_40406_n())
        {
            return false;
        }
        boolean flag = false;
        for(int i = 0; i < 3; i++)
        {
            if(field_40058_a[i] == null || field_40058_a[i].field_1617_c != Item.field_40413_bs.field_291_aS)
            {
                continue;
            }
            int j = field_40058_a[i].func_21181_i();
            int k = func_40051_b(j, itemstack);
            if(!ItemPotion.func_40433_c(j) && ItemPotion.func_40433_c(k))
            {
                flag = true;
                break;
            }
            java.util.List list = Item.field_40413_bs.func_40431_c_(j);
            java.util.List list1 = Item.field_40413_bs.func_40431_c_(k);
            if(j > 0 && list == list1 || list != null && (list.equals(list1) || list1 == null) || j == k)
            {
                continue;
            }
            flag = true;
            break;
        }

        return flag;
    }

    private void func_40052_p()
    {
        if(!func_40050_o())
        {
            return;
        }
        ItemStack itemstack = field_40058_a[3];
        for(int i = 0; i < 3; i++)
        {
            if(field_40058_a[i] == null || field_40058_a[i].field_1617_c != Item.field_40413_bs.field_291_aS)
            {
                continue;
            }
            int j = field_40058_a[i].func_21181_i();
            int k = func_40051_b(j, itemstack);
            java.util.List list = Item.field_40413_bs.func_40431_c_(j);
            java.util.List list1 = Item.field_40413_bs.func_40431_c_(k);
            if(j > 0 && list == list1 || list != null && (list.equals(list1) || list1 == null))
            {
                if(!ItemPotion.func_40433_c(j) && ItemPotion.func_40433_c(k))
                {
                    field_40058_a[i].func_28156_b(k);
                }
                continue;
            }
            if(j != k)
            {
                field_40058_a[i].func_28156_b(k);
            }
        }

        if(Item.field_233_c[itemstack.field_1617_c].func_21014_i())
        {
            field_40058_a[3] = new ItemStack(Item.field_233_c[itemstack.field_1617_c].func_21016_h());
        } else
        {
            field_40058_a[3].field_1615_a--;
            if(field_40058_a[3].field_1615_a <= 0)
            {
                field_40058_a[3] = null;
            }
        }
    }

    private int func_40051_b(int i, ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return i;
        }
        if(Item.field_233_c[itemstack.field_1617_c].func_40406_n())
        {
            return PotionHelper.func_40356_a(i, Item.field_233_c[itemstack.field_1617_c].func_40405_m());
        } else
        {
            return i;
        }
    }

    public void func_482_a(NBTTagCompound nbttagcompound)
    {
        super.func_482_a(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.func_753_l("Items");
        field_40058_a = new ItemStack[func_469_c()];
        for(int i = 0; i < nbttaglist.func_740_c(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_741_a(i);
            byte byte0 = nbttagcompound1.func_746_c("Slot");
            if(byte0 >= 0 && byte0 < field_40058_a.length)
            {
                field_40058_a[byte0] = ItemStack.func_35864_a(nbttagcompound1);
            }
        }

        field_40056_b = nbttagcompound.func_745_d("BrewTime");
    }

    public void func_481_b(NBTTagCompound nbttagcompound)
    {
        super.func_481_b(nbttagcompound);
        nbttagcompound.func_749_a("BrewTime", (short)field_40056_b);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_40058_a.length; i++)
        {
            if(field_40058_a[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_761_a("Slot", (byte)i);
                field_40058_a[i].func_1086_a(nbttagcompound1);
                nbttaglist.func_742_a(nbttagcompound1);
            }
        }

        nbttagcompound.func_762_a("Items", nbttaglist);
    }

    public ItemStack func_468_c(int i)
    {
        if(i >= 0 && i < field_40058_a.length)
        {
            return field_40058_a[i];
        } else
        {
            return null;
        }
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(i >= 0 && i < field_40058_a.length)
        {
            ItemStack itemstack = field_40058_a[i];
            field_40058_a[i] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        if(i >= 0 && i < field_40058_a.length)
        {
            field_40058_a[i] = itemstack;
        }
    }

    public int func_470_e()
    {
        return 1;
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

    public void func_40049_b(int i)
    {
        field_40056_b = i;
    }

    public int func_40054_n()
    {
        int i = 0;
        for(int j = 0; j < 3; j++)
        {
            if(field_40058_a[j] != null)
            {
                i |= 1 << j;
            }
        }

        return i;
    }
}
