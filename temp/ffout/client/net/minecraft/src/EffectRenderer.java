// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, ActiveRenderInfo, Entity, RenderEngine, 
//            Tessellator, MathHelper, Block, EntityDiggingFX, 
//            World

public class EffectRenderer
{

    protected World field_1729_a;
    private List field_1728_b[];
    private RenderEngine field_1731_c;
    private Random field_1730_d;

    public EffectRenderer(World world, RenderEngine renderengine)
    {
        field_1728_b = new List[4];
        field_1730_d = new Random();
        if(world != null)
        {
            field_1729_a = world;
        }
        field_1731_c = renderengine;
        for(int i = 0; i < 4; i++)
        {
            field_1728_b[i] = new ArrayList();
        }

    }

    public void func_1192_a(EntityFX entityfx)
    {
        int i = entityfx.func_404_c();
        if(field_1728_b[i].size() >= 4000)
        {
            field_1728_b[i].remove(0);
        }
        field_1728_b[i].add(entityfx);
    }

    public void func_1193_a()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < field_1728_b[i].size(); j++)
            {
                EntityFX entityfx = (EntityFX)field_1728_b[i].get(j);
                entityfx.func_370_e_();
                if(entityfx.field_646_aA)
                {
                    field_1728_b[i].remove(j--);
                }
            }

        }

    }

    public void func_1189_a(Entity entity, float f)
    {
        float f1 = ActiveRenderInfo.field_41070_d;
        float f2 = ActiveRenderInfo.field_41068_f;
        float f3 = ActiveRenderInfo.field_41069_g;
        float f4 = ActiveRenderInfo.field_41078_h;
        float f5 = ActiveRenderInfo.field_41071_e;
        EntityFX.field_660_l = entity.field_638_aI + (entity.field_611_ak - entity.field_638_aI) * (double)f;
        EntityFX.field_659_m = entity.field_637_aJ + (entity.field_610_al - entity.field_637_aJ) * (double)f;
        EntityFX.field_658_n = entity.field_636_aK + (entity.field_609_am - entity.field_636_aK) * (double)f;
        for(int i = 0; i < 3; i++)
        {
            if(field_1728_b[i].size() == 0)
            {
                continue;
            }
            int j = 0;
            if(i == 0)
            {
                j = field_1731_c.func_1070_a("/particles.png");
            }
            if(i == 1)
            {
                j = field_1731_c.func_1070_a("/terrain.png");
            }
            if(i == 2)
            {
                j = field_1731_c.func_1070_a("/gui/items.png");
            }
            GL11.glBindTexture(3553, j);
            Tessellator tessellator = Tessellator.field_1512_a;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tessellator.func_977_b();
            for(int k = 0; k < field_1728_b[i].size(); k++)
            {
                EntityFX entityfx = (EntityFX)field_1728_b[i].get(k);
                tessellator.func_35835_b(entityfx.func_35115_a(f));
                entityfx.func_406_a(tessellator, f, f1, f5, f2, f3, f4);
            }

            tessellator.func_982_a();
        }

    }

    public void func_1187_b(Entity entity, float f)
    {
        float f1 = MathHelper.func_1114_b((entity.field_605_aq * 3.141593F) / 180F);
        float f2 = MathHelper.func_1106_a((entity.field_605_aq * 3.141593F) / 180F);
        float f3 = -f2 * MathHelper.func_1106_a((entity.field_604_ar * 3.141593F) / 180F);
        float f4 = f1 * MathHelper.func_1106_a((entity.field_604_ar * 3.141593F) / 180F);
        float f5 = MathHelper.func_1114_b((entity.field_604_ar * 3.141593F) / 180F);
        byte byte0 = 3;
        if(field_1728_b[byte0].size() == 0)
        {
            return;
        }
        Tessellator tessellator = Tessellator.field_1512_a;
        for(int i = 0; i < field_1728_b[byte0].size(); i++)
        {
            EntityFX entityfx = (EntityFX)field_1728_b[byte0].get(i);
            tessellator.func_35835_b(entityfx.func_35115_a(f));
            entityfx.func_406_a(tessellator, f, f1, f5, f2, f3, f4);
        }

    }

    public void func_1188_a(World world)
    {
        field_1729_a = world;
        for(int i = 0; i < 4; i++)
        {
            field_1728_b[i].clear();
        }

    }

    public void func_1186_a(int i, int j, int k, int l, int i1)
    {
        if(l == 0)
        {
            return;
        }
        Block block = Block.field_345_n[l];
        int j1 = 4;
        for(int k1 = 0; k1 < j1; k1++)
        {
            for(int l1 = 0; l1 < j1; l1++)
            {
                for(int i2 = 0; i2 < j1; i2++)
                {
                    double d = (double)i + ((double)k1 + 0.5D) / (double)j1;
                    double d1 = (double)j + ((double)l1 + 0.5D) / (double)j1;
                    double d2 = (double)k + ((double)i2 + 0.5D) / (double)j1;
                    int j2 = field_1730_d.nextInt(6);
                    func_1192_a((new EntityDiggingFX(field_1729_a, d, d1, d2, d - (double)i - 0.5D, d1 - (double)j - 0.5D, d2 - (double)k - 0.5D, block, j2, i1)).func_4041_a(i, j, k));
                }

            }

        }

    }

    public void func_1191_a(int i, int j, int k, int l)
    {
        int i1 = field_1729_a.func_600_a(i, j, k);
        if(i1 == 0)
        {
            return;
        }
        Block block = Block.field_345_n[i1];
        float f = 0.1F;
        double d = (double)i + field_1730_d.nextDouble() * (block.field_364_bi - block.field_370_bf - (double)(f * 2.0F)) + (double)f + block.field_370_bf;
        double d1 = (double)j + field_1730_d.nextDouble() * (block.field_362_bj - block.field_368_bg - (double)(f * 2.0F)) + (double)f + block.field_368_bg;
        double d2 = (double)k + field_1730_d.nextDouble() * (block.field_360_bk - block.field_366_bh - (double)(f * 2.0F)) + (double)f + block.field_366_bh;
        if(l == 0)
        {
            d1 = ((double)j + block.field_368_bg) - (double)f;
        }
        if(l == 1)
        {
            d1 = (double)j + block.field_362_bj + (double)f;
        }
        if(l == 2)
        {
            d2 = ((double)k + block.field_366_bh) - (double)f;
        }
        if(l == 3)
        {
            d2 = (double)k + block.field_360_bk + (double)f;
        }
        if(l == 4)
        {
            d = ((double)i + block.field_370_bf) - (double)f;
        }
        if(l == 5)
        {
            d = (double)i + block.field_364_bi + (double)f;
        }
        func_1192_a((new EntityDiggingFX(field_1729_a, d, d1, d2, 0.0D, 0.0D, 0.0D, block, l, field_1729_a.func_602_e(i, j, k))).func_4041_a(i, j, k).func_407_b(0.2F).func_405_d(0.6F));
    }

    public String func_1190_b()
    {
        return (new StringBuilder()).append("").append(field_1728_b[0].size() + field_1728_b[1].size() + field_1728_b[2].size()).toString();
    }
}
