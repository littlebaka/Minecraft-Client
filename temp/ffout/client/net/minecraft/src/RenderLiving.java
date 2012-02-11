// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelBase, EntityLiving, OpenGlHelper, 
//            MathHelper, RenderManager, Tessellator, FontRenderer, 
//            Entity

public class RenderLiving extends Render
{

    protected ModelBase field_20920_e;
    protected ModelBase field_6332_f;

    public RenderLiving(ModelBase modelbase, float f)
    {
        field_20920_e = modelbase;
        field_9246_c = f;
    }

    public void func_4013_a(ModelBase modelbase)
    {
        field_6332_f = modelbase;
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        field_20920_e.field_1244_k = func_167_c(entityliving, f1);
        if(field_6332_f != null)
        {
            field_6332_f.field_1244_k = field_20920_e.field_1244_k;
        }
        field_20920_e.field_1243_l = entityliving.func_21063_V();
        if(field_6332_f != null)
        {
            field_6332_f.field_1243_l = field_20920_e.field_1243_l;
        }
        field_20920_e.field_40301_k = entityliving.func_40127_l();
        if(field_6332_f != null)
        {
            field_6332_f.field_40301_k = field_20920_e.field_40301_k;
        }
        try
        {
            float f2 = entityliving.field_734_o + (entityliving.field_735_n - entityliving.field_734_o) * f1;
            float f3 = entityliving.field_603_as + (entityliving.field_605_aq - entityliving.field_603_as) * f1;
            float f4 = entityliving.field_602_at + (entityliving.field_604_ar - entityliving.field_602_at) * f1;
            func_22012_b(entityliving, d, d1, d2);
            float f5 = func_170_d(entityliving, f1);
            func_21004_a(entityliving, f5, f2, f1);
            float f6 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(-1F, -1F, 1.0F);
            func_6330_a(entityliving, f1);
            GL11.glTranslatef(0.0F, -24F * f6 - 0.0078125F, 0.0F);
            float f7 = entityliving.field_705_Q + (entityliving.field_704_R - entityliving.field_705_Q) * f1;
            float f8 = entityliving.field_703_S - entityliving.field_704_R * (1.0F - f1);
            if(entityliving.func_40127_l())
            {
                f8 *= 3F;
            }
            if(f7 > 1.0F)
            {
                f7 = 1.0F;
            }
            GL11.glEnable(3008);
            field_20920_e.func_25103_a(entityliving, f8, f7, f1);
            func_40270_a(entityliving, f8, f7, f5, f3 - f2, f4, f6);
            for(int i = 0; i < 4; i++)
            {
                int j = func_166_a(entityliving, i, f1);
                if(j <= 0)
                {
                    continue;
                }
                field_6332_f.func_25103_a(entityliving, f8, f7, f1);
                field_6332_f.func_864_b(entityliving, f8, f7, f5, f3 - f2, f4, f6);
                if(j == 15)
                {
                    float f10 = (float)entityliving.field_9311_be + f1;
                    func_151_a("%blur%/misc/glint.png");
                    GL11.glEnable(3042);
                    float f12 = 0.5F;
                    GL11.glColor4f(f12, f12, f12, 1.0F);
                    GL11.glDepthFunc(514);
                    GL11.glDepthMask(false);
                    for(int i1 = 0; i1 < 2; i1++)
                    {
                        GL11.glDisable(2896);
                        float f15 = 0.76F;
                        GL11.glColor4f(0.5F * f15, 0.25F * f15, 0.8F * f15, 1.0F);
                        GL11.glBlendFunc(768, 1);
                        GL11.glMatrixMode(5890);
                        GL11.glLoadIdentity();
                        float f17 = f10 * (0.001F + (float)i1 * 0.003F) * 20F;
                        float f18 = 0.3333333F;
                        GL11.glScalef(f18, f18, f18);
                        GL11.glRotatef(30F - (float)i1 * 60F, 0.0F, 0.0F, 1.0F);
                        GL11.glTranslatef(0.0F, f17, 0.0F);
                        GL11.glMatrixMode(5888);
                        field_6332_f.func_864_b(entityliving, f8, f7, f5, f3 - f2, f4, f6);
                    }

                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glMatrixMode(5890);
                    GL11.glDepthMask(true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode(5888);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glDepthFunc(515);
                }
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }

            func_6331_b(entityliving, f1);
            float f9 = entityliving.func_382_a(f1);
            int k = func_173_a(entityliving, f9, f1);
            OpenGlHelper.func_40452_a(OpenGlHelper.field_40455_b);
            GL11.glDisable(3553);
            OpenGlHelper.func_40452_a(OpenGlHelper.field_40457_a);
            if((k >> 24 & 0xff) > 0 || entityliving.field_715_G > 0 || entityliving.field_712_J > 0)
            {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if(entityliving.field_715_G > 0 || entityliving.field_712_J > 0)
                {
                    GL11.glColor4f(f9, 0.0F, 0.0F, 0.4F);
                    field_20920_e.func_864_b(entityliving, f8, f7, f5, f3 - f2, f4, f6);
                    for(int l = 0; l < 4; l++)
                    {
                        if(func_27005_b(entityliving, l, f1) >= 0)
                        {
                            GL11.glColor4f(f9, 0.0F, 0.0F, 0.4F);
                            field_6332_f.func_864_b(entityliving, f8, f7, f5, f3 - f2, f4, f6);
                        }
                    }

                }
                if((k >> 24 & 0xff) > 0)
                {
                    float f11 = (float)(k >> 16 & 0xff) / 255F;
                    float f13 = (float)(k >> 8 & 0xff) / 255F;
                    float f14 = (float)(k & 0xff) / 255F;
                    float f16 = (float)(k >> 24 & 0xff) / 255F;
                    GL11.glColor4f(f11, f13, f14, f16);
                    field_20920_e.func_864_b(entityliving, f8, f7, f5, f3 - f2, f4, f6);
                    for(int j1 = 0; j1 < 4; j1++)
                    {
                        if(func_27005_b(entityliving, j1, f1) >= 0)
                        {
                            GL11.glColor4f(f11, f13, f14, f16);
                            field_6332_f.func_864_b(entityliving, f8, f7, f5, f3 - f2, f4, f6);
                        }
                    }

                }
                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }
            GL11.glDisable(32826);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        OpenGlHelper.func_40452_a(OpenGlHelper.field_40455_b);
        GL11.glEnable(3553);
        OpenGlHelper.func_40452_a(OpenGlHelper.field_40457_a);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        func_22014_a(entityliving, d, d1, d2);
    }

    protected void func_40270_a(EntityLiving entityliving, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_140_a(entityliving.field_20047_bv, entityliving.func_6376_z());
        field_20920_e.func_864_b(entityliving, f, f1, f2, f3, f4, f5);
    }

    protected void func_22012_b(EntityLiving entityliving, double d, double d1, double d2)
    {
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
    }

    protected void func_21004_a(EntityLiving entityliving, float f, float f1, float f2)
    {
        GL11.glRotatef(180F - f1, 0.0F, 1.0F, 0.0F);
        if(entityliving.field_712_J > 0)
        {
            float f3 = ((((float)entityliving.field_712_J + f2) - 1.0F) / 20F) * 1.6F;
            f3 = MathHelper.func_1113_c(f3);
            if(f3 > 1.0F)
            {
                f3 = 1.0F;
            }
            GL11.glRotatef(f3 * func_172_a(entityliving), 0.0F, 0.0F, 1.0F);
        }
    }

    protected float func_167_c(EntityLiving entityliving, float f)
    {
        return entityliving.func_431_d(f);
    }

    protected float func_170_d(EntityLiving entityliving, float f)
    {
        return (float)entityliving.field_9311_be + f;
    }

    protected void func_6331_b(EntityLiving entityliving, float f)
    {
    }

    protected int func_27005_b(EntityLiving entityliving, int i, float f)
    {
        return func_166_a(entityliving, i, f);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return -1;
    }

    protected float func_172_a(EntityLiving entityliving)
    {
        return 90F;
    }

    protected int func_173_a(EntityLiving entityliving, float f, float f1)
    {
        return 0;
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
    }

    protected void func_22014_a(EntityLiving entityliving, double d, double d1, double d2)
    {
        if(!Minecraft.func_22007_w());
    }

    protected void func_22013_a(EntityLiving entityliving, String s, double d, double d1, double d2, int i)
    {
        float f = entityliving.func_379_d(field_191_a.field_22188_h);
        if(f > (float)i)
        {
            return;
        }
        FontRenderer fontrenderer = func_6329_a();
        float f1 = 1.6F;
        float f2 = 0.01666667F * f1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1 + 2.3F, (float)d2);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-f2, -f2, f2);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Tessellator tessellator = Tessellator.field_1512_a;
        byte byte0 = 0;
        if(s.equals("deadmau5"))
        {
            byte0 = -10;
        }
        GL11.glDisable(3553);
        tessellator.func_977_b();
        int j = fontrenderer.func_871_a(s) / 2;
        tessellator.func_986_a(0.0F, 0.0F, 0.0F, 0.25F);
        tessellator.func_991_a(-j - 1, -1 + byte0, 0.0D);
        tessellator.func_991_a(-j - 1, 8 + byte0, 0.0D);
        tessellator.func_991_a(j + 1, 8 + byte0, 0.0D);
        tessellator.func_991_a(j + 1, -1 + byte0, 0.0D);
        tessellator.func_982_a();
        GL11.glEnable(3553);
        fontrenderer.func_873_b(s, -fontrenderer.func_871_a(s) / 2, byte0, 0x20ffffff);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        fontrenderer.func_873_b(s, -fontrenderer.func_871_a(s) / 2, byte0, -1);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_171_a((EntityLiving)entity, d, d1, d2, f, f1);
    }
}
