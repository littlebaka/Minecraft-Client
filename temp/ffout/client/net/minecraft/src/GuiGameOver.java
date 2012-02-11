// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, World, WorldInfo, GuiButton, 
//            StatCollector, ISaveFormat, ISaveHandler, GuiMainMenu, 
//            EntityPlayerSP

public class GuiGameOver extends GuiScreen
{

    public GuiGameOver()
    {
    }

    public void func_6448_a()
    {
        field_949_e.clear();
        if(field_945_b.field_6324_e.func_22144_v().func_40724_s())
        {
            field_949_e.add(new GuiButton(1, field_951_c / 2 - 100, field_950_d / 4 + 96, StatCollector.func_25200_a("deathScreen.deleteWorld")));
        } else
        {
            field_949_e.add(new GuiButton(1, field_951_c / 2 - 100, field_950_d / 4 + 72, StatCollector.func_25200_a("deathScreen.respawn")));
            field_949_e.add(new GuiButton(2, field_951_c / 2 - 100, field_950_d / 4 + 96, StatCollector.func_25200_a("deathScreen.titleScreen")));
            if(field_945_b.field_6320_i == null)
            {
                ((GuiButton)field_949_e.get(1)).field_937_g = false;
            }
        }
    }

    protected void func_580_a(char c, int i)
    {
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(guibutton.field_938_f != 0);
        if(guibutton.field_938_f == 1)
        {
            if(field_945_b.field_6324_e.func_22144_v().func_40724_s())
            {
                World world = field_945_b.field_6324_e;
                field_945_b.func_40002_b("Deleting world");
                ISaveFormat isaveformat = field_945_b.func_22004_c();
                isaveformat.func_22177_c();
                isaveformat.func_22172_c(world.func_40479_y().func_40530_d());
                field_945_b.func_6272_a(new GuiMainMenu());
            } else
            {
                field_945_b.field_6322_g.func_9367_r();
                field_945_b.func_6272_a(null);
            }
        }
        if(guibutton.field_938_f == 2)
        {
            if(field_945_b.func_6260_j())
            {
                field_945_b.field_6324_e.func_660_k();
            }
            field_945_b.func_6261_a(null);
            field_945_b.func_6272_a(new GuiMainMenu());
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        func_549_a(0, 0, field_951_c, field_950_d, 0x60500000, 0xa0803030);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        if(field_945_b.field_6324_e.func_22144_v().func_40724_s())
        {
            func_548_a(field_6451_g, StatCollector.func_25200_a("deathScreen.title.hardcore"), field_951_c / 2 / 2, 30, 0xffffff);
        } else
        {
            func_548_a(field_6451_g, StatCollector.func_25200_a("deathScreen.title"), field_951_c / 2 / 2, 30, 0xffffff);
        }
        GL11.glPopMatrix();
        if(field_945_b.field_6324_e.func_22144_v().func_40724_s())
        {
            func_548_a(field_6451_g, StatCollector.func_25200_a("deathScreen.hardcoreInfo"), field_951_c / 2, 144, 0xffffff);
        }
        func_548_a(field_6451_g, (new StringBuilder()).append(StatCollector.func_25200_a("deathScreen.score")).append(": \247e").append(field_945_b.field_6322_g.func_6417_t()).toString(), field_951_c / 2, 100, 0xffffff);
        super.func_571_a(i, j, f);
    }

    public boolean func_6450_b()
    {
        return false;
    }
}
