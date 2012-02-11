// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, SignModel, TileEntitySign, Block, 
//            ModelRenderer, FontRenderer, TileEntity

public class TileEntitySignRenderer extends TileEntitySpecialRenderer
{

    private SignModel field_1413_b;

    public TileEntitySignRenderer()
    {
        field_1413_b = new SignModel();
    }

    public void func_932_a(TileEntitySign tileentitysign, double d, double d1, double d2, 
            float f)
    {
        Block block = tileentitysign.func_478_g();
        GL11.glPushMatrix();
        float f1 = 0.6666667F;
        if(block == Block.field_443_aE)
        {
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.75F * f1, (float)d2 + 0.5F);
            float f2 = (float)(tileentitysign.func_479_f() * 360) / 16F;
            GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
            field_1413_b.field_1345_b.field_1403_h = true;
        } else
        {
            int i = tileentitysign.func_479_f();
            float f3 = 0.0F;
            if(i == 2)
            {
                f3 = 180F;
            }
            if(i == 4)
            {
                f3 = 90F;
            }
            if(i == 5)
            {
                f3 = -90F;
            }
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.75F * f1, (float)d2 + 0.5F);
            GL11.glRotatef(-f3, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
            field_1413_b.field_1345_b.field_1403_h = false;
        }
        func_6507_a("/item/sign.png");
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        field_1413_b.func_887_a();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = func_6508_a();
        float f4 = 0.01666667F * f1;
        GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
        GL11.glScalef(f4, -f4, f4);
        GL11.glNormal3f(0.0F, 0.0F, -1F * f4);
        GL11.glDepthMask(false);
        int j = 0;
        for(int k = 0; k < tileentitysign.field_826_a.length; k++)
        {
            String s = tileentitysign.field_826_a[k];
            if(k == tileentitysign.field_825_b)
            {
                s = (new StringBuilder()).append("> ").append(s).append(" <").toString();
                fontrenderer.func_873_b(s, -fontrenderer.func_871_a(s) / 2, k * 10 - tileentitysign.field_826_a.length * 5, j);
            } else
            {
                fontrenderer.func_873_b(s, -fontrenderer.func_871_a(s) / 2, k * 10 - tileentitysign.field_826_a.length * 5, j);
            }
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void func_930_a(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        func_932_a((TileEntitySign)tileentity, d, d1, d2, f);
    }
}
