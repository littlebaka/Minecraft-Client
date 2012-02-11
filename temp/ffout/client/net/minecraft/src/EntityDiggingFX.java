// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, Block, Tessellator, World

public class EntityDiggingFX extends EntityFX
{

    private Block field_4082_a;

    public EntityDiggingFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, Block block, 
            int i, int j)
    {
        super(world, d, d1, d2, d3, d4, d5);
        field_4082_a = block;
        func_40099_c(block.func_232_a(0, j));
        field_664_h = block.field_357_bm;
        field_663_i = field_662_j = field_661_k = 0.6F;
        field_665_g /= 2.0F;
    }

    public EntityDiggingFX func_4041_a(int i, int j, int k)
    {
        if(field_4082_a == Block.field_337_v)
        {
            return this;
        } else
        {
            int l = field_4082_a.func_207_d(field_615_ag, i, j, k);
            field_663_i *= (float)(l >> 16 & 0xff) / 255F;
            field_662_j *= (float)(l >> 8 & 0xff) / 255F;
            field_661_k *= (float)(l & 0xff) / 255F;
            return this;
        }
    }

    public int func_404_c()
    {
        return 1;
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)(func_40100_q() % 16) + field_669_c / 4F) / 16F;
        float f7 = f6 + 0.01560938F;
        float f8 = ((float)(func_40100_q() / 16) + field_668_d / 4F) / 16F;
        float f9 = f8 + 0.01560938F;
        float f10 = 0.1F * field_665_g;
        float f11 = (float)((field_9285_at + (field_611_ak - field_9285_at) * (double)f) - field_660_l);
        float f12 = (float)((field_9284_au + (field_610_al - field_9284_au) * (double)f) - field_659_m);
        float f13 = (float)((field_9283_av + (field_609_am - field_9283_av) * (double)f) - field_658_n);
        float f14 = 1.0F;
        tessellator.func_987_a(f14 * field_663_i, f14 * field_662_j, f14 * field_661_k);
        tessellator.func_983_a(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f6, f9);
        tessellator.func_983_a((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f6, f8);
        tessellator.func_983_a(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f7, f8);
        tessellator.func_983_a((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f7, f9);
    }
}
