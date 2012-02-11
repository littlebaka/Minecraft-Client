// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagByteArray extends NBTBase
{

    public byte field_1096_a[];

    public NBTTagByteArray(String s)
    {
        super(s);
    }

    public NBTTagByteArray(String s, byte abyte0[])
    {
        super(s);
        field_1096_a = abyte0;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeInt(field_1096_a.length);
        dataoutput.write(field_1096_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        int i = datainput.readInt();
        field_1096_a = new byte[i];
        datainput.readFully(field_1096_a);
    }

    public byte func_733_a()
    {
        return 7;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(field_1096_a.length).append(" bytes]").toString();
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagByteArray nbttagbytearray = (NBTTagByteArray)obj;
            return field_1096_a == null && nbttagbytearray.field_1096_a == null || field_1096_a != null && field_1096_a.equals(nbttagbytearray.field_1096_a);
        } else
        {
            return false;
        }
    }

    public NBTBase func_40195_b()
    {
        byte abyte0[] = new byte[field_1096_a.length];
        System.arraycopy(field_1096_a, 0, abyte0, 0, field_1096_a.length);
        return new NBTTagByteArray(func_737_b(), abyte0);
    }
}
