// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityFX, Item, Block, Tessellator, 
//            World

public class EntityBreakingFX extends EntityFX
{

    public EntityBreakingFX(World world, double d, double d1, double d2, 
            Item item)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        func_40099_c(item.func_27009_a(0));
        field_663_i = field_662_j = field_661_k = 1.0F;
        field_664_h = Block.field_426_aV.field_357_bm;
        field_665_g /= 2.0F;
    }

    public EntityBreakingFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5, Item item)
    {
        this(world, d, d1, d2, item);
        field_608_an *= 0.10000000149011612D;
        field_607_ao *= 0.10000000149011612D;
        field_606_ap *= 0.10000000149011612D;
        field_608_an += d3;
        field_607_ao += d4;
        field_606_ap += d5;
    }

    public int func_404_c()
    {
        return 2;
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
