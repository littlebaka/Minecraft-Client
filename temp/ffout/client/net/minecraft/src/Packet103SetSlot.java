// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet103SetSlot extends Packet
{

    public int field_20042_a;
    public int field_20041_b;
    public ItemStack field_20043_c;

    public Packet103SetSlot()
    {
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20088_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20042_a = datainputstream.readByte();
        field_20041_b = datainputstream.readShort();
        field_20043_c = func_40187_b(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_20042_a);
        dataoutputstream.writeShort(field_20041_b);
        func_40188_a(field_20043_c, dataoutputstream);
    }

    public int func_329_a()
    {
        return 8;
    }
}
