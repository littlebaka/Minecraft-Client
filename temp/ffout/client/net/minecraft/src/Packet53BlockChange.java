// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet53BlockChange extends Packet
{

    public int field_492_a;
    public int field_491_b;
    public int field_495_c;
    public int field_494_d;
    public int field_493_e;

    public Packet53BlockChange()
    {
        field_472_j = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_492_a = datainputstream.readInt();
        field_491_b = datainputstream.read();
        field_495_c = datainputstream.readInt();
        field_494_d = datainputstream.read();
        field_493_e = datainputstream.read();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_492_a);
        dataoutputstream.write(field_491_b);
        dataoutputstream.writeInt(field_495_c);
        dataoutputstream.write(field_494_d);
        dataoutputstream.write(field_493_e);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_822_a(this);
    }

    public int func_329_a()
    {
        return 11;
    }
}
