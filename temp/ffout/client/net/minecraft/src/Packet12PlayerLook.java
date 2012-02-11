// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet10Flying

public class Packet12PlayerLook extends Packet10Flying
{

    public Packet12PlayerLook()
    {
        field_553_i = true;
    }

    public Packet12PlayerLook(float f, float f1, boolean flag)
    {
        field_557_e = f;
        field_556_f = f1;
        field_555_g = flag;
        field_553_i = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_557_e = datainputstream.readFloat();
        field_556_f = datainputstream.readFloat();
        super.func_327_a(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeFloat(field_557_e);
        dataoutputstream.writeFloat(field_556_f);
        super.func_322_a(dataoutputstream);
    }

    public int func_329_a()
    {
        return 9;
    }
}
