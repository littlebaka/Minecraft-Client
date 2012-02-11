// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, Block, EntityFallingSand, 
//            Tessellator, MathHelper, Entity

public class RenderFallingSand extends Render
{

    private RenderBlocks field_197_d;

    public RenderFallingSand()
    {
        field_197_d = new RenderBlocks();
        field_9246_c = 0.5F;
    }

    public void func_156_a(EntityFallingSand entityfallingsand, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        func_151_a("/terrain.png");
        Block block = Block.field_345_n[entityfallingsand.field_799_a];
        World world = entityfallingsand.func_465_i();
        GL11.glDisable(2896);
        if(block == Block.field_41050_bK)
        {
            field_197_d.field_1772_a = world;
            Tessellator tessellator = Tessellator.field_1512_a;
            tessellator.func_977_b();
            tessellator.func_984_b((float)(-MathHelper.func_1108_b(entityfallingsand.field_611_ak)) - 0.5F, (float)(-MathHelper.func_1108_b(entityfallingsand.field_610_al)) - 0.5F, (float)(-MathHelper.func_1108_b(entityfallingsand.field_609_am)) - 0.5F);
            field_197_d.func_1234_a(block, MathHelper.func_1108_b(entityfallingsand.field_611_ak), MathHelper.func_1108_b(entityfallingsand.field_610_al), MathHelper.func_1108_b(entityfallingsand.field_609_am));
            tessellator.func_984_b(0.0D, 0.0D, 0.0D);
            tessellator.func_982_a();
        } else
        {
            field_197_d.func_1243_a(block, world, MathHelper.func_1108_b(entityfallingsand.field_611_ak), MathHelper.func_1108_b(entityfallingsand.field_610_al), MathHelper.func_1108_b(entityfallingsand.field_609_am));
        }
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_156_a((EntityFallingSand)entity, d, d1, d2, f, f1);
    }
}
