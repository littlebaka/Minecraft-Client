// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, MathHelper, World, RenderEngine, 
//            Tessellator

public class EntityFootStepFX extends EntityFX
{

    private int field_27018_a;
    private int field_27020_o;
    private RenderEngine field_27019_p;

    public EntityFootStepFX(RenderEngine renderengine, World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        field_27018_a = 0;
        field_27020_o = 0;
        field_27019_p = renderengine;
        field_608_an = field_607_ao = field_606_ap = 0.0D;
        field_27020_o = 200;
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)field_27018_a + f) / (float)field_27020_o;
        f6 *= f6;
        float f7 = 2.0F - f6 * 2.0F;
        if(f7 > 1.0F)
        {
            f7 = 1.0F;
        }
        f7 *= 0.2F;
        GL11.glDisable(2896);
        float f8 = 0.125F;
        float f9 = (float)(field_611_ak - field_660_l);
        float f10 = (float)(field_610_al - field_659_m);
        float f11 = (float)(field_609_am - field_658_n);
        float f12 = field_615_ag.func_598_c(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_610_al), MathHelper.func_1108_b(field_609_am));
        field_27019_p.func_1076_b(field_27019_p.func_1070_a("/misc/footprint.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        tessellator.func_977_b();
        tessellator.func_986_a(f12, f12, f12, f7);
        tessellator.func_983_a(f9 - f8, f10, f11 + f8, 0.0D, 1.0D);
        tessellator.func_983_a(f9 + f8, f10, f11 + f8, 1.0D, 1.0D);
        tessellator.func_983_a(f9 + f8, f10, f11 - f8, 1.0D, 0.0D);
        tessellator.func_983_a(f9 - f8, f10, f11 - f8, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }

    public void func_370_e_()
    {
        field_27018_a++;
        if(field_27018_a == field_27020_o)
        {
            func_395_F();
        }
    }

    public int func_404_c()
    {
        return 3;
    }
}
