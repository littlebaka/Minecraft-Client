// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelGhast extends ModelBase
{

    ModelRenderer field_4258_a;
    ModelRenderer field_4257_b[];

    public ModelGhast()
    {
        field_4257_b = new ModelRenderer[9];
        byte byte0 = -16;
        field_4258_a = new ModelRenderer(this, 0, 0);
        field_4258_a.func_40604_a(-8F, -8F, -8F, 16, 16, 16);
        field_4258_a.field_1409_b += 24 + byte0;
        Random random = new Random(1660L);
        for(int i = 0; i < field_4257_b.length; i++)
        {
            field_4257_b[i] = new ModelRenderer(this, 0, 0);
            float f = (((((float)(i % 3) - (float)((i / 3) % 2) * 0.5F) + 0.25F) / 2.0F) * 2.0F - 1.0F) * 5F;
            float f1 = (((float)(i / 3) / 2.0F) * 2.0F - 1.0F) * 5F;
            int j = random.nextInt(7) + 8;
            field_4257_b[i].func_40604_a(-1F, 0.0F, -1F, 2, j, 2);
            field_4257_b[i].field_1410_a = f;
            field_4257_b[i].field_1408_c = f1;
            field_4257_b[i].field_1409_b = 31 + byte0;
        }

    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        for(int i = 0; i < field_4257_b.length; i++)
        {
            field_4257_b[i].field_1407_d = 0.2F * MathHelper.func_1106_a(f2 * 0.3F + (float)i) + 0.4F;
        }

    }

    public void func_864_b(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        func_863_a(f, f1, f2, f3, f4, f5);
        field_4258_a.func_922_a(f5);
        for(int i = 0; i < field_4257_b.length; i++)
        {
            field_4257_b[i].func_922_a(f5);
        }

    }
}
