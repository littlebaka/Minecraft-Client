// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagLong extends NBTBase
{

    public long field_1095_a;

    public NBTTagLong(String s)
    {
        super(s);
    }

    public NBTTagLong(String s, long l)
    {
        super(s);
        field_1095_a = l;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeLong(field_1095_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1095_a = datainput.readLong();
    }

    public byte func_733_a()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1095_a).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagLong(func_737_b(), field_1095_a);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagLong nbttaglong = (NBTTagLong)obj;
            return field_1095_a == nbttaglong.field_1095_a;
        } else
        {
            return false;
        }
    }
}
