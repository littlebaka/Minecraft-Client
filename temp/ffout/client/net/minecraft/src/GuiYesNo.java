// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiSmallButton, GuiButton

public class GuiYesNo extends GuiScreen
{

    private GuiScreen field_961_a;
    private String field_964_h;
    private String field_963_i;
    private String field_22106_k;
    private String field_22105_l;
    private int field_962_j;

    public GuiYesNo(GuiScreen guiscreen, String s, String s1, String s2, String s3, int i)
    {
        field_961_a = guiscreen;
        field_964_h = s;
        field_963_i = s1;
        field_22106_k = s2;
        field_22105_l = s3;
        field_962_j = i;
    }

    public void func_6448_a()
    {
        field_949_e.add(new GuiSmallButton(0, (field_951_c / 2 - 155) + 0, field_950_d / 6 + 96, field_22106_k));
        field_949_e.add(new GuiSmallButton(1, (field_951_c / 2 - 155) + 160, field_950_d / 6 + 96, field_22105_l));
    }

    protected void func_572_a(GuiButton guibutton)
    {
        field_961_a.func_568_a(guibutton.field_938_f == 0, field_962_j);
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        func_548_a(field_6451_g, field_964_h, field_951_c / 2, 70, 0xffffff);
        func_548_a(field_6451_g, field_963_i, field_951_c / 2, 90, 0xffffff);
        super.func_571_a(i, j, f);
    }
}
