// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityLiving, EntityList, MathHelper, 
//            DataWatcher, NetHandler

public class Packet24MobSpawn extends Packet
{

    public int field_547_a;
    public int field_546_b;
    public int field_552_c;
    public int field_551_d;
    public int field_550_e;
    public byte field_549_f;
    public byte field_548_g;
    private DataWatcher field_21055_h;
    private List field_21054_i;

    public Packet24MobSpawn()
    {
    }

    public Packet24MobSpawn(EntityLiving entityliving)
    {
        field_547_a = entityliving.field_620_ab;
        field_546_b = (byte)EntityList.func_1082_a(entityliving);
        field_552_c = MathHelper.func_1108_b(entityliving.field_611_ak * 32D);
        field_551_d = MathHelper.func_1108_b(entityliving.field_610_al * 32D);
        field_550_e = MathHelper.func_1108_b(entityliving.field_609_am * 32D);
        field_549_f = (byte)(int)((entityliving.field_605_aq * 256F) / 360F);
        field_548_g = (byte)(int)((entityliving.field_604_ar * 256F) / 360F);
        field_21055_h = entityliving.func_21061_O();
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_547_a = datainputstream.readInt();
        field_546_b = datainputstream.readByte() & 0xff;
        field_552_c = datainputstream.readInt();
        field_551_d = datainputstream.readInt();
        field_550_e = datainputstream.readInt();
        field_549_f = datainputstream.readByte();
        field_548_g = datainputstream.readByte();
        field_21054_i = DataWatcher.func_21131_a(datainputstream);
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_547_a);
        dataoutputstream.writeByte(field_546_b & 0xff);
        dataoutputstream.writeInt(field_552_c);
        dataoutputstream.writeInt(field_551_d);
        dataoutputstream.writeInt(field_550_e);
        dataoutputstream.writeByte(field_549_f);
        dataoutputstream.writeByte(field_548_g);
        field_21055_h.func_21127_a(dataoutputstream);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_828_a(this);
    }

    public int func_329_a()
    {
        return 20;
    }

    public List func_21053_b()
    {
        return field_21054_i;
    }
}
