// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelCreeper extends ModelBase
{

    public ModelRenderer field_1271_a;
    public ModelRenderer field_1270_b;
    public ModelRenderer field_1276_c;
    public ModelRenderer field_1275_d;
    public ModelRenderer field_1274_e;
    public ModelRenderer field_1273_f;
    public ModelRenderer field_1272_g;

    public ModelCreeper()
    {
        this(0.0F);
    }

    public ModelCreeper(float f)
    {
        int i = 4;
        field_1271_a = new ModelRenderer(this, 0, 0);
        field_1271_a.func_923_a(-4F, -8F, -4F, 8, 8, 8, f);
        field_1271_a.func_925_a(0.0F, i, 0.0F);
        field_1270_b = new ModelRenderer(this, 32, 0);
        field_1270_b.func_923_a(-4F, -8F, -4F, 8, 8, 8, f + 0.5F);
        field_1270_b.func_925_a(0.0F, i, 0.0F);
        field_1276_c = new ModelRenderer(this, 16, 16);
        field_1276_c.func_923_a(-4F, 0.0F, -2F, 8, 12, 4, f);
        field_1276_c.func_925_a(0.0F, i, 0.0F);
        field_1275_d = new ModelRenderer(this, 0, 16);
        field_1275_d.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1275_d.func_925_a(-2F, 12 + i, 4F);
        field_1274_e = new ModelRenderer(this, 0, 16);
        field_1274_e.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1274_e.func_925_a(2.0F, 12 + i, 4F);
        field_1273_f = new ModelRenderer(this, 0, 16);
        field_1273_f.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1273_f.func_925_a(-2F, 12 + i, -4F);
        field_1272_g = new ModelRenderer(this, 0, 16);
        field_1272_g.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1272_g.func_925_a(2.0F, 12 + i, -4F);
    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_863_a(f, f1, f2, f3, f4, f5);
        field_1271_a.func_922_a(f5);
        field_1276_c.func_922_a(f5);
        field_1275_d.func_922_a(f5);
        field_1274_e.func_922_a(f5);
        field_1273_f.func_922_a(f5);
        field_1272_g.func_922_a(f5);
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        field_1271_a.field_1406_e = f3 / 57.29578F;
        field_1271_a.field_1407_d = f4 / 57.29578F;
        field_1275_d.field_1407_d = MathHelper.func_1114_b(f * 0.6662F) * 1.4F * f1;
        field_1274_e.field_1407_d = MathHelper.func_1114_b(f * 0.6662F + 3.141593F) * 1.4F * f1;
        field_1273_f.field_1407_d = MathHelper.func_1114_b(f * 0.6662F + 3.141593F) * 1.4F * f1;
        field_1272_g.field_1407_d = MathHelper.func_1114_b(f * 0.6662F) * 1.4F * f1;
    }
}
