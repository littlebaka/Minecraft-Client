// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet52MultiBlockChange extends Packet
{

    public int field_479_a;
    public int field_478_b;
    public short field_483_c[];
    public byte field_482_d[];
    public byte field_481_e[];
    public int field_480_f;

    public Packet52MultiBlockChange()
    {
        field_472_j = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_479_a = datainputstream.readInt();
        field_478_b = datainputstream.readInt();
        field_480_f = datainputstream.readShort() & 0xffff;
        field_483_c = new short[field_480_f];
        field_482_d = new byte[field_480_f];
        field_481_e = new byte[field_480_f];
        for(int i = 0; i < field_480_f; i++)
        {
            field_483_c[i] = datainputstream.readShort();
        }

        datainputstream.readFully(field_482_d);
        datainputstream.readFully(field_481_e);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_479_a);
        dataoutputstream.writeInt(field_478_b);
        dataoutputstream.writeShort((short)field_480_f);
        for(int i = 0; i < field_480_f; i++)
        {
            dataoutputstream.writeShort(field_483_c[i]);
        }

        dataoutputstream.write(field_482_d);
        dataoutputstream.write(field_481_e);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_824_a(this);
    }

    public int func_329_a()
    {
        return 10 + field_480_f * 4;
    }
}
