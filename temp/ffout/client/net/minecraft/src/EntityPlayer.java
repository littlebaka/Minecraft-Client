// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityLiving, InventoryPlayer, FoodStats, PlayerCapabilities, 
//            ContainerPlayer, World, ChunkCoordinates, DataWatcher, 
//            ItemStack, Item, EnumAction, Container, 
//            StatList, Vec3D, Potion, PotionEffect, 
//            MathHelper, AxisAlignedBB, Entity, EnchantmentHelper, 
//            EntityItem, Material, NBTTagCompound, NBTTagList, 
//            DamageSource, EntityMob, EntityArrow, EntityCreeper, 
//            EntityGhast, EntityWolf, AchievementList, EnumStatus, 
//            WorldProvider, BlockBed, Block, IChunkProvider, 
//            EntityMinecart, EntityBoat, EntityPig, EntityFishHook, 
//            IInventory, TileEntityFurnace, TileEntityDispenser, TileEntitySign, 
//            TileEntityBrewingStand, StatBase

public abstract class EntityPlayer extends EntityLiving
{

    public InventoryPlayer field_778_b;
    public Container field_20069_g;
    public Container field_20068_h;
    protected FoodStats field_35217_av;
    protected int field_35216_aw;
    public byte field_9371_f;
    public int field_9370_g;
    public float field_775_e;
    public float field_774_f;
    public boolean field_9369_j;
    public int field_9368_k;
    public String field_771_i;
    public int field_4129_m;
    public String field_20067_q;
    public int field_35214_aG;
    public double field_20066_r;
    public double field_20065_s;
    public double field_20064_t;
    public double field_20063_u;
    public double field_20062_v;
    public double field_20061_w;
    protected boolean field_21901_a;
    public ChunkCoordinates field_21908_b;
    private int field_21907_c;
    public float field_22063_x;
    public float field_22062_y;
    public float field_22061_z;
    private ChunkCoordinates field_24900_bi;
    private ChunkCoordinates field_26907_d;
    public int field_28024_y;
    protected boolean field_28023_z;
    public float field_28026_A;
    public float field_28025_B;
    public PlayerCapabilities field_35212_aW;
    public int field_35210_aY;
    public int field_35209_aZ;
    public float field_35211_aX;
    private ItemStack field_34907_d;
    private int field_34906_e;
    protected float field_35215_ba;
    protected float field_35213_bb;
    public EntityFishHook field_4128_n;

    public EntityPlayer(World world)
    {
        super(world);
        field_778_b = new InventoryPlayer(this);
        field_35217_av = new FoodStats();
        field_35216_aw = 0;
        field_9371_f = 0;
        field_9370_g = 0;
        field_9369_j = false;
        field_9368_k = 0;
        field_35214_aG = 0;
        field_28024_y = 20;
        field_28023_z = false;
        field_35212_aW = new PlayerCapabilities();
        field_35215_ba = 0.1F;
        field_35213_bb = 0.02F;
        field_4128_n = null;
        field_20069_g = new ContainerPlayer(field_778_b, !world.field_1026_y);
        field_20068_h = field_20069_g;
        field_9292_aO = 1.62F;
        ChunkCoordinates chunkcoordinates = world.func_22137_s();
        func_365_c((double)chunkcoordinates.field_22395_a + 0.5D, chunkcoordinates.field_22394_b + 1, (double)chunkcoordinates.field_22396_c + 0.5D, 0.0F, 0.0F);
        field_9351_C = "humanoid";
        field_9353_B = 180F;
        field_9310_bf = 20;
        field_9357_z = "/mob/char.png";
    }

    public int func_40117_c()
    {
        return 20;
    }

    protected void func_21057_b()
    {
        super.func_21057_b();
        field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
        field_21064_bx.func_21124_a(17, Byte.valueOf((byte)0));
    }

    public ItemStack func_35195_X()
    {
        return field_34907_d;
    }

    public int func_35205_Y()
    {
        return field_34906_e;
    }

    public boolean func_35196_Z()
    {
        return field_34907_d != null;
    }

    public int func_35192_aa()
    {
        if(func_35196_Z())
        {
            return field_34907_d.func_35866_m() - field_34906_e;
        } else
        {
            return 0;
        }
    }

    public void func_35206_ab()
    {
        if(field_34907_d != null)
        {
            field_34907_d.func_35862_a(field_615_ag, this, field_34906_e);
        }
        func_35207_ac();
    }

    public void func_35207_ac()
    {
        field_34907_d = null;
        field_34906_e = 0;
        if(!field_615_ag.field_1026_y)
        {
            func_35116_d(false);
        }
    }

    public boolean func_35162_ad()
    {
        return func_35196_Z() && Item.field_233_c[field_34907_d.field_1617_c].func_35412_b(field_34907_d) == EnumAction.block;
    }

    public void func_370_e_()
    {
        if(field_34907_d != null)
        {
            ItemStack itemstack = field_778_b.func_494_a();
            if(itemstack != field_34907_d)
            {
                func_35207_ac();
            } else
            {
                if(field_34906_e <= 25 && field_34906_e % 4 == 0)
                {
                    func_35201_a(itemstack, 5);
                }
                if(--field_34906_e == 0 && !field_615_ag.field_1026_y)
                {
                    func_35208_ae();
                }
            }
        }
        if(field_35214_aG > 0)
        {
            field_35214_aG--;
        }
        if(func_22051_K())
        {
            field_21907_c++;
            if(field_21907_c > 100)
            {
                field_21907_c = 100;
            }
            if(!field_615_ag.field_1026_y)
            {
                if(!func_22057_q())
                {
                    func_22056_a(true, true, false);
                } else
                if(field_615_ag.func_624_b())
                {
                    func_22056_a(false, true, true);
                }
            }
        } else
        if(field_21907_c > 0)
        {
            field_21907_c++;
            if(field_21907_c >= 110)
            {
                field_21907_c = 0;
            }
        }
        super.func_370_e_();
        if(!field_615_ag.field_1026_y && field_20068_h != null && !field_20068_h.func_20120_b(this))
        {
            func_20059_m();
            field_20068_h = field_20069_g;
        }
        if(field_35212_aW.field_35757_b)
        {
            for(int i = 0; i < 8; i++) { }
        }
        if(func_21062_U() && field_35212_aW.field_35759_a)
        {
            func_40045_B();
        }
        field_20066_r = field_20063_u;
        field_20065_s = field_20062_v;
        field_20064_t = field_20061_w;
        double d = field_611_ak - field_20063_u;
        double d1 = field_610_al - field_20062_v;
        double d2 = field_609_am - field_20061_w;
        double d3 = 10D;
        if(d > d3)
        {
            field_20066_r = field_20063_u = field_611_ak;
        }
        if(d2 > d3)
        {
            field_20064_t = field_20061_w = field_609_am;
        }
        if(d1 > d3)
        {
            field_20065_s = field_20062_v = field_610_al;
        }
        if(d < -d3)
        {
            field_20066_r = field_20063_u = field_611_ak;
        }
        if(d2 < -d3)
        {
            field_20064_t = field_20061_w = field_609_am;
        }
        if(d1 < -d3)
        {
            field_20065_s = field_20062_v = field_610_al;
        }
        field_20063_u += d * 0.25D;
        field_20061_w += d2 * 0.25D;
        field_20062_v += d1 * 0.25D;
        func_25058_a(StatList.field_25179_j, 1);
        if(field_616_af == null)
        {
            field_26907_d = null;
        }
        if(!field_615_ag.field_1026_y)
        {
            field_35217_av.func_35768_a(this);
        }
    }

    protected void func_35201_a(ItemStack itemstack, int i)
    {
        if(itemstack.func_35865_n() == EnumAction.drink)
        {
            field_615_ag.func_623_a(this, "random.drink", 0.5F, field_615_ag.field_1037_n.nextFloat() * 0.1F + 0.9F);
        }
        if(itemstack.func_35865_n() == EnumAction.eat)
        {
            for(int j = 0; j < i; j++)
            {
                Vec3D vec3d = Vec3D.func_1248_b(((double)field_9312_bd.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D);
                vec3d.func_1258_a((-field_604_ar * 3.141593F) / 180F);
                vec3d.func_1249_b((-field_605_aq * 3.141593F) / 180F);
                Vec3D vec3d1 = Vec3D.func_1248_b(((double)field_9312_bd.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-field_9312_bd.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D);
                vec3d1.func_1258_a((-field_604_ar * 3.141593F) / 180F);
                vec3d1.func_1249_b((-field_605_aq * 3.141593F) / 180F);
                vec3d1 = vec3d1.func_1257_c(field_611_ak, field_610_al + (double)func_373_s(), field_609_am);
                field_615_ag.func_694_a((new StringBuilder()).append("iconcrack_").append(itemstack.func_1091_a().field_291_aS).toString(), vec3d1.field_1776_a, vec3d1.field_1775_b, vec3d1.field_1779_c, vec3d.field_1776_a, vec3d.field_1775_b + 0.050000000000000003D, vec3d.field_1779_c);
            }

            field_615_ag.func_623_a(this, "random.eat", 0.5F + 0.5F * (float)field_9312_bd.nextInt(2), (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected void func_35208_ae()
    {
        if(field_34907_d != null)
        {
            func_35201_a(field_34907_d, 16);
            int i = field_34907_d.field_1615_a;
            ItemStack itemstack = field_34907_d.func_35863_b(field_615_ag, this);
            if(itemstack != field_34907_d || itemstack != null && itemstack.field_1615_a != i)
            {
                field_778_b.field_843_a[field_778_b.field_847_d] = itemstack;
                if(itemstack.field_1615_a == 0)
                {
                    field_778_b.field_843_a[field_778_b.field_847_d] = null;
                }
            }
            func_35207_ac();
        }
    }

    public void func_9282_a(byte byte0)
    {
        if(byte0 == 9)
        {
            func_35208_ae();
        } else
        {
            super.func_9282_a(byte0);
        }
    }

    protected boolean func_22049_v()
    {
        return func_40114_aH() <= 0 || func_22051_K();
    }

    protected void func_20059_m()
    {
        field_20068_h = field_20069_g;
    }

    public void func_20046_s()
    {
        field_20067_q = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftCloaks/").append(field_771_i).append(".png").toString();
        field_622_aY = field_20067_q;
    }

    public void func_350_p()
    {
        double d = field_611_ak;
        double d1 = field_610_al;
        double d2 = field_609_am;
        super.func_350_p();
        field_775_e = field_774_f;
        field_774_f = 0.0F;
        func_27024_i(field_611_ak - d, field_610_al - d1, field_609_am - d2);
    }

    public void func_374_q()
    {
        field_9292_aO = 1.62F;
        func_371_a(0.6F, 1.8F);
        super.func_374_q();
        func_40121_k(func_40117_c());
        field_712_J = 0;
    }

    private int func_35202_aE()
    {
        if(func_35160_a(Potion.field_35675_e))
        {
            return 6 - (1 + func_35167_b(Potion.field_35675_e).func_35801_c()) * 1;
        }
        if(func_35160_a(Potion.field_35672_f))
        {
            return 6 + (1 + func_35167_b(Potion.field_35672_f).func_35801_c()) * 2;
        } else
        {
            return 6;
        }
    }

    protected void func_418_b_()
    {
        int i = func_35202_aE();
        if(field_9369_j)
        {
            field_9368_k++;
            if(field_9368_k >= i)
            {
                field_9368_k = 0;
                field_9369_j = false;
            }
        } else
        {
            field_9368_k = 0;
        }
        field_9339_I = (float)field_9368_k / (float)i;
    }

    public void func_425_j()
    {
        if(field_35216_aw > 0)
        {
            field_35216_aw--;
        }
        if(field_615_ag.field_1039_l == 0 && func_40114_aH() < func_40117_c() && (field_9311_be % 20) * 12 == 0)
        {
            func_432_b(1);
        }
        field_778_b.func_511_b();
        field_775_e = field_774_f;
        super.func_425_j();
        field_35169_bv = field_35215_ba;
        field_35168_bw = field_35213_bb;
        if(func_35117_Q())
        {
            field_35169_bv += (double)field_35215_ba * 0.29999999999999999D;
            field_35168_bw += (double)field_35213_bb * 0.29999999999999999D;
        }
        float f = MathHelper.func_1109_a(field_608_an * field_608_an + field_606_ap * field_606_ap);
        float f1 = (float)Math.atan(-field_607_ao * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
        {
            f = 0.1F;
        }
        if(!field_9298_aH || func_40114_aH() <= 0)
        {
            f = 0.0F;
        }
        if(field_9298_aH || func_40114_aH() <= 0)
        {
            f1 = 0.0F;
        }
        field_774_f += (f - field_774_f) * 0.4F;
        field_9328_R += (f1 - field_9328_R) * 0.8F;
        if(func_40114_aH() > 0)
        {
            List list = field_615_ag.func_659_b(this, field_601_au.func_1177_b(1.0D, 0.0D, 1.0D));
            if(list != null)
            {
                for(int i = 0; i < list.size(); i++)
                {
                    Entity entity = (Entity)list.get(i);
                    if(!entity.field_646_aA)
                    {
                        func_451_h(entity);
                    }
                }

            }
        }
    }

    private void func_451_h(Entity entity)
    {
        entity.func_6378_b(this);
    }

    public int func_6417_t()
    {
        return field_9370_g;
    }

    public void func_419_b(DamageSource damagesource)
    {
        super.func_419_b(damagesource);
        func_371_a(0.2F, 0.2F);
        func_347_a(field_611_ak, field_610_al, field_609_am);
        field_607_ao = 0.10000000149011612D;
        if(field_771_i.equals("Notch"))
        {
            func_444_a(new ItemStack(Item.field_228_h, 1), true);
        }
        field_778_b.func_503_g();
        if(damagesource != null)
        {
            field_608_an = -MathHelper.func_1114_b(((field_9331_N + field_605_aq) * 3.141593F) / 180F) * 0.1F;
            field_606_ap = -MathHelper.func_1106_a(((field_9331_N + field_605_aq) * 3.141593F) / 180F) * 0.1F;
        } else
        {
            field_608_an = field_606_ap = 0.0D;
        }
        field_9292_aO = 0.1F;
        func_25058_a(StatList.field_25163_u, 1);
    }

    public void func_364_b(Entity entity, int i)
    {
        field_9370_g += i;
        if(entity instanceof EntityPlayer)
        {
            func_25058_a(StatList.field_25161_w, 1);
        } else
        {
            func_25058_a(StatList.field_25162_v, 1);
        }
    }

    protected int func_40116_f(int i)
    {
        int j = EnchantmentHelper.func_40632_a(field_778_b);
        if(j > 0 && field_9312_bd.nextInt(j + 1) > 0)
        {
            return i;
        } else
        {
            return super.func_40116_f(i);
        }
    }

    public void func_20060_w()
    {
        func_444_a(field_778_b.func_473_a(field_778_b.field_847_d, 1), false);
    }

    public void func_449_a(ItemStack itemstack)
    {
        func_444_a(itemstack, false);
    }

    public void func_444_a(ItemStack itemstack, boolean flag)
    {
        if(itemstack == null)
        {
            return;
        }
        EntityItem entityitem = new EntityItem(field_615_ag, field_611_ak, (field_610_al - 0.30000001192092896D) + (double)func_373_s(), field_609_am, itemstack);
        entityitem.field_805_c = 40;
        float f = 0.1F;
        if(flag)
        {
            float f2 = field_9312_bd.nextFloat() * 0.5F;
            float f4 = field_9312_bd.nextFloat() * 3.141593F * 2.0F;
            entityitem.field_608_an = -MathHelper.func_1106_a(f4) * f2;
            entityitem.field_606_ap = MathHelper.func_1114_b(f4) * f2;
            entityitem.field_607_ao = 0.20000000298023224D;
        } else
        {
            float f1 = 0.3F;
            entityitem.field_608_an = -MathHelper.func_1106_a((field_605_aq / 180F) * 3.141593F) * MathHelper.func_1114_b((field_604_ar / 180F) * 3.141593F) * f1;
            entityitem.field_606_ap = MathHelper.func_1114_b((field_605_aq / 180F) * 3.141593F) * MathHelper.func_1114_b((field_604_ar / 180F) * 3.141593F) * f1;
            entityitem.field_607_ao = -MathHelper.func_1106_a((field_604_ar / 180F) * 3.141593F) * f1 + 0.1F;
            f1 = 0.02F;
            float f3 = field_9312_bd.nextFloat() * 3.141593F * 2.0F;
            f1 *= field_9312_bd.nextFloat();
            entityitem.field_608_an += Math.cos(f3) * (double)f1;
            entityitem.field_607_ao += (field_9312_bd.nextFloat() - field_9312_bd.nextFloat()) * 0.1F;
            entityitem.field_606_ap += Math.sin(f3) * (double)f1;
        }
        func_446_a(entityitem);
        func_25058_a(StatList.field_25168_r, 1);
    }

    protected void func_446_a(EntityItem entityitem)
    {
        field_615_ag.func_674_a(entityitem);
    }

    public float func_450_a(Block block)
    {
        float f = field_778_b.func_508_a(block);
        float f1 = f;
        int i = EnchantmentHelper.func_40642_b(field_778_b);
        if(i > 0 && field_778_b.func_509_b(block))
        {
            f1 += i * i + 1;
        }
        if(func_35160_a(Potion.field_35675_e))
        {
            f1 *= 1.0F + (float)(func_35167_b(Potion.field_35675_e).func_35801_c() + 1) * 0.2F;
        }
        if(func_35160_a(Potion.field_35672_f))
        {
            f1 *= 1.0F - (float)(func_35167_b(Potion.field_35672_f).func_35801_c() + 1) * 0.2F;
        }
        if(func_393_a(Material.field_1332_f) && !EnchantmentHelper.func_40633_g(field_778_b))
        {
            f1 /= 5F;
        }
        if(!field_9298_aH)
        {
            f1 /= 5F;
        }
        return f1;
    }

    public boolean func_454_b(Block block)
    {
        return field_778_b.func_509_b(block);
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        super.func_357_b(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.func_753_l("Inventory");
        field_778_b.func_513_b(nbttaglist);
        field_4129_m = nbttagcompound.func_756_e("Dimension");
        field_21901_a = nbttagcompound.func_760_m("Sleeping");
        field_21907_c = nbttagcompound.func_745_d("SleepTimer");
        field_35211_aX = nbttagcompound.func_752_g("XpP");
        field_35210_aY = nbttagcompound.func_756_e("XpLevel");
        field_35209_aZ = nbttagcompound.func_756_e("XpTotal");
        if(field_21901_a)
        {
            field_21908_b = new ChunkCoordinates(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_610_al), MathHelper.func_1108_b(field_609_am));
            func_22056_a(true, true, false);
        }
        if(nbttagcompound.func_751_b("SpawnX") && nbttagcompound.func_751_b("SpawnY") && nbttagcompound.func_751_b("SpawnZ"))
        {
            field_24900_bi = new ChunkCoordinates(nbttagcompound.func_756_e("SpawnX"), nbttagcompound.func_756_e("SpawnY"), nbttagcompound.func_756_e("SpawnZ"));
        }
        field_35217_av.func_35766_a(nbttagcompound);
        field_35212_aW.func_40600_b(nbttagcompound);
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        super.func_352_a(nbttagcompound);
        nbttagcompound.func_762_a("Inventory", field_778_b.func_493_a(new NBTTagList()));
        nbttagcompound.func_758_a("Dimension", field_4129_m);
        nbttagcompound.func_748_a("Sleeping", field_21901_a);
        nbttagcompound.func_749_a("SleepTimer", (short)field_21907_c);
        nbttagcompound.func_744_a("XpP", field_35211_aX);
        nbttagcompound.func_758_a("XpLevel", field_35210_aY);
        nbttagcompound.func_758_a("XpTotal", field_35209_aZ);
        if(field_24900_bi != null)
        {
            nbttagcompound.func_758_a("SpawnX", field_24900_bi.field_22395_a);
            nbttagcompound.func_758_a("SpawnY", field_24900_bi.field_22394_b);
            nbttagcompound.func_758_a("SpawnZ", field_24900_bi.field_22396_c);
        }
        field_35217_av.func_35763_b(nbttagcompound);
        field_35212_aW.func_40601_a(nbttagcompound);
    }

    public void func_452_a(IInventory iinventory)
    {
    }

    public void func_40181_c(int i, int j, int k)
    {
    }

    public void func_445_l(int i, int j, int k)
    {
    }

    public void func_443_a_(Entity entity, int i)
    {
    }

    public float func_373_s()
    {
        return 0.12F;
    }

    protected void func_22058_C()
    {
        field_9292_aO = 1.62F;
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        if(field_35212_aW.field_35759_a && !damagesource.func_35529_d())
        {
            return false;
        }
        field_9344_ag = 0;
        if(func_40114_aH() <= 0)
        {
            return false;
        }
        if(func_22051_K() && !field_615_ag.field_1026_y)
        {
            func_22056_a(true, true, false);
        }
        Entity entity = damagesource.func_35532_a();
        if((entity instanceof EntityMob) || (entity instanceof EntityArrow))
        {
            if(field_615_ag.field_1039_l == 0)
            {
                i = 0;
            }
            if(field_615_ag.field_1039_l == 1)
            {
                i = i / 2 + 1;
            }
            if(field_615_ag.field_1039_l == 3)
            {
                i = (i * 3) / 2;
            }
        }
        if(i == 0)
        {
            return false;
        }
        Entity entity1 = entity;
        if((entity1 instanceof EntityArrow) && ((EntityArrow)entity1).field_682_g != null)
        {
            entity1 = ((EntityArrow)entity1).field_682_g;
        }
        if(entity1 instanceof EntityLiving)
        {
            func_25055_a((EntityLiving)entity1, false);
        }
        func_25058_a(StatList.field_25165_t, i);
        return super.func_396_a(damagesource, i);
    }

    protected int func_40128_b(DamageSource damagesource, int i)
    {
        int j = super.func_40128_b(damagesource, i);
        if(j <= 0)
        {
            return 0;
        }
        int k = EnchantmentHelper.func_40643_a(field_778_b, damagesource);
        if(k > 20)
        {
            k = 20;
        }
        if(k > 0 && k <= 20)
        {
            int l = 25 - k;
            int i1 = j * l + field_40129_bA;
            j = i1 / 25;
            field_40129_bA = i1 % 25;
        }
        return j;
    }

    protected boolean func_27025_G()
    {
        return false;
    }

    protected void func_25055_a(EntityLiving entityliving, boolean flag)
    {
        if((entityliving instanceof EntityCreeper) || (entityliving instanceof EntityGhast))
        {
            return;
        }
        if(entityliving instanceof EntityWolf)
        {
            EntityWolf entitywolf = (EntityWolf)entityliving;
            if(entitywolf.func_25047_D() && field_771_i.equals(entitywolf.func_25045_A()))
            {
                return;
            }
        }
        if((entityliving instanceof EntityPlayer) && !func_27025_G())
        {
            return;
        }
        List list = field_615_ag.func_657_a(net.minecraft.src.EntityWolf.class, AxisAlignedBB.func_1161_b(field_611_ak, field_610_al, field_609_am, field_611_ak + 1.0D, field_610_al + 1.0D, field_609_am + 1.0D).func_1177_b(16D, 4D, 16D));
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            EntityWolf entitywolf1 = (EntityWolf)entity;
            if(entitywolf1.func_25047_D() && entitywolf1.func_25030_F() == null && field_771_i.equals(entitywolf1.func_25045_A()) && (!flag || !entitywolf1.func_25034_B()))
            {
                entitywolf1.func_25046_b(false);
                entitywolf1.func_25032_c(entityliving);
            }
        } while(true);
    }

    protected void func_40125_g(int i)
    {
        field_778_b.func_507_e(i);
    }

    public int func_40119_ar()
    {
        return field_778_b.func_506_f();
    }

    protected void func_4044_a(DamageSource damagesource, int i)
    {
        if(!damagesource.func_35534_b() && func_35162_ad())
        {
            i = 1 + i >> 1;
        }
        i = func_40115_d(damagesource, i);
        i = func_40128_b(damagesource, i);
        func_35198_d(damagesource.func_35533_c());
        field_9337_J -= i;
    }

    public void func_453_a(TileEntityFurnace tileentityfurnace)
    {
    }

    public void func_21092_a(TileEntityDispenser tileentitydispenser)
    {
    }

    public void func_4052_a(TileEntitySign tileentitysign)
    {
    }

    public void func_40180_a(TileEntityBrewingStand tileentitybrewingstand)
    {
    }

    public void func_6415_a_(Entity entity)
    {
        if(entity.func_353_a(this))
        {
            return;
        }
        ItemStack itemstack = func_6416_v();
        if(itemstack != null && (entity instanceof EntityLiving))
        {
            itemstack.func_1100_b((EntityLiving)entity);
            if(itemstack.field_1615_a <= 0)
            {
                itemstack.func_1097_a(this);
                func_448_u();
            }
        }
    }

    public ItemStack func_6416_v()
    {
        return field_778_b.func_494_a();
    }

    public void func_448_u()
    {
        field_778_b.func_472_a(field_778_b.field_847_d, null);
    }

    public double func_388_v()
    {
        return (double)(field_9292_aO - 0.5F);
    }

    public void func_457_w()
    {
        if(!field_9369_j || field_9368_k >= func_35202_aE() / 2 || field_9368_k < 0)
        {
            field_9368_k = -1;
            field_9369_j = true;
        }
    }

    public void func_463_a(Entity entity)
    {
        int i = field_778_b.func_502_a(entity);
        if(func_35160_a(Potion.field_35673_g))
        {
            i += 3 << func_35167_b(Potion.field_35673_g).func_35801_c();
        }
        if(func_35160_a(Potion.field_35690_t))
        {
            i -= 2 << func_35167_b(Potion.field_35690_t).func_35801_c();
        }
        int j = 0;
        int k = 0;
        if(entity instanceof EntityLiving)
        {
            k = EnchantmentHelper.func_40630_a(field_778_b, (EntityLiving)entity);
            j += EnchantmentHelper.func_40645_b(field_778_b, (EntityLiving)entity);
        }
        if(func_35117_Q())
        {
            j++;
        }
        if(i > 0 || k > 0)
        {
            boolean flag = field_9288_aU > 0.0F && !field_9298_aH && !func_429_A() && !func_27013_ag() && !func_35160_a(Potion.field_35693_q) && field_616_af == null && (entity instanceof EntityLiving);
            if(flag)
            {
                i += field_9312_bd.nextInt(i / 2 + 2);
            }
            i += k;
            boolean flag1 = entity.func_396_a(DamageSource.func_35527_a(this), i);
            if(flag1)
            {
                if(j > 0)
                {
                    entity.func_348_f(-MathHelper.func_1106_a((field_605_aq * 3.141593F) / 180F) * (float)j * 0.5F, 0.10000000000000001D, MathHelper.func_1114_b((field_605_aq * 3.141593F) / 180F) * (float)j * 0.5F);
                    field_608_an *= 0.59999999999999998D;
                    field_606_ap *= 0.59999999999999998D;
                    func_35113_c(false);
                }
                if(flag)
                {
                    func_35200_b(entity);
                }
                if(k > 0)
                {
                    func_40183_c(entity);
                }
                if(i >= 18)
                {
                    func_27026_a(AchievementList.field_40459_E);
                }
            }
            ItemStack itemstack = func_6416_v();
            if(itemstack != null && (entity instanceof EntityLiving))
            {
                itemstack.func_1092_a((EntityLiving)entity, this);
                if(itemstack.field_1615_a <= 0)
                {
                    itemstack.func_1097_a(this);
                    func_448_u();
                }
            }
            if(entity instanceof EntityLiving)
            {
                if(entity.func_354_B())
                {
                    func_25055_a((EntityLiving)entity, true);
                }
                func_25058_a(StatList.field_25167_s, i);
                int l = EnchantmentHelper.func_40631_c(field_778_b, (EntityLiving)entity);
                if(l > 0)
                {
                    entity.func_40046_d(l * 4);
                }
            }
            func_35198_d(0.3F);
        }
    }

    public void func_35200_b(Entity entity)
    {
    }

    public void func_40183_c(Entity entity)
    {
    }

    public void func_9367_r()
    {
    }

    public abstract void func_6420_o();

    public void func_20058_b(ItemStack itemstack)
    {
    }

    public void func_395_F()
    {
        super.func_395_F();
        field_20069_g.func_1104_a(this);
        if(field_20068_h != null)
        {
            field_20068_h.func_1104_a(this);
        }
    }

    public boolean func_345_I()
    {
        return !field_21901_a && super.func_345_I();
    }

    public EnumStatus func_22053_b(int i, int j, int k)
    {
        if(!field_615_ag.field_1026_y)
        {
            if(func_22051_K() || !func_354_B())
            {
                return EnumStatus.OTHER_PROBLEM;
            }
            if(field_615_ag.field_4209_q.field_4220_c)
            {
                return EnumStatus.NOT_POSSIBLE_HERE;
            }
            if(field_615_ag.func_624_b())
            {
                return EnumStatus.NOT_POSSIBLE_NOW;
            }
            if(Math.abs(field_611_ak - (double)i) > 3D || Math.abs(field_610_al - (double)j) > 2D || Math.abs(field_609_am - (double)k) > 3D)
            {
                return EnumStatus.TOO_FAR_AWAY;
            }
            double d = 8D;
            double d1 = 5D;
            List list = field_615_ag.func_657_a(net.minecraft.src.EntityMob.class, AxisAlignedBB.func_1161_b((double)i - d, (double)j - d1, (double)k - d, (double)i + d, (double)j + d1, (double)k + d));
            if(!list.isEmpty())
            {
                return EnumStatus.NOT_SAFE;
            }
        }
        func_371_a(0.2F, 0.2F);
        field_9292_aO = 0.2F;
        if(field_615_ag.func_630_d(i, j, k))
        {
            int l = field_615_ag.func_602_e(i, j, k);
            int i1 = BlockBed.func_22030_c(l);
            float f = 0.5F;
            float f1 = 0.5F;
            switch(i1)
            {
            case 0: // '\0'
                f1 = 0.9F;
                break;

            case 2: // '\002'
                f1 = 0.1F;
                break;

            case 1: // '\001'
                f = 0.1F;
                break;

            case 3: // '\003'
                f = 0.9F;
                break;
            }
            func_22052_e(i1);
            func_347_a((float)i + f, (float)j + 0.9375F, (float)k + f1);
        } else
        {
            func_347_a((float)i + 0.5F, (float)j + 0.9375F, (float)k + 0.5F);
        }
        field_21901_a = true;
        field_21907_c = 0;
        field_21908_b = new ChunkCoordinates(i, j, k);
        field_608_an = field_606_ap = field_607_ao = 0.0D;
        if(!field_615_ag.field_1026_y)
        {
            field_615_ag.func_22140_w();
        }
        return EnumStatus.OK;
    }

    private void func_22052_e(int i)
    {
        field_22063_x = 0.0F;
        field_22061_z = 0.0F;
        switch(i)
        {
        case 0: // '\0'
            field_22061_z = -1.8F;
            break;

        case 2: // '\002'
            field_22061_z = 1.8F;
            break;

        case 1: // '\001'
            field_22063_x = 1.8F;
            break;

        case 3: // '\003'
            field_22063_x = -1.8F;
            break;
        }
    }

    public void func_22056_a(boolean flag, boolean flag1, boolean flag2)
    {
        func_371_a(0.6F, 1.8F);
        func_22058_C();
        ChunkCoordinates chunkcoordinates = field_21908_b;
        ChunkCoordinates chunkcoordinates1 = field_21908_b;
        if(chunkcoordinates != null && field_615_ag.func_600_a(chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b, chunkcoordinates.field_22396_c) == Block.field_9262_S.field_376_bc)
        {
            BlockBed.func_22031_a(field_615_ag, chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b, chunkcoordinates.field_22396_c, false);
            ChunkCoordinates chunkcoordinates2 = BlockBed.func_22028_g(field_615_ag, chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b, chunkcoordinates.field_22396_c, 0);
            if(chunkcoordinates2 == null)
            {
                chunkcoordinates2 = new ChunkCoordinates(chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b + 1, chunkcoordinates.field_22396_c);
            }
            func_347_a((float)chunkcoordinates2.field_22395_a + 0.5F, (float)chunkcoordinates2.field_22394_b + field_9292_aO + 0.1F, (float)chunkcoordinates2.field_22396_c + 0.5F);
        }
        field_21901_a = false;
        if(!field_615_ag.field_1026_y && flag1)
        {
            field_615_ag.func_22140_w();
        }
        if(flag)
        {
            field_21907_c = 0;
        } else
        {
            field_21907_c = 100;
        }
        if(flag2)
        {
            func_25061_a(field_21908_b);
        }
    }

    private boolean func_22057_q()
    {
        return field_615_ag.func_600_a(field_21908_b.field_22395_a, field_21908_b.field_22394_b, field_21908_b.field_22396_c) == Block.field_9262_S.field_376_bc;
    }

    public static ChunkCoordinates func_25060_a(World world, ChunkCoordinates chunkcoordinates)
    {
        IChunkProvider ichunkprovider = world.func_21118_q();
        ichunkprovider.func_538_d(chunkcoordinates.field_22395_a - 3 >> 4, chunkcoordinates.field_22396_c - 3 >> 4);
        ichunkprovider.func_538_d(chunkcoordinates.field_22395_a + 3 >> 4, chunkcoordinates.field_22396_c - 3 >> 4);
        ichunkprovider.func_538_d(chunkcoordinates.field_22395_a - 3 >> 4, chunkcoordinates.field_22396_c + 3 >> 4);
        ichunkprovider.func_538_d(chunkcoordinates.field_22395_a + 3 >> 4, chunkcoordinates.field_22396_c + 3 >> 4);
        if(world.func_600_a(chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b, chunkcoordinates.field_22396_c) != Block.field_9262_S.field_376_bc)
        {
            return null;
        } else
        {
            ChunkCoordinates chunkcoordinates1 = BlockBed.func_22028_g(world, chunkcoordinates.field_22395_a, chunkcoordinates.field_22394_b, chunkcoordinates.field_22396_c, 0);
            return chunkcoordinates1;
        }
    }

    public float func_22059_J()
    {
        if(field_21908_b != null)
        {
            int i = field_615_ag.func_602_e(field_21908_b.field_22395_a, field_21908_b.field_22394_b, field_21908_b.field_22396_c);
            int j = BlockBed.func_22030_c(i);
            switch(j)
            {
            case 0: // '\0'
                return 90F;

            case 1: // '\001'
                return 0.0F;

            case 2: // '\002'
                return 270F;

            case 3: // '\003'
                return 180F;
            }
        }
        return 0.0F;
    }

    public boolean func_22051_K()
    {
        return field_21901_a;
    }

    public boolean func_22054_L()
    {
        return field_21901_a && field_21907_c >= 100;
    }

    public int func_22060_M()
    {
        return field_21907_c;
    }

    public void func_22055_b(String s)
    {
    }

    public ChunkCoordinates func_25059_P()
    {
        return field_24900_bi;
    }

    public void func_25061_a(ChunkCoordinates chunkcoordinates)
    {
        if(chunkcoordinates != null)
        {
            field_24900_bi = new ChunkCoordinates(chunkcoordinates);
        } else
        {
            field_24900_bi = null;
        }
    }

    public void func_27026_a(StatBase statbase)
    {
        func_25058_a(statbase, 1);
    }

    public void func_25058_a(StatBase statbase, int i)
    {
    }

    protected void func_424_C()
    {
        super.func_424_C();
        func_25058_a(StatList.field_25171_q, 1);
        if(func_35117_Q())
        {
            func_35198_d(0.8F);
        } else
        {
            func_35198_d(0.2F);
        }
    }

    public void func_435_b(float f, float f1)
    {
        double d = field_611_ak;
        double d1 = field_610_al;
        double d2 = field_609_am;
        if(field_35212_aW.field_35757_b)
        {
            double d3 = field_607_ao;
            float f2 = field_35168_bw;
            field_35168_bw = 0.05F;
            super.func_435_b(f, f1);
            field_607_ao = d3 * 0.59999999999999998D;
            field_35168_bw = f2;
        } else
        {
            super.func_435_b(f, f1);
        }
        func_25056_h(field_611_ak - d, field_610_al - d1, field_609_am - d2);
    }

    public void func_25056_h(double d, double d1, double d2)
    {
        if(field_616_af != null)
        {
            return;
        }
        if(func_393_a(Material.field_1332_f))
        {
            int i = Math.round(MathHelper.func_1109_a(d * d + d1 * d1 + d2 * d2) * 100F);
            if(i > 0)
            {
                func_25058_a(StatList.field_25173_p, i);
                func_35198_d(0.015F * (float)i * 0.01F);
            }
        } else
        if(func_27013_ag())
        {
            int j = Math.round(MathHelper.func_1109_a(d * d + d2 * d2) * 100F);
            if(j > 0)
            {
                func_25058_a(StatList.field_25177_l, j);
                func_35198_d(0.015F * (float)j * 0.01F);
            }
        } else
        if(func_429_A())
        {
            if(d1 > 0.0D)
            {
                func_25058_a(StatList.field_25175_n, (int)Math.round(d1 * 100D));
            }
        } else
        if(field_9298_aH)
        {
            int k = Math.round(MathHelper.func_1109_a(d * d + d2 * d2) * 100F);
            if(k > 0)
            {
                func_25058_a(StatList.field_25178_k, k);
                if(func_35117_Q())
                {
                    func_35198_d(0.09999999F * (float)k * 0.01F);
                } else
                {
                    func_35198_d(0.01F * (float)k * 0.01F);
                }
            }
        } else
        {
            int l = Math.round(MathHelper.func_1109_a(d * d + d2 * d2) * 100F);
            if(l > 25)
            {
                func_25058_a(StatList.field_25174_o, l);
            }
        }
    }

    private void func_27024_i(double d, double d1, double d2)
    {
        if(field_616_af != null)
        {
            int i = Math.round(MathHelper.func_1109_a(d * d + d1 * d1 + d2 * d2) * 100F);
            if(i > 0)
            {
                if(field_616_af instanceof EntityMinecart)
                {
                    func_25058_a(StatList.field_27364_r, i);
                    if(field_26907_d == null)
                    {
                        field_26907_d = new ChunkCoordinates(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_610_al), MathHelper.func_1108_b(field_609_am));
                    } else
                    if(field_26907_d.func_27439_a(MathHelper.func_1108_b(field_611_ak), MathHelper.func_1108_b(field_610_al), MathHelper.func_1108_b(field_609_am)) >= 1000D)
                    {
                        func_25058_a(AchievementList.field_27379_q, 1);
                    }
                } else
                if(field_616_af instanceof EntityBoat)
                {
                    func_25058_a(StatList.field_27363_s, i);
                } else
                if(field_616_af instanceof EntityPig)
                {
                    func_25058_a(StatList.field_27362_t, i);
                }
            }
        }
    }

    protected void func_400_c(float f)
    {
        if(field_35212_aW.field_35758_c)
        {
            return;
        }
        if(f >= 2.0F)
        {
            func_25058_a(StatList.field_25176_m, (int)Math.round((double)f * 100D));
        }
        super.func_400_c(f);
    }

    public void func_27015_a(EntityLiving entityliving)
    {
        if(entityliving instanceof EntityMob)
        {
            func_27026_a(AchievementList.field_27377_s);
        }
    }

    public int func_28021_c(ItemStack itemstack, int i)
    {
        int j = super.func_28021_c(itemstack, i);
        if(itemstack.field_1617_c == Item.field_4024_aP.field_291_aS && field_4128_n != null)
        {
            j = itemstack.func_1088_b() + 16;
        } else
        {
            if(itemstack.func_1091_a().func_46058_c())
            {
                return itemstack.func_1091_a().func_46057_a(itemstack.func_21181_i(), i);
            }
            if(field_34907_d != null && itemstack.field_1617_c == Item.field_227_i.field_291_aS)
            {
                int k = itemstack.func_35866_m() - field_34906_e;
                if(k >= 18)
                {
                    return 133;
                }
                if(k > 13)
                {
                    return 117;
                }
                if(k > 0)
                {
                    return 101;
                }
            }
        }
        return j;
    }

    public void func_4039_q()
    {
        if(field_28024_y > 0)
        {
            field_28024_y = 10;
            return;
        } else
        {
            field_28023_z = true;
            return;
        }
    }

    public void func_35204_c(int i)
    {
        field_9370_g += i;
        int j = 0x7fffffff - field_35209_aZ;
        if(i > j)
        {
            i = j;
        }
        field_35211_aX += (float)i / (float)func_35193_as();
        field_35209_aZ += i;
        for(; field_35211_aX >= 1.0F; field_35211_aX = field_35211_aX / (float)func_35193_as())
        {
            field_35211_aX = (field_35211_aX - 1.0F) * (float)func_35193_as();
            func_35203_aG();
        }

    }

    public void func_40184_i(int i)
    {
        field_35210_aY -= i;
        if(field_35210_aY < 0)
        {
            field_35210_aY = 0;
        }
    }

    public int func_35193_as()
    {
        return 7 + (field_35210_aY * 7 >> 1);
    }

    private void func_35203_aG()
    {
        field_35210_aY++;
    }

    public void func_35198_d(float f)
    {
        if(field_35212_aW.field_35759_a)
        {
            return;
        }
        if(!field_615_ag.field_1026_y)
        {
            field_35217_av.func_35762_a(f);
        }
    }

    public FoodStats func_35191_at()
    {
        return field_35217_av;
    }

    public boolean func_35197_b(boolean flag)
    {
        return (flag || field_35217_av.func_35770_c()) && !field_35212_aW.field_35759_a;
    }

    public boolean func_35194_au()
    {
        return func_40114_aH() > 0 && func_40114_aH() < func_40117_c();
    }

    public void func_35199_b(ItemStack itemstack, int i)
    {
        if(itemstack == field_34907_d)
        {
            return;
        }
        field_34907_d = itemstack;
        field_34906_e = i;
        if(!field_615_ag.field_1026_y)
        {
            func_35116_d(true);
        }
    }

    public boolean func_35190_e(int i, int j, int k)
    {
        return true;
    }

    protected int func_36001_a(EntityPlayer entityplayer)
    {
        int i = field_35210_aY * 7;
        if(i > 100)
        {
            return 100;
        } else
        {
            return i;
        }
    }

    protected boolean func_35163_av()
    {
        return true;
    }

    public void func_40182_b(int i)
    {
    }

    public void func_41014_d(EntityPlayer entityplayer)
    {
        field_778_b.func_41022_a(entityplayer.field_778_b);
        field_9337_J = entityplayer.field_9337_J;
        field_35217_av = entityplayer.field_35217_av;
        field_35210_aY = entityplayer.field_35210_aY;
        field_35209_aZ = entityplayer.field_35209_aZ;
        field_35211_aX = entityplayer.field_35211_aX;
        field_9370_g = entityplayer.field_9370_g;
    }
}
