// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, ThreadConnectToServer, NetClientHandler, StringTranslate, 
//            GuiButton, GuiMainMenu

public class GuiConnecting extends GuiScreen
{

    private NetClientHandler field_952_a;
    private boolean field_953_h;

    public GuiConnecting(Minecraft minecraft, String s, int i)
    {
        field_953_h = false;
        System.out.println((new StringBuilder()).append("Connecting to ").append(s).append(", ").append(i).toString());
        minecraft.func_6261_a(null);
        (new ThreadConnectToServer(this, minecraft, s, i)).start();
    }

    public void func_570_g()
    {
        if(field_952_a != null)
        {
            field_952_a.func_848_a();
        }
    }

    protected void func_580_a(char c, int i)
    {
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_949_e.clear();
        field_949_e.add(new GuiButton(0, field_951_c / 2 - 100, field_950_d / 4 + 120 + 12, stringtranslate.func_20163_a("gui.cancel")));
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(guibutton.field_938_f == 0)
        {
            field_953_h = true;
            if(field_952_a != null)
            {
                field_952_a.func_849_b();
            }
            field_945_b.func_6272_a(new GuiMainMenu());
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        if(field_952_a == null)
        {
            func_548_a(field_6451_g, stringtranslate.func_20163_a("connect.connecting"), field_951_c / 2, field_950_d / 2 - 50, 0xffffff);
            func_548_a(field_6451_g, "", field_951_c / 2, field_950_d / 2 - 10, 0xffffff);
        } else
        {
            func_548_a(field_6451_g, stringtranslate.func_20163_a("connect.authorizing"), field_951_c / 2, field_950_d / 2 - 50, 0xffffff);
            func_548_a(field_6451_g, field_952_a.field_1209_a, field_951_c / 2, field_950_d / 2 - 10, 0xffffff);
        }
        super.func_571_a(i, j, f);
    }

    static NetClientHandler func_582_a(GuiConnecting guiconnecting, NetClientHandler netclienthandler)
    {
        return guiconnecting.field_952_a = netclienthandler;
    }

    static boolean func_581_a(GuiConnecting guiconnecting)
    {
        return guiconnecting.field_953_h;
    }

    static NetClientHandler func_583_b(GuiConnecting guiconnecting)
    {
        return guiconnecting.field_952_a;
    }
}
