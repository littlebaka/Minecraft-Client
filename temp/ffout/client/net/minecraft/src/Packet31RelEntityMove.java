// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet30Entity

public class Packet31RelEntityMove extends Packet30Entity
{

    public Packet31RelEntityMove()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        super.func_327_a(datainputstream);
        field_484_b = datainputstream.readByte();
        field_490_c = datainputstream.readByte();
        field_489_d = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        super.func_322_a(dataoutputstream);
        dataoutputstream.writeByte(field_484_b);
        dataoutputstream.writeByte(field_490_c);
        dataoutputstream.writeByte(field_489_d);
    }

    public int func_329_a()
    {
        return 7;
    }
}
