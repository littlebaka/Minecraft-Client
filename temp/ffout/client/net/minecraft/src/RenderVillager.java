// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelVillager, EntityVillager, EntityLiving, 
//            Entity

public class RenderVillager extends RenderLiving
{

    protected ModelVillager field_40295_c;

    public RenderVillager()
    {
        super(new ModelVillager(0.0F), 0.5F);
        field_40295_c = (ModelVillager)field_20920_e;
    }

    protected int func_40293_a(EntityVillager entityvillager, int i, float f)
    {
        return -1;
    }

    public void func_40294_a(EntityVillager entityvillager, double d, double d1, double d2, 
            float f, float f1)
    {
        super.func_171_a(entityvillager, d, d1, d2, f, f1);
    }

    protected void func_40290_a(EntityVillager entityvillager, double d, double d1, double d2)
    {
    }

    protected void func_40291_a(EntityVillager entityvillager, float f)
    {
        super.func_6331_b(entityvillager, f);
    }

    protected void func_40292_b(EntityVillager entityvillager, float f)
    {
        float f1 = 0.9375F;
        GL11.glScalef(f1, f1, f1);
    }

    protected void func_22014_a(EntityLiving entityliving, double d, double d1, double d2)
    {
        func_40290_a((EntityVillager)entityliving, d, d1, d2);
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
        func_40292_b((EntityVillager)entityliving, f);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_40293_a((EntityVillager)entityliving, i, f);
    }

    protected void func_6331_b(EntityLiving entityliving, float f)
    {
        func_40291_a((EntityVillager)entityliving, f);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40294_a((EntityVillager)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40294_a((EntityVillager)entity, d, d1, d2, f, f1);
    }
}
