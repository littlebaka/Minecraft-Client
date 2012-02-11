// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelBiped, EntityPlayer, InventoryPlayer, 
//            ItemStack, ItemArmor, ModelRenderer, EnumAction, 
//            EntityPlayerSP, RenderManager, Tessellator, FontRenderer, 
//            Item, Block, RenderBlocks, ItemRenderer, 
//            MathHelper, EntityLiving, Entity

public class RenderPlayer extends RenderLiving
{

    private ModelBiped field_209_f;
    private ModelBiped field_208_g;
    private ModelBiped field_207_h;
    private static final String field_206_i[] = {
        "cloth", "chain", "iron", "diamond", "gold"
    };

    public RenderPlayer()
    {
        super(new ModelBiped(0.0F), 0.5F);
        field_209_f = (ModelBiped)field_20920_e;
        field_208_g = new ModelBiped(1.0F);
        field_207_h = new ModelBiped(0.5F);
    }

    protected int func_187_a(EntityPlayer entityplayer, int i, float f)
    {
        ItemStack itemstack = entityplayer.field_778_b.func_492_d(3 - i);
        if(itemstack != null)
        {
            Item item = itemstack.func_1091_a();
            if(item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                func_151_a((new StringBuilder()).append("/armor/").append(field_206_i[itemarmor.field_311_aZ]).append("_").append(i != 2 ? 1 : 2).append(".png").toString());
                ModelBiped modelbiped = i != 2 ? field_208_g : field_207_h;
                modelbiped.field_1286_a.field_1403_h = i == 0;
                modelbiped.field_1285_b.field_1403_h = i == 0;
                modelbiped.field_1284_c.field_1403_h = i == 1 || i == 2;
                modelbiped.field_1283_d.field_1403_h = i == 1;
                modelbiped.field_1282_e.field_1403_h = i == 1;
                modelbiped.field_1281_f.field_1403_h = i == 2 || i == 3;
                modelbiped.field_1280_g.field_1403_h = i == 2 || i == 3;
                func_4013_a(modelbiped);
                return !itemstack.func_40711_u() ? 1 : 15;
            }
        }
        return -1;
    }

    public void func_188_a(EntityPlayer entityplayer, double d, double d1, double d2, 
            float f, float f1)
    {
        ItemStack itemstack = entityplayer.field_778_b.func_494_a();
        field_208_g.field_1278_i = field_207_h.field_1278_i = field_209_f.field_1278_i = itemstack == null ? 0 : 1;
        if(itemstack != null && entityplayer.func_35205_Y() > 0)
        {
            EnumAction enumaction = itemstack.func_35865_n();
            if(enumaction == EnumAction.block)
            {
                field_208_g.field_1278_i = field_207_h.field_1278_i = field_209_f.field_1278_i = 3;
            } else
            if(enumaction == EnumAction.bow)
            {
                field_208_g.field_40333_u = field_207_h.field_40333_u = field_209_f.field_40333_u = true;
            }
        }
        field_208_g.field_1277_j = field_207_h.field_1277_j = field_209_f.field_1277_j = entityplayer.func_381_o();
        double d3 = d1 - (double)entityplayer.field_9292_aO;
        if(entityplayer.func_381_o() && !(entityplayer instanceof EntityPlayerSP))
        {
            d3 -= 0.125D;
        }
        super.func_171_a(entityplayer, d, d3, d2, f, f1);
        field_208_g.field_40333_u = field_207_h.field_40333_u = field_209_f.field_40333_u = false;
        field_208_g.field_1277_j = field_207_h.field_1277_j = field_209_f.field_1277_j = false;
        field_208_g.field_1278_i = field_207_h.field_1278_i = field_209_f.field_1278_i = 0;
    }

    protected void func_22015_a(EntityPlayer entityplayer, double d, double d1, double d2)
    {
        if(Minecraft.func_22006_t() && entityplayer != field_191_a.field_22188_h)
        {
            float f = 1.6F;
            float f1 = 0.01666667F * f;
            float f2 = entityplayer.func_379_d(field_191_a.field_22188_h);
            float f3 = entityplayer.func_381_o() ? 32F : 64F;
            if(f2 < f3)
            {
                String s = entityplayer.field_771_i;
                if(!entityplayer.func_381_o())
                {
                    if(entityplayer.func_22051_K())
                    {
                        func_22013_a(entityplayer, s, d, d1 - 1.5D, d2, 64);
                    } else
                    {
                        func_22013_a(entityplayer, s, d, d1, d2, 64);
                    }
                } else
                {
                    FontRenderer fontrenderer = func_6329_a();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)d + 0.0F, (float)d1 + 2.3F, (float)d2);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
                    GL11.glScalef(-f1, -f1, f1);
                    GL11.glDisable(2896);
                    GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    Tessellator tessellator = Tessellator.field_1512_a;
                    GL11.glDisable(3553);
                    tessellator.func_977_b();
                    int i = fontrenderer.func_871_a(s) / 2;
                    tessellator.func_986_a(0.0F, 0.0F, 0.0F, 0.25F);
                    tessellator.func_991_a(-i - 1, -1D, 0.0D);
                    tessellator.func_991_a(-i - 1, 8D, 0.0D);
                    tessellator.func_991_a(i + 1, 8D, 0.0D);
                    tessellator.func_991_a(i + 1, -1D, 0.0D);
                    tessellator.func_982_a();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    fontrenderer.func_873_b(s, -fontrenderer.func_871_a(s) / 2, 0, 0x20ffffff);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glPopMatrix();
                }
            }
        }
    }

    protected void func_4015_a(EntityPlayer entityplayer, float f)
    {
        super.func_6331_b(entityplayer, f);
        ItemStack itemstack = entityplayer.field_778_b.func_492_d(3);
        if(itemstack != null && itemstack.func_1091_a().field_291_aS < 256)
        {
            GL11.glPushMatrix();
            field_209_f.field_1286_a.func_926_b(0.0625F);
            if(RenderBlocks.func_1219_a(Block.field_345_n[itemstack.field_1617_c].func_210_f()))
            {
                float f1 = 0.625F;
                GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            }
            field_191_a.field_4236_f.func_4132_a(entityplayer, itemstack, 0);
            GL11.glPopMatrix();
        }
        if(entityplayer.field_771_i.equals("deadmau5") && func_140_a(entityplayer.field_20047_bv, null))
        {
            for(int i = 0; i < 2; i++)
            {
                float f2 = (entityplayer.field_603_as + (entityplayer.field_605_aq - entityplayer.field_603_as) * f) - (entityplayer.field_734_o + (entityplayer.field_735_n - entityplayer.field_734_o) * f);
                float f3 = entityplayer.field_602_at + (entityplayer.field_604_ar - entityplayer.field_602_at) * f;
                GL11.glPushMatrix();
                GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(f3, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.375F * (float)(i * 2 - 1), 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.375F, 0.0F);
                GL11.glRotatef(-f3, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
                float f8 = 1.333333F;
                GL11.glScalef(f8, f8, f8);
                field_209_f.func_20095_a(0.0625F);
                GL11.glPopMatrix();
            }

        }
        if(func_140_a(entityplayer.field_20067_q, null))
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
            double d = (entityplayer.field_20066_r + (entityplayer.field_20063_u - entityplayer.field_20066_r) * (double)f) - (entityplayer.field_9285_at + (entityplayer.field_611_ak - entityplayer.field_9285_at) * (double)f);
            double d1 = (entityplayer.field_20065_s + (entityplayer.field_20062_v - entityplayer.field_20065_s) * (double)f) - (entityplayer.field_9284_au + (entityplayer.field_610_al - entityplayer.field_9284_au) * (double)f);
            double d2 = (entityplayer.field_20064_t + (entityplayer.field_20061_w - entityplayer.field_20064_t) * (double)f) - (entityplayer.field_9283_av + (entityplayer.field_609_am - entityplayer.field_9283_av) * (double)f);
            float f11 = entityplayer.field_734_o + (entityplayer.field_735_n - entityplayer.field_734_o) * f;
            double d3 = MathHelper.func_1106_a((f11 * 3.141593F) / 180F);
            double d4 = -MathHelper.func_1114_b((f11 * 3.141593F) / 180F);
            float f13 = (float)d1 * 10F;
            if(f13 < -6F)
            {
                f13 = -6F;
            }
            if(f13 > 32F)
            {
                f13 = 32F;
            }
            float f14 = (float)(d * d3 + d2 * d4) * 100F;
            float f15 = (float)(d * d4 - d2 * d3) * 100F;
            if(f14 < 0.0F)
            {
                f14 = 0.0F;
            }
            float f16 = entityplayer.field_775_e + (entityplayer.field_774_f - entityplayer.field_775_e) * f;
            f13 += MathHelper.func_1106_a((entityplayer.field_9291_aR + (entityplayer.field_9290_aS - entityplayer.field_9291_aR) * f) * 6F) * 32F * f16;
            if(entityplayer.func_381_o())
            {
                f13 += 25F;
            }
            GL11.glRotatef(6F + f14 / 2.0F + f13, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f15 / 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f15 / 2.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            field_209_f.func_20096_b(0.0625F);
            GL11.glPopMatrix();
        }
        ItemStack itemstack1 = entityplayer.field_778_b.func_494_a();
        if(itemstack1 != null)
        {
            GL11.glPushMatrix();
            field_209_f.field_1283_d.func_926_b(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if(entityplayer.field_4128_n != null)
            {
                itemstack1 = new ItemStack(Item.field_266_B);
            }
            EnumAction enumaction = null;
            if(entityplayer.func_35205_Y() > 0)
            {
                enumaction = itemstack1.func_35865_n();
            }
            if(itemstack1.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[itemstack1.field_1617_c].func_210_f()))
            {
                float f4 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f4 *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f4, -f4, f4);
            } else
            if(itemstack1.field_1617_c == Item.field_227_i.field_291_aS)
            {
                float f5 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f5, -f5, f5);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            if(Item.field_233_c[itemstack1.field_1617_c].func_4017_a())
            {
                float f6 = 0.625F;
                if(Item.field_233_c[itemstack1.field_1617_c].func_4023_b())
                {
                    GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }
                if(entityplayer.func_35205_Y() > 0 && enumaction == EnumAction.block)
                {
                    GL11.glTranslatef(0.05F, 0.0F, -0.1F);
                    GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-10F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-60F, 0.0F, 0.0F, 1.0F);
                }
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f6, -f6, f6);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f7 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f7, f7, f7);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            if(itemstack1.func_1091_a().func_46058_c())
            {
                for(int j = 0; j <= 1; j++)
                {
                    int k = itemstack1.func_1091_a().func_27010_f(itemstack1.func_21181_i(), j);
                    float f9 = (float)(k >> 16 & 0xff) / 255F;
                    float f10 = (float)(k >> 8 & 0xff) / 255F;
                    float f12 = (float)(k & 0xff) / 255F;
                    GL11.glColor4f(f9, f10, f12, 1.0F);
                    field_191_a.field_4236_f.func_4132_a(entityplayer, itemstack1, j);
                }

            } else
            {
                field_191_a.field_4236_f.func_4132_a(entityplayer, itemstack1, 0);
            }
            GL11.glPopMatrix();
        }
    }

    protected void func_186_b(EntityPlayer entityplayer, float f)
    {
        float f1 = 0.9375F;
        GL11.glScalef(f1, f1, f1);
    }

    public void func_185_b()
    {
        field_209_f.field_1244_k = 0.0F;
        field_209_f.func_863_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        field_209_f.field_1283_d.func_922_a(0.0625F);
    }

    protected void func_22016_b(EntityPlayer entityplayer, double d, double d1, double d2)
    {
        if(entityplayer.func_354_B() && entityplayer.func_22051_K())
        {
            super.func_22012_b(entityplayer, d + (double)entityplayer.field_22063_x, d1 + (double)entityplayer.field_22062_y, d2 + (double)entityplayer.field_22061_z);
        } else
        {
            super.func_22012_b(entityplayer, d, d1, d2);
        }
    }

    protected void func_22017_a(EntityPlayer entityplayer, float f, float f1, float f2)
    {
        if(entityplayer.func_354_B() && entityplayer.func_22051_K())
        {
            GL11.glRotatef(entityplayer.func_22059_J(), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(func_172_a(entityplayer), 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
        } else
        {
            super.func_21004_a(entityplayer, f, f1, f2);
        }
    }

    protected void func_22014_a(EntityLiving entityliving, double d, double d1, double d2)
    {
        func_22015_a((EntityPlayer)entityliving, d, d1, d2);
    }

    protected void func_6330_a(EntityLiving entityliving, float f)
    {
        func_186_b((EntityPlayer)entityliving, f);
    }

    protected int func_166_a(EntityLiving entityliving, int i, float f)
    {
        return func_187_a((EntityPlayer)entityliving, i, f);
    }

    protected void func_6331_b(EntityLiving entityliving, float f)
    {
        func_4015_a((EntityPlayer)entityliving, f);
    }

    protected void func_21004_a(EntityLiving entityliving, float f, float f1, float f2)
    {
        func_22017_a((EntityPlayer)entityliving, f, f1, f2);
    }

    protected void func_22012_b(EntityLiving entityliving, double d, double d1, double d2)
    {
        func_22016_b((EntityPlayer)entityliving, d, d1, d2);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_188_a((EntityPlayer)entityliving, d, d1, d2, f, f1);
    }

    public void func_147_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_188_a((EntityPlayer)entity, d, d1, d2, f, f1);
    }

}
