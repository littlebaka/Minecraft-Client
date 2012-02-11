// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet54PlayNoteBlock extends Packet
{

    public int field_21037_a;
    public int field_21036_b;
    public int field_21040_c;
    public int field_21039_d;
    public int field_21038_e;

    public Packet54PlayNoteBlock()
    {
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_21037_a = datainputstream.readInt();
        field_21036_b = datainputstream.readShort();
        field_21040_c = datainputstream.readInt();
        field_21039_d = datainputstream.read();
        field_21038_e = datainputstream.read();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_21037_a);
        dataoutputstream.writeShort(field_21036_b);
        dataoutputstream.writeInt(field_21040_c);
        dataoutputstream.write(field_21039_d);
        dataoutputstream.write(field_21038_e);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_21145_a(this);
    }

    public int func_329_a()
    {
        return 12;
    }
}
