// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            LayerIsland, GenLayerZoomFuzzy, GenLayerIsland, GenLayerZoom, 
//            GenLayerSnow, GenLayerMushroomIsland, GenLayerRiverInit, GenLayerRiver, 
//            GenLayerSmooth, GenLayerVillageLandscape, GenLayerHills, GenLayerTemperature, 
//            GenLayerDownfall, GenLayerShore, GenLayerSwampRivers, GenLayerSmoothZoom, 
//            GenLayerTemperatureMix, GenLayerDownfallMix, GenLayerRiverMix, GenLayerZoomVoronoi

public abstract class GenLayer
{

    private long field_35502_b;
    protected GenLayer field_35504_a;
    private long field_35503_c;
    private long field_35501_d;

    public static GenLayer[] func_35497_a(long l)
    {
        Object obj = new LayerIsland(1L);
        obj = new GenLayerZoomFuzzy(2000L, ((GenLayer) (obj)));
        obj = new GenLayerIsland(1L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2001L, ((GenLayer) (obj)));
        obj = new GenLayerIsland(2L, ((GenLayer) (obj)));
        obj = new GenLayerSnow(2L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2002L, ((GenLayer) (obj)));
        obj = new GenLayerIsland(3L, ((GenLayer) (obj)));
        obj = new GenLayerZoom(2003L, ((GenLayer) (obj)));
        obj = new GenLayerIsland(4L, ((GenLayer) (obj)));
        obj = new GenLayerMushroomIsland(5L, ((GenLayer) (obj)));
        byte byte0 = 4;
        Object obj1 = obj;
        obj1 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj1)), 0);
        obj1 = new GenLayerRiverInit(100L, ((GenLayer) (obj1)));
        obj1 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj1)), byte0 + 2);
        obj1 = new GenLayerRiver(1L, ((GenLayer) (obj1)));
        obj1 = new GenLayerSmooth(1000L, ((GenLayer) (obj1)));
        Object obj2 = obj;
        obj2 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj2)), 0);
        obj2 = new GenLayerVillageLandscape(200L, ((GenLayer) (obj2)));
        obj2 = GenLayerZoom.func_35515_a(1000L, ((GenLayer) (obj2)), 2);
        obj2 = new GenLayerHills(1000L, ((GenLayer) (obj2)));
        Object obj3 = new GenLayerTemperature(((GenLayer) (obj2)));
        Object obj4 = new GenLayerDownfall(((GenLayer) (obj2)));
        for(int i = 0; i < byte0; i++)
        {
            obj2 = new GenLayerZoom(1000 + i, ((GenLayer) (obj2)));
            if(i == 0)
            {
                obj2 = new GenLayerIsland(3L, ((GenLayer) (obj2)));
            }
            if(i == 1)
            {
                obj2 = new GenLayerShore(1000L, ((GenLayer) (obj2)));
            }
            if(i == 1)
            {
                obj2 = new GenLayerSwampRivers(1000L, ((GenLayer) (obj2)));
            }
            obj3 = new GenLayerSmoothZoom(1000 + i, ((GenLayer) (obj3)));
            obj3 = new GenLayerTemperatureMix(((GenLayer) (obj3)), ((GenLayer) (obj2)), i);
            obj4 = new GenLayerSmoothZoom(1000 + i, ((GenLayer) (obj4)));
            obj4 = new GenLayerDownfallMix(((GenLayer) (obj4)), ((GenLayer) (obj2)), i);
        }

        obj2 = new GenLayerSmooth(1000L, ((GenLayer) (obj2)));
        obj2 = new GenLayerRiverMix(100L, ((GenLayer) (obj2)), ((GenLayer) (obj1)));
        GenLayerRiverMix genlayerrivermix = ((GenLayerRiverMix) (obj2));
        obj3 = GenLayerSmoothZoom.func_35517_a(1000L, ((GenLayer) (obj3)), 2);
        obj4 = GenLayerSmoothZoom.func_35517_a(1000L, ((GenLayer) (obj4)), 2);
        GenLayerZoomVoronoi genlayerzoomvoronoi = new GenLayerZoomVoronoi(10L, ((GenLayer) (obj2)));
        ((GenLayer) (obj2)).func_35496_b(l);
        ((GenLayer) (obj3)).func_35496_b(l);
        ((GenLayer) (obj4)).func_35496_b(l);
        genlayerzoomvoronoi.func_35496_b(l);
        return (new GenLayer[] {
            obj2, genlayerzoomvoronoi, obj3, obj4, genlayerrivermix
        });
    }

    public GenLayer(long l)
    {
        field_35501_d = l;
        field_35501_d *= field_35501_d * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35501_d += l;
        field_35501_d *= field_35501_d * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35501_d += l;
        field_35501_d *= field_35501_d * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35501_d += l;
    }

    public void func_35496_b(long l)
    {
        field_35502_b = l;
        if(field_35504_a != null)
        {
            field_35504_a.func_35496_b(l);
        }
        field_35502_b *= field_35502_b * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35502_b += field_35501_d;
        field_35502_b *= field_35502_b * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35502_b += field_35501_d;
        field_35502_b *= field_35502_b * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35502_b += field_35501_d;
    }

    public void func_35499_a(long l, long l1)
    {
        field_35503_c = field_35502_b;
        field_35503_c *= field_35503_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35503_c += l;
        field_35503_c *= field_35503_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35503_c += l1;
        field_35503_c *= field_35503_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35503_c += l;
        field_35503_c *= field_35503_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35503_c += l1;
    }

    protected int func_35498_a(int i)
    {
        int j = (int)((field_35503_c >> 24) % (long)i);
        if(j < 0)
        {
            j += i;
        }
        field_35503_c *= field_35503_c * 0x5851f42d4c957f2dL + 0x14057b7ef767814fL;
        field_35503_c += field_35502_b;
        return j;
    }

    public abstract int[] func_35500_a(int i, int j, int k, int l);
}
