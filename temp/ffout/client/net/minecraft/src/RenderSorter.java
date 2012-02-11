// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            WorldRenderer, EntityLiving

public class RenderSorter
    implements Comparator
{

    private EntityLiving field_4274_a;

    public RenderSorter(EntityLiving entityliving)
    {
        field_4274_a = entityliving;
    }

    public int func_993_a(WorldRenderer worldrenderer, WorldRenderer worldrenderer1)
    {
        boolean flag = worldrenderer.field_1749_o;
        boolean flag1 = worldrenderer1.field_1749_o;
        if(flag && !flag1)
        {
            return 1;
        }
        if(flag1 && !flag)
        {
            return -1;
        }
        double d = worldrenderer.func_1202_a(field_4274_a);
        double d1 = worldrenderer1.func_1202_a(field_4274_a);
        if(d < d1)
        {
            return 1;
        }
        if(d > d1)
        {
            return -1;
        } else
        {
            return worldrenderer.field_1735_w >= worldrenderer1.field_1735_w ? -1 : 1;
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return func_993_a((WorldRenderer)obj, (WorldRenderer)obj1);
    }
}
