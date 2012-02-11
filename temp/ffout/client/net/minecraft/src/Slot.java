// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack

public class Slot
{

    private final int field_1119_a;
    public final IInventory field_1118_b;
    public int field_20007_a;
    public int field_20006_b;
    public int field_20008_c;

    public Slot(IInventory iinventory, int i, int j, int k)
    {
        field_1118_b = iinventory;
        field_1119_a = i;
        field_20006_b = j;
        field_20008_c = k;
    }

    public void func_4103_a(ItemStack itemstack)
    {
        func_779_d();
    }

    public boolean func_4105_a(ItemStack itemstack)
    {
        return true;
    }

    public ItemStack func_777_b()
    {
        return field_1118_b.func_468_c(field_1119_a);
    }

    public boolean func_20005_c()
    {
        return func_777_b() != null;
    }

    public void func_776_b(ItemStack itemstack)
    {
        field_1118_b.func_472_a(field_1119_a, itemstack);
        func_779_d();
    }

    public void func_779_d()
    {
        field_1118_b.func_474_j_();
    }

    public int func_4104_e()
    {
        return field_1118_b.func_470_e();
    }

    public int func_775_c()
    {
        return -1;
    }

    public ItemStack func_20004_a(int i)
    {
        return field_1118_b.func_473_a(field_1119_a, i);
    }
}
