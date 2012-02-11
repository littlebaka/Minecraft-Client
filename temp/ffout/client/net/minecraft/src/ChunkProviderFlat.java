// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenVillage, Block, BlockGrass, 
//            World, Chunk, ChunkCoordIntPair, WorldChunkManager, 
//            BiomeGenBase, IProgressUpdate, EnumCreatureType, ChunkPosition

public class ChunkProviderFlat
    implements IChunkProvider
{

    private World field_46055_a;
    private Random field_46053_b;
    private final boolean field_46054_c;
    private MapGenVillage field_46052_d;

    public ChunkProviderFlat(World world, long l, boolean flag)
    {
        field_46052_d = new MapGenVillage(1);
        field_46055_a = world;
        field_46054_c = flag;
        field_46053_b = new Random(l);
    }

    private void func_46051_a(byte abyte0[])
    {
        int i = abyte0.length / 256;
        for(int j = 0; j < 16; j++)
        {
            for(int k = 0; k < 16; k++)
            {
                for(int l = 0; l < i; l++)
                {
                    int i1 = 0;
                    if(l == 0)
                    {
                        i1 = Block.field_403_A.field_376_bc;
                    } else
                    if(l <= 2)
                    {
                        i1 = Block.field_336_w.field_376_bc;
                    } else
                    if(l == 3)
                    {
                        i1 = Block.field_337_v.field_376_bc;
                    }
                    abyte0[j << 11 | k << 7 | l] = (byte)i1;
                }

            }

        }

    }

    public Chunk func_538_d(int i, int j)
    {
        return func_533_b(i, j);
    }

    public Chunk func_533_b(int i, int j)
    {
        byte abyte0[] = new byte[16 * field_46055_a.field_35472_c * 16];
        Chunk chunk = new Chunk(field_46055_a, abyte0, i, j);
        func_46051_a(abyte0);
        if(field_46054_c)
        {
            field_46052_d.func_867_a(this, field_46055_a, i, j, abyte0);
        }
        chunk.func_1024_c();
        return chunk;
    }

    public boolean func_537_a(int i, int j)
    {
        return true;
    }

    public void func_534_a(IChunkProvider ichunkprovider, int i, int j)
    {
        field_46053_b.setSeed(field_46055_a.func_22138_q());
        long l = (field_46053_b.nextLong() / 2L) * 2L + 1L;
        long l1 = (field_46053_b.nextLong() / 2L) * 2L + 1L;
        field_46053_b.setSeed((long)i * l + (long)j * l1 ^ field_46055_a.func_22138_q());
        if(field_46054_c)
        {
            field_46052_d.func_35629_a(field_46055_a, field_46053_b, i, j);
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
        return true;
    }

    public String func_21109_c()
    {
        return "FlatLevelSource";
    }

    public List func_40377_a(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        WorldChunkManager worldchunkmanager = field_46055_a.func_4075_a();
        if(worldchunkmanager == null)
        {
            return null;
        }
        BiomeGenBase biomegenbase = worldchunkmanager.func_4074_a(new ChunkCoordIntPair(i >> 4, k >> 4));
        if(biomegenbase == null)
        {
            return null;
        } else
        {
            return biomegenbase.func_25063_a(enumcreaturetype);
        }
    }

    public ChunkPosition func_40376_a(World world, String s, int i, int j, int k)
    {
        return null;
    }
}
