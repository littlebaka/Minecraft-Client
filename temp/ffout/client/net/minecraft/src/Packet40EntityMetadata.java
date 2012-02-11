// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Packet, DataWatcher, NetHandler

public class Packet40EntityMetadata extends Packet
{

    public int field_21049_a;
    private List field_21048_b;

    public Packet40EntityMetadata()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_21049_a = datainputstream.readInt();
        field_21048_b = DataWatcher.func_21131_a(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_21049_a);
        DataWatcher.func_21125_a(field_21048_b, dataoutputstream);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_21148_a(this);
    }

    public int func_329_a()
    {
        return 5;
    }

    public List func_21047_b()
    {
        return field_21048_b;
    }
}
