// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package net.minecraft.src:
//            IntHashMapEntry

public class IntHashMap
{

    private transient IntHashMapEntry field_1590_a[];
    private transient int field_1589_b;
    private int field_1593_c;
    private final float field_1592_d = 0.75F;
    private volatile transient int field_1591_e;
    private Set field_35861_f;

    public IntHashMap()
    {
        field_35861_f = new HashSet();
        field_1593_c = 12;
        field_1590_a = new IntHashMapEntry[16];
    }

    private static int func_1055_e(int i)
    {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int func_1062_a(int i, int j)
    {
        return i & j - 1;
    }

    public Object func_1057_a(int i)
    {
        int j = func_1055_e(i);
        for(IntHashMapEntry inthashmapentry = field_1590_a[func_1062_a(j, field_1590_a.length)]; inthashmapentry != null; inthashmapentry = inthashmapentry.field_1108_c)
        {
            if(inthashmapentry.field_1106_a == i)
            {
                return inthashmapentry.field_1105_b;
            }
        }

        return null;
    }

    public boolean func_35858_b(int i)
    {
        return func_35859_c(i) != null;
    }

    final IntHashMapEntry func_35859_c(int i)
    {
        int j = func_1055_e(i);
        for(IntHashMapEntry inthashmapentry = field_1590_a[func_1062_a(j, field_1590_a.length)]; inthashmapentry != null; inthashmapentry = inthashmapentry.field_1108_c)
        {
            if(inthashmapentry.field_1106_a == i)
            {
                return inthashmapentry;
            }
        }

        return null;
    }

    public void func_1061_a(int i, Object obj)
    {
        field_35861_f.add(Integer.valueOf(i));
        int j = func_1055_e(i);
        int k = func_1062_a(j, field_1590_a.length);
        for(IntHashMapEntry inthashmapentry = field_1590_a[k]; inthashmapentry != null; inthashmapentry = inthashmapentry.field_1108_c)
        {
            if(inthashmapentry.field_1106_a == i)
            {
                inthashmapentry.field_1105_b = obj;
            }
        }

        field_1591_e++;
        func_1053_a(j, i, obj, k);
    }

    private void func_1060_f(int i)
    {
        IntHashMapEntry ainthashmapentry[] = field_1590_a;
        int j = ainthashmapentry.length;
        if(j == 0x40000000)
        {
            field_1593_c = 0x7fffffff;
            return;
        } else
        {
            IntHashMapEntry ainthashmapentry1[] = new IntHashMapEntry[i];
            func_1059_a(ainthashmapentry1);
            field_1590_a = ainthashmapentry1;
            field_1593_c = (int)((float)i * field_1592_d);
            return;
        }
    }

    private void func_1059_a(IntHashMapEntry ainthashmapentry[])
    {
        IntHashMapEntry ainthashmapentry1[] = field_1590_a;
        int i = ainthashmapentry.length;
        for(int j = 0; j < ainthashmapentry1.length; j++)
        {
            IntHashMapEntry inthashmapentry = ainthashmapentry1[j];
            if(inthashmapentry == null)
            {
                continue;
            }
            ainthashmapentry1[j] = null;
            do
            {
                IntHashMapEntry inthashmapentry1 = inthashmapentry.field_1108_c;
                int k = func_1062_a(inthashmapentry.field_1107_d, i);
                inthashmapentry.field_1108_c = ainthashmapentry[k];
                ainthashmapentry[k] = inthashmapentry;
                inthashmapentry = inthashmapentry1;
            } while(inthashmapentry != null);
        }

    }

    public Object func_1052_b(int i)
    {
        field_35861_f.remove(Integer.valueOf(i));
        IntHashMapEntry inthashmapentry = func_1054_c(i);
        return inthashmapentry != null ? inthashmapentry.field_1105_b : null;
    }

    final IntHashMapEntry func_1054_c(int i)
    {
        int j = func_1055_e(i);
        int k = func_1062_a(j, field_1590_a.length);
        IntHashMapEntry inthashmapentry = field_1590_a[k];
        IntHashMapEntry inthashmapentry1;
        IntHashMapEntry inthashmapentry2;
        for(inthashmapentry1 = inthashmapentry; inthashmapentry1 != null; inthashmapentry1 = inthashmapentry2)
        {
            inthashmapentry2 = inthashmapentry1.field_1108_c;
            if(inthashmapentry1.field_1106_a == i)
            {
                field_1591_e++;
                field_1589_b--;
                if(inthashmapentry == inthashmapentry1)
                {
                    field_1590_a[k] = inthashmapentry2;
                } else
                {
                    inthashmapentry.field_1108_c = inthashmapentry2;
                }
                return inthashmapentry1;
            }
            inthashmapentry = inthashmapentry1;
        }

        return inthashmapentry1;
    }

    public void func_1058_a()
    {
        field_1591_e++;
        IntHashMapEntry ainthashmapentry[] = field_1590_a;
        for(int i = 0; i < ainthashmapentry.length; i++)
        {
            ainthashmapentry[i] = null;
        }

        field_1589_b = 0;
    }

    private void func_1053_a(int i, int j, Object obj, int k)
    {
        IntHashMapEntry inthashmapentry = field_1590_a[k];
        field_1590_a[k] = new IntHashMapEntry(i, j, obj, inthashmapentry);
        if(field_1589_b++ >= field_1593_c)
        {
            func_1060_f(2 * field_1590_a.length);
        }
    }

    public Set func_35860_b()
    {
        return field_35861_f;
    }

    static int func_1056_d(int i)
    {
        return func_1055_e(i);
    }
}
