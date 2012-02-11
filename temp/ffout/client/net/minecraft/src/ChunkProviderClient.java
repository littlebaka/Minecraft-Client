// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, LongHashMap, EmptyChunk, World, 
//            ChunkCoordIntPair, Chunk, NibbleArray, IProgressUpdate, 
//            EnumCreatureType, ChunkPosition

public class ChunkProviderClient
    implements IChunkProvider
{

    private Chunk field_887_a;
    private LongHashMap field_886_b;
    private List field_889_c;
    private World field_888_d;

    public ChunkProviderClient(World world)
    {
        field_886_b = new LongHashMap();
        field_889_c = new ArrayList();
        field_887_a = new EmptyChunk(world, new byte[256 * world.field_35472_c], 0, 0);
        field_888_d = world;
    }

    public boolean func_537_a(int i, int j)
    {
        if(this != null)
        {
            return true;
        } else
        {
            return field_886_b.func_35575_b(ChunkCoordIntPair.func_22011_a(i, j));
        }
    }

    public void func_539_c(int i, int j)
    {
        Chunk chunk = func_533_b(i, j);
        if(!chunk.func_21167_h())
        {
            chunk.func_998_e();
        }
        field_886_b.func_35574_d(ChunkCoordIntPair.func_22011_a(i, j));
        field_889_c.remove(chunk);
    }

    public Chunk func_538_d(int i, int j)
    {
        byte abyte0[] = new byte[256 * field_888_d.field_35472_c];
        Chunk chunk = new Chunk(field_888_d, abyte0, i, j);
        Arrays.fill(chunk.field_1535_f.field_1109_a, (byte)-1);
        field_886_b.func_35577_a(ChunkCoordIntPair.func_22011_a(i, j), chunk);
        chunk.field_1538_c = true;
        return chunk;
    }

    public Chunk func_533_b(int i, int j)
    {
        Chunk chunk = (Chunk)field_886_b.func_35578_a(ChunkCoordIntPair.func_22011_a(i, j));
        if(chunk == null)
        {
            return field_887_a;
        } else
        {
            return chunk;
        }
    }

    public boolean func_535_a(boolean flag, IProgressUpdate iprogressupdate)
    {
        return true;
    }

    public boolean func_532_a()
    {
        return false;
    }

    public boolean func_536_b()
    {
        return false;
    }

    public void func_534_a(IChunkProvider ichunkprovider, int i, int j)
    {
    }

    public String func_21109_c()
    {
        return (new StringBuilder()).append("MultiplayerChunkCache: ").append(field_886_b.func_35576_a()).toString();
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        return null;
    }

    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
    {
        return null;
    }
}
