// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PathPoint

public class Path
{

    private PathPoint field_1556_a[];
    private int field_1555_b;

    public Path()
    {
        field_1556_a = new PathPoint[1024];
        field_1555_b = 0;
    }

    public PathPoint func_1034_a(PathPoint pathpoint)
    {
        if(pathpoint.field_1714_e >= 0)
        {
            throw new IllegalStateException("OW KNOWS!");
        }
        if(field_1555_b == field_1556_a.length)
        {
            PathPoint apathpoint[] = new PathPoint[field_1555_b << 1];
            System.arraycopy(field_1556_a, 0, apathpoint, 0, field_1555_b);
            field_1556_a = apathpoint;
        }
        field_1556_a[field_1555_b] = pathpoint;
        pathpoint.field_1714_e = field_1555_b;
        func_1033_a(field_1555_b++);
        return pathpoint;
    }

    public void func_1038_a()
    {
        field_1555_b = 0;
    }

    public PathPoint func_1036_b()
    {
        PathPoint pathpoint = field_1556_a[0];
        field_1556_a[0] = field_1556_a[--field_1555_b];
        field_1556_a[field_1555_b] = null;
        if(field_1555_b > 0)
        {
            func_1037_b(0);
        }
        pathpoint.field_1714_e = -1;
        return pathpoint;
    }

    public void func_1035_a(PathPoint pathpoint, float f)
    {
        float f1 = pathpoint.field_1711_h;
        pathpoint.field_1711_h = f;
        if(f < f1)
        {
            func_1033_a(pathpoint.field_1714_e);
        } else
        {
            func_1037_b(pathpoint.field_1714_e);
        }
    }

    private void func_1033_a(int i)
    {
        PathPoint pathpoint = field_1556_a[i];
        float f = pathpoint.field_1711_h;
        do
        {
            if(i <= 0)
            {
                break;
            }
            int j = i - 1 >> 1;
            PathPoint pathpoint1 = field_1556_a[j];
            if(f >= pathpoint1.field_1711_h)
            {
                break;
            }
            field_1556_a[i] = pathpoint1;
            pathpoint1.field_1714_e = i;
            i = j;
        } while(true);
        field_1556_a[i] = pathpoint;
        pathpoint.field_1714_e = i;
    }

    private void func_1037_b(int i)
    {
        PathPoint pathpoint = field_1556_a[i];
        float f = pathpoint.field_1711_h;
        do
        {
            int j = 1 + (i << 1);
            int k = j + 1;
            if(j >= field_1555_b)
            {
                break;
            }
            PathPoint pathpoint1 = field_1556_a[j];
            float f1 = pathpoint1.field_1711_h;
            PathPoint pathpoint2;
            float f2;
            if(k >= field_1555_b)
            {
                pathpoint2 = null;
                f2 = (1.0F / 0.0F);
            } else
            {
                pathpoint2 = field_1556_a[k];
                f2 = pathpoint2.field_1711_h;
            }
            if(f1 < f2)
            {
                if(f1 >= f)
                {
                    break;
                }
                field_1556_a[i] = pathpoint1;
                pathpoint1.field_1714_e = i;
                i = j;
                continue;
            }
            if(f2 >= f)
            {
                break;
            }
            field_1556_a[i] = pathpoint2;
            pathpoint2.field_1714_e = i;
            i = k;
        } while(true);
        field_1556_a[i] = pathpoint;
        pathpoint.field_1714_e = i;
    }

    public boolean func_1039_c()
    {
        return field_1555_b == 0;
    }
}
