// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, GLAllocation, TileEntityRenderer, ActiveRenderInfo, 
//            Tessellator, TileEntityEndPortal, TileEntity

public class RenderEndPortal extends TileEntitySpecialRenderer
{

    FloatBuffer field_40448_a;

    public RenderEndPortal()
    {
        field_40448_a = GLAllocation.func_1123_d(16);
    }

    public void func_40446_a(TileEntityEndPortal tileentityendportal, double d, double d1, double d2, 
            float f)
    {
        float f1 = (float)field_6509_a.field_1545_j;
        float f2 = (float)field_6509_a.field_1544_k;
        float f3 = (float)field_6509_a.field_1543_l;
        GL11.glDisable(2896);
        Random random = new Random(31100L);
        float f4 = 0.75F;
        for(int i = 0; i < 16; i++)
        {
            GL11.glPushMatrix();
            float f5 = 16 - i;
            float f6 = 0.0625F;
            float f7 = 1.0F / (f5 + 1.0F);
            if(i == 0)
            {
                func_6507_a("/misc/tunnel.png");
                f7 = 0.1F;
                f5 = 65F;
                f6 = 0.125F;
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
            }
            if(i == 1)
            {
                func_6507_a("/misc/particlefield.png");
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 1);
                f6 = 0.5F;
            }
            float f8 = (float)(-(d1 + (double)f4));
            float f9 = f8 + ActiveRenderInfo.field_41072_b;
            float f10 = f8 + f5 + ActiveRenderInfo.field_41072_b;
            float f11 = f9 / f10;
            f11 = (float)(d1 + (double)f4) + f11;
            GL11.glTranslatef(f1, f11, f3);
            GL11.glTexGeni(8192, 9472, 9217);
            GL11.glTexGeni(8193, 9472, 9217);
            GL11.glTexGeni(8194, 9472, 9217);
            GL11.glTexGeni(8195, 9472, 9216);
            GL11.glTexGen(8192, 9473, func_40447_a(1.0F, 0.0F, 0.0F, 0.0F));
            GL11.glTexGen(8193, 9473, func_40447_a(0.0F, 0.0F, 1.0F, 0.0F));
            GL11.glTexGen(8194, 9473, func_40447_a(0.0F, 0.0F, 0.0F, 1.0F));
            GL11.glTexGen(8195, 9474, func_40447_a(0.0F, 1.0F, 0.0F, 0.0F));
            GL11.glEnable(3168);
            GL11.glEnable(3169);
            GL11.glEnable(3170);
            GL11.glEnable(3171);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, (float)(System.currentTimeMillis() % 0xaae60L) / 700000F, 0.0F);
            GL11.glScalef(f6, f6, f6);
            GL11.glTranslatef(0.5F, 0.5F, 0.0F);
            GL11.glRotatef((float)(i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
            GL11.glTranslatef(-f1, -f3, -f2);
            f9 = f8 + ActiveRenderInfo.field_41072_b;
            GL11.glTranslatef((ActiveRenderInfo.field_41074_a * f5) / f9, (ActiveRenderInfo.field_41073_c * f5) / f9, -f2);
            Tessellator tessellator = Tessellator.field_1512_a;
            tessellator.func_977_b();
            f11 = random.nextFloat() * 0.5F + 0.1F;
            float f12 = random.nextFloat() * 0.5F + 0.4F;
            float f13 = random.nextFloat() * 0.5F + 0.5F;
            if(i == 0)
            {
                f11 = f12 = f13 = 1.0F;
            }
            tessellator.func_986_a(f11 * f7, f12 * f7, f13 * f7, 1.0F);
            tessellator.func_991_a(d, d1 + (double)f4, d2);
            tessellator.func_991_a(d, d1 + (double)f4, d2 + 1.0D);
            tessellator.func_991_a(d + 1.0D, d1 + (double)f4, d2 + 1.0D);
            tessellator.func_991_a(d + 1.0D, d1 + (double)f4, d2);
            tessellator.func_982_a();
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
        }

        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }

    private FloatBuffer func_40447_a(float f, float f1, float f2, float f3)
    {
        field_40448_a.clear();
        field_40448_a.put(f).put(f1).put(f2).put(f3);
        field_40448_a.flip();
        return field_40448_a;
    }

    public void func_930_a(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        func_40446_a((TileEntityEndPortal)tileentity, d, d1, d2, f);
    }
}
