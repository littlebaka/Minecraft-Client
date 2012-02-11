// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ProfilerResult

public class Profiler
{

    public static boolean field_40669_a = false;
    private static List field_40667_b = new ArrayList();
    private static List field_40668_c = new ArrayList();
    private static String field_40665_d = "";
    private static Map field_40666_e = new HashMap();

    public Profiler()
    {
    }

    public static void func_40660_a()
    {
        field_40666_e.clear();
    }

    public static void func_40663_a(String s)
    {
        if(!field_40669_a)
        {
            return;
        }
        if(field_40665_d.length() > 0)
        {
            field_40665_d = (new StringBuilder()).append(field_40665_d).append(".").toString();
        }
        field_40665_d = (new StringBuilder()).append(field_40665_d).append(s).toString();
        field_40667_b.add(field_40665_d);
        field_40668_c.add(Long.valueOf(System.nanoTime()));
    }

    public static void func_40662_b()
    {
        if(!field_40669_a)
        {
            return;
        }
        long l = System.nanoTime();
        long l1 = ((Long)field_40668_c.remove(field_40668_c.size() - 1)).longValue();
        field_40667_b.remove(field_40667_b.size() - 1);
        long l2 = l - l1;
        if(field_40666_e.containsKey(field_40665_d))
        {
            field_40666_e.put(field_40665_d, Long.valueOf(((Long)field_40666_e.get(field_40665_d)).longValue() + l2));
        } else
        {
            field_40666_e.put(field_40665_d, Long.valueOf(l2));
        }
        field_40665_d = field_40667_b.size() <= 0 ? "" : (String)field_40667_b.get(field_40667_b.size() - 1);
    }

    public static List func_40664_b(String s)
    {
        if(!field_40669_a)
        {
            return null;
        }
        String s1 = s;
        long l = field_40666_e.containsKey("root") ? ((Long)field_40666_e.get("root")).longValue() : 0L;
        long l1 = field_40666_e.containsKey(s) ? ((Long)field_40666_e.get(s)).longValue() : -1L;
        ArrayList arraylist = new ArrayList();
        if(s.length() > 0)
        {
            s = (new StringBuilder()).append(s).append(".").toString();
        }
        long l2 = 0L;
        Iterator iterator = field_40666_e.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            String s2 = (String)iterator.next();
            if(s2.length() > s.length() && s2.startsWith(s) && s2.indexOf(".", s.length() + 1) < 0)
            {
                l2 += ((Long)field_40666_e.get(s2)).longValue();
            }
        } while(true);
        float f = l2;
        if(l2 < l1)
        {
            l2 = l1;
        }
        if(l < l2)
        {
            l = l2;
        }
        Iterator iterator1 = field_40666_e.keySet().iterator();
        do
        {
            if(!iterator1.hasNext())
            {
                break;
            }
            String s3 = (String)iterator1.next();
            if(s3.length() > s.length() && s3.startsWith(s) && s3.indexOf(".", s.length() + 1) < 0)
            {
                long l3 = ((Long)field_40666_e.get(s3)).longValue();
                double d = ((double)l3 * 100D) / (double)l2;
                double d1 = ((double)l3 * 100D) / (double)l;
                String s5 = s3.substring(s.length());
                arraylist.add(new ProfilerResult(s5, d, d1));
            }
        } while(true);
        String s4;
        for(Iterator iterator2 = field_40666_e.keySet().iterator(); iterator2.hasNext(); field_40666_e.put(s4, Long.valueOf((((Long)field_40666_e.get(s4)).longValue() * 999L) / 1000L)))
        {
            s4 = (String)iterator2.next();
        }

        if((float)l2 > f)
        {
            arraylist.add(new ProfilerResult("unspecified", ((double)((float)l2 - f) * 100D) / (double)l2, ((double)((float)l2 - f) * 100D) / (double)l));
        }
        Collections.sort(arraylist);
        arraylist.add(0, new ProfilerResult(s1, 100D, ((double)l2 * 100D) / (double)l));
        return arraylist;
    }

    public static void func_40661_c(String s)
    {
        func_40662_b();
        func_40663_a(s);
    }

}
