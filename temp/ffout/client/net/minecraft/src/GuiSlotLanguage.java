// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiLanguage, StringTranslate, FontRenderer, 
//            GameSettings, GuiSmallButton, Tessellator

class GuiSlotLanguage extends GuiSlot
{

    private ArrayList field_44013_b;
    private TreeMap field_44014_c;
    final GuiLanguage field_44015_a; /* synthetic field */

    public GuiSlotLanguage(GuiLanguage guilanguage)
    {
        field_44015_a = guilanguage;
        super(guilanguage.field_945_b, guilanguage.field_951_c, guilanguage.field_950_d, 32, (guilanguage.field_950_d - 65) + 4, 18);
        field_44014_c = StringTranslate.func_20162_a().func_44022_b();
        field_44013_b = new ArrayList();
        String s;
        for(Iterator iterator = field_44014_c.keySet().iterator(); iterator.hasNext(); field_44013_b.add(s))
        {
            s = (String)iterator.next();
        }

    }

    protected int func_22249_a()
    {
        return field_44013_b.size();
    }

    protected void func_22247_a(int i, boolean flag)
    {
        StringTranslate.func_20162_a().func_44023_a((String)field_44013_b.get(i));
        field_44015_a.field_945_b.field_6314_o.func_44032_a(StringTranslate.func_20162_a().func_46110_d());
        GuiLanguage.func_44005_a(field_44015_a).field_44018_Q = (String)field_44013_b.get(i);
        field_44015_a.field_6451_g.func_46123_b(StringTranslate.func_46109_d(GuiLanguage.func_44005_a(field_44015_a).field_44018_Q));
        GuiLanguage.func_46028_b(field_44015_a).field_939_e = StringTranslate.func_20162_a().func_20163_a("gui.done");
    }

    protected boolean func_22246_a(int i)
    {
        return ((String)field_44013_b.get(i)).equals(StringTranslate.func_20162_a().func_44024_c());
    }

    protected int func_22245_b()
    {
        return func_22249_a() * 18;
    }

    protected void func_22248_c()
    {
        field_44015_a.func_578_i();
    }

    protected void func_22242_a(int i, int j, int k, int l, Tessellator tessellator)
    {
        field_44015_a.field_6451_g.func_46123_b(true);
        field_44015_a.func_548_a(field_44015_a.field_6451_g, (String)field_44014_c.get(field_44013_b.get(i)), field_44015_a.field_951_c / 2, k + 1, 0xffffff);
        field_44015_a.field_6451_g.func_46123_b(StringTranslate.func_46109_d(GuiLanguage.func_44005_a(field_44015_a).field_44018_Q));
    }
}
