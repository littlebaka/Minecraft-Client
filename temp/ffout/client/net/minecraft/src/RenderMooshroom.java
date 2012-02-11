// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityMooshroom, Block, RenderBlocks, 
//            ModelQuadruped, ModelRenderer, ModelBase, EntityLiving, 
//            Entity

public class RenderMooshroom extends RenderLiving
{

    public RenderMooshroom(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void func_40273_a(EntityMooshroom entitymooshroom, double d, double d1, double d2, 
            float f, float f1)
    {
        super.func_171_a(entitymooshroom, d, d1, d2, f, f1);
    }

    protected void func_40272_a(EntityMooshroom entitymooshroom, float f)
    {
        super.func_6331_b(entitymooshroom, f);
        if(entitymooshroom.func_40127_l())
        {
            return;
        } else
        {
            func_151_a("/terrain.png");
            GL11.glEnable(2884);
            GL11.glPushMatrix();
            GL11.glScalef(1.0F, -1F, 1.0F);
            GL11.glTranslatef(0.2F, 0.4F, 0.5F);
            GL11.glRotatef(42F, 0.0F, 1.0F, 0.0F);
            field_203_d.func_1227_a(Block.field_414_ah, 0, 1.0F);
            GL11.glTranslatef(0.1F, 0.0F, -0.6F);
            GL11.glRotatef(42F, 0.0F, 1.0F, 0.0F);
            field_203_d.func_1227_a(Block.field_414_ah, 0, 1.0F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            ((ModelQuadruped)field_20920_e).field_1266_d.func_926_b(0.0625F);
            GL11.glScalef(1.0F, -1F, 1.0F);
            GL11.glTranslatef(0.0F, 0.75F, -0.2F);
            GL11.glRotatef(12F, 0.0F, 1.0F, 0.0F);
            field_203_d.func_1227_a(Block.field_414_ah, 0, 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(2884);
            return;
        }
    }

    protected void func_6331_b(EntityLiving entityliving, float f)
    {
        func_40272_a((EntityMooshroom)entityliving, f);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40273_a((EntityMooshroom)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_40273_a((EntityMooshroom)entity, d, d1, d2, f, f1);
    }
}
