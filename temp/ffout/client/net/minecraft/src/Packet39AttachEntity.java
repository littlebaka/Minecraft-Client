// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet39AttachEntity extends Packet
{

    public int field_6365_a;
    public int field_6364_b;

    public Packet39AttachEntity()
    {
    }

    public int func_329_a()
    {
        return 8;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_6365_a = datainputstream.readInt();
        field_6364_b = datainputstream.readInt();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_6365_a);
        dataoutputstream.writeInt(field_6364_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_6497_a(this);
    }
}
