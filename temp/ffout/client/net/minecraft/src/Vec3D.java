// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            MathHelper

public class Vec3D
{

    private static List field_1778_d = new ArrayList();
    private static int field_1777_e = 0;
    public double field_1776_a;
    public double field_1775_b;
    public double field_1779_c;

    public static Vec3D func_1260_a(double d, double d1, double d2)
    {
        return new Vec3D(d, d1, d2);
    }

    public static void func_28215_a()
    {
        field_1778_d.clear();
        field_1777_e = 0;
    }

    public static void func_1259_a()
    {
        field_1777_e = 0;
    }

    public static Vec3D func_1248_b(double d, double d1, double d2)
    {
        if(field_1777_e >= field_1778_d.size())
        {
            field_1778_d.add(func_1260_a(0.0D, 0.0D, 0.0D));
        }
        return ((Vec3D)field_1778_d.get(field_1777_e++)).func_1254_e(d, d1, d2);
    }

    private Vec3D(double d, double d1, double d2)
    {
        if(d == -0D)
        {
            d = 0.0D;
        }
        if(d1 == -0D)
        {
            d1 = 0.0D;
        }
        if(d2 == -0D)
        {
            d2 = 0.0D;
        }
        field_1776_a = d;
        field_1775_b = d1;
        field_1779_c = d2;
    }

    private Vec3D func_1254_e(double d, double d1, double d2)
    {
        field_1776_a = d;
        field_1775_b = d1;
        field_1779_c = d2;
        return this;
    }

    public Vec3D func_1262_a(Vec3D vec3d)
    {
        return func_1248_b(vec3d.field_1776_a - field_1776_a, vec3d.field_1775_b - field_1775_b, vec3d.field_1779_c - field_1779_c);
    }

    public Vec3D func_1252_b()
    {
        double d = MathHelper.func_1109_a(field_1776_a * field_1776_a + field_1775_b * field_1775_b + field_1779_c * field_1779_c);
        if(d < 0.0001D)
        {
            return func_1248_b(0.0D, 0.0D, 0.0D);
        } else
        {
            return func_1248_b(field_1776_a / d, field_1775_b / d, field_1779_c / d);
        }
    }

    public double func_35612_b(Vec3D vec3d)
    {
        return field_1776_a * vec3d.field_1776_a + field_1775_b * vec3d.field_1775_b + field_1779_c * vec3d.field_1779_c;
    }

    public Vec3D func_1246_b(Vec3D vec3d)
    {
        return func_1248_b(field_1775_b * vec3d.field_1779_c - field_1779_c * vec3d.field_1775_b, field_1779_c * vec3d.field_1776_a - field_1776_a * vec3d.field_1779_c, field_1776_a * vec3d.field_1775_b - field_1775_b * vec3d.field_1776_a);
    }

    public Vec3D func_1257_c(double d, double d1, double d2)
    {
        return func_1248_b(field_1776_a + d, field_1775_b + d1, field_1779_c + d2);
    }

    public double func_1251_c(Vec3D vec3d)
    {
        double d = vec3d.field_1776_a - field_1776_a;
        double d1 = vec3d.field_1775_b - field_1775_b;
        double d2 = vec3d.field_1779_c - field_1779_c;
        return (double)MathHelper.func_1109_a(d * d + d1 * d1 + d2 * d2);
    }

    public double func_1261_d(Vec3D vec3d)
    {
        double d = vec3d.field_1776_a - field_1776_a;
        double d1 = vec3d.field_1775_b - field_1775_b;
        double d2 = vec3d.field_1779_c - field_1779_c;
        return d * d + d1 * d1 + d2 * d2;
    }

    public double func_1255_d(double d, double d1, double d2)
    {
        double d3 = d - field_1776_a;
        double d4 = d1 - field_1775_b;
        double d5 = d2 - field_1779_c;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public double func_1253_c()
    {
        return (double)MathHelper.func_1109_a(field_1776_a * field_1776_a + field_1775_b * field_1775_b + field_1779_c * field_1779_c);
    }

    public Vec3D func_1247_a(Vec3D vec3d, double d)
    {
        double d1 = vec3d.field_1776_a - field_1776_a;
        double d2 = vec3d.field_1775_b - field_1775_b;
        double d3 = vec3d.field_1779_c - field_1779_c;
        if(d1 * d1 < 1.0000000116860974E-007D)
        {
            return null;
        }
        double d4 = (d - field_1776_a) / d1;
        if(d4 < 0.0D || d4 > 1.0D)
        {
            return null;
        } else
        {
            return func_1248_b(field_1776_a + d1 * d4, field_1775_b + d2 * d4, field_1779_c + d3 * d4);
        }
    }

    public Vec3D func_1250_b(Vec3D vec3d, double d)
    {
        double d1 = vec3d.field_1776_a - field_1776_a;
        double d2 = vec3d.field_1775_b - field_1775_b;
        double d3 = vec3d.field_1779_c - field_1779_c;
        if(d2 * d2 < 1.0000000116860974E-007D)
        {
            return null;
        }
        double d4 = (d - field_1775_b) / d2;
        if(d4 < 0.0D || d4 > 1.0D)
        {
            return null;
        } else
        {
            return func_1248_b(field_1776_a + d1 * d4, field_1775_b + d2 * d4, field_1779_c + d3 * d4);
        }
    }

    public Vec3D func_1256_c(Vec3D vec3d, double d)
    {
        double d1 = vec3d.field_1776_a - field_1776_a;
        double d2 = vec3d.field_1775_b - field_1775_b;
        double d3 = vec3d.field_1779_c - field_1779_c;
        if(d3 * d3 < 1.0000000116860974E-007D)
        {
            return null;
        }
        double d4 = (d - field_1779_c) / d3;
        if(d4 < 0.0D || d4 > 1.0D)
        {
            return null;
        } else
        {
            return func_1248_b(field_1776_a + d1 * d4, field_1775_b + d2 * d4, field_1779_c + d3 * d4);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("(").append(field_1776_a).append(", ").append(field_1775_b).append(", ").append(field_1779_c).append(")").toString();
    }

    public void func_1258_a(float f)
    {
        float f1 = MathHelper.func_1114_b(f);
        float f2 = MathHelper.func_1106_a(f);
        double d = field_1776_a;
        double d1 = field_1775_b * (double)f1 + field_1779_c * (double)f2;
        double d2 = field_1779_c * (double)f1 - field_1775_b * (double)f2;
        field_1776_a = d;
        field_1775_b = d1;
        field_1779_c = d2;
    }

    public void func_1249_b(float f)
    {
        float f1 = MathHelper.func_1114_b(f);
        float f2 = MathHelper.func_1106_a(f);
        double d = field_1776_a * (double)f1 + field_1779_c * (double)f2;
        double d1 = field_1775_b;
        double d2 = field_1779_c * (double)f1 - field_1776_a * (double)f2;
        field_1776_a = d;
        field_1775_b = d1;
        field_1779_c = d2;
    }

}
