// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnumWorldType

public final class WorldSettings
{

    private final long field_35523_a;
    private final int field_35521_b;
    private final boolean field_35522_c;
    private final boolean field_40558_d;
    private final EnumWorldType field_46108_e;

    public WorldSettings(long l, int i, boolean flag, boolean flag1, EnumWorldType enumworldtype)
    {
        field_35523_a = l;
        field_35521_b = i;
        field_35522_c = flag;
        field_40558_d = flag1;
        field_46108_e = enumworldtype;
    }

    public long func_35518_a()
    {
        return field_35523_a;
    }

    public int func_35519_b()
    {
        return field_35521_b;
    }

    public boolean func_40557_c()
    {
        return field_40558_d;
    }

    public boolean func_35520_c()
    {
        return field_35522_c;
    }

    public EnumWorldType func_46107_e()
    {
        return field_46108_e;
    }
}
