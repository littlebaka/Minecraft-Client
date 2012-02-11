// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerSwampRivers extends GenLayer
{

    public GenLayerSwampRivers(long l, GenLayer genlayer)
    {
        super(l);
        field_35504_a = genlayer;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = field_35504_a.func_35500_a(i - 1, j - 1, k + 2, l + 2);
        int ai1[] = IntCache.func_35267_a(k * l);
        for(int i1 = 0; i1 < l; i1++)
        {
            for(int j1 = 0; j1 < k; j1++)
            {
                func_35499_a(j1 + i, i1 + j);
                int k1 = ai[j1 + 1 + (i1 + 1) * (k + 2)];
                if(k1 == BiomeGenBase.field_4255_b.field_35494_y && func_35498_a(6) == 0)
                {
                    ai1[j1 + i1 * k] = BiomeGenBase.field_35487_i.field_35494_y;
                } else
                {
                    ai1[j1 + i1 * k] = k1;
                }
            }

        }

        return ai1;
    }
}
