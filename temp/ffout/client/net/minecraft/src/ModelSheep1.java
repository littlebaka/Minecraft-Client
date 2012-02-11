// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelQuadruped, ModelRenderer, EntitySheep, EntityLiving

public class ModelSheep1 extends ModelQuadruped
{

    private float field_44016_o;

    public ModelSheep1()
    {
        super(12, 0.0F);
        field_1266_d = new ModelRenderer(this, 0, 0);
        field_1266_d.func_923_a(-3F, -4F, -4F, 6, 6, 6, 0.6F);
        field_1266_d.func_925_a(0.0F, 6F, -8F);
        field_1265_e = new ModelRenderer(this, 28, 8);
        field_1265_e.func_923_a(-4F, -10F, -7F, 8, 16, 6, 1.75F);
        field_1265_e.func_925_a(0.0F, 5F, 2.0F);
        float f = 0.5F;
        field_1264_f = new ModelRenderer(this, 0, 16);
        field_1264_f.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1264_f.func_925_a(-3F, 12F, 7F);
        field_1263_g = new ModelRenderer(this, 0, 16);
        field_1263_g.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1263_g.func_925_a(3F, 12F, 7F);
        field_1262_h = new ModelRenderer(this, 0, 16);
        field_1262_h.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1262_h.func_925_a(-3F, 12F, -5F);
        field_1261_i = new ModelRenderer(this, 0, 16);
        field_1261_i.func_923_a(-2F, 0.0F, -2F, 4, 6, 4, f);
        field_1261_i.func_925_a(3F, 12F, -5F);
    }

    public void func_25103_a(EntityLiving entityliving, float f, float f1, float f2)
    {
        super.func_25103_a(entityliving, f, f1, f2);
        field_1266_d.field_1409_b = 6F + ((EntitySheep)entityliving).func_44003_c(f2) * 9F;
        field_44016_o = ((EntitySheep)entityliving).func_44002_d(f2);
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_863_a(f, f1, f2, f3, f4, f5);
        field_1266_d.field_1407_d = field_44016_o;
    }
}
