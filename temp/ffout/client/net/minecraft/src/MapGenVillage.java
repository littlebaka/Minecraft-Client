// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, World, WorldChunkManager, StructureVillageStart, 
//            BiomeGenBase, StructureStart

public class MapGenVillage extends MapGenStructure
{

    public static List field_35635_a;
    private final int field_46060_f;

    public MapGenVillage(int i)
    {
        field_46060_f = i;
    }

    protected boolean func_35628_a(int i, int j)
    {
        byte byte0 = 32;
        byte byte1 = 8;
        int k = i;
        int l = j;
        if(i < 0)
        {
            i -= byte0 - 1;
        }
        if(j < 0)
        {
            j -= byte0 - 1;
        }
        int i1 = i / byte0;
        int j1 = j / byte0;
        Random random = field_35625_d.func_35462_u(i1, j1, 0x9e7f70);
        i1 *= byte0;
        j1 *= byte0;
        i1 += random.nextInt(byte0 - byte1);
        j1 += random.nextInt(byte0 - byte1);
        i = k;
        j = l;
        if(i == i1 && j == j1)
        {
            boolean flag = field_35625_d.func_4075_a().func_35562_a(i * 16 + 8, j * 16 + 8, 0, field_35635_a);
            if(flag)
            {
                return true;
            }
        }
        return false;
    }

    protected StructureStart func_35630_b(int i, int j)
    {
        return new StructureVillageStart(field_35625_d, field_1305_b, i, j, field_46060_f);
    }

    static 
    {
        field_35635_a = Arrays.asList(new BiomeGenBase[] {
            BiomeGenBase.field_35485_c, BiomeGenBase.field_4249_h
        });
    }
}
