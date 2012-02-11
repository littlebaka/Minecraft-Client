// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, EntityPlayer, MathHelper, AxisAlignedBB, 
//            World, ItemStack, Item, Vec3D, 
//            MovingObjectPosition, DamageSource, Material, NBTTagCompound, 
//            EntityItem, StatList

public class EntityFishHook extends Entity
{

    private int field_4095_d;
    private int field_4094_e;
    private int field_4093_f;
    private int field_4092_g;
    private boolean field_4091_h;
    public int field_4098_a;
    public EntityPlayer field_4097_b;
    private int field_4090_i;
    private int field_4089_j;
    private int field_4088_k;
    public Entity field_4096_c;
    private int field_6388_l;
    private double field_6387_m;
    private double field_6386_n;
    private double field_6385_o;
    private double field_6384_p;
    private double field_6383_q;
    private double field_6382_r;
    private double field_6381_s;
    private double field_6380_t;

    public EntityFishHook(World world)
    {
        super(world);
        field_4095_d = -1;
        field_4094_e = -1;
        field_4093_f = -1;
        field_4092_g = 0;
        field_4091_h = false;
        field_4098_a = 0;
        field_4089_j = 0;
        field_4088_k = 0;
        field_4096_c = null;
        func_371_a(0.25F, 0.25F);
        field_28016_bK = true;
    }

    public EntityFishHook(World world, double d, double d1, double d2)
    {
        this(world);
        func_347_a(d, d1, d2);
        field_28016_bK = true;
    }

    public EntityFishHook(World world, EntityPlayer entityplayer)
    {
        super(world);
        field_4095_d = -1;
        field_4094_e = -1;
        field_4093_f = -1;
        field_4092_g = 0;
        field_4091_h = false;
        field_4098_a = 0;
        field_4089_j = 0;
        field_4088_k = 0;
        field_4096_c = null;
        field_28016_bK = true;
        field_4097_b = entityplayer;
        field_4097_b.field_4128_n = this;
        func_371_a(0.25F, 0.25F);
        func_365_c(entityplayer.field_611_ak, (entityplayer.field_610_al + 1.6200000000000001D) - (double)entityplayer.field_9292_aO, entityplayer.field_609_am, entityplayer.field_605_aq, entityplayer.field_604_ar);
        field_611_ak -= MathHelper.func_1114_b((field_605_aq / 180F) * 3.141593F) * 0.16F;
        field_610_al -= 0.10000000149011612D;
        field_609_am -= MathHelper.func_1106_a((field_605_aq / 180F) * 3.141593F) * 0.16F;
        func_347_a(field_611_ak, field_610_al, field_609_am);
        field_9292_aO = 0.0F;
        float f = 0.4F;
        field_608_an = -MathHelper.func_1106_a((field_605_aq / 180F) * 3.141593F) * MathHelper.func_1114_b((field_604_ar / 180F) * 3.141593F) * f;
        field_606_ap = MathHelper.func_1114_b((field_605_aq / 180F) * 3.141593F) * MathHelper.func_1114_b((field_604_ar / 180F) * 3.141593F) * f;
        field_607_ao = -MathHelper.func_1106_a((field_604_ar / 180F) * 3.141593F) * f;
        func_4042_a(field_608_an, field_607_ao, field_606_ap, 1.5F, 1.0F);
    }

    protected void func_21057_b()
    {
    }

    public boolean func_384_a(double d)
    {
        double d1 = field_601_au.func_1164_b() * 4D;
        d1 *= 64D;
        return d < d1 * d1;
    }

    public void func_4042_a(double d, double d1, double d2, float f, 
            float f1)
    {
        float f2 = MathHelper.func_1109_a(d * d + d1 * d1 + d2 * d2);
        d /= f2;
        d1 /= f2;
        d2 /= f2;
        d += field_9312_bd.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d1 += field_9312_bd.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d2 += field_9312_bd.nextGaussian() * 0.0074999998323619366D * (double)f1;
        d *= f;
        d1 *= f;
        d2 *= f;
        field_608_an = d;
        field_607_ao = d1;
        field_606_ap = d2;
        float f3 = MathHelper.func_1109_a(d * d + d2 * d2);
        field_603_as = field_605_aq = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
        field_602_at = field_604_ar = (float)((Math.atan2(d1, f3) * 180D) / 3.1415927410125732D);
        field_4090_i = 0;
    }

    public void func_378_a(double d, double d1, double d2, float f, 
            float f1, int i)
    {
        field_6387_m = d;
        field_6386_n = d1;
        field_6385_o = d2;
        field_6384_p = f;
        field_6383_q = f1;
        field_6388_l = i;
        field_608_an = field_6382_r;
        field_607_ao = field_6381_s;
        field_606_ap = field_6380_t;
    }

    public void func_6375_a(double d, double d1, double d2)
    {
        field_6382_r = field_608_an = d;
        field_6381_s = field_607_ao = d1;
        field_6380_t = field_606_ap = d2;
    }

    public void func_370_e_()
    {
        super.func_370_e_();
        if(field_6388_l > 0)
        {
            double d = field_611_ak + (field_6387_m - field_611_ak) / (double)field_6388_l;
            double d1 = field_610_al + (field_6386_n - field_610_al) / (double)field_6388_l;
            double d2 = field_609_am + (field_6385_o - field_609_am) / (double)field_6388_l;
            double d4;
            for(d4 = field_6384_p - (double)field_605_aq; d4 < -180D; d4 += 360D) { }
            for(; d4 >= 180D; d4 -= 360D) { }
            field_605_aq += d4 / (double)field_6388_l;
            field_604_ar += (field_6383_q - (double)field_604_ar) / (double)field_6388_l;
            field_6388_l--;
            func_347_a(d, d1, d2);
            func_376_c(field_605_aq, field_604_ar);
            return;
        }
        if(!field_615_ag.field_1026_y)
        {
            ItemStack itemstack = field_4097_b.func_6416_v();
            if(field_4097_b.field_646_aA || !field_4097_b.func_354_B() || itemstack == null || itemstack.func_1091_a() != Item.field_4024_aP || func_387_e(field_4097_b) > 1024D)
            {
                func_395_F();
                field_4097_b.field_4128_n = null;
                return;
            }
            if(field_4096_c != null)
            {
                if(field_4096_c.field_646_aA)
                {
                    field_4096_c = null;
                } else
                {
                    field_611_ak = field_4096_c.field_611_ak;
                    field_610_al = field_4096_c.field_601_au.field_1697_b + (double)field_4096_c.field_643_aD * 0.80000000000000004D;
                    field_609_am = field_4096_c.field_609_am;
                    return;
                }
            }
        }
        if(field_4098_a > 0)
        {
            field_4098_a--;
        }
        if(field_4091_h)
        {
            int i = field_615_ag.func_600_a(field_4095_d, field_4094_e, field_4093_f);
            if(i != field_4092_g)
            {
                field_4091_h = false;
                field_608_an *= field_9312_bd.nextFloat() * 0.2F;
                field_607_ao *= field_9312_bd.nextFloat() * 0.2F;
                field_606_ap *= field_9312_bd.nextFloat() * 0.2F;
                field_4090_i = 0;
                field_4089_j = 0;
            } else
            {
                field_4090_i++;
                if(field_4090_i == 1200)
                {
                    func_395_F();
                }
                return;
            }
        } else
        {
            field_4089_j++;
        }
        Vec3D vec3d = Vec3D.func_1248_b(field_611_ak, field_610_al, field_609_am);
        Vec3D vec3d1 = Vec3D.func_1248_b(field_611_ak + field_608_an, field_610_al + field_607_ao, field_609_am + field_606_ap);
        MovingObjectPosition movingobjectposition = field_615_ag.func_645_a(vec3d, vec3d1);
        vec3d = Vec3D.func_1248_b(field_611_ak, field_610_al, field_609_am);
        vec3d1 = Vec3D.func_1248_b(field_611_ak + field_608_an, field_610_al + field_607_ao, field_609_am + field_606_ap);
        if(movingobjectposition != null)
        {
            vec3d1 = Vec3D.func_1248_b(movingobjectposition.field_1169_f.field_1776_a, movingobjectposition.field_1169_f.field_1775_b, movingobjectposition.field_1169_f.field_1779_c);
        }
        Entity entity = null;
        List list = field_615_ag.func_659_b(this, field_601_au.func_1170_a(field_608_an, field_607_ao, field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
        double d3 = 0.0D;
        for(int j = 0; j < list.size(); j++)
        {
            Entity entity1 = (Entity)list.get(j);
            if(!entity1.func_401_c_() || entity1 == field_4097_b && field_4089_j < 5)
            {
                continue;
            }
            float f2 = 0.3F;
            AxisAlignedBB axisalignedbb = entity1.field_601_au.func_1177_b(f2, f2, f2);
            MovingObjectPosition movingobjectposition1 = axisalignedbb.func_1169_a(vec3d, vec3d1);
            if(movingobjectposition1 == null)
            {
                continue;
            }
            double d6 = vec3d.func_1251_c(movingobjectposition1.field_1169_f);
            if(d6 < d3 || d3 == 0.0D)
            {
                entity = entity1;
                d3 = d6;
            }
        }

        if(entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if(movingobjectposition != null)
        {
            if(movingobjectposition.field_1168_g != null)
            {
                if(movingobjectposition.field_1168_g.func_396_a(DamageSource.func_35524_a(this, field_4097_b), 0))
                {
                    field_4096_c = movingobjectposition.field_1168_g;
                }
            } else
            {
                field_4091_h = true;
            }
        }
        if(field_4091_h)
        {
            return;
        }
        func_349_c(field_608_an, field_607_ao, field_606_ap);
        float f = MathHelper.func_1109_a(field_608_an * field_608_an + field_606_ap * field_606_ap);
        field_605_aq = (float)((Math.atan2(field_608_an, field_606_ap) * 180D) / 3.1415927410125732D);
        for(field_604_ar = (float)((Math.atan2(field_607_ao, f) * 180D) / 3.1415927410125732D); field_604_ar - field_602_at < -180F; field_602_at -= 360F) { }
        for(; field_604_ar - field_602_at >= 180F; field_602_at += 360F) { }
        for(; field_605_aq - field_603_as < -180F; field_603_as -= 360F) { }
        for(; field_605_aq - field_603_as >= 180F; field_603_as += 360F) { }
        field_604_ar = field_602_at + (field_604_ar - field_602_at) * 0.2F;
        field_605_aq = field_603_as + (field_605_aq - field_603_as) * 0.2F;
        float f1 = 0.92F;
        if(field_9298_aH || field_9297_aI)
        {
            f1 = 0.5F;
        }
        int k = 5;
        double d5 = 0.0D;
        for(int l = 0; l < k; l++)
        {
            double d8 = ((field_601_au.field_1697_b + ((field_601_au.field_1702_e - field_601_au.field_1697_b) * (double)(l + 0)) / (double)k) - 0.125D) + 0.125D;
            double d9 = ((field_601_au.field_1697_b + ((field_601_au.field_1702_e - field_601_au.field_1697_b) * (double)(l + 1)) / (double)k) - 0.125D) + 0.125D;
            AxisAlignedBB axisalignedbb1 = AxisAlignedBB.func_1161_b(field_601_au.field_1698_a, d8, field_601_au.field_1704_c, field_601_au.field_1703_d, d9, field_601_au.field_1701_f);
            if(field_615_ag.func_707_b(axisalignedbb1, Material.field_1332_f))
            {
                d5 += 1.0D / (double)k;
            }
        }

        if(d5 > 0.0D)
        {
            if(field_4088_k > 0)
            {
                field_4088_k--;
            } else
            {
                char c = '\u01F4';
                if(field_615_ag.func_27167_r(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_610_al) + 1, MathHelper.func_1108_b(field_609_am)))
                {
                    c = '\u012C';
                }
                if(field_9312_bd.nextInt(c) == 0)
                {
                    field_4088_k = field_9312_bd.nextInt(30) + 10;
                    field_607_ao -= 0.20000000298023224D;
                    field_615_ag.func_623_a(this, "random.splash", 0.25F, 1.0F + (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.4F);
                    float f3 = MathHelper.func_1108_b(field_601_au.field_1697_b);
                    for(int i1 = 0; (float)i1 < 1.0F + field_644_aC * 20F; i1++)
                    {
                        float f4 = (field_9312_bd.nextFloat() * 2.0F - 1.0F) * field_644_aC;
                        float f6 = (field_9312_bd.nextFloat() * 2.0F - 1.0F) * field_644_aC;
                        field_615_ag.func_694_a("bubble", field_611_ak + (double)f4, f3 + 1.0F, field_609_am + (double)f6, field_608_an, field_607_ao - (double)(field_9312_bd.nextFloat() * 0.2F), field_606_ap);
                    }

                    for(int j1 = 0; (float)j1 < 1.0F + field_644_aC * 20F; j1++)
                    {
                        float f5 = (field_9312_bd.nextFloat() * 2.0F - 1.0F) * field_644_aC;
                        float f7 = (field_9312_bd.nextFloat() * 2.0F - 1.0F) * field_644_aC;
                        field_615_ag.func_694_a("splash", field_611_ak + (double)f5, f3 + 1.0F, field_609_am + (double)f7, field_608_an, field_607_ao, field_606_ap);
                    }

                }
            }
        }
        if(field_4088_k > 0)
        {
            field_607_ao -= (double)(field_9312_bd.nextFloat() * field_9312_bd.nextFloat() * field_9312_bd.nextFloat()) * 0.20000000000000001D;
        }
        double d7 = d5 * 2D - 1.0D;
        field_607_ao += 0.039999999105930328D * d7;
        if(d5 > 0.0D)
        {
            f1 = (float)((double)f1 * 0.90000000000000002D);
            field_607_ao *= 0.80000000000000004D;
        }
        field_608_an *= f1;
        field_607_ao *= f1;
        field_606_ap *= f1;
        func_347_a(field_611_ak, field_610_al, field_609_am);
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.func_749_a("xTile", (short)field_4095_d);
        nbttagcompound.func_749_a("yTile", (short)field_4094_e);
        nbttagcompound.func_749_a("zTile", (short)field_4093_f);
        nbttagcompound.func_761_a("inTile", (byte)field_4092_g);
        nbttagcompound.func_761_a("shake", (byte)field_4098_a);
        nbttagcompound.func_761_a("inGround", (byte)(field_4091_h ? 1 : 0));
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        field_4095_d = nbttagcompound.func_745_d("xTile");
        field_4094_e = nbttagcompound.func_745_d("yTile");
        field_4093_f = nbttagcompound.func_745_d("zTile");
        field_4092_g = nbttagcompound.func_746_c("inTile") & 0xff;
        field_4098_a = nbttagcompound.func_746_c("shake") & 0xff;
        field_4091_h = nbttagcompound.func_746_c("inGround") == 1;
    }

    public float func_392_h_()
    {
        return 0.0F;
    }

    public int func_4043_i()
    {
        byte byte0 = 0;
        if(field_4096_c != null)
        {
            double d = field_4097_b.field_611_ak - field_611_ak;
            double d2 = field_4097_b.field_610_al - field_610_al;
            double d4 = field_4097_b.field_609_am - field_609_am;
            double d6 = MathHelper.func_1109_a(d * d + d2 * d2 + d4 * d4);
            double d8 = 0.10000000000000001D;
            field_4096_c.field_608_an += d * d8;
            field_4096_c.field_607_ao += d2 * d8 + (double)MathHelper.func_1109_a(d6) * 0.080000000000000002D;
            field_4096_c.field_606_ap += d4 * d8;
            byte0 = 3;
        } else
        if(field_4088_k > 0)
        {
            EntityItem entityitem = new EntityItem(field_615_ag, field_611_ak, field_610_al, field_609_am, new ItemStack(Item.field_4021_aS));
            double d1 = field_4097_b.field_611_ak - field_611_ak;
            double d3 = field_4097_b.field_610_al - field_610_al;
            double d5 = field_4097_b.field_609_am - field_609_am;
            double d7 = MathHelper.func_1109_a(d1 * d1 + d3 * d3 + d5 * d5);
            double d9 = 0.10000000000000001D;
            entityitem.field_608_an = d1 * d9;
            entityitem.field_607_ao = d3 * d9 + (double)MathHelper.func_1109_a(d7) * 0.080000000000000002D;
            entityitem.field_606_ap = d5 * d9;
            field_615_ag.func_674_a(entityitem);
            field_4097_b.func_25058_a(StatList.field_25160_x, 1);
            byte0 = 1;
        }
        if(field_4091_h)
        {
            byte0 = 2;
        }
        func_395_F();
        field_4097_b.field_4128_n = null;
        return byte0;
    }
}
