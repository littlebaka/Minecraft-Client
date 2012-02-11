// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

public class StringTranslate
{

    private static StringTranslate field_20165_a = new StringTranslate();
    private Properties field_20164_b;
    private TreeMap field_44027_c;
    private String field_44026_d;
    private boolean field_46111_e;

    private StringTranslate()
    {
        field_20164_b = new Properties();
        func_44021_d();
        func_44023_a("en_US");
    }

    public static StringTranslate func_20162_a()
    {
        return field_20165_a;
    }

    private void func_44021_d()
    {
        TreeMap treemap = new TreeMap();
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.StringTranslate.class).getResourceAsStream("/lang/languages.txt"), "UTF-8"));
            for(String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            {
                String as[] = s.split("=");
                if(as != null && as.length == 2)
                {
                    treemap.put(as[0], as[1]);
                }
            }

        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        field_44027_c = treemap;
    }

    public TreeMap func_44022_b()
    {
        return field_44027_c;
    }

    private void func_44025_a(Properties properties, String s)
        throws IOException
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.StringTranslate.class).getResourceAsStream((new StringBuilder()).append("/lang/").append(s).append(".lang").toString()), "UTF-8"));
        for(String s1 = bufferedreader.readLine(); s1 != null; s1 = bufferedreader.readLine())
        {
            s1 = s1.trim();
            if(s1.startsWith("#"))
            {
                continue;
            }
            String as[] = s1.split("=");
            if(as != null && as.length == 2)
            {
                properties.setProperty(as[0], as[1]);
            }
        }

    }

    public void func_44023_a(String s)
    {
        Properties properties;
        if(s.equals(field_44026_d))
        {
            return;
        }
        properties = new Properties();
        try
        {
            func_44025_a(properties, "en_US");
        }
        catch(IOException ioexception) { }
        field_46111_e = false;
        if("en_US".equals(s))
        {
            break MISSING_BLOCK_LABEL_152;
        }
        Enumeration enumeration;
        func_44025_a(properties, s);
        enumeration = properties.propertyNames();
_L2:
        String s1;
        int i;
        Object obj1;
        do
        {
            if(!enumeration.hasMoreElements() || field_46111_e)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            Object obj = enumeration.nextElement();
            obj1 = properties.get(obj);
        } while(obj1 == null);
        s1 = obj1.toString();
        i = 0;
_L5:
        if(i >= s1.length()) goto _L2; else goto _L1
_L1:
        if(s1.charAt(i) < '\u0100') goto _L4; else goto _L3
_L3:
        field_46111_e = true;
          goto _L2
_L4:
        i++;
          goto _L5
        IOException ioexception1;
        ioexception1;
        ioexception1.printStackTrace();
        return;
        field_44026_d = s;
        field_20164_b = properties;
        return;
          goto _L2
    }

    public String func_44024_c()
    {
        return field_44026_d;
    }

    public boolean func_46110_d()
    {
        return field_46111_e;
    }

    public String func_20163_a(String s)
    {
        return field_20164_b.getProperty(s, s);
    }

    public String func_20160_a(String s, Object aobj[])
    {
        String s1 = field_20164_b.getProperty(s, s);
        return String.format(s1, aobj);
    }

    public String func_20161_b(String s)
    {
        return field_20164_b.getProperty((new StringBuilder()).append(s).append(".name").toString(), "");
    }

    public static boolean func_46109_d(String s)
    {
        return "ar_SA".equals(s) || "he_IL".equals(s);
    }

}
