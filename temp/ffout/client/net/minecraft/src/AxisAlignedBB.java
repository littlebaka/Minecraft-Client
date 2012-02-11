// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Vec3D, MovingObjectPosition

public class AxisAlignedBB
{

    private static List field_1700_g = new ArrayList();
    private static int field_1699_h = 0;
    public double field_1698_a;
    public double field_1697_b;
    public double field_1704_c;
    public double field_1703_d;
    public double field_1702_e;
    public double field_1701_f;

    public static AxisAlignedBB func_1168_a(double d, double d1, double d2, double d3, 
            double d4, double d5)
    {
        return new AxisAlignedBB(d, d1, d2, d3, d4, d5);
    }

    public static void func_28196_a()
    {
        field_1700_g.clear();
        field_1699_h = 0;
    }

    public static void func_4149_a()
    {
        field_1699_h = 0;
    }

    public static AxisAlignedBB func_1161_b(double d, double d1, double d2, double d3, 
            double d4, double d5)
    {
        if(field_1699_h >= field_1700_g.size())
        {
            field_1700_g.add(func_1168_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D));
        }
        return ((AxisAlignedBB)field_1700_g.get(field_1699_h++)).func_1165_c(d, d1, d2, d3, d4, d5);
    }

    private AxisAlignedBB(double d, double d1, double d2, double d3, double d4, double d5)
    {
        field_1698_a = d;
        field_1697_b = d1;
        field_1704_c = d2;
        field_1703_d = d3;
        field_1702_e = d4;
        field_1701_f = d5;
    }

    public AxisAlignedBB func_1165_c(double d, double d1, double d2, double d3, double d4, double d5)
    {
        field_1698_a = d;
        field_1697_b = d1;
        field_1704_c = d2;
        field_1703_d = d3;
        field_1702_e = d4;
        field_1701_f = d5;
        return this;
    }

    public AxisAlignedBB func_1170_a(double d, double d1, double d2)
    {
        double d3 = field_1698_a;
        double d4 = field_1697_b;
        double d5 = field_1704_c;
        double d6 = field_1703_d;
        double d7 = field_1702_e;
        double d8 = field_1701_f;
        if(d < 0.0D)
        {
            d3 += d;
        }
        if(d > 0.0D)
        {
            d6 += d;
        }
        if(d1 < 0.0D)
        {
            d4 += d1;
        }
        if(d1 > 0.0D)
        {
            d7 += d1;
        }
        if(d2 < 0.0D)
        {
            d5 += d2;
        }
        if(d2 > 0.0D)
        {
            d8 += d2;
        }
        return func_1161_b(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB func_1177_b(double d, double d1, double d2)
    {
        double d3 = field_1698_a - d;
        double d4 = field_1697_b - d1;
        double d5 = field_1704_c - d2;
        double d6 = field_1703_d + d;
        double d7 = field_1702_e + d1;
        double d8 = field_1701_f + d2;
        return func_1161_b(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB func_1166_c(double d, double d1, double d2)
    {
        return func_1161_b(field_1698_a + d, field_1697_b + d1, field_1704_c + d2, field_1703_d + d, field_1702_e + d1, field_1701_f + d2);
    }

    public double func_1163_a(AxisAlignedBB axisalignedbb, double d)
    {
        if(axisalignedbb.field_1702_e <= field_1697_b || axisalignedbb.field_1697_b >= field_1702_e)
        {
            return d;
        }
        if(axisalignedbb.field_1701_f <= field_1704_c || axisalignedbb.field_1704_c >= field_1701_f)
        {
            return d;
        }
        if(d > 0.0D && axisalignedbb.field_1703_d <= field_1698_a)
        {
            double d1 = field_1698_a - axisalignedbb.field_1703_d;
            if(d1 < d)
            {
                d = d1;
            }
        }
        if(d < 0.0D && axisalignedbb.field_1698_a >= field_1703_d)
        {
            double d2 = field_1703_d - axisalignedbb.field_1698_a;
            if(d2 > d)
            {
                d = d2;
            }
        }
        return d;
    }

    public double func_1172_b(AxisAlignedBB axisalignedbb, double d)
    {
        if(axisalignedbb.field_1703_d <= field_1698_a || axisalignedbb.field_1698_a >= field_1703_d)
        {
            return d;
        }
        if(axisalignedbb.field_1701_f <= field_1704_c || axisalignedbb.field_1704_c >= field_1701_f)
        {
            return d;
        }
        if(d > 0.0D && axisalignedbb.field_1702_e <= field_1697_b)
        {
            double d1 = field_1697_b - axisalignedbb.field_1702_e;
            if(d1 < d)
            {
                d = d1;
            }
        }
        if(d < 0.0D && axisalignedbb.field_1697_b >= field_1702_e)
        {
            double d2 = field_1702_e - axisalignedbb.field_1697_b;
            if(d2 > d)
            {
                d = d2;
            }
        }
        return d;
    }

    public double func_1162_c(AxisAlignedBB axisalignedbb, double d)
    {
        if(axisalignedbb.field_1703_d <= field_1698_a || axisalignedbb.field_1698_a >= field_1703_d)
        {
            return d;
        }
        if(axisalignedbb.field_1702_e <= field_1697_b || axisalignedbb.field_1697_b >= field_1702_e)
        {
            return d;
        }
        if(d > 0.0D && axisalignedbb.field_1701_f <= field_1704_c)
        {
            double d1 = field_1704_c - axisalignedbb.field_1701_f;
            if(d1 < d)
            {
                d = d1;
            }
        }
        if(d < 0.0D && axisalignedbb.field_1704_c >= field_1701_f)
        {
            double d2 = field_1701_f - axisalignedbb.field_1704_c;
            if(d2 > d)
            {
                d = d2;
            }
        }
        return d;
    }

    public boolean func_1178_a(AxisAlignedBB axisalignedbb)
    {
        if(axisalignedbb.field_1703_d <= field_1698_a || axisalignedbb.field_1698_a >= field_1703_d)
        {
            return false;
        }
        if(axisalignedbb.field_1702_e <= field_1697_b || axisalignedbb.field_1697_b >= field_1702_e)
        {
            return false;
        }
        return axisalignedbb.field_1701_f > field_1704_c && axisalignedbb.field_1704_c < field_1701_f;
    }

    public AxisAlignedBB func_1174_d(double d, double d1, double d2)
    {
        field_1698_a += d;
        field_1697_b += d1;
        field_1704_c += d2;
        field_1703_d += d;
        field_1702_e += d1;
        field_1701_f += d2;
        return this;
    }

    public boolean func_4150_a(Vec3D vec3d)
    {
        if(vec3d.field_1776_a <= field_1698_a || vec3d.field_1776_a >= field_1703_d)
        {
            return false;
        }
        if(vec3d.field_1775_b <= field_1697_b || vec3d.field_1775_b >= field_1702_e)
        {
            return false;
        }
        return vec3d.field_1779_c > field_1704_c && vec3d.field_1779_c < field_1701_f;
    }

    public double func_1164_b()
    {
        double d = field_1703_d - field_1698_a;
        double d1 = field_1702_e - field_1697_b;
        double d2 = field_1701_f - field_1704_c;
        return (d + d1 + d2) / 3D;
    }

    public AxisAlignedBB func_28195_e(double d, double d1, double d2)
    {
        double d3 = field_1698_a + d;
        double d4 = field_1697_b + d1;
        double d5 = field_1704_c + d2;
        double d6 = field_1703_d - d;
        double d7 = field_1702_e - d1;
        double d8 = field_1701_f - d2;
        return func_1161_b(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB func_1160_c()
    {
        return func_1161_b(field_1698_a, field_1697_b, field_1704_c, field_1703_d, field_1702_e, field_1701_f);
    }

    public MovingObjectPosition func_1169_a(Vec3D vec3d, Vec3D vec3d1)
    {
        Vec3D vec3d2 = vec3d.func_1247_a(vec3d1, field_1698_a);
        Vec3D vec3d3 = vec3d.func_1247_a(vec3d1, field_1703_d);
        Vec3D vec3d4 = vec3d.func_1250_b(vec3d1, field_1697_b);
        Vec3D vec3d5 = vec3d.func_1250_b(vec3d1, field_1702_e);
        Vec3D vec3d6 = vec3d.func_1256_c(vec3d1, field_1704_c);
        Vec3D vec3d7 = vec3d.func_1256_c(vec3d1, field_1701_f);
        if(!func_1167_a(vec3d2))
        {
            vec3d2 = null;
        }
        if(!func_1167_a(vec3d3))
        {
            vec3d3 = null;
        }
        if(!func_1175_b(vec3d4))
        {
            vec3d4 = null;
        }
        if(!func_1175_b(vec3d5))
        {
            vec3d5 = null;
        }
        if(!func_1176_c(vec3d6))
        {
            vec3d6 = null;
        }
        if(!func_1176_c(vec3d7))
        {
            vec3d7 = null;
        }
        Vec3D vec3d8 = null;
        if(vec3d2 != null && (vec3d8 == null || vec3d.func_1261_d(vec3d2) < vec3d.func_1261_d(vec3d8)))
        {
            vec3d8 = vec3d2;
        }
        if(vec3d3 != null && (vec3d8 == null || vec3d.func_1261_d(vec3d3) < vec3d.func_1261_d(vec3d8)))
        {
            vec3d8 = vec3d3;
        }
        if(vec3d4 != null && (vec3d8 == null || vec3d.func_1261_d(vec3d4) < vec3d.func_1261_d(vec3d8)))
        {
            vec3d8 = vec3d4;
        }
        if(vec3d5 != null && (vec3d8 == null || vec3d.func_1261_d(vec3d5) < vec3d.func_1261_d(vec3d8)))
        {
            vec3d8 = vec3d5;
        }
        if(vec3d6 != null && (vec3d8 == null || vec3d.func_1261_d(vec3d6) < vec3d.func_1261_d(vec3d8)))
        {
            vec3d8 = vec3d6;
        }
        if(vec3d7 != null && (vec3d8 == null || vec3d.func_1261_d(vec3d7) < vec3d.func_1261_d(vec3d8)))
        {
            vec3d8 = vec3d7;
        }
        if(vec3d8 == null)
        {
            return null;
        }
        byte byte0 = -1;
        if(vec3d8 == vec3d2)
        {
            byte0 = 4;
        }
        if(vec3d8 == vec3d3)
        {
            byte0 = 5;
        }
        if(vec3d8 == vec3d4)
        {
            byte0 = 0;
        }
        if(vec3d8 == vec3d5)
        {
            byte0 = 1;
        }
        if(vec3d8 == vec3d6)
        {
            byte0 = 2;
        }
        if(vec3d8 == vec3d7)
        {
            byte0 = 3;
        }
        return new MovingObjectPosition(0, 0, 0, byte0, vec3d8);
    }

    private boolean func_1167_a(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.field_1775_b >= field_1697_b && vec3d.field_1775_b <= field_1702_e && vec3d.field_1779_c >= field_1704_c && vec3d.field_1779_c <= field_1701_f;
        }
    }

    private boolean func_1175_b(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.field_1776_a >= field_1698_a && vec3d.field_1776_a <= field_1703_d && vec3d.field_1779_c >= field_1704_c && vec3d.field_1779_c <= field_1701_f;
        }
    }

    private boolean func_1176_c(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.field_1776_a >= field_1698_a && vec3d.field_1776_a <= field_1703_d && vec3d.field_1775_b >= field_1697_b && vec3d.field_1775_b <= field_1702_e;
        }
    }

    public void func_1171_b(AxisAlignedBB axisalignedbb)
    {
        field_1698_a = axisalignedbb.field_1698_a;
        field_1697_b = axisalignedbb.field_1697_b;
        field_1704_c = axisalignedbb.field_1704_c;
        field_1703_d = axisalignedbb.field_1703_d;
        field_1702_e = axisalignedbb.field_1702_e;
        field_1701_f = axisalignedbb.field_1701_f;
    }

    public String toString()
    {
        return (new StringBuilder()).append("box[").append(field_1698_a).append(", ").append(field_1697_b).append(", ").append(field_1704_c).append(" -> ").append(field_1703_d).append(", ").append(field_1702_e).append(", ").append(field_1701_f).append("]").toString();
    }

}
