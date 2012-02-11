// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelSnowMan extends ModelBase
{

    public ModelRenderer field_40306_a;
    public ModelRenderer field_40304_b;
    public ModelRenderer field_40305_c;
    public ModelRenderer field_40302_d;
    public ModelRenderer field_40303_e;

    public ModelSnowMan()
    {
        float f = 4F;
        float f1 = 0.0F;
        field_40305_c = (new ModelRenderer(this, 0, 0)).func_35968_a(64, 64);
        field_40305_c.func_923_a(-4F, -8F, -4F, 8, 8, 8, f1 - 0.5F);
        field_40305_c.func_925_a(0.0F, 0.0F + f, 0.0F);
        field_40302_d = (new ModelRenderer(this, 32, 0)).func_35968_a(64, 64);
        field_40302_d.func_923_a(-1F, 0.0F, -1F, 12, 2, 2, f1 - 0.5F);
        field_40302_d.func_925_a(0.0F, (0.0F + f + 9F) - 7F, 0.0F);
        field_40303_e = (new ModelRenderer(this, 32, 0)).func_35968_a(64, 64);
        field_40303_e.func_923_a(-1F, 0.0F, -1F, 12, 2, 2, f1 - 0.5F);
        field_40303_e.func_925_a(0.0F, (0.0F + f + 9F) - 7F, 0.0F);
        field_40306_a = (new ModelRenderer(this, 0, 16)).func_35968_a(64, 64);
        field_40306_a.func_923_a(-5F, -10F, -5F, 10, 10, 10, f1 - 0.5F);
        field_40306_a.func_925_a(0.0F, 0.0F + f + 9F, 0.0F);
        field_40304_b = (new ModelRenderer(this, 0, 36)).func_35968_a(64, 64);
        field_40304_b.func_923_a(-6F, -12F, -6F, 12, 12, 12, f1 - 0.5F);
        field_40304_b.func_925_a(0.0F, 0.0F + f + 20F, 0.0F);
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_863_a(f, f1, f2, f3, f4, f5);
        field_40305_c.field_1406_e = f3 / 57.29578F;
        field_40305_c.field_1407_d = f4 / 57.29578F;
        field_40306_a.field_1406_e = (f3 / 57.29578F) * 0.25F;
        float f6 = MathHelper.func_1106_a(field_40306_a.field_1406_e);
        float f7 = MathHelper.func_1114_b(field_40306_a.field_1406_e);
        field_40302_d.field_1405_f = 1.0F;
        field_40303_e.field_1405_f = -1F;
        field_40302_d.field_1406_e = 0.0F + field_40306_a.field_1406_e;
        field_40303_e.field_1406_e = 3.141593F + field_40306_a.field_1406_e;
        field_40302_d.field_1410_a = f7 * 5F;
        field_40302_d.field_1408_c = -f6 * 5F;
        field_40303_e.field_1410_a = -f7 * 5F;
        field_40303_e.field_1408_c = f6 * 5F;
    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_863_a(f, f1, f2, f3, f4, f5);
        field_40306_a.func_922_a(f5);
        field_40304_b.func_922_a(f5);
        field_40305_c.func_922_a(f5);
        field_40302_d.func_922_a(f5);
        field_40303_e.func_922_a(f5);
    }
}
