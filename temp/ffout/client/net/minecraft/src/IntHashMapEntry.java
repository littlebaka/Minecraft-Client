// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IntHashMap

class IntHashMapEntry
{

    final int field_1106_a;
    Object field_1105_b;
    IntHashMapEntry field_1108_c;
    final int field_1107_d;

    IntHashMapEntry(int i, int j, Object obj, IntHashMapEntry inthashmapentry)
    {
        field_1105_b = obj;
        field_1108_c = inthashmapentry;
        field_1106_a = j;
        field_1107_d = i;
    }

    public final int func_768_a()
    {
        return field_1106_a;
    }

    public final Object func_767_b()
    {
        return field_1105_b;
    }

    public final boolean equals(Object obj)
    {
        if(!(obj instanceof IntHashMapEntry))
        {
            return false;
        }
        IntHashMapEntry inthashmapentry = (IntHashMapEntry)obj;
        Integer integer = Integer.valueOf(func_768_a());
        Integer integer1 = Integer.valueOf(inthashmapentry.func_768_a());
        if(integer == integer1 || integer != null && integer.equals(integer1))
        {
            Object obj1 = func_767_b();
            Object obj2 = inthashmapentry.func_767_b();
            if(obj1 == obj2 || obj1 != null && obj1.equals(obj2))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return IntHashMap.func_1056_d(field_1106_a);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(func_768_a()).append("=").append(func_767_b()).toString();
    }
}
