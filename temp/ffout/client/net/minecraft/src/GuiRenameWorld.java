// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiTextField, StringTranslate, GuiButton, 
//            ISaveFormat, WorldInfo

public class GuiRenameWorld extends GuiScreen
{

    private GuiScreen field_22112_a;
    private GuiTextField field_22114_h;
    private final String field_22113_i;

    public GuiRenameWorld(GuiScreen guiscreen, String s)
    {
        field_22112_a = guiscreen;
        field_22113_i = s;
    }

    public void func_570_g()
    {
        field_22114_h.func_22070_b();
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        Keyboard.enableRepeatEvents(true);
        field_949_e.clear();
        field_949_e.add(new GuiButton(0, field_951_c / 2 - 100, field_950_d / 4 + 96 + 12, stringtranslate.func_20163_a("selectWorld.renameButton")));
        field_949_e.add(new GuiButton(1, field_951_c / 2 - 100, field_950_d / 4 + 120 + 12, stringtranslate.func_20163_a("gui.cancel")));
        ISaveFormat isaveformat = field_945_b.func_22004_c();
        WorldInfo worldinfo = isaveformat.func_22173_b(field_22113_i);
        String s = worldinfo.func_22302_j();
        field_22114_h = new GuiTextField(this, field_6451_g, field_951_c / 2 - 100, 60, 200, 20, s);
        field_22114_h.field_22082_a = true;
        field_22114_h.func_22066_a(32);
    }

    public void func_6449_h()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f == 1)
        {
            field_945_b.func_6272_a(field_22112_a);
        } else
        if(guibutton.field_938_f == 0)
        {
            ISaveFormat isaveformat = field_945_b.func_22004_c();
            isaveformat.func_22170_a(field_22113_i, field_22114_h.func_22071_a().trim());
            field_945_b.func_6272_a(field_22112_a);
        }
    }

    protected void func_580_a(char c, int i)
    {
        field_22114_h.func_22072_a(c, i);
        ((GuiButton)field_949_e.get(0)).field_937_g = field_22114_h.func_22071_a().trim().length() > 0;
        if(c == '\r')
        {
            func_572_a((GuiButton)field_949_e.get(0));
        }
    }

    protected void func_565_a(int i, int j, int k)
    {
        super.func_565_a(i, j, k);
        field_22114_h.func_22069_a(i, j, k);
    }

    public void func_571_a(int i, int j, float f)
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        func_578_i();
        func_548_a(field_6451_g, stringtranslate.func_20163_a("selectWorld.renameTitle"), field_951_c / 2, (field_950_d / 4 - 60) + 20, 0xffffff);
        func_547_b(field_6451_g, stringtranslate.func_20163_a("selectWorld.enterName"), field_951_c / 2 - 100, 47, 0xa0a0a0);
        field_22114_h.func_22067_c();
        super.func_571_a(i, j, f);
    }
}
