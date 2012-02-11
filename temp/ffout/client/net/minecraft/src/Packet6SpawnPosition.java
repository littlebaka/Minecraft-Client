// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet6SpawnPosition extends Packet
{

    public int field_515_a;
    public int field_514_b;
    public int field_516_c;

    public Packet6SpawnPosition()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_515_a = datainputstream.readInt();
        field_514_b = datainputstream.readInt();
        field_516_c = datainputstream.readInt();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_515_a);
        dataoutputstream.writeInt(field_514_b);
        dataoutputstream.writeInt(field_516_c);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_845_a(this);
    }

    public int func_329_a()
    {
        return 12;
    }
}
