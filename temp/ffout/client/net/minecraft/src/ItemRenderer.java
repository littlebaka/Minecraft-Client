// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderBlocks, MapItemRenderer, ItemStack, Block, 
//            RenderEngine, Tessellator, EntityLiving, EntityPlayer, 
//            RenderHelper, EntityPlayerSP, MathHelper, World, 
//            OpenGlHelper, Item, ItemMap, RenderManager, 
//            RenderPlayer, EnumAction, Material, BlockFire, 
//            InventoryPlayer

public class ItemRenderer
{

    private Minecraft field_1356_a;
    private ItemStack field_9451_b;
    private float field_9453_c;
    private float field_9452_d;
    private RenderBlocks field_1357_e;
    private MapItemRenderer field_28131_f;
    private int field_20099_f;

    public ItemRenderer(Minecraft minecraft)
    {
        field_9451_b = null;
        field_9453_c = 0.0F;
        field_9452_d = 0.0F;
        field_1357_e = new RenderBlocks();
        field_20099_f = -1;
        field_1356_a = minecraft;
        field_28131_f = new MapItemRenderer(minecraft.field_6314_o, minecraft.field_6304_y, minecraft.field_6315_n);
    }

    public void func_4132_a(EntityLiving entityliving, ItemStack itemstack, int i)
    {
        GL11.glPushMatrix();
        if(itemstack.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[itemstack.field_1617_c].func_210_f()))
        {
            GL11.glBindTexture(3553, field_1356_a.field_6315_n.func_1070_a("/terrain.png"));
            field_1357_e.func_1227_a(Block.field_345_n[itemstack.field_1617_c], itemstack.func_21181_i(), 1.0F);
        } else
        {
            if(itemstack.field_1617_c < 256)
            {
                GL11.glBindTexture(3553, field_1356_a.field_6315_n.func_1070_a("/terrain.png"));
            } else
            {
                GL11.glBindTexture(3553, field_1356_a.field_6315_n.func_1070_a("/gui/items.png"));
            }
            Tessellator tessellator = Tessellator.field_1512_a;
            int j = entityliving.func_28021_c(itemstack, i);
            float f = ((float)((j % 16) * 16) + 0.0F) / 256F;
            float f1 = ((float)((j % 16) * 16) + 15.99F) / 256F;
            float f2 = ((float)((j / 16) * 16) + 0.0F) / 256F;
            float f3 = ((float)((j / 16) * 16) + 15.99F) / 256F;
            float f4 = 0.0F;
            float f5 = 0.3F;
            GL11.glEnable(32826);
            GL11.glTranslatef(-f4, -f5, 0.0F);
            float f6 = 1.5F;
            GL11.glScalef(f6, f6, f6);
            GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(335F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
            func_40686_a(tessellator, f1, f2, f, f3);
            if(itemstack != null && itemstack.func_40713_r() && i == 0)
            {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                field_1356_a.field_6315_n.func_1076_b(field_1356_a.field_6315_n.func_1070_a("%blur%/misc/glint.png"));
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                float f7 = 0.76F;
                GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                float f8 = 0.125F;
                GL11.glScalef(f8, f8, f8);
                float f9 = ((float)(System.currentTimeMillis() % 3000L) / 3000F) * 8F;
                GL11.glTranslatef(f9, 0.0F, 0.0F);
                GL11.glRotatef(-50F, 0.0F, 0.0F, 1.0F);
                func_40686_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = ((float)(System.currentTimeMillis() % 4873L) / 4873F) * 8F;
                GL11.glTranslatef(-f9, 0.0F, 0.0F);
                GL11.glRotatef(10F, 0.0F, 0.0F, 1.0F);
                func_40686_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glDisable(32826);
        }
        GL11.glPopMatrix();
    }

    private void func_40686_a(Tessellator tessellator, float f, float f1, float f2, float f3)
    {
        float f4 = 1.0F;
        float f5 = 0.0625F;
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, 0.0F, 1.0F);
        tessellator.func_983_a(0.0D, 0.0D, 0.0D, f, f3);
        tessellator.func_983_a(f4, 0.0D, 0.0D, f2, f3);
        tessellator.func_983_a(f4, 1.0D, 0.0D, f2, f1);
        tessellator.func_983_a(0.0D, 1.0D, 0.0D, f, f1);
        tessellator.func_982_a();
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, 0.0F, -1F);
        tessellator.func_983_a(0.0D, 1.0D, 0.0F - f5, f, f1);
        tessellator.func_983_a(f4, 1.0D, 0.0F - f5, f2, f1);
        tessellator.func_983_a(f4, 0.0D, 0.0F - f5, f2, f3);
        tessellator.func_983_a(0.0D, 0.0D, 0.0F - f5, f, f3);
        tessellator.func_982_a();
        tessellator.func_977_b();
        tessellator.func_980_b(-1F, 0.0F, 0.0F);
        for(int i = 0; i < 16; i++)
        {
            float f6 = (float)i / 16F;
            float f10 = (f + (f2 - f) * f6) - 0.001953125F;
            float f14 = f4 * f6;
            tessellator.func_983_a(f14, 0.0D, 0.0F - f5, f10, f3);
            tessellator.func_983_a(f14, 0.0D, 0.0D, f10, f3);
            tessellator.func_983_a(f14, 1.0D, 0.0D, f10, f1);
            tessellator.func_983_a(f14, 1.0D, 0.0F - f5, f10, f1);
        }

        tessellator.func_982_a();
        tessellator.func_977_b();
        tessellator.func_980_b(1.0F, 0.0F, 0.0F);
        for(int j = 0; j < 16; j++)
        {
            float f7 = (float)j / 16F;
            float f11 = (f + (f2 - f) * f7) - 0.001953125F;
            float f15 = f4 * f7 + 0.0625F;
            tessellator.func_983_a(f15, 1.0D, 0.0F - f5, f11, f1);
            tessellator.func_983_a(f15, 1.0D, 0.0D, f11, f1);
            tessellator.func_983_a(f15, 0.0D, 0.0D, f11, f3);
            tessellator.func_983_a(f15, 0.0D, 0.0F - f5, f11, f3);
        }

        tessellator.func_982_a();
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, 1.0F, 0.0F);
        for(int k = 0; k < 16; k++)
        {
            float f8 = (float)k / 16F;
            float f12 = (f3 + (f1 - f3) * f8) - 0.001953125F;
            float f16 = f4 * f8 + 0.0625F;
            tessellator.func_983_a(0.0D, f16, 0.0D, f, f12);
            tessellator.func_983_a(f4, f16, 0.0D, f2, f12);
            tessellator.func_983_a(f4, f16, 0.0F - f5, f2, f12);
            tessellator.func_983_a(0.0D, f16, 0.0F - f5, f, f12);
        }

        tessellator.func_982_a();
        tessellator.func_977_b();
        tessellator.func_980_b(0.0F, -1F, 0.0F);
        for(int l = 0; l < 16; l++)
        {
            float f9 = (float)l / 16F;
            float f13 = (f3 + (f1 - f3) * f9) - 0.001953125F;
            float f17 = f4 * f9;
            tessellator.func_983_a(f4, f17, 0.0D, f2, f13);
            tessellator.func_983_a(0.0D, f17, 0.0D, f, f13);
            tessellator.func_983_a(0.0D, f17, 0.0F - f5, f, f13);
            tessellator.func_983_a(f4, f17, 0.0F - f5, f2, f13);
        }

        tessellator.func_982_a();
    }

    public void func_4133_a(float f)
    {
        float f1 = field_9452_d + (field_9453_c - field_9452_d) * f;
        EntityPlayerSP entityplayersp = field_1356_a.field_6322_g;
        float f2 = ((EntityPlayer) (entityplayersp)).field_602_at + (((EntityPlayer) (entityplayersp)).field_604_ar - ((EntityPlayer) (entityplayersp)).field_602_at) * f;
        GL11.glPushMatrix();
        GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(((EntityPlayer) (entityplayersp)).field_603_as + (((EntityPlayer) (entityplayersp)).field_605_aq - ((EntityPlayer) (entityplayersp)).field_603_as) * f, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glPopMatrix();
        if(entityplayersp instanceof EntityPlayerSP)
        {
            EntityPlayerSP entityplayersp1 = (EntityPlayerSP)entityplayersp;
            float f3 = entityplayersp1.field_35225_ar + (entityplayersp1.field_35223_ap - entityplayersp1.field_35225_ar) * f;
            float f5 = entityplayersp1.field_35226_aq + (entityplayersp1.field_35222_e - entityplayersp1.field_35226_aq) * f;
            GL11.glRotatef((((EntityPlayer) (entityplayersp)).field_604_ar - f3) * 0.1F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef((((EntityPlayer) (entityplayersp)).field_605_aq - f5) * 0.1F, 0.0F, 1.0F, 0.0F);
        }
        ItemStack itemstack = field_9451_b;
        float f4 = field_1356_a.field_6324_e.func_598_c(MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_611_ak), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_610_al), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_609_am));
        f4 = 1.0F;
        int i = field_1356_a.field_6324_e.func_35451_b(MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_611_ak), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_610_al), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_609_am), 0);
        int k = i % 0x10000;
        int l = i / 0x10000;
        OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)k / 1.0F, (float)l / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if(itemstack != null)
        {
            int j = Item.field_233_c[itemstack.field_1617_c].func_27010_f(itemstack.func_21181_i(), 0);
            float f9 = (float)(j >> 16 & 0xff) / 255F;
            float f14 = (float)(j >> 8 & 0xff) / 255F;
            float f20 = (float)(j & 0xff) / 255F;
            GL11.glColor4f(f4 * f9, f4 * f14, f4 * f20, 1.0F);
        } else
        {
            GL11.glColor4f(f4, f4, f4, 1.0F);
        }
        if(itemstack != null && itemstack.field_1617_c == Item.field_28010_bb.field_291_aS)
        {
            GL11.glPushMatrix();
            float f6 = 0.8F;
            float f10 = entityplayersp.func_431_d(f);
            float f15 = MathHelper.func_1106_a(f10 * 3.141593F);
            float f21 = MathHelper.func_1106_a(MathHelper.func_1113_c(f10) * 3.141593F);
            GL11.glTranslatef(-f21 * 0.4F, MathHelper.func_1106_a(MathHelper.func_1113_c(f10) * 3.141593F * 2.0F) * 0.2F, -f15 * 0.2F);
            f10 = (1.0F - f2 / 45F) + 0.1F;
            if(f10 < 0.0F)
            {
                f10 = 0.0F;
            }
            if(f10 > 1.0F)
            {
                f10 = 1.0F;
            }
            f10 = -MathHelper.func_1114_b(f10 * 3.141593F) * 0.5F + 0.5F;
            GL11.glTranslatef(0.0F, (0.0F * f6 - (1.0F - f1) * 1.2F - f10 * 0.5F) + 0.04F, -0.9F * f6);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f10 * -85F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(32826);
            GL11.glBindTexture(3553, field_1356_a.field_6315_n.func_1071_a(field_1356_a.field_6322_g.field_20047_bv, field_1356_a.field_6322_g.func_6376_z()));
            for(f15 = 0; f15 < 2; f15++)
            {
                f21 = f15 * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0F, -0.6F, 1.1F * (float)f21);
                GL11.glRotatef(-45 * f21, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(59F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-65 * f21, 0.0F, 1.0F, 0.0F);
                Render render1 = RenderManager.field_1233_a.func_855_a(field_1356_a.field_6322_g);
                RenderPlayer renderplayer1 = (RenderPlayer)render1;
                float f35 = 1.0F;
                GL11.glScalef(f35, f35, f35);
                renderplayer1.func_185_b();
                GL11.glPopMatrix();
            }

            f15 = entityplayersp.func_431_d(f);
            f21 = MathHelper.func_1106_a(f15 * f15 * 3.141593F);
            float f28 = MathHelper.func_1106_a(MathHelper.func_1113_c(f15) * 3.141593F);
            GL11.glRotatef(-f21 * 20F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f28 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f28 * 80F, 1.0F, 0.0F, 0.0F);
            f15 = 0.38F;
            GL11.glScalef(f15, f15, f15);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1F, -1F, 0.0F);
            f21 = 0.015625F;
            GL11.glScalef(f21, f21, f21);
            field_1356_a.field_6315_n.func_1076_b(field_1356_a.field_6315_n.func_1070_a("/misc/mapbg.png"));
            Tessellator tessellator = Tessellator.field_1512_a;
            GL11.glNormal3f(0.0F, 0.0F, -1F);
            tessellator.func_977_b();
            byte byte0 = 7;
            tessellator.func_983_a(0 - byte0, 128 + byte0, 0.0D, 0.0D, 1.0D);
            tessellator.func_983_a(128 + byte0, 128 + byte0, 0.0D, 1.0D, 1.0D);
            tessellator.func_983_a(128 + byte0, 0 - byte0, 0.0D, 1.0D, 0.0D);
            tessellator.func_983_a(0 - byte0, 0 - byte0, 0.0D, 0.0D, 0.0D);
            tessellator.func_982_a();
            MapData mapdata = Item.field_28010_bb.func_28012_a(itemstack, field_1356_a.field_6324_e);
            field_28131_f.func_28157_a(field_1356_a.field_6322_g, field_1356_a.field_6315_n, mapdata);
            GL11.glPopMatrix();
        } else
        if(itemstack != null)
        {
            GL11.glPushMatrix();
            float f7 = 0.8F;
            if(entityplayersp.func_35205_Y() > 0)
            {
                EnumAction enumaction = itemstack.func_35865_n();
                if(enumaction == EnumAction.eat || enumaction == EnumAction.drink)
                {
                    float f16 = ((float)entityplayersp.func_35205_Y() - f) + 1.0F;
                    float f22 = 1.0F - f16 / (float)itemstack.func_35866_m();
                    float f29 = f22;
                    float f32 = 1.0F - f29;
                    f32 = f32 * f32 * f32;
                    f32 = f32 * f32 * f32;
                    f32 = f32 * f32 * f32;
                    float f36 = 1.0F - f32;
                    GL11.glTranslatef(0.0F, MathHelper.func_1112_e(MathHelper.func_1114_b((f16 / 4F) * 3.141593F) * 0.1F) * (float)((double)f29 <= 0.20000000000000001D ? 0 : 1), 0.0F);
                    GL11.glTranslatef(f36 * 0.6F, -f36 * 0.5F, 0.0F);
                    GL11.glRotatef(f36 * 90F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(f36 * 10F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(f36 * 30F, 0.0F, 0.0F, 1.0F);
                }
            } else
            {
                float f11 = entityplayersp.func_431_d(f);
                float f17 = MathHelper.func_1106_a(f11 * 3.141593F);
                float f23 = MathHelper.func_1106_a(MathHelper.func_1113_c(f11) * 3.141593F);
                GL11.glTranslatef(-f23 * 0.4F, MathHelper.func_1106_a(MathHelper.func_1113_c(f11) * 3.141593F * 2.0F) * 0.2F, -f17 * 0.2F);
            }
            GL11.glTranslatef(0.7F * f7, -0.65F * f7 - (1.0F - f1) * 0.6F, -0.9F * f7);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826);
            float f12 = entityplayersp.func_431_d(f);
            float f18 = MathHelper.func_1106_a(f12 * f12 * 3.141593F);
            float f24 = MathHelper.func_1106_a(MathHelper.func_1113_c(f12) * 3.141593F);
            GL11.glRotatef(-f18 * 20F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f24 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f24 * 80F, 1.0F, 0.0F, 0.0F);
            f12 = 0.4F;
            GL11.glScalef(f12, f12, f12);
            if(entityplayersp.func_35205_Y() > 0)
            {
                EnumAction enumaction1 = itemstack.func_35865_n();
                if(enumaction1 == EnumAction.block)
                {
                    GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
                    GL11.glRotatef(30F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-80F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(60F, 0.0F, 1.0F, 0.0F);
                } else
                if(enumaction1 == EnumAction.bow)
                {
                    GL11.glRotatef(-18F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-12F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-8F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
                    float f25 = (float)itemstack.func_35866_m() - (((float)entityplayersp.func_35205_Y() - f) + 1.0F);
                    float f30 = f25 / 20F;
                    f30 = (f30 * f30 + f30 * 2.0F) / 3F;
                    if(f30 > 1.0F)
                    {
                        f30 = 1.0F;
                    }
                    if(f30 > 0.1F)
                    {
                        GL11.glTranslatef(0.0F, MathHelper.func_1106_a((f25 - 0.1F) * 1.3F) * 0.01F * (f30 - 0.1F), 0.0F);
                    }
                    GL11.glTranslatef(0.0F, 0.0F, f30 * 0.1F);
                    GL11.glRotatef(-335F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(0.0F, 0.5F, 0.0F);
                    float f33 = 1.0F + f30 * 0.2F;
                    GL11.glScalef(1.0F, 1.0F, f33);
                    GL11.glTranslatef(0.0F, -0.5F, 0.0F);
                    GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(335F, 0.0F, 0.0F, 1.0F);
                }
            }
            if(itemstack.func_1091_a().func_4023_b())
            {
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            }
            if(itemstack.func_1091_a().func_46058_c())
            {
                func_4132_a(entityplayersp, itemstack, 0);
                int i1 = Item.field_233_c[itemstack.field_1617_c].func_27010_f(itemstack.func_21181_i(), 1);
                float f26 = (float)(i1 >> 16 & 0xff) / 255F;
                float f31 = (float)(i1 >> 8 & 0xff) / 255F;
                float f34 = (float)(i1 & 0xff) / 255F;
                GL11.glColor4f(f4 * f26, f4 * f31, f4 * f34, 1.0F);
                func_4132_a(entityplayersp, itemstack, 1);
            } else
            {
                func_4132_a(entityplayersp, itemstack, 0);
            }
            GL11.glPopMatrix();
        } else
        {
            GL11.glPushMatrix();
            float f8 = 0.8F;
            float f13 = entityplayersp.func_431_d(f);
            float f19 = MathHelper.func_1106_a(f13 * 3.141593F);
            float f27 = MathHelper.func_1106_a(MathHelper.func_1113_c(f13) * 3.141593F);
            GL11.glTranslatef(-f27 * 0.3F, MathHelper.func_1106_a(MathHelper.func_1113_c(f13) * 3.141593F * 2.0F) * 0.4F, -f19 * 0.4F);
            GL11.glTranslatef(0.8F * f8, -0.75F * f8 - (1.0F - f1) * 0.6F, -0.9F * f8);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826);
            f13 = entityplayersp.func_431_d(f);
            f19 = MathHelper.func_1106_a(f13 * f13 * 3.141593F);
            f27 = MathHelper.func_1106_a(MathHelper.func_1113_c(f13) * 3.141593F);
            GL11.glRotatef(f27 * 70F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f19 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glBindTexture(3553, field_1356_a.field_6315_n.func_1071_a(field_1356_a.field_6322_g.field_20047_bv, field_1356_a.field_6322_g.func_6376_z()));
            GL11.glTranslatef(-1F, 3.6F, 3.5F);
            GL11.glRotatef(120F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(200F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(5.6F, 0.0F, 0.0F);
            Render render = RenderManager.field_1233_a.func_855_a(field_1356_a.field_6322_g);
            RenderPlayer renderplayer = (RenderPlayer)render;
            f27 = 1.0F;
            GL11.glScalef(f27, f27, f27);
            renderplayer.func_185_b();
            GL11.glPopMatrix();
        }
        GL11.glDisable(32826);
        RenderHelper.func_1159_a();
    }

    public void func_893_b(float f)
    {
        GL11.glDisable(3008);
        if(field_1356_a.field_6322_g.func_21062_U())
        {
            int i = field_1356_a.field_6315_n.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, i);
            func_890_d(f);
        }
        if(field_1356_a.field_6322_g.func_345_I())
        {
            int j = MathHelper.func_1108_b(field_1356_a.field_6322_g.field_611_ak);
            int l = MathHelper.func_1108_b(field_1356_a.field_6322_g.field_610_al);
            int i1 = MathHelper.func_1108_b(field_1356_a.field_6322_g.field_609_am);
            int j1 = field_1356_a.field_6315_n.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, j1);
            int k1 = field_1356_a.field_6324_e.func_600_a(j, l, i1);
            if(field_1356_a.field_6324_e.func_28100_h(j, l, i1))
            {
                func_898_a(f, Block.field_345_n[k1].func_218_a(2));
            } else
            {
                for(int l1 = 0; l1 < 8; l1++)
                {
                    float f1 = ((float)((l1 >> 0) % 2) - 0.5F) * field_1356_a.field_6322_g.field_644_aC * 0.9F;
                    float f2 = ((float)((l1 >> 1) % 2) - 0.5F) * field_1356_a.field_6322_g.field_643_aD * 0.2F;
                    float f3 = ((float)((l1 >> 2) % 2) - 0.5F) * field_1356_a.field_6322_g.field_644_aC * 0.9F;
                    int i2 = MathHelper.func_1110_d((float)j + f1);
                    int j2 = MathHelper.func_1110_d((float)l + f2);
                    int k2 = MathHelper.func_1110_d((float)i1 + f3);
                    if(field_1356_a.field_6324_e.func_28100_h(i2, j2, k2))
                    {
                        k1 = field_1356_a.field_6324_e.func_600_a(i2, j2, k2);
                    }
                }

            }
            if(Block.field_345_n[k1] != null)
            {
                func_898_a(f, Block.field_345_n[k1].func_218_a(2));
            }
        }
        if(field_1356_a.field_6322_g.func_393_a(Material.field_1332_f))
        {
            int k = field_1356_a.field_6315_n.func_1070_a("/misc/water.png");
            GL11.glBindTexture(3553, k);
            func_892_c(f);
        }
        GL11.glEnable(3008);
    }

    private void func_898_a(float f, int i)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        float f1 = field_1356_a.field_6322_g.func_382_a(f);
        f1 = 0.1F;
        GL11.glColor4f(f1, f1, f1, 0.5F);
        GL11.glPushMatrix();
        float f2 = -1F;
        float f3 = 1.0F;
        float f4 = -1F;
        float f5 = 1.0F;
        float f6 = -0.5F;
        float f7 = 0.0078125F;
        float f8 = (float)(i % 16) / 256F - f7;
        float f9 = ((float)(i % 16) + 15.99F) / 256F + f7;
        float f10 = (float)(i / 16) / 256F - f7;
        float f11 = ((float)(i / 16) + 15.99F) / 256F + f7;
        tessellator.func_977_b();
        tessellator.func_983_a(f2, f4, f6, f9, f11);
        tessellator.func_983_a(f3, f4, f6, f8, f11);
        tessellator.func_983_a(f3, f5, f6, f8, f10);
        tessellator.func_983_a(f2, f5, f6, f9, f10);
        tessellator.func_982_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_892_c(float f)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        float f1 = field_1356_a.field_6322_g.func_382_a(f);
        GL11.glColor4f(f1, f1, f1, 0.5F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float f2 = 4F;
        float f3 = -1F;
        float f4 = 1.0F;
        float f5 = -1F;
        float f6 = 1.0F;
        float f7 = -0.5F;
        float f8 = -field_1356_a.field_6322_g.field_605_aq / 64F;
        float f9 = field_1356_a.field_6322_g.field_604_ar / 64F;
        tessellator.func_977_b();
        tessellator.func_983_a(f3, f5, f7, f2 + f8, f2 + f9);
        tessellator.func_983_a(f4, f5, f7, 0.0F + f8, f2 + f9);
        tessellator.func_983_a(f4, f6, f7, 0.0F + f8, 0.0F + f9);
        tessellator.func_983_a(f3, f6, f7, f2 + f8, 0.0F + f9);
        tessellator.func_982_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
    }

    private void func_890_d(float f)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float f1 = 1.0F;
        for(int i = 0; i < 2; i++)
        {
            GL11.glPushMatrix();
            int j = Block.field_402_as.field_378_bb + i * 16;
            int k = (j & 0xf) << 4;
            int l = j & 0xf0;
            float f2 = (float)k / 256F;
            float f3 = ((float)k + 15.99F) / 256F;
            float f4 = (float)l / 256F;
            float f5 = ((float)l + 15.99F) / 256F;
            float f6 = (0.0F - f1) / 2.0F;
            float f7 = f6 + f1;
            float f8 = 0.0F - f1 / 2.0F;
            float f9 = f8 + f1;
            float f10 = -0.5F;
            GL11.glTranslatef((float)(-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            GL11.glRotatef((float)(i * 2 - 1) * 10F, 0.0F, 1.0F, 0.0F);
            tessellator.func_977_b();
            tessellator.func_983_a(f6, f8, f10, f3, f5);
            tessellator.func_983_a(f7, f8, f10, f2, f5);
            tessellator.func_983_a(f7, f9, f10, f2, f4);
            tessellator.func_983_a(f6, f9, f10, f3, f4);
            tessellator.func_982_a();
            GL11.glPopMatrix();
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
    }

    public void func_895_a()
    {
        field_9452_d = field_9453_c;
        EntityPlayerSP entityplayersp = field_1356_a.field_6322_g;
        ItemStack itemstack = ((EntityPlayer) (entityplayersp)).field_778_b.func_494_a();
        ItemStack itemstack1 = itemstack;
        boolean flag = field_20099_f == ((EntityPlayer) (entityplayersp)).field_778_b.field_847_d && itemstack1 == field_9451_b;
        if(field_9451_b == null && itemstack1 == null)
        {
            flag = true;
        }
        if(itemstack1 != null && field_9451_b != null && itemstack1 != field_9451_b && itemstack1.field_1617_c == field_9451_b.field_1617_c && itemstack1.func_21181_i() == field_9451_b.func_21181_i())
        {
            field_9451_b = itemstack1;
            flag = true;
        }
        float f = 0.4F;
        float f1 = flag ? 1.0F : 0.0F;
        float f2 = f1 - field_9453_c;
        if(f2 < -f)
        {
            f2 = -f;
        }
        if(f2 > f)
        {
            f2 = f;
        }
        field_9453_c += f2;
        if(field_9453_c < 0.1F)
        {
            field_9451_b = itemstack1;
            field_20099_f = ((EntityPlayer) (entityplayersp)).field_778_b.field_847_d;
        }
    }

    public void func_9449_b()
    {
        field_9453_c = 0.0F;
    }

    public void func_9450_c()
    {
        field_9453_c = 0.0F;
    }
}
