// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet10Flying

public class Packet11PlayerPosition extends Packet10Flying
{

    public Packet11PlayerPosition()
    {
        field_554_h = true;
    }

    public Packet11PlayerPosition(double d, double d1, double d2, double d3, boolean flag)
    {
        field_561_a = d;
        field_560_b = d1;
        field_558_d = d2;
        field_559_c = d3;
        field_555_g = flag;
        field_554_h = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_561_a = datainputstream.readDouble();
        field_560_b = datainputstream.readDouble();
        field_558_d = datainputstream.readDouble();
        field_559_c = datainputstream.readDouble();
        super.func_327_a(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeDouble(field_561_a);
        dataoutputstream.writeDouble(field_560_b);
        dataoutputstream.writeDouble(field_558_d);
        dataoutputstream.writeDouble(field_559_c);
        super.func_322_a(dataoutputstream);
    }

    public int func_329_a()
    {
        return 33;
    }
}
