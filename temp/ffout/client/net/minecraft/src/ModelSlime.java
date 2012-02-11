// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelSlime extends ModelBase
{

    ModelRenderer field_1258_a;
    ModelRenderer field_1257_b;
    ModelRenderer field_1260_c;
    ModelRenderer field_1259_d;

    public ModelSlime(int i)
    {
        field_1258_a = new ModelRenderer(this, 0, i);
        field_1258_a.func_40604_a(-4F, 16F, -4F, 8, 8, 8);
        if(i > 0)
        {
            field_1258_a = new ModelRenderer(this, 0, i);
            field_1258_a.func_40604_a(-3F, 17F, -3F, 6, 6, 6);
            field_1257_b = new ModelRenderer(this, 32, 0);
            field_1257_b.func_40604_a(-3.25F, 18F, -3.5F, 2, 2, 2);
            field_1260_c = new ModelRenderer(this, 32, 4);
            field_1260_c.func_40604_a(1.25F, 18F, -3.5F, 2, 2, 2);
            field_1259_d = new ModelRenderer(this, 32, 8);
            field_1259_d.func_40604_a(0.0F, 21F, -3.5F, 1, 1, 1);
        }
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_863_a(f, f1, f2, f3, f4, f5);
        field_1258_a.func_922_a(f5);
        if(field_1257_b != null)
        {
            field_1257_b.func_922_a(f5);
            field_1260_c.func_922_a(f5);
            field_1259_d.func_922_a(f5);
        }
    }
}
