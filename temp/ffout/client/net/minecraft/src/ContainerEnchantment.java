// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Container, SlotEnchantmentTable, SlotEnchantment, Slot, 
//            ICrafting, IInventory, ItemStack, World, 
//            Block, EnchantmentHelper, EntityPlayer, EnchantmentData, 
//            InventoryPlayer

public class ContainerEnchantment extends Container
{

    public IInventory field_40236_a;
    private World field_40240_h;
    private int field_40241_i;
    private int field_40238_j;
    private int field_40239_k;
    private Random field_40237_l;
    public long field_40234_b;
    public int field_40235_c[];

    public ContainerEnchantment(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
        field_40236_a = new SlotEnchantmentTable(this, "Enchant", 1);
        field_40237_l = new Random();
        field_40235_c = new int[3];
        field_40240_h = world;
        field_40241_i = i;
        field_40238_j = j;
        field_40239_k = k;
        func_20117_a(new SlotEnchantment(this, field_40236_a, 0, 25, 47));
        for(int l = 0; l < 3; l++)
        {
            for(int j1 = 0; j1 < 9; j1++)
            {
                func_20117_a(new Slot(inventoryplayer, j1 + l * 9 + 9, 8 + j1 * 18, 84 + l * 18));
            }

        }

        for(int i1 = 0; i1 < 9; i1++)
        {
            func_20117_a(new Slot(inventoryplayer, i1, 8 + i1 * 18, 142));
        }

    }

    public void func_20114_a()
    {
        super.func_20114_a();
        for(int i = 0; i < field_20121_g.size(); i++)
        {
            ICrafting icrafting = (ICrafting)field_20121_g.get(i);
            icrafting.func_20158_a(this, 0, field_40235_c[0]);
            icrafting.func_20158_a(this, 1, field_40235_c[1]);
            icrafting.func_20158_a(this, 2, field_40235_c[2]);
        }

    }

    public void func_20112_a(int i, int j)
    {
        if(i >= 0 && i <= 2)
        {
            field_40235_c[i] = j;
        } else
        {
            super.func_20112_a(i, j);
        }
    }

    public void func_1103_a(IInventory iinventory)
    {
        if(iinventory == field_40236_a)
        {
            ItemStack itemstack = iinventory.func_468_c(0);
            if(itemstack == null || !itemstack.func_40708_t())
            {
                for(int i = 0; i < 3; i++)
                {
                    field_40235_c[i] = 0;
                }

            } else
            {
                field_40234_b = field_40237_l.nextLong();
                if(!field_40240_h.field_1026_y)
                {
                    int j = 0;
                    for(int k = -1; k <= 1; k++)
                    {
                        for(int i1 = -1; i1 <= 1; i1++)
                        {
                            if(k == 0 && i1 == 0 || !field_40240_h.func_20084_d(field_40241_i + i1, field_40238_j, field_40239_k + k) || !field_40240_h.func_20084_d(field_40241_i + i1, field_40238_j + 1, field_40239_k + k))
                            {
                                continue;
                            }
                            if(field_40240_h.func_600_a(field_40241_i + i1 * 2, field_40238_j, field_40239_k + k * 2) == Block.field_407_ao.field_376_bc)
                            {
                                j++;
                            }
                            if(field_40240_h.func_600_a(field_40241_i + i1 * 2, field_40238_j + 1, field_40239_k + k * 2) == Block.field_407_ao.field_376_bc)
                            {
                                j++;
                            }
                            if(i1 == 0 || k == 0)
                            {
                                continue;
                            }
                            if(field_40240_h.func_600_a(field_40241_i + i1 * 2, field_40238_j, field_40239_k + k) == Block.field_407_ao.field_376_bc)
                            {
                                j++;
                            }
                            if(field_40240_h.func_600_a(field_40241_i + i1 * 2, field_40238_j + 1, field_40239_k + k) == Block.field_407_ao.field_376_bc)
                            {
                                j++;
                            }
                            if(field_40240_h.func_600_a(field_40241_i + i1, field_40238_j, field_40239_k + k * 2) == Block.field_407_ao.field_376_bc)
                            {
                                j++;
                            }
                            if(field_40240_h.func_600_a(field_40241_i + i1, field_40238_j + 1, field_40239_k + k * 2) == Block.field_407_ao.field_376_bc)
                            {
                                j++;
                            }
                        }

                    }

                    for(int l = 0; l < 3; l++)
                    {
                        field_40235_c[l] = EnchantmentHelper.func_40629_a(field_40237_l, l, j, itemstack);
                    }

                    func_20114_a();
                }
            }
        }
    }

    public boolean func_40233_a(EntityPlayer entityplayer, int i)
    {
        ItemStack itemstack = field_40236_a.func_468_c(0);
        if(field_40235_c[i] > 0 && itemstack != null && entityplayer.field_35210_aY >= field_40235_c[i])
        {
            if(!field_40240_h.field_1026_y)
            {
                List list = EnchantmentHelper.func_40644_a(field_40237_l, itemstack, field_40235_c[i]);
                if(list != null)
                {
                    entityplayer.func_40184_i(field_40235_c[i]);
                    EnchantmentData enchantmentdata;
                    for(Iterator iterator = list.iterator(); iterator.hasNext(); itemstack.func_40705_a(enchantmentdata.field_40264_a, enchantmentdata.field_40263_b))
                    {
                        enchantmentdata = (EnchantmentData)iterator.next();
                    }

                    func_1103_a(field_40236_a);
                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void func_1104_a(EntityPlayer entityplayer)
    {
        super.func_1104_a(entityplayer);
        if(field_40240_h.field_1026_y)
        {
            return;
        }
        ItemStack itemstack = field_40236_a.func_468_c(0);
        if(itemstack != null)
        {
            entityplayer.func_449_a(itemstack);
        }
    }

    public boolean func_20120_b(EntityPlayer entityplayer)
    {
        if(field_40240_h.func_600_a(field_40241_i, field_40238_j, field_40239_k) != Block.field_40210_bF.field_376_bc)
        {
            return false;
        }
        return entityplayer.func_360_d((double)field_40241_i + 0.5D, (double)field_40238_j + 0.5D, (double)field_40239_k + 0.5D) <= 64D;
    }

    public ItemStack func_27279_a(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_20122_e.get(i);
        if(slot != null && slot.func_20005_c())
        {
            ItemStack itemstack1 = slot.func_777_b();
            itemstack = itemstack1.func_1102_e();
            if(i == 0)
            {
                if(!func_28125_a(itemstack1, 1, 37, true))
                {
                    return null;
                }
            } else
            {
                return null;
            }
            if(itemstack1.field_1615_a == 0)
            {
                slot.func_776_b(null);
            } else
            {
                slot.func_779_d();
            }
            if(itemstack1.field_1615_a != itemstack.field_1615_a)
            {
                slot.func_4103_a(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }
}
