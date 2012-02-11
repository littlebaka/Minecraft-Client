package net.minecraft.src;

import java.io.*;
import java.util.*;

public class StringTranslate
{
    private static StringTranslate instance = new StringTranslate();
    private Properties translateTable;
    private TreeMap field_44027_c;
    private String field_44026_d;
    private boolean field_46111_e;

    private StringTranslate()
    {
        translateTable = new Properties();
        func_44021_d();
        func_44023_a("en_US");
    }

    public static StringTranslate getInstance()
    {
        return instance;
    }

    private void func_44021_d()
    {
        TreeMap treemap = new TreeMap();
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.StringTranslate.class).getResourceAsStream("/lang/languages.txt"), "UTF-8"));
            for (String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            {
                String as[] = s.split("=");
                if (as != null && as.length == 2)
                {
                    treemap.put(as[0], as[1]);
                }
            }
        }
        catch (IOException ioexception)
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
        for (String s1 = bufferedreader.readLine(); s1 != null; s1 = bufferedreader.readLine())
        {
            s1 = s1.trim();
            if (s1.startsWith("#"))
            {
                continue;
            }
            String as[] = s1.split("=");
            if (as != null && as.length == 2)
            {
                properties.setProperty(as[0], as[1]);
            }
        }
    }

    public void func_44023_a(String var1)
    {
        if (!var1.equals(this.field_44026_d))
        {
            Properties var2 = new Properties();

            try
            {
                this.func_44025_a(var2, "en_US");
            }
            catch (IOException var8)
            {
                ;
            }

            this.field_46111_e = false;
            if (!"en_US".equals(var1))
            {
                try
                {
                    this.func_44025_a(var2, var1);
                    Enumeration var3 = var2.propertyNames();

                    while (var3.hasMoreElements() && !this.field_46111_e)
                    {
                        Object var4 = var3.nextElement();
                        Object var5 = var2.get(var4);
                        if (var5 != null)
                        {
                            String var6 = var5.toString();

                            for (int var7 = 0; var7 < var6.length(); ++var7)
                            {
                                if (var6.charAt(var7) >= 256)
                                {
                                    this.field_46111_e = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                catch (IOException var9)
                {
                    var9.printStackTrace();
                    return;
                }
            }

            this.field_44026_d = var1;
            this.translateTable = var2;
        }
    }

    public String func_44024_c()
    {
        return field_44026_d;
    }

    public boolean func_46110_d()
    {
        return field_46111_e;
    }

    public String translateKey(String s)
    {
        return translateTable.getProperty(s, s);
    }

    public String translateKeyFormat(String s, Object aobj[])
    {
        String s1 = translateTable.getProperty(s, s);
        return String.format(s1, aobj);
    }

    public String translateNamedKey(String s)
    {
        return translateTable.getProperty((new StringBuilder()).append(s).append(".name").toString(), "");
    }

    public static boolean func_46109_d(String s)
    {
        return "ar_SA".equals(s) || "he_IL".equals(s);
    }
}
