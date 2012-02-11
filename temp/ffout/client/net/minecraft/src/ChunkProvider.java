// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, LongHashMap, EmptyChunk, World, 
//            ChunkCoordIntPair, ChunkCoordinates, Chunk, IChunkLoader, 
//            IProgressUpdate, EnumCreatureType, ChunkPosition

public class ChunkProvider
    implements IChunkProvider
{

    private Set field_28065_a;
    private Chunk field_28064_b;
    private IChunkProvider field_28070_c;
    private IChunkLoader field_28069_d;
    private LongHashMap field_28068_e;
    private List field_28067_f;
    private World field_28066_g;
    private int field_35392_h;

    public ChunkProvider(World world, IChunkLoader ichunkloader, IChunkProvider ichunkprovider)
    {
        field_28065_a = new HashSet();
        field_28068_e = new LongHashMap();
        field_28067_f = new ArrayList();
        field_28064_b = new EmptyChunk(world, new byte[256 * world.field_35472_c], 0, 0);
        field_28066_g = world;
        field_28069_d = ichunkloader;
        field_28070_c = ichunkprovider;
    }

    public boolean func_537_a(int i, int j)
    {
        return field_28068_e.func_35575_b(ChunkCoordIntPair.func_22011_a(i, j));
    }

    public void func_35391_d(int i, int j)
    {
        ChunkCoordinates chunkcoordinates = field_28066_g.func_22137_s();
        int k = (i * 16 + 8) - chunkcoordinates.field_22395_a;
        int l = (j * 16 + 8) - chunkcoordinates.field_22396_c;
        char c = '\200';
        if(k < -c || k > c || l < -c || l > c)
        {
            field_28065_a.add(Long.valueOf(ChunkCoordIntPair.func_22011_a(i, j)));
        }
    }

    public Chunk func_538_d(int i, int j)
    {
        long l = ChunkCoordIntPair.func_22011_a(i, j);
        field_28065_a.remove(Long.valueOf(l));
        Chunk chunk = (Chunk)field_28068_e.func_35578_a(l);
        if(chunk == null)
        {
            int k = 0x1c9c3c;
            if(i < -k || j < -k || i >= k || j >= k)
            {
                return field_28064_b;
            }
            chunk = func_28061_d(i, j);
            if(chunk == null)
            {
                if(field_28070_c == null)
                {
                    chunk = field_28064_b;
                } else
                {
                    chunk = field_28070_c.func_533_b(i, j);
                }
            }
            field_28068_e.func_35577_a(l, chunk);
            field_28067_f.add(chunk);
            if(chunk != null)
            {
                chunk.func_4143_d();
                chunk.func_995_d();
            }
            chunk.func_35843_a(this, this, i, j);
        }
        return chunk;
    }

    public Chunk func_533_b(int i, int j)
    {
        Chunk chunk = (Chunk)field_28068_e.func_35578_a(ChunkCoordIntPair.func_22011_a(i, j));
        if(chunk == null)
        {
            return func_538_d(i, j);
        } else
        {
            return chunk;
        }
    }

    private Chunk func_28061_d(int i, int j)
    {
        if(field_28069_d == null)
        {
            return null;
        }
        try
        {
            Chunk chunk = field_28069_d.func_813_a(field_28066_g, i, j);
            if(chunk != null)
            {
                chunk.field_1522_s = field_28066_g.func_22139_r();
            }
            return chunk;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    private void func_28063_a(Chunk chunk)
    {
        if(field_28069_d == null)
        {
            return;
        }
        try
        {
            field_28069_d.func_815_b(field_28066_g, chunk);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_28062_b(Chunk chunk)
    {
        if(field_28069_d == null)
        {
            return;
        }
        try
        {
            chunk.field_1522_s = field_28066_g.func_22139_r();
            field_28069_d.func_812_a(field_28066_g, chunk);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void func_534_a(IChunkProvider ichunkprovider, int i, int j)
    {
        Chunk chunk = func_533_b(i, j);
        if(!chunk.field_1527_n)
        {
            chunk.field_1527_n = true;
            if(field_28070_c != null)
            {
                field_28070_c.func_534_a(ichunkprovider, i, j);
                chunk.func_1006_f();
            }
        }
    }

    public boolean func_535_a(boolean flag, IProgressUpdate iprogressupdate)
    {
        int i = 0;
        for(int j = 0; j < field_28067_f.size(); j++)
        {
            Chunk chunk = (Chunk)field_28067_f.get(j);
            if(flag && !chunk.field_1525_p)
            {
                func_28063_a(chunk);
            }
            if(!chunk.func_1012_a(flag))
            {
                continue;
            }
            func_28062_b(chunk);
            chunk.field_1526_o = false;
            if(++i == 24 && !flag)
            {
                return false;
            }
        }

        if(flag)
        {
            if(field_28069_d == null)
            {
                return true;
            }
            field_28069_d.func_811_b();
        }
        return true;
    }

    public boolean func_532_a()
    {
        for(int i = 0; i < 100; i++)
        {
            if(!field_28065_a.isEmpty())
            {
                Long long1 = (Long)field_28065_a.iterator().next();
                Chunk chunk1 = (Chunk)field_28068_e.func_35578_a(long1.longValue());
                chunk1.func_998_e();
                func_28062_b(chunk1);
                func_28063_a(chunk1);
                field_28065_a.remove(long1);
                field_28068_e.func_35574_d(long1.longValue());
                field_28067_f.remove(chunk1);
            }
        }

        for(int j = 0; j < 10; j++)
        {
            if(field_35392_h >= field_28067_f.size())
            {
                field_35392_h = 0;
                break;
            }
            Chunk chunk = (Chunk)field_28067_f.get(field_35392_h++);
            EntityPlayer entityplayer = field_28066_g.func_683_a((double)(chunk.field_1531_j << 4) + 8D, 64D, (double)(chunk.field_1530_k << 4) + 8D, 288D);
            if(entityplayer == null)
            {
                func_35391_d(chunk.field_1531_j, chunk.field_1530_k);
            }
        }

        if(field_28069_d != null)
        {
            field_28069_d.func_814_a();
        }
        return field_28070_c.func_532_a();
    }

    public boolean func_536_b()
    {
        return true;
    }

    public String func_21109_c()
    {
        return (new StringBuilder()).append("ServerChunkCache: ").append(field_28068_e.func_35576_a()).append(" Drop: ").append(field_28065_a.size()).toString();
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        return field_28070_c.func_40377_a(enumcreaturetype, i, j, k);
    }

    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
    {
        return field_28070_c.func_40376_a(world, s, i, j, k);
    }
}
