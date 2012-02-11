// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet200Statistic extends Packet
{

    public int field_27052_a;
    public int field_27051_b;

    public Packet200Statistic()
    {
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_27245_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_27052_a = datainputstream.readInt();
        field_27051_b = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_27052_a);
        dataoutputstream.writeByte(field_27051_b);
    }

    public int func_329_a()
    {
        return 6;
    }
}
