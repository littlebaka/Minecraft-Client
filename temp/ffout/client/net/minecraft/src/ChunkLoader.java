// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IChunkLoader, CompressedStreamTools, NBTTagCompound, Chunk, 
//            World, WorldInfo, NibbleArray, NBTTagList, 
//            Entity, TileEntity, NextTickListEntry, EntityList

public class ChunkLoader
    implements IChunkLoader
{

    private File field_1200_a;
    private boolean field_1199_b;

    public ChunkLoader(File file, boolean flag)
    {
        field_1200_a = file;
        field_1199_b = flag;
    }

    private File func_817_a(int i, int j)
    {
        String s = (new StringBuilder()).append("c.").append(Integer.toString(i, 36)).append(".").append(Integer.toString(j, 36)).append(".dat").toString();
        String s1 = Integer.toString(i & 0x3f, 36);
        String s2 = Integer.toString(j & 0x3f, 36);
        File file = new File(field_1200_a, s1);
        if(!file.exists())
        {
            if(field_1199_b)
            {
                file.mkdir();
            } else
            {
                return null;
            }
        }
        file = new File(file, s2);
        if(!file.exists())
        {
            if(field_1199_b)
            {
                file.mkdir();
            } else
            {
                return null;
            }
        }
        file = new File(file, s);
        if(!file.exists() && !field_1199_b)
        {
            return null;
        } else
        {
            return file;
        }
    }

    public Chunk func_813_a(World world, int i, int j)
        throws IOException
    {
        File file = func_817_a(i, j);
        if(file != null && file.exists())
        {
            try
            {
                FileInputStream fileinputstream = new FileInputStream(file);
                NBTTagCompound nbttagcompound = CompressedStreamTools.func_1138_a(fileinputstream);
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
                Chunk chunk = func_816_a(world, nbttagcompound.func_743_k("Level"));
                if(!chunk.func_1017_a(i, j))
                {
                    System.out.println((new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is in the wrong location; relocating. (Expected ").append(i).append(", ").append(j).append(", got ").append(chunk.field_1531_j).append(", ").append(chunk.field_1530_k).append(")").toString());
                    nbttagcompound.func_758_a("xPos", i);
                    nbttagcompound.func_758_a("zPos", j);
                    chunk = func_816_a(world, nbttagcompound.func_743_k("Level"));
                }
                chunk.func_25124_i();
                return chunk;
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void func_812_a(World world, Chunk chunk)
        throws IOException
    {
        world.func_663_l();
        File file = func_817_a(chunk.field_1531_j, chunk.field_1530_k);
        if(file.exists())
        {
            WorldInfo worldinfo = world.func_22144_v();
            worldinfo.func_22297_b(worldinfo.func_22306_g() - file.length());
        }
        try
        {
            File file1 = new File(field_1200_a, "tmp_chunk.dat");
            FileOutputStream fileoutputstream = new FileOutputStream(file1);
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound.func_762_a("Level", nbttagcompound1);
            func_818_a(chunk, world, nbttagcompound1);
            CompressedStreamTools.func_1143_a(nbttagcompound, fileoutputstream);
            fileoutputstream.close();
            if(file.exists())
            {
                file.delete();
            }
            file1.renameTo(file);
            WorldInfo worldinfo1 = world.func_22144_v();
            worldinfo1.func_22297_b(worldinfo1.func_22306_g() + file.length());
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void func_818_a(Chunk chunk, World world, NBTTagCompound nbttagcompound)
    {
        world.func_663_l();
        nbttagcompound.func_758_a("xPos", chunk.field_1531_j);
        nbttagcompound.func_758_a("zPos", chunk.field_1530_k);
        nbttagcompound.func_750_a("LastUpdate", world.func_22139_r());
        nbttagcompound.func_747_a("Blocks", chunk.field_1539_b);
        nbttagcompound.func_747_a("Data", chunk.field_1536_e.field_1109_a);
        nbttagcompound.func_747_a("SkyLight", chunk.field_1535_f.field_1109_a);
        nbttagcompound.func_747_a("BlockLight", chunk.field_1534_g.field_1109_a);
        nbttagcompound.func_747_a("HeightMap", chunk.field_1533_h);
        nbttagcompound.func_748_a("TerrainPopulated", chunk.field_1527_n);
        chunk.field_1523_r = false;
        NBTTagList nbttaglist = new NBTTagList();
label0:
        for(int i = 0; i < chunk.field_1528_m.length; i++)
        {
            Iterator iterator = chunk.field_1528_m[i].iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    continue label0;
                }
                Entity entity = (Entity)iterator.next();
                chunk.field_1523_r = true;
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                if(entity.func_358_c(nbttagcompound1))
                {
                    nbttaglist.func_742_a(nbttagcompound1);
                }
            } while(true);
        }

        nbttagcompound.func_762_a("Entities", nbttaglist);
        NBTTagList nbttaglist1 = new NBTTagList();
        NBTTagCompound nbttagcompound2;
        for(Iterator iterator1 = chunk.field_1529_l.values().iterator(); iterator1.hasNext(); nbttaglist1.func_742_a(nbttagcompound2))
        {
            TileEntity tileentity = (TileEntity)iterator1.next();
            nbttagcompound2 = new NBTTagCompound();
            tileentity.func_481_b(nbttagcompound2);
        }

        nbttagcompound.func_762_a("TileEntities", nbttaglist1);
        List list = world.func_41081_a(chunk, false);
        if(list != null)
        {
            long l = world.func_22139_r();
            NBTTagList nbttaglist2 = new NBTTagList();
            NBTTagCompound nbttagcompound3;
            for(Iterator iterator2 = list.iterator(); iterator2.hasNext(); nbttaglist2.func_742_a(nbttagcompound3))
            {
                NextTickListEntry nextticklistentry = (NextTickListEntry)iterator2.next();
                nbttagcompound3 = new NBTTagCompound();
                nbttagcompound3.func_758_a("i", nextticklistentry.field_1365_d);
                nbttagcompound3.func_758_a("x", nextticklistentry.field_1361_a);
                nbttagcompound3.func_758_a("y", nextticklistentry.field_1360_b);
                nbttagcompound3.func_758_a("z", nextticklistentry.field_1366_c);
                nbttagcompound3.func_758_a("t", (int)(nextticklistentry.field_1364_e - l));
            }

            nbttagcompound.func_762_a("TileTicks", nbttaglist2);
        }
    }

    public static Chunk func_816_a(World world, NBTTagCompound nbttagcompound)
    {
        int i = nbttagcompound.func_756_e("xPos");
        int j = nbttagcompound.func_756_e("zPos");
        Chunk chunk = new Chunk(world, i, j);
        chunk.field_1539_b = nbttagcompound.func_759_j("Blocks");
        chunk.field_1536_e = new NibbleArray(nbttagcompound.func_759_j("Data"), world.field_35473_a);
        chunk.field_1535_f = new NibbleArray(nbttagcompound.func_759_j("SkyLight"), world.field_35473_a);
        chunk.field_1534_g = new NibbleArray(nbttagcompound.func_759_j("BlockLight"), world.field_35473_a);
        chunk.field_1533_h = nbttagcompound.func_759_j("HeightMap");
        chunk.field_1527_n = nbttagcompound.func_760_m("TerrainPopulated");
        if(!chunk.field_1536_e.func_769_a())
        {
            chunk.field_1536_e = new NibbleArray(chunk.field_1539_b.length, world.field_35473_a);
        }
        if(chunk.field_1533_h == null || !chunk.field_1535_f.func_769_a())
        {
            chunk.field_1533_h = new byte[256];
            chunk.field_1535_f = new NibbleArray(chunk.field_1539_b.length, world.field_35473_a);
            chunk.func_1024_c();
        }
        if(!chunk.field_1534_g.func_769_a())
        {
            chunk.field_1534_g = new NibbleArray(chunk.field_1539_b.length, world.field_35473_a);
            chunk.func_1014_a();
        }
        NBTTagList nbttaglist = nbttagcompound.func_753_l("Entities");
        if(nbttaglist != null)
        {
            for(int k = 0; k < nbttaglist.func_740_c(); k++)
            {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.func_741_a(k);
                Entity entity = EntityList.func_1081_a(nbttagcompound1, world);
                chunk.field_1523_r = true;
                if(entity != null)
                {
                    chunk.func_1000_a(entity);
                }
            }

        }
        NBTTagList nbttaglist1 = nbttagcompound.func_753_l("TileEntities");
        if(nbttaglist1 != null)
        {
            for(int l = 0; l < nbttaglist1.func_740_c(); l++)
            {
                NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist1.func_741_a(l);
                TileEntity tileentity = TileEntity.func_477_c(nbttagcompound2);
                if(tileentity != null)
                {
                    chunk.func_1001_a(tileentity);
                }
            }

        }
        if(nbttagcompound.func_751_b("TileTicks"))
        {
            NBTTagList nbttaglist2 = nbttagcompound.func_753_l("TileTicks");
            if(nbttaglist2 != null)
            {
                for(int i1 = 0; i1 < nbttaglist2.func_740_c(); i1++)
                {
                    NBTTagCompound nbttagcompound3 = (NBTTagCompound)nbttaglist2.func_741_a(i1);
                    world.func_41083_e(nbttagcompound3.func_756_e("x"), nbttagcompound3.func_756_e("y"), nbttagcompound3.func_756_e("z"), nbttagcompound3.func_756_e("i"), nbttagcompound3.func_756_e("t"));
                }

            }
        }
        return chunk;
    }

    public void func_814_a()
    {
    }

    public void func_811_b()
    {
    }

    public void func_815_b(World world, Chunk chunk)
        throws IOException
    {
    }
}
