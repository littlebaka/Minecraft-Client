// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class StructureVillagePieceWeight
{

    public Class field_35607_a;
    public final int field_35605_b;
    public int field_35606_c;
    public int field_35604_d;

    public StructureVillagePieceWeight(Class class1, int i, int j)
    {
        field_35607_a = class1;
        field_35605_b = i;
        field_35604_d = j;
    }

    public boolean func_35602_a(int i)
    {
        return field_35604_d == 0 || field_35606_c < field_35604_d;
    }

    public boolean func_35603_a()
    {
        return field_35604_d == 0 || field_35606_c < field_35604_d;
    }
}
