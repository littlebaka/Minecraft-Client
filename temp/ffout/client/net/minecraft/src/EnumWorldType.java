// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumWorldType extends Enum
{

    public static final EnumWorldType DEFAULT;
    public static final EnumWorldType FLAT;
    private String field_46139_c;
    private static final EnumWorldType field_46137_d[]; /* synthetic field */

    public static EnumWorldType[] values()
    {
        return (EnumWorldType[])field_46137_d.clone();
    }

    public static EnumWorldType valueOf(String s)
    {
        return (EnumWorldType)Enum.valueOf(net.minecraft.src.EnumWorldType.class, s);
    }

    private EnumWorldType(String s, int i, String s1)
    {
        super(s, i);
        field_46139_c = s1;
    }

    public String func_46136_a()
    {
        return (new StringBuilder()).append("generator.").append(field_46139_c).toString();
    }

    public static EnumWorldType func_46135_a(String s)
    {
        EnumWorldType aenumworldtype[] = values();
        int i = aenumworldtype.length;
        for(int j = 0; j < i; j++)
        {
            EnumWorldType enumworldtype = aenumworldtype[j];
            if(enumworldtype.name().equals(s))
            {
                return enumworldtype;
            }
        }

        return null;
    }

    static 
    {
        DEFAULT = new EnumWorldType("DEFAULT", 0, "default");
        FLAT = new EnumWorldType("FLAT", 1, "flat");
        field_46137_d = (new EnumWorldType[] {
            DEFAULT, FLAT
        });
    }
}
