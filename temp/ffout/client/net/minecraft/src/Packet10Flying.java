// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet10Flying extends Packet
{

    public double field_561_a;
    public double field_560_b;
    public double field_559_c;
    public double field_558_d;
    public float field_557_e;
    public float field_556_f;
    public boolean field_555_g;
    public boolean field_554_h;
    public boolean field_553_i;

    public Packet10Flying()
    {
    }

    public Packet10Flying(boolean flag)
    {
        field_555_g = flag;
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_837_a(this);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_555_g = datainputstream.read() != 0;
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.write(field_555_g ? 1 : 0);
    }

    public int func_329_a()
    {
        return 1;
    }
}
