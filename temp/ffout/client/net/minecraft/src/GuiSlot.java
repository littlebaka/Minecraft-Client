// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, Tessellator, RenderEngine

public abstract class GuiSlot
{

    private final Minecraft field_22264_a;
    private final int field_22263_b;
    private final int field_22262_c;
    protected final int field_22261_d;
    protected final int field_22260_e;
    private final int field_22259_f;
    private final int field_22258_g = 0;
    protected final int field_22257_h;
    private int field_22256_i;
    private int field_22255_j;
    protected int field_35409_k;
    protected int field_35408_l;
    private float field_22254_k;
    private float field_22253_l;
    private float field_22252_m;
    private int field_22251_n;
    private long field_22250_o;
    private boolean field_25123_p;
    private boolean field_27262_q;
    private int field_27261_r;

    public GuiSlot(Minecraft minecraft, int i, int j, int k, int l, int i1)
    {
        field_22254_k = -2F;
        field_22251_n = -1;
        field_22250_o = 0L;
        field_25123_p = true;
        field_22264_a = minecraft;
        field_22263_b = i;
        field_22262_c = j;
        field_22261_d = k;
        field_22260_e = l;
        field_22257_h = i1;
        field_22259_f = i;
    }

    public void func_27258_a(boolean flag)
    {
        field_25123_p = flag;
    }

    protected void func_27259_a(boolean flag, int i)
    {
        field_27262_q = flag;
        field_27261_r = i;
        if(!flag)
        {
            field_27261_r = 0;
        }
    }

    protected abstract int func_22249_a();

    protected abstract void func_22247_a(int i, boolean flag);

    protected abstract boolean func_22246_a(int i);

    protected int func_22245_b()
    {
        return func_22249_a() * field_22257_h + field_27261_r;
    }

    protected abstract void func_22248_c();

    protected abstract void func_22242_a(int i, int j, int k, int l, Tessellator tessellator);

    protected void func_27260_a(int i, int j, Tessellator tessellator)
    {
    }

    protected void func_27255_a(int i, int j)
    {
    }

    protected void func_27257_b(int i, int j)
    {
    }

    public int func_27256_c(int i, int j)
    {
        int k = field_22263_b / 2 - 110;
        int l = field_22263_b / 2 + 110;
        int i1 = ((j - field_22261_d - field_27261_r) + (int)field_22252_m) - 4;
        int j1 = i1 / field_22257_h;
        if(i >= k && i <= l && j1 >= 0 && i1 >= 0 && j1 < func_22249_a())
        {
            return j1;
        } else
        {
            return -1;
        }
    }

    public void func_22240_a(List list, int i, int j)
    {
        field_22256_i = i;
        field_22255_j = j;
    }

    private void func_22244_d()
    {
        int i = func_22245_b() - (field_22260_e - field_22261_d - 4);
        if(i < 0)
        {
            i /= 2;
        }
        if(field_22252_m < 0.0F)
        {
            field_22252_m = 0.0F;
        }
        if(field_22252_m > (float)i)
        {
            field_22252_m = i;
        }
    }

    public void func_22241_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f == field_22256_i)
        {
            field_22252_m -= (field_22257_h * 2) / 3;
            field_22254_k = -2F;
            func_22244_d();
        } else
        if(guibutton.field_938_f == field_22255_j)
        {
            field_22252_m += (field_22257_h * 2) / 3;
            field_22254_k = -2F;
            func_22244_d();
        }
    }

    public void func_22243_a(int i, int j, float f)
    {
        field_35409_k = i;
        field_35408_l = j;
        func_22248_c();
        int k = func_22249_a();
        int l = field_22263_b / 2 + 124;
        int i1 = l + 6;
        if(Mouse.isButtonDown(0))
        {
            if(field_22254_k == -1F)
            {
                boolean flag = true;
                if(j >= field_22261_d && j <= field_22260_e)
                {
                    int k1 = field_22263_b / 2 - 110;
                    int l1 = field_22263_b / 2 + 110;
                    int j2 = ((j - field_22261_d - field_27261_r) + (int)field_22252_m) - 4;
                    int l2 = j2 / field_22257_h;
                    if(i >= k1 && i <= l1 && l2 >= 0 && j2 >= 0 && l2 < k)
                    {
                        boolean flag1 = l2 == field_22251_n && System.currentTimeMillis() - field_22250_o < 250L;
                        func_22247_a(l2, flag1);
                        field_22251_n = l2;
                        field_22250_o = System.currentTimeMillis();
                    } else
                    if(i >= k1 && i <= l1 && j2 < 0)
                    {
                        func_27255_a(i - k1, ((j - field_22261_d) + (int)field_22252_m) - 4);
                        flag = false;
                    }
                    if(i >= l && i <= i1)
                    {
                        field_22253_l = -1F;
                        int j3 = func_22245_b() - (field_22260_e - field_22261_d - 4);
                        if(j3 < 1)
                        {
                            j3 = 1;
                        }
                        int i4 = (int)((float)((field_22260_e - field_22261_d) * (field_22260_e - field_22261_d)) / (float)func_22245_b());
                        if(i4 < 32)
                        {
                            i4 = 32;
                        }
                        if(i4 > field_22260_e - field_22261_d - 8)
                        {
                            i4 = field_22260_e - field_22261_d - 8;
                        }
                        field_22253_l /= (float)(field_22260_e - field_22261_d - i4) / (float)j3;
                    } else
                    {
                        field_22253_l = 1.0F;
                    }
                    if(flag)
                    {
                        field_22254_k = j;
                    } else
                    {
                        field_22254_k = -2F;
                    }
                } else
                {
                    field_22254_k = -2F;
                }
            } else
            if(field_22254_k >= 0.0F)
            {
                field_22252_m -= ((float)j - field_22254_k) * field_22253_l;
                field_22254_k = j;
            }
        } else
        {
            do
            {
                if(!Mouse.next())
                {
                    break;
                }
                int j1 = Mouse.getEventDWheel();
                if(j1 != 0)
                {
                    if(j1 > 0)
                    {
                        j1 = -1;
                    } else
                    if(j1 < 0)
                    {
                        j1 = 1;
                    }
                    field_22252_m += (j1 * field_22257_h) / 2;
                }
            } while(true);
            field_22254_k = -1F;
        }
        func_22244_d();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, field_22264_a.field_6315_n.func_1070_a("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f1 = 32F;
        tessellator.func_977_b();
        tessellator.func_990_b(0x202020);
        tessellator.func_983_a(field_22258_g, field_22260_e, 0.0D, (float)field_22258_g / f1, (float)(field_22260_e + (int)field_22252_m) / f1);
        tessellator.func_983_a(field_22259_f, field_22260_e, 0.0D, (float)field_22259_f / f1, (float)(field_22260_e + (int)field_22252_m) / f1);
        tessellator.func_983_a(field_22259_f, field_22261_d, 0.0D, (float)field_22259_f / f1, (float)(field_22261_d + (int)field_22252_m) / f1);
        tessellator.func_983_a(field_22258_g, field_22261_d, 0.0D, (float)field_22258_g / f1, (float)(field_22261_d + (int)field_22252_m) / f1);
        tessellator.func_982_a();
        int i2 = field_22263_b / 2 - 92 - 16;
        int k2 = (field_22261_d + 4) - (int)field_22252_m;
        if(field_27262_q)
        {
            func_27260_a(i2, k2, tessellator);
        }
        for(int i3 = 0; i3 < k; i3++)
        {
            int k3 = k2 + i3 * field_22257_h + field_27261_r;
            int j4 = field_22257_h - 4;
            if(k3 > field_22260_e || k3 + j4 < field_22261_d)
            {
                continue;
            }
            if(field_25123_p && func_22246_a(i3))
            {
                int l4 = field_22263_b / 2 - 110;
                int j5 = field_22263_b / 2 + 110;
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(3553);
                tessellator.func_977_b();
                tessellator.func_990_b(0x808080);
                tessellator.func_983_a(l4, k3 + j4 + 2, 0.0D, 0.0D, 1.0D);
                tessellator.func_983_a(j5, k3 + j4 + 2, 0.0D, 1.0D, 1.0D);
                tessellator.func_983_a(j5, k3 - 2, 0.0D, 1.0D, 0.0D);
                tessellator.func_983_a(l4, k3 - 2, 0.0D, 0.0D, 0.0D);
                tessellator.func_990_b(0);
                tessellator.func_983_a(l4 + 1, k3 + j4 + 1, 0.0D, 0.0D, 1.0D);
                tessellator.func_983_a(j5 - 1, k3 + j4 + 1, 0.0D, 1.0D, 1.0D);
                tessellator.func_983_a(j5 - 1, k3 - 1, 0.0D, 1.0D, 0.0D);
                tessellator.func_983_a(l4 + 1, k3 - 1, 0.0D, 0.0D, 0.0D);
                tessellator.func_982_a();
                GL11.glEnable(3553);
            }
            func_22242_a(i3, i2, k3, j4, tessellator);
        }

        GL11.glDisable(2929);
        byte byte0 = 4;
        func_22239_a(0, field_22261_d, 255, 255);
        func_22239_a(field_22260_e, field_22262_c, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        tessellator.func_977_b();
        tessellator.func_6513_a(0, 0);
        tessellator.func_983_a(field_22258_g, field_22261_d + byte0, 0.0D, 0.0D, 1.0D);
        tessellator.func_983_a(field_22259_f, field_22261_d + byte0, 0.0D, 1.0D, 1.0D);
        tessellator.func_6513_a(0, 255);
        tessellator.func_983_a(field_22259_f, field_22261_d, 0.0D, 1.0D, 0.0D);
        tessellator.func_983_a(field_22258_g, field_22261_d, 0.0D, 0.0D, 0.0D);
        tessellator.func_982_a();
        tessellator.func_977_b();
        tessellator.func_6513_a(0, 255);
        tessellator.func_983_a(field_22258_g, field_22260_e, 0.0D, 0.0D, 1.0D);
        tessellator.func_983_a(field_22259_f, field_22260_e, 0.0D, 1.0D, 1.0D);
        tessellator.func_6513_a(0, 0);
        tessellator.func_983_a(field_22259_f, field_22260_e - byte0, 0.0D, 1.0D, 0.0D);
        tessellator.func_983_a(field_22258_g, field_22260_e - byte0, 0.0D, 0.0D, 0.0D);
        tessellator.func_982_a();
        int l3 = func_22245_b() - (field_22260_e - field_22261_d - 4);
        if(l3 > 0)
        {
            int k4 = ((field_22260_e - field_22261_d) * (field_22260_e - field_22261_d)) / func_22245_b();
            if(k4 < 32)
            {
                k4 = 32;
            }
            if(k4 > field_22260_e - field_22261_d - 8)
            {
                k4 = field_22260_e - field_22261_d - 8;
            }
            int i5 = ((int)field_22252_m * (field_22260_e - field_22261_d - k4)) / l3 + field_22261_d;
            if(i5 < field_22261_d)
            {
                i5 = field_22261_d;
            }
            tessellator.func_977_b();
            tessellator.func_6513_a(0, 255);
            tessellator.func_983_a(l, field_22260_e, 0.0D, 0.0D, 1.0D);
            tessellator.func_983_a(i1, field_22260_e, 0.0D, 1.0D, 1.0D);
            tessellator.func_983_a(i1, field_22261_d, 0.0D, 1.0D, 0.0D);
            tessellator.func_983_a(l, field_22261_d, 0.0D, 0.0D, 0.0D);
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_6513_a(0x808080, 255);
            tessellator.func_983_a(l, i5 + k4, 0.0D, 0.0D, 1.0D);
            tessellator.func_983_a(i1, i5 + k4, 0.0D, 1.0D, 1.0D);
            tessellator.func_983_a(i1, i5, 0.0D, 1.0D, 0.0D);
            tessellator.func_983_a(l, i5, 0.0D, 0.0D, 0.0D);
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_6513_a(0xc0c0c0, 255);
            tessellator.func_983_a(l, (i5 + k4) - 1, 0.0D, 0.0D, 1.0D);
            tessellator.func_983_a(i1 - 1, (i5 + k4) - 1, 0.0D, 1.0D, 1.0D);
            tessellator.func_983_a(i1 - 1, i5, 0.0D, 1.0D, 0.0D);
            tessellator.func_983_a(l, i5, 0.0D, 0.0D, 0.0D);
            tessellator.func_982_a();
        }
        func_27257_b(i, j);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    private void func_22239_a(int i, int j, int k, int l)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, field_22264_a.field_6315_n.func_1070_a("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32F;
        tessellator.func_977_b();
        tessellator.func_6513_a(0x404040, l);
        tessellator.func_983_a(0.0D, j, 0.0D, 0.0D, (float)j / f);
        tessellator.func_983_a(field_22263_b, j, 0.0D, (float)field_22263_b / f, (float)j / f);
        tessellator.func_6513_a(0x404040, k);
        tessellator.func_983_a(field_22263_b, i, 0.0D, (float)field_22263_b / f, (float)i / f);
        tessellator.func_983_a(0.0D, i, 0.0D, 0.0D, (float)i / f);
        tessellator.func_982_a();
    }
}
