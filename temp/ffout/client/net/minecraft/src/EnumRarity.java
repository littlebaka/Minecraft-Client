// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumRarity extends Enum
{

    public static final EnumRarity common;
    public static final EnumRarity uncommon;
    public static final EnumRarity rare;
    public static final EnumRarity epic;
    public final int field_40535_e;
    public final String field_40532_f;
    private static final EnumRarity field_40533_g[]; /* synthetic field */

    public static EnumRarity[] values()
    {
        return (EnumRarity[])field_40533_g.clone();
    }

    public static EnumRarity valueOf(String s)
    {
        return (EnumRarity)Enum.valueOf(net.minecraft.src.EnumRarity.class, s);
    }

    private EnumRarity(String s, int i, int j, String s1)
    {
        super(s, i);
        field_40535_e = j;
        field_40532_f = s1;
    }

    static 
    {
        common = new EnumRarity("common", 0, 15, "Common");
        uncommon = new EnumRarity("uncommon", 1, 14, "Uncommon");
        rare = new EnumRarity("rare", 2, 11, "Rare");
        epic = new EnumRarity("epic", 3, 13, "Epic");
        field_40533_g = (new EnumRarity[] {
            common, uncommon, rare, epic
        });
    }
}
