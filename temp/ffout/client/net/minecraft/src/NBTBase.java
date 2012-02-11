// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTTagEnd, NBTTagByte, NBTTagShort, NBTTagInt, 
//            NBTTagLong, NBTTagFloat, NBTTagDouble, NBTTagByteArray, 
//            NBTTagString, NBTTagList, NBTTagCompound

public abstract class NBTBase
{

    private String field_1087_a;

    abstract void func_735_a(DataOutput dataoutput)
        throws IOException;

    abstract void func_736_a(DataInput datainput)
        throws IOException;

    public abstract byte func_733_a();

    protected NBTBase(String s)
    {
        if(s == null)
        {
            field_1087_a = "";
        } else
        {
            field_1087_a = s;
        }
    }

    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof NBTBase))
        {
            return false;
        }
        NBTBase nbtbase = (NBTBase)obj;
        if(func_733_a() != nbtbase.func_733_a())
        {
            return false;
        }
        if(field_1087_a == null && nbtbase.field_1087_a != null || field_1087_a != null && nbtbase.field_1087_a == null)
        {
            return false;
        }
        return field_1087_a == null || field_1087_a.equals(nbtbase.field_1087_a);
    }

    public NBTBase func_732_a(String s)
    {
        if(s == null)
        {
            field_1087_a = "";
        } else
        {
            field_1087_a = s;
        }
        return this;
    }

    public String func_737_b()
    {
        if(field_1087_a == null)
        {
            return "";
        } else
        {
            return field_1087_a;
        }
    }

    public static NBTBase func_734_b(DataInput datainput)
        throws IOException
    {
        byte byte0 = datainput.readByte();
        if(byte0 == 0)
        {
            return new NBTTagEnd();
        } else
        {
            String s = datainput.readUTF();
            NBTBase nbtbase = func_739_a(byte0, s);
            nbtbase.func_736_a(datainput);
            return nbtbase;
        }
    }

    public static void func_738_a(NBTBase nbtbase, DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeByte(nbtbase.func_733_a());
        if(nbtbase.func_733_a() == 0)
        {
            return;
        } else
        {
            dataoutput.writeUTF(nbtbase.func_737_b());
            nbtbase.func_735_a(dataoutput);
            return;
        }
    }

    public static NBTBase func_739_a(byte byte0, String s)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return new NBTTagEnd();

        case 1: // '\001'
            return new NBTTagByte(s);

        case 2: // '\002'
            return new NBTTagShort(s);

        case 3: // '\003'
            return new NBTTagInt(s);

        case 4: // '\004'
            return new NBTTagLong(s);

        case 5: // '\005'
            return new NBTTagFloat(s);

        case 6: // '\006'
            return new NBTTagDouble(s);

        case 7: // '\007'
            return new NBTTagByteArray(s);

        case 8: // '\b'
            return new NBTTagString(s);

        case 9: // '\t'
            return new NBTTagList(s);

        case 10: // '\n'
            return new NBTTagCompound(s);
        }
        return null;
    }

    public static String func_731_b(byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return "TAG_End";

        case 1: // '\001'
            return "TAG_Byte";

        case 2: // '\002'
            return "TAG_Short";

        case 3: // '\003'
            return "TAG_Int";

        case 4: // '\004'
            return "TAG_Long";

        case 5: // '\005'
            return "TAG_Float";

        case 6: // '\006'
            return "TAG_Double";

        case 7: // '\007'
            return "TAG_Byte_Array";

        case 8: // '\b'
            return "TAG_String";

        case 9: // '\t'
            return "TAG_List";

        case 10: // '\n'
            return "TAG_Compound";
        }
        return "UNKNOWN";
    }

    public abstract NBTBase func_40195_b();
}
