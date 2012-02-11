// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagShort extends NBTBase
{

    public short field_1088_a;

    public NBTTagShort(String s)
    {
        super(s);
    }

    public NBTTagShort(String s, short word0)
    {
        super(s);
        field_1088_a = word0;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeShort(field_1088_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1088_a = datainput.readShort();
    }

    public byte func_733_a()
    {
        return 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1088_a).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagShort(func_737_b(), field_1088_a);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagShort nbttagshort = (NBTTagShort)obj;
            return field_1088_a == nbttagshort.field_1088_a;
        } else
        {
            return false;
        }
    }
}
