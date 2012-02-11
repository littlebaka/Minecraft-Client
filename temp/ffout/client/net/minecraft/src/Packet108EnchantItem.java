// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet108EnchantItem extends Packet
{

    public int field_40192_a;
    public int field_40191_b;

    public Packet108EnchantItem()
    {
    }

    public Packet108EnchantItem(int i, int j)
    {
        field_40192_a = i;
        field_40191_b = j;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_40599_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_40192_a = datainputstream.readByte();
        field_40191_b = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_40192_a);
        dataoutputstream.writeByte(field_40191_b);
    }

    public int func_329_a()
    {
        return 2;
    }
}
