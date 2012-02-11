// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, BiomeGenBase, ChunkCoordIntPair, World, 
//            WorldChunkManager, ChunkPosition, StructureStrongholdStart, ComponentStrongholdStairs2, 
//            StructureStart

public class MapGenStronghold extends MapGenStructure
{

    private BiomeGenBase field_35634_a[];
    private boolean field_35632_f;
    private ChunkCoordIntPair field_35633_g[];

    public MapGenStronghold()
    {
        field_35634_a = (new BiomeGenBase[] {
            BiomeGenBase.field_4249_h, BiomeGenBase.field_4253_d, BiomeGenBase.field_35483_e, BiomeGenBase.field_4255_b, BiomeGenBase.field_4250_g, BiomeGenBase.field_40257_n, BiomeGenBase.field_40258_o, BiomeGenBase.field_46049_s, BiomeGenBase.field_46048_t, BiomeGenBase.field_46046_v
        });
        field_35633_g = new ChunkCoordIntPair[3];
    }

    protected boolean func_35628_a(int i, int j)
    {
        if(!field_35632_f)
        {
            Random random = new Random();
            random.setSeed(field_35625_d.func_22138_q());
            double d = random.nextDouble() * 3.1415926535897931D * 2D;
            for(int i1 = 0; i1 < field_35633_g.length; i1++)
            {
                double d1 = (1.25D + random.nextDouble()) * 32D;
                int j1 = (int)Math.round(Math.cos(d) * d1);
                int k1 = (int)Math.round(Math.sin(d) * d1);
                ArrayList arraylist = new ArrayList();
                BiomeGenBase abiomegenbase[] = field_35634_a;
                int l1 = abiomegenbase.length;
                for(int i2 = 0; i2 < l1; i2++)
                {
                    BiomeGenBase biomegenbase = abiomegenbase[i2];
                    arraylist.add(biomegenbase);
                }

                ChunkPosition chunkposition = field_35625_d.func_4075_a().func_35556_a((j1 << 4) + 8, (k1 << 4) + 8, 112, arraylist, random);
                if(chunkposition != null)
                {
                    j1 = chunkposition.field_1111_a >> 4;
                    k1 = chunkposition.field_1112_c >> 4;
                } else
                {
                    System.out.println((new StringBuilder()).append("Placed stronghold in INVALID biome at (").append(j1).append(", ").append(k1).append(")").toString());
                }
                field_35633_g[i1] = new ChunkCoordIntPair(j1, k1);
                d += 6.2831853071795862D / (double)field_35633_g.length;
            }

            field_35632_f = true;
        }
        ChunkCoordIntPair achunkcoordintpair[] = field_35633_g;
        int k = achunkcoordintpair.length;
        for(int l = 0; l < k; l++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[l];
            if(i == chunkcoordintpair.field_189_a && j == chunkcoordintpair.field_188_b)
            {
                System.out.println((new StringBuilder()).append(i).append(", ").append(j).toString());
                return true;
            }
        }

        return false;
    }

    protected List func_40482_a()
    {
        ArrayList arraylist = new ArrayList();
        ChunkCoordIntPair achunkcoordintpair[] = field_35633_g;
        int i = achunkcoordintpair.length;
        for(int j = 0; j < i; j++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[j];
            if(chunkcoordintpair != null)
            {
                arraylist.add(chunkcoordintpair.func_40737_a(64));
            }
        }

        return arraylist;
    }

    protected StructureStart func_35630_b(int i, int j)
    {
        StructureStrongholdStart structurestrongholdstart;
        for(structurestrongholdstart = new StructureStrongholdStart(field_35625_d, field_1305_b, i, j); structurestrongholdstart.func_40560_b().isEmpty() || ((ComponentStrongholdStairs2)structurestrongholdstart.func_40560_b().get(0)).field_40009_b == null; structurestrongholdstart = new StructureStrongholdStart(field_35625_d, field_1305_b, i, j)) { }
        return structurestrongholdstart;
    }
}
