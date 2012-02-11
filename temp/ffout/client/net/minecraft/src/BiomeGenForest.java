// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, SpawnListEntry, EntityWolf, BiomeDecorator, 
//            WorldGenerator

public class BiomeGenForest extends BiomeGenBase
{

    public BiomeGenForest(int i)
    {
        super(i);
        field_25065_s.add(new SpawnListEntry(net.minecraft.src.EntityWolf.class, 5, 4, 4));
        field_35488_u.field_35911_r = 10;
        field_35488_u.field_35909_t = 2;
    }

    public WorldGenerator func_21107_a(Random random)
    {
        if(random.nextInt(5) == 0)
        {
            return field_35481_B;
        }
        if(random.nextInt(10) == 0)
        {
            return field_35480_A;
        } else
        {
            return field_35493_z;
        }
    }
}
