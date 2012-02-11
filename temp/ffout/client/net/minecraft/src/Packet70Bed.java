// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet70Bed extends Packet
{

    public static final String field_25020_a[] = {
        "tile.bed.notValid", null, null, "gameMode.changed"
    };
    public int field_25019_b;
    public int field_35262_c;

    public Packet70Bed()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_25019_b = datainputstream.readByte();
        field_35262_c = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_25019_b);
        dataoutputstream.writeByte(field_35262_c);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_25118_a(this);
    }

    public int func_329_a()
    {
        return 2;
    }

}
