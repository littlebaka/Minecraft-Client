// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, EnumWorldType

public class Packet9Respawn extends Packet
{

    public long field_35246_a;
    public int field_35244_b;
    public int field_35245_c;
    public int field_35242_d;
    public int field_35243_e;
    public EnumWorldType field_46031_f;

    public Packet9Respawn()
    {
    }

    public Packet9Respawn(byte byte0, byte byte1, long l, EnumWorldType enumworldtype, int i, int j)
    {
        field_35244_b = byte0;
        field_35245_c = byte1;
        field_35246_a = l;
        field_35242_d = i;
        field_35243_e = j;
        field_46031_f = enumworldtype;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_9448_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_35244_b = datainputstream.readByte();
        field_35245_c = datainputstream.readByte();
        field_35243_e = datainputstream.readByte();
        field_35242_d = datainputstream.readShort();
        field_35246_a = datainputstream.readLong();
        String s = func_27048_a(datainputstream, 16);
        field_46031_f = EnumWorldType.func_46135_a(s);
        if(field_46031_f == null)
        {
            field_46031_f = EnumWorldType.DEFAULT;
        }
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_35244_b);
        dataoutputstream.writeByte(field_35245_c);
        dataoutputstream.writeByte(field_35243_e);
        dataoutputstream.writeShort(field_35242_d);
        dataoutputstream.writeLong(field_35246_a);
        func_27049_a(field_46031_f.name(), dataoutputstream);
    }

    public int func_329_a()
    {
        return 13 + field_46031_f.name().length();
    }
}
