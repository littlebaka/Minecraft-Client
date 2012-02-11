// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet14BlockDig extends Packet
{

    public int field_542_a;
    public int field_541_b;
    public int field_545_c;
    public int field_544_d;
    public int field_543_e;

    public Packet14BlockDig()
    {
    }

    public Packet14BlockDig(int i, int j, int k, int l, int i1)
    {
        field_543_e = i;
        field_542_a = j;
        field_541_b = k;
        field_545_c = l;
        field_544_d = i1;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_543_e = datainputstream.read();
        field_542_a = datainputstream.readInt();
        field_541_b = datainputstream.read();
        field_545_c = datainputstream.readInt();
        field_544_d = datainputstream.read();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.write(field_543_e);
        dataoutputstream.writeInt(field_542_a);
        dataoutputstream.write(field_541_b);
        dataoutputstream.writeInt(field_545_c);
        dataoutputstream.write(field_544_d);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_821_a(this);
    }

    public int func_329_a()
    {
        return 11;
    }
}
