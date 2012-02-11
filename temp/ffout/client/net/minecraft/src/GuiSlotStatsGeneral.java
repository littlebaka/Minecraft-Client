// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiStats, StatList, StatBase, 
//            StatCollector, StatFileWriter, FontRenderer, Tessellator

class GuiSlotStatsGeneral extends GuiSlot
{

    final GuiStats field_27276_a; /* synthetic field */

    public GuiSlotStatsGeneral(GuiStats guistats)
    {
        field_27276_a = guistats;
        super(GuiStats.func_27141_a(guistats), guistats.field_951_c, guistats.field_950_d, 32, guistats.field_950_d - 64, 10);
        func_27258_a(false);
    }

    protected int func_22249_a()
    {
        return StatList.field_25187_b.size();
    }

    protected void func_22247_a(int i, boolean flag)
    {
    }

    protected boolean func_22246_a(int i)
    {
        return false;
    }

    protected int func_22245_b()
    {
        return func_22249_a() * 10;
    }

    protected void func_22248_c()
    {
        field_27276_a.func_578_i();
    }

    protected void func_22242_a(int i, int j, int k, int l, Tessellator tessellator)
    {
        StatBase statbase = (StatBase)StatList.field_25187_b.get(i);
        field_27276_a.func_547_b(GuiStats.func_27145_b(field_27276_a), StatCollector.func_25200_a(statbase.func_44020_i()), j + 2, k + 1, i % 2 != 0 ? 0x909090 : 0xffffff);
        String s = statbase.func_27084_a(GuiStats.func_27142_c(field_27276_a).func_27184_a(statbase));
        field_27276_a.func_547_b(GuiStats.func_27140_d(field_27276_a), s, (j + 2 + 213) - GuiStats.func_27146_e(field_27276_a).func_871_a(s), k + 1, i % 2 != 0 ? 0x909090 : 0xffffff);
    }
}
