// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, NetHandler

public class Packet19EntityAction extends Packet
{

    public int field_21051_a;
    public int field_21050_b;

    public Packet19EntityAction()
    {
    }

    public Packet19EntityAction(Entity entity, int i)
    {
        field_21051_a = entity.field_620_ab;
        field_21050_b = i;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_21051_a = datainputstream.readInt();
        field_21050_b = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_21051_a);
        dataoutputstream.writeByte(field_21050_b);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_21147_a(this);
    }

    public int func_329_a()
    {
        return 5;
    }
}
