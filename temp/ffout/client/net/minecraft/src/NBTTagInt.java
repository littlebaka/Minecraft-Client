// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagInt extends NBTBase
{

    public int field_1093_a;

    public NBTTagInt(String s)
    {
        super(s);
    }

    public NBTTagInt(String s, int i)
    {
        super(s);
        field_1093_a = i;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeInt(field_1093_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1093_a = datainput.readInt();
    }

    public byte func_733_a()
    {
        return 3;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1093_a).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagInt(func_737_b(), field_1093_a);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagInt nbttagint = (NBTTagInt)obj;
            return field_1093_a == nbttagint.field_1093_a;
        } else
        {
            return false;
        }
    }
}
