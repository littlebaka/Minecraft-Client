// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySlime, ModelBase, EntityLiving

public class RenderSlime extends RenderLiving
{

    private ModelBase field_205_f;

    public RenderSlime(ModelBase modelbase, ModelBase modelbase1, float f)
    {
        super(modelbase, f);
        field_205_f = modelbase1;
    }

    protected int func_40287_a(EntitySlime entityslime, int i, float f)
    {
        if(i == 0)
        {
            func_4013_a(field_205_f);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if(i == 1)
        {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        return -1;
    }

    protected void func_178_a(EntitySlime entityslime, float f)
    {
        int i = entityslime.func_25027_v();
        float f1 = (entityslime.field_767_b + (entityslime.field_768_a - entityslime.field_767_b) * f) / ((float)i * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        float f3 = i;
        GL11.glScalef(f2 * f3, (1.0F / f2) * f3, f2 * f3);
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
        func_178_a((EntitySlime)entityliving, f);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_40287_a((EntitySlime)entityliving, i, f);
    }
}
