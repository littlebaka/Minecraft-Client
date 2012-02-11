// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, StatCollector, GuiOptions, 
//            StatList, StatFileWriter, World, GuiMainMenu, 
//            GuiAchievements, GuiStats, MathHelper

public class GuiIngameMenu extends GuiScreen
{

    private int field_966_a;
    private int field_967_h;

    public GuiIngameMenu()
    {
        field_966_a = 0;
        field_967_h = 0;
    }

    public void func_6448_a()
    {
        field_966_a = 0;
        field_949_e.clear();
        byte byte0 = -16;
        field_949_e.add(new GuiButton(1, field_951_c / 2 - 100, field_950_d / 4 + 120 + byte0, StatCollector.func_25200_a("menu.returnToMenu")));
        if(field_945_b.func_6260_j())
        {
            ((GuiButton)field_949_e.get(0)).field_939_e = StatCollector.func_25200_a("menu.disconnect");
        }
        field_949_e.add(new GuiButton(4, field_951_c / 2 - 100, field_950_d / 4 + 24 + byte0, StatCollector.func_25200_a("menu.returnToGame")));
        field_949_e.add(new GuiButton(0, field_951_c / 2 - 100, field_950_d / 4 + 96 + byte0, StatCollector.func_25200_a("menu.options")));
        field_949_e.add(new GuiButton(5, field_951_c / 2 - 100, field_950_d / 4 + 48 + byte0, 98, 20, StatCollector.func_25200_a("gui.achievements")));
        field_949_e.add(new GuiButton(6, field_951_c / 2 + 2, field_950_d / 4 + 48 + byte0, 98, 20, StatCollector.func_25200_a("gui.stats")));
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(guibutton.field_938_f == 0)
        {
            field_945_b.func_6272_a(new GuiOptions(this, field_945_b.field_6304_y));
        }
        if(guibutton.field_938_f == 1)
        {
            field_945_b.field_25001_G.func_25100_a(StatList.field_25180_i, 1);
            if(field_945_b.func_6260_j())
            {
                field_945_b.field_6324_e.func_660_k();
            }
            field_945_b.func_6261_a(null);
            field_945_b.func_6272_a(new GuiMainMenu());
        }
        if(guibutton.field_938_f == 4)
        {
            field_945_b.func_6272_a(null);
            field_945_b.func_6259_e();
        }
        if(guibutton.field_938_f == 5)
        {
            field_945_b.func_6272_a(new GuiAchievements(field_945_b.field_25001_G));
        }
        if(guibutton.field_938_f == 6)
        {
            field_945_b.func_6272_a(new GuiStats(this, field_945_b.field_25001_G));
        }
    }

    public void func_570_g()
    {
        super.func_570_g();
        field_967_h++;
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        boolean flag = !field_945_b.field_6324_e.func_650_a(field_966_a++);
        if(flag || field_967_h < 20)
        {
            float f1 = ((float)(field_967_h % 10) + f) / 10F;
            f1 = MathHelper.func_1106_a(f1 * 3.141593F * 2.0F) * 0.2F + 0.8F;
            int k = (int)(255F * f1);
            func_547_b(field_6451_g, "Saving level..", 8, field_950_d - 16, k << 16 | k << 8 | k);
        }
        func_548_a(field_6451_g, "Game menu", field_951_c / 2, 40, 0xffffff);
        super.func_571_a(i, j, f);
    }
}
