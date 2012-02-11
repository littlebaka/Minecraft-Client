// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, EntityItem, MathHelper, 
//            ItemStack, Block, Item, Tessellator, 
//            RenderManager, RenderEngine, FontRenderer, Entity

public class RenderItem extends Render
{

    private RenderBlocks field_201_d;
    private Random field_200_e;
    public boolean field_27004_a;
    public float field_40268_b;

    public RenderItem()
    {
        field_201_d = new RenderBlocks();
        field_200_e = new Random();
        field_27004_a = true;
        field_40268_b = 0.0F;
        field_9246_c = 0.15F;
        field_194_c = 0.75F;
    }

    public void func_165_a(EntityItem entityitem, double d, double d1, double d2, 
            float f, float f1)
    {
        field_200_e.setSeed(187L);
        ItemStack itemstack = entityitem.field_801_a;
        GL11.glPushMatrix();
        float f2 = MathHelper.func_1106_a(((float)entityitem.field_800_b + f1) / 10F + entityitem.field_804_d) * 0.1F + 0.1F;
        float f3 = (((float)entityitem.field_800_b + f1) / 20F + entityitem.field_804_d) * 57.29578F;
        byte byte0 = 1;
        if(entityitem.field_801_a.field_1615_a > 1)
        {
            byte0 = 2;
        }
        if(entityitem.field_801_a.field_1615_a > 5)
        {
            byte0 = 3;
        }
        if(entityitem.field_801_a.field_1615_a > 20)
        {
            byte0 = 4;
        }
        GL11.glTranslatef((float)d, (float)d1 + f2, (float)d2);
        GL11.glEnable(32826);
        if(itemstack.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[itemstack.field_1617_c].func_210_f()))
        {
            GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
            func_151_a("/terrain.png");
            float f4 = 0.25F;
            int k = Block.field_345_n[itemstack.field_1617_c].func_210_f();
            if(k == 1 || k == 19 || k == 12 || k == 2)
            {
                f4 = 0.5F;
            }
            GL11.glScalef(f4, f4, f4);
            for(int j1 = 0; j1 < byte0; j1++)
            {
                GL11.glPushMatrix();
                if(j1 > 0)
                {
                    float f7 = ((field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f10 = ((field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    float f13 = ((field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F) / f4;
                    GL11.glTranslatef(f7, f10, f13);
                }
                float f8 = 1.0F;
                field_201_d.func_1227_a(Block.field_345_n[itemstack.field_1617_c], itemstack.func_21181_i(), f8);
                GL11.glPopMatrix();
            }

        } else
        if(itemstack.func_1091_a().func_46058_c())
        {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            func_151_a("/gui/items.png");
            for(int i = 0; i <= 1; i++)
            {
                int l = itemstack.func_1091_a().func_46057_a(itemstack.func_21181_i(), i);
                float f5 = 1.0F;
                if(field_27004_a)
                {
                    int k1 = Item.field_233_c[itemstack.field_1617_c].func_27010_f(itemstack.func_21181_i(), i);
                    float f11 = (float)(k1 >> 16 & 0xff) / 255F;
                    float f14 = (float)(k1 >> 8 & 0xff) / 255F;
                    float f16 = (float)(k1 & 0xff) / 255F;
                    GL11.glColor4f(f11 * f5, f14 * f5, f16 * f5, 1.0F);
                }
                func_40267_a(l, byte0);
            }

        } else
        {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            int j = itemstack.func_1088_b();
            if(itemstack.field_1617_c < 256)
            {
                func_151_a("/terrain.png");
            } else
            {
                func_151_a("/gui/items.png");
            }
            if(field_27004_a)
            {
                int i1 = Item.field_233_c[itemstack.field_1617_c].func_27010_f(itemstack.func_21181_i(), 0);
                float f6 = (float)(i1 >> 16 & 0xff) / 255F;
                float f9 = (float)(i1 >> 8 & 0xff) / 255F;
                float f12 = (float)(i1 & 0xff) / 255F;
                float f15 = 1.0F;
                GL11.glColor4f(f6 * f15, f9 * f15, f12 * f15, 1.0F);
            }
            func_40267_a(j, byte0);
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_40267_a(int i, int j)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        float f = (float)((i % 16) * 16 + 0) / 256F;
        float f1 = (float)((i % 16) * 16 + 16) / 256F;
        float f2 = (float)((i / 16) * 16 + 0) / 256F;
        float f3 = (float)((i / 16) * 16 + 16) / 256F;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        for(int k = 0; k < j; k++)
        {
            GL11.glPushMatrix();
            if(k > 0)
            {
                float f7 = (field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                float f8 = (field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                float f9 = (field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                GL11.glTranslatef(f7, f8, f9);
            }
            GL11.glRotatef(180F - field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 1.0F, 0.0F);
            tessellator.func_983_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
            tessellator.func_983_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
            tessellator.func_983_a(f4 - f5, 1.0F - f6, 0.0D, f1, f2);
            tessellator.func_983_a(0.0F - f5, 1.0F - f6, 0.0D, f, f2);
            tessellator.func_982_a();
            GL11.glPopMatrix();
        }

    }

    public void func_27003_a(FontRenderer fontrenderer, RenderEngine renderengine, int i, int j, int k, int l, int i1)
    {
        if(i < 256 && RenderBlocks.func_1219_a(Block.field_345_n[i].func_210_f()))
        {
            int j1 = i;
            renderengine.func_1076_b(renderengine.func_1070_a("/terrain.png"));
            Block block = Block.field_345_n[j1];
            GL11.glPushMatrix();
            GL11.glTranslatef(l - 2, i1 + 3, -3F + field_40268_b);
            GL11.glScalef(10F, 10F, 10F);
            GL11.glTranslatef(1.0F, 0.5F, 1.0F);
            GL11.glScalef(1.0F, 1.0F, -1F);
            GL11.glRotatef(210F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            int j2 = Item.field_233_c[i].func_27010_f(j, 0);
            float f2 = (float)(j2 >> 16 & 0xff) / 255F;
            float f5 = (float)(j2 >> 8 & 0xff) / 255F;
            float f7 = (float)(j2 & 0xff) / 255F;
            if(field_27004_a)
            {
                GL11.glColor4f(f2, f5, f7, 1.0F);
            }
            GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
            field_201_d.field_31088_b = field_27004_a;
            field_201_d.func_1227_a(block, j, 1.0F);
            field_201_d.field_31088_b = true;
            GL11.glPopMatrix();
        } else
        if(Item.field_233_c[i].func_46058_c())
        {
            GL11.glDisable(2896);
            renderengine.func_1076_b(renderengine.func_1070_a("/gui/items.png"));
            for(int k1 = 0; k1 <= 1; k1++)
            {
                int i2 = Item.field_233_c[i].func_46057_a(j, k1);
                int k2 = Item.field_233_c[i].func_27010_f(j, k1);
                float f3 = (float)(k2 >> 16 & 0xff) / 255F;
                float f6 = (float)(k2 >> 8 & 0xff) / 255F;
                float f8 = (float)(k2 & 0xff) / 255F;
                if(field_27004_a)
                {
                    GL11.glColor4f(f3, f6, f8, 1.0F);
                }
                func_163_a(l, i1, (i2 % 16) * 16, (i2 / 16) * 16, 16, 16);
            }

            GL11.glEnable(2896);
        } else
        if(k >= 0)
        {
            GL11.glDisable(2896);
            if(i < 256)
            {
                renderengine.func_1076_b(renderengine.func_1070_a("/terrain.png"));
            } else
            {
                renderengine.func_1076_b(renderengine.func_1070_a("/gui/items.png"));
            }
            int l1 = Item.field_233_c[i].func_27010_f(j, 0);
            float f = (float)(l1 >> 16 & 0xff) / 255F;
            float f1 = (float)(l1 >> 8 & 0xff) / 255F;
            float f4 = (float)(l1 & 0xff) / 255F;
            if(field_27004_a)
            {
                GL11.glColor4f(f, f1, f4, 1.0F);
            }
            func_163_a(l, i1, (k % 16) * 16, (k / 16) * 16, 16, 16);
            GL11.glEnable(2896);
        }
        GL11.glEnable(2884);
    }

    public void func_161_a(FontRenderer fontrenderer, RenderEngine renderengine, ItemStack itemstack, int i, int j)
    {
        if(itemstack == null)
        {
            return;
        }
        func_27003_a(fontrenderer, renderengine, itemstack.field_1617_c, itemstack.func_21181_i(), itemstack.func_1088_b(), i, j);
        if(itemstack != null && itemstack.func_40713_r())
        {
            GL11.glDepthFunc(516);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            renderengine.func_1076_b(renderengine.func_1070_a("%blur%/misc/glint.png"));
            field_40268_b -= 50F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(774, 774);
            GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
            func_40266_a(i * 0x19b4ca14 + j * 0x1eafff1, i - 2, j - 2, 20, 20);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            field_40268_b += 50F;
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
    }

    private void func_40266_a(int i, int j, int k, int l, int i1)
    {
        for(int j1 = 0; j1 < 2; j1++)
        {
            if(j1 == 0)
            {
                GL11.glBlendFunc(768, 1);
            }
            if(j1 == 1)
            {
                GL11.glBlendFunc(768, 1);
            }
            float f = 0.00390625F;
            float f1 = 0.00390625F;
            float f2 = ((float)(System.currentTimeMillis() % (long)(3000 + j1 * 1873)) / (3000F + (float)(j1 * 1873))) * 256F;
            float f3 = 0.0F;
            Tessellator tessellator = Tessellator.field_1512_a;
            float f4 = 4F;
            if(j1 == 1)
            {
                f4 = -1F;
            }
            tessellator.func_977_b();
            tessellator.func_983_a(j + 0, k + i1, field_40268_b, (f2 + (float)i1 * f4) * f, (f3 + (float)i1) * f1);
            tessellator.func_983_a(j + l, k + i1, field_40268_b, (f2 + (float)l + (float)i1 * f4) * f, (f3 + (float)i1) * f1);
            tessellator.func_983_a(j + l, k + 0, field_40268_b, (f2 + (float)l) * f, (f3 + 0.0F) * f1);
            tessellator.func_983_a(j + 0, k + 0, field_40268_b, (f2 + 0.0F) * f, (f3 + 0.0F) * f1);
            tessellator.func_982_a();
        }

    }

    public void func_164_b(FontRenderer fontrenderer, RenderEngine renderengine, ItemStack itemstack, int i, int j)
    {
        if(itemstack == null)
        {
            return;
        }
        if(itemstack.field_1615_a > 1)
        {
            String s = (new StringBuilder()).append("").append(itemstack.field_1615_a).toString();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            fontrenderer.func_874_a(s, (i + 19) - 2 - fontrenderer.func_871_a(s), j + 6 + 3, 0xffffff);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        if(itemstack.func_21185_g())
        {
            int k = (int)Math.round(13D - ((double)itemstack.func_21179_h() * 13D) / (double)itemstack.func_1094_d());
            int l = (int)Math.round(255D - ((double)itemstack.func_21179_h() * 255D) / (double)itemstack.func_1094_d());
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            Tessellator tessellator = Tessellator.field_1512_a;
            int i1 = 255 - l << 16 | l << 8;
            int j1 = (255 - l) / 4 << 16 | 0x3f00;
            func_162_a(tessellator, i + 2, j + 13, 13, 2, 0);
            func_162_a(tessellator, i + 2, j + 13, 12, 1, j1);
            func_162_a(tessellator, i + 2, j + 13, k, 1, i1);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    private void func_162_a(Tessellator tessellator, int i, int j, int k, int l, int i1)
    {
        tessellator.func_977_b();
        tessellator.func_990_b(i1);
        tessellator.func_991_a(i + 0, j + 0, 0.0D);
        tessellator.func_991_a(i + 0, j + l, 0.0D);
        tessellator.func_991_a(i + k, j + l, 0.0D);
        tessellator.func_991_a(i + k, j + 0, 0.0D);
        tessellator.func_982_a();
    }

    public void func_163_a(int i, int j, int k, int l, int i1, int j1)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_983_a(i + 0, j + j1, field_40268_b, (float)(k + 0) * f, (float)(l + j1) * f1);
        tessellator.func_983_a(i + i1, j + j1, field_40268_b, (float)(k + i1) * f, (float)(l + j1) * f1);
        tessellator.func_983_a(i + i1, j + 0, field_40268_b, (float)(k + i1) * f, (float)(l + 0) * f1);
        tessellator.func_983_a(i + 0, j + 0, field_40268_b, (float)(k + 0) * f, (float)(l + 0) * f1);
        tessellator.func_982_a();
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_165_a((EntityItem)entity, d, d1, d2, f, f1);
    }
}
