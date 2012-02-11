// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet2Handshake extends Packet
{

    public String field_532_a;

    public Packet2Handshake()
    {
    }

    public Packet2Handshake(String s)
    {
        field_532_a = s;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_532_a = func_27048_a(datainputstream, 32);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        func_27049_a(field_532_a, dataoutputstream);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_838_a(this);
    }

    public int func_329_a()
    {
        return 4 + field_532_a.length() + 4;
    }
}
