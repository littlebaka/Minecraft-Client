// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MouseFilter, Session, MovementInput, 
//            PlayerController, AchievementList, StatFileWriter, GuiAchievement, 
//            World, SoundManager, Potion, PotionEffect, 
//            AxisAlignedBB, FoodStats, PlayerCapabilities, GuiWinGame, 
//            ItemStack, Item, NBTTagCompound, GuiEditSign, 
//            GuiChest, GuiCrafting, GuiEnchantment, GuiFurnace, 
//            GuiBrewingStand, GuiDispenser, EntityCrit2FX, EffectRenderer, 
//            EntityPickupFX, DamageSource, GuiIngame, StatBase, 
//            Achievement, MathHelper, TileEntitySign, IInventory, 
//            TileEntityFurnace, TileEntityBrewingStand, TileEntityDispenser, Entity

public class EntityPlayerSP extends EntityPlayer
{

    public MovementInput field_787_a;
    protected Minecraft field_788_bg;
    protected int field_35224_c;
    public int field_35221_d;
    public float field_35222_e;
    public float field_35223_ap;
    public float field_35226_aq;
    public float field_35225_ar;
    private MouseFilter field_21903_bJ;
    private MouseFilter field_21904_bK;
    private MouseFilter field_21902_bL;

    public EntityPlayerSP(Minecraft minecraft, World world, Session session, int i)
    {
        super(world);
        field_35224_c = 0;
        field_35221_d = 0;
        field_21903_bJ = new MouseFilter();
        field_21904_bK = new MouseFilter();
        field_21902_bL = new MouseFilter();
        field_788_bg = minecraft;
        field_4129_m = i;
        if(session != null && session.field_1666_b != null && session.field_1666_b.length() > 0)
        {
            field_20047_bv = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftSkins/").append(session.field_1666_b).append(".png").toString();
        }
        field_771_i = session.field_1666_b;
    }

    public void func_349_c(double d, double d1, double d2)
    {
        super.func_349_c(d, d1, d2);
    }

    public void func_418_b_()
    {
        super.func_418_b_();
        field_9342_ah = field_787_a.field_1174_a;
        field_9340_ai = field_787_a.field_1173_b;
        field_9336_ak = field_787_a.field_1176_d;
        field_35226_aq = field_35222_e;
        field_35225_ar = field_35223_ap;
        field_35223_ap += (double)(field_604_ar - field_35223_ap) * 0.5D;
        field_35222_e += (double)(field_605_aq - field_35222_e) * 0.5D;
    }

    protected boolean func_44001_ad()
    {
        return true;
    }

    public void func_425_j()
    {
        if(field_35221_d > 0)
        {
            field_35221_d--;
            if(field_35221_d == 0)
            {
                func_35113_c(false);
            }
        }
        if(field_35224_c > 0)
        {
            field_35224_c--;
        }
        if(field_788_bg.field_6327_b.func_35643_e())
        {
            field_611_ak = field_609_am = 0.5D;
            field_611_ak = 0.0D;
            field_609_am = 0.0D;
            field_605_aq = (float)field_9311_be / 12F;
            field_604_ar = 10F;
            field_610_al = 68.5D;
            return;
        }
        if(!field_788_bg.field_25001_G.func_27183_a(AchievementList.field_25195_b))
        {
            field_788_bg.field_25002_t.func_27101_b(AchievementList.field_25195_b);
        }
        field_28025_B = field_28026_A;
        if(field_28023_z)
        {
            if(!field_615_ag.field_1026_y && field_616_af != null)
            {
                func_6377_h(null);
            }
            if(field_788_bg.field_6313_p != null)
            {
                field_788_bg.func_6272_a(null);
            }
            if(field_28026_A == 0.0F)
            {
                field_788_bg.field_6301_A.func_337_a("portal.trigger", 1.0F, field_9312_bd.nextFloat() * 0.4F + 0.8F);
            }
            field_28026_A += 0.0125F;
            if(field_28026_A >= 1.0F)
            {
                field_28026_A = 1.0F;
                if(!field_615_ag.field_1026_y)
                {
                    field_28024_y = 10;
                    field_788_bg.field_6301_A.func_337_a("portal.travel", 1.0F, field_9312_bd.nextFloat() * 0.4F + 0.8F);
                    byte byte0 = 0;
                    if(field_4129_m == -1)
                    {
                        byte0 = 0;
                    } else
                    {
                        byte0 = -1;
                    }
                    field_788_bg.func_6237_k(byte0);
                    func_27026_a(AchievementList.field_40467_x);
                }
            }
            field_28023_z = false;
        } else
        if(func_35160_a(Potion.field_35684_k) && func_35167_b(Potion.field_35684_k).func_35802_b() > 60)
        {
            field_28026_A += 0.006666667F;
            if(field_28026_A > 1.0F)
            {
                field_28026_A = 1.0F;
            }
        } else
        {
            if(field_28026_A > 0.0F)
            {
                field_28026_A -= 0.05F;
            }
            if(field_28026_A < 0.0F)
            {
                field_28026_A = 0.0F;
            }
        }
        if(field_28024_y > 0)
        {
            field_28024_y--;
        }
        boolean flag = field_787_a.field_1176_d;
        float f = 0.8F;
        boolean flag1 = field_787_a.field_1173_b >= f;
        field_787_a.func_797_a(this);
        if(func_35196_Z())
        {
            field_787_a.field_1174_a *= 0.2F;
            field_787_a.field_1173_b *= 0.2F;
            field_35224_c = 0;
        }
        if(field_787_a.field_1175_e && field_9287_aY < 0.2F)
        {
            field_9287_aY = 0.2F;
        }
        func_28014_c(field_611_ak - (double)field_644_aC * 0.34999999999999998D, field_601_au.field_1697_b + 0.5D, field_609_am + (double)field_644_aC * 0.34999999999999998D);
        func_28014_c(field_611_ak - (double)field_644_aC * 0.34999999999999998D, field_601_au.field_1697_b + 0.5D, field_609_am - (double)field_644_aC * 0.34999999999999998D);
        func_28014_c(field_611_ak + (double)field_644_aC * 0.34999999999999998D, field_601_au.field_1697_b + 0.5D, field_609_am - (double)field_644_aC * 0.34999999999999998D);
        func_28014_c(field_611_ak + (double)field_644_aC * 0.34999999999999998D, field_601_au.field_1697_b + 0.5D, field_609_am + (double)field_644_aC * 0.34999999999999998D);
        boolean flag2 = (float)func_35191_at().func_35765_a() > 6F;
        if(field_9298_aH && !flag1 && field_787_a.field_1173_b >= f && !func_35117_Q() && flag2 && !func_35196_Z() && !func_35160_a(Potion.field_35693_q))
        {
            if(field_35224_c == 0)
            {
                field_35224_c = 7;
            } else
            {
                func_35113_c(true);
                field_35224_c = 0;
            }
        }
        if(func_381_o())
        {
            field_35224_c = 0;
        }
        if(func_35117_Q() && (field_787_a.field_1173_b < f || field_9297_aI || !flag2))
        {
            func_35113_c(false);
        }
        if(field_35212_aW.field_35758_c && !flag && field_787_a.field_1176_d)
        {
            if(field_35216_aw == 0)
            {
                field_35216_aw = 7;
            } else
            {
                field_35212_aW.field_35757_b = !field_35212_aW.field_35757_b;
                field_35216_aw = 0;
            }
        }
        if(field_35212_aW.field_35757_b)
        {
            if(field_787_a.field_1175_e)
            {
                field_607_ao -= 0.14999999999999999D;
            }
            if(field_787_a.field_1176_d)
            {
                field_607_ao += 0.14999999999999999D;
            }
        }
        super.func_425_j();
        if(field_9298_aH && field_35212_aW.field_35757_b)
        {
            field_35212_aW.field_35757_b = false;
        }
    }

    public void func_40182_b(int i)
    {
        if(!field_615_ag.field_1026_y)
        {
            if(field_4129_m == 1 && i == 1)
            {
                func_27026_a(AchievementList.field_40463_C);
                field_788_bg.func_6272_a(new GuiWinGame());
            } else
            {
                func_27026_a(AchievementList.field_40462_B);
                field_788_bg.field_6301_A.func_337_a("portal.travel", 1.0F, field_9312_bd.nextFloat() * 0.4F + 0.8F);
                field_788_bg.func_6237_k(1);
            }
        }
    }

    public float func_35220_u_()
    {
        float f = 1.0F;
        if(field_35212_aW.field_35757_b)
        {
            f *= 1.1F;
        }
        f *= ((field_35169_bv * func_35166_t_()) / field_35215_ba + 1.0F) / 2.0F;
        if(func_35196_Z() && func_35195_X().field_1617_c == Item.field_227_i.field_291_aS)
        {
            int i = func_35192_aa();
            float f1 = (float)i / 20F;
            if(f1 > 1.0F)
            {
                f1 = 1.0F;
            } else
            {
                f1 *= f1;
            }
            f *= 1.0F - f1 * 0.15F;
        }
        return f;
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        nbttagcompound.func_758_a("Score", field_9370_g);
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        field_9370_g = nbttagcompound.func_756_e("Score");
    }

    public void func_20059_m()
    {
        super.func_20059_m();
        field_788_bg.func_6272_a(null);
    }

    public void func_4052_a(TileEntitySign tileentitysign)
    {
        field_788_bg.func_6272_a(new GuiEditSign(tileentitysign));
    }

    public void func_452_a(IInventory iinventory)
    {
        field_788_bg.func_6272_a(new GuiChest(field_778_b, iinventory));
    }

    public void func_445_l(int i, int j, int k)
    {
        field_788_bg.func_6272_a(new GuiCrafting(field_778_b, field_615_ag, i, j, k));
    }

    public void func_40181_c(int i, int j, int k)
    {
        field_788_bg.func_6272_a(new GuiEnchantment(field_778_b, field_615_ag, i, j, k));
    }

    public void func_453_a(TileEntityFurnace tileentityfurnace)
    {
        field_788_bg.func_6272_a(new GuiFurnace(field_778_b, tileentityfurnace));
    }

    public void func_40180_a(TileEntityBrewingStand tileentitybrewingstand)
    {
        field_788_bg.func_6272_a(new GuiBrewingStand(field_778_b, tileentitybrewingstand));
    }

    public void func_21092_a(TileEntityDispenser tileentitydispenser)
    {
        field_788_bg.func_6272_a(new GuiDispenser(field_778_b, tileentitydispenser));
    }

    public void func_35200_b(Entity entity)
    {
        field_788_bg.field_6321_h.func_1192_a(new EntityCrit2FX(field_788_bg.field_6324_e, entity));
    }

    public void func_40183_c(Entity entity)
    {
        EntityCrit2FX entitycrit2fx = new EntityCrit2FX(field_788_bg.field_6324_e, entity, "magicCrit");
        field_788_bg.field_6321_h.func_1192_a(entitycrit2fx);
    }

    public void func_443_a_(Entity entity, int i)
    {
        field_788_bg.field_6321_h.func_1192_a(new EntityPickupFX(field_788_bg.field_6324_e, entity, this, -0.5F));
    }

    public void func_461_a(String s)
    {
    }

    public boolean func_381_o()
    {
        return field_787_a.field_1175_e && !field_21901_a;
    }

    public void func_9372_a_(int i)
    {
        int j = func_40114_aH() - i;
        if(j <= 0)
        {
            func_40121_k(i);
            if(j < 0)
            {
                field_9306_bj = field_9366_o / 2;
            }
        } else
        {
            field_9346_af = j;
            func_40121_k(func_40114_aH());
            field_9306_bj = field_9366_o;
            func_4044_a(DamageSource.field_35547_j, j);
            field_715_G = field_9332_M = 10;
        }
    }

    public void func_9367_r()
    {
        field_788_bg.func_6239_p(false, 0, false);
    }

    public void func_6420_o()
    {
    }

    public void func_22055_b(String s)
    {
        field_788_bg.field_6308_u.func_22064_c(s);
    }

    public void func_25058_a(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.func_25067_a())
        {
            Achievement achievement = (Achievement)statbase;
            if(achievement.field_25076_c == null || field_788_bg.field_25001_G.func_27183_a(achievement.field_25076_c))
            {
                if(!field_788_bg.field_25001_G.func_27183_a(achievement))
                {
                    field_788_bg.field_25002_t.func_27102_a(achievement);
                }
                field_788_bg.field_25001_G.func_25100_a(statbase, i);
            }
        } else
        {
            field_788_bg.field_25001_G.func_25100_a(statbase, i);
        }
    }

    private boolean func_28027_d(int i, int j, int k)
    {
        return field_615_ag.func_28100_h(i, j, k);
    }

    protected boolean func_28014_c(double d, double d1, double d2)
    {
        int i = MathHelper.func_1108_b(d);
        int j = MathHelper.func_1108_b(d1);
        int k = MathHelper.func_1108_b(d2);
        double d3 = d - (double)i;
        double d4 = d2 - (double)k;
        if(func_28027_d(i, j, k) || func_28027_d(i, j + 1, k))
        {
            boolean flag = !func_28027_d(i - 1, j, k) && !func_28027_d(i - 1, j + 1, k);
            boolean flag1 = !func_28027_d(i + 1, j, k) && !func_28027_d(i + 1, j + 1, k);
            boolean flag2 = !func_28027_d(i, j, k - 1) && !func_28027_d(i, j + 1, k - 1);
            boolean flag3 = !func_28027_d(i, j, k + 1) && !func_28027_d(i, j + 1, k + 1);
            byte byte0 = -1;
            double d5 = 9999D;
            if(flag && d3 < d5)
            {
                d5 = d3;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d3 < d5)
            {
                d5 = 1.0D - d3;
                byte0 = 1;
            }
            if(flag2 && d4 < d5)
            {
                d5 = d4;
                byte0 = 4;
            }
            if(flag3 && 1.0D - d4 < d5)
            {
                double d6 = 1.0D - d4;
                byte0 = 5;
            }
            float f = 0.1F;
            if(byte0 == 0)
            {
                field_608_an = -f;
            }
            if(byte0 == 1)
            {
                field_608_an = f;
            }
            if(byte0 == 4)
            {
                field_606_ap = -f;
            }
            if(byte0 == 5)
            {
                field_606_ap = f;
            }
        }
        return false;
    }

    public void func_35113_c(boolean flag)
    {
        super.func_35113_c(flag);
        if(!flag)
        {
            field_35221_d = 0;
        } else
        {
            field_35221_d = 600;
        }
    }

    public void func_35219_c(float f, int i, int j)
    {
        field_35211_aX = f;
        field_35209_aZ = i;
        field_35210_aY = j;
    }
}
