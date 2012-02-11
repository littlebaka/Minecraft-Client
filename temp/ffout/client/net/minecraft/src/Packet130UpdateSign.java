// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet130UpdateSign extends Packet
{

    public int field_20020_a;
    public int field_20019_b;
    public int field_20022_c;
    public String field_20021_d[];

    public Packet130UpdateSign()
    {
        field_472_j = true;
    }

    public Packet130UpdateSign(int i, int j, int k, String as[])
    {
        field_472_j = true;
        field_20020_a = i;
        field_20019_b = j;
        field_20022_c = k;
        field_20021_d = as;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20020_a = datainputstream.readInt();
        field_20019_b = datainputstream.readShort();
        field_20022_c = datainputstream.readInt();
        field_20021_d = new String[4];
        for(int i = 0; i < 4; i++)
        {
            field_20021_d[i] = func_27048_a(datainputstream, 15);
        }

    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_20020_a);
        dataoutputstream.writeShort(field_20019_b);
        dataoutputstream.writeInt(field_20022_c);
        for(int i = 0; i < 4; i++)
        {
            func_27049_a(field_20021_d[i], dataoutputstream);
        }

    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20093_a(this);
    }

    public int func_329_a()
    {
        int i = 0;
        for(int j = 0; j < 4; j++)
        {
            i += field_20021_d[j].length();
        }

        return i;
    }
}
