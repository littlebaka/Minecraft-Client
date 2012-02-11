// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, NBTTagCompound, EntityPlayer, 
//            PlayerCapabilities, NBTTagList, Block, Material, 
//            ItemArmor, Entity

public class InventoryPlayer
    implements IInventory
{

    public ItemStack field_843_a[];
    public ItemStack field_842_b[];
    public int field_847_d;
    public EntityPlayer field_844_g;
    private ItemStack field_20077_f;
    public boolean field_845_f;

    public InventoryPlayer(EntityPlayer entityplayer)
    {
        field_843_a = new ItemStack[36];
        field_842_b = new ItemStack[4];
        field_847_d = 0;
        field_845_f = false;
        field_844_g = entityplayer;
    }

    public ItemStack func_494_a()
    {
        if(field_847_d < 9 && field_847_d >= 0)
        {
            return field_843_a[field_847_d];
        } else
        {
            return null;
        }
    }

    private int func_505_f(int i)
    {
        for(int j = 0; j < field_843_a.length; j++)
        {
            if(field_843_a[j] != null && field_843_a[j].field_1617_c == i)
            {
                return j;
            }
        }

        return -1;
    }

    private int func_41021_b(int i, int j)
    {
        for(int k = 0; k < field_843_a.length; k++)
        {
            if(field_843_a[k] != null && field_843_a[k].field_1617_c == i && field_843_a[k].func_21181_i() == j)
            {
                return k;
            }
        }

        return -1;
    }

    private int func_21105_c(ItemStack itemstack)
    {
        for(int i = 0; i < field_843_a.length; i++)
        {
            if(field_843_a[i] != null && field_843_a[i].field_1617_c == itemstack.field_1617_c && field_843_a[i].func_21180_d() && field_843_a[i].field_1615_a < field_843_a[i].func_1089_c() && field_843_a[i].field_1615_a < func_470_e() && (!field_843_a[i].func_21183_f() || field_843_a[i].func_21181_i() == itemstack.func_21181_i()) && ItemStack.func_46154_a(field_843_a[i], itemstack))
            {
                return i;
            }
        }

        return -1;
    }

    private int func_499_j()
    {
        for(int i = 0; i < field_843_a.length; i++)
        {
            if(field_843_a[i] == null)
            {
                return i;
            }
        }

        return -1;
    }

    public void func_496_a(int i, int j, boolean flag, boolean flag1)
    {
        int k = -1;
        if(flag)
        {
            k = func_41021_b(i, j);
        } else
        {
            k = func_505_f(i);
        }
        if(k >= 0 && k < 9)
        {
            field_847_d = k;
            return;
        } else
        {
            return;
        }
    }

    public void func_498_a(int i)
    {
        if(i > 0)
        {
            i = 1;
        }
        if(i < 0)
        {
            i = -1;
        }
        for(field_847_d -= i; field_847_d < 0; field_847_d += 9) { }
        for(; field_847_d >= 9; field_847_d -= 9) { }
    }

    private int func_21106_d(ItemStack itemstack)
    {
        int i = itemstack.field_1617_c;
        int j = itemstack.field_1615_a;
        if(itemstack.func_1089_c() == 1)
        {
            int k = func_499_j();
            if(k < 0)
            {
                return j;
            }
            if(field_843_a[k] == null)
            {
                field_843_a[k] = ItemStack.func_30010_b(itemstack);
            }
            return 0;
        }
        int l = func_21105_c(itemstack);
        if(l < 0)
        {
            l = func_499_j();
        }
        if(l < 0)
        {
            return j;
        }
        if(field_843_a[l] == null)
        {
            field_843_a[l] = new ItemStack(i, 0, itemstack.func_21181_i());
            if(itemstack.func_40710_n())
            {
                field_843_a[l].func_40706_d((NBTTagCompound)itemstack.func_40709_o().func_40195_b());
            }
        }
        int i1 = j;
        if(i1 > field_843_a[l].func_1089_c() - field_843_a[l].field_1615_a)
        {
            i1 = field_843_a[l].func_1089_c() - field_843_a[l].field_1615_a;
        }
        if(i1 > func_470_e() - field_843_a[l].field_1615_a)
        {
            i1 = func_470_e() - field_843_a[l].field_1615_a;
        }
        if(i1 == 0)
        {
            return j;
        } else
        {
            j -= i1;
            field_843_a[l].field_1615_a += i1;
            field_843_a[l].field_1614_b = 5;
            return j;
        }
    }

    public void func_511_b()
    {
        for(int i = 0; i < field_843_a.length; i++)
        {
            if(field_843_a[i] != null)
            {
                field_843_a[i].func_28153_a(field_844_g.field_615_ag, field_844_g, i, field_847_d == i);
            }
        }

    }

    public boolean func_510_b(int i)
    {
        int j = func_505_f(i);
        if(j < 0)
        {
            return false;
        }
        if(--field_843_a[j].field_1615_a <= 0)
        {
            field_843_a[j] = null;
        }
        return true;
    }

    public boolean func_35157_d(int i)
    {
        int j = func_505_f(i);
        return j >= 0;
    }

    public boolean func_504_a(ItemStack itemstack)
    {
        if(!itemstack.func_21185_g())
        {
            int i;
            do
            {
                i = itemstack.field_1615_a;
                itemstack.field_1615_a = func_21106_d(itemstack);
            } while(itemstack.field_1615_a > 0 && itemstack.field_1615_a < i);
            if(itemstack.field_1615_a == i && field_844_g.field_35212_aW.field_35756_d)
            {
                itemstack.field_1615_a = 0;
                return true;
            } else
            {
                return itemstack.field_1615_a < i;
            }
        }
        int j = func_499_j();
        if(j >= 0)
        {
            field_843_a[j] = ItemStack.func_30010_b(itemstack);
            field_843_a[j].field_1614_b = 5;
            itemstack.field_1615_a = 0;
            return true;
        }
        if(field_844_g.field_35212_aW.field_35756_d)
        {
            itemstack.field_1615_a = 0;
            return true;
        } else
        {
            return false;
        }
    }

    public ItemStack func_473_a(int i, int j)
    {
        ItemStack aitemstack[] = field_843_a;
        if(i >= field_843_a.length)
        {
            aitemstack = field_842_b;
            i -= field_843_a.length;
        }
        if(aitemstack[i] != null)
        {
            if(aitemstack[i].field_1615_a <= j)
            {
                ItemStack itemstack = aitemstack[i];
                aitemstack[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = aitemstack[i].func_1085_a(j);
            if(aitemstack[i].field_1615_a == 0)
            {
                aitemstack[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        ItemStack aitemstack[] = field_843_a;
        if(i >= aitemstack.length)
        {
            i -= aitemstack.length;
            aitemstack = field_842_b;
        }
        aitemstack[i] = itemstack;
    }

    public float func_508_a(Block block)
    {
        float f = 1.0F;
        if(field_843_a[field_847_d] != null)
        {
            f *= field_843_a[field_847_d].func_1098_a(block);
        }
        return f;
    }

    public NBTTagList func_493_a(NBTTagList nbttaglist)
    {
        for(int i = 0; i < field_843_a.length; i++)
        {
            if(field_843_a[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_761_a("Slot", (byte)i);
                field_843_a[i].func_1086_a(nbttagcompound);
                nbttaglist.func_742_a(nbttagcompound);
            }
        }

        for(int j = 0; j < field_842_b.length; j++)
        {
            if(field_842_b[j] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_761_a("Slot", (byte)(j + 100));
                field_842_b[j].func_1086_a(nbttagcompound1);
                nbttaglist.func_742_a(nbttagcompound1);
            }
        }

        return nbttaglist;
    }

    public void func_513_b(NBTTagList nbttaglist)
    {
        field_843_a = new ItemStack[36];
        field_842_b = new ItemStack[4];
        for(int i = 0; i < nbttaglist.func_740_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_741_a(i);
            int j = nbttagcompound.func_746_c("Slot") & 0xff;
            ItemStack itemstack = ItemStack.func_35864_a(nbttagcompound);
            if(itemstack == null)
            {
                continue;
            }
            if(j >= 0 && j < field_843_a.length)
            {
                field_843_a[j] = itemstack;
            }
            if(j >= 100 && j < field_842_b.length + 100)
            {
                field_842_b[j - 100] = itemstack;
            }
        }

    }

    public int func_469_c()
    {
        return field_843_a.length + 4;
    }

    public ItemStack func_468_c(int i)
    {
        ItemStack aitemstack[] = field_843_a;
        if(i >= aitemstack.length)
        {
            i -= aitemstack.length;
            aitemstack = field_842_b;
        }
        return aitemstack[i];
    }

    public String func_471_d()
    {
        return "Inventory";
    }

    public int func_470_e()
    {
        return 64;
    }

    public int func_502_a(Entity entity)
    {
        ItemStack itemstack = func_468_c(field_847_d);
        if(itemstack != null)
        {
            return itemstack.func_1095_a(entity);
        } else
        {
            return 1;
        }
    }

    public boolean func_509_b(Block block)
    {
        if(block.field_356_bn.func_31061_i())
        {
            return true;
        }
        ItemStack itemstack = func_468_c(field_847_d);
        if(itemstack != null)
        {
            return itemstack.func_1099_b(block);
        } else
        {
            return false;
        }
    }

    public ItemStack func_492_d(int i)
    {
        return field_842_b[i];
    }

    public int func_506_f()
    {
        int i = 0;
        for(int j = 0; j < field_842_b.length; j++)
        {
            if(field_842_b[j] != null && (field_842_b[j].func_1091_a() instanceof ItemArmor))
            {
                int k = ((ItemArmor)field_842_b[j].func_1091_a()).field_312_aY;
                i += k;
            }
        }

        return i;
    }

    public void func_507_e(int i)
    {
        i /= 4;
        if(i < 1)
        {
            i = 1;
        }
        for(int j = 0; j < field_842_b.length; j++)
        {
            if(field_842_b[j] == null || !(field_842_b[j].func_1091_a() instanceof ItemArmor))
            {
                continue;
            }
            field_842_b[j].func_25190_a(i, field_844_g);
            if(field_842_b[j].field_1615_a == 0)
            {
                field_842_b[j].func_1097_a(field_844_g);
                field_842_b[j] = null;
            }
        }

    }

    public void func_503_g()
    {
        for(int i = 0; i < field_843_a.length; i++)
        {
            if(field_843_a[i] != null)
            {
                field_844_g.func_444_a(field_843_a[i], true);
                field_843_a[i] = null;
            }
        }

        for(int j = 0; j < field_842_b.length; j++)
        {
            if(field_842_b[j] != null)
            {
                field_844_g.func_444_a(field_842_b[j], true);
                field_842_b[j] = null;
            }
        }

    }

    public void func_474_j_()
    {
        field_845_f = true;
    }

    public void func_20076_b(ItemStack itemstack)
    {
        field_20077_f = itemstack;
        field_844_g.func_20058_b(itemstack);
    }

    public ItemStack func_20075_i()
    {
        return field_20077_f;
    }

    public boolean func_20070_a_(EntityPlayer entityplayer)
    {
        if(field_844_g.field_646_aA)
        {
            return false;
        }
        return entityplayer.func_387_e(field_844_g) <= 64D;
    }

    public boolean func_28018_c(ItemStack itemstack)
    {
        for(int i = 0; i < field_842_b.length; i++)
        {
            if(field_842_b[i] != null && field_842_b[i].func_28154_b(itemstack))
            {
                return true;
            }
        }

        for(int j = 0; j < field_843_a.length; j++)
        {
            if(field_843_a[j] != null && field_843_a[j].func_28154_b(itemstack))
            {
                return true;
            }
        }

        return false;
    }

    public void func_35142_x_()
    {
    }

    public void func_35141_y_()
    {
    }

    public void func_41022_a(InventoryPlayer inventoryplayer)
    {
        for(int i = 0; i < field_843_a.length; i++)
        {
            field_843_a[i] = ItemStack.func_30010_b(inventoryplayer.field_843_a[i]);
        }

        for(int j = 0; j < field_842_b.length; j++)
        {
            field_842_b[j] = ItemStack.func_30010_b(inventoryplayer.field_842_b[j]);
        }

    }
}
