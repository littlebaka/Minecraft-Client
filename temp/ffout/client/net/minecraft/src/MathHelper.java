// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

public class MathHelper
{

    private static float field_1653_a[];

    public MathHelper()
    {
    }

    public static final float func_1106_a(float f)
    {
        return field_1653_a[(int)(f * 10430.38F) & 0xffff];
    }

    public static final float func_1114_b(float f)
    {
        return field_1653_a[(int)(f * 10430.38F + 16384F) & 0xffff];
    }

    public static final float func_1113_c(float f)
    {
        return (float)Math.sqrt(f);
    }

    public static final float func_1109_a(double d)
    {
        return (float)Math.sqrt(d);
    }

    public static int func_1110_d(float f)
    {
        int i = (int)f;
        return f >= (float)i ? i : i - 1;
    }

    public static int func_40346_b(double d)
    {
        return (int)(d + 1024D) - 1024;
    }

    public static int func_1108_b(double d)
    {
        int i = (int)d;
        return d >= (double)i ? i : i - 1;
    }

    public static long func_35599_c(double d)
    {
        long l = (long)d;
        return d >= (double)l ? l : l - 1L;
    }

    public static float func_1112_e(float f)
    {
        return f < 0.0F ? -f : f;
    }

    public static int func_35597_a(int i)
    {
        return i < 0 ? -i : i;
    }

    public static int func_41084_a(int i, int j, int k)
    {
        if(i < j)
        {
            return j;
        }
        if(i > k)
        {
            return k;
        } else
        {
            return i;
        }
    }

    public static double func_1107_a(double d, double d1)
    {
        if(d < 0.0D)
        {
            d = -d;
        }
        if(d1 < 0.0D)
        {
            d1 = -d1;
        }
        return d <= d1 ? d1 : d;
    }

    public static int func_1111_a(int i, int j)
    {
        if(i < 0)
        {
            return -((-i - 1) / j) - 1;
        } else
        {
            return i / j;
        }
    }

    public static boolean func_22282_a(String s)
    {
        return s == null || s.length() == 0;
    }

    public static int func_35598_a(Random random, int i, int j)
    {
        if(i >= j)
        {
            return i;
        } else
        {
            return random.nextInt((j - i) + 1) + i;
        }
    }

    static 
    {
        field_1653_a = new float[0x10000];
        for(int i = 0; i < 0x10000; i++)
        {
            field_1653_a[i] = (float)Math.sin(((double)i * 3.1415926535897931D * 2D) / 65536D);
        }

    }
}
