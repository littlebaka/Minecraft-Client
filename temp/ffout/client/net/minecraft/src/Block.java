// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Material, IBlockAccess, AxisAlignedBB, EntityPlayer, 
//            World, ItemStack, EntityItem, Vec3D, 
//            MovingObjectPosition, StatList, EnchantmentHelper, Item, 
//            StatCollector, StepSound, StepSoundStone, StepSoundSand, 
//            BlockStone, BlockGrass, BlockDirt, BlockSapling, 
//            BlockFlowing, BlockStationary, BlockSand, BlockGravel, 
//            BlockOre, BlockLog, BlockLeaves, BlockSponge, 
//            BlockGlass, BlockDispenser, BlockSandStone, BlockNote, 
//            BlockBed, BlockRail, BlockDetectorRail, BlockPistonBase, 
//            BlockWeb, BlockTallGrass, BlockDeadBush, BlockPistonExtension, 
//            BlockCloth, BlockPistonMoving, BlockFlower, BlockMushroom, 
//            BlockOreStorage, BlockStep, BlockTNT, BlockBookshelf, 
//            BlockObsidian, BlockTorch, BlockFire, BlockMobSpawner, 
//            BlockStairs, BlockChest, BlockRedstoneWire, BlockWorkbench, 
//            BlockCrops, BlockFarmland, BlockFurnace, BlockSign, 
//            TileEntitySign, BlockDoor, BlockLadder, BlockLever, 
//            BlockPressurePlate, EnumMobType, BlockRedstoneOre, BlockRedstoneTorch, 
//            BlockButton, BlockSnow, BlockIce, BlockSnowBlock, 
//            BlockCactus, BlockClay, BlockReed, BlockJukeBox, 
//            BlockFence, BlockPumpkin, BlockNetherrack, BlockSoulSand, 
//            BlockGlowStone, BlockPortal, BlockCake, BlockRedstoneRepeater, 
//            BlockLockedChest, BlockTrapDoor, BlockSilverfish, BlockStoneBrick, 
//            BlockMushroomCap, BlockPane, BlockMelon, BlockStem, 
//            BlockVine, BlockFenceGate, BlockMycelium, BlockLilyPad, 
//            BlockNetherStalk, BlockEnchantmentTable, BlockBrewingStand, BlockCauldron, 
//            BlockEndPortal, BlockEndPortalFrame, BlockDragonEgg, ItemCloth, 
//            ItemMetadata, ItemSlab, ItemSapling, ItemLeaves, 
//            ItemColored, ItemLilyPad, ItemPiston, ItemBlock, 
//            Entity, EntityLiving

public class Block
{

    public static final StepSound field_354_e;
    public static final StepSound field_9254_e;
    public static final StepSound field_9253_f;
    public static final StepSound field_9252_g;
    public static final StepSound field_9251_h;
    public static final StepSound field_9250_i;
    public static final StepSound field_9249_j;
    public static final StepSound field_9248_k;
    public static final StepSound field_9247_l;
    public static final Block field_345_n[];
    public static final boolean field_344_o[] = new boolean[256];
    public static final boolean field_343_p[] = new boolean[256];
    public static final boolean field_342_q[] = new boolean[256];
    public static final int field_341_r[] = new int[256];
    public static final boolean field_340_s[];
    public static final int field_339_t[] = new int[256];
    public static final boolean field_28032_t[] = new boolean[256];
    public static boolean field_40201_bL[];
    public static final Block field_338_u;
    public static final BlockGrass field_337_v;
    public static final Block field_336_w;
    public static final Block field_335_x;
    public static final Block field_334_y;
    public static final Block field_333_z;
    public static final Block field_403_A;
    public static final Block field_401_B;
    public static final Block field_399_C;
    public static final Block field_397_D;
    public static final Block field_395_E;
    public static final Block field_393_F;
    public static final Block field_392_G;
    public static final Block field_390_H;
    public static final Block field_388_I;
    public static final Block field_386_J;
    public static final Block field_385_K;
    public static final BlockLeaves field_384_L;
    public static final Block field_383_M;
    public static final Block field_382_N;
    public static final Block field_9267_N;
    public static final Block field_9266_O;
    public static final Block field_9265_P;
    public static final Block field_9264_Q;
    public static final Block field_9263_R = (new BlockNote(25)).func_222_c(0.8F).func_20012_a("musicBlock").func_28031_n();
    public static final Block field_9262_S = (new BlockBed(26)).func_222_c(0.2F).func_20012_a("bed").func_27032_l().func_28031_n();
    public static final Block field_9261_T;
    public static final Block field_9260_U;
    public static final Block field_9259_V;
    public static final Block field_9258_W = (new BlockWeb(30, 11)).func_256_d(1).func_222_c(4F).func_20012_a("web");
    public static final BlockTallGrass field_9257_X;
    public static final BlockDeadBush field_9256_Y;
    public static final Block field_9255_Z;
    public static final BlockPistonExtension field_9269_aa = (BlockPistonExtension)(new BlockPistonExtension(34, 107)).func_28031_n();
    public static final Block field_419_ac;
    public static final BlockPistonMoving field_9268_ac = new BlockPistonMoving(36);
    public static final BlockFlower field_417_ae;
    public static final BlockFlower field_416_af;
    public static final BlockFlower field_415_ag;
    public static final BlockFlower field_414_ah;
    public static final Block field_413_ai;
    public static final Block field_412_aj;
    public static final Block field_411_ak;
    public static final Block field_410_al;
    public static final Block field_409_am;
    public static final Block field_408_an;
    public static final Block field_407_ao;
    public static final Block field_406_ap;
    public static final Block field_405_aq;
    public static final Block field_404_ar;
    public static final BlockFire field_402_as;
    public static final Block field_400_at;
    public static final Block field_4059_au;
    public static final Block field_396_av;
    public static final Block field_394_aw;
    public static final Block field_391_ax;
    public static final Block field_389_ay;
    public static final Block field_387_az;
    public static final Block field_447_aA;
    public static final Block field_446_aB;
    public static final Block field_445_aC;
    public static final Block field_444_aD;
    public static final Block field_443_aE;
    public static final Block field_442_aF;
    public static final Block field_441_aG;
    public static final Block field_440_aH;
    public static final Block field_4069_aI;
    public static final Block field_4068_aJ;
    public static final Block field_4067_aK;
    public static final Block field_4066_aL;
    public static final Block field_435_aM;
    public static final Block field_4065_aN;
    public static final Block field_433_aO;
    public static final Block field_432_aP;
    public static final Block field_431_aQ;
    public static final Block field_430_aR;
    public static final Block field_4064_aS;
    public static final Block field_428_aT;
    public static final Block field_4063_aU;
    public static final Block field_426_aV;
    public static final Block field_425_aW;
    public static final Block field_424_aX;
    public static final Block field_423_aY;
    public static final Block field_422_aZ;
    public static final Block field_4057_ba;
    public static final Block field_4055_bb;
    public static final Block field_4053_bc;
    public static final Block field_4051_bd;
    public static final Block field_4049_be;
    public static final BlockPortal field_4047_bf;
    public static final Block field_4045_bg;
    public static final Block field_21026_bg;
    public static final Block field_22021_bh;
    public static final Block field_22020_bi;
    public static final Block field_25017_bj;
    public static final Block field_28033_bl;
    public static final Block field_35289_bm = (new BlockSilverfish(97)).func_222_c(0.75F);
    public static final Block field_35285_bn;
    public static final Block field_35286_bo;
    public static final Block field_35287_bp;
    public static final Block field_35288_bq;
    public static final Block field_35282_br;
    public static final Block field_35281_bs;
    public static final Block field_35284_bt;
    public static final Block field_35283_bu;
    public static final Block field_35278_bv;
    public static final Block field_35277_bw;
    public static final Block field_35280_bx;
    public static final Block field_35279_by;
    public static final BlockMycelium field_40199_bz;
    public static final Block field_40200_bA;
    public static final Block field_40206_bB;
    public static final Block field_40207_bC;
    public static final Block field_40204_bD;
    public static final Block field_40205_bE = (new BlockNetherStalk(115)).func_20012_a("netherStalk").func_28031_n();
    public static final Block field_40210_bF = (new BlockEnchantmentTable(116)).func_222_c(5F).func_219_b(2000F).func_20012_a("enchantmentTable");
    public static final Block field_40211_bG = (new BlockBrewingStand(117)).func_222_c(0.5F).func_215_a(0.125F).func_20012_a("brewingStand").func_28031_n();
    public static final Block field_40208_bH = (new BlockCauldron(118)).func_222_c(2.0F).func_20012_a("cauldron").func_28031_n();
    public static final Block field_40209_bI;
    public static final Block field_40202_bJ;
    public static final Block field_40203_bK;
    public static final Block field_41050_bK;
    public int field_378_bb;
    public final int field_376_bc;
    protected float field_374_bd;
    protected float field_372_be;
    protected boolean field_27035_bo;
    protected boolean field_27034_bp;
    public double field_370_bf;
    public double field_368_bg;
    public double field_366_bh;
    public double field_364_bi;
    public double field_362_bj;
    public double field_360_bk;
    public StepSound field_358_bl;
    public float field_357_bm;
    public final Material field_356_bn;
    public float field_355_bo;
    private String field_469_a;

    protected Block(int i, Material material)
    {
        field_27035_bo = true;
        field_27034_bp = true;
        field_358_bl = field_354_e;
        field_357_bm = 1.0F;
        field_355_bo = 0.6F;
        if(field_345_n[i] != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Slot ").append(i).append(" is already occupied by ").append(field_345_n[i]).append(" when adding ").append(this).toString());
        } else
        {
            field_356_bn = material;
            field_345_n[i] = this;
            field_376_bc = i;
            func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            field_343_p[i] = func_217_b();
            field_341_r[i] = func_217_b() ? 255 : 0;
            field_340_s[i] = !material.func_881_b();
            field_342_q[i] = false;
            return;
        }
    }

    protected Block func_28031_n()
    {
        field_28032_t[field_376_bc] = true;
        return this;
    }

    protected void func_28028_i()
    {
    }

    protected Block(int i, int j, Material material)
    {
        this(i, material);
        field_378_bb = j;
    }

    protected Block func_4024_a(StepSound stepsound)
    {
        field_358_bl = stepsound;
        return this;
    }

    protected Block func_256_d(int i)
    {
        field_341_r[field_376_bc] = i;
        return this;
    }

    protected Block func_215_a(float f)
    {
        field_339_t[field_376_bc] = (int)(15F * f);
        return this;
    }

    protected Block func_219_b(float f)
    {
        field_372_be = f * 3F;
        return this;
    }

    public boolean func_242_c()
    {
        return true;
    }

    public int func_210_f()
    {
        return 0;
    }

    protected Block func_222_c(float f)
    {
        field_374_bd = f;
        if(field_372_be < f * 5F)
        {
            field_372_be = f * 5F;
        }
        return this;
    }

    protected Block func_31028_l()
    {
        func_222_c(-1F);
        return this;
    }

    public float func_31031_m()
    {
        return field_374_bd;
    }

    protected Block func_253_b(boolean flag)
    {
        field_344_o[field_376_bc] = flag;
        return this;
    }

    public void func_213_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        field_370_bf = f;
        field_368_bg = f1;
        field_366_bh = f2;
        field_364_bi = f3;
        field_362_bj = f4;
        field_360_bk = f5;
    }

    public float func_241_c(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return iblockaccess.func_28099_a(i, j, k, field_339_t[field_376_bc]);
    }

    public int func_35275_c(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return iblockaccess.func_35451_b(i, j, k, field_339_t[field_376_bc]);
    }

    public boolean func_260_c(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 0 && field_368_bg > 0.0D)
        {
            return true;
        }
        if(l == 1 && field_362_bj < 1.0D)
        {
            return true;
        }
        if(l == 2 && field_366_bh > 0.0D)
        {
            return true;
        }
        if(l == 3 && field_360_bk < 1.0D)
        {
            return true;
        }
        if(l == 4 && field_370_bf > 0.0D)
        {
            return true;
        }
        if(l == 5 && field_364_bi < 1.0D)
        {
            return true;
        } else
        {
            return !iblockaccess.func_601_g(i, j, k);
        }
    }

    public boolean func_28029_d(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return iblockaccess.func_599_f(i, j, k).func_878_a();
    }

    public int func_211_a(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return func_232_a(l, iblockaccess.func_602_e(i, j, k));
    }

    public int func_232_a(int i, int j)
    {
        return func_218_a(i);
    }

    public int func_218_a(int i)
    {
        return field_378_bb;
    }

    public AxisAlignedBB func_246_f(World world, int i, int j, int k)
    {
        return AxisAlignedBB.func_1161_b((double)i + field_370_bf, (double)j + field_368_bg, (double)k + field_366_bh, (double)i + field_364_bi, (double)j + field_362_bj, (double)k + field_360_bk);
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        AxisAlignedBB axisalignedbb1 = func_221_d(world, i, j, k);
        if(axisalignedbb1 != null && axisalignedbb.func_1178_a(axisalignedbb1))
        {
            arraylist.add(axisalignedbb1);
        }
    }

    public AxisAlignedBB func_221_d(World world, int i, int j, int k)
    {
        return AxisAlignedBB.func_1161_b((double)i + field_370_bf, (double)j + field_368_bg, (double)k + field_366_bh, (double)i + field_364_bi, (double)j + field_362_bj, (double)k + field_360_bk);
    }

    public boolean func_217_b()
    {
        return true;
    }

    public boolean func_224_a(int i, boolean flag)
    {
        return func_245_h();
    }

    public boolean func_245_h()
    {
        return true;
    }

    public void func_208_a(World world, int i, int j, int k, Random random)
    {
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
    }

    public void func_252_b(World world, int i, int j, int k, int l)
    {
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
    }

    public int func_4025_d()
    {
        return 10;
    }

    public void func_235_e(World world, int i, int j, int k)
    {
    }

    public void func_214_b(World world, int i, int j, int k)
    {
    }

    public int func_229_a(Random random)
    {
        return 1;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return field_376_bc;
    }

    public float func_225_a(EntityPlayer entityplayer)
    {
        if(field_374_bd < 0.0F)
        {
            return 0.0F;
        }
        if(!entityplayer.func_454_b(this))
        {
            return 1.0F / field_374_bd / 100F;
        } else
        {
            return entityplayer.func_450_a(this) / field_374_bd / 30F;
        }
    }

    public final void func_259_b_(World world, int i, int j, int k, int l, int i1)
    {
        func_216_a(world, i, j, k, l, 1.0F, i1);
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        if(world.field_1026_y)
        {
            return;
        }
        int j1 = func_40198_a(i1, world.field_1037_n);
        for(int k1 = 0; k1 < j1; k1++)
        {
            if(world.field_1037_n.nextFloat() > f)
            {
                continue;
            }
            int l1 = func_240_a(l, world.field_1037_n, i1);
            if(l1 > 0)
            {
                func_31027_a(world, i, j, k, new ItemStack(l1, 1, func_21025_b(l)));
            }
        }

    }

    protected void func_31027_a(World world, int i, int j, int k, ItemStack itemstack)
    {
        if(world.field_1026_y)
        {
            return;
        } else
        {
            float f = 0.7F;
            double d = (double)(world.field_1037_n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(world.field_1037_n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(world.field_1037_n.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, itemstack);
            entityitem.field_805_c = 10;
            world.func_674_a(entityitem);
            return;
        }
    }

    protected int func_21025_b(int i)
    {
        return 0;
    }

    public float func_227_a(Entity entity)
    {
        return field_372_be / 5F;
    }

    public MovingObjectPosition func_255_a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        func_238_a(world, i, j, k);
        vec3d = vec3d.func_1257_c(-i, -j, -k);
        vec3d1 = vec3d1.func_1257_c(-i, -j, -k);
        Vec3D vec3d2 = vec3d.func_1247_a(vec3d1, field_370_bf);
        Vec3D vec3d3 = vec3d.func_1247_a(vec3d1, field_364_bi);
        Vec3D vec3d4 = vec3d.func_1250_b(vec3d1, field_368_bg);
        Vec3D vec3d5 = vec3d.func_1250_b(vec3d1, field_362_bj);
        Vec3D vec3d6 = vec3d.func_1256_c(vec3d1, field_366_bh);
        Vec3D vec3d7 = vec3d.func_1256_c(vec3d1, field_360_bk);
        if(!func_244_a(vec3d2))
        {
            vec3d2 = null;
        }
        if(!func_244_a(vec3d3))
        {
            vec3d3 = null;
        }
        if(!func_249_b(vec3d4))
        {
            vec3d4 = null;
        }
        if(!func_249_b(vec3d5))
        {
            vec3d5 = null;
        }
        if(!func_251_c(vec3d6))
        {
            vec3d6 = null;
        }
        if(!func_251_c(vec3d7))
        {
            vec3d7 = null;
        }
        Vec3D vec3d8 = null;
        if(vec3d2 != null && (vec3d8 == null || vec3d.func_1251_c(vec3d2) < vec3d.func_1251_c(vec3d8)))
        {
            vec3d8 = vec3d2;
        }
        if(vec3d3 != null && (vec3d8 == null || vec3d.func_1251_c(vec3d3) < vec3d.func_1251_c(vec3d8)))
        {
            vec3d8 = vec3d3;
        }
        if(vec3d4 != null && (vec3d8 == null || vec3d.func_1251_c(vec3d4) < vec3d.func_1251_c(vec3d8)))
        {
            vec3d8 = vec3d4;
        }
        if(vec3d5 != null && (vec3d8 == null || vec3d.func_1251_c(vec3d5) < vec3d.func_1251_c(vec3d8)))
        {
            vec3d8 = vec3d5;
        }
        if(vec3d6 != null && (vec3d8 == null || vec3d.func_1251_c(vec3d6) < vec3d.func_1251_c(vec3d8)))
        {
            vec3d8 = vec3d6;
        }
        if(vec3d7 != null && (vec3d8 == null || vec3d.func_1251_c(vec3d7) < vec3d.func_1251_c(vec3d8)))
        {
            vec3d8 = vec3d7;
        }
        if(vec3d8 == null)
        {
            return null;
        }
        byte byte0 = -1;
        if(vec3d8 == vec3d2)
        {
            byte0 = 4;
        }
        if(vec3d8 == vec3d3)
        {
            byte0 = 5;
        }
        if(vec3d8 == vec3d4)
        {
            byte0 = 0;
        }
        if(vec3d8 == vec3d5)
        {
            byte0 = 1;
        }
        if(vec3d8 == vec3d6)
        {
            byte0 = 2;
        }
        if(vec3d8 == vec3d7)
        {
            byte0 = 3;
        }
        return new MovingObjectPosition(i, j, k, byte0, vec3d8.func_1257_c(i, j, k));
    }

    private boolean func_244_a(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.field_1775_b >= field_368_bg && vec3d.field_1775_b <= field_362_bj && vec3d.field_1779_c >= field_366_bh && vec3d.field_1779_c <= field_360_bk;
        }
    }

    private boolean func_249_b(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.field_1776_a >= field_370_bf && vec3d.field_1776_a <= field_364_bi && vec3d.field_1779_c >= field_366_bh && vec3d.field_1779_c <= field_360_bk;
        }
    }

    private boolean func_251_c(Vec3D vec3d)
    {
        if(vec3d == null)
        {
            return false;
        } else
        {
            return vec3d.field_1776_a >= field_370_bf && vec3d.field_1776_a <= field_364_bi && vec3d.field_1775_b >= field_368_bg && vec3d.field_1775_b <= field_362_bj;
        }
    }

    public void func_4027_c(World world, int i, int j, int k)
    {
    }

    public int func_234_g()
    {
        return 0;
    }

    public boolean func_28030_e(World world, int i, int j, int k, int l)
    {
        return func_243_a(world, i, j, k);
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        int l = world.func_600_a(i, j, k);
        return l == 0 || field_345_n[l].field_356_bn.func_27283_g();
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return false;
    }

    public void func_254_a(World world, int i, int j, int k, Entity entity)
    {
    }

    public void func_258_d(World world, int i, int j, int k, int l)
    {
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    }

    public void func_257_a(World world, int i, int j, int k, Entity entity, Vec3D vec3d)
    {
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
    }

    public int func_35274_i()
    {
        return 0xffffff;
    }

    public int func_31030_b(int i)
    {
        return 0xffffff;
    }

    public int func_207_d(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return 0xffffff;
    }

    public boolean func_231_b(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;
    }

    public boolean func_209_d()
    {
        return false;
    }

    public void func_236_b(World world, int i, int j, int k, Entity entity)
    {
    }

    public boolean func_228_c(World world, int i, int j, int k, int l)
    {
        return false;
    }

    public void func_237_e()
    {
    }

    public void func_220_a_(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.func_25058_a(StatList.field_25159_y[field_376_bc], 1);
        entityplayer.func_35198_d(0.025F);
        if(func_242_c() && !field_342_q[field_376_bc] && EnchantmentHelper.func_40646_d(entityplayer.field_778_b))
        {
            ItemStack itemstack = func_41049_c_(l);
            if(itemstack != null)
            {
                func_31027_a(world, i, j, k, itemstack);
            }
        } else
        {
            int i1 = EnchantmentHelper.func_40638_e(entityplayer.field_778_b);
            func_259_b_(world, i, j, k, l, i1);
        }
    }

    protected ItemStack func_41049_c_(int i)
    {
        int j = 0;
        if(field_376_bc >= 0 && field_376_bc < Item.field_233_c.length && Item.field_233_c[field_376_bc].func_21010_e())
        {
            j = i;
        }
        return new ItemStack(field_376_bc, 1, j);
    }

    public int func_40198_a(int i, Random random)
    {
        return func_229_a(random);
    }

    public boolean func_223_g(World world, int i, int j, int k)
    {
        return true;
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
    }

    public Block func_20012_a(String s)
    {
        field_469_a = (new StringBuilder()).append("tile.").append(s).toString();
        return this;
    }

    public String func_25016_i()
    {
        return StatCollector.func_25200_a((new StringBuilder()).append(func_20013_i()).append(".name").toString());
    }

    public String func_20013_i()
    {
        return field_469_a;
    }

    public void func_21024_a(World world, int i, int j, int k, int l, int i1)
    {
    }

    public boolean func_27033_k()
    {
        return field_27034_bp;
    }

    protected Block func_27032_l()
    {
        field_27034_bp = false;
        return this;
    }

    public int func_31029_h()
    {
        return field_356_bn.func_31064_j();
    }

    public float func_35276_e(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return iblockaccess.func_28100_h(i, j, k) ? 0.2F : 1.0F;
    }

    public void func_43001_a(World world, int i, int j, int k, Entity entity, float f)
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        field_354_e = new StepSound("stone", 1.0F, 1.0F);
        field_9254_e = new StepSound("wood", 1.0F, 1.0F);
        field_9253_f = new StepSound("gravel", 1.0F, 1.0F);
        field_9252_g = new StepSound("grass", 1.0F, 1.0F);
        field_9251_h = new StepSound("stone", 1.0F, 1.0F);
        field_9250_i = new StepSound("stone", 1.0F, 1.5F);
        field_9249_j = new StepSoundStone("stone", 1.0F, 1.0F);
        field_9248_k = new StepSound("cloth", 1.0F, 1.0F);
        field_9247_l = new StepSoundSand("sand", 1.0F, 1.0F);
        field_345_n = new Block[256];
        field_340_s = new boolean[256];
        field_40201_bL = new boolean[256];
        field_338_u = (new BlockStone(1, 1)).func_222_c(1.5F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("stone");
        field_337_v = (BlockGrass)(new BlockGrass(2)).func_222_c(0.6F).func_4024_a(field_9252_g).func_20012_a("grass");
        field_336_w = (new BlockDirt(3, 2)).func_222_c(0.5F).func_4024_a(field_9253_f).func_20012_a("dirt");
        field_335_x = (new Block(4, 16, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("stonebrick");
        field_334_y = (new Block(5, 4, Material.field_1335_c)).func_222_c(2.0F).func_219_b(5F).func_4024_a(field_9254_e).func_20012_a("wood").func_28031_n();
        field_333_z = (new BlockSapling(6, 15)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("sapling").func_28031_n();
        field_403_A = (new Block(7, 17, Material.field_1334_d)).func_31028_l().func_219_b(6000000F).func_4024_a(field_9251_h).func_20012_a("bedrock").func_27032_l();
        field_401_B = (new BlockFlowing(8, Material.field_1332_f)).func_222_c(100F).func_256_d(3).func_20012_a("water").func_27032_l().func_28031_n();
        field_399_C = (new BlockStationary(9, Material.field_1332_f)).func_222_c(100F).func_256_d(3).func_20012_a("water").func_27032_l().func_28031_n();
        field_397_D = (new BlockFlowing(10, Material.field_1331_g)).func_222_c(0.0F).func_215_a(1.0F).func_256_d(255).func_20012_a("lava").func_27032_l().func_28031_n();
        field_395_E = (new BlockStationary(11, Material.field_1331_g)).func_222_c(100F).func_215_a(1.0F).func_256_d(255).func_20012_a("lava").func_27032_l().func_28031_n();
        field_393_F = (new BlockSand(12, 18)).func_222_c(0.5F).func_4024_a(field_9247_l).func_20012_a("sand");
        field_392_G = (new BlockGravel(13, 19)).func_222_c(0.6F).func_4024_a(field_9253_f).func_20012_a("gravel");
        field_390_H = (new BlockOre(14, 32)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreGold");
        field_388_I = (new BlockOre(15, 33)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreIron");
        field_386_J = (new BlockOre(16, 34)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreCoal");
        field_385_K = (new BlockLog(17)).func_222_c(2.0F).func_4024_a(field_9254_e).func_20012_a("log").func_28031_n();
        field_384_L = (BlockLeaves)(new BlockLeaves(18, 52)).func_222_c(0.2F).func_256_d(1).func_4024_a(field_9252_g).func_20012_a("leaves").func_28031_n();
        field_383_M = (new BlockSponge(19)).func_222_c(0.6F).func_4024_a(field_9252_g).func_20012_a("sponge");
        field_382_N = (new BlockGlass(20, 49, Material.field_4263_o, false)).func_222_c(0.3F).func_4024_a(field_9249_j).func_20012_a("glass");
        field_9267_N = (new BlockOre(21, 160)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreLapis");
        field_9266_O = (new Block(22, 144, Material.field_1334_d)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("blockLapis");
        field_9265_P = (new BlockDispenser(23)).func_222_c(3.5F).func_4024_a(field_9251_h).func_20012_a("dispenser").func_28031_n();
        field_9264_Q = (new BlockSandStone(24)).func_4024_a(field_9251_h).func_222_c(0.8F).func_20012_a("sandStone");
        field_9261_T = (new BlockRail(27, 179, true)).func_222_c(0.7F).func_4024_a(field_9250_i).func_20012_a("goldenRail").func_28031_n();
        field_9260_U = (new BlockDetectorRail(28, 195)).func_222_c(0.7F).func_4024_a(field_9250_i).func_20012_a("detectorRail").func_28031_n();
        field_9259_V = (new BlockPistonBase(29, 106, true)).func_20012_a("pistonStickyBase").func_28031_n();
        field_9257_X = (BlockTallGrass)(new BlockTallGrass(31, 39)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("tallgrass");
        field_9256_Y = (BlockDeadBush)(new BlockDeadBush(32, 55)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("deadbush");
        field_9255_Z = (new BlockPistonBase(33, 107, false)).func_20012_a("pistonBase").func_28031_n();
        field_419_ac = (new BlockCloth()).func_222_c(0.8F).func_4024_a(field_9248_k).func_20012_a("cloth").func_28031_n();
        field_417_ae = (BlockFlower)(new BlockFlower(37, 13)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("flower");
        field_416_af = (BlockFlower)(new BlockFlower(38, 12)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("rose");
        field_415_ag = (BlockFlower)(new BlockMushroom(39, 29)).func_222_c(0.0F).func_4024_a(field_9252_g).func_215_a(0.125F).func_20012_a("mushroom");
        field_414_ah = (BlockFlower)(new BlockMushroom(40, 28)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("mushroom");
        field_413_ai = (new BlockOreStorage(41, 23)).func_222_c(3F).func_219_b(10F).func_4024_a(field_9250_i).func_20012_a("blockGold");
        field_412_aj = (new BlockOreStorage(42, 22)).func_222_c(5F).func_219_b(10F).func_4024_a(field_9250_i).func_20012_a("blockIron");
        field_411_ak = (new BlockStep(43, true)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("stoneSlab");
        field_410_al = (new BlockStep(44, false)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("stoneSlab");
        field_409_am = (new Block(45, 7, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("brick");
        field_408_an = (new BlockTNT(46, 8)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("tnt");
        field_407_ao = (new BlockBookshelf(47, 35)).func_222_c(1.5F).func_4024_a(field_9254_e).func_20012_a("bookshelf");
        field_406_ap = (new Block(48, 36, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("stoneMoss");
        field_405_aq = (new BlockObsidian(49, 37)).func_222_c(50F).func_219_b(2000F).func_4024_a(field_9251_h).func_20012_a("obsidian");
        field_404_ar = (new BlockTorch(50, 80)).func_222_c(0.0F).func_215_a(0.9375F).func_4024_a(field_9254_e).func_20012_a("torch").func_28031_n();
        field_402_as = (BlockFire)(new BlockFire(51, 31)).func_222_c(0.0F).func_215_a(1.0F).func_4024_a(field_9254_e).func_20012_a("fire").func_27032_l();
        field_400_at = (new BlockMobSpawner(52, 65)).func_222_c(5F).func_4024_a(field_9250_i).func_20012_a("mobSpawner").func_27032_l();
        field_4059_au = (new BlockStairs(53, field_334_y)).func_20012_a("stairsWood").func_28031_n();
        field_396_av = (new BlockChest(54)).func_222_c(2.5F).func_4024_a(field_9254_e).func_20012_a("chest").func_28031_n();
        field_394_aw = (new BlockRedstoneWire(55, 164)).func_222_c(0.0F).func_4024_a(field_354_e).func_20012_a("redstoneDust").func_27032_l().func_28031_n();
        field_391_ax = (new BlockOre(56, 50)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreDiamond");
        field_389_ay = (new BlockOreStorage(57, 24)).func_222_c(5F).func_219_b(10F).func_4024_a(field_9250_i).func_20012_a("blockDiamond");
        field_387_az = (new BlockWorkbench(58)).func_222_c(2.5F).func_4024_a(field_9254_e).func_20012_a("workbench");
        field_447_aA = (new BlockCrops(59, 88)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("crops").func_27032_l().func_28031_n();
        field_446_aB = (new BlockFarmland(60)).func_222_c(0.6F).func_4024_a(field_9253_f).func_20012_a("farmland").func_28031_n();
        field_445_aC = (new BlockFurnace(61, false)).func_222_c(3.5F).func_4024_a(field_9251_h).func_20012_a("furnace").func_28031_n();
        field_444_aD = (new BlockFurnace(62, true)).func_222_c(3.5F).func_4024_a(field_9251_h).func_215_a(0.875F).func_20012_a("furnace").func_28031_n();
        field_443_aE = (new BlockSign(63, net.minecraft.src.TileEntitySign.class, true)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("sign").func_27032_l().func_28031_n();
        field_442_aF = (new BlockDoor(64, Material.field_1335_c)).func_222_c(3F).func_4024_a(field_9254_e).func_20012_a("doorWood").func_27032_l().func_28031_n();
        field_441_aG = (new BlockLadder(65, 83)).func_222_c(0.4F).func_4024_a(field_9254_e).func_20012_a("ladder").func_28031_n();
        field_440_aH = (new BlockRail(66, 128, false)).func_222_c(0.7F).func_4024_a(field_9250_i).func_20012_a("rail").func_28031_n();
        field_4069_aI = (new BlockStairs(67, field_335_x)).func_20012_a("stairsStone").func_28031_n();
        field_4068_aJ = (new BlockSign(68, net.minecraft.src.TileEntitySign.class, false)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("sign").func_27032_l().func_28031_n();
        field_4067_aK = (new BlockLever(69, 96)).func_222_c(0.5F).func_4024_a(field_9254_e).func_20012_a("lever").func_28031_n();
        field_4066_aL = (new BlockPressurePlate(70, field_338_u.field_378_bb, EnumMobType.mobs, Material.field_1334_d)).func_222_c(0.5F).func_4024_a(field_9251_h).func_20012_a("pressurePlate").func_28031_n();
        field_435_aM = (new BlockDoor(71, Material.field_1333_e)).func_222_c(5F).func_4024_a(field_9250_i).func_20012_a("doorIron").func_27032_l().func_28031_n();
        field_4065_aN = (new BlockPressurePlate(72, field_334_y.field_378_bb, EnumMobType.everything, Material.field_1335_c)).func_222_c(0.5F).func_4024_a(field_9254_e).func_20012_a("pressurePlate").func_28031_n();
        field_433_aO = (new BlockRedstoneOre(73, 51, false)).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreRedstone").func_28031_n();
        field_432_aP = (new BlockRedstoneOre(74, 51, true)).func_215_a(0.625F).func_222_c(3F).func_219_b(5F).func_4024_a(field_9251_h).func_20012_a("oreRedstone").func_28031_n();
        field_431_aQ = (new BlockRedstoneTorch(75, 115, false)).func_222_c(0.0F).func_4024_a(field_9254_e).func_20012_a("notGate").func_28031_n();
        field_430_aR = (new BlockRedstoneTorch(76, 99, true)).func_222_c(0.0F).func_215_a(0.5F).func_4024_a(field_9254_e).func_20012_a("notGate").func_28031_n();
        field_4064_aS = (new BlockButton(77, field_338_u.field_378_bb)).func_222_c(0.5F).func_4024_a(field_9251_h).func_20012_a("button").func_28031_n();
        field_428_aT = (new BlockSnow(78, 66)).func_222_c(0.1F).func_4024_a(field_9248_k).func_20012_a("snow").func_256_d(0);
        field_4063_aU = (new BlockIce(79, 67)).func_222_c(0.5F).func_256_d(3).func_4024_a(field_9249_j).func_20012_a("ice");
        field_426_aV = (new BlockSnowBlock(80, 66)).func_222_c(0.2F).func_4024_a(field_9248_k).func_20012_a("snow");
        field_425_aW = (new BlockCactus(81, 70)).func_222_c(0.4F).func_4024_a(field_9248_k).func_20012_a("cactus");
        field_424_aX = (new BlockClay(82, 72)).func_222_c(0.6F).func_4024_a(field_9253_f).func_20012_a("clay");
        field_423_aY = (new BlockReed(83, 73)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("reeds").func_27032_l();
        field_422_aZ = (new BlockJukeBox(84, 74)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("jukebox").func_28031_n();
        field_4057_ba = (new BlockFence(85, 4)).func_222_c(2.0F).func_219_b(5F).func_4024_a(field_9254_e).func_20012_a("fence");
        field_4055_bb = (new BlockPumpkin(86, 102, false)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("pumpkin").func_28031_n();
        field_4053_bc = (new BlockNetherrack(87, 103)).func_222_c(0.4F).func_4024_a(field_9251_h).func_20012_a("hellrock");
        field_4051_bd = (new BlockSoulSand(88, 104)).func_222_c(0.5F).func_4024_a(field_9247_l).func_20012_a("hellsand");
        field_4049_be = (new BlockGlowStone(89, 105, Material.field_4263_o)).func_222_c(0.3F).func_4024_a(field_9249_j).func_215_a(1.0F).func_20012_a("lightgem");
        field_4047_bf = (BlockPortal)(new BlockPortal(90, 14)).func_222_c(-1F).func_4024_a(field_9249_j).func_215_a(0.75F).func_20012_a("portal");
        field_4045_bg = (new BlockPumpkin(91, 102, true)).func_222_c(1.0F).func_4024_a(field_9254_e).func_215_a(1.0F).func_20012_a("litpumpkin").func_28031_n();
        field_21026_bg = (new BlockCake(92, 121)).func_222_c(0.5F).func_4024_a(field_9248_k).func_20012_a("cake").func_27032_l().func_28031_n();
        field_22021_bh = (new BlockRedstoneRepeater(93, false)).func_222_c(0.0F).func_4024_a(field_9254_e).func_20012_a("diode").func_27032_l().func_28031_n();
        field_22020_bi = (new BlockRedstoneRepeater(94, true)).func_222_c(0.0F).func_215_a(0.625F).func_4024_a(field_9254_e).func_20012_a("diode").func_27032_l().func_28031_n();
        field_25017_bj = (new BlockLockedChest(95)).func_222_c(0.0F).func_215_a(1.0F).func_4024_a(field_9254_e).func_20012_a("lockedchest").func_253_b(true).func_28031_n();
        field_28033_bl = (new BlockTrapDoor(96, Material.field_1335_c)).func_222_c(3F).func_4024_a(field_9254_e).func_20012_a("trapdoor").func_27032_l().func_28031_n();
        field_35285_bn = (new BlockStoneBrick(98)).func_222_c(1.5F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("stonebricksmooth");
        field_35286_bo = (new BlockMushroomCap(99, Material.field_1335_c, 142, 0)).func_222_c(0.2F).func_4024_a(field_9254_e).func_20012_a("mushroom").func_28031_n();
        field_35287_bp = (new BlockMushroomCap(100, Material.field_1335_c, 142, 1)).func_222_c(0.2F).func_4024_a(field_9254_e).func_20012_a("mushroom").func_28031_n();
        field_35288_bq = (new BlockPane(101, 85, 85, Material.field_1333_e, true)).func_222_c(5F).func_219_b(10F).func_4024_a(field_9250_i).func_20012_a("fenceIron");
        field_35282_br = (new BlockPane(102, 49, 148, Material.field_4263_o, false)).func_222_c(0.3F).func_4024_a(field_9249_j).func_20012_a("thinGlass");
        field_35281_bs = (new BlockMelon(103)).func_222_c(1.0F).func_4024_a(field_9254_e).func_20012_a("melon");
        field_35284_bt = (new BlockStem(104, field_4055_bb)).func_222_c(0.0F).func_4024_a(field_9254_e).func_20012_a("pumpkinStem").func_28031_n();
        field_35283_bu = (new BlockStem(105, field_35281_bs)).func_222_c(0.0F).func_4024_a(field_9254_e).func_20012_a("pumpkinStem").func_28031_n();
        field_35278_bv = (new BlockVine(106)).func_222_c(0.2F).func_4024_a(field_9252_g).func_20012_a("vine").func_28031_n();
        field_35277_bw = (new BlockFenceGate(107, 4)).func_222_c(2.0F).func_219_b(5F).func_4024_a(field_9254_e).func_20012_a("fenceGate").func_28031_n();
        field_35280_bx = (new BlockStairs(108, field_409_am)).func_20012_a("stairsBrick").func_28031_n();
        field_35279_by = (new BlockStairs(109, field_35285_bn)).func_20012_a("stairsStoneBrickSmooth").func_28031_n();
        field_40199_bz = (BlockMycelium)(new BlockMycelium(110)).func_222_c(0.6F).func_4024_a(field_9252_g).func_20012_a("mycel");
        field_40200_bA = (new BlockLilyPad(111, 76)).func_222_c(0.0F).func_4024_a(field_9252_g).func_20012_a("waterlily");
        field_40206_bB = (new Block(112, 224, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("netherBrick");
        field_40207_bC = (new BlockFence(113, 224, Material.field_1334_d)).func_222_c(2.0F).func_219_b(10F).func_4024_a(field_9251_h).func_20012_a("netherFence");
        field_40204_bD = (new BlockStairs(114, field_40206_bB)).func_20012_a("stairsNetherBrick").func_28031_n();
        field_40209_bI = (new BlockEndPortal(119, Material.field_4260_x)).func_222_c(-1F).func_219_b(6000000F);
        field_40202_bJ = (new BlockEndPortalFrame(120)).func_4024_a(field_9249_j).func_215_a(0.125F).func_222_c(-1F).func_20012_a("endPortalFrame").func_28031_n().func_219_b(6000000F);
        field_40203_bK = (new Block(121, 175, Material.field_1334_d)).func_222_c(3F).func_219_b(15F).func_4024_a(field_9251_h).func_20012_a("whiteStone");
        field_41050_bK = (new BlockDragonEgg(122, 167)).func_222_c(3F).func_219_b(15F).func_4024_a(field_9251_h).func_215_a(0.125F).func_20012_a("dragonEgg");
        Item.field_233_c[field_419_ac.field_376_bc] = (new ItemCloth(field_419_ac.field_376_bc - 256)).func_20011_a("cloth");
        Item.field_233_c[field_385_K.field_376_bc] = (new ItemMetadata(field_385_K.field_376_bc - 256, field_385_K)).func_20011_a("log");
        Item.field_233_c[field_35285_bn.field_376_bc] = (new ItemMetadata(field_35285_bn.field_376_bc - 256, field_35285_bn)).func_20011_a("stonebricksmooth");
        Item.field_233_c[field_410_al.field_376_bc] = (new ItemSlab(field_410_al.field_376_bc - 256)).func_20011_a("stoneSlab");
        Item.field_233_c[field_333_z.field_376_bc] = (new ItemSapling(field_333_z.field_376_bc - 256)).func_20011_a("sapling");
        Item.field_233_c[field_384_L.field_376_bc] = (new ItemLeaves(field_384_L.field_376_bc - 256)).func_20011_a("leaves");
        Item.field_233_c[field_35278_bv.field_376_bc] = new ItemColored(field_35278_bv.field_376_bc - 256, false);
        Item.field_233_c[field_9257_X.field_376_bc] = (new ItemColored(field_9257_X.field_376_bc - 256, true)).func_41033_a(new String[] {
            "shrub", "grass", "fern"
        });
        Item.field_233_c[field_40200_bA.field_376_bc] = new ItemLilyPad(field_40200_bA.field_376_bc - 256);
        Item.field_233_c[field_9255_Z.field_376_bc] = new ItemPiston(field_9255_Z.field_376_bc - 256);
        Item.field_233_c[field_9259_V.field_376_bc] = new ItemPiston(field_9259_V.field_376_bc - 256);
        for(int i = 0; i < 256; i++)
        {
            if(field_345_n[i] == null)
            {
                continue;
            }
            if(Item.field_233_c[i] == null)
            {
                Item.field_233_c[i] = new ItemBlock(i - 256);
                field_345_n[i].func_28028_i();
            }
            boolean flag = false;
            if(i > 0 && field_345_n[i].func_210_f() == 10)
            {
                flag = true;
            }
            if(i > 0 && (field_345_n[i] instanceof BlockStep))
            {
                flag = true;
            }
            if(i == field_446_aB.field_376_bc)
            {
                flag = true;
            }
            field_40201_bL[i] = flag;
        }

        field_340_s[0] = true;
        StatList.func_25154_a();
    }
}
