// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.*;

public class ThreadDownloadResources extends Thread
{

    public File field_1768_a;
    private Minecraft field_1767_b;
    private boolean field_1769_c;

    public ThreadDownloadResources(File file, Minecraft minecraft)
    {
        field_1769_c = false;
        field_1767_b = minecraft;
        setName("Resource download thread");
        setDaemon(true);
        field_1768_a = new File(file, "resources/");
        if(!field_1768_a.exists() && !field_1768_a.mkdirs())
        {
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(field_1768_a).toString());
        } else
        {
            return;
        }
    }

    public void run()
    {
        try
        {
            URL url = new URL("http://s3.amazonaws.com/MinecraftResources/");
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            Document document = documentbuilder.parse(url.openStream());
            NodeList nodelist = document.getElementsByTagName("Contents");
            for(int i = 0; i < 2; i++)
            {
                for(int j = 0; j < nodelist.getLength(); j++)
                {
                    Node node = nodelist.item(j);
                    if(node.getNodeType() != 1)
                    {
                        continue;
                    }
                    Element element = (Element)node;
                    String s = ((Element)element.getElementsByTagName("Key").item(0)).getChildNodes().item(0).getNodeValue();
                    long l = Long.parseLong(((Element)element.getElementsByTagName("Size").item(0)).getChildNodes().item(0).getNodeValue());
                    if(l <= 0L)
                    {
                        continue;
                    }
                    func_1211_a(url, s, l, i);
                    if(field_1769_c)
                    {
                        return;
                    }
                }

            }

        }
        catch(Exception exception)
        {
            func_1209_a(field_1768_a, "");
            exception.printStackTrace();
        }
    }

    public void func_1210_a()
    {
        func_1209_a(field_1768_a, "");
    }

    private void func_1209_a(File file, String s)
    {
        File afile[] = file.listFiles();
        for(int i = 0; i < afile.length; i++)
        {
            if(afile[i].isDirectory())
            {
                func_1209_a(afile[i], (new StringBuilder()).append(s).append(afile[i].getName()).append("/").toString());
                continue;
            }
            try
            {
                field_1767_b.func_6268_a((new StringBuilder()).append(s).append(afile[i].getName()).toString(), afile[i]);
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("Failed to add ").append(s).append(afile[i].getName()).toString());
            }
        }

    }

    private void func_1211_a(URL url, String s, long l, int i)
    {
        try
        {
            int j = s.indexOf("/");
            String s1 = s.substring(0, j);
            if(s1.equals("sound") || s1.equals("newsound"))
            {
                if(i != 0)
                {
                    return;
                }
            } else
            if(i != 1)
            {
                return;
            }
            File file = new File(field_1768_a, s);
            if(!file.exists() || file.length() != l)
            {
                file.getParentFile().mkdirs();
                String s2 = s.replaceAll(" ", "%20");
                func_1212_a(new URL(url, s2), file, l);
                if(field_1769_c)
                {
                    return;
                }
            }
            field_1767_b.func_6268_a(s, file);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_1212_a(URL url, File file, long l)
        throws IOException
    {
        byte abyte0[] = new byte[4096];
        DataInputStream datainputstream = new DataInputStream(url.openStream());
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
        for(int i = 0; (i = datainputstream.read(abyte0)) >= 0;)
        {
            dataoutputstream.write(abyte0, 0, i);
            if(field_1769_c)
            {
                return;
            }
        }

        datainputstream.close();
        dataoutputstream.close();
    }

    public void func_1208_b()
    {
        field_1769_c = true;
    }
}
