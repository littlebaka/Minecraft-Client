// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet7UseEntity extends Packet
{

    public int field_9277_a;
    public int field_9276_b;
    public int field_9278_c;

    public Packet7UseEntity()
    {
    }

    public Packet7UseEntity(int i, int j, int k)
    {
        field_9277_a = i;
        field_9276_b = j;
        field_9278_c = k;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_9277_a = datainputstream.readInt();
        field_9276_b = datainputstream.readInt();
        field_9278_c = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_9277_a);
        dataoutputstream.writeInt(field_9276_b);
        dataoutputstream.writeByte(field_9278_c);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_6499_a(this);
    }

    public int func_329_a()
    {
        return 9;
    }
}
