// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerShore extends GenLayer
{

    public GenLayerShore(long l, GenLayer genlayer)
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
                if(k1 == BiomeGenBase.field_40262_p.field_35494_y)
                {
                    int l1 = ai[j1 + 1 + ((i1 + 1) - 1) * (k + 2)];
                    int k2 = ai[j1 + 1 + 1 + (i1 + 1) * (k + 2)];
                    int j3 = ai[((j1 + 1) - 1) + (i1 + 1) * (k + 2)];
                    int i4 = ai[j1 + 1 + (i1 + 1 + 1) * (k + 2)];
                    if(l1 == BiomeGenBase.field_35484_b.field_35494_y || k2 == BiomeGenBase.field_35484_b.field_35494_y || j3 == BiomeGenBase.field_35484_b.field_35494_y || i4 == BiomeGenBase.field_35484_b.field_35494_y)
                    {
                        ai1[j1 + i1 * k] = BiomeGenBase.field_40261_q.field_35494_y;
                    } else
                    {
                        ai1[j1 + i1 * k] = k1;
                    }
                    continue;
                }
                if(k1 != BiomeGenBase.field_35484_b.field_35494_y && k1 != BiomeGenBase.field_35487_i.field_35494_y && k1 != BiomeGenBase.field_4255_b.field_35494_y && k1 != BiomeGenBase.field_35483_e.field_35494_y)
                {
                    int i2 = ai[j1 + 1 + ((i1 + 1) - 1) * (k + 2)];
                    int l2 = ai[j1 + 1 + 1 + (i1 + 1) * (k + 2)];
                    int k3 = ai[((j1 + 1) - 1) + (i1 + 1) * (k + 2)];
                    int j4 = ai[j1 + 1 + (i1 + 1 + 1) * (k + 2)];
                    if(i2 == BiomeGenBase.field_35484_b.field_35494_y || l2 == BiomeGenBase.field_35484_b.field_35494_y || k3 == BiomeGenBase.field_35484_b.field_35494_y || j4 == BiomeGenBase.field_35484_b.field_35494_y)
                    {
                        ai1[j1 + i1 * k] = BiomeGenBase.field_46050_r.field_35494_y;
                    } else
                    {
                        ai1[j1 + i1 * k] = k1;
                    }
                    continue;
                }
                if(k1 == BiomeGenBase.field_35483_e.field_35494_y)
                {
                    int j2 = ai[j1 + 1 + ((i1 + 1) - 1) * (k + 2)];
                    int i3 = ai[j1 + 1 + 1 + (i1 + 1) * (k + 2)];
                    int l3 = ai[((j1 + 1) - 1) + (i1 + 1) * (k + 2)];
                    int k4 = ai[j1 + 1 + (i1 + 1 + 1) * (k + 2)];
                    if(j2 != BiomeGenBase.field_35483_e.field_35494_y || i3 != BiomeGenBase.field_35483_e.field_35494_y || l3 != BiomeGenBase.field_35483_e.field_35494_y || k4 != BiomeGenBase.field_35483_e.field_35494_y)
                    {
                        ai1[j1 + i1 * k] = BiomeGenBase.field_46046_v.field_35494_y;
                    } else
                    {
                        ai1[j1 + i1 * k] = k1;
                    }
                } else
                {
                    ai1[j1 + i1 * k] = k1;
                }
            }

        }

        return ai1;
    }
}
