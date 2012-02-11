// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, RenderEngine

public class GuiButton extends Gui
{

    protected int field_935_a;
    protected int field_934_b;
    public int field_941_c;
    public int field_940_d;
    public String field_939_e;
    public int field_938_f;
    public boolean field_937_g;
    public boolean field_936_h;

    public GuiButton(int i, int j, int k, String s)
    {
        this(i, j, k, 200, 20, s);
    }

    public GuiButton(int i, int j, int k, int l, int i1, String s)
    {
        field_935_a = 200;
        field_934_b = 20;
        field_937_g = true;
        field_936_h = true;
        field_938_f = i;
        field_941_c = j;
        field_940_d = k;
        field_935_a = l;
        field_934_b = i1;
        field_939_e = s;
    }

    protected int func_558_a(boolean flag)
    {
        byte byte0 = 1;
        if(!field_937_g)
        {
            byte0 = 0;
        } else
        if(flag)
        {
            byte0 = 2;
        }
        return byte0;
    }

    public void func_561_a(Minecraft minecraft, int i, int j)
    {
        if(!field_936_h)
        {
            return;
        }
        FontRenderer fontrenderer = minecraft.field_6314_o;
        GL11.glBindTexture(3553, minecraft.field_6315_n.func_1070_a("/gui/gui.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = i >= field_941_c && j >= field_940_d && i < field_941_c + field_935_a && j < field_940_d + field_934_b;
        int k = func_558_a(flag);
        func_550_b(field_941_c, field_940_d, 0, 46 + k * 20, field_935_a / 2, field_934_b);
        func_550_b(field_941_c + field_935_a / 2, field_940_d, 200 - field_935_a / 2, 46 + k * 20, field_935_a / 2, field_934_b);
        func_560_b(minecraft, i, j);
        if(!field_937_g)
        {
            func_548_a(fontrenderer, field_939_e, field_941_c + field_935_a / 2, field_940_d + (field_934_b - 8) / 2, 0xffa0a0a0);
        } else
        if(flag)
        {
            func_548_a(fontrenderer, field_939_e, field_941_c + field_935_a / 2, field_940_d + (field_934_b - 8) / 2, 0xffffa0);
        } else
        {
            func_548_a(fontrenderer, field_939_e, field_941_c + field_935_a / 2, field_940_d + (field_934_b - 8) / 2, 0xe0e0e0);
        }
    }

    protected void func_560_b(Minecraft minecraft, int i, int j)
    {
    }

    public void func_559_a(int i, int j)
    {
    }

    public boolean func_562_c(Minecraft minecraft, int i, int j)
    {
        return field_937_g && field_936_h && i >= field_941_c && j >= field_940_d && i < field_941_c + field_935_a && j < field_940_d + field_934_b;
    }
}
