// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet22Collect extends Packet
{

    public int field_581_a;
    public int field_580_b;

    public Packet22Collect()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_581_a = datainputstream.readInt();
        field_580_b = datainputstream.readInt();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_581_a);
        dataoutputstream.writeInt(field_580_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_834_a(this);
    }

    public int func_329_a()
    {
        return 8;
    }
}
