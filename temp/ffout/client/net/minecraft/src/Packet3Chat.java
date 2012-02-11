// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet3Chat extends Packet
{

    public String field_517_a;

    public Packet3Chat()
    {
    }

    public Packet3Chat(String s)
    {
        if(s.length() > 119)
        {
            s = s.substring(0, 119);
        }
        field_517_a = s;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_517_a = func_27048_a(datainputstream, 119);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        func_27049_a(field_517_a, dataoutputstream);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_4113_a(this);
    }

    public int func_329_a()
    {
        return 2 + field_517_a.length() * 2;
    }
}
