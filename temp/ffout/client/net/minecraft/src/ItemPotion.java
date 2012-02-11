// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, PotionHelper, World, 
//            PotionEffect, EntityPlayer, InventoryPlayer, EnumAction, 
//            EntityPotion, Potion, StatCollector

public class ItemPotion extends Item
{

    private HashMap field_40435_a;

    public ItemPotion(int i)
    {
        super(i);
        field_40435_a = new HashMap();
        func_21009_c(1);
        func_21015_a(true);
        func_21013_d(0);
    }

    public List func_40434_a_(ItemStack itemstack)
    {
        return func_40431_c_(itemstack.func_21181_i());
    }

    public List func_40431_c_(int i)
    {
        List list = (List)field_40435_a.get(Integer.valueOf(i));
        if(list == null)
        {
            list = PotionHelper.func_40360_b(i, false);
            field_40435_a.put(Integer.valueOf(i), list);
        }
        return list;
    }

    public ItemStack func_35413_b(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.field_1615_a--;
        if(!world.field_1026_y)
        {
            List list = func_40434_a_(itemstack);
            if(list != null)
            {
                PotionEffect potioneffect;
                for(Iterator iterator = list.iterator(); iterator.hasNext(); entityplayer.func_35165_a(new PotionEffect(potioneffect)))
                {
                    potioneffect = (PotionEffect)iterator.next();
                }

            }
        }
        if(itemstack.field_1615_a <= 0)
        {
            return new ItemStack(Item.field_40416_bt);
        } else
        {
            entityplayer.field_778_b.func_504_a(new ItemStack(Item.field_40416_bt));
            return itemstack;
        }
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 32;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.drink;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(func_40433_c(itemstack.func_21181_i()))
        {
            itemstack.field_1615_a--;
            world.func_623_a(entityplayer, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
            if(!world.field_1026_y)
            {
                world.func_674_a(new EntityPotion(world, entityplayer, itemstack.func_21181_i()));
            }
            return itemstack;
        } else
        {
            entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
            return itemstack;
        }
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        return false;
    }

    public int func_27009_a(int i)
    {
        return !func_40433_c(i) ? 140 : 154;
    }

    public int func_46057_a(int i, int j)
    {
        if(j == 0)
        {
            return 141;
        } else
        {
            return super.func_46057_a(i, j);
        }
    }

    public static boolean func_40433_c(int i)
    {
        return (i & 0x4000) != 0;
    }

    public int func_27010_f(int i, int j)
    {
        if(j > 0)
        {
            return 0xffffff;
        } else
        {
            return PotionHelper.func_40358_a(i, false);
        }
    }

    public boolean func_46058_c()
    {
        return true;
    }

    public boolean func_40432_e(int i)
    {
        List list = func_40431_c_(i);
        if(list == null || list.isEmpty())
        {
            return false;
        }
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            if(Potion.field_35678_a[potioneffect.func_35799_a()].func_40622_b())
            {
                return true;
            }
        }

        return false;
    }

    public String func_40397_d(ItemStack itemstack)
    {
        if(itemstack.func_21181_i() == 0)
        {
            return StatCollector.func_25200_a("item.emptyPotion.name").trim();
        }
        String s = "";
        if(func_40433_c(itemstack.func_21181_i()))
        {
            s = (new StringBuilder()).append(StatCollector.func_25200_a("potion.prefix.grenade").trim()).append(" ").toString();
        }
        List list = Item.field_40413_bs.func_40434_a_(itemstack);
        if(list != null && !list.isEmpty())
        {
            String s1 = ((PotionEffect)list.get(0)).func_40468_d();
            s1 = (new StringBuilder()).append(s1).append(".postfix").toString();
            return (new StringBuilder()).append(s).append(StatCollector.func_25200_a(s1).trim()).toString();
        } else
        {
            String s2 = PotionHelper.func_40359_b(itemstack.func_21181_i());
            return (new StringBuilder()).append(StatCollector.func_25200_a(s2).trim()).append(" ").append(super.func_40397_d(itemstack)).toString();
        }
    }

    public void func_40404_a(ItemStack itemstack, List list)
    {
        if(itemstack.func_21181_i() == 0)
        {
            return;
        }
        List list1 = Item.field_40413_bs.func_40434_a_(itemstack);
        if(list1 != null && !list1.isEmpty())
        {
            for(Iterator iterator = list1.iterator(); iterator.hasNext();)
            {
                PotionEffect potioneffect = (PotionEffect)iterator.next();
                String s1 = StatCollector.func_25200_a(potioneffect.func_40468_d()).trim();
                if(potioneffect.func_35801_c() > 0)
                {
                    s1 = (new StringBuilder()).append(s1).append(" ").append(StatCollector.func_25200_a((new StringBuilder()).append("potion.potency.").append(potioneffect.func_35801_c()).toString()).trim()).toString();
                }
                if(potioneffect.func_35802_b() > 20)
                {
                    s1 = (new StringBuilder()).append(s1).append(" (").append(Potion.func_40620_a(potioneffect)).append(")").toString();
                }
                if(Potion.field_35678_a[potioneffect.func_35799_a()].func_40615_f())
                {
                    list.add((new StringBuilder()).append("\247c").append(s1).toString());
                } else
                {
                    list.add((new StringBuilder()).append("\2477").append(s1).toString());
                }
            }

        } else
        {
            String s = StatCollector.func_25200_a("potion.empty").trim();
            list.add((new StringBuilder()).append("\2477").append(s).toString());
        }
    }

    public boolean func_40403_e(ItemStack itemstack)
    {
        List list = func_40434_a_(itemstack);
        return list != null && !list.isEmpty();
    }
}
