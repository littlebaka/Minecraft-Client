// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, ScaledResolution, EntityRenderer, EntityPlayerSP, 
//            InventoryPlayer, GameSettings, ItemStack, Block, 
//            Potion, PlayerController, RenderEngine, FoodStats, 
//            World, WorldInfo, Material, RenderHelper, 
//            FontRenderer, MathHelper, GuiChat, ChatLine, 
//            EntityClientPlayerMP, KeyBinding, NetClientHandler, GuiSavingLevelString, 
//            RenderDragon, EntityDragon, Tessellator, BlockPortal, 
//            RenderItem, StringTranslate

public class GuiIngame extends Gui
{

    private static RenderItem field_930_d = new RenderItem();
    private java.util.List field_929_e;
    private Random field_9423_f;
    private Minecraft field_9422_g;
    public String field_933_a;
    private int field_9421_h;
    private String field_9420_i;
    private int field_9419_j;
    private boolean field_22065_l;
    public float field_6446_b;
    float field_931_c;

    public GuiIngame(Minecraft minecraft)
    {
        field_929_e = new ArrayList();
        field_9423_f = new Random();
        field_933_a = null;
        field_9421_h = 0;
        field_9420_i = "";
        field_9419_j = 0;
        field_22065_l = false;
        field_931_c = 1.0F;
        field_9422_g = minecraft;
    }

    public void func_4066_a(float f, boolean flag, int i, int j)
    {
        ScaledResolution scaledresolution = new ScaledResolution(field_9422_g.field_6304_y, field_9422_g.field_6326_c, field_9422_g.field_6325_d);
        int k = scaledresolution.func_903_a();
        int l = scaledresolution.func_902_b();
        FontRenderer fontrenderer = field_9422_g.field_6314_o;
        field_9422_g.field_9243_r.func_905_b();
        GL11.glEnable(3042);
        if(Minecraft.func_22001_u())
        {
            func_4064_a(field_9422_g.field_6322_g.func_382_a(f), k, l);
        } else
        {
            GL11.glBlendFunc(770, 771);
        }
        ItemStack itemstack = field_9422_g.field_6322_g.field_778_b.func_492_d(3);
        if(field_9422_g.field_6304_y.field_1560_x == 0 && itemstack != null && itemstack.field_1617_c == Block.field_4055_bb.field_376_bc)
        {
            func_4063_a(k, l);
        }
        if(!field_9422_g.field_6322_g.func_35160_a(Potion.field_35684_k))
        {
            float f1 = field_9422_g.field_6322_g.field_28025_B + (field_9422_g.field_6322_g.field_28026_A - field_9422_g.field_6322_g.field_28025_B) * f;
            if(f1 > 0.0F)
            {
                func_4065_b(f1, k, l);
            }
        }
        if(!field_9422_g.field_6327_b.func_35643_e())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/gui/gui.png"));
            InventoryPlayer inventoryplayer = field_9422_g.field_6322_g.field_778_b;
            field_923_k = -90F;
            func_550_b(k / 2 - 91, l - 22, 0, 0, 182, 22);
            func_550_b((k / 2 - 91 - 1) + inventoryplayer.field_847_d * 20, l - 22 - 1, 0, 22, 24, 22);
            GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            func_550_b(k / 2 - 7, l / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            boolean flag2 = (field_9422_g.field_6322_g.field_9306_bj / 3) % 2 == 1;
            if(field_9422_g.field_6322_g.field_9306_bj < 10)
            {
                flag2 = false;
            }
            int i2 = field_9422_g.field_6322_g.func_40114_aH();
            int j3 = field_9422_g.field_6322_g.field_9335_K;
            field_9423_f.setSeed(field_9421_h * 0x4c627);
            boolean flag4 = false;
            FoodStats foodstats = field_9422_g.field_6322_g.func_35191_at();
            int i5 = foodstats.func_35765_a();
            int k5 = foodstats.func_35769_b();
            func_41039_c();
            if(field_9422_g.field_6327_b.func_6469_d())
            {
                int k6 = k / 2 - 91;
                int j7 = k / 2 + 91;
                int l7 = field_9422_g.field_6322_g.func_35193_as();
                if(l7 > 0)
                {
                    char c = '\266';
                    int i9 = (int)(field_9422_g.field_6322_g.field_35211_aX * (float)(c + 1));
                    int l9 = (l - 32) + 3;
                    func_550_b(k6, l9, 0, 64, c, 5);
                    if(i9 > 0)
                    {
                        func_550_b(k6, l9, 0, 69, i9, 5);
                    }
                }
                int k8 = l - 39;
                int j9 = k8 - 10;
                int i10 = field_9422_g.field_6322_g.func_40119_ar();
                int j10 = -1;
                if(field_9422_g.field_6322_g.func_35160_a(Potion.field_35681_l))
                {
                    j10 = field_9421_h % 25;
                }
                for(int l10 = 0; l10 < 10; l10++)
                {
                    if(i10 > 0)
                    {
                        int k11 = k6 + l10 * 8;
                        if(l10 * 2 + 1 < i10)
                        {
                            func_550_b(k11, j9, 34, 9, 9, 9);
                        }
                        if(l10 * 2 + 1 == i10)
                        {
                            func_550_b(k11, j9, 25, 9, 9, 9);
                        }
                        if(l10 * 2 + 1 > i10)
                        {
                            func_550_b(k11, j9, 16, 9, 9, 9);
                        }
                    }
                    int l11 = 16;
                    if(field_9422_g.field_6322_g.func_35160_a(Potion.field_35689_u))
                    {
                        l11 += 36;
                    }
                    int k12 = 0;
                    if(flag2)
                    {
                        k12 = 1;
                    }
                    int j13 = k6 + l10 * 8;
                    int k13 = k8;
                    if(i2 <= 4)
                    {
                        k13 += field_9423_f.nextInt(2);
                    }
                    if(l10 == j10)
                    {
                        k13 -= 2;
                    }
                    byte byte5 = 0;
                    if(field_9422_g.field_6324_e.func_22144_v().func_40724_s())
                    {
                        byte5 = 5;
                    }
                    func_550_b(j13, k13, 16 + k12 * 9, 9 * byte5, 9, 9);
                    if(flag2)
                    {
                        if(l10 * 2 + 1 < j3)
                        {
                            func_550_b(j13, k13, l11 + 54, 9 * byte5, 9, 9);
                        }
                        if(l10 * 2 + 1 == j3)
                        {
                            func_550_b(j13, k13, l11 + 63, 9 * byte5, 9, 9);
                        }
                    }
                    if(l10 * 2 + 1 < i2)
                    {
                        func_550_b(j13, k13, l11 + 36, 9 * byte5, 9, 9);
                    }
                    if(l10 * 2 + 1 == i2)
                    {
                        func_550_b(j13, k13, l11 + 45, 9 * byte5, 9, 9);
                    }
                }

                for(int i11 = 0; i11 < 10; i11++)
                {
                    int i12 = k8;
                    int l12 = 16;
                    byte byte4 = 0;
                    if(field_9422_g.field_6322_g.func_35160_a(Potion.field_35691_s))
                    {
                        l12 += 36;
                        byte4 = 13;
                    }
                    if(field_9422_g.field_6322_g.func_35191_at().func_35760_d() <= 0.0F && field_9421_h % (i5 * 3 + 1) == 0)
                    {
                        i12 += field_9423_f.nextInt(3) - 1;
                    }
                    if(flag4)
                    {
                        byte4 = 1;
                    }
                    int l13 = j7 - i11 * 8 - 9;
                    func_550_b(l13, i12, 16 + byte4 * 9, 27, 9, 9);
                    if(flag4)
                    {
                        if(i11 * 2 + 1 < k5)
                        {
                            func_550_b(l13, i12, l12 + 54, 27, 9, 9);
                        }
                        if(i11 * 2 + 1 == k5)
                        {
                            func_550_b(l13, i12, l12 + 63, 27, 9, 9);
                        }
                    }
                    if(i11 * 2 + 1 < i5)
                    {
                        func_550_b(l13, i12, l12 + 36, 27, 9, 9);
                    }
                    if(i11 * 2 + 1 == i5)
                    {
                        func_550_b(l13, i12, l12 + 45, 27, 9, 9);
                    }
                }

                if(field_9422_g.field_6322_g.func_393_a(Material.field_1332_f))
                {
                    int j11 = (int)Math.ceil(((double)(field_9422_g.field_6322_g.func_41001_Z() - 2) * 10D) / 300D);
                    int j12 = (int)Math.ceil(((double)field_9422_g.field_6322_g.func_41001_Z() * 10D) / 300D) - j11;
                    for(int i13 = 0; i13 < j11 + j12; i13++)
                    {
                        if(i13 < j11)
                        {
                            func_550_b(j7 - i13 * 8 - 9, j9, 16, 18, 9, 9);
                        } else
                        {
                            func_550_b(j7 - i13 * 8 - 9, j9, 25, 18, 9, 9);
                        }
                    }

                }
            }
            GL11.glDisable(3042);
            GL11.glEnable(32826);
            RenderHelper.func_41089_c();
            for(int l6 = 0; l6 < 9; l6++)
            {
                int k7 = (k / 2 - 90) + l6 * 20 + 2;
                int i8 = l - 16 - 3;
                func_554_a(l6, k7, i8, f);
            }

            RenderHelper.func_1159_a();
            GL11.glDisable(32826);
        }
        if(field_9422_g.field_6322_g.func_22060_M() > 0)
        {
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int i1 = field_9422_g.field_6322_g.func_22060_M();
            float f3 = (float)i1 / 100F;
            if(f3 > 1.0F)
            {
                f3 = 1.0F - (float)(i1 - 100) / 10F;
            }
            int j2 = (int)(220F * f3) << 24 | 0x101020;
            func_551_a(0, 0, k, l, j2);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
        }
        if(field_9422_g.field_6327_b.func_35642_f() && field_9422_g.field_6322_g.field_35210_aY > 0)
        {
            boolean flag1 = false;
            int j1 = flag1 ? 0xffffff : 0x80ff20;
            String s = (new StringBuilder()).append("").append(field_9422_g.field_6322_g.field_35210_aY).toString();
            int k3 = (k - fontrenderer.func_871_a(s)) / 2;
            int l3 = l - 31 - 4;
            fontrenderer.func_873_b(s, k3 + 1, l3, 0);
            fontrenderer.func_873_b(s, k3 - 1, l3, 0);
            fontrenderer.func_873_b(s, k3, l3 + 1, 0);
            fontrenderer.func_873_b(s, k3, l3 - 1, 0);
            fontrenderer.func_873_b(s, k3, l3, j1);
        }
        if(field_9422_g.field_6304_y.field_22276_A)
        {
            GL11.glPushMatrix();
            if(Minecraft.field_28005_H > 0L)
            {
                GL11.glTranslatef(0.0F, 32F, 0.0F);
            }
            fontrenderer.func_874_a((new StringBuilder()).append("Minecraft 1.1 (").append(field_9422_g.field_6292_I).append(")").toString(), 2, 2, 0xffffff);
            fontrenderer.func_874_a(field_9422_g.func_6241_m(), 2, 12, 0xffffff);
            fontrenderer.func_874_a(field_9422_g.func_6262_n(), 2, 22, 0xffffff);
            fontrenderer.func_874_a(field_9422_g.func_6245_o(), 2, 32, 0xffffff);
            fontrenderer.func_874_a(field_9422_g.func_21002_o(), 2, 42, 0xffffff);
            long l1 = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l4 = Runtime.getRuntime().freeMemory();
            long l5 = l2 - l4;
            String s1 = (new StringBuilder()).append("Used memory: ").append((l5 * 100L) / l1).append("% (").append(l5 / 1024L / 1024L).append("MB) of ").append(l1 / 1024L / 1024L).append("MB").toString();
            func_547_b(fontrenderer, s1, k - fontrenderer.func_871_a(s1) - 2, 2, 0xe0e0e0);
            s1 = (new StringBuilder()).append("Allocated memory: ").append((l2 * 100L) / l1).append("% (").append(l2 / 1024L / 1024L).append("MB)").toString();
            func_547_b(fontrenderer, s1, k - fontrenderer.func_871_a(s1) - 2, 12, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("x: ").append(field_9422_g.field_6322_g.field_611_ak).toString(), 2, 64, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("y: ").append(field_9422_g.field_6322_g.field_610_al).toString(), 2, 72, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("z: ").append(field_9422_g.field_6322_g.field_609_am).toString(), 2, 80, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("f: ").append(MathHelper.func_1108_b((double)((field_9422_g.field_6322_g.field_605_aq * 4F) / 360F) + 0.5D) & 3).toString(), 2, 88, 0xe0e0e0);
            func_547_b(fontrenderer, (new StringBuilder()).append("Seed: ").append(field_9422_g.field_6324_e.func_22138_q()).toString(), 2, 104, 0xe0e0e0);
            GL11.glPopMatrix();
        }
        if(field_9419_j > 0)
        {
            float f2 = (float)field_9419_j - f;
            int k1 = (int)((f2 * 256F) / 20F);
            if(k1 > 255)
            {
                k1 = 255;
            }
            if(k1 > 0)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(k / 2, l - 48, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int k2 = 0xffffff;
                if(field_22065_l)
                {
                    k2 = Color.HSBtoRGB(f2 / 50F, 0.7F, 0.6F) & 0xffffff;
                }
                fontrenderer.func_873_b(field_9420_i, -fontrenderer.func_871_a(field_9420_i) / 2, -4, k2 + (k1 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
        }
        byte byte0 = 10;
        boolean flag3 = false;
        if(field_9422_g.field_6313_p instanceof GuiChat)
        {
            byte0 = 20;
            flag3 = true;
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, l - 48, 0.0F);
        for(int i3 = 0; i3 < field_929_e.size() && i3 < byte0; i3++)
        {
            if(((ChatLine)field_929_e.get(i3)).field_1296_b >= 200 && !flag3)
            {
                continue;
            }
            double d = (double)((ChatLine)field_929_e.get(i3)).field_1296_b / 200D;
            d = 1.0D - d;
            d *= 10D;
            if(d < 0.0D)
            {
                d = 0.0D;
            }
            if(d > 1.0D)
            {
                d = 1.0D;
            }
            d *= d;
            int j4 = (int)(255D * d);
            if(flag3)
            {
                j4 = 255;
            }
            if(j4 > 0)
            {
                byte byte1 = 2;
                int i6 = -i3 * 9;
                String s2 = ((ChatLine)field_929_e.get(i3)).field_1297_a;
                func_551_a(byte1, i6 - 1, byte1 + 320, i6 + 8, j4 / 2 << 24);
                GL11.glEnable(3042);
                fontrenderer.func_874_a(s2, byte1, i6, 0xffffff + (j4 << 24));
            }
        }

        GL11.glPopMatrix();
        if((field_9422_g.field_6322_g instanceof EntityClientPlayerMP) && field_9422_g.field_6304_y.field_35384_x.field_35965_e)
        {
            NetClientHandler netclienthandler = ((EntityClientPlayerMP)field_9422_g.field_6322_g).field_797_bg;
            java.util.List list = netclienthandler.field_35786_c;
            int i4 = netclienthandler.field_35785_d;
            int k4 = i4;
            int j5 = 1;
            for(; k4 > 20; k4 = ((i4 + j5) - 1) / j5)
            {
                j5++;
            }

            int j6 = 300 / j5;
            if(j6 > 150)
            {
                j6 = 150;
            }
            int i7 = (k - j5 * j6) / 2;
            byte byte2 = 10;
            func_551_a(i7 - 1, byte2 - 1, i7 + j6 * j5, byte2 + 9 * k4, 0x80000000);
            for(int j8 = 0; j8 < i4; j8++)
            {
                int l8 = i7 + (j8 % j5) * j6;
                int k9 = byte2 + (j8 / j5) * 9;
                func_551_a(l8, k9, (l8 + j6) - 1, k9 + 8, 0x20ffffff);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3008);
                if(j8 >= list.size())
                {
                    continue;
                }
                GuiSavingLevelString guisavinglevelstring = (GuiSavingLevelString)list.get(j8);
                fontrenderer.func_874_a(guisavinglevelstring.field_35624_a, l8, k9, 0xffffff);
                field_9422_g.field_6315_n.func_1076_b(field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
                int k10 = 0;
                byte byte3 = 0;
                k10 = 0;
                byte3 = 0;
                if(guisavinglevelstring.field_35623_b < 0)
                {
                    byte3 = 5;
                } else
                if(guisavinglevelstring.field_35623_b < 150)
                {
                    byte3 = 0;
                } else
                if(guisavinglevelstring.field_35623_b < 300)
                {
                    byte3 = 1;
                } else
                if(guisavinglevelstring.field_35623_b < 600)
                {
                    byte3 = 2;
                } else
                if(guisavinglevelstring.field_35623_b < 1000)
                {
                    byte3 = 3;
                } else
                {
                    byte3 = 4;
                }
                field_923_k += 100F;
                func_550_b((l8 + j6) - 12, k9, 0 + k10 * 10, 176 + byte3 * 8, 10, 8);
                field_923_k -= 100F;
            }

        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    private void func_41039_c()
    {
        if(RenderDragon.field_41038_a == null)
        {
            return;
        }
        EntityDragon entitydragon = RenderDragon.field_41038_a;
        RenderDragon.field_41038_a = null;
        FontRenderer fontrenderer = field_9422_g.field_6314_o;
        ScaledResolution scaledresolution = new ScaledResolution(field_9422_g.field_6304_y, field_9422_g.field_6326_c, field_9422_g.field_6325_d);
        int i = scaledresolution.func_903_a();
        char c = '\266';
        int j = i / 2 - c / 2;
        int k = (int)(((float)entitydragon.func_41010_ax() / (float)entitydragon.func_40117_c()) * (float)(c + 1));
        byte byte0 = 12;
        func_550_b(j, byte0, 0, 74, c, 5);
        func_550_b(j, byte0, 0, 74, c, 5);
        if(k > 0)
        {
            func_550_b(j, byte0, 0, 79, k, 5);
        }
        String s = "Boss health";
        fontrenderer.func_874_a(s, i / 2 - fontrenderer.func_871_a(s) / 2, byte0 - 10, 0xff00ff);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
    }

    private void func_4063_a(int i, int j)
    {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("%blur%/misc/pumpkinblur.png"));
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(0.0D, j, -90D, 0.0D, 1.0D);
        tessellator.func_983_a(i, j, -90D, 1.0D, 1.0D);
        tessellator.func_983_a(i, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.func_983_a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_4064_a(float f, int i, int j)
    {
        f = 1.0F - f;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        if(f > 1.0F)
        {
            f = 1.0F;
        }
        field_931_c += (double)(f - field_931_c) * 0.01D;
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(field_931_c, field_931_c, field_931_c, 1.0F);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("%blur%/misc/vignette.png"));
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(0.0D, j, -90D, 0.0D, 1.0D);
        tessellator.func_983_a(i, j, -90D, 1.0D, 1.0D);
        tessellator.func_983_a(i, 0.0D, -90D, 1.0D, 0.0D);
        tessellator.func_983_a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void func_4065_b(float f, int i, int j)
    {
        if(f < 1.0F)
        {
            f *= f;
            f *= f;
            f = f * 0.8F + 0.2F;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
        GL11.glBindTexture(3553, field_9422_g.field_6315_n.func_1070_a("/terrain.png"));
        float f1 = (float)(Block.field_4047_bf.field_378_bb % 16) / 16F;
        float f2 = (float)(Block.field_4047_bf.field_378_bb / 16) / 16F;
        float f3 = (float)(Block.field_4047_bf.field_378_bb % 16 + 1) / 16F;
        float f4 = (float)(Block.field_4047_bf.field_378_bb / 16 + 1) / 16F;
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(0.0D, j, -90D, f1, f4);
        tessellator.func_983_a(i, j, -90D, f3, f4);
        tessellator.func_983_a(i, 0.0D, -90D, f3, f2);
        tessellator.func_983_a(0.0D, 0.0D, -90D, f1, f2);
        tessellator.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_554_a(int i, int j, int k, float f)
    {
        ItemStack itemstack = field_9422_g.field_6322_g.field_778_b.field_843_a[i];
        if(itemstack == null)
        {
            return;
        }
        float f1 = (float)itemstack.field_1614_b - f;
        if(f1 > 0.0F)
        {
            GL11.glPushMatrix();
            float f2 = 1.0F + f1 / 5F;
            GL11.glTranslatef(j + 8, k + 12, 0.0F);
            GL11.glScalef(1.0F / f2, (f2 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(j + 8), -(k + 12), 0.0F);
        }
        field_930_d.func_161_a(field_9422_g.field_6314_o, field_9422_g.field_6315_n, itemstack, j, k);
        if(f1 > 0.0F)
        {
            GL11.glPopMatrix();
        }
        field_930_d.func_164_b(field_9422_g.field_6314_o, field_9422_g.field_6315_n, itemstack, j, k);
    }

    public void func_555_a()
    {
        if(field_9419_j > 0)
        {
            field_9419_j--;
        }
        field_9421_h++;
        for(int i = 0; i < field_929_e.size(); i++)
        {
            ((ChatLine)field_929_e.get(i)).field_1296_b++;
        }

    }

    public void func_28097_b()
    {
        field_929_e.clear();
    }

    public void func_552_a(String s)
    {
        int i;
        for(; field_9422_g.field_6314_o.func_871_a(s) > 320; s = s.substring(i))
        {
            for(i = 1; i < s.length() && field_9422_g.field_6314_o.func_871_a(s.substring(0, i + 1)) <= 320; i++) { }
            func_552_a(s.substring(0, i));
        }

        field_929_e.add(0, new ChatLine(s));
        for(; field_929_e.size() > 50; field_929_e.remove(field_929_e.size() - 1)) { }
    }

    public void func_553_b(String s)
    {
        field_9420_i = (new StringBuilder()).append("Now playing: ").append(s).toString();
        field_9419_j = 60;
        field_22065_l = true;
    }

    public void func_22064_c(String s)
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        String s1 = stringtranslate.func_20163_a(s);
        func_552_a(s1);
    }

}
