// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet43Experience extends Packet
{

    public float field_35230_a;
    public int field_35228_b;
    public int field_35229_c;

    public Packet43Experience()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_35230_a = datainputstream.readFloat();
        field_35229_c = datainputstream.readShort();
        field_35228_b = datainputstream.readShort();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeFloat(field_35230_a);
        dataoutputstream.writeShort(field_35229_c);
        dataoutputstream.writeShort(field_35228_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_35777_a(this);
    }

    public int func_329_a()
    {
        return 4;
    }
}
