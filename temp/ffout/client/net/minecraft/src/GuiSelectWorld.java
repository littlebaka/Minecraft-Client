// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiWorldSlot, ISaveFormat, 
//            SaveFormatComparator, MathHelper, GuiButton, GuiYesNo, 
//            GuiCreateWorld, GuiRenameWorld, PlayerControllerSP, PlayerControllerCreative

public class GuiSelectWorld extends GuiScreen
{

    private final DateFormat field_22102_i = new SimpleDateFormat();
    protected GuiScreen field_958_a;
    protected String field_960_h;
    private boolean field_959_i;
    private int field_22101_l;
    private List field_22100_m;
    private GuiWorldSlot field_22099_n;
    private String field_22098_o;
    private String field_22097_p;
    private String field_35316_k[];
    private boolean field_22096_q;
    private GuiButton field_22095_r;
    private GuiButton field_22104_s;
    private GuiButton field_22103_t;

    public GuiSelectWorld(GuiScreen guiscreen)
    {
        field_960_h = "Select world";
        field_959_i = false;
        field_35316_k = new String[2];
        field_958_a = guiscreen;
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_960_h = stringtranslate.func_20163_a("selectWorld.title");
        field_22098_o = stringtranslate.func_20163_a("selectWorld.world");
        field_22097_p = stringtranslate.func_20163_a("selectWorld.conversion");
        field_35316_k[0] = stringtranslate.func_20163_a("gameMode.survival");
        field_35316_k[1] = stringtranslate.func_20163_a("gameMode.creative");
        func_22084_k();
        field_22099_n = new GuiWorldSlot(this);
        field_22099_n.func_22240_a(field_949_e, 4, 5);
        func_585_j();
    }

    private void func_22084_k()
    {
        ISaveFormat isaveformat = field_945_b.func_22004_c();
        field_22100_m = isaveformat.func_22176_b();
        Collections.sort(field_22100_m);
        field_22101_l = -1;
    }

    protected String func_22091_c(int i)
    {
        return ((SaveFormatComparator)field_22100_m.get(i)).func_22164_a();
    }

    protected String func_22094_d(int i)
    {
        String s = ((SaveFormatComparator)field_22100_m.get(i)).func_22162_b();
        if(s == null || MathHelper.func_22282_a(s))
        {
            StringTranslate stringtranslate = StringTranslate.func_20162_a();
            s = (new StringBuilder()).append(stringtranslate.func_20163_a("selectWorld.world")).append(" ").append(i + 1).toString();
        }
        return s;
    }

    public void func_585_j()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_949_e.add(field_22104_s = new GuiButton(1, field_951_c / 2 - 154, field_950_d - 52, 150, 20, stringtranslate.func_20163_a("selectWorld.select")));
        field_949_e.add(field_22103_t = new GuiButton(6, field_951_c / 2 - 154, field_950_d - 28, 70, 20, stringtranslate.func_20163_a("selectWorld.rename")));
        field_949_e.add(field_22095_r = new GuiButton(2, field_951_c / 2 - 74, field_950_d - 28, 70, 20, stringtranslate.func_20163_a("selectWorld.delete")));
        field_949_e.add(new GuiButton(3, field_951_c / 2 + 4, field_950_d - 52, 150, 20, stringtranslate.func_20163_a("selectWorld.create")));
        field_949_e.add(new GuiButton(0, field_951_c / 2 + 4, field_950_d - 28, 150, 20, stringtranslate.func_20163_a("gui.cancel")));
        field_22104_s.field_937_g = false;
        field_22095_r.field_937_g = false;
        field_22103_t.field_937_g = false;
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f == 2)
        {
            String s = func_22094_d(field_22101_l);
            if(s != null)
            {
                field_22096_q = true;
                StringTranslate stringtranslate = StringTranslate.func_20162_a();
                String s1 = stringtranslate.func_20163_a("selectWorld.deleteQuestion");
                String s2 = (new StringBuilder()).append("'").append(s).append("' ").append(stringtranslate.func_20163_a("selectWorld.deleteWarning")).toString();
                String s3 = stringtranslate.func_20163_a("selectWorld.deleteButton");
                String s4 = stringtranslate.func_20163_a("gui.cancel");
                GuiYesNo guiyesno = new GuiYesNo(this, s1, s2, s3, s4, field_22101_l);
                field_945_b.func_6272_a(guiyesno);
            }
        } else
        if(guibutton.field_938_f == 1)
        {
            func_584_c(field_22101_l);
        } else
        if(guibutton.field_938_f == 3)
        {
            field_945_b.func_6272_a(new GuiCreateWorld(this));
        } else
        if(guibutton.field_938_f == 6)
        {
            field_945_b.func_6272_a(new GuiRenameWorld(this, func_22091_c(field_22101_l)));
        } else
        if(guibutton.field_938_f == 0)
        {
            field_945_b.func_6272_a(field_958_a);
        } else
        {
            field_22099_n.func_22241_a(guibutton);
        }
    }

    public void func_584_c(int i)
    {
        field_945_b.func_6272_a(null);
        if(field_959_i)
        {
            return;
        }
        field_959_i = true;
        int j = ((SaveFormatComparator)field_22100_m.get(i)).func_35719_f();
        if(j == 0)
        {
            field_945_b.field_6327_b = new PlayerControllerSP(field_945_b);
        } else
        {
            field_945_b.field_6327_b = new PlayerControllerCreative(field_945_b);
        }
        String s = func_22091_c(i);
        if(s == null)
        {
            s = (new StringBuilder()).append("World").append(i).toString();
        }
        field_945_b.func_6247_b(s, func_22094_d(i), null);
        field_945_b.func_6272_a(null);
    }

    public void func_568_a(boolean flag, int i)
    {
        if(field_22096_q)
        {
            field_22096_q = false;
            if(flag)
            {
                ISaveFormat isaveformat = field_945_b.func_22004_c();
                isaveformat.func_22177_c();
                isaveformat.func_22172_c(func_22091_c(i));
                func_22084_k();
            }
            field_945_b.func_6272_a(this);
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        field_22099_n.func_22243_a(i, j, f);
        func_548_a(field_6451_g, field_960_h, field_951_c / 2, 20, 0xffffff);
        super.func_571_a(i, j, f);
    }

    static List func_22090_a(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22100_m;
    }

    static int func_22089_a(GuiSelectWorld guiselectworld, int i)
    {
        return guiselectworld.field_22101_l = i;
    }

    static int func_22086_b(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22101_l;
    }

    static GuiButton func_22083_c(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22104_s;
    }

    static GuiButton func_22085_d(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22095_r;
    }

    static GuiButton func_22092_e(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22103_t;
    }

    static String func_22087_f(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22098_o;
    }

    static DateFormat func_22093_g(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22102_i;
    }

    static String func_22088_h(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_22097_p;
    }

    static String[] func_35315_i(GuiSelectWorld guiselectworld)
    {
        return guiselectworld.field_35316_k;
    }
}
