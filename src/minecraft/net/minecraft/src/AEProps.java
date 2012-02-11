// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            ModLoader, World, SaveHandler, AEPropSection

public class AEProps
{

    public String name;
    public String header;
    public List sections;
    public File path;
    public File dir;
    public Logger logger;

    public AEProps(File file, String s, String s1)
    {
        path = file;
        name = s;
        header = s1;
        sections = new ArrayList();
        if(!path.getParentFile().exists())
        {
            path.getParentFile().mkdirs();
        }
        logger = Logger.getLogger(s);
        //logger.setParent(ModLoader.getLogger());
    }

    public AEProps(String s, String s1, String s2)
    {
        this(new File(getGlobalDir(), s), s1, s2);
    }

    public static File getWorldDir(World world)
    {
        return ((SaveHandler)world.saveHandler).getSaveDirectory();
    }

    public static File getGlobalDir()
    {
        return Minecraft.getAppDir("minecraft/config");
    }

    public void addSection(AEPropSection aepropsection)
    {
        sections.add(aepropsection);
    }

    public void load()
    {
        loadConfig();
        saveConfig();
    }

    public void saveConfig()
    {
        BufferedWriter bufferedwriter = null;
        try
        {
            bufferedwriter = new BufferedWriter(new FileWriter(path));
            store(bufferedwriter);
        }
        catch(IOException ioexception)
        {
            logger.severe((new StringBuilder()).append("Couldn't write aether config to: ").append(path).toString());
        }
        finally
        {
            try
            {
                if(bufferedwriter != null)
                {
                    bufferedwriter.close();
                }
            }
            catch(IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
        }
    }

    public void store(BufferedWriter bufferedwriter)
        throws IOException
    {
        writeHeader(bufferedwriter);
        AEPropSection aepropsection;
        for(Iterator iterator = sections.iterator(); iterator.hasNext(); aepropsection.store(bufferedwriter))
        {
            aepropsection = (AEPropSection)iterator.next();
        }

    }

    public void writeHeader(BufferedWriter bufferedwriter)
        throws IOException
    {
        bufferedwriter.write((new StringBuilder()).append("### ").append(name).append(" ###").toString());
        bufferedwriter.newLine();
        bufferedwriter.write((new StringBuilder()).append("# Written on ").append((new Date()).toString()).toString());
        bufferedwriter.newLine();
        bufferedwriter.newLine();
        if(header != null)
        {
            writeMultiLine(bufferedwriter, header);
        }
    }

    public static void writeMultiLine(BufferedWriter bufferedwriter, String s)
        throws IOException
    {
        String as[] = s.split("\n");
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String s1 = as[j];
            s1 = s1.trim();
            bufferedwriter.write((new StringBuilder()).append("# ").append(s1).toString());
            bufferedwriter.newLine();
        }

    }

    public void loadConfig()
    {
        if(!path.canRead() || !path.isFile())
        {
            logger.warning((new StringBuilder()).append("Couldn't load config file from ").append(path).toString());
            return;
        }
        Properties properties = new Properties();
        FileInputStream fileinputstream = null;
        try
        {
            fileinputstream = new FileInputStream(path);
            properties.load(fileinputstream);
        }
        catch(IOException ioexception)
        {
            logger.warning((new StringBuilder()).append("Couldn't load config file from ").append(path).toString());
            logger.throwing(getClass().getSimpleName(), "loadConfig", ioexception);
            return;
        }
        finally
        {
            if(fileinputstream != null)
            {
                try
                {
                    fileinputstream.close();
                }
                catch(IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                }
            }
        }
        loadConfig(properties);
        logger.finer((new StringBuilder()).append("Loaded config file from ").append(path).toString());
    }

    public void loadConfig(Properties properties)
    {
        AEPropSection aepropsection;
        for(Iterator iterator = sections.iterator(); iterator.hasNext(); aepropsection.loadConfig(properties))
        {
            aepropsection = (AEPropSection)iterator.next();
        }

    }
}
