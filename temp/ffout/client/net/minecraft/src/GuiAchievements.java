// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, AchievementList, Achievement, GuiSmallButton, 
//            StatCollector, GuiButton, GameSettings, KeyBinding, 
//            FontRenderer, MathHelper, RenderEngine, Block, 
//            StatFileWriter, RenderItem, RenderHelper

public class GuiAchievements extends GuiScreen
{

    private static final int field_27126_s;
    private static final int field_27125_t;
    private static final int field_27124_u;
    private static final int field_27123_v;
    protected int field_27121_a;
    protected int field_27119_i;
    protected int field_27118_j;
    protected int field_27117_l;
    protected double field_27116_m;
    protected double field_27115_n;
    protected double field_27114_o;
    protected double field_27113_p;
    protected double field_27112_q;
    protected double field_27111_r;
    private int field_27122_w;
    private StatFileWriter field_27120_x;

    public GuiAchievements(StatFileWriter statfilewriter)
    {
        field_27121_a = 256;
        field_27119_i = 202;
        field_27118_j = 0;
        field_27117_l = 0;
        field_27122_w = 0;
        field_27120_x = statfilewriter;
        char c = '\215';
        char c1 = '\215';
        field_27116_m = field_27114_o = field_27112_q = AchievementList.field_25195_b.field_25075_a * 24 - c / 2 - 12;
        field_27115_n = field_27113_p = field_27111_r = AchievementList.field_25195_b.field_25074_b * 24 - c1 / 2;
    }

    public void func_6448_a()
    {
        field_949_e.clear();
        field_949_e.add(new GuiSmallButton(1, field_951_c / 2 + 24, field_950_d / 2 + 74, 80, 20, StatCollector.func_25200_a("gui.done")));
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(guibutton.field_938_f == 1)
        {
            field_945_b.func_6272_a(null);
            field_945_b.func_6259_e();
        }
        super.func_572_a(guibutton);
    }

    protected void func_580_a(char c, int i)
    {
        if(i == field_945_b.field_6304_y.field_1570_o.field_1370_b)
        {
            field_945_b.func_6272_a(null);
            field_945_b.func_6259_e();
        } else
        {
            super.func_580_a(c, i);
        }
    }

    public void func_571_a(int i, int j, float f)
    {
        if(Mouse.isButtonDown(0))
        {
            int k = (field_951_c - field_27121_a) / 2;
            int l = (field_950_d - field_27119_i) / 2;
            int i1 = k + 8;
            int j1 = l + 17;
            if((field_27122_w == 0 || field_27122_w == 1) && i >= i1 && i < i1 + 224 && j >= j1 && j < j1 + 155)
            {
                if(field_27122_w == 0)
                {
                    field_27122_w = 1;
                } else
                {
                    field_27114_o -= i - field_27118_j;
                    field_27113_p -= j - field_27117_l;
                    field_27112_q = field_27116_m = field_27114_o;
                    field_27111_r = field_27115_n = field_27113_p;
                }
                field_27118_j = i;
                field_27117_l = j;
            }
            if(field_27112_q < (double)field_27126_s)
            {
                field_27112_q = field_27126_s;
            }
            if(field_27111_r < (double)field_27125_t)
            {
                field_27111_r = field_27125_t;
            }
            if(field_27112_q >= (double)field_27124_u)
            {
                field_27112_q = field_27124_u - 1;
            }
            if(field_27111_r >= (double)field_27123_v)
            {
                field_27111_r = field_27123_v - 1;
            }
        } else
        {
            field_27122_w = 0;
        }
        func_578_i();
        func_27109_b(i, j, f);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        func_27110_k();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    public void func_570_g()
    {
        field_27116_m = field_27114_o;
        field_27115_n = field_27113_p;
        double d = field_27112_q - field_27114_o;
        double d1 = field_27111_r - field_27113_p;
        if(d * d + d1 * d1 < 4D)
        {
            field_27114_o += d;
            field_27113_p += d1;
        } else
        {
            field_27114_o += d * 0.84999999999999998D;
            field_27113_p += d1 * 0.84999999999999998D;
        }
    }

    protected void func_27110_k()
    {
        int i = (field_951_c - field_27121_a) / 2;
        int j = (field_950_d - field_27119_i) / 2;
        field_6451_g.func_873_b("Achievements", i + 15, j + 5, 0x404040);
    }

    protected void func_27109_b(int i, int j, float f)
    {
        int k = MathHelper.func_1108_b(field_27116_m + (field_27114_o - field_27116_m) * (double)f);
        int l = MathHelper.func_1108_b(field_27115_n + (field_27113_p - field_27115_n) * (double)f);
        if(k < field_27126_s)
        {
            k = field_27126_s;
        }
        if(l < field_27125_t)
        {
            l = field_27125_t;
        }
        if(k >= field_27124_u)
        {
            k = field_27124_u - 1;
        }
        if(l >= field_27123_v)
        {
            l = field_27123_v - 1;
        }
        int i1 = field_945_b.field_6315_n.func_1070_a("/terrain.png");
        int j1 = field_945_b.field_6315_n.func_1070_a("/achievement/bg.png");
        int k1 = (field_951_c - field_27121_a) / 2;
        int l1 = (field_950_d - field_27119_i) / 2;
        int i2 = k1 + 16;
        int j2 = l1 + 17;
        field_923_k = 0.0F;
        GL11.glDepthFunc(518);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glEnable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        field_945_b.field_6315_n.func_1076_b(i1);
        int k2 = k + 288 >> 4;
        int i3 = l + 288 >> 4;
        int j3 = (k + 288) % 16;
        int i4 = (l + 288) % 16;
        Random random = new Random();
        for(int l7 = 0; l7 * 16 - i4 < 155; l7++)
        {
            float f5 = 0.6F - ((float)(i3 + l7) / 25F) * 0.3F;
            GL11.glColor4f(f5, f5, f5, 1.0F);
            for(int i8 = 0; i8 * 16 - j3 < 224; i8++)
            {
                random.setSeed(1234 + k2 + i8);
                random.nextInt();
                int j8 = random.nextInt(1 + i3 + l7) + (i3 + l7) / 2;
                int k8 = Block.field_393_F.field_378_bb;
                if(j8 > 37 || i3 + l7 == 35)
                {
                    k8 = Block.field_403_A.field_378_bb;
                } else
                if(j8 == 22)
                {
                    if(random.nextInt(2) == 0)
                    {
                        k8 = Block.field_391_ax.field_378_bb;
                    } else
                    {
                        k8 = Block.field_433_aO.field_378_bb;
                    }
                } else
                if(j8 == 10)
                {
                    k8 = Block.field_388_I.field_378_bb;
                } else
                if(j8 == 8)
                {
                    k8 = Block.field_386_J.field_378_bb;
                } else
                if(j8 > 4)
                {
                    k8 = Block.field_338_u.field_378_bb;
                } else
                if(j8 > 0)
                {
                    k8 = Block.field_336_w.field_378_bb;
                }
                func_550_b((i2 + i8 * 16) - j3, (j2 + l7 * 16) - i4, k8 % 16 << 4, (k8 >> 4) << 4, 16, 16);
            }

        }

        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553);
        for(int l2 = 0; l2 < AchievementList.field_27388_e.size(); l2++)
        {
            Achievement achievement1 = (Achievement)AchievementList.field_27388_e.get(l2);
            if(achievement1.field_25076_c == null)
            {
                continue;
            }
            int k3 = (achievement1.field_25075_a * 24 - k) + 11 + i2;
            int j4 = (achievement1.field_25074_b * 24 - l) + 11 + j2;
            int k4 = (achievement1.field_25076_c.field_25075_a * 24 - k) + 11 + i2;
            int i5 = (achievement1.field_25076_c.field_25074_b * 24 - l) + 11 + j2;
            int l5 = 0;
            boolean flag = field_27120_x.func_27183_a(achievement1);
            boolean flag1 = field_27120_x.func_27181_b(achievement1);
            char c = Math.sin(((double)(System.currentTimeMillis() % 600L) / 600D) * 3.1415926535897931D * 2D) <= 0.59999999999999998D ? '\202' : '\377';
            if(flag)
            {
                l5 = 0xff707070;
            } else
            if(flag1)
            {
                l5 = 65280 + (c << 24);
            } else
            {
                l5 = 0xff000000;
            }
            func_27100_a(k3, k4, j4, l5);
            func_27099_b(k4, j4, i5, l5);
        }

        Achievement achievement = null;
        RenderItem renderitem = new RenderItem();
        RenderHelper.func_41089_c();
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        for(int l3 = 0; l3 < AchievementList.field_27388_e.size(); l3++)
        {
            Achievement achievement3 = (Achievement)AchievementList.field_27388_e.get(l3);
            int l4 = achievement3.field_25075_a * 24 - k;
            int j5 = achievement3.field_25074_b * 24 - l;
            if(l4 < -24 || j5 < -24 || l4 > 224 || j5 > 155)
            {
                continue;
            }
            if(field_27120_x.func_27183_a(achievement3))
            {
                float f1 = 1.0F;
                GL11.glColor4f(f1, f1, f1, 1.0F);
            } else
            if(field_27120_x.func_27181_b(achievement3))
            {
                float f2 = Math.sin(((double)(System.currentTimeMillis() % 600L) / 600D) * 3.1415926535897931D * 2D) >= 0.59999999999999998D ? 0.8F : 0.6F;
                GL11.glColor4f(f2, f2, f2, 1.0F);
            } else
            {
                float f3 = 0.3F;
                GL11.glColor4f(f3, f3, f3, 1.0F);
            }
            field_945_b.field_6315_n.func_1076_b(j1);
            int i6 = i2 + l4;
            int k6 = j2 + j5;
            if(achievement3.func_27093_f())
            {
                func_550_b(i6 - 2, k6 - 2, 26, 202, 26, 26);
            } else
            {
                func_550_b(i6 - 2, k6 - 2, 0, 202, 26, 26);
            }
            if(!field_27120_x.func_27181_b(achievement3))
            {
                float f4 = 0.1F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                renderitem.field_27004_a = false;
            }
            GL11.glEnable(2896);
            GL11.glEnable(2884);
            renderitem.func_161_a(field_945_b.field_6314_o, field_945_b.field_6315_n, achievement3.field_27097_d, i6 + 3, k6 + 3);
            GL11.glDisable(2896);
            if(!field_27120_x.func_27181_b(achievement3))
            {
                renderitem.field_27004_a = true;
            }
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(i >= i2 && j >= j2 && i < i2 + 224 && j < j2 + 155 && i >= i6 && i <= i6 + 22 && j >= k6 && j <= k6 + 22)
            {
                achievement = achievement3;
            }
        }

        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_945_b.field_6315_n.func_1076_b(j1);
        func_550_b(k1, l1, 0, 0, field_27121_a, field_27119_i);
        GL11.glPopMatrix();
        field_923_k = 0.0F;
        GL11.glDepthFunc(515);
        GL11.glDisable(2929);
        GL11.glEnable(3553);
        super.func_571_a(i, j, f);
        if(achievement != null)
        {
            Achievement achievement2 = achievement;
            String s = StatCollector.func_25200_a(achievement2.func_44020_i());
            String s1 = achievement2.func_27090_e();
            int k5 = i + 12;
            int j6 = j - 4;
            if(field_27120_x.func_27181_b(achievement2))
            {
                int l6 = Math.max(field_6451_g.func_871_a(s), 120);
                int j7 = field_6451_g.func_27277_a(s1, l6);
                if(field_27120_x.func_27183_a(achievement2))
                {
                    j7 += 12;
                }
                func_549_a(k5 - 3, j6 - 3, k5 + l6 + 3, j6 + j7 + 3 + 12, 0xc0000000, 0xc0000000);
                field_6451_g.func_27278_a(s1, k5, j6 + 12, l6, 0xffa0a0a0);
                if(field_27120_x.func_27183_a(achievement2))
                {
                    field_6451_g.func_874_a(StatCollector.func_25200_a("achievement.taken"), k5, j6 + j7 + 4, 0xff9090ff);
                }
            } else
            {
                int i7 = Math.max(field_6451_g.func_871_a(s), 120);
                String s2 = StatCollector.func_25199_a("achievement.requires", new Object[] {
                    StatCollector.func_25200_a(achievement2.field_25076_c.func_44020_i())
                });
                int k7 = field_6451_g.func_27277_a(s2, i7);
                func_549_a(k5 - 3, j6 - 3, k5 + i7 + 3, j6 + k7 + 12 + 3, 0xc0000000, 0xc0000000);
                field_6451_g.func_27278_a(s2, k5, j6 + 12, i7, 0xff705050);
            }
            field_6451_g.func_874_a(s, k5, j6, field_27120_x.func_27181_b(achievement2) ? achievement2.func_27093_f() ? -128 : -1 : achievement2.func_27093_f() ? 0xff808040 : 0xff808080);
        }
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        RenderHelper.func_1159_a();
    }

    public boolean func_6450_b()
    {
        return true;
    }

    static 
    {
        field_27126_s = AchievementList.field_27392_a * 24 - 112;
        field_27125_t = AchievementList.field_27391_b * 24 - 112;
        field_27124_u = AchievementList.field_27390_c * 24 - 77;
        field_27123_v = AchievementList.field_27389_d * 24 - 77;
    }
}
