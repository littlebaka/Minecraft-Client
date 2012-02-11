// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagString extends NBTBase
{

    public String field_1098_a;

    public NBTTagString(String s)
    {
        super(s);
    }

    public NBTTagString(String s, String s1)
    {
        super(s);
        field_1098_a = s1;
        if(s1 == null)
        {
            throw new IllegalArgumentException("Empty string not allowed");
        } else
        {
            return;
        }
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeUTF(field_1098_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1098_a = datainput.readUTF();
    }

    public byte func_733_a()
    {
        return 8;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1098_a).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagString(func_737_b(), field_1098_a);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagString nbttagstring = (NBTTagString)obj;
            return field_1098_a == null && nbttagstring.field_1098_a == null || field_1098_a != null && field_1098_a.equals(nbttagstring.field_1098_a);
        } else
        {
            return false;
        }
    }
}
