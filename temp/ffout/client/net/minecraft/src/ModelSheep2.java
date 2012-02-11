// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelQuadruped, ModelRenderer, EntitySheep, EntityLiving

public class ModelSheep2 extends ModelQuadruped
{

    private float field_44017_o;

    public ModelSheep2()
    {
        super(12, 0.0F);
        field_1266_d = new ModelRenderer(this, 0, 0);
        field_1266_d.func_923_a(-3F, -4F, -6F, 6, 6, 8, 0.0F);
        field_1266_d.func_925_a(0.0F, 6F, -8F);
        field_1265_e = new ModelRenderer(this, 28, 8);
        field_1265_e.func_923_a(-4F, -10F, -7F, 8, 16, 6, 0.0F);
        field_1265_e.func_925_a(0.0F, 5F, 2.0F);
    }

    public void func_25103_a(EntityLiving entityliving, float f, float f1, float f2)
    {
        super.func_25103_a(entityliving, f, f1, f2);
        field_1266_d.field_1409_b = 6F + ((EntitySheep)entityliving).func_44003_c(f2) * 9F;
        field_44017_o = ((EntitySheep)entityliving).func_44002_d(f2);
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_863_a(f, f1, f2, f3, f4, f5);
        field_1266_d.field_1407_d = field_44017_o;
    }
}
