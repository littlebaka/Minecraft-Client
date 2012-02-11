// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet105UpdateProgressbar extends Packet
{

    public int field_20032_a;
    public int field_20031_b;
    public int field_20033_c;

    public Packet105UpdateProgressbar()
    {
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20090_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20032_a = datainputstream.readByte();
        field_20031_b = datainputstream.readShort();
        field_20033_c = datainputstream.readShort();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_20032_a);
        dataoutputstream.writeShort(field_20031_b);
        dataoutputstream.writeShort(field_20033_c);
    }

    public int func_329_a()
    {
        return 5;
    }
}
