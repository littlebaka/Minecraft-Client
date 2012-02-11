// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiSmallButton, TexturePackList, 
//            GuiTexturePackSlot, GuiButton, RenderEngine, FontRenderer

public class GuiTexturePacks extends GuiScreen
{

    protected GuiScreen field_6461_a;
    private int field_6454_o;
    private String field_6453_p;
    private GuiTexturePackSlot field_22128_k;

    public GuiTexturePacks(GuiScreen guiscreen)
    {
        field_6454_o = -1;
        field_6453_p = "";
        field_6461_a = guiscreen;
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_949_e.add(new GuiSmallButton(5, field_951_c / 2 - 154, field_950_d - 48, stringtranslate.func_20163_a("texturePack.openFolder")));
        field_949_e.add(new GuiSmallButton(6, field_951_c / 2 + 4, field_950_d - 48, stringtranslate.func_20163_a("gui.done")));
        field_945_b.field_6298_C.func_6532_a();
        field_6453_p = (new File(Minecraft.func_6240_b(), "texturepacks")).getAbsolutePath();
        field_22128_k = new GuiTexturePackSlot(this);
        field_22128_k.func_22240_a(field_949_e, 7, 8);
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f == 5)
        {
            Sys.openURL((new StringBuilder()).append("file://").append(field_6453_p).toString());
        } else
        if(guibutton.field_938_f == 6)
        {
            field_945_b.field_6315_n.func_1065_b();
            field_945_b.func_6272_a(field_6461_a);
        } else
        {
            field_22128_k.func_22241_a(guibutton);
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
        field_22128_k.func_22243_a(i, j, f);
        if(field_6454_o <= 0)
        {
            field_945_b.field_6298_C.func_6532_a();
            field_6454_o += 20;
        }
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        func_548_a(field_6451_g, stringtranslate.func_20163_a("texturePack.title"), field_951_c / 2, 16, 0xffffff);
        func_548_a(field_6451_g, stringtranslate.func_20163_a("texturePack.folderInfo"), field_951_c / 2 - 77, field_950_d - 26, 0x808080);
        super.func_571_a(i, j, f);
    }

    public void func_570_g()
    {
        super.func_570_g();
        field_6454_o--;
    }

    static Minecraft func_22124_a(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22126_b(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22119_c(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22122_d(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22117_e(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_35307_f(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_35308_g(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22118_f(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22116_g(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22121_h(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static Minecraft func_22123_i(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_945_b;
    }

    static FontRenderer func_22127_j(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_6451_g;
    }

    static FontRenderer func_22120_k(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_6451_g;
    }

    static FontRenderer func_22125_l(GuiTexturePacks guitexturepacks)
    {
        return guitexturepacks.field_6451_g;
    }
}
