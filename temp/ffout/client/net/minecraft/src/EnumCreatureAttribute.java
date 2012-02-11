// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumCreatureAttribute extends Enum
{

    public static final EnumCreatureAttribute UNDEFINED;
    public static final EnumCreatureAttribute UNDEAD;
    public static final EnumCreatureAttribute ARTHROPOD;
    private static final EnumCreatureAttribute field_40586_d[]; /* synthetic field */

    public static EnumCreatureAttribute[] values()
    {
        return (EnumCreatureAttribute[])field_40586_d.clone();
    }

    public static EnumCreatureAttribute valueOf(String s)
    {
        return (EnumCreatureAttribute)Enum.valueOf(net.minecraft.src.EnumCreatureAttribute.class, s);
    }

    private EnumCreatureAttribute(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        UNDEFINED = new EnumCreatureAttribute("UNDEFINED", 0);
        UNDEAD = new EnumCreatureAttribute("UNDEAD", 1);
        ARTHROPOD = new EnumCreatureAttribute("ARTHROPOD", 2);
        field_40586_d = (new EnumCreatureAttribute[] {
            UNDEFINED, UNDEAD, ARTHROPOD
        });
    }
}
