// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MathHelper

public class PathPoint
{

    public final int field_1718_a;
    public final int field_1717_b;
    public final int field_1716_c;
    private final int field_1715_d;
    int field_1714_e;
    float field_1713_f;
    float field_1712_g;
    float field_1711_h;
    PathPoint field_1710_i;
    public boolean field_1709_j;

    public PathPoint(int i, int j, int k)
    {
        field_1714_e = -1;
        field_1709_j = false;
        field_1718_a = i;
        field_1717_b = j;
        field_1716_c = k;
        field_1715_d = func_22329_a(i, j, k);
    }

    public static int func_22329_a(int i, int j, int k)
    {
        return j & 0xff | (i & 0x7fff) << 8 | (k & 0x7fff) << 24 | (i >= 0 ? 0 : 0x80000000) | (k >= 0 ? 0 : 0x8000);
    }

    public float func_1180_a(PathPoint pathpoint)
    {
        float f = pathpoint.field_1718_a - field_1718_a;
        float f1 = pathpoint.field_1717_b - field_1717_b;
        float f2 = pathpoint.field_1716_c - field_1716_c;
        return MathHelper.func_1113_c(f * f + f1 * f1 + f2 * f2);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof PathPoint)
        {
            PathPoint pathpoint = (PathPoint)obj;
            return field_1715_d == pathpoint.field_1715_d && field_1718_a == pathpoint.field_1718_a && field_1717_b == pathpoint.field_1717_b && field_1716_c == pathpoint.field_1716_c;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return field_1715_d;
    }

    public boolean func_1179_a()
    {
        return field_1714_e >= 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append(field_1718_a).append(", ").append(field_1717_b).append(", ").append(field_1716_c).toString();
    }
}
