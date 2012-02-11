// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, MathHelper, EntityLightningBolt, 
//            NetHandler

public class Packet71Weather extends Packet
{

    public int field_27054_a;
    public int field_27053_b;
    public int field_27057_c;
    public int field_27056_d;
    public int field_27055_e;

    public Packet71Weather()
    {
    }

    public Packet71Weather(Entity entity)
    {
        field_27054_a = entity.field_620_ab;
        field_27053_b = MathHelper.func_1108_b(entity.field_611_ak * 32D);
        field_27057_c = MathHelper.func_1108_b(entity.field_610_al * 32D);
        field_27056_d = MathHelper.func_1108_b(entity.field_609_am * 32D);
        if(entity instanceof EntityLightningBolt)
        {
            field_27055_e = 1;
        }
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_27054_a = datainputstream.readInt();
        field_27055_e = datainputstream.readByte();
        field_27053_b = datainputstream.readInt();
        field_27057_c = datainputstream.readInt();
        field_27056_d = datainputstream.readInt();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_27054_a);
        dataoutputstream.writeByte(field_27055_e);
        dataoutputstream.writeInt(field_27053_b);
        dataoutputstream.writeInt(field_27057_c);
        dataoutputstream.writeInt(field_27056_d);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_27246_a(this);
    }

    public int func_329_a()
    {
        return 17;
    }
}
