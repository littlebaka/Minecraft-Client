// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiSmallButton, GuiSlotLanguage, 
//            GuiButton, GameSettings, TexturePackList

public class GuiLanguage extends GuiScreen
{

    protected GuiScreen field_44009_a;
    private int field_44007_b;
    private GuiSlotLanguage field_44008_c;
    private final GameSettings field_44006_d;
    private GuiSmallButton field_46029_e;

    public GuiLanguage(GuiScreen guiscreen, GameSettings gamesettings)
    {
        field_44007_b = -1;
        field_44009_a = guiscreen;
        field_44006_d = gamesettings;
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_949_e.add(field_46029_e = new GuiSmallButton(6, field_951_c / 2 - 75, field_950_d - 38, stringtranslate.func_20163_a("gui.done")));
        field_44008_c = new GuiSlotLanguage(this);
        field_44008_c.func_22240_a(field_949_e, 7, 8);
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f != 5)
        {
            if(guibutton.field_938_f == 6)
            {
                field_44006_d.func_1041_b();
                field_945_b.func_6272_a(field_44009_a);
            } else
            {
                field_44008_c.func_22241_a(guibutton);
            }
        }
    }

    protected void func_565_a(int i, int j, int k)
    {
        super.func_565_a(i, j, k);
    }

    protected void func_573_b(int i, int j, int k)
    {
        super.func_573_b(i, j, k);
    }

    public void func_571_a(int i, int j, float f)
    {
        field_44008_c.func_22243_a(i, j, f);
        if(field_44007_b <= 0)
        {
            field_945_b.field_6298_C.func_6532_a();
            field_44007_b += 20;
        }
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        func_548_a(field_6451_g, stringtranslate.func_20163_a("options.language"), field_951_c / 2, 16, 0xffffff);
        func_548_a(field_6451_g, (new StringBuilder()).append("(").append(stringtranslate.func_20163_a("options.languageWarning")).append(")").toString(), field_951_c / 2, field_950_d - 56, 0x808080);
        super.func_571_a(i, j, f);
    }

    public void func_570_g()
    {
        super.func_570_g();
        field_44007_b--;
    }

    static GameSettings func_44005_a(GuiLanguage guilanguage)
    {
        return guilanguage.field_44006_d;
    }

    static GuiSmallButton func_46028_b(GuiLanguage guilanguage)
    {
        return guilanguage.field_46029_e;
    }
}
