// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, EnumWorldType, NetHandler

public class Packet1Login extends Packet
{

    public int field_519_a;
    public String field_518_b;
    public long field_4074_d;
    public EnumWorldType field_46032_d;
    public int field_35249_d;
    public byte field_35250_e;
    public byte field_35247_f;
    public byte field_35248_g;
    public byte field_35251_h;

    public Packet1Login()
    {
    }

    public Packet1Login(String s, int i)
    {
        field_518_b = s;
        field_519_a = i;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_519_a = datainputstream.readInt();
        field_518_b = func_27048_a(datainputstream, 16);
        field_4074_d = datainputstream.readLong();
        String s = func_27048_a(datainputstream, 16);
        field_46032_d = EnumWorldType.func_46135_a(s);
        if(field_46032_d == null)
        {
            field_46032_d = EnumWorldType.DEFAULT;
        }
        field_35249_d = datainputstream.readInt();
        field_35250_e = datainputstream.readByte();
        field_35247_f = datainputstream.readByte();
        field_35248_g = datainputstream.readByte();
        field_35251_h = datainputstream.readByte();
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_519_a);
        func_27049_a(field_518_b, dataoutputstream);
        dataoutputstream.writeLong(field_4074_d);
        if(field_46032_d == null)
        {
            func_27049_a("", dataoutputstream);
        } else
        {
            func_27049_a(field_46032_d.name(), dataoutputstream);
        }
        dataoutputstream.writeInt(field_35249_d);
        dataoutputstream.writeByte(field_35250_e);
        dataoutputstream.writeByte(field_35247_f);
        dataoutputstream.writeByte(field_35248_g);
        dataoutputstream.writeByte(field_35251_h);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_4115_a(this);
    }

    public int func_329_a()
    {
        int i = 0;
        if(field_46032_d != null)
        {
            i = field_46032_d.name().length();
        }
        return 4 + field_518_b.length() + 4 + 7 + 4 + i;
    }
}
