// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StatCollector, GuiSlotStatsGeneral, GuiSlotStatsItem, 
//            GuiSlotStatsBlock, StringTranslate, GuiButton, GuiSlot, 
//            RenderHelper, Item, RenderItem, RenderEngine, 
//            Tessellator, StatFileWriter, FontRenderer

public class GuiStats extends GuiScreen
{

    private static RenderItem field_27153_j = new RenderItem();
    protected GuiScreen field_27152_a;
    protected String field_27154_i;
    private GuiSlotStatsGeneral field_27151_l;
    private GuiSlotStatsItem field_27150_m;
    private GuiSlotStatsBlock field_27157_n;
    private StatFileWriter field_27156_o;
    private GuiSlot field_27155_p;

    public GuiStats(GuiScreen guiscreen, StatFileWriter statfilewriter)
    {
        field_27154_i = "Select world";
        field_27155_p = null;
        field_27152_a = guiscreen;
        field_27156_o = statfilewriter;
    }

    public void func_6448_a()
    {
        field_27154_i = StatCollector.func_25200_a("gui.stats");
        field_27151_l = new GuiSlotStatsGeneral(this);
        field_27151_l.func_22240_a(field_949_e, 1, 1);
        field_27150_m = new GuiSlotStatsItem(this);
        field_27150_m.func_22240_a(field_949_e, 1, 1);
        field_27157_n = new GuiSlotStatsBlock(this);
        field_27157_n.func_22240_a(field_949_e, 1, 1);
        field_27155_p = field_27151_l;
        func_27130_k();
    }

    public void func_27130_k()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_949_e.add(new GuiButton(0, field_951_c / 2 + 4, field_950_d - 28, 150, 20, stringtranslate.func_20163_a("gui.done")));
        field_949_e.add(new GuiButton(1, field_951_c / 2 - 154, field_950_d - 52, 100, 20, stringtranslate.func_20163_a("stat.generalButton")));
        GuiButton guibutton;
        field_949_e.add(guibutton = new GuiButton(2, field_951_c / 2 - 46, field_950_d - 52, 100, 20, stringtranslate.func_20163_a("stat.blocksButton")));
        GuiButton guibutton1;
        field_949_e.add(guibutton1 = new GuiButton(3, field_951_c / 2 + 62, field_950_d - 52, 100, 20, stringtranslate.func_20163_a("stat.itemsButton")));
        if(field_27157_n.func_22249_a() == 0)
        {
            guibutton.field_937_g = false;
        }
        if(field_27150_m.func_22249_a() == 0)
        {
            guibutton1.field_937_g = false;
        }
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f == 0)
        {
            field_945_b.func_6272_a(field_27152_a);
        } else
        if(guibutton.field_938_f == 1)
        {
            field_27155_p = field_27151_l;
        } else
        if(guibutton.field_938_f == 3)
        {
            field_27155_p = field_27150_m;
        } else
        if(guibutton.field_938_f == 2)
        {
            field_27155_p = field_27157_n;
        } else
        {
            field_27155_p.func_22241_a(guibutton);
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        field_27155_p.func_22243_a(i, j, f);
        func_548_a(field_6451_g, field_27154_i, field_951_c / 2, 20, 0xffffff);
        super.func_571_a(i, j, f);
    }

    private void func_27138_c(int i, int j, int k)
    {
        func_27147_a(i + 1, j + 1);
        GL11.glEnable(32826);
        RenderHelper.func_41089_c();
        field_27153_j.func_27003_a(field_6451_g, field_945_b.field_6315_n, k, 0, Item.field_233_c[k].func_27009_a(0), i + 2, j + 2);
        RenderHelper.func_1159_a();
        GL11.glDisable(32826);
    }

    private void func_27147_a(int i, int j)
    {
        func_27136_c(i, j, 0, 0);
    }

    private void func_27136_c(int i, int j, int k, int l)
    {
        int i1 = field_945_b.field_6315_n.func_1070_a("/gui/slot.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_945_b.field_6315_n.func_1076_b(i1);
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(i + 0, j + 18, field_923_k, (float)(k + 0) * 0.0078125F, (float)(l + 18) * 0.0078125F);
        tessellator.func_983_a(i + 18, j + 18, field_923_k, (float)(k + 18) * 0.0078125F, (float)(l + 18) * 0.0078125F);
        tessellator.func_983_a(i + 18, j + 0, field_923_k, (float)(k + 18) * 0.0078125F, (float)(l + 0) * 0.0078125F);
        tessellator.func_983_a(i + 0, j + 0, field_923_k, (float)(k + 0) * 0.0078125F, (float)(l + 0) * 0.0078125F);
        tessellator.func_982_a();
    }

    static Minecraft func_27141_a(GuiStats guistats)
    {
        return guistats.field_945_b;
    }

    static FontRenderer func_27145_b(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static StatFileWriter func_27142_c(GuiStats guistats)
    {
        return guistats.field_27156_o;
    }

    static FontRenderer func_27140_d(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static FontRenderer func_27146_e(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static Minecraft func_27143_f(GuiStats guistats)
    {
        return guistats.field_945_b;
    }

    static void func_27128_a(GuiStats guistats, int i, int j, int k, int l)
    {
        guistats.func_27136_c(i, j, k, l);
    }

    static Minecraft func_27149_g(GuiStats guistats)
    {
        return guistats.field_945_b;
    }

    static FontRenderer func_27133_h(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static FontRenderer func_27137_i(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static FontRenderer func_27132_j(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static FontRenderer func_27134_k(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static FontRenderer func_27139_l(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static void func_27129_a(GuiStats guistats, int i, int j, int k, int l, int i1, int j1)
    {
        guistats.func_549_a(i, j, k, l, i1, j1);
    }

    static FontRenderer func_27144_m(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static FontRenderer func_27127_n(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static void func_27135_b(GuiStats guistats, int i, int j, int k, int l, int i1, int j1)
    {
        guistats.func_549_a(i, j, k, l, i1, j1);
    }

    static FontRenderer func_27131_o(GuiStats guistats)
    {
        return guistats.field_6451_g;
    }

    static void func_27148_a(GuiStats guistats, int i, int j, int k)
    {
        guistats.func_27138_c(i, j, k);
    }

}
