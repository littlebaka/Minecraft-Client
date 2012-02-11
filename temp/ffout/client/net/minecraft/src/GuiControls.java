// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GameSettings, GuiSmallButton, 
//            GuiButton, KeyBinding

public class GuiControls extends GuiScreen
{

    private GuiScreen field_957_h;
    protected String field_954_a;
    private GameSettings field_956_i;
    private int field_955_j;

    public GuiControls(GuiScreen guiscreen, GameSettings gamesettings)
    {
        field_954_a = "Controls";
        field_955_j = -1;
        field_957_h = guiscreen;
        field_956_i = gamesettings;
    }

    private int func_20080_j()
    {
        return field_951_c / 2 - 155;
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        int i = func_20080_j();
        for(int j = 0; j < field_956_i.field_1564_t.length; j++)
        {
            field_949_e.add(new GuiSmallButton(j, i + (j % 2) * 160, field_950_d / 6 + 24 * (j >> 1), 70, 20, field_956_i.func_1047_d(j)));
        }

        field_949_e.add(new GuiButton(200, field_951_c / 2 - 100, field_950_d / 6 + 168, stringtranslate.func_20163_a("gui.done")));
        field_954_a = stringtranslate.func_20163_a("controls.title");
    }

    protected void func_572_a(GuiButton guibutton)
    {
        for(int i = 0; i < field_956_i.field_1564_t.length; i++)
        {
            ((GuiButton)field_949_e.get(i)).field_939_e = field_956_i.func_1047_d(i);
        }

        if(guibutton.field_938_f == 200)
        {
            field_945_b.func_6272_a(field_957_h);
        } else
        {
            field_955_j = guibutton.field_938_f;
            guibutton.field_939_e = (new StringBuilder()).append("> ").append(field_956_i.func_1047_d(guibutton.field_938_f)).append(" <").toString();
        }
    }

    protected void func_565_a(int i, int j, int k)
    {
        if(field_955_j >= 0)
        {
            field_956_i.func_1042_a(field_955_j, -100 + k);
            ((GuiButton)field_949_e.get(field_955_j)).field_939_e = field_956_i.func_1047_d(field_955_j);
            field_955_j = -1;
            KeyBinding.func_35961_b();
        } else
        {
            super.func_565_a(i, j, k);
        }
    }

    protected void func_580_a(char c, int i)
    {
        if(field_955_j >= 0)
        {
            field_956_i.func_1042_a(field_955_j, i);
            ((GuiButton)field_949_e.get(field_955_j)).field_939_e = field_956_i.func_1047_d(field_955_j);
            field_955_j = -1;
            KeyBinding.func_35961_b();
        } else
        {
            super.func_580_a(c, i);
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        func_548_a(field_6451_g, field_954_a, field_951_c / 2, 20, 0xffffff);
        int k = func_20080_j();
        for(int l = 0; l < field_956_i.field_1564_t.length; l++)
        {
            boolean flag = false;
            for(int i1 = 0; i1 < field_956_i.field_1564_t.length; i1++)
            {
                if(i1 != l && field_956_i.field_1564_t[l].field_1370_b == field_956_i.field_1564_t[i1].field_1370_b)
                {
                    flag = true;
                }
            }

            int j1 = l;
            if(field_955_j == l)
            {
                ((GuiButton)field_949_e.get(j1)).field_939_e = "\247f> \247e??? \247f<";
            } else
            if(flag)
            {
                ((GuiButton)field_949_e.get(j1)).field_939_e = (new StringBuilder()).append("\247c").append(field_956_i.func_1047_d(j1)).toString();
            } else
            {
                ((GuiButton)field_949_e.get(j1)).field_939_e = field_956_i.func_1047_d(j1);
            }
            func_547_b(field_6451_g, field_956_i.func_20102_a(l), k + (l % 2) * 160 + 70 + 6, field_950_d / 6 + 24 * (l >> 1) + 7, -1);
        }

        super.func_571_a(i, j, f);
    }
}
