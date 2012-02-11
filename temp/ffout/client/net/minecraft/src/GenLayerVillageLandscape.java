// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, BiomeGenBase, IntCache

public class GenLayerVillageLandscape extends GenLayer
{

    private BiomeGenBase field_35509_b[];

    public GenLayerVillageLandscape(long l, GenLayer genlayer)
    {
        super(l);
        field_35509_b = (new BiomeGenBase[] {
            BiomeGenBase.field_4249_h, BiomeGenBase.field_4253_d, BiomeGenBase.field_35483_e, BiomeGenBase.field_4255_b, BiomeGenBase.field_35485_c, BiomeGenBase.field_4250_g
        });
        field_35504_a = genlayer;
    }

    public int[] func_35500_a(int i, int j, int k, int l)
    {
        int ai[] = field_35504_a.func_35500_a(i, j, k, l);
        int ai1[] = IntCache.func_35267_a(k * l);
        for(int i1 = 0; i1 < l; i1++)
        {
            for(int j1 = 0; j1 < k; j1++)
            {
                func_35499_a(j1 + i, i1 + j);
                int k1 = ai[j1 + i1 * k];
                if(k1 == 0)
                {
                    ai1[j1 + i1 * k] = 0;
                    continue;
                }
                if(k1 == BiomeGenBase.field_40262_p.field_35494_y)
                {
                    ai1[j1 + i1 * k] = k1;
                    continue;
                }
                if(k1 == 1)
                {
                    ai1[j1 + i1 * k] = field_35509_b[func_35498_a(field_35509_b.length)].field_35494_y;
                } else
                {
                    ai1[j1 + i1 * k] = BiomeGenBase.field_40257_n.field_35494_y;
                }
            }

        }

        return ai1;
    }
}
