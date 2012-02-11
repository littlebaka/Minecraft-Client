// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBiped, MathHelper, ModelRenderer

public class ModelZombie extends ModelBiped
{

    public ModelZombie()
    {
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.func_863_a(f, f1, f2, f3, f4, f5);
        float f6 = MathHelper.func_1106_a(field_1244_k * 3.141593F);
        float f7 = MathHelper.func_1106_a((1.0F - (1.0F - field_1244_k) * (1.0F - field_1244_k)) * 3.141593F);
        field_1283_d.field_1405_f = 0.0F;
        field_1282_e.field_1405_f = 0.0F;
        field_1283_d.field_1406_e = -(0.1F - f6 * 0.6F);
        field_1282_e.field_1406_e = 0.1F - f6 * 0.6F;
        field_1283_d.field_1407_d = -1.570796F;
        field_1282_e.field_1407_d = -1.570796F;
        field_1283_d.field_1407_d -= f6 * 1.2F - f7 * 0.4F;
        field_1282_e.field_1407_d -= f6 * 1.2F - f7 * 0.4F;
        field_1283_d.field_1405_f += MathHelper.func_1114_b(f2 * 0.09F) * 0.05F + 0.05F;
        field_1282_e.field_1405_f -= MathHelper.func_1114_b(f2 * 0.09F) * 0.05F + 0.05F;
        field_1283_d.field_1407_d += MathHelper.func_1106_a(f2 * 0.067F) * 0.05F;
        field_1282_e.field_1407_d -= MathHelper.func_1106_a(f2 * 0.067F) * 0.05F;
    }
}
