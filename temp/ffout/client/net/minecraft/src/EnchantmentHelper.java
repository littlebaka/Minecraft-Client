// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ItemStack, NBTTagList, NBTTagCompound, Enchantment, 
//            IEnchantmentModifier, EnchantmentModifierDamage, InventoryPlayer, EnchantmentModifierLiving, 
//            Item, WeightedRandom, EnchantmentData, EnumEnchantmentType, 
//            DamageSource, EntityLiving

public class EnchantmentHelper
{

    private static final Random field_40649_a = new Random();
    private static final EnchantmentModifierDamage field_40647_b = new EnchantmentModifierDamage(null);
    private static final EnchantmentModifierLiving field_40648_c = new EnchantmentModifierLiving(null);

    public EnchantmentHelper()
    {
    }

    public static int func_40634_b(int i, ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return 0;
        }
        NBTTagList nbttaglist = itemstack.func_40714_p();
        if(nbttaglist == null)
        {
            return 0;
        }
        for(int j = 0; j < nbttaglist.func_740_c(); j++)
        {
            short word0 = ((NBTTagCompound)nbttaglist.func_741_a(j)).func_745_d("id");
            short word1 = ((NBTTagCompound)nbttaglist.func_741_a(j)).func_745_d("lvl");
            if(word0 == i)
            {
                return word1;
            }
        }

        return 0;
    }

    private static int func_40636_a(int i, ItemStack aitemstack[])
    {
        int j = 0;
        ItemStack aitemstack1[] = aitemstack;
        int k = aitemstack1.length;
        for(int l = 0; l < k; l++)
        {
            ItemStack itemstack = aitemstack1[l];
            int i1 = func_40634_b(i, itemstack);
            if(i1 > j)
            {
                j = i1;
            }
        }

        return j;
    }

    private static void func_40641_a(IEnchantmentModifier ienchantmentmodifier, ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return;
        }
        NBTTagList nbttaglist = itemstack.func_40714_p();
        if(nbttaglist == null)
        {
            return;
        }
        for(int i = 0; i < nbttaglist.func_740_c(); i++)
        {
            short word0 = ((NBTTagCompound)nbttaglist.func_741_a(i)).func_745_d("id");
            short word1 = ((NBTTagCompound)nbttaglist.func_741_a(i)).func_745_d("lvl");
            if(Enchantment.field_40504_a[word0] != null)
            {
                ienchantmentmodifier.func_40244_a(Enchantment.field_40504_a[word0], word1);
            }
        }

    }

    private static void func_40639_a(IEnchantmentModifier ienchantmentmodifier, ItemStack aitemstack[])
    {
        ItemStack aitemstack1[] = aitemstack;
        int i = aitemstack1.length;
        for(int j = 0; j < i; j++)
        {
            ItemStack itemstack = aitemstack1[j];
            func_40641_a(ienchantmentmodifier, itemstack);
        }

    }

    public static int func_40643_a(InventoryPlayer inventoryplayer, DamageSource damagesource)
    {
        field_40647_b.field_40246_a = 0;
        field_40647_b.field_40245_b = damagesource;
        func_40639_a(field_40647_b, inventoryplayer.field_842_b);
        if(field_40647_b.field_40246_a > 25)
        {
            field_40647_b.field_40246_a = 25;
        }
        return (field_40647_b.field_40246_a + 1 >> 1) + field_40649_a.nextInt((field_40647_b.field_40246_a >> 1) + 1);
    }

    public static int func_40630_a(InventoryPlayer inventoryplayer, EntityLiving entityliving)
    {
        field_40648_c.field_40248_a = 0;
        field_40648_c.field_40247_b = entityliving;
        func_40641_a(field_40648_c, inventoryplayer.func_494_a());
        if(field_40648_c.field_40248_a > 0)
        {
            return 1 + field_40649_a.nextInt(field_40648_c.field_40248_a);
        } else
        {
            return 0;
        }
    }

    public static int func_40645_b(InventoryPlayer inventoryplayer, EntityLiving entityliving)
    {
        return func_40634_b(Enchantment.field_40507_l.field_40516_s, inventoryplayer.func_494_a());
    }

    public static int func_40631_c(InventoryPlayer inventoryplayer, EntityLiving entityliving)
    {
        return func_40634_b(Enchantment.field_40508_m.field_40516_s, inventoryplayer.func_494_a());
    }

    public static int func_40632_a(InventoryPlayer inventoryplayer)
    {
        return func_40636_a(Enchantment.field_40499_g.field_40516_s, inventoryplayer.field_842_b);
    }

    public static int func_40642_b(InventoryPlayer inventoryplayer)
    {
        return func_40634_b(Enchantment.field_40506_o.field_40516_s, inventoryplayer.func_494_a());
    }

    public static int func_40640_c(InventoryPlayer inventoryplayer)
    {
        return func_40634_b(Enchantment.field_40518_q.field_40516_s, inventoryplayer.func_494_a());
    }

    public static boolean func_40646_d(InventoryPlayer inventoryplayer)
    {
        return func_40634_b(Enchantment.field_40519_p.field_40516_s, inventoryplayer.func_494_a()) > 0;
    }

    public static int func_40638_e(InventoryPlayer inventoryplayer)
    {
        return func_40634_b(Enchantment.field_40517_r.field_40516_s, inventoryplayer.func_494_a());
    }

    public static int func_40637_f(InventoryPlayer inventoryplayer)
    {
        return func_40634_b(Enchantment.field_40505_n.field_40516_s, inventoryplayer.func_494_a());
    }

    public static boolean func_40633_g(InventoryPlayer inventoryplayer)
    {
        return func_40636_a(Enchantment.field_40511_h.field_40516_s, inventoryplayer.field_842_b) > 0;
    }

    public static int func_40629_a(Random random, int i, int j, ItemStack itemstack)
    {
        Item item = itemstack.func_1091_a();
        int k = item.func_40399_b();
        if(k <= 0)
        {
            return 0;
        }
        if(j > 30)
        {
            j = 30;
        }
        j = 1 + (j >> 1) + random.nextInt(j + 1);
        int l = random.nextInt(5) + j;
        if(i == 0)
        {
            return (l >> 1) + 1;
        }
        if(i == 1)
        {
            return (l * 2) / 3 + 1;
        } else
        {
            return l;
        }
    }

    public static List func_40644_a(Random random, ItemStack itemstack, int i)
    {
        Item item = itemstack.func_1091_a();
        int j = item.func_40399_b();
        if(j <= 0)
        {
            return null;
        }
        j = 1 + random.nextInt((j >> 1) + 1) + random.nextInt((j >> 1) + 1);
        int k = j + i;
        float f = ((random.nextFloat() + random.nextFloat()) - 1.0F) * 0.25F;
        int l = (int)((float)k * (1.0F + f) + 0.5F);
        ArrayList arraylist = null;
        Map map = func_40635_a(l, itemstack);
        if(map != null && !map.isEmpty())
        {
            EnchantmentData enchantmentdata = (EnchantmentData)WeightedRandom.func_35733_a(random, map.values());
            if(enchantmentdata != null)
            {
                arraylist = new ArrayList();
                arraylist.add(enchantmentdata);
                for(int i1 = l >> 1; random.nextInt(50) <= i1; i1 >>= 1)
                {
                    Iterator iterator = map.keySet().iterator();
                    do
                    {
                        if(!iterator.hasNext())
                        {
                            break;
                        }
                        Integer integer = (Integer)iterator.next();
                        boolean flag = true;
                        Iterator iterator1 = arraylist.iterator();
                        do
                        {
                            if(!iterator1.hasNext())
                            {
                                break;
                            }
                            EnchantmentData enchantmentdata2 = (EnchantmentData)iterator1.next();
                            if(enchantmentdata2.field_40264_a.func_40496_a(Enchantment.field_40504_a[integer.intValue()]))
                            {
                                continue;
                            }
                            flag = false;
                            break;
                        } while(true);
                        if(!flag)
                        {
                            iterator.remove();
                        }
                    } while(true);
                    if(!map.isEmpty())
                    {
                        EnchantmentData enchantmentdata1 = (EnchantmentData)WeightedRandom.func_35733_a(random, map.values());
                        arraylist.add(enchantmentdata1);
                    }
                }

            }
        }
        return arraylist;
    }

    public static Map func_40635_a(int i, ItemStack itemstack)
    {
        Item item = itemstack.func_1091_a();
        HashMap hashmap = null;
        Enchantment aenchantment[] = Enchantment.field_40504_a;
        int j = aenchantment.length;
        for(int k = 0; k < j; k++)
        {
            Enchantment enchantment = aenchantment[k];
            if(enchantment == null || !enchantment.field_40515_t.func_40650_a(item))
            {
                continue;
            }
            for(int l = enchantment.func_40493_c(); l <= enchantment.func_40491_a(); l++)
            {
                if(i < enchantment.func_40492_a(l) || i > enchantment.func_40489_b(l))
                {
                    continue;
                }
                if(hashmap == null)
                {
                    hashmap = new HashMap();
                }
                hashmap.put(Integer.valueOf(enchantment.field_40516_s), new EnchantmentData(enchantment, l));
            }

        }

        return hashmap;
    }

}
