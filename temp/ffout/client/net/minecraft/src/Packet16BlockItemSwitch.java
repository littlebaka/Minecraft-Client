// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet16BlockItemSwitch extends Packet
{

    public int field_562_b;

    public Packet16BlockItemSwitch()
    {
    }

    public Packet16BlockItemSwitch(int i)
    {
        field_562_b = i;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_562_b = datainputstream.readShort();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(field_562_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_841_a(this);
    }

    public int func_329_a()
    {
        return 2;
    }
}
