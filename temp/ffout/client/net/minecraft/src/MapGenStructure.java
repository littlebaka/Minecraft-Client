// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenBase, ChunkCoordIntPair, StructureStart, StructureBoundingBox, 
//            StructureComponent, World, ChunkPosition, IChunkProvider

public abstract class MapGenStructure extends MapGenBase
{

    protected HashMap field_35631_e;

    public MapGenStructure()
    {
        field_35631_e = new HashMap();
    }

    public void func_867_a(IChunkProvider ichunkprovider, World world, int i, int j, byte abyte0[])
    {
        super.func_867_a(ichunkprovider, world, i, j, abyte0);
    }

    protected void func_868_a(World world, int i, int j, int k, int l, byte abyte0[])
    {
        if(field_35631_e.containsKey(Long.valueOf(ChunkCoordIntPair.func_22011_a(i, j))))
        {
            return;
        }
        int i1 = field_1305_b.nextInt();
        if(func_35628_a(i, j))
        {
            StructureStart structurestart = func_35630_b(i, j);
            field_35631_e.put(Long.valueOf(ChunkCoordIntPair.func_22011_a(i, j)), structurestart);
        }
    }

    public boolean func_35629_a(World world, Random random, int i, int j)
    {
        int k = (i << 4) + 8;
        int l = (j << 4) + 8;
        boolean flag = false;
        Iterator iterator = field_35631_e.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureStart structurestart = (StructureStart)iterator.next();
            if(structurestart.func_35715_c() && structurestart.func_35712_a().func_35746_a(k, l, k + 15, l + 15))
            {
                structurestart.func_35711_a(world, random, new StructureBoundingBox(k, l, k + 15, l + 15));
                flag = true;
            }
        } while(true);
        return flag;
    }

    public boolean func_40483_a(int i, int j, int k)
    {
        Iterator iterator = field_35631_e.values().iterator();
label0:
        do
        {
            if(iterator.hasNext())
            {
                StructureStart structurestart = (StructureStart)iterator.next();
                if(!structurestart.func_35715_c() || !structurestart.func_35712_a().func_35746_a(i, k, i, k))
                {
                    continue;
                }
                Iterator iterator1 = structurestart.func_40560_b().iterator();
                StructureComponent structurecomponent;
                do
                {
                    if(!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    structurecomponent = (StructureComponent)iterator1.next();
                } while(!structurecomponent.func_35021_b().func_35742_b(i, j, k));
                break;
            } else
            {
                return false;
            }
        } while(true);
        return true;
    }

    public ChunkPosition func_40484_a(World world, int i, int j, int k)
    {
        field_35625_d = world;
        field_1305_b.setSeed(world.func_22138_q());
        long l = field_1305_b.nextLong();
        long l1 = field_1305_b.nextLong();
        long l2 = (long)(i >> 4) * l;
        long l3 = (long)(k >> 4) * l1;
        field_1305_b.setSeed(l2 ^ l3 ^ world.func_22138_q());
        func_868_a(world, i >> 4, k >> 4, 0, 0, null);
        double d = 1.7976931348623157E+308D;
        ChunkPosition chunkposition = null;
        Object obj = field_35631_e.values().iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
            {
                break;
            }
            StructureStart structurestart = (StructureStart)((Iterator) (obj)).next();
            if(structurestart.func_35715_c())
            {
                StructureComponent structurecomponent = (StructureComponent)structurestart.func_40560_b().get(0);
                ChunkPosition chunkposition2 = structurecomponent.func_40008_a_();
                int i1 = chunkposition2.field_1111_a - i;
                int k1 = chunkposition2.field_1110_b - j;
                int j2 = chunkposition2.field_1112_c - k;
                double d1 = i1 + i1 * k1 * k1 + j2 * j2;
                if(d1 < d)
                {
                    d = d1;
                    chunkposition = chunkposition2;
                }
            }
        } while(true);
        if(chunkposition != null)
        {
            return chunkposition;
        }
        obj = func_40482_a();
        if(obj != null)
        {
            ChunkPosition chunkposition1 = null;
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                ChunkPosition chunkposition3 = (ChunkPosition)iterator.next();
                int j1 = chunkposition3.field_1111_a - i;
                int i2 = chunkposition3.field_1110_b - j;
                int k2 = chunkposition3.field_1112_c - k;
                double d2 = j1 + j1 * i2 * i2 + k2 * k2;
                if(d2 < d)
                {
                    d = d2;
                    chunkposition1 = chunkposition3;
                }
            } while(true);
            return chunkposition1;
        } else
        {
            return null;
        }
    }

    protected List func_40482_a()
    {
        return null;
    }

    protected abstract boolean func_35628_a(int i, int j);

    protected abstract StructureStart func_35630_b(int i, int j);
}
