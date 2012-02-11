// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelChicken extends ModelBase
{

    public ModelRenderer field_1289_a;
    public ModelRenderer field_1288_b;
    public ModelRenderer field_1295_c;
    public ModelRenderer field_1294_d;
    public ModelRenderer field_1293_e;
    public ModelRenderer field_1292_f;
    public ModelRenderer field_1291_g;
    public ModelRenderer field_1290_h;

    public ModelChicken()
    {
        byte byte0 = 16;
        field_1289_a = new ModelRenderer(this, 0, 0);
        field_1289_a.func_923_a(-2F, -6F, -2F, 4, 6, 3, 0.0F);
        field_1289_a.func_925_a(0.0F, -1 + byte0, -4F);
        field_1291_g = new ModelRenderer(this, 14, 0);
        field_1291_g.func_923_a(-2F, -4F, -4F, 4, 2, 2, 0.0F);
        field_1291_g.func_925_a(0.0F, -1 + byte0, -4F);
        field_1290_h = new ModelRenderer(this, 14, 4);
        field_1290_h.func_923_a(-1F, -2F, -3F, 2, 2, 2, 0.0F);
        field_1290_h.func_925_a(0.0F, -1 + byte0, -4F);
        field_1288_b = new ModelRenderer(this, 0, 9);
        field_1288_b.func_923_a(-3F, -4F, -3F, 6, 8, 6, 0.0F);
        field_1288_b.func_925_a(0.0F, 0 + byte0, 0.0F);
        field_1295_c = new ModelRenderer(this, 26, 0);
        field_1295_c.func_40604_a(-1F, 0.0F, -3F, 3, 5, 3);
        field_1295_c.func_925_a(-2F, 3 + byte0, 1.0F);
        field_1294_d = new ModelRenderer(this, 26, 0);
        field_1294_d.func_40604_a(-1F, 0.0F, -3F, 3, 5, 3);
        field_1294_d.func_925_a(1.0F, 3 + byte0, 1.0F);
        field_1293_e = new ModelRenderer(this, 24, 13);
        field_1293_e.func_40604_a(0.0F, 0.0F, -3F, 1, 4, 6);
        field_1293_e.func_925_a(-4F, -3 + byte0, 0.0F);
        field_1292_f = new ModelRenderer(this, 24, 13);
        field_1292_f.func_40604_a(-1F, 0.0F, -3F, 1, 4, 6);
        field_1292_f.func_925_a(4F, -3 + byte0, 0.0F);
    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_863_a(f, f1, f2, f3, f4, f5);
        if(field_40301_k)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5F * f5, 2.0F * f5);
            field_1289_a.func_922_a(f5);
            field_1291_g.func_922_a(f5);
            field_1290_h.func_922_a(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
            field_1288_b.func_922_a(f5);
            field_1295_c.func_922_a(f5);
            field_1294_d.func_922_a(f5);
            field_1293_e.func_922_a(f5);
            field_1292_f.func_922_a(f5);
            GL11.glPopMatrix();
        } else
        {
            field_1289_a.func_922_a(f5);
            field_1291_g.func_922_a(f5);
            field_1290_h.func_922_a(f5);
            field_1288_b.func_922_a(f5);
            field_1295_c.func_922_a(f5);
            field_1294_d.func_922_a(f5);
            field_1293_e.func_922_a(f5);
            field_1292_f.func_922_a(f5);
        }
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        field_1289_a.field_1407_d = -(f4 / 57.29578F);
        field_1289_a.field_1406_e = f3 / 57.29578F;
        field_1291_g.field_1407_d = field_1289_a.field_1407_d;
        field_1291_g.field_1406_e = field_1289_a.field_1406_e;
        field_1290_h.field_1407_d = field_1289_a.field_1407_d;
        field_1290_h.field_1406_e = field_1289_a.field_1406_e;
        field_1288_b.field_1407_d = 1.570796F;
        field_1295_c.field_1407_d = MathHelper.func_1114_b(f * 0.6662F) * 1.4F * f1;
        field_1294_d.field_1407_d = MathHelper.func_1114_b(f * 0.6662F + 3.141593F) * 1.4F * f1;
        field_1293_e.field_1405_f = f2;
        field_1292_f.field_1405_f = -f2;
    }
}
