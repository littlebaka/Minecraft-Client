// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet15Place extends Packet
{

    public int field_566_a;
    public int field_565_b;
    public int field_569_c;
    public int field_568_d;
    public ItemStack field_567_e;

    public Packet15Place()
    {
    }

    public Packet15Place(int i, int j, int k, int l, ItemStack itemstack)
    {
        field_566_a = i;
        field_565_b = j;
        field_569_c = k;
        field_568_d = l;
        field_567_e = itemstack;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_566_a = datainputstream.readInt();
        field_565_b = datainputstream.read();
        field_569_c = datainputstream.readInt();
        field_568_d = datainputstream.read();
        field_567_e = func_40187_b(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_566_a);
        dataoutputstream.write(field_565_b);
        dataoutputstream.writeInt(field_569_c);
        dataoutputstream.write(field_568_d);
        func_40188_a(field_567_e, dataoutputstream);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_819_a(this);
    }

    public int func_329_a()
    {
        return 15;
    }
}
