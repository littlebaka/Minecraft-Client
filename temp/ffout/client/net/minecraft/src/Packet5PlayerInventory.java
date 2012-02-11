// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet5PlayerInventory extends Packet
{

    public int field_571_a;
    public int field_21056_b;
    public int field_570_b;
    public int field_20044_c;

    public Packet5PlayerInventory()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_571_a = datainputstream.readInt();
        field_21056_b = datainputstream.readShort();
        field_570_b = datainputstream.readShort();
        field_20044_c = datainputstream.readShort();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_571_a);
        dataoutputstream.writeShort(field_21056_b);
        dataoutputstream.writeShort(field_570_b);
        dataoutputstream.writeShort(field_20044_c);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_843_a(this);
    }

    public int func_329_a()
    {
        return 8;
    }
}
