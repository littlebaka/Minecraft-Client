// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, ICrafting, EntityPlayer, 
//            InventoryPlayer, IInventory

public abstract class Container
{

    public List field_20123_d;
    public List field_20122_e;
    public int field_1618_c;
    private short field_20917_a;
    protected List field_20121_g;
    private Set field_20918_b;

    public Container()
    {
        field_20123_d = new ArrayList();
        field_20122_e = new ArrayList();
        field_1618_c = 0;
        field_20917_a = 0;
        field_20121_g = new ArrayList();
        field_20918_b = new HashSet();
    }

    protected void func_20117_a(Slot slot)
    {
        slot.field_20007_a = field_20122_e.size();
        field_20122_e.add(slot);
        field_20123_d.add(null);
    }

    public void func_20114_a()
    {
        for(int i = 0; i < field_20122_e.size(); i++)
        {
            ItemStack itemstack = ((Slot)field_20122_e.get(i)).func_777_b();
            ItemStack itemstack1 = (ItemStack)field_20123_d.get(i);
            if(ItemStack.func_20107_a(itemstack1, itemstack))
            {
                continue;
            }
            itemstack1 = itemstack != null ? itemstack.func_1102_e() : null;
            field_20123_d.set(i, itemstack1);
            for(int j = 0; j < field_20121_g.size(); j++)
            {
                ((ICrafting)field_20121_g.get(j)).func_20159_a(this, i, itemstack1);
            }

        }

    }

    public boolean func_40233_a(EntityPlayer entityplayer, int i)
    {
        return false;
    }

    public Slot func_20118_a(int i)
    {
        return (Slot)field_20122_e.get(i);
    }

    public ItemStack func_27279_a(int i)
    {
        Slot slot = (Slot)field_20122_e.get(i);
        if(slot != null)
        {
            return slot.func_777_b();
        } else
        {
            return null;
        }
    }

    public ItemStack func_27280_a(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
        ItemStack itemstack = null;
        if(j > 1)
        {
            return null;
        }
        if(j == 0 || j == 1)
        {
            InventoryPlayer inventoryplayer = entityplayer.field_778_b;
            if(i == -999)
            {
                if(inventoryplayer.func_20075_i() != null && i == -999)
                {
                    if(j == 0)
                    {
                        entityplayer.func_449_a(inventoryplayer.func_20075_i());
                        inventoryplayer.func_20076_b(null);
                    }
                    if(j == 1)
                    {
                        entityplayer.func_449_a(inventoryplayer.func_20075_i().func_1085_a(1));
                        if(inventoryplayer.func_20075_i().field_1615_a == 0)
                        {
                            inventoryplayer.func_20076_b(null);
                        }
                    }
                }
            } else
            if(flag)
            {
                ItemStack itemstack1 = func_27279_a(i);
                if(itemstack1 != null)
                {
                    int k = itemstack1.field_1617_c;
                    itemstack = itemstack1.func_1102_e();
                    Slot slot1 = (Slot)field_20122_e.get(i);
                    if(slot1 != null && slot1.func_777_b() != null && slot1.func_777_b().field_1617_c == k)
                    {
                        func_35373_b(i, j, flag, entityplayer);
                    }
                }
            } else
            {
                if(i < 0)
                {
                    return null;
                }
                Slot slot = (Slot)field_20122_e.get(i);
                if(slot != null)
                {
                    slot.func_779_d();
                    ItemStack itemstack2 = slot.func_777_b();
                    ItemStack itemstack3 = inventoryplayer.func_20075_i();
                    if(itemstack2 != null)
                    {
                        itemstack = itemstack2.func_1102_e();
                    }
                    if(itemstack2 == null)
                    {
                        if(itemstack3 != null && slot.func_4105_a(itemstack3))
                        {
                            int l = j != 0 ? 1 : itemstack3.field_1615_a;
                            if(l > slot.func_4104_e())
                            {
                                l = slot.func_4104_e();
                            }
                            slot.func_776_b(itemstack3.func_1085_a(l));
                            if(itemstack3.field_1615_a == 0)
                            {
                                inventoryplayer.func_20076_b(null);
                            }
                        }
                    } else
                    if(itemstack3 == null)
                    {
                        int i1 = j != 0 ? (itemstack2.field_1615_a + 1) / 2 : itemstack2.field_1615_a;
                        ItemStack itemstack5 = slot.func_20004_a(i1);
                        inventoryplayer.func_20076_b(itemstack5);
                        if(itemstack2.field_1615_a == 0)
                        {
                            slot.func_776_b(null);
                        }
                        slot.func_4103_a(inventoryplayer.func_20075_i());
                    } else
                    if(slot.func_4105_a(itemstack3))
                    {
                        if(itemstack2.field_1617_c != itemstack3.field_1617_c || itemstack2.func_21183_f() && itemstack2.func_21181_i() != itemstack3.func_21181_i() || !ItemStack.func_46154_a(itemstack2, itemstack3))
                        {
                            if(itemstack3.field_1615_a <= slot.func_4104_e())
                            {
                                ItemStack itemstack4 = itemstack2;
                                slot.func_776_b(itemstack3);
                                inventoryplayer.func_20076_b(itemstack4);
                            }
                        } else
                        {
                            int j1 = j != 0 ? 1 : itemstack3.field_1615_a;
                            if(j1 > slot.func_4104_e() - itemstack2.field_1615_a)
                            {
                                j1 = slot.func_4104_e() - itemstack2.field_1615_a;
                            }
                            if(j1 > itemstack3.func_1089_c() - itemstack2.field_1615_a)
                            {
                                j1 = itemstack3.func_1089_c() - itemstack2.field_1615_a;
                            }
                            itemstack3.func_1085_a(j1);
                            if(itemstack3.field_1615_a == 0)
                            {
                                inventoryplayer.func_20076_b(null);
                            }
                            itemstack2.field_1615_a += j1;
                        }
                    } else
                    if(itemstack2.field_1617_c == itemstack3.field_1617_c && itemstack3.func_1089_c() > 1 && (!itemstack2.func_21183_f() || itemstack2.func_21181_i() == itemstack3.func_21181_i()) && ItemStack.func_46154_a(itemstack2, itemstack3))
                    {
                        int k1 = itemstack2.field_1615_a;
                        if(k1 > 0 && k1 + itemstack3.field_1615_a <= itemstack3.func_1089_c())
                        {
                            itemstack3.field_1615_a += k1;
                            itemstack2.func_1085_a(k1);
                            if(itemstack2.field_1615_a == 0)
                            {
                                slot.func_776_b(null);
                            }
                            slot.func_4103_a(inventoryplayer.func_20075_i());
                        }
                    }
                }
            }
        }
        return itemstack;
    }

    protected void func_35373_b(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
        func_27280_a(i, j, flag, entityplayer);
    }

    public void func_1104_a(EntityPlayer entityplayer)
    {
        InventoryPlayer inventoryplayer = entityplayer.field_778_b;
        if(inventoryplayer.func_20075_i() != null)
        {
            entityplayer.func_449_a(inventoryplayer.func_20075_i());
            inventoryplayer.func_20076_b(null);
        }
    }

    public void func_1103_a(IInventory iinventory)
    {
        func_20114_a();
    }

    public void func_20119_a(int i, ItemStack itemstack)
    {
        func_20118_a(i).func_776_b(itemstack);
    }

    public void func_20115_a(ItemStack aitemstack[])
    {
        for(int i = 0; i < aitemstack.length; i++)
        {
            func_20118_a(i).func_776_b(aitemstack[i]);
        }

    }

    public void func_20112_a(int i, int j)
    {
    }

    public short func_20111_a(InventoryPlayer inventoryplayer)
    {
        field_20917_a++;
        return field_20917_a;
    }

    public void func_20113_a(short word0)
    {
    }

    public void func_20110_b(short word0)
    {
    }

    public abstract boolean func_20120_b(EntityPlayer entityplayer);

    protected boolean func_28125_a(ItemStack itemstack, int i, int j, boolean flag)
    {
        boolean flag1 = false;
        int k = i;
        if(flag)
        {
            k = j - 1;
        }
        if(itemstack.func_21180_d())
        {
            while(itemstack.field_1615_a > 0 && (!flag && k < j || flag && k >= i)) 
            {
                Slot slot = (Slot)field_20122_e.get(k);
                ItemStack itemstack1 = slot.func_777_b();
                if(itemstack1 != null && itemstack1.field_1617_c == itemstack.field_1617_c && (!itemstack.func_21183_f() || itemstack.func_21181_i() == itemstack1.func_21181_i()) && ItemStack.func_46154_a(itemstack, itemstack1))
                {
                    int i1 = itemstack1.field_1615_a + itemstack.field_1615_a;
                    if(i1 <= itemstack.func_1089_c())
                    {
                        itemstack.field_1615_a = 0;
                        itemstack1.field_1615_a = i1;
                        slot.func_779_d();
                        flag1 = true;
                    } else
                    if(itemstack1.field_1615_a < itemstack.func_1089_c())
                    {
                        itemstack.field_1615_a -= itemstack.func_1089_c() - itemstack1.field_1615_a;
                        itemstack1.field_1615_a = itemstack.func_1089_c();
                        slot.func_779_d();
                        flag1 = true;
                    }
                }
                if(flag)
                {
                    k--;
                } else
                {
                    k++;
                }
            }
        }
        if(itemstack.field_1615_a > 0)
        {
            int l;
            if(flag)
            {
                l = j - 1;
            } else
            {
                l = i;
            }
            do
            {
                if((flag || l >= j) && (!flag || l < i))
                {
                    break;
                }
                Slot slot1 = (Slot)field_20122_e.get(l);
                ItemStack itemstack2 = slot1.func_777_b();
                if(itemstack2 == null)
                {
                    slot1.func_776_b(itemstack.func_1102_e());
                    slot1.func_779_d();
                    itemstack.field_1615_a = 0;
                    flag1 = true;
                    break;
                }
                if(flag)
                {
                    l--;
                } else
                {
                    l++;
                }
            } while(true);
        }
        return flag1;
    }
}
