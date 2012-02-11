// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet106Transaction extends Packet
{

    public int field_20029_a;
    public short field_20028_b;
    public boolean field_20030_c;

    public Packet106Transaction()
    {
    }

    public Packet106Transaction(int i, short word0, boolean flag)
    {
        field_20029_a = i;
        field_20028_b = word0;
        field_20030_c = flag;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20089_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20029_a = datainputstream.readByte();
        field_20028_b = datainputstream.readShort();
        field_20030_c = datainputstream.readByte() != 0;
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_20029_a);
        dataoutputstream.writeShort(field_20028_b);
        dataoutputstream.writeByte(field_20030_c ? 1 : 0);
    }

    public int func_329_a()
    {
        return 4;
    }
}
