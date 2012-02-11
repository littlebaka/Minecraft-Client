// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet131MapData extends Packet
{

    public short field_28055_a;
    public short field_28054_b;
    public byte field_28056_c[];

    public Packet131MapData()
    {
        field_472_j = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_28055_a = datainputstream.readShort();
        field_28054_b = datainputstream.readShort();
        field_28056_c = new byte[datainputstream.readByte() & 0xff];
        datainputstream.readFully(field_28056_c);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(field_28055_a);
        dataoutputstream.writeShort(field_28054_b);
        dataoutputstream.writeByte(field_28056_c.length);
        dataoutputstream.write(field_28056_c);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_28116_a(this);
    }

    public int func_329_a()
    {
        return 4 + field_28056_c.length;
    }
}
