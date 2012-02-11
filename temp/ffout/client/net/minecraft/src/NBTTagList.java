// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagList extends NBTBase
{

    private List field_1091_a;
    private byte field_1090_b;

    public NBTTagList()
    {
        super("");
        field_1091_a = new ArrayList();
    }

    public NBTTagList(String s)
    {
        super(s);
        field_1091_a = new ArrayList();
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        if(field_1091_a.size() > 0)
        {
            field_1090_b = ((NBTBase)field_1091_a.get(0)).func_733_a();
        } else
        {
            field_1090_b = 1;
        }
        dataoutput.writeByte(field_1090_b);
        dataoutput.writeInt(field_1091_a.size());
        for(int i = 0; i < field_1091_a.size(); i++)
        {
            ((NBTBase)field_1091_a.get(i)).func_735_a(dataoutput);
        }

    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1090_b = datainput.readByte();
        int i = datainput.readInt();
        field_1091_a = new ArrayList();
        for(int j = 0; j < i; j++)
        {
            NBTBase nbtbase = NBTBase.func_739_a(field_1090_b, null);
            nbtbase.func_736_a(datainput);
            field_1091_a.add(nbtbase);
        }

    }

    public byte func_733_a()
    {
        return 9;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1091_a.size()).append(" entries of type ").append(NBTBase.func_731_b(field_1090_b)).toString();
    }

    public void func_742_a(NBTBase nbtbase)
    {
        field_1090_b = nbtbase.func_733_a();
        field_1091_a.add(nbtbase);
    }

    public NBTBase func_741_a(int i)
    {
        return (NBTBase)field_1091_a.get(i);
    }

    public int func_740_c()
    {
        return field_1091_a.size();
    }

    public NBTBase func_40195_b()
    {
        NBTTagList nbttaglist = new NBTTagList(func_737_b());
        nbttaglist.field_1090_b = field_1090_b;
        NBTBase nbtbase1;
        for(Iterator iterator = field_1091_a.iterator(); iterator.hasNext(); nbttaglist.field_1091_a.add(nbtbase1))
        {
            NBTBase nbtbase = (NBTBase)iterator.next();
            nbtbase1 = nbtbase.func_40195_b();
        }

        return nbttaglist;
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagList nbttaglist = (NBTTagList)obj;
            if(field_1090_b == nbttaglist.field_1090_b)
            {
                return field_1091_a.equals(nbttaglist.field_1091_a);
            }
        }
        return false;
    }
}
