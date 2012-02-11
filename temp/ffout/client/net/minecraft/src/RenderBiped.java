// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityLiving, ModelBiped, ModelRenderer, 
//            ItemStack, Block, RenderBlocks, Item, 
//            RenderManager, ItemRenderer

public class RenderBiped extends RenderLiving
{

    protected ModelBiped field_4013_a;
    protected float field_40296_d;

    public RenderBiped(ModelBiped modelbiped, float f)
    {
        this(modelbiped, f, 1.0F);
        field_4013_a = modelbiped;
    }

    public RenderBiped(ModelBiped modelbiped, float f, float f1)
    {
        super(modelbiped, f);
        field_4013_a = modelbiped;
        field_40296_d = f1;
    }

    protected void func_6331_b(EntityLiving entityliving, float f)
    {
        super.func_6331_b(entityliving, f);
        ItemStack itemstack = entityliving.func_4045_l();
        if(itemstack != null)
        {
            GL11.glPushMatrix();
            field_4013_a.field_1283_d.func_926_b(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if(itemstack.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[itemstack.field_1617_c].func_210_f()))
            {
                float f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f1 *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            } else
            if(itemstack.field_1617_c == Item.field_227_i.field_291_aS)
            {
                float f2 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            if(Item.field_233_c[itemstack.field_1617_c].func_4017_a())
            {
                float f3 = 0.625F;
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f4 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f4, f4, f4);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            field_191_a.field_4236_f.func_4132_a(entityliving, itemstack, 0);
            if(itemstack.func_1091_a().func_46058_c())
            {
                field_191_a.field_4236_f.func_4132_a(entityliving, itemstack, 1);
            }
            GL11.glPopMatrix();
        }
    }
}
