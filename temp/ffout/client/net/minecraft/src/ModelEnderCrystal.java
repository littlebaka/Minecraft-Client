// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelEnderCrystal extends ModelBase
{

    private ModelRenderer field_41057_g;
    private ModelRenderer field_41058_h;
    private ModelRenderer field_41059_i;

    public ModelEnderCrystal(float f)
    {
        field_41058_h = new ModelRenderer(this, "glass");
        field_41058_h.func_40602_a(0, 0).func_40604_a(-4F, -4F, -4F, 8, 8, 8);
        field_41057_g = new ModelRenderer(this, "cube");
        field_41057_g.func_40602_a(32, 0).func_40604_a(-4F, -4F, -4F, 8, 8, 8);
        field_41059_i = new ModelRenderer(this, "base");
        field_41059_i.func_40602_a(0, 16).func_40604_a(-6F, 0.0F, -6F, 12, 4, 12);
    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        GL11.glTranslatef(0.0F, -0.5F, 0.0F);
        field_41059_i.func_922_a(f5);
        GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.8F + f2, 0.0F);
        GL11.glRotatef(60F, 0.7071F, 0.0F, 0.7071F);
        field_41058_h.func_922_a(f5);
        float f6 = 0.875F;
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(60F, 0.7071F, 0.0F, 0.7071F);
        GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
        field_41058_h.func_922_a(f5);
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(60F, 0.7071F, 0.0F, 0.7071F);
        GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
        field_41057_g.func_922_a(f5);
        GL11.glPopMatrix();
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_863_a(f, f1, f2, f3, f4, f5);
    }
}
