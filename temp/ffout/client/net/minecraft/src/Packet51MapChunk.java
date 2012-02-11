// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet51MapChunk extends Packet
{

    public int field_573_a;
    public int field_572_b;
    public int field_579_c;
    public int field_578_d;
    public int field_577_e;
    public int field_576_f;
    public byte field_575_g[];
    private int field_574_h;

    public Packet51MapChunk()
    {
        field_472_j = true;
    }

    public void func_327_a(DataInputStream datainputstream)
        throws IOException
    {
        field_573_a = datainputstream.readInt();
        field_572_b = datainputstream.readShort();
        field_579_c = datainputstream.readInt();
        field_578_d = datainputstream.read() + 1;
        field_577_e = datainputstream.read() + 1;
        field_576_f = datainputstream.read() + 1;
        field_574_h = datainputstream.readInt();
        byte abyte0[] = new byte[field_574_h];
        datainputstream.readFully(abyte0);
        field_575_g = new byte[(field_578_d * field_577_e * field_576_f * 5) / 2];
        Inflater inflater = new Inflater();
        inflater.setInput(abyte0);
        try
        {
            inflater.inflate(field_575_g);
        }
        catch(DataFormatException dataformatexception)
        {
            throw new IOException("Bad compressed data format");
        }
        finally
        {
            inflater.end();
        }
    }

    public void func_322_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_573_a);
        dataoutputstream.writeShort(field_572_b);
        dataoutputstream.writeInt(field_579_c);
        dataoutputstream.write(field_578_d - 1);
        dataoutputstream.write(field_577_e - 1);
        dataoutputstream.write(field_576_f - 1);
        dataoutputstream.writeInt(field_574_h);
        dataoutputstream.write(field_575_g, 0, field_574_h);
    }

    public void func_323_a(NetHandler nethandler)
    {
        nethandler.func_833_a(this);
    }

    public int func_329_a()
    {
        return 17 + field_574_h;
    }
}
