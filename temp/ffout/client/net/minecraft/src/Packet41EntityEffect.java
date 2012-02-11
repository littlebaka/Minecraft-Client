// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet41EntityEffect extends Packet
{

    public int field_35261_a;
    public byte field_35259_b;
    public byte field_35260_c;
    public short field_35258_d;

    public Packet41EntityEffect()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_35261_a = datainputstream.readInt();
        field_35259_b = datainputstream.readByte();
        field_35260_c = datainputstream.readByte();
        field_35258_d = datainputstream.readShort();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_35261_a);
        dataoutputstream.writeByte(field_35259_b);
        dataoutputstream.writeByte(field_35260_c);
        dataoutputstream.writeShort(field_35258_d);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_35780_a(this);
    }

    public int func_329_a()
    {
        return 8;
    }
}
