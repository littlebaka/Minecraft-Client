// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, NetHandler

public class Packet28EntityVelocity extends Packet
{

    public int field_6367_a;
    public int field_6366_b;
    public int field_6369_c;
    public int field_6368_d;

    public Packet28EntityVelocity()
    {
    }

    public Packet28EntityVelocity(Entity entity)
    {
        this(entity.field_620_ab, entity.field_608_an, entity.field_607_ao, entity.field_606_ap);
    }

    public Packet28EntityVelocity(int i, double d, double d1, double d2)
    {
        field_6367_a = i;
        double d3 = 3.8999999999999999D;
        if(d < -d3)
        {
            d = -d3;
        }
        if(d1 < -d3)
        {
            d1 = -d3;
        }
        if(d2 < -d3)
        {
            d2 = -d3;
        }
        if(d > d3)
        {
            d = d3;
        }
        if(d1 > d3)
        {
            d1 = d3;
        }
        if(d2 > d3)
        {
            d2 = d3;
        }
        field_6366_b = (int)(d * 8000D);
        field_6369_c = (int)(d1 * 8000D);
        field_6368_d = (int)(d2 * 8000D);
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_6367_a = datainputstream.readInt();
        field_6366_b = datainputstream.readShort();
        field_6369_c = datainputstream.readShort();
        field_6368_d = datainputstream.readShort();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_6367_a);
        dataoutputstream.writeShort(field_6366_b);
        dataoutputstream.writeShort(field_6369_c);
        dataoutputstream.writeShort(field_6368_d);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_6498_a(this);
    }

    public int func_329_a()
    {
        return 10;
    }
}
