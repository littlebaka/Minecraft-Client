// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet38EntityStatus extends Packet
{

    public int field_9274_a;
    public byte field_9273_b;

    public Packet38EntityStatus()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_9274_a = datainputstream.readInt();
        field_9273_b = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_9274_a);
        dataoutputstream.writeByte(field_9273_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_9447_a(this);
    }

    public int func_329_a()
    {
        return 5;
    }
}
