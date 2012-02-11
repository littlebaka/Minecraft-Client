// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityPainting, EnumArt, NetHandler

public class Packet25EntityPainting extends Packet
{

    public int field_21042_a;
    public int field_21041_b;
    public int field_21046_c;
    public int field_21045_d;
    public int field_21044_e;
    public String field_21043_f;

    public Packet25EntityPainting()
    {
    }

    public Packet25EntityPainting(EntityPainting entitypainting)
    {
        field_21042_a = entitypainting.field_620_ab;
        field_21041_b = entitypainting.field_9322_d;
        field_21046_c = entitypainting.field_9321_e;
        field_21045_d = entitypainting.field_9320_f;
        field_21044_e = entitypainting.field_691_a;
        field_21043_f = entitypainting.field_690_b.field_1624_y;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_21042_a = datainputstream.readInt();
        field_21043_f = func_27048_a(datainputstream, EnumArt.field_27365_z);
        field_21041_b = datainputstream.readInt();
        field_21046_c = datainputstream.readInt();
        field_21045_d = datainputstream.readInt();
        field_21044_e = datainputstream.readInt();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_21042_a);
        func_27049_a(field_21043_f, dataoutputstream);
        dataoutputstream.writeInt(field_21041_b);
        dataoutputstream.writeInt(field_21046_c);
        dataoutputstream.writeInt(field_21045_d);
        dataoutputstream.writeInt(field_21044_e);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_21146_a(this);
    }

    public int func_329_a()
    {
        return 24;
    }
}
