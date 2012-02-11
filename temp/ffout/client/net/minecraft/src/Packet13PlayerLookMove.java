// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet10Flying

public class Packet13PlayerLookMove extends Packet10Flying
{

    public Packet13PlayerLookMove()
    {
        field_553_i = true;
        field_554_h = true;
    }

    public Packet13PlayerLookMove(double d, double d1, double d2, double d3, float f, float f1, boolean flag)
    {
        field_561_a = d;
        field_560_b = d1;
        field_558_d = d2;
        field_559_c = d3;
        field_557_e = f;
        field_556_f = f1;
        field_555_g = flag;
        field_553_i = true;
        field_554_h = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_561_a = datainputstream.readDouble();
        field_560_b = datainputstream.readDouble();
        field_558_d = datainputstream.readDouble();
        field_559_c = datainputstream.readDouble();
        field_557_e = datainputstream.readFloat();
        field_556_f = datainputstream.readFloat();
        super.func_327_a(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeDouble(field_561_a);
        dataoutputstream.writeDouble(field_560_b);
        dataoutputstream.writeDouble(field_558_d);
        dataoutputstream.writeDouble(field_559_c);
        dataoutputstream.writeFloat(field_557_e);
        dataoutputstream.writeFloat(field_556_f);
        super.func_322_a(dataoutputstream);
    }

    public int func_329_a()
    {
        return 41;
    }
}
