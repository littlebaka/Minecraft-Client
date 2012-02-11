// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet0KeepAlive extends Packet
{

    public int field_35254_a;

    public Packet0KeepAlive()
    {
    }

    public Packet0KeepAlive(int i)
    {
        field_35254_a = i;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_35784_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_35254_a = datainputstream.readInt();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_35254_a);
    }

    public int func_329_a()
    {
        return 4;
    }
}
