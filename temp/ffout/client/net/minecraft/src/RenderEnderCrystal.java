// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelEnderCrystal, EntityEnderCrystal, MathHelper, 
//            ModelBase, Entity

public class RenderEnderCrystal extends Render
{

    private int field_41037_a;
    private ModelBase field_41036_b;

    public RenderEnderCrystal()
    {
        field_41037_a = -1;
        field_9246_c = 0.5F;
    }

    public void func_41035_a(EntityEnderCrystal entityendercrystal, double d, double d1, double d2, 
            float f, float f1)
    {
        if(field_41037_a != 1)
        {
            field_41036_b = new ModelEnderCrystal(0.0F);
            field_41037_a = 1;
        }
        float f2 = (float)entityendercrystal.field_41032_a + f1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        func_151_a("/mob/enderdragon/crystal.png");
        float f3 = MathHelper.func_1106_a(f2 * 0.2F) / 2.0F + 0.5F;
        f3 = f3 * f3 + f3;
        field_41036_b.func_864_b(entityendercrystal, 0.0F, f2 * 3F, f3 * 0.2F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_41035_a((EntityEnderCrystal)entity, d, d1, d2, f, f1);
    }
}
