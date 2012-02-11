// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GuiButton, EnumOptions

public class GuiSmallButton extends GuiButton
{

    private final EnumOptions field_20079_i;

    public GuiSmallButton(int i, int j, int k, String s)
    {
        this(i, j, k, null, s);
    }

    public GuiSmallButton(int i, int j, int k, int l, int i1, String s)
    {
        super(i, j, k, l, i1, s);
        field_20079_i = null;
    }

    public GuiSmallButton(int i, int j, int k, EnumOptions enumoptions, String s)
    {
        super(i, j, k, 150, 20, s);
        field_20079_i = enumoptions;
    }

    public EnumOptions func_20078_a()
    {
        return field_20079_i;
    }
}
