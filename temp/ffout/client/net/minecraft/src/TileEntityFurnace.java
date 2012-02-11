// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, BlockFurnace, FurnaceRecipes, 
//            Item, Block, Material, EntityPlayer

public class TileEntityFurnace extends TileEntity
    implements IInventory
{

    private ItemStack field_833_a[];
    public int field_832_b;
    public int field_835_c;
    public int field_834_d;

    public TileEntityFurnace()
    {
        field_833_a = new ItemStack[3];
        field_832_b = 0;
        field_835_c = 0;
        field_834_d = 0;
    }

    public int func_469_c()
    {
        return field_833_a.length;
    }

    public ItemStack func_468_c(int i)
    {
        return field_833_a[i];
    }

    public ItemStack func_473_a(int i, int j)
    {
        if(field_833_a[i] != null)
        {
            if(field_833_a[i].field_1615_a <= j)
            {
                ItemStack itemstack = field_833_a[i];
                field_833_a[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = field_833_a[i].func_1085_a(j);
            if(field_833_a[i].field_1615_a == 0)
            {
                field_833_a[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void func_472_a(int i, ItemStack itemstack)
    {
        field_833_a[i] = itemstack;
        if(itemstack != null && itemstack.field_1615_a > func_470_e())
        {
            itemstack.field_1615_a = func_470_e();
        }
    }

    public String func_471_d()
    {
        return "Furnace";
    }

    public void func_482_a(NBTTagCompound nbttagcompound)
    {
        super.func_482_a(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.func_753_l("Items");
        field_833_a = new ItemStack[func_469_c()];
        for(int i = 0; i < nbttaglist.func_740_c(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_741_a(i);
            byte byte0 = nbttagcompound1.func_746_c("Slot");
            if(byte0 >= 0 && byte0 < field_833_a.length)
            {
                field_833_a[byte0] = ItemStack.func_35864_a(nbttagcompound1);
            }
        }

        field_832_b = nbttagcompound.func_745_d("BurnTime");
        field_834_d = nbttagcompound.func_745_d("CookTime");
        field_835_c = func_488_a(field_833_a[1]);
    }

    public void func_481_b(NBTTagCompound nbttagcompound)
    {
        super.func_481_b(nbttagcompound);
        nbttagcompound.func_749_a("BurnTime", (short)field_832_b);
        nbttagcompound.func_749_a("CookTime", (short)field_834_d);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_833_a.length; i++)
        {
            if(field_833_a[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_761_a("Slot", (byte)i);
                field_833_a[i].func_1086_a(nbttagcompound1);
                nbttaglist.func_742_a(nbttagcompound1);
            }
        }

        nbttagcompound.func_762_a("Items", nbttaglist);
    }

    public int func_470_e()
    {
        return 64;
    }

    public int func_490_a(int i)
    {
        return (field_834_d * i) / 200;
    }

    public int func_489_b(int i)
    {
        if(field_835_c == 0)
        {
            field_835_c = 200;
        }
        return (field_832_b * i) / field_835_c;
    }

    public boolean func_485_a()
    {
        return field_832_b > 0;
    }

    public void func_475_b()
    {
        boolean flag = field_832_b > 0;
        boolean flag1 = false;
        if(field_832_b > 0)
        {
            field_832_b--;
        }
        if(!field_824_e.field_1026_y)
        {
            if(field_832_b == 0 && func_491_j())
            {
                field_835_c = field_832_b = func_488_a(field_833_a[1]);
                if(field_832_b > 0)
                {
                    flag1 = true;
                    if(field_833_a[1] != null)
                    {
                        field_833_a[1].field_1615_a--;
                        if(field_833_a[1].field_1615_a == 0)
                        {
                            field_833_a[1] = null;
                        }
                    }
                }
            }
            if(func_485_a() && func_491_j())
            {
                field_834_d++;
                if(field_834_d == 200)
                {
                    field_834_d = 0;
                    func_487_i();
                    flag1 = true;
                }
            } else
            {
                field_834_d = 0;
            }
            if(flag != (field_832_b > 0))
            {
                flag1 = true;
                BlockFurnace.func_285_a(field_832_b > 0, field_824_e, field_823_f, field_822_g, field_821_h);
            }
        }
        if(flag1)
        {
            func_474_j_();
        }
    }

    private boolean func_491_j()
    {
        if(field_833_a[0] == null)
        {
            return false;
        }
        ItemStack itemstack = FurnaceRecipes.func_21200_a().func_21198_a(field_833_a[0].func_1091_a().field_291_aS);
        if(itemstack == null)
        {
            return false;
        }
        if(field_833_a[2] == null)
        {
            return true;
        }
        if(!field_833_a[2].func_21184_a(itemstack))
        {
            return false;
        }
        if(field_833_a[2].field_1615_a < func_470_e() && field_833_a[2].field_1615_a < field_833_a[2].func_1089_c())
        {
            return true;
        }
        return field_833_a[2].field_1615_a < itemstack.func_1089_c();
    }

    public void func_487_i()
    {
        if(!func_491_j())
        {
            return;
        }
        ItemStack itemstack = FurnaceRecipes.func_21200_a().func_21198_a(field_833_a[0].func_1091_a().field_291_aS);
        if(field_833_a[2] == null)
        {
            field_833_a[2] = itemstack.func_1102_e();
        } else
        if(field_833_a[2].field_1617_c == itemstack.field_1617_c)
        {
            field_833_a[2].field_1615_a++;
        }
        field_833_a[0].field_1615_a--;
        if(field_833_a[0].field_1615_a <= 0)
        {
            field_833_a[0] = null;
        }
    }

    private int func_488_a(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return 0;
        }
        int i = itemstack.func_1091_a().field_291_aS;
        if(i < 256 && Block.field_345_n[i].field_356_bn == Material.field_1335_c)
        {
            return 300;
        }
        if(i == Item.field_266_B.field_291_aS)
        {
            return 100;
        }
        if(i == Item.field_225_k.field_291_aS)
        {
            return 1600;
        }
        if(i == Item.field_258_aw.field_291_aS)
        {
            return 20000;
        }
        if(i == Block.field_333_z.field_376_bc)
        {
            return 100;
        }
        return i != Item.field_40417_bo.field_291_aS ? 0 : 2400;
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
