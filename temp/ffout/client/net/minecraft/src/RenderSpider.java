// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelSpider, OpenGlHelper, EntitySpider, 
//            EntityLiving

public class RenderSpider extends RenderLiving
{

    public RenderSpider()
    {
        super(new ModelSpider(), 1.0F);
        func_4013_a(new ModelSpider());
    }

    protected float func_191_a(EntitySpider entityspider)
    {
        return 180F;
    }

    protected int func_190_a(EntitySpider entityspider, int i, float f)
    {
        if(i != 0)
        {
            return -1;
        } else
        {
            func_151_a("/mob/spider_eyes.png");
            float f1 = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            int j = 61680;
            int k = j % 0x10000;
            int l = j / 0x10000;
            OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)k / 1.0F, (float)l / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    protected void func_35446_a(EntitySpider entityspider, float f)
    {
        float f1 = entityspider.func_35188_k_();
        GL11.glScalef(f1, f1, f1);
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
        func_35446_a((EntitySpider)entityliving, f);
    }

    protected float func_172_a(EntityLiving entityliving)
    {
        return func_191_a((EntitySpider)entityliving);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_190_a((EntitySpider)entityliving, i, f);
    }
}
