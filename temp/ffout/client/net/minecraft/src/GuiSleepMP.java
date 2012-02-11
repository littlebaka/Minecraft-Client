// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiChat, StringTranslate, GuiButton, EntityPlayerSP, 
//            EntityClientPlayerMP, Packet19EntityAction, NetClientHandler

public class GuiSleepMP extends GuiChat
{

    public GuiSleepMP()
    {
    }

    public void func_6448_a()
    {
        Keyboard.enableRepeatEvents(true);
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_949_e.add(new GuiButton(1, field_951_c / 2 - 100, field_950_d - 40, stringtranslate.func_20163_a("multiplayer.stopSleeping")));
    }

    public void func_6449_h()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_580_a(char c, int i)
    {
        if(i == 1)
        {
            func_22115_j();
        } else
        if(i == 28)
        {
            String s = field_985_a.trim();
            if(s.length() > 0)
            {
                field_945_b.field_6322_g.func_461_a(field_985_a.trim());
            }
            field_985_a = "";
        } else
        {
            super.func_580_a(c, i);
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        super.func_571_a(i, j, f);
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(guibutton.field_938_f == 1)
        {
            func_22115_j();
        } else
        {
            super.func_572_a(guibutton);
        }
    }

    private void func_22115_j()
    {
        if(field_945_b.field_6322_g instanceof EntityClientPlayerMP)
        {
            NetClientHandler netclienthandler = ((EntityClientPlayerMP)field_945_b.field_6322_g).field_797_bg;
            netclienthandler.func_847_a(new Packet19EntityAction(field_945_b.field_6322_g, 3));
        }
    }
}
