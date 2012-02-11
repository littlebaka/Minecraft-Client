// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagDouble extends NBTBase
{

    public double field_1089_a;

    public NBTTagDouble(String s)
    {
        super(s);
    }

    public NBTTagDouble(String s, double d)
    {
        super(s);
        field_1089_a = d;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeDouble(field_1089_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1089_a = datainput.readDouble();
    }

    public byte func_733_a()
    {
        return 6;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1089_a).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagDouble(func_737_b(), field_1089_a);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagDouble nbttagdouble = (NBTTagDouble)obj;
            return field_1089_a == nbttagdouble.field_1089_a;
        } else
        {
            return false;
        }
    }
}
