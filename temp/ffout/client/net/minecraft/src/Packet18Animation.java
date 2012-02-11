// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, NetHandler

public class Packet18Animation extends Packet
{

    public int field_522_a;
    public int field_521_b;

    public Packet18Animation()
    {
    }

    public Packet18Animation(Entity entity, int i)
    {
        field_522_a = entity.field_620_ab;
        field_521_b = i;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_522_a = datainputstream.readInt();
        field_521_b = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_522_a);
        dataoutputstream.writeByte(field_521_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_825_a(this);
    }

    public int func_329_a()
    {
        return 5;
    }
}
