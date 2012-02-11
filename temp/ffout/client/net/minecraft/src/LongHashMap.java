// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            LongHashMapEntry

public class LongHashMap
{

    private transient LongHashMapEntry field_35584_a[];
    private transient int field_35582_b;
    private int field_35583_c;
    private final float field_35580_d = 0.75F;
    private volatile transient int field_35581_e;

    public LongHashMap()
    {
        field_35583_c = 12;
        field_35584_a = new LongHashMapEntry[16];
    }

    private static int func_35568_g(long l)
    {
        return func_35571_a((int)(l ^ l >>> 32));
    }

    private static int func_35571_a(int i)
    {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int func_35573_a(int i, int j)
    {
        return i & j - 1;
    }

    public int func_35576_a()
    {
        return field_35582_b;
    }

    public Object func_35578_a(long l)
    {
        int i = func_35568_g(l);
        for(LongHashMapEntry longhashmapentry = field_35584_a[func_35573_a(i, field_35584_a.length)]; longhashmapentry != null; longhashmapentry = longhashmapentry.field_35833_c)
        {
            if(longhashmapentry.field_35834_a == l)
            {
                return longhashmapentry.field_35832_b;
            }
        }

        return null;
    }

    public boolean func_35575_b(long l)
    {
        return func_35569_c(l) != null;
    }

    final LongHashMapEntry func_35569_c(long l)
    {
        int i = func_35568_g(l);
        for(LongHashMapEntry longhashmapentry = field_35584_a[func_35573_a(i, field_35584_a.length)]; longhashmapentry != null; longhashmapentry = longhashmapentry.field_35833_c)
        {
            if(longhashmapentry.field_35834_a == l)
            {
                return longhashmapentry;
            }
        }

        return null;
    }

    public void func_35577_a(long l, Object obj)
    {
        int i = func_35568_g(l);
        int j = func_35573_a(i, field_35584_a.length);
        for(LongHashMapEntry longhashmapentry = field_35584_a[j]; longhashmapentry != null; longhashmapentry = longhashmapentry.field_35833_c)
        {
            if(longhashmapentry.field_35834_a == l)
            {
                longhashmapentry.field_35832_b = obj;
            }
        }

        field_35581_e++;
        func_35570_a(i, l, obj, j);
    }

    private void func_35567_b(int i)
    {
        LongHashMapEntry alonghashmapentry[] = field_35584_a;
        int j = alonghashmapentry.length;
        if(j == 0x40000000)
        {
            field_35583_c = 0x7fffffff;
            return;
        } else
        {
            LongHashMapEntry alonghashmapentry1[] = new LongHashMapEntry[i];
            func_35579_a(alonghashmapentry1);
            field_35584_a = alonghashmapentry1;
            field_35583_c = (int)((float)i * field_35580_d);
            return;
        }
    }

    private void func_35579_a(LongHashMapEntry alonghashmapentry[])
    {
        LongHashMapEntry alonghashmapentry1[] = field_35584_a;
        int i = alonghashmapentry.length;
        for(int j = 0; j < alonghashmapentry1.length; j++)
        {
            LongHashMapEntry longhashmapentry = alonghashmapentry1[j];
            if(longhashmapentry == null)
            {
                continue;
            }
            alonghashmapentry1[j] = null;
            do
            {
                LongHashMapEntry longhashmapentry1 = longhashmapentry.field_35833_c;
                int k = func_35573_a(longhashmapentry.field_35831_d, i);
                longhashmapentry.field_35833_c = alonghashmapentry[k];
                alonghashmapentry[k] = longhashmapentry;
                longhashmapentry = longhashmapentry1;
            } while(longhashmapentry != null);
        }

    }

    public Object func_35574_d(long l)
    {
        LongHashMapEntry longhashmapentry = func_35572_e(l);
        return longhashmapentry != null ? longhashmapentry.field_35832_b : null;
    }

    final LongHashMapEntry func_35572_e(long l)
    {
        int i = func_35568_g(l);
        int j = func_35573_a(i, field_35584_a.length);
        LongHashMapEntry longhashmapentry = field_35584_a[j];
        LongHashMapEntry longhashmapentry1;
        LongHashMapEntry longhashmapentry2;
        for(longhashmapentry1 = longhashmapentry; longhashmapentry1 != null; longhashmapentry1 = longhashmapentry2)
        {
            longhashmapentry2 = longhashmapentry1.field_35833_c;
            if(longhashmapentry1.field_35834_a == l)
            {
                field_35581_e++;
                field_35582_b--;
                if(longhashmapentry == longhashmapentry1)
                {
                    field_35584_a[j] = longhashmapentry2;
                } else
                {
                    longhashmapentry.field_35833_c = longhashmapentry2;
                }
                return longhashmapentry1;
            }
            longhashmapentry = longhashmapentry1;
        }

        return longhashmapentry1;
    }

    private void func_35570_a(int i, long l, Object obj, int j)
    {
        LongHashMapEntry longhashmapentry = field_35584_a[j];
        field_35584_a[j] = new LongHashMapEntry(i, l, obj, longhashmapentry);
        if(field_35582_b++ >= field_35583_c)
        {
            func_35567_b(2 * field_35584_a.length);
        }
    }

    static int func_35566_f(long l)
    {
        return func_35568_g(l);
    }
}
