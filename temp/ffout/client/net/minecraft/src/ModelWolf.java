// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityWolf, MathHelper, 
//            Entity, EntityLiving

public class ModelWolf extends ModelBase
{

    public ModelRenderer field_25114_a;
    public ModelRenderer field_25113_b;
    public ModelRenderer field_25112_c;
    public ModelRenderer field_25111_d;
    public ModelRenderer field_25110_e;
    public ModelRenderer field_25109_f;
    ModelRenderer field_25105_j;
    ModelRenderer field_25104_k;

    public ModelWolf()
    {
        float f = 0.0F;
        float f1 = 13.5F;
        field_25114_a = new ModelRenderer(this, 0, 0);
        field_25114_a.func_923_a(-3F, -3F, -2F, 6, 6, 4, f);
        field_25114_a.func_925_a(-1F, f1, -7F);
        field_25113_b = new ModelRenderer(this, 18, 14);
        field_25113_b.func_923_a(-4F, -2F, -3F, 6, 9, 6, f);
        field_25113_b.func_925_a(0.0F, 14F, 2.0F);
        field_25104_k = new ModelRenderer(this, 21, 0);
        field_25104_k.func_923_a(-4F, -3F, -3F, 8, 6, 7, f);
        field_25104_k.func_925_a(-1F, 14F, 2.0F);
        field_25112_c = new ModelRenderer(this, 0, 18);
        field_25112_c.func_923_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_25112_c.func_925_a(-2.5F, 16F, 7F);
        field_25111_d = new ModelRenderer(this, 0, 18);
        field_25111_d.func_923_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_25111_d.func_925_a(0.5F, 16F, 7F);
        field_25110_e = new ModelRenderer(this, 0, 18);
        field_25110_e.func_923_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_25110_e.func_925_a(-2.5F, 16F, -4F);
        field_25109_f = new ModelRenderer(this, 0, 18);
        field_25109_f.func_923_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_25109_f.func_925_a(0.5F, 16F, -4F);
        field_25105_j = new ModelRenderer(this, 9, 18);
        field_25105_j.func_923_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_25105_j.func_925_a(-1F, 12F, 8F);
        field_25114_a.func_40602_a(16, 14).func_923_a(-3F, -5F, 0.0F, 2, 2, 1, f);
        field_25114_a.func_40602_a(16, 14).func_923_a(1.0F, -5F, 0.0F, 2, 2, 1, f);
        field_25114_a.func_40602_a(0, 10).func_923_a(-1.5F, 0.0F, -5F, 3, 3, 4, f);
    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_864_b(entity, f, f1, f2, f3, f4, f5);
        func_863_a(f, f1, f2, f3, f4, f5);
        if(field_40301_k)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5F * f5, 2.0F * f5);
            field_25114_a.func_25122_b(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
            field_25113_b.func_922_a(f5);
            field_25112_c.func_922_a(f5);
            field_25111_d.func_922_a(f5);
            field_25110_e.func_922_a(f5);
            field_25109_f.func_922_a(f5);
            field_25105_j.func_25122_b(f5);
            field_25104_k.func_922_a(f5);
            GL11.glPopMatrix();
        } else
        {
            field_25114_a.func_25122_b(f5);
            field_25113_b.func_922_a(f5);
            field_25112_c.func_922_a(f5);
            field_25111_d.func_922_a(f5);
            field_25110_e.func_922_a(f5);
            field_25109_f.func_922_a(f5);
            field_25105_j.func_25122_b(f5);
            field_25104_k.func_922_a(f5);
        }
    }

    public void func_25103_a(EntityLiving entityliving, float f, float f1, float f2)
    {
        EntityWolf entitywolf = (EntityWolf)entityliving;
        if(entitywolf.func_25040_C())
        {
            field_25105_j.field_1406_e = 0.0F;
        } else
        {
            field_25105_j.field_1406_e = MathHelper.func_1114_b(f * 0.6662F) * 1.4F * f1;
        }
        if(entitywolf.func_25034_B())
        {
            field_25104_k.func_925_a(-1F, 16F, -3F);
            field_25104_k.field_1407_d = 1.256637F;
            field_25104_k.field_1406_e = 0.0F;
            field_25113_b.func_925_a(0.0F, 18F, 0.0F);
            field_25113_b.field_1407_d = 0.7853982F;
            field_25105_j.func_925_a(-1F, 21F, 6F);
            field_25112_c.func_925_a(-2.5F, 22F, 2.0F);
            field_25112_c.field_1407_d = 4.712389F;
            field_25111_d.func_925_a(0.5F, 22F, 2.0F);
            field_25111_d.field_1407_d = 4.712389F;
            field_25110_e.field_1407_d = 5.811947F;
            field_25110_e.func_925_a(-2.49F, 17F, -4F);
            field_25109_f.field_1407_d = 5.811947F;
            field_25109_f.func_925_a(0.51F, 17F, -4F);
        } else
        {
            field_25113_b.func_925_a(0.0F, 14F, 2.0F);
            field_25113_b.field_1407_d = 1.570796F;
            field_25104_k.func_925_a(-1F, 14F, -3F);
            field_25104_k.field_1407_d = field_25113_b.field_1407_d;
            field_25105_j.func_925_a(-1F, 12F, 8F);
            field_25112_c.func_925_a(-2.5F, 16F, 7F);
            field_25111_d.func_925_a(0.5F, 16F, 7F);
            field_25110_e.func_925_a(-2.5F, 16F, -4F);
            field_25109_f.func_925_a(0.5F, 16F, -4F);
            field_25112_c.field_1407_d = MathHelper.func_1114_b(f * 0.6662F) * 1.4F * f1;
            field_25111_d.field_1407_d = MathHelper.func_1114_b(f * 0.6662F + 3.141593F) * 1.4F * f1;
            field_25110_e.field_1407_d = MathHelper.func_1114_b(f * 0.6662F + 3.141593F) * 1.4F * f1;
            field_25109_f.field_1407_d = MathHelper.func_1114_b(f * 0.6662F) * 1.4F * f1;
        }
        float f3 = entitywolf.func_25033_c(f2) + entitywolf.func_25042_a(f2, 0.0F);
        field_25114_a.field_1405_f = f3;
        field_25104_k.field_1405_f = entitywolf.func_25042_a(f2, -0.08F);
        field_25113_b.field_1405_f = entitywolf.func_25042_a(f2, -0.16F);
        field_25105_j.field_1405_f = entitywolf.func_25042_a(f2, -0.2F);
        if(entitywolf.func_25039_v())
        {
            float f4 = entitywolf.func_382_a(f2) * entitywolf.func_25043_b_(f2);
            GL11.glColor3f(f4, f4, f4);
        }
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_863_a(f, f1, f2, f3, f4, f5);
        field_25114_a.field_1407_d = f4 / 57.29578F;
        field_25114_a.field_1406_e = f3 / 57.29578F;
        field_25105_j.field_1407_d = f2;
    }
}
