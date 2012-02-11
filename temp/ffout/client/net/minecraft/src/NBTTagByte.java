// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagByte extends NBTBase
{

    public byte field_1092_a;

    public NBTTagByte(String s)
    {
        super(s);
    }

    public NBTTagByte(String s, byte byte0)
    {
        super(s);
        field_1092_a = byte0;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeByte(field_1092_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1092_a = datainput.readByte();
    }

    public byte func_733_a()
    {
        return 1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1092_a).toString();
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagByte nbttagbyte = (NBTTagByte)obj;
            return field_1092_a == nbttagbyte.field_1092_a;
        } else
        {
            return false;
        }
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagByte(func_737_b(), field_1092_a);
    }
}
