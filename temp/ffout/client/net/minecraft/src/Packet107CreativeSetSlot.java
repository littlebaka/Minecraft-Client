// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet107CreativeSetSlot extends Packet
{

    public int field_35236_a;
    public ItemStack field_40190_b;

    public Packet107CreativeSetSlot()
    {
    }

    public Packet107CreativeSetSlot(int i, ItemStack itemstack)
    {
        field_35236_a = i;
        field_40190_b = itemstack;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_35781_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_35236_a = datainputstream.readShort();
        field_40190_b = func_40187_b(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(field_35236_a);
        func_40188_a(field_40190_b, dataoutputstream);
    }

    public int func_329_a()
    {
        return 8;
    }
}
