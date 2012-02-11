// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet102WindowClick extends Packet
{

    public int field_20024_a;
    public int field_20023_b;
    public int field_20027_c;
    public short field_20026_d;
    public ItemStack field_20025_e;
    public boolean field_27050_f;

    public Packet102WindowClick()
    {
    }

    public Packet102WindowClick(int i, int j, int k, boolean flag, ItemStack itemstack, short word0)
    {
        field_20024_a = i;
        field_20023_b = j;
        field_20027_c = k;
        field_20025_e = itemstack;
        field_20026_d = word0;
        field_27050_f = flag;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20091_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20024_a = datainputstream.readByte();
        field_20023_b = datainputstream.readShort();
        field_20027_c = datainputstream.readByte();
        field_20026_d = datainputstream.readShort();
        field_27050_f = datainputstream.readBoolean();
        field_20025_e = func_40187_b(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_20024_a);
        dataoutputstream.writeShort(field_20023_b);
        dataoutputstream.writeByte(field_20027_c);
        dataoutputstream.writeShort(field_20026_d);
        dataoutputstream.writeBoolean(field_27050_f);
        func_40188_a(field_20025_e, dataoutputstream);
    }

    public int func_329_a()
    {
        return 11;
    }
}
