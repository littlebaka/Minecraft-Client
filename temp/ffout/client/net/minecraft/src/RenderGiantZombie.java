// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityGiantZombie, ModelBase, EntityLiving

public class RenderGiantZombie extends RenderLiving
{

    private float field_204_f;

    public RenderGiantZombie(ModelBase modelbase, float f, float f1)
    {
        super(modelbase, f * f1);
        field_204_f = f1;
    }

    protected void func_175_a(EntityGiantZombie entitygiantzombie, float f)
    {
        GL11.glScalef(field_204_f, field_204_f, field_204_f);
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
        func_175_a((EntityGiantZombie)entityliving, f);
    }
}
