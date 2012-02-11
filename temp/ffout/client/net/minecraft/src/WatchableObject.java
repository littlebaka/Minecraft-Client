// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class WatchableObject
{

    private final int field_21164_a;
    private final int field_21163_b;
    private Object field_21166_c;
    private boolean field_21165_d;

    public WatchableObject(int i, int j, Object obj)
    {
        field_21163_b = j;
        field_21166_c = obj;
        field_21164_a = i;
        field_21165_d = true;
    }

    public int func_21161_a()
    {
        return field_21163_b;
    }

    public void func_21160_a(Object obj)
    {
        field_21166_c = obj;
    }

    public Object func_21158_b()
    {
        return field_21166_c;
    }

    public int func_21159_c()
    {
        return field_21164_a;
    }

    public void func_21162_a(boolean flag)
    {
        field_21165_d = flag;
    }
}
