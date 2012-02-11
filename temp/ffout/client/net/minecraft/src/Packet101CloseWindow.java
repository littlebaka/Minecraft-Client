// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet101CloseWindow extends Packet
{

    public int field_20034_a;

    public Packet101CloseWindow()
    {
    }

    public Packet101CloseWindow(int i)
    {
        field_20034_a = i;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_20092_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_20034_a = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_20034_a);
    }

    public int func_329_a()
    {
        return 1;
    }
}
