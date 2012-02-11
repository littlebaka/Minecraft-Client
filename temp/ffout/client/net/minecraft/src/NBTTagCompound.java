// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase, NBTTagByte, NBTTagShort, NBTTagInt, 
//            NBTTagLong, NBTTagFloat, NBTTagDouble, NBTTagString, 
//            NBTTagByteArray, NBTTagList

public class NBTTagCompound extends NBTBase
{

    private Map field_1094_a;

    public NBTTagCompound()
    {
        super("");
        field_1094_a = new HashMap();
    }

    public NBTTagCompound(String s)
    {
        super(s);
        field_1094_a = new HashMap();
    }

    void func_735_a(DataOutput dataoutput)
        throws IOException
    {
        NBTBase nbtbase;
        for(Iterator iterator = field_1094_a.values().iterator(); iterator.hasNext(); NBTBase.func_738_a(nbtbase, dataoutput))
        {
            nbtbase = (NBTBase)iterator.next();
        }

        dataoutput.writeByte(0);
    }

    void func_736_a(DataInput datainput)
        throws IOException
    {
        field_1094_a.clear();
        NBTBase nbtbase;
        for(; (nbtbase = NBTBase.func_734_b(datainput)).func_733_a() != 0; field_1094_a.put(nbtbase.func_737_b(), nbtbase)) { }
    }

    public Collection func_28110_c()
    {
        return field_1094_a.values();
    }

    public byte func_733_a()
    {
        return 10;
    }

    public void func_762_a(String s, NBTBase nbtbase)
    {
        field_1094_a.put(s, nbtbase.func_732_a(s));
    }

    public void func_761_a(String s, byte byte0)
    {
        field_1094_a.put(s, new NBTTagByte(s, byte0));
    }

    public void func_749_a(String s, short word0)
    {
        field_1094_a.put(s, new NBTTagShort(s, word0));
    }

    public void func_758_a(String s, int i)
    {
        field_1094_a.put(s, new NBTTagInt(s, i));
    }

    public void func_750_a(String s, long l)
    {
        field_1094_a.put(s, new NBTTagLong(s, l));
    }

    public void func_744_a(String s, float f)
    {
        field_1094_a.put(s, new NBTTagFloat(s, f));
    }

    public void func_765_a(String s, double d)
    {
        field_1094_a.put(s, new NBTTagDouble(s, d));
    }

    public void func_754_a(String s, String s1)
    {
        field_1094_a.put(s, new NBTTagString(s, s1));
    }

    public void func_747_a(String s, byte abyte0[])
    {
        field_1094_a.put(s, new NBTTagByteArray(s, abyte0));
    }

    public void func_763_a(String s, NBTTagCompound nbttagcompound)
    {
        field_1094_a.put(s, nbttagcompound.func_732_a(s));
    }

    public void func_748_a(String s, boolean flag)
    {
        func_761_a(s, ((byte)(flag ? 1 : 0)));
    }

    public NBTBase func_40196_b(String s)
    {
        return (NBTBase)field_1094_a.get(s);
    }

    public boolean func_751_b(String s)
    {
        return field_1094_a.containsKey(s);
    }

    public byte func_746_c(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return 0;
        } else
        {
            return ((NBTTagByte)field_1094_a.get(s)).field_1092_a;
        }
    }

    public short func_745_d(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return 0;
        } else
        {
            return ((NBTTagShort)field_1094_a.get(s)).field_1088_a;
        }
    }

    public int func_756_e(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return 0;
        } else
        {
            return ((NBTTagInt)field_1094_a.get(s)).field_1093_a;
        }
    }

    public long func_764_f(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return 0L;
        } else
        {
            return ((NBTTagLong)field_1094_a.get(s)).field_1095_a;
        }
    }

    public float func_752_g(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return 0.0F;
        } else
        {
            return ((NBTTagFloat)field_1094_a.get(s)).field_1097_a;
        }
    }

    public double func_757_h(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return 0.0D;
        } else
        {
            return ((NBTTagDouble)field_1094_a.get(s)).field_1089_a;
        }
    }

    public String func_755_i(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return "";
        } else
        {
            return ((NBTTagString)field_1094_a.get(s)).field_1098_a;
        }
    }

    public byte[] func_759_j(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return new byte[0];
        } else
        {
            return ((NBTTagByteArray)field_1094_a.get(s)).field_1096_a;
        }
    }

    public NBTTagCompound func_743_k(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return new NBTTagCompound(s);
        } else
        {
            return (NBTTagCompound)field_1094_a.get(s);
        }
    }

    public NBTTagList func_753_l(String s)
    {
        if(!field_1094_a.containsKey(s))
        {
            return new NBTTagList(s);
        } else
        {
            return (NBTTagList)field_1094_a.get(s);
        }
    }

    public boolean func_760_m(String s)
    {
        return func_746_c(s) != 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_1094_a.size()).append(" entries").toString();
    }

    public NBTBase func_40195_b()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound(func_737_b());
        String s;
        for(Iterator iterator = field_1094_a.keySet().iterator(); iterator.hasNext(); nbttagcompound.func_762_a(s, ((NBTBase)field_1094_a.get(s)).func_40195_b()))
        {
            s = (String)iterator.next();
        }

        return nbttagcompound;
    }

    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)obj;
            return field_1094_a.entrySet().equals(nbttagcompound.field_1094_a.entrySet());
        } else
        {
            return false;
        }
    }
}
