// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelDragon, EntityDragon, MathHelper, 
//            ModelBase, EntityEnderCrystal, Tessellator, RenderHelper, 
//            OpenGlHelper, EntityLiving, Entity

public class RenderDragon extends RenderLiving
{

    public static EntityDragon field_41038_a;
    private static int field_40284_d = 0;
    protected ModelDragon field_40285_c;

    public RenderDragon()
    {
        super(new ModelDragon(0.0F), 0.5F);
        field_40285_c = (ModelDragon)field_20920_e;
        func_4013_a(field_20920_e);
    }

    protected void func_40282_a(EntityDragon entitydragon, float f, float f1, float f2)
    {
        float f3 = (float)entitydragon.func_40160_a(7, f2)[0];
        float f4 = (float)(entitydragon.func_40160_a(5, f2)[1] - entitydragon.func_40160_a(10, f2)[1]);
        GL11.glRotatef(-f3, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(f4 * 10F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.0F, 1.0F);
        if(entitydragon.field_712_J > 0)
        {
            float f5 = ((((float)entitydragon.field_712_J + f2) - 1.0F) / 20F) * 1.6F;
            f5 = MathHelper.func_1113_c(f5);
            if(f5 > 1.0F)
            {
                f5 = 1.0F;
            }
            GL11.glRotatef(f5 * func_172_a(entitydragon), 0.0F, 0.0F, 1.0F);
        }
    }

    protected void func_40280_a(EntityDragon entitydragon, float f, float f1, float f2, float f3, float f4, float f5)
    {
        if(entitydragon.field_40178_aA > 0)
        {
            float f6 = (float)entitydragon.field_40178_aA / 200F;
            GL11.glDepthFunc(515);
            GL11.glEnable(3008);
            GL11.glAlphaFunc(516, f6);
            func_140_a(entitydragon.field_20047_bv, "/mob/enderdragon/shuffle.png");
            field_20920_e.func_864_b(entitydragon, f, f1, f2, f3, f4, f5);
            GL11.glAlphaFunc(516, 0.1F);
            GL11.glDepthFunc(514);
        }
        func_140_a(entitydragon.field_20047_bv, entitydragon.func_6376_z());
        field_20920_e.func_864_b(entitydragon, f, f1, f2, f3, f4, f5);
        if(entitydragon.field_715_G > 0)
        {
            GL11.glDepthFunc(514);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
            field_20920_e.func_864_b(entitydragon, f, f1, f2, f3, f4, f5);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDepthFunc(515);
        }
    }

    public void func_40281_a(EntityDragon entitydragon, double d, double d1, double d2, 
            float f, float f1)
    {
        field_41038_a = entitydragon;
        if(field_40284_d != 4)
        {
            field_20920_e = new ModelDragon(0.0F);
            field_40284_d = 4;
        }
        super.func_171_a(entitydragon, d, d1, d2, f, f1);
        if(entitydragon.field_41013_bH != null)
        {
            float f2 = (float)entitydragon.field_41013_bH.field_41032_a + f1;
            float f3 = MathHelper.func_1106_a(f2 * 0.2F) / 2.0F + 0.5F;
            f3 = (f3 * f3 + f3) * 0.2F;
            float f4 = (float)(entitydragon.field_41013_bH.field_611_ak - entitydragon.field_611_ak - (entitydragon.field_9285_at - entitydragon.field_611_ak) * (double)(1.0F - f1));
            float f5 = (float)(((double)f3 + entitydragon.field_41013_bH.field_610_al) - 1.0D - entitydragon.field_610_al - (entitydragon.field_9284_au - entitydragon.field_610_al) * (double)(1.0F - f1));
            float f6 = (float)(entitydragon.field_41013_bH.field_609_am - entitydragon.field_609_am - (entitydragon.field_9283_av - entitydragon.field_609_am) * (double)(1.0F - f1));
            float f7 = MathHelper.func_1113_c(f4 * f4 + f6 * f6);
            float f8 = MathHelper.func_1113_c(f4 * f4 + f5 * f5 + f6 * f6);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d, (float)d1 + 2.0F, (float)d2);
            GL11.glRotatef(((float)(-Math.atan2(f6, f4)) * 180F) / 3.141593F - 90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(((float)(-Math.atan2(f7, f5)) * 180F) / 3.141593F - 90F, 1.0F, 0.0F, 0.0F);
            Tessellator tessellator = Tessellator.field_1512_a;
            RenderHelper.func_1159_a();
            GL11.glDisable(2884);
            func_151_a("/mob/enderdragon/beam.png");
            GL11.glShadeModel(7425);
            float f9 = 0.0F - ((float)entitydragon.field_9311_be + f1) * 0.01F;
            float f10 = MathHelper.func_1113_c(f4 * f4 + f5 * f5 + f6 * f6) / 32F - ((float)entitydragon.field_9311_be + f1) * 0.01F;
            tessellator.func_992_a(5);
            int i = 8;
            for(int j = 0; j <= i; j++)
            {
                float f11 = MathHelper.func_1106_a(((float)(j % i) * 3.141593F * 2.0F) / (float)i) * 0.75F;
                float f12 = MathHelper.func_1114_b(((float)(j % i) * 3.141593F * 2.0F) / (float)i) * 0.75F;
                float f13 = ((float)(j % i) * 1.0F) / (float)i;
                tessellator.func_990_b(0);
                tessellator.func_983_a(f11 * 0.2F, f12 * 0.2F, 0.0D, f13, f10);
                tessellator.func_990_b(0xffffff);
                tessellator.func_983_a(f11, f12, f8, f13, f9);
            }

            tessellator.func_982_a();
            GL11.glEnable(2884);
            GL11.glShadeModel(7424);
            RenderHelper.func_1158_b();
            GL11.glPopMatrix();
        }
    }

    protected void func_40279_a(EntityDragon entitydragon, float f)
    {
        super.func_6331_b(entitydragon, f);
        Tessellator tessellator = Tessellator.field_1512_a;
        if(entitydragon.field_40178_aA > 0)
        {
            RenderHelper.func_1159_a();
            float f1 = ((float)entitydragon.field_40178_aA + f) / 200F;
            float f2 = 0.0F;
            if(f1 > 0.8F)
            {
                f2 = (f1 - 0.8F) / 0.2F;
            }
            Random random = new Random(432L);
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(3008);
            GL11.glEnable(2884);
            GL11.glDepthMask(false);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -1F, -2F);
            for(int i = 0; (float)i < ((f1 + f1 * f1) / 2.0F) * 60F; i++)
            {
                GL11.glRotatef(random.nextFloat() * 360F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F + f1 * 90F, 0.0F, 0.0F, 1.0F);
                tessellator.func_992_a(6);
                float f3 = random.nextFloat() * 20F + 5F + f2 * 10F;
                float f4 = random.nextFloat() * 2.0F + 1.0F + f2 * 2.0F;
                tessellator.func_6513_a(0xffffff, (int)(255F * (1.0F - f2)));
                tessellator.func_991_a(0.0D, 0.0D, 0.0D);
                tessellator.func_6513_a(0xff00ff, 0);
                tessellator.func_991_a(-0.86599999999999999D * (double)f4, f3, -0.5F * f4);
                tessellator.func_991_a(0.86599999999999999D * (double)f4, f3, -0.5F * f4);
                tessellator.func_991_a(0.0D, f3, 1.0F * f4);
                tessellator.func_991_a(-0.86599999999999999D * (double)f4, f3, -0.5F * f4);
                tessellator.func_982_a();
            }

            GL11.glPopMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            RenderHelper.func_1158_b();
        }
    }

    protected int func_40283_a(EntityDragon entitydragon, int i, float f)
    {
        if(i == 1)
        {
            GL11.glDepthFunc(515);
        }
        if(i != 0)
        {
            return -1;
        } else
        {
            func_151_a("/mob/enderdragon/ender_eyes.png");
            float f1 = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(2896);
            GL11.glDepthFunc(514);
            int j = 61680;
            int k = j % 0x10000;
            int l = j / 0x10000;
            OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)k / 1.0F, (float)l / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(2896);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_40283_a((EntityDragon)entityliving, i, f);
    }

    protected void func_6331_b(EntityLiving entityliving, float f)
    {
        func_40279_a((EntityDragon)entityliving, f);
    }

    protected void func_21004_a(EntityLiving entityliving, float f, float f1, float f2)
    {
        func_40282_a((EntityDragon)entityliving, f, f1, f2);
    }

    protected void func_40270_a(EntityLiving entityliving, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_40280_a((EntityDragon)entityliving, f, f1, f2, f3, f4, f5);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40281_a((EntityDragon)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40281_a((EntityDragon)entity, d, d1, d2, f, f1);
    }

}
