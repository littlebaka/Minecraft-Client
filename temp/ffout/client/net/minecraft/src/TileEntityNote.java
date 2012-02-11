// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, NBTTagCompound, World, Material

public class TileEntityNote extends TileEntity
{

    public byte field_21097_a;
    public boolean field_21096_b;

    public TileEntityNote()
    {
        field_21097_a = 0;
        field_21096_b = false;
    }

    public void func_481_b(NBTTagCompound nbttagcompound)
    {
        super.func_481_b(nbttagcompound);
        nbttagcompound.func_761_a("note", field_21097_a);
    }

    public void func_482_a(NBTTagCompound nbttagcompound)
    {
        super.func_482_a(nbttagcompound);
        field_21097_a = nbttagcompound.func_746_c("note");
        if(field_21097_a < 0)
        {
            field_21097_a = 0;
        }
        if(field_21097_a > 24)
        {
            field_21097_a = 24;
        }
    }

    public void func_21095_a()
    {
        field_21097_a = (byte)((field_21097_a + 1) % 25);
        func_474_j_();
    }

    public void func_21094_a(World world, int i, int j, int k)
    {
        if(world.func_599_f(i, j + 1, k) != Material.field_1337_a)
        {
            return;
        }
        Material material = world.func_599_f(i, j - 1, k);
        byte byte0 = 0;
        if(material == Material.field_1334_d)
        {
            byte0 = 1;
        }
        if(material == Material.field_1325_m)
        {
            byte0 = 2;
        }
        if(material == Material.field_4263_o)
        {
            byte0 = 3;
        }
        if(material == Material.field_1335_c)
        {
            byte0 = 4;
        }
        world.func_21116_c(i, j, k, byte0, field_21097_a);
    }
}
