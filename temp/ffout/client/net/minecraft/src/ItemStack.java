// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Block, Item, NBTTagCompound, StatList, 
//            EntityPlayer, EnchantmentHelper, EntityLiving, World, 
//            NBTTagList, Enchantment, Entity, EnumAction, 
//            EnumRarity

public final class ItemStack
{

    public int field_1615_a;
    public int field_1614_b;
    public int field_1617_c;
    public NBTTagCompound field_40715_d;
    private int field_1616_d;

    public ItemStack(Block block)
    {
        this(block, 1);
    }

    public ItemStack(Block block, int i)
    {
        this(block.field_376_bc, i, 0);
    }

    public ItemStack(Block block, int i, int j)
    {
        this(block.field_376_bc, i, j);
    }

    public ItemStack(Item item)
    {
        this(item.field_291_aS, 1, 0);
    }

    public ItemStack(Item item, int i)
    {
        this(item.field_291_aS, i, 0);
    }

    public ItemStack(Item item, int i, int j)
    {
        this(item.field_291_aS, i, j);
    }

    public ItemStack(int i, int j, int k)
    {
        field_1615_a = 0;
        field_1617_c = i;
        field_1615_a = j;
        field_1616_d = k;
    }

    public static ItemStack func_35864_a(NBTTagCompound nbttagcompound)
    {
        ItemStack itemstack = new ItemStack();
        itemstack.func_1096_b(nbttagcompound);
        return itemstack.func_1091_a() == null ? null : itemstack;
    }

    private ItemStack()
    {
        field_1615_a = 0;
    }

    public ItemStack func_1085_a(int i)
    {
        ItemStack itemstack = new ItemStack(field_1617_c, i, field_1616_d);
        if(field_40715_d != null)
        {
            itemstack.field_40715_d = (NBTTagCompound)field_40715_d.func_40195_b();
        }
        field_1615_a -= i;
        return itemstack;
    }

    public Item func_1091_a()
    {
        return Item.field_233_c[field_1617_c];
    }

    public int func_1088_b()
    {
        return func_1091_a().func_196_a(this);
    }

    public boolean func_1090_a(EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        boolean flag = func_1091_a().func_192_a(this, entityplayer, world, i, j, k, l);
        if(flag)
        {
            entityplayer.func_25058_a(StatList.field_25172_A[field_1617_c], 1);
        }
        return flag;
    }

    public float func_1098_a(Block block)
    {
        return func_1091_a().func_204_a(this, block);
    }

    public ItemStack func_1093_a(World world, EntityPlayer entityplayer)
    {
        return func_1091_a().func_193_a(this, world, entityplayer);
    }

    public ItemStack func_35863_b(World world, EntityPlayer entityplayer)
    {
        return func_1091_a().func_35413_b(this, world, entityplayer);
    }

    public NBTTagCompound func_1086_a(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.func_749_a("id", (short)field_1617_c);
        nbttagcompound.func_761_a("Count", (byte)field_1615_a);
        nbttagcompound.func_749_a("Damage", (short)field_1616_d);
        if(field_40715_d != null)
        {
            nbttagcompound.func_762_a("tag", field_40715_d);
        }
        return nbttagcompound;
    }

    public void func_1096_b(NBTTagCompound nbttagcompound)
    {
        field_1617_c = nbttagcompound.func_745_d("id");
        field_1615_a = nbttagcompound.func_746_c("Count");
        field_1616_d = nbttagcompound.func_745_d("Damage");
        if(nbttagcompound.func_751_b("tag"))
        {
            field_40715_d = nbttagcompound.func_743_k("tag");
        }
    }

    public int func_1089_c()
    {
        return func_1091_a().func_200_b();
    }

    public boolean func_21180_d()
    {
        return func_1089_c() > 1 && (!func_21182_e() || !func_21185_g());
    }

    public boolean func_21182_e()
    {
        return Item.field_233_c[field_1617_c].func_197_c() > 0;
    }

    public boolean func_21183_f()
    {
        return Item.field_233_c[field_1617_c].func_21010_e();
    }

    public boolean func_21185_g()
    {
        return func_21182_e() && field_1616_d > 0;
    }

    public int func_21179_h()
    {
        return field_1616_d;
    }

    public int func_21181_i()
    {
        return field_1616_d;
    }

    public void func_28156_b(int i)
    {
        field_1616_d = i;
    }

    public int func_1094_d()
    {
        return Item.field_233_c[field_1617_c].func_197_c();
    }

    public void func_25190_a(int i, EntityLiving entityliving)
    {
        if(!func_21182_e())
        {
            return;
        }
        if(i > 0 && (entityliving instanceof EntityPlayer))
        {
            int j = EnchantmentHelper.func_40640_c(((EntityPlayer)entityliving).field_778_b);
            if(j > 0 && entityliving.field_615_ag.field_1037_n.nextInt(j + 1) > 0)
            {
                return;
            }
        }
        field_1616_d += i;
        if(field_1616_d > func_1094_d())
        {
            entityliving.func_41005_b(this);
            if(entityliving instanceof EntityPlayer)
            {
                ((EntityPlayer)entityliving).func_25058_a(StatList.field_25170_B[field_1617_c], 1);
            }
            field_1615_a--;
            if(field_1615_a < 0)
            {
                field_1615_a = 0;
            }
            field_1616_d = 0;
        }
    }

    public void func_1092_a(EntityLiving entityliving, EntityPlayer entityplayer)
    {
        boolean flag = Item.field_233_c[field_1617_c].func_4021_a(this, entityliving, entityplayer);
        if(flag)
        {
            entityplayer.func_25058_a(StatList.field_25172_A[field_1617_c], 1);
        }
    }

    public void func_25191_a(int i, int j, int k, int l, EntityPlayer entityplayer)
    {
        boolean flag = Item.field_233_c[field_1617_c].func_25008_a(this, i, j, k, l, entityplayer);
        if(flag)
        {
            entityplayer.func_25058_a(StatList.field_25172_A[field_1617_c], 1);
        }
    }

    public int func_1095_a(Entity entity)
    {
        return Item.field_233_c[field_1617_c].func_4020_a(entity);
    }

    public boolean func_1099_b(Block block)
    {
        return Item.field_233_c[field_1617_c].func_4018_a(block);
    }

    public void func_1097_a(EntityPlayer entityplayer)
    {
    }

    public void func_1100_b(EntityLiving entityliving)
    {
        Item.field_233_c[field_1617_c].func_4019_b(this, entityliving);
    }

    public ItemStack func_1102_e()
    {
        ItemStack itemstack = new ItemStack(field_1617_c, field_1615_a, field_1616_d);
        if(field_40715_d != null)
        {
            itemstack.field_40715_d = (NBTTagCompound)field_40715_d.func_40195_b();
            if(!itemstack.field_40715_d.equals(field_40715_d))
            {
                return itemstack;
            }
        }
        return itemstack;
    }

    public static boolean func_46154_a(ItemStack itemstack, ItemStack itemstack1)
    {
        if(itemstack == null && itemstack1 == null)
        {
            return true;
        }
        if(itemstack == null || itemstack1 == null)
        {
            return false;
        }
        if(itemstack.field_40715_d == null && itemstack1.field_40715_d != null)
        {
            return false;
        }
        return itemstack.field_40715_d == null || itemstack.field_40715_d.equals(itemstack1.field_40715_d);
    }

    public static boolean func_20107_a(ItemStack itemstack, ItemStack itemstack1)
    {
        if(itemstack == null && itemstack1 == null)
        {
            return true;
        }
        if(itemstack == null || itemstack1 == null)
        {
            return false;
        } else
        {
            return itemstack.func_20108_a(itemstack1);
        }
    }

    private boolean func_20108_a(ItemStack itemstack)
    {
        if(field_1615_a != itemstack.field_1615_a)
        {
            return false;
        }
        if(field_1617_c != itemstack.field_1617_c)
        {
            return false;
        }
        if(field_1616_d != itemstack.field_1616_d)
        {
            return false;
        }
        if(field_40715_d == null && itemstack.field_40715_d != null)
        {
            return false;
        }
        return field_40715_d == null || field_40715_d.equals(itemstack.field_40715_d);
    }

    public boolean func_21184_a(ItemStack itemstack)
    {
        return field_1617_c == itemstack.field_1617_c && field_1616_d == itemstack.field_1616_d;
    }

    public static ItemStack func_30010_b(ItemStack itemstack)
    {
        return itemstack != null ? itemstack.func_1102_e() : null;
    }

    public String toString()
    {
        return (new StringBuilder()).append(field_1615_a).append("x").append(Item.field_233_c[field_1617_c].func_20009_a()).append("@").append(field_1616_d).toString();
    }

    public void func_28153_a(World world, Entity entity, int i, boolean flag)
    {
        if(field_1614_b > 0)
        {
            field_1614_b--;
        }
        Item.field_233_c[field_1617_c].func_28008_a(this, world, entity, i, flag);
    }

    public void func_28155_b(World world, EntityPlayer entityplayer)
    {
        entityplayer.func_25058_a(StatList.field_25158_z[field_1617_c], field_1615_a);
        Item.field_233_c[field_1617_c].func_28009_b(this, world, entityplayer);
    }

    public boolean func_28154_b(ItemStack itemstack)
    {
        return field_1617_c == itemstack.field_1617_c && field_1615_a == itemstack.field_1615_a && field_1616_d == itemstack.field_1616_d;
    }

    public int func_35866_m()
    {
        return func_1091_a().func_35411_c(this);
    }

    public EnumAction func_35865_n()
    {
        return func_1091_a().func_35412_b(this);
    }

    public void func_35862_a(World world, EntityPlayer entityplayer, int i)
    {
        func_1091_a().func_35414_a(this, world, entityplayer, i);
    }

    public boolean func_40710_n()
    {
        return field_40715_d != null;
    }

    public NBTTagCompound func_40709_o()
    {
        return field_40715_d;
    }

    public NBTTagList func_40714_p()
    {
        if(field_40715_d == null)
        {
            return null;
        } else
        {
            return (NBTTagList)field_40715_d.func_40196_b("ench");
        }
    }

    public void func_40706_d(NBTTagCompound nbttagcompound)
    {
        field_40715_d = nbttagcompound;
    }

    public List func_40712_q()
    {
        ArrayList arraylist = new ArrayList();
        Item item = Item.field_233_c[field_1617_c];
        arraylist.add(item.func_40397_d(this));
        item.func_40404_a(this, arraylist);
        if(func_40710_n())
        {
            NBTTagList nbttaglist = func_40714_p();
            if(nbttaglist != null)
            {
                for(int i = 0; i < nbttaglist.func_740_c(); i++)
                {
                    short word0 = ((NBTTagCompound)nbttaglist.func_741_a(i)).func_745_d("id");
                    short word1 = ((NBTTagCompound)nbttaglist.func_741_a(i)).func_745_d("lvl");
                    if(Enchantment.field_40504_a[word0] != null)
                    {
                        arraylist.add(Enchantment.field_40504_a[word0].func_40487_c(word1));
                    }
                }

            }
        }
        return arraylist;
    }

    public boolean func_40713_r()
    {
        return func_1091_a().func_40403_e(this);
    }

    public EnumRarity func_40707_s()
    {
        return func_1091_a().func_40398_f(this);
    }

    public boolean func_40708_t()
    {
        if(!func_1091_a().func_40401_i(this))
        {
            return false;
        }
        return !func_40711_u();
    }

    public void func_40705_a(Enchantment enchantment, int i)
    {
        if(field_40715_d == null)
        {
            func_40706_d(new NBTTagCompound());
        }
        if(!field_40715_d.func_751_b("ench"))
        {
            field_40715_d.func_762_a("ench", new NBTTagList("ench"));
        }
        NBTTagList nbttaglist = (NBTTagList)field_40715_d.func_40196_b("ench");
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_749_a("id", (short)enchantment.field_40516_s);
        nbttagcompound.func_749_a("lvl", (byte)i);
        nbttaglist.func_742_a(nbttagcompound);
    }

    public boolean func_40711_u()
    {
        return field_40715_d != null && field_40715_d.func_751_b("ench");
    }
}
