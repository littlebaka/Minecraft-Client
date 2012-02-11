// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ClippingHelper
{

    public float field_1688_a[][];
    public float field_1687_b[];
    public float field_1690_c[];
    public float field_1689_d[];

    public ClippingHelper()
    {
        field_1688_a = new float[16][16];
        field_1687_b = new float[16];
        field_1690_c = new float[16];
        field_1689_d = new float[16];
    }

    public boolean func_1152_a(double d, double d1, double d2, double d3, double d4, double d5)
    {
        for(int i = 0; i < 6; i++)
        {
            if((double)field_1688_a[i][0] * d + (double)field_1688_a[i][1] * d1 + (double)field_1688_a[i][2] * d2 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d3 + (double)field_1688_a[i][1] * d1 + (double)field_1688_a[i][2] * d2 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d + (double)field_1688_a[i][1] * d4 + (double)field_1688_a[i][2] * d2 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d3 + (double)field_1688_a[i][1] * d4 + (double)field_1688_a[i][2] * d2 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d + (double)field_1688_a[i][1] * d1 + (double)field_1688_a[i][2] * d5 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d3 + (double)field_1688_a[i][1] * d1 + (double)field_1688_a[i][2] * d5 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d + (double)field_1688_a[i][1] * d4 + (double)field_1688_a[i][2] * d5 + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * d3 + (double)field_1688_a[i][1] * d4 + (double)field_1688_a[i][2] * d5 + (double)field_1688_a[i][3] <= 0.0D)
            {
                return false;
            }
        }

        return true;
    }
}
