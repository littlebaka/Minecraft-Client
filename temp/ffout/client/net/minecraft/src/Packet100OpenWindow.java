// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet100OpenWindow extends Packet
{

    public int field_20038_a;
    public int field_20037_b;
    public String field_20040_c;
    public int field_20039_d;

    public Packet100OpenWindow()
    {
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20087_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20038_a = datainputstream.readByte() & 0xff;
        field_20037_b = datainputstream.readByte() & 0xff;
        field_20040_c = func_27048_a(datainputstream, 16);
        field_20039_d = datainputstream.readByte() & 0xff;
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_20038_a & 0xff);
        dataoutputstream.writeByte(field_20037_b & 0xff);
        func_27049_a(field_20040_c, dataoutputstream);
        dataoutputstream.writeByte(field_20039_d & 0xff);
    }

    public int func_329_a()
    {
        return 3 + field_20040_c.length();
    }
}
