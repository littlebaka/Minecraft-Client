// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WatchableObject, Packet, ItemStack, Item, 
//            ChunkCoordinates

public class DataWatcher
{

    private static final HashMap field_21133_a;
    private final Map field_21132_b = new HashMap();
    private boolean field_21134_c;

    public DataWatcher()
    {
    }

    public void func_21124_a(int i, Object obj)
    {
        Integer integer = (Integer)field_21133_a.get(obj.getClass());
        if(integer == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown data type: ").append(obj.getClass()).toString());
        }
        if(i > 31)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Data value id is too big with ").append(i).append("! (Max is ").append(31).append(")").toString());
        }
        if(field_21132_b.containsKey(Integer.valueOf(i)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id value for ").append(i).append("!").toString());
        } else
        {
            WatchableObject watchableobject = new WatchableObject(integer.intValue(), i, obj);
            field_21132_b.put(Integer.valueOf(i), watchableobject);
            return;
        }
    }

    public byte func_21130_a(int i)
    {
        return ((Byte)((WatchableObject)field_21132_b.get(Integer.valueOf(i))).func_21158_b()).byteValue();
    }

    public short func_41062_b(int i)
    {
        return ((Short)((WatchableObject)field_21132_b.get(Integer.valueOf(i))).func_21158_b()).shortValue();
    }

    public int func_25115_b(int i)
    {
        return ((Integer)((WatchableObject)field_21132_b.get(Integer.valueOf(i))).func_21158_b()).intValue();
    }

    public String func_25116_c(int i)
    {
        return (String)((WatchableObject)field_21132_b.get(Integer.valueOf(i))).func_21158_b();
    }

    public void func_21129_b(int i, Object obj)
    {
        WatchableObject watchableobject = (WatchableObject)field_21132_b.get(Integer.valueOf(i));
        if(!obj.equals(watchableobject.func_21158_b()))
        {
            watchableobject.func_21160_a(obj);
            watchableobject.func_21162_a(true);
            field_21134_c = true;
        }
    }

    public static void func_21125_a(List list, DataOutputStream dataoutputstream)
        throws IOException
    {
        if(list != null)
        {
            WatchableObject watchableobject;
            for(Iterator iterator = list.iterator(); iterator.hasNext(); func_21128_a(dataoutputstream, watchableobject))
            {
                watchableobject = (WatchableObject)iterator.next();
            }

        }
        dataoutputstream.writeByte(127);
    }

    public void func_21127_a(DataOutputStream dataoutputstream)
        throws IOException
    {
        WatchableObject watchableobject;
        for(Iterator iterator = field_21132_b.values().iterator(); iterator.hasNext(); func_21128_a(dataoutputstream, watchableobject))
        {
            watchableobject = (WatchableObject)iterator.next();
        }

        dataoutputstream.writeByte(127);
    }

    private static void func_21128_a(DataOutputStream dataoutputstream, WatchableObject watchableobject)
        throws IOException
    {
        int i = (watchableobject.func_21159_c() << 5 | watchableobject.func_21161_a() & 0x1f) & 0xff;
        dataoutputstream.writeByte(i);
        switch(watchableobject.func_21159_c())
        {
        case 0: // '\0'
            dataoutputstream.writeByte(((Byte)watchableobject.func_21158_b()).byteValue());
            break;

        case 1: // '\001'
            dataoutputstream.writeShort(((Short)watchableobject.func_21158_b()).shortValue());
            break;

        case 2: // '\002'
            dataoutputstream.writeInt(((Integer)watchableobject.func_21158_b()).intValue());
            break;

        case 3: // '\003'
            dataoutputstream.writeFloat(((Float)watchableobject.func_21158_b()).floatValue());
            break;

        case 4: // '\004'
            Packet.func_27049_a((String)watchableobject.func_21158_b(), dataoutputstream);
            break;

        case 5: // '\005'
            ItemStack itemstack = (ItemStack)watchableobject.func_21158_b();
            dataoutputstream.writeShort(itemstack.func_1091_a().field_291_aS);
            dataoutputstream.writeByte(itemstack.field_1615_a);
            dataoutputstream.writeShort(itemstack.func_21181_i());
            break;

        case 6: // '\006'
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)watchableobject.func_21158_b();
            dataoutputstream.writeInt(chunkcoordinates.field_22395_a);
            dataoutputstream.writeInt(chunkcoordinates.field_22394_b);
            dataoutputstream.writeInt(chunkcoordinates.field_22396_c);
            break;
        }
    }

    public static List func_21131_a(DataInputStream datainputstream)
        throws IOException
    {
        ArrayList arraylist = null;
        for(byte byte0 = datainputstream.readByte(); byte0 != 127; byte0 = datainputstream.readByte())
        {
            if(arraylist == null)
            {
                arraylist = new ArrayList();
            }
            int i = (byte0 & 0xe0) >> 5;
            int j = byte0 & 0x1f;
            WatchableObject watchableobject = null;
            switch(i)
            {
            case 0: // '\0'
                watchableobject = new WatchableObject(i, j, Byte.valueOf(datainputstream.readByte()));
                break;

            case 1: // '\001'
                watchableobject = new WatchableObject(i, j, Short.valueOf(datainputstream.readShort()));
                break;

            case 2: // '\002'
                watchableobject = new WatchableObject(i, j, Integer.valueOf(datainputstream.readInt()));
                break;

            case 3: // '\003'
                watchableobject = new WatchableObject(i, j, Float.valueOf(datainputstream.readFloat()));
                break;

            case 4: // '\004'
                watchableobject = new WatchableObject(i, j, Packet.func_27048_a(datainputstream, 64));
                break;

            case 5: // '\005'
                short word0 = datainputstream.readShort();
                byte byte1 = datainputstream.readByte();
                short word1 = datainputstream.readShort();
                watchableobject = new WatchableObject(i, j, new ItemStack(word0, byte1, word1));
                break;

            case 6: // '\006'
                int k = datainputstream.readInt();
                int l = datainputstream.readInt();
                int i1 = datainputstream.readInt();
                watchableobject = new WatchableObject(i, j, new ChunkCoordinates(k, l, i1));
                break;
            }
            arraylist.add(watchableobject);
        }

        return arraylist;
    }

    public void func_21126_a(List list)
    {
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            WatchableObject watchableobject = (WatchableObject)iterator.next();
            WatchableObject watchableobject1 = (WatchableObject)field_21132_b.get(Integer.valueOf(watchableobject.func_21161_a()));
            if(watchableobject1 != null)
            {
                watchableobject1.func_21160_a(watchableobject.func_21158_b());
            }
        } while(true);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        field_21133_a = new HashMap();
        field_21133_a.put(java.lang.Byte.class, Integer.valueOf(0));
        field_21133_a.put(java.lang.Short.class, Integer.valueOf(1));
        field_21133_a.put(java.lang.Integer.class, Integer.valueOf(2));
        field_21133_a.put(java.lang.Float.class, Integer.valueOf(3));
        field_21133_a.put(java.lang.String.class, Integer.valueOf(4));
        field_21133_a.put(net.minecraft.src.ItemStack.class, Integer.valueOf(5));
        field_21133_a.put(net.minecraft.src.ChunkCoordinates.class, Integer.valueOf(6));
    }
}
