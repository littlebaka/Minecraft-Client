// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IThreadedFileIO, IChunkLoader, ChunkCoordIntPair, ThreadedChunkLoaderPending, 
//            RegionFileCache, CompressedStreamTools, NBTTagCompound, ChunkLoader, 
//            Chunk, World, ThreadedFileIOBase

public class ThreadedChunkLoader
    implements IThreadedFileIO, IChunkLoader
{

    private List field_40556_a;
    private Set field_40554_b;
    private Object field_40555_c;
    private final File field_40553_d;

    public ThreadedChunkLoader(File file)
    {
        field_40556_a = new ArrayList();
        field_40554_b = new HashSet();
        field_40555_c = new Object();
        field_40553_d = file;
    }

    public Chunk func_813_a(World world, int i, int j)
        throws IOException
    {
        NBTTagCompound nbttagcompound = null;
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i, j);
        synchronized(field_40555_c)
        {
            if(field_40554_b.contains(chunkcoordintpair))
            {
                int k = 0;
                do
                {
                    if(k >= field_40556_a.size())
                    {
                        break;
                    }
                    if(((ThreadedChunkLoaderPending)field_40556_a.get(k)).field_40739_a.equals(chunkcoordintpair))
                    {
                        nbttagcompound = ((ThreadedChunkLoaderPending)field_40556_a.get(k)).field_40738_b;
                        break;
                    }
                    k++;
                } while(true);
            }
        }
        if(nbttagcompound == null)
        {
            java.io.DataInputStream datainputstream = RegionFileCache.func_22194_c(field_40553_d, i, j);
            if(datainputstream != null)
            {
                nbttagcompound = CompressedStreamTools.func_1141_a(datainputstream);
            } else
            {
                return null;
            }
        }
        if(!nbttagcompound.func_751_b("Level"))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is missing level data, skipping").toString());
            return null;
        }
        if(!nbttagcompound.func_743_k("Level").func_751_b("Blocks"))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is missing block data, skipping").toString());
            return null;
        }
        Chunk chunk = ChunkLoader.func_816_a(world, nbttagcompound.func_743_k("Level"));
        if(!chunk.func_1017_a(i, j))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is in the wrong location; relocating. (Expected ").append(i).append(", ").append(j).append(", got ").append(chunk.field_1531_j).append(", ").append(chunk.field_1530_k).append(")").toString());
            nbttagcompound.func_758_a("xPos", i);
            nbttagcompound.func_758_a("zPos", j);
            chunk = ChunkLoader.func_816_a(world, nbttagcompound.func_743_k("Level"));
        }
        chunk.func_25124_i();
        return chunk;
    }

    public void func_812_a(World world, Chunk chunk)
    {
        world.func_663_l();
        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound.func_762_a("Level", nbttagcompound1);
            ChunkLoader.func_818_a(chunk, world, nbttagcompound1);
            func_40552_a(chunk.func_40740_k(), nbttagcompound);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_40552_a(ChunkCoordIntPair chunkcoordintpair, NBTTagCompound nbttagcompound)
    {
        synchronized(field_40555_c)
        {
            if(field_40554_b.contains(chunkcoordintpair))
            {
                for(int i = 0; i < field_40556_a.size(); i++)
                {
                    if(((ThreadedChunkLoaderPending)field_40556_a.get(i)).field_40739_a.equals(chunkcoordintpair))
                    {
                        field_40556_a.set(i, new ThreadedChunkLoaderPending(chunkcoordintpair, nbttagcompound));
                        return;
                    }
                }

            }
            field_40556_a.add(new ThreadedChunkLoaderPending(chunkcoordintpair, nbttagcompound));
            field_40554_b.add(chunkcoordintpair);
            ThreadedFileIOBase.field_40573_a.func_40567_a(this);
            return;
        }
    }

    public boolean func_40550_A_()
    {
        ThreadedChunkLoaderPending threadedchunkloaderpending = null;
        synchronized(field_40555_c)
        {
            if(field_40556_a.size() > 0)
            {
                threadedchunkloaderpending = (ThreadedChunkLoaderPending)field_40556_a.remove(0);
                field_40554_b.remove(threadedchunkloaderpending.field_40739_a);
            } else
            {
                return false;
            }
        }
        if(threadedchunkloaderpending != null)
        {
            try
            {
                func_40551_a(threadedchunkloaderpending);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        return true;
    }

    public void func_40551_a(ThreadedChunkLoaderPending threadedchunkloaderpending)
        throws IOException
    {
        DataOutputStream dataoutputstream = RegionFileCache.func_22190_d(field_40553_d, threadedchunkloaderpending.field_40739_a.field_189_a, threadedchunkloaderpending.field_40739_a.field_188_b);
        CompressedStreamTools.func_1139_a(threadedchunkloaderpending.field_40738_b, dataoutputstream);
        dataoutputstream.close();
    }

    public void func_815_b(World world, Chunk chunk)
    {
    }

    public void func_814_a()
    {
    }

    public void func_811_b()
    {
    }
}
