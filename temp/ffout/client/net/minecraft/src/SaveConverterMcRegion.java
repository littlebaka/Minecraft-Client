// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

// Referenced classes of package net.minecraft.src:
//            SaveFormatOld, WorldInfo, MathHelper, SaveFormatComparator, 
//            RegionFileCache, SaveOldDir, IProgressUpdate, ISaveHandler, 
//            ChunkFolderPattern, ChunkFilePattern, ChunkFile, RegionFile

public class SaveConverterMcRegion extends SaveFormatOld
{

    public SaveConverterMcRegion(File file)
    {
        super(file);
    }

    public String func_22178_a()
    {
        return "Scaevolus' McRegion";
    }

    public List func_22176_b()
    {
        ArrayList arraylist = new ArrayList();
        File afile[] = field_22180_a.listFiles();
        File afile1[] = afile;
        int i = afile1.length;
        for(int j = 0; j < i; j++)
        {
            File file = afile1[j];
            if(!file.isDirectory())
            {
                continue;
            }
            String s = file.getName();
            WorldInfo worldinfo = func_22173_b(s);
            if(worldinfo == null)
            {
                continue;
            }
            boolean flag = worldinfo.func_22296_k() != 19132;
            String s1 = worldinfo.func_22302_j();
            if(s1 == null || MathHelper.func_22282_a(s1))
            {
                s1 = s;
            }
            long l = 0L;
            arraylist.add(new SaveFormatComparator(s, s1, worldinfo.func_22301_l(), l, worldinfo.func_35918_q(), flag, worldinfo.func_40724_s()));
        }

        return arraylist;
    }

    public void func_22177_c()
    {
        RegionFileCache.func_22192_a();
    }

    public ISaveHandler func_22174_a(String s, boolean flag)
    {
        return new SaveOldDir(field_22180_a, s, flag);
    }

    public boolean func_22175_a(String s)
    {
        WorldInfo worldinfo = func_22173_b(s);
        return worldinfo != null && worldinfo.func_22296_k() == 0;
    }

    public boolean func_22171_a(String s, IProgressUpdate iprogressupdate)
    {
        iprogressupdate.func_593_a(0);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        ArrayList arraylist4 = new ArrayList();
        ArrayList arraylist5 = new ArrayList();
        File file = new File(field_22180_a, s);
        File file1 = new File(file, "DIM-1");
        File file2 = new File(file, "DIM1");
        System.out.println("Scanning folders...");
        func_22183_a(file, arraylist, arraylist1);
        if(file1.exists())
        {
            func_22183_a(file1, arraylist2, arraylist3);
        }
        if(file2.exists())
        {
            func_22183_a(file2, arraylist4, arraylist5);
        }
        int i = arraylist.size() + arraylist2.size() + arraylist4.size() + arraylist1.size() + arraylist3.size() + arraylist5.size();
        System.out.println((new StringBuilder()).append("Total conversion count is ").append(i).toString());
        func_22181_a(file, arraylist, 0, i, iprogressupdate);
        func_22181_a(file1, arraylist2, arraylist.size(), i, iprogressupdate);
        func_22181_a(file2, arraylist4, arraylist.size() + arraylist2.size(), i, iprogressupdate);
        WorldInfo worldinfo = func_22173_b(s);
        worldinfo.func_22289_d(19132);
        ISaveHandler isavehandler = func_22174_a(s, false);
        isavehandler.func_22152_a(worldinfo);
        func_22182_a(arraylist1, arraylist.size() + arraylist2.size(), i, iprogressupdate);
        if(file1.exists())
        {
            func_22182_a(arraylist3, arraylist.size() + arraylist2.size() + arraylist1.size(), i, iprogressupdate);
        }
        return true;
    }

    private void func_22183_a(File file, ArrayList arraylist, ArrayList arraylist1)
    {
        ChunkFolderPattern chunkfolderpattern = new ChunkFolderPattern(null);
        ChunkFilePattern chunkfilepattern = new ChunkFilePattern(null);
        File afile[] = file.listFiles(chunkfolderpattern);
        File afile1[] = afile;
        int i = afile1.length;
        for(int j = 0; j < i; j++)
        {
            File file1 = afile1[j];
            arraylist1.add(file1);
            File afile2[] = file1.listFiles(chunkfolderpattern);
            File afile3[] = afile2;
            int k = afile3.length;
            for(int l = 0; l < k; l++)
            {
                File file2 = afile3[l];
                File afile4[] = file2.listFiles(chunkfilepattern);
                File afile5[] = afile4;
                int i1 = afile5.length;
                for(int j1 = 0; j1 < i1; j1++)
                {
                    File file3 = afile5[j1];
                    arraylist.add(new ChunkFile(file3));
                }

            }

        }

    }

    private void func_22181_a(File file, ArrayList arraylist, int i, int j, IProgressUpdate iprogressupdate)
    {
        Collections.sort(arraylist);
        byte abyte0[] = new byte[4096];
        int i1;
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); iprogressupdate.func_593_a(i1))
        {
            ChunkFile chunkfile = (ChunkFile)iterator.next();
            int k = chunkfile.func_22323_b();
            int l = chunkfile.func_22321_c();
            RegionFile regionfile = RegionFileCache.func_22193_a(file, k, l);
            if(!regionfile.func_22202_c(k & 0x1f, l & 0x1f))
            {
                try
                {
                    DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new FileInputStream(chunkfile.func_22324_a()))));
                    DataOutputStream dataoutputstream = regionfile.func_22205_b(k & 0x1f, l & 0x1f);
                    for(int j1 = 0; (j1 = datainputstream.read(abyte0)) != -1;)
                    {
                        dataoutputstream.write(abyte0, 0, j1);
                    }

                    dataoutputstream.close();
                    datainputstream.close();
                }
                catch(IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
            }
            i++;
            i1 = (int)Math.round((100D * (double)i) / (double)j);
        }

        RegionFileCache.func_22192_a();
    }

    private void func_22182_a(ArrayList arraylist, int i, int j, IProgressUpdate iprogressupdate)
    {
        int k;
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); iprogressupdate.func_593_a(k))
        {
            File file = (File)iterator.next();
            File afile[] = file.listFiles();
            func_22179_a(afile);
            file.delete();
            i++;
            k = (int)Math.round((100D * (double)i) / (double)j);
        }

    }
}