// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet23VehicleSpawn extends Packet
{

    public int field_500_a;
    public int field_499_b;
    public int field_503_c;
    public int field_502_d;
    public int field_28047_e;
    public int field_28046_f;
    public int field_28045_g;
    public int field_501_e;
    public int field_28044_i;

    public Packet23VehicleSpawn()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_500_a = datainputstream.readInt();
        field_501_e = datainputstream.readByte();
        field_499_b = datainputstream.readInt();
        field_503_c = datainputstream.readInt();
        field_502_d = datainputstream.readInt();
        field_28044_i = datainputstream.readInt();
        if(field_28044_i > 0)
        {
            field_28047_e = datainputstream.readShort();
            field_28046_f = datainputstream.readShort();
            field_28045_g = datainputstream.readShort();
        }
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_500_a);
        dataoutputstream.writeByte(field_501_e);
        dataoutputstream.writeInt(field_499_b);
        dataoutputstream.writeInt(field_503_c);
        dataoutputstream.writeInt(field_502_d);
        dataoutputstream.writeInt(field_28044_i);
        if(field_28044_i > 0)
        {
            dataoutputstream.writeShort(field_28047_e);
            dataoutputstream.writeShort(field_28046_f);
            dataoutputstream.writeShort(field_28045_g);
        }
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_835_a(this);
    }

    public int func_329_a()
    {
        return 21 + field_28044_i <= 0 ? 0 : 6;
    }
}
