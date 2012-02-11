// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelMinecart, EntityMinecart, Vec3D, 
//            MathHelper, RenderBlocks, Block, ModelBase, 
//            Entity

public class RenderMinecart extends Render
{

    protected ModelBase field_20925_a;

    public RenderMinecart()
    {
        field_9246_c = 0.5F;
        field_20925_a = new ModelMinecart();
    }

    public void func_152_a(EntityMinecart entityminecart, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        long l = (long)entityminecart.field_620_ab * 0x1d66f537L;
        l = l * l * 0x105cb26d1L + l * 0x181c9L;
        float f2 = (((float)(l >> 16 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        float f3 = (((float)(l >> 20 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        float f4 = (((float)(l >> 24 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        GL11.glTranslatef(f2, f3, f4);
        double d3 = entityminecart.field_638_aI + (entityminecart.field_611_ak - entityminecart.field_638_aI) * (double)f1;
        double d4 = entityminecart.field_637_aJ + (entityminecart.field_610_al - entityminecart.field_637_aJ) * (double)f1;
        double d5 = entityminecart.field_636_aK + (entityminecart.field_609_am - entityminecart.field_636_aK) * (double)f1;
        double d6 = 0.30000001192092896D;
        Vec3D vec3d = entityminecart.func_514_g(d3, d4, d5);
        float f5 = entityminecart.field_602_at + (entityminecart.field_604_ar - entityminecart.field_602_at) * f1;
        if(vec3d != null)
        {
            Vec3D vec3d1 = entityminecart.func_515_a(d3, d4, d5, d6);
            Vec3D vec3d2 = entityminecart.func_515_a(d3, d4, d5, -d6);
            if(vec3d1 == null)
            {
                vec3d1 = vec3d;
            }
            if(vec3d2 == null)
            {
                vec3d2 = vec3d;
            }
            d += vec3d.field_1776_a - d3;
            d1 += (vec3d1.field_1775_b + vec3d2.field_1775_b) / 2D - d4;
            d2 += vec3d.field_1779_c - d5;
            Vec3D vec3d3 = vec3d2.func_1257_c(-vec3d1.field_1776_a, -vec3d1.field_1775_b, -vec3d1.field_1779_c);
            if(vec3d3.func_1253_c() != 0.0D)
            {
                vec3d3 = vec3d3.func_1252_b();
                f = (float)((Math.atan2(vec3d3.field_1779_c, vec3d3.field_1776_a) * 180D) / 3.1415926535897931D);
                f5 = (float)(Math.atan(vec3d3.field_1775_b) * 73D);
            }
        }
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(180F - f, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f5, 0.0F, 0.0F, 1.0F);
        float f6 = (float)entityminecart.func_41023_l() - f1;
        float f7 = (float)entityminecart.func_41025_i() - f1;
        if(f7 < 0.0F)
        {
            f7 = 0.0F;
        }
        if(f6 > 0.0F)
        {
            GL11.glRotatef(((MathHelper.func_1106_a(f6) * f6 * f7) / 10F) * (float)entityminecart.func_41030_m(), 1.0F, 0.0F, 0.0F);
        }
        if(entityminecart.field_20913_d != 0)
        {
            func_151_a("/terrain.png");
            float f8 = 0.75F;
            GL11.glScalef(f8, f8, f8);
            if(entityminecart.field_20913_d == 1)
            {
                GL11.glTranslatef(-0.5F, 0.0F, 0.5F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                (new RenderBlocks()).func_1227_a(Block.field_396_av, 0, entityminecart.func_382_a(f1));
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.5F, 0.0F, -0.5F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            } else
            if(entityminecart.field_20913_d == 2)
            {
                GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                (new RenderBlocks()).func_1227_a(Block.field_445_aC, 0, entityminecart.func_382_a(f1));
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
            GL11.glScalef(1.0F / f8, 1.0F / f8, 1.0F / f8);
        }
        func_151_a("/item/cart.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        field_20925_a.func_864_b(entityminecart, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_152_a((EntityMinecart)entity, d, d1, d2, f, f1);
    }
}
