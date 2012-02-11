// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Tessellator, FontRenderer

public class Gui
{

    protected float field_923_k;

    public Gui()
    {
        field_923_k = 0.0F;
    }

    protected void func_27100_a(int i, int j, int k, int l)
    {
        if(j < i)
        {
            int i1 = i;
            i = j;
            j = i1;
        }
        func_551_a(i, k, j + 1, k + 1, l);
    }

    protected void func_27099_b(int i, int j, int k, int l)
    {
        if(k < j)
        {
            int i1 = j;
            j = k;
            k = i1;
        }
        func_551_a(i, j + 1, i + 1, k, l);
    }

    protected void func_551_a(int i, int j, int k, int l, int i1)
    {
        if(i < k)
        {
            int j1 = i;
            i = k;
            k = j1;
        }
        if(j < l)
        {
            int k1 = j;
            j = l;
            l = k1;
        }
        float f = (float)(i1 >> 24 & 0xff) / 255F;
        float f1 = (float)(i1 >> 16 & 0xff) / 255F;
        float f2 = (float)(i1 >> 8 & 0xff) / 255F;
        float f3 = (float)(i1 & 0xff) / 255F;
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        tessellator.func_977_b();
        tessellator.func_991_a(i, l, 0.0D);
        tessellator.func_991_a(k, l, 0.0D);
        tessellator.func_991_a(k, j, 0.0D);
        tessellator.func_991_a(i, j, 0.0D);
        tessellator.func_982_a();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    protected void func_549_a(int i, int j, int k, int l, int i1, int j1)
    {
        float f = (float)(i1 >> 24 & 0xff) / 255F;
        float f1 = (float)(i1 >> 16 & 0xff) / 255F;
        float f2 = (float)(i1 >> 8 & 0xff) / 255F;
        float f3 = (float)(i1 & 0xff) / 255F;
        float f4 = (float)(j1 >> 24 & 0xff) / 255F;
        float f5 = (float)(j1 >> 16 & 0xff) / 255F;
        float f6 = (float)(j1 >> 8 & 0xff) / 255F;
        float f7 = (float)(j1 & 0xff) / 255F;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_986_a(f1, f2, f3, f);
        tessellator.func_991_a(k, j, field_923_k);
        tessellator.func_991_a(i, j, field_923_k);
        tessellator.func_986_a(f5, f6, f7, f4);
        tessellator.func_991_a(i, l, field_923_k);
        tessellator.func_991_a(k, l, field_923_k);
        tessellator.func_982_a();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void func_548_a(FontRenderer fontrenderer, String s, int i, int j, int k)
    {
        fontrenderer.func_874_a(s, i - fontrenderer.func_871_a(s) / 2, j, k);
    }

    public void func_547_b(FontRenderer fontrenderer, String s, int i, int j, int k)
    {
        fontrenderer.func_874_a(s, i, j, k);
    }

    public void func_550_b(int i, int j, int k, int l, int i1, int j1)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(i + 0, j + j1, field_923_k, (float)(k + 0) * f, (float)(l + j1) * f1);
        tessellator.func_983_a(i + i1, j + j1, field_923_k, (float)(k + i1) * f, (float)(l + j1) * f1);
        tessellator.func_983_a(i + i1, j + 0, field_923_k, (float)(k + i1) * f, (float)(l + 0) * f1);
        tessellator.func_983_a(i + 0, j + 0, field_923_k, (float)(k + 0) * f, (float)(l + 0) * f1);
        tessellator.func_982_a();
    }
}
