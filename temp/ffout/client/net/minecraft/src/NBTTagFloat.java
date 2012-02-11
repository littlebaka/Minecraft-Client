// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagFloat extends NBTBase
{

    public float field_1097_a;

    public NBTTagFloat(String s)
    {
        super(s);
    }

    public NBTTagFloat(String s, float f)
    {
        super(s);
        field_1097_a = f;
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeFloat(field_1097_a);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1097_a = datainput.readFloat();
    }

    public byte func_733_a()
    {
        return 5;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1097_a).toString();
    }

    public NBTBase func_40195_b()
    {
        return new NBTTagFloat(func_737_b(), field_1097_a);
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagFloat nbttagfloat = (NBTTagFloat)obj;
            return field_1097_a == nbttagfloat.field_1097_a;
        } else
        {
            return false;
        }
    }
}
