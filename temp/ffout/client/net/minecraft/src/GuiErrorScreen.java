// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton

public class GuiErrorScreen extends GuiScreen
{

    private int field_28098_a;

    public GuiErrorScreen()
    {
        field_28098_a = 0;
    }

    public void func_570_g()
    {
        field_28098_a++;
    }

    public void func_6448_a()
    {
    }

    protected void func_572_a(GuiButton guibutton)
    {
    }

    protected void func_580_a(char c, int i)
    {
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        func_548_a(field_6451_g, "Out of memory!", field_951_c / 2, (field_950_d / 4 - 60) + 20, 0xffffff);
        func_547_b(field_6451_g, "Minecraft has run out of memory.", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 0, 0xa0a0a0);
        func_547_b(field_6451_g, "This could be caused by a bug in the game or by the", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 18, 0xa0a0a0);
        func_547_b(field_6451_g, "Java Virtual Machine not being allocated enough", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 27, 0xa0a0a0);
        func_547_b(field_6451_g, "memory. If you are playing in a web browser, try", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 36, 0xa0a0a0);
        func_547_b(field_6451_g, "downloading the game and playing it offline.", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 45, 0xa0a0a0);
        func_547_b(field_6451_g, "To prevent level corruption, the current game has quit.", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 63, 0xa0a0a0);
        func_547_b(field_6451_g, "Please restart the game.", field_951_c / 2 - 140, (field_950_d / 4 - 60) + 60 + 81, 0xa0a0a0);
        super.func_571_a(i, j, f);
    }
}
