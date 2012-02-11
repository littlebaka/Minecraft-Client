// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            NetHandler, MapStorage, NetworkManager, PlayerControllerMP, 
//            StatList, StatFileWriter, WorldClient, WorldSettings, 
//            Packet1Login, EntityPlayerSP, GuiDownloadTerrain, Packet21PickupSpawn, 
//            EntityItem, ItemStack, Packet23VehicleSpawn, EntityMinecart, 
//            EntityFishHook, EntityArrow, EntitySnowball, EntityEnderPearl, 
//            EntityEnderEye, EntityFireball, EntitySmallFireball, EntityEgg, 
//            EntityPotion, EntityBoat, EntityTNTPrimed, EntityEnderCrystal, 
//            EntityFallingSand, Block, Entity, EntityLiving, 
//            EntityXPOrb, Packet26EntityExpOrb, Packet71Weather, EntityLightningBolt, 
//            EntityPainting, Packet25EntityPainting, Packet28EntityVelocity, Packet40EntityMetadata, 
//            DataWatcher, Packet20NamedEntitySpawn, EntityOtherPlayerMP, InventoryPlayer, 
//            Packet34EntityTeleport, Packet30Entity, Packet29DestroyEntity, EntityPlayer, 
//            Packet10Flying, AxisAlignedBB, Packet50PreChunk, Packet52MultiBlockChange, 
//            Chunk, Packet51MapChunk, Packet53BlockChange, GuiDisconnected, 
//            Packet255KickDisconnect, Packet22Collect, EntityPickupFX, EffectRenderer, 
//            Packet3Chat, GuiIngame, Packet18Animation, EntityCrit2FX, 
//            Packet17Sleep, Packet2Handshake, Session, Packet24MobSpawn, 
//            EntityList, Packet4UpdateTime, World, ChunkCoordinates, 
//            Packet6SpawnPosition, WorldInfo, Packet39AttachEntity, Packet38EntityStatus, 
//            Packet8UpdateHealth, FoodStats, Packet43Experience, Packet9Respawn, 
//            Explosion, Packet60Explosion, Packet100OpenWindow, InventoryBasic, 
//            Container, TileEntityFurnace, TileEntityBrewingStand, TileEntityDispenser, 
//            MathHelper, Packet103SetSlot, Slot, Packet106Transaction, 
//            Packet104WindowItems, Packet130UpdateSign, TileEntitySign, Packet105UpdateProgressbar, 
//            Packet5PlayerInventory, Packet54PlayNoteBlock, Packet70Bed, GuiWinGame, 
//            Packet131MapData, Item, ItemMap, MapData, 
//            Packet61DoorChange, EntityClientPlayerMP, Packet200Statistic, Packet41EntityEffect, 
//            PotionEffect, Packet42RemoveEntityEffect, Packet201PlayerInfo, GuiSavingLevelString, 
//            Packet0KeepAlive, Packet, Packet101CloseWindow

public class NetClientHandler extends NetHandler
{

    private boolean field_1214_c;
    private NetworkManager field_1213_d;
    public String field_1209_a;
    private Minecraft field_1212_e;
    private WorldClient field_1211_f;
    private boolean field_1210_g;
    public MapStorage field_28118_b;
    private Map field_35787_k;
    public List field_35786_c;
    public int field_35785_d;
    Random field_1208_b;

    public NetClientHandler(Minecraft minecraft, String s, int i)
        throws UnknownHostException, IOException
    {
        field_1214_c = false;
        field_1210_g = false;
        field_28118_b = new MapStorage(null);
        field_35787_k = new HashMap();
        field_35786_c = new ArrayList();
        field_35785_d = 20;
        field_1208_b = new Random();
        field_1212_e = minecraft;
        Socket socket = new Socket(InetAddress.getByName(s), i);
        field_1213_d = new NetworkManager(socket, "Client", this);
    }

    public void func_848_a()
    {
        if(!field_1214_c)
        {
            field_1213_d.func_967_a();
        }
        field_1213_d.func_28139_a();
    }

    public void func_4115_a(Packet1Login packet1login)
    {
        field_1212_e.field_6327_b = new PlayerControllerMP(field_1212_e, this);
        field_1212_e.field_25001_G.func_25100_a(StatList.field_25181_h, 1);
        field_1211_f = new WorldClient(this, new WorldSettings(packet1login.field_4074_d, packet1login.field_35249_d, false, false, packet1login.field_46032_d), packet1login.field_35250_e, packet1login.field_35247_f);
        field_1211_f.field_1026_y = true;
        field_1212_e.func_6261_a(field_1211_f);
        field_1212_e.field_6322_g.field_4129_m = packet1login.field_35250_e;
        field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
        field_1212_e.field_6322_g.field_620_ab = packet1login.field_519_a;
        field_35785_d = packet1login.field_35251_h;
        ((PlayerControllerMP)field_1212_e.field_6327_b).func_35648_a(packet1login.field_35249_d == 1);
    }

    public void func_832_a(Packet21PickupSpawn packet21pickupspawn)
    {
        double d = (double)packet21pickupspawn.field_530_b / 32D;
        double d1 = (double)packet21pickupspawn.field_529_c / 32D;
        double d2 = (double)packet21pickupspawn.field_528_d / 32D;
        EntityItem entityitem = new EntityItem(field_1211_f, d, d1, d2, new ItemStack(packet21pickupspawn.field_524_h, packet21pickupspawn.field_523_i, packet21pickupspawn.field_21052_l));
        entityitem.field_608_an = (double)packet21pickupspawn.field_527_e / 128D;
        entityitem.field_607_ao = (double)packet21pickupspawn.field_526_f / 128D;
        entityitem.field_606_ap = (double)packet21pickupspawn.field_525_g / 128D;
        entityitem.field_9303_br = packet21pickupspawn.field_530_b;
        entityitem.field_9302_bs = packet21pickupspawn.field_529_c;
        entityitem.field_9301_bt = packet21pickupspawn.field_528_d;
        field_1211_f.func_712_a(packet21pickupspawn.field_531_a, entityitem);
    }

    public void func_835_a(Packet23VehicleSpawn packet23vehiclespawn)
    {
        double d = (double)packet23vehiclespawn.field_499_b / 32D;
        double d1 = (double)packet23vehiclespawn.field_503_c / 32D;
        double d2 = (double)packet23vehiclespawn.field_502_d / 32D;
        Object obj = null;
        if(packet23vehiclespawn.field_501_e == 10)
        {
            obj = new EntityMinecart(field_1211_f, d, d1, d2, 0);
        }
        if(packet23vehiclespawn.field_501_e == 11)
        {
            obj = new EntityMinecart(field_1211_f, d, d1, d2, 1);
        }
        if(packet23vehiclespawn.field_501_e == 12)
        {
            obj = new EntityMinecart(field_1211_f, d, d1, d2, 2);
        }
        if(packet23vehiclespawn.field_501_e == 90)
        {
            obj = new EntityFishHook(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 60)
        {
            obj = new EntityArrow(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 61)
        {
            obj = new EntitySnowball(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 65)
        {
            obj = new EntityEnderPearl(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 72)
        {
            obj = new EntityEnderEye(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 63)
        {
            obj = new EntityFireball(field_1211_f, d, d1, d2, (double)packet23vehiclespawn.field_28047_e / 8000D, (double)packet23vehiclespawn.field_28046_f / 8000D, (double)packet23vehiclespawn.field_28045_g / 8000D);
            packet23vehiclespawn.field_28044_i = 0;
        }
        if(packet23vehiclespawn.field_501_e == 64)
        {
            obj = new EntitySmallFireball(field_1211_f, d, d1, d2, (double)packet23vehiclespawn.field_28047_e / 8000D, (double)packet23vehiclespawn.field_28046_f / 8000D, (double)packet23vehiclespawn.field_28045_g / 8000D);
            packet23vehiclespawn.field_28044_i = 0;
        }
        if(packet23vehiclespawn.field_501_e == 62)
        {
            obj = new EntityEgg(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 73)
        {
            obj = new EntityPotion(field_1211_f, d, d1, d2, packet23vehiclespawn.field_28044_i);
            packet23vehiclespawn.field_28044_i = 0;
        }
        if(packet23vehiclespawn.field_501_e == 1)
        {
            obj = new EntityBoat(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 50)
        {
            obj = new EntityTNTPrimed(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 51)
        {
            obj = new EntityEnderCrystal(field_1211_f, d, d1, d2);
        }
        if(packet23vehiclespawn.field_501_e == 70)
        {
            obj = new EntityFallingSand(field_1211_f, d, d1, d2, Block.field_393_F.field_376_bc);
        }
        if(packet23vehiclespawn.field_501_e == 71)
        {
            obj = new EntityFallingSand(field_1211_f, d, d1, d2, Block.field_392_G.field_376_bc);
        }
        if(packet23vehiclespawn.field_501_e == 74)
        {
            obj = new EntityFallingSand(field_1211_f, d, d1, d2, Block.field_41050_bK.field_376_bc);
        }
        if(obj != null)
        {
            obj.field_9303_br = packet23vehiclespawn.field_499_b;
            obj.field_9302_bs = packet23vehiclespawn.field_503_c;
            obj.field_9301_bt = packet23vehiclespawn.field_502_d;
            obj.field_605_aq = 0.0F;
            obj.field_604_ar = 0.0F;
            Entity aentity[] = ((Entity) (obj)).func_40048_X();
            if(aentity != null)
            {
                int i = packet23vehiclespawn.field_500_a - ((Entity) (obj)).field_620_ab;
                for(int j = 0; j < aentity.length; j++)
                {
                    aentity[j].field_620_ab += i;
                    System.out.println(aentity[j].field_620_ab);
                }

            }
            obj.field_620_ab = packet23vehiclespawn.field_500_a;
            field_1211_f.func_712_a(packet23vehiclespawn.field_500_a, ((Entity) (obj)));
            if(packet23vehiclespawn.field_28044_i > 0)
            {
                if(packet23vehiclespawn.field_501_e == 60)
                {
                    Entity entity = func_12246_a(packet23vehiclespawn.field_28044_i);
                    if(entity instanceof EntityLiving)
                    {
                        ((EntityArrow)obj).field_682_g = (EntityLiving)entity;
                    }
                }
                ((Entity) (obj)).func_6375_a((double)packet23vehiclespawn.field_28047_e / 8000D, (double)packet23vehiclespawn.field_28046_f / 8000D, (double)packet23vehiclespawn.field_28045_g / 8000D);
            }
        }
    }

    public void func_35778_a(Packet26EntityExpOrb packet26entityexporb)
    {
        EntityXPOrb entityxporb = new EntityXPOrb(field_1211_f, packet26entityexporb.field_35239_b, packet26entityexporb.field_35240_c, packet26entityexporb.field_35237_d, packet26entityexporb.field_35238_e);
        entityxporb.field_9303_br = packet26entityexporb.field_35239_b;
        entityxporb.field_9302_bs = packet26entityexporb.field_35240_c;
        entityxporb.field_9301_bt = packet26entityexporb.field_35237_d;
        entityxporb.field_605_aq = 0.0F;
        entityxporb.field_604_ar = 0.0F;
        entityxporb.field_620_ab = packet26entityexporb.field_35241_a;
        field_1211_f.func_712_a(packet26entityexporb.field_35241_a, entityxporb);
    }

    public void func_27246_a(Packet71Weather packet71weather)
    {
        double d = (double)packet71weather.field_27053_b / 32D;
        double d1 = (double)packet71weather.field_27057_c / 32D;
        double d2 = (double)packet71weather.field_27056_d / 32D;
        EntityLightningBolt entitylightningbolt = null;
        if(packet71weather.field_27055_e == 1)
        {
            entitylightningbolt = new EntityLightningBolt(field_1211_f, d, d1, d2);
        }
        if(entitylightningbolt != null)
        {
            entitylightningbolt.field_9303_br = packet71weather.field_27053_b;
            entitylightningbolt.field_9302_bs = packet71weather.field_27057_c;
            entitylightningbolt.field_9301_bt = packet71weather.field_27056_d;
            entitylightningbolt.field_605_aq = 0.0F;
            entitylightningbolt.field_604_ar = 0.0F;
            entitylightningbolt.field_620_ab = packet71weather.field_27054_a;
            field_1211_f.func_27159_a(entitylightningbolt);
        }
    }

    public void func_21146_a(Packet25EntityPainting packet25entitypainting)
    {
        EntityPainting entitypainting = new EntityPainting(field_1211_f, packet25entitypainting.field_21041_b, packet25entitypainting.field_21046_c, packet25entitypainting.field_21045_d, packet25entitypainting.field_21044_e, packet25entitypainting.field_21043_f);
        field_1211_f.func_712_a(packet25entitypainting.field_21042_a, entitypainting);
    }

    public void func_6498_a(Packet28EntityVelocity packet28entityvelocity)
    {
        Entity entity = func_12246_a(packet28entityvelocity.field_6367_a);
        if(entity == null)
        {
            return;
        } else
        {
            entity.func_6375_a((double)packet28entityvelocity.field_6366_b / 8000D, (double)packet28entityvelocity.field_6369_c / 8000D, (double)packet28entityvelocity.field_6368_d / 8000D);
            return;
        }
    }

    public void func_21148_a(Packet40EntityMetadata packet40entitymetadata)
    {
        Entity entity = func_12246_a(packet40entitymetadata.field_21049_a);
        if(entity != null && packet40entitymetadata.func_21047_b() != null)
        {
            entity.func_21061_O().func_21126_a(packet40entitymetadata.func_21047_b());
        }
    }

    public void func_820_a(Packet20NamedEntitySpawn packet20namedentityspawn)
    {
        double d = (double)packet20namedentityspawn.field_540_c / 32D;
        double d1 = (double)packet20namedentityspawn.field_539_d / 32D;
        double d2 = (double)packet20namedentityspawn.field_538_e / 32D;
        float f = (float)(packet20namedentityspawn.field_537_f * 360) / 256F;
        float f1 = (float)(packet20namedentityspawn.field_536_g * 360) / 256F;
        EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP(field_1212_e.field_6324_e, packet20namedentityspawn.field_533_b);
        entityotherplayermp.field_9285_at = entityotherplayermp.field_638_aI = entityotherplayermp.field_9303_br = packet20namedentityspawn.field_540_c;
        entityotherplayermp.field_9284_au = entityotherplayermp.field_637_aJ = entityotherplayermp.field_9302_bs = packet20namedentityspawn.field_539_d;
        entityotherplayermp.field_9283_av = entityotherplayermp.field_636_aK = entityotherplayermp.field_9301_bt = packet20namedentityspawn.field_538_e;
        int i = packet20namedentityspawn.field_535_h;
        if(i == 0)
        {
            entityotherplayermp.field_778_b.field_843_a[entityotherplayermp.field_778_b.field_847_d] = null;
        } else
        {
            entityotherplayermp.field_778_b.field_843_a[entityotherplayermp.field_778_b.field_847_d] = new ItemStack(i, 1, 0);
        }
        entityotherplayermp.func_399_b(d, d1, d2, f, f1);
        field_1211_f.func_712_a(packet20namedentityspawn.field_534_a, entityotherplayermp);
    }

    public void func_829_a(Packet34EntityTeleport packet34entityteleport)
    {
        Entity entity = func_12246_a(packet34entityteleport.field_509_a);
        if(entity == null)
        {
            return;
        } else
        {
            entity.field_9303_br = packet34entityteleport.field_508_b;
            entity.field_9302_bs = packet34entityteleport.field_513_c;
            entity.field_9301_bt = packet34entityteleport.field_512_d;
            double d = (double)entity.field_9303_br / 32D;
            double d1 = (double)entity.field_9302_bs / 32D + 0.015625D;
            double d2 = (double)entity.field_9301_bt / 32D;
            float f = (float)(packet34entityteleport.field_511_e * 360) / 256F;
            float f1 = (float)(packet34entityteleport.field_510_f * 360) / 256F;
            entity.func_378_a(d, d1, d2, f, f1, 3);
            return;
        }
    }

    public void func_827_a(Packet30Entity packet30entity)
    {
        Entity entity = func_12246_a(packet30entity.field_485_a);
        if(entity == null)
        {
            return;
        } else
        {
            entity.field_9303_br += packet30entity.field_484_b;
            entity.field_9302_bs += packet30entity.field_490_c;
            entity.field_9301_bt += packet30entity.field_489_d;
            double d = (double)entity.field_9303_br / 32D;
            double d1 = (double)entity.field_9302_bs / 32D;
            double d2 = (double)entity.field_9301_bt / 32D;
            float f = packet30entity.field_486_g ? (float)(packet30entity.field_488_e * 360) / 256F : entity.field_605_aq;
            float f1 = packet30entity.field_486_g ? (float)(packet30entity.field_487_f * 360) / 256F : entity.field_604_ar;
            entity.func_378_a(d, d1, d2, f, f1, 3);
            return;
        }
    }

    public void func_839_a(Packet29DestroyEntity packet29destroyentity)
    {
        field_1211_f.func_710_c(packet29destroyentity.field_507_a);
    }

    public void func_837_a(Packet10Flying packet10flying)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        double d = ((EntityPlayer) (entityplayersp)).field_611_ak;
        double d1 = ((EntityPlayer) (entityplayersp)).field_610_al;
        double d2 = ((EntityPlayer) (entityplayersp)).field_609_am;
        float f = ((EntityPlayer) (entityplayersp)).field_605_aq;
        float f1 = ((EntityPlayer) (entityplayersp)).field_604_ar;
        if(packet10flying.field_554_h)
        {
            d = packet10flying.field_561_a;
            d1 = packet10flying.field_560_b;
            d2 = packet10flying.field_559_c;
        }
        if(packet10flying.field_553_i)
        {
            f = packet10flying.field_557_e;
            f1 = packet10flying.field_556_f;
        }
        entityplayersp.field_9287_aY = 0.0F;
        entityplayersp.field_608_an = entityplayersp.field_607_ao = entityplayersp.field_606_ap = 0.0D;
        entityplayersp.func_399_b(d, d1, d2, f, f1);
        packet10flying.field_561_a = ((EntityPlayer) (entityplayersp)).field_611_ak;
        packet10flying.field_560_b = ((EntityPlayer) (entityplayersp)).field_601_au.field_1697_b;
        packet10flying.field_559_c = ((EntityPlayer) (entityplayersp)).field_609_am;
        packet10flying.field_558_d = ((EntityPlayer) (entityplayersp)).field_610_al;
        field_1213_d.func_972_a(packet10flying);
        if(!field_1210_g)
        {
            field_1212_e.field_6322_g.field_9285_at = field_1212_e.field_6322_g.field_611_ak;
            field_1212_e.field_6322_g.field_9284_au = field_1212_e.field_6322_g.field_610_al;
            field_1212_e.field_6322_g.field_9283_av = field_1212_e.field_6322_g.field_609_am;
            field_1210_g = true;
            field_1212_e.func_6272_a(null);
        }
    }

    public void func_826_a(Packet50PreChunk packet50prechunk)
    {
        field_1211_f.func_713_a(packet50prechunk.field_505_a, packet50prechunk.field_504_b, packet50prechunk.field_506_c);
    }

    public void func_824_a(Packet52MultiBlockChange packet52multiblockchange)
    {
        Chunk chunk = field_1211_f.func_704_b(packet52multiblockchange.field_479_a, packet52multiblockchange.field_478_b);
        int i = packet52multiblockchange.field_479_a * 16;
        int j = packet52multiblockchange.field_478_b * 16;
        for(int k = 0; k < packet52multiblockchange.field_480_f; k++)
        {
            short word0 = packet52multiblockchange.field_483_c[k];
            int l = packet52multiblockchange.field_482_d[k] & 0xff;
            byte byte0 = packet52multiblockchange.field_481_e[k];
            int i1 = word0 >> 12 & 0xf;
            int j1 = word0 >> 8 & 0xf;
            int k1 = word0 & 0xff;
            chunk.func_1010_a(i1, k1, j1, l, byte0);
            field_1211_f.func_711_c(i1 + i, k1, j1 + j, i1 + i, k1, j1 + j);
            field_1211_f.func_701_b(i1 + i, k1, j1 + j, i1 + i, k1, j1 + j);
        }

    }

    public void func_833_a(Packet51MapChunk packet51mapchunk)
    {
        field_1211_f.func_711_c(packet51mapchunk.field_573_a, packet51mapchunk.field_572_b, packet51mapchunk.field_579_c, (packet51mapchunk.field_573_a + packet51mapchunk.field_578_d) - 1, (packet51mapchunk.field_572_b + packet51mapchunk.field_577_e) - 1, (packet51mapchunk.field_579_c + packet51mapchunk.field_576_f) - 1);
        field_1211_f.func_693_a(packet51mapchunk.field_573_a, packet51mapchunk.field_572_b, packet51mapchunk.field_579_c, packet51mapchunk.field_578_d, packet51mapchunk.field_577_e, packet51mapchunk.field_576_f, packet51mapchunk.field_575_g);
    }

    public void func_822_a(Packet53BlockChange packet53blockchange)
    {
        field_1211_f.func_714_c(packet53blockchange.field_492_a, packet53blockchange.field_491_b, packet53blockchange.field_495_c, packet53blockchange.field_494_d, packet53blockchange.field_493_e);
    }

    public void func_844_a(Packet255KickDisconnect packet255kickdisconnect)
    {
        field_1213_d.func_974_a("disconnect.kicked", new Object[0]);
        field_1214_c = true;
        field_1212_e.func_6261_a(null);
        field_1212_e.func_6272_a(new GuiDisconnected("disconnect.disconnected", "disconnect.genericReason", new Object[] {
            packet255kickdisconnect.field_582_a
        }));
    }

    public void func_823_a(String s, Object aobj[])
    {
        if(field_1214_c)
        {
            return;
        } else
        {
            field_1214_c = true;
            field_1212_e.func_6261_a(null);
            field_1212_e.func_6272_a(new GuiDisconnected("disconnect.lost", s, aobj));
            return;
        }
    }

    public void func_28117_a(Packet packet)
    {
        if(field_1214_c)
        {
            return;
        } else
        {
            field_1213_d.func_972_a(packet);
            field_1213_d.func_28142_c();
            return;
        }
    }

    public void func_847_a(Packet packet)
    {
        if(field_1214_c)
        {
            return;
        } else
        {
            field_1213_d.func_972_a(packet);
            return;
        }
    }

    public void func_834_a(Packet22Collect packet22collect)
    {
        Entity entity = func_12246_a(packet22collect.field_581_a);
        Object obj = (EntityLiving)func_12246_a(packet22collect.field_580_b);
        if(obj == null)
        {
            obj = field_1212_e.field_6322_g;
        }
        if(entity != null)
        {
            field_1211_f.func_623_a(entity, "random.pop", 0.2F, ((field_1208_b.nextFloat() - field_1208_b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            field_1212_e.field_6321_h.func_1192_a(new EntityPickupFX(field_1212_e.field_6324_e, entity, ((Entity) (obj)), -0.5F));
            field_1211_f.func_710_c(packet22collect.field_581_a);
        }
    }

    public void func_4113_a(Packet3Chat packet3chat)
    {
        field_1212_e.field_6308_u.func_552_a(packet3chat.field_517_a);
    }

    public void func_825_a(Packet18Animation packet18animation)
    {
        Entity entity = func_12246_a(packet18animation.field_522_a);
        if(entity == null)
        {
            return;
        }
        if(packet18animation.field_521_b == 1)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.func_457_w();
        } else
        if(packet18animation.field_521_b == 2)
        {
            entity.func_9280_g();
        } else
        if(packet18animation.field_521_b == 3)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)entity;
            entityplayer1.func_22056_a(false, false, false);
        } else
        if(packet18animation.field_521_b == 4)
        {
            EntityPlayer entityplayer2 = (EntityPlayer)entity;
            entityplayer2.func_6420_o();
        } else
        if(packet18animation.field_521_b == 6)
        {
            field_1212_e.field_6321_h.func_1192_a(new EntityCrit2FX(field_1212_e.field_6324_e, entity));
        } else
        if(packet18animation.field_521_b == 7)
        {
            EntityCrit2FX entitycrit2fx = new EntityCrit2FX(field_1212_e.field_6324_e, entity, "magicCrit");
            field_1212_e.field_6321_h.func_1192_a(entitycrit2fx);
        } else
        if(packet18animation.field_521_b == 5)
        {
            if(!(entity instanceof EntityOtherPlayerMP));
        }
    }

    public void func_22186_a(Packet17Sleep packet17sleep)
    {
        Entity entity = func_12246_a(packet17sleep.field_22045_a);
        if(entity == null)
        {
            return;
        }
        if(packet17sleep.field_22046_e == 0)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.func_22053_b(packet17sleep.field_22044_b, packet17sleep.field_22048_c, packet17sleep.field_22047_d);
        }
    }

    public void func_838_a(Packet2Handshake packet2handshake)
    {
        boolean flag = true;
        String s = packet2handshake.field_532_a;
        if(s == null || s.trim().length() == 0)
        {
            flag = false;
        } else
        if(!s.equals("-"))
        {
            try
            {
                Long.parseLong(s, 16);
            }
            catch(NumberFormatException numberformatexception)
            {
                flag = false;
            }
        }
        if(!flag)
        {
            field_1213_d.func_974_a("disconnect.genericReason", new Object[] {
                "The server responded with an invalid server key"
            });
        } else
        if(packet2handshake.field_532_a.equals("-"))
        {
            func_847_a(new Packet1Login(field_1212_e.field_6320_i.field_1666_b, 23));
        } else
        {
            try
            {
                URL url = new URL((new StringBuilder()).append("http://session.minecraft.net/game/joinserver.jsp?user=").append(field_1212_e.field_6320_i.field_1666_b).append("&sessionId=").append(field_1212_e.field_6320_i.field_6543_c).append("&serverId=").append(packet2handshake.field_532_a).toString());
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
                String s1 = bufferedreader.readLine();
                bufferedreader.close();
                if(s1.equalsIgnoreCase("ok"))
                {
                    func_847_a(new Packet1Login(field_1212_e.field_6320_i.field_1666_b, 23));
                } else
                {
                    field_1213_d.func_974_a("disconnect.loginFailedInfo", new Object[] {
                        s1
                    });
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
                field_1213_d.func_974_a("disconnect.genericReason", new Object[] {
                    (new StringBuilder()).append("Internal client error: ").append(exception.toString()).toString()
                });
            }
        }
    }

    public void func_849_b()
    {
        field_1214_c = true;
        field_1213_d.func_28139_a();
        field_1213_d.func_974_a("disconnect.closed", new Object[0]);
    }

    public void func_828_a(Packet24MobSpawn packet24mobspawn)
    {
        double d = (double)packet24mobspawn.field_552_c / 32D;
        double d1 = (double)packet24mobspawn.field_551_d / 32D;
        double d2 = (double)packet24mobspawn.field_550_e / 32D;
        float f = (float)(packet24mobspawn.field_549_f * 360) / 256F;
        float f1 = (float)(packet24mobspawn.field_548_g * 360) / 256F;
        EntityLiving entityliving = (EntityLiving)EntityList.func_1084_a(packet24mobspawn.field_546_b, field_1212_e.field_6324_e);
        entityliving.field_9303_br = packet24mobspawn.field_552_c;
        entityliving.field_9302_bs = packet24mobspawn.field_551_d;
        entityliving.field_9301_bt = packet24mobspawn.field_550_e;
        Entity aentity[] = entityliving.func_40048_X();
        if(aentity != null)
        {
            int i = packet24mobspawn.field_547_a - entityliving.field_620_ab;
            for(int j = 0; j < aentity.length; j++)
            {
                aentity[j].field_620_ab += i;
            }

        }
        entityliving.field_620_ab = packet24mobspawn.field_547_a;
        entityliving.func_399_b(d, d1, d2, f, f1);
        field_1211_f.func_712_a(packet24mobspawn.field_547_a, entityliving);
        List list = packet24mobspawn.func_21053_b();
        if(list != null)
        {
            entityliving.func_21061_O().func_21126_a(list);
        }
    }

    public void func_846_a(Packet4UpdateTime packet4updatetime)
    {
        field_1212_e.field_6324_e.func_648_a(packet4updatetime.field_564_a);
    }

    public void func_845_a(Packet6SpawnPosition packet6spawnposition)
    {
        field_1212_e.field_6322_g.func_25061_a(new ChunkCoordinates(packet6spawnposition.field_515_a, packet6spawnposition.field_514_b, packet6spawnposition.field_516_c));
        field_1212_e.field_6324_e.func_22144_v().func_22292_a(packet6spawnposition.field_515_a, packet6spawnposition.field_514_b, packet6spawnposition.field_516_c);
    }

    public void func_6497_a(Packet39AttachEntity packet39attachentity)
    {
        Object obj = func_12246_a(packet39attachentity.field_6365_a);
        Entity entity = func_12246_a(packet39attachentity.field_6364_b);
        if(packet39attachentity.field_6365_a == field_1212_e.field_6322_g.field_620_ab)
        {
            obj = field_1212_e.field_6322_g;
        }
        if(obj == null)
        {
            return;
        } else
        {
            ((Entity) (obj)).func_6377_h(entity);
            return;
        }
    }

    public void func_9447_a(Packet38EntityStatus packet38entitystatus)
    {
        Entity entity = func_12246_a(packet38entitystatus.field_9274_a);
        if(entity != null)
        {
            entity.func_9282_a(packet38entitystatus.field_9273_b);
        }
    }

    private Entity func_12246_a(int i)
    {
        if(i == field_1212_e.field_6322_g.field_620_ab)
        {
            return field_1212_e.field_6322_g;
        } else
        {
            return field_1211_f.func_709_b(i);
        }
    }

    public void func_9446_a(Packet8UpdateHealth packet8updatehealth)
    {
        field_1212_e.field_6322_g.func_9372_a_(packet8updatehealth.field_9275_a);
        field_1212_e.field_6322_g.func_35191_at().func_35764_a(packet8updatehealth.field_35231_b);
        field_1212_e.field_6322_g.func_35191_at().func_35767_b(packet8updatehealth.field_35232_c);
    }

    public void func_35777_a(Packet43Experience packet43experience)
    {
        field_1212_e.field_6322_g.func_35219_c(packet43experience.field_35230_a, packet43experience.field_35228_b, packet43experience.field_35229_c);
    }

    public void func_9448_a(Packet9Respawn packet9respawn)
    {
        if(packet9respawn.field_35244_b != field_1212_e.field_6322_g.field_4129_m || packet9respawn.field_35246_a != field_1212_e.field_6322_g.field_615_ag.func_22138_q())
        {
            field_1210_g = false;
            field_1211_f = new WorldClient(this, new WorldSettings(packet9respawn.field_35246_a, packet9respawn.field_35243_e, false, false, packet9respawn.field_46031_f), packet9respawn.field_35244_b, packet9respawn.field_35245_c);
            field_1211_f.field_1026_y = true;
            field_1212_e.func_6261_a(field_1211_f);
            field_1212_e.field_6322_g.field_4129_m = packet9respawn.field_35244_b;
            field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
        }
        field_1212_e.func_6239_p(true, packet9respawn.field_35244_b, false);
        ((PlayerControllerMP)field_1212_e.field_6327_b).func_35648_a(packet9respawn.field_35243_e == 1);
    }

    public void func_12245_a(Packet60Explosion packet60explosion)
    {
        Explosion explosion = new Explosion(field_1212_e.field_6324_e, null, packet60explosion.field_12236_a, packet60explosion.field_12235_b, packet60explosion.field_12239_c, packet60explosion.field_12238_d);
        explosion.field_12251_g = packet60explosion.field_12237_e;
        explosion.func_12247_b(true);
    }

    public void func_20087_a(Packet100OpenWindow packet100openwindow)
    {
        if(packet100openwindow.field_20037_b == 0)
        {
            InventoryBasic inventorybasic = new InventoryBasic(packet100openwindow.field_20040_c, packet100openwindow.field_20039_d);
            field_1212_e.field_6322_g.func_452_a(inventorybasic);
            field_1212_e.field_6322_g.field_20068_h.field_1618_c = packet100openwindow.field_20038_a;
        } else
        if(packet100openwindow.field_20037_b == 2)
        {
            TileEntityFurnace tileentityfurnace = new TileEntityFurnace();
            field_1212_e.field_6322_g.func_453_a(tileentityfurnace);
            field_1212_e.field_6322_g.field_20068_h.field_1618_c = packet100openwindow.field_20038_a;
        } else
        if(packet100openwindow.field_20037_b == 5)
        {
            TileEntityBrewingStand tileentitybrewingstand = new TileEntityBrewingStand();
            field_1212_e.field_6322_g.func_40180_a(tileentitybrewingstand);
            field_1212_e.field_6322_g.field_20068_h.field_1618_c = packet100openwindow.field_20038_a;
        } else
        if(packet100openwindow.field_20037_b == 3)
        {
            TileEntityDispenser tileentitydispenser = new TileEntityDispenser();
            field_1212_e.field_6322_g.func_21092_a(tileentitydispenser);
            field_1212_e.field_6322_g.field_20068_h.field_1618_c = packet100openwindow.field_20038_a;
        } else
        if(packet100openwindow.field_20037_b == 1)
        {
            EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
            field_1212_e.field_6322_g.func_445_l(MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_611_ak), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_610_al), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp)).field_609_am));
            field_1212_e.field_6322_g.field_20068_h.field_1618_c = packet100openwindow.field_20038_a;
        } else
        if(packet100openwindow.field_20037_b == 4)
        {
            EntityPlayerSP entityplayersp1 = field_1212_e.field_6322_g;
            field_1212_e.field_6322_g.func_40181_c(MathHelper.func_1108_b(((EntityPlayer) (entityplayersp1)).field_611_ak), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp1)).field_610_al), MathHelper.func_1108_b(((EntityPlayer) (entityplayersp1)).field_609_am));
            field_1212_e.field_6322_g.field_20068_h.field_1618_c = packet100openwindow.field_20038_a;
        }
    }

    public void func_20088_a(Packet103SetSlot packet103setslot)
    {
        if(packet103setslot.field_20042_a == -1)
        {
            field_1212_e.field_6322_g.field_778_b.func_20076_b(packet103setslot.field_20043_c);
        } else
        if(packet103setslot.field_20042_a == 0 && packet103setslot.field_20041_b >= 36 && packet103setslot.field_20041_b < 45)
        {
            ItemStack itemstack = field_1212_e.field_6322_g.field_20069_g.func_20118_a(packet103setslot.field_20041_b).func_777_b();
            if(packet103setslot.field_20043_c != null && (itemstack == null || itemstack.field_1615_a < packet103setslot.field_20043_c.field_1615_a))
            {
                packet103setslot.field_20043_c.field_1614_b = 5;
            }
            field_1212_e.field_6322_g.field_20069_g.func_20119_a(packet103setslot.field_20041_b, packet103setslot.field_20043_c);
        } else
        if(packet103setslot.field_20042_a == field_1212_e.field_6322_g.field_20068_h.field_1618_c)
        {
            field_1212_e.field_6322_g.field_20068_h.func_20119_a(packet103setslot.field_20041_b, packet103setslot.field_20043_c);
        }
    }

    public void func_20089_a(Packet106Transaction packet106transaction)
    {
        Container container = null;
        if(packet106transaction.field_20029_a == 0)
        {
            container = field_1212_e.field_6322_g.field_20069_g;
        } else
        if(packet106transaction.field_20029_a == field_1212_e.field_6322_g.field_20068_h.field_1618_c)
        {
            container = field_1212_e.field_6322_g.field_20068_h;
        }
        if(container != null)
        {
            if(packet106transaction.field_20030_c)
            {
                container.func_20113_a(packet106transaction.field_20028_b);
            } else
            {
                container.func_20110_b(packet106transaction.field_20028_b);
                func_847_a(new Packet106Transaction(packet106transaction.field_20029_a, packet106transaction.field_20028_b, true));
            }
        }
    }

    public void func_20094_a(Packet104WindowItems packet104windowitems)
    {
        if(packet104windowitems.field_20036_a == 0)
        {
            field_1212_e.field_6322_g.field_20069_g.func_20115_a(packet104windowitems.field_20035_b);
        } else
        if(packet104windowitems.field_20036_a == field_1212_e.field_6322_g.field_20068_h.field_1618_c)
        {
            field_1212_e.field_6322_g.field_20068_h.func_20115_a(packet104windowitems.field_20035_b);
        }
    }

    public void func_20093_a(Packet130UpdateSign packet130updatesign)
    {
        if(field_1212_e.field_6324_e.func_630_d(packet130updatesign.field_20020_a, packet130updatesign.field_20019_b, packet130updatesign.field_20022_c))
        {
            TileEntity tileentity = field_1212_e.field_6324_e.func_603_b(packet130updatesign.field_20020_a, packet130updatesign.field_20019_b, packet130updatesign.field_20022_c);
            if(tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;
                for(int i = 0; i < 4; i++)
                {
                    tileentitysign.field_826_a[i] = packet130updatesign.field_20021_d[i];
                }

                tileentitysign.func_474_j_();
            }
        }
    }

    public void func_20090_a(Packet105UpdateProgressbar packet105updateprogressbar)
    {
        func_4114_b(packet105updateprogressbar);
        if(field_1212_e.field_6322_g.field_20068_h != null && field_1212_e.field_6322_g.field_20068_h.field_1618_c == packet105updateprogressbar.field_20032_a)
        {
            field_1212_e.field_6322_g.field_20068_h.func_20112_a(packet105updateprogressbar.field_20031_b, packet105updateprogressbar.field_20033_c);
        }
    }

    public void func_843_a(Packet5PlayerInventory packet5playerinventory)
    {
        Entity entity = func_12246_a(packet5playerinventory.field_571_a);
        if(entity != null)
        {
            entity.func_20045_c(packet5playerinventory.field_21056_b, packet5playerinventory.field_570_b, packet5playerinventory.field_20044_c);
        }
    }

    public void func_20092_a(Packet101CloseWindow packet101closewindow)
    {
        field_1212_e.field_6322_g.func_20059_m();
    }

    public void func_21145_a(Packet54PlayNoteBlock packet54playnoteblock)
    {
        field_1212_e.field_6324_e.func_21116_c(packet54playnoteblock.field_21037_a, packet54playnoteblock.field_21036_b, packet54playnoteblock.field_21040_c, packet54playnoteblock.field_21039_d, packet54playnoteblock.field_21038_e);
    }

    public void func_25118_a(Packet70Bed packet70bed)
    {
        int i = packet70bed.field_25019_b;
        if(i >= 0 && i < Packet70Bed.field_25020_a.length && Packet70Bed.field_25020_a[i] != null)
        {
            field_1212_e.field_6322_g.func_22055_b(Packet70Bed.field_25020_a[i]);
        }
        if(i == 1)
        {
            field_1211_f.func_22144_v().func_27394_b(true);
            field_1211_f.func_27158_h(1.0F);
        } else
        if(i == 2)
        {
            field_1211_f.func_22144_v().func_27394_b(false);
            field_1211_f.func_27158_h(0.0F);
        } else
        if(i == 3)
        {
            ((PlayerControllerMP)field_1212_e.field_6327_b).func_35648_a(packet70bed.field_35262_c == 1);
        } else
        if(i == 4)
        {
            field_1212_e.func_6272_a(new GuiWinGame());
        }
    }

    public void func_28116_a(Packet131MapData packet131mapdata)
    {
        if(packet131mapdata.field_28055_a == Item.field_28010_bb.field_291_aS)
        {
            ItemMap.func_28013_a(packet131mapdata.field_28054_b, field_1212_e.field_6324_e).func_28171_a(packet131mapdata.field_28056_c);
        } else
        {
            System.out.println((new StringBuilder()).append("Unknown itemid: ").append(packet131mapdata.field_28054_b).toString());
        }
    }

    public void func_28115_a(Packet61DoorChange packet61doorchange)
    {
        field_1212_e.field_6324_e.func_28106_e(packet61doorchange.field_28050_a, packet61doorchange.field_28053_c, packet61doorchange.field_28052_d, packet61doorchange.field_28051_e, packet61doorchange.field_28049_b);
    }

    public void func_27245_a(Packet200Statistic packet200statistic)
    {
        ((EntityClientPlayerMP)field_1212_e.field_6322_g).func_27027_b(StatList.func_27361_a(packet200statistic.field_27052_a), packet200statistic.field_27051_b);
    }

    public void func_35780_a(Packet41EntityEffect packet41entityeffect)
    {
        Entity entity = func_12246_a(packet41entityeffect.field_35261_a);
        if(entity == null || !(entity instanceof EntityLiving))
        {
            return;
        } else
        {
            ((EntityLiving)entity).func_35165_a(new PotionEffect(packet41entityeffect.field_35259_b, packet41entityeffect.field_35258_d, packet41entityeffect.field_35260_c));
            return;
        }
    }

    public void func_35783_a(Packet42RemoveEntityEffect packet42removeentityeffect)
    {
        Entity entity = func_12246_a(packet42removeentityeffect.field_35253_a);
        if(entity == null || !(entity instanceof EntityLiving))
        {
            return;
        } else
        {
            ((EntityLiving)entity).func_36002_f(packet42removeentityeffect.field_35252_b);
            return;
        }
    }

    public boolean func_27247_c()
    {
        return false;
    }

    public void func_35779_a(Packet201PlayerInfo packet201playerinfo)
    {
        GuiSavingLevelString guisavinglevelstring = (GuiSavingLevelString)field_35787_k.get(packet201playerinfo.field_35257_a);
        if(guisavinglevelstring == null && packet201playerinfo.field_35255_b)
        {
            guisavinglevelstring = new GuiSavingLevelString(packet201playerinfo.field_35257_a);
            field_35787_k.put(packet201playerinfo.field_35257_a, guisavinglevelstring);
            field_35786_c.add(guisavinglevelstring);
        }
        if(guisavinglevelstring != null && !packet201playerinfo.field_35255_b)
        {
            field_35787_k.remove(packet201playerinfo.field_35257_a);
            field_35786_c.remove(guisavinglevelstring);
        }
        if(packet201playerinfo.field_35255_b && guisavinglevelstring != null)
        {
            guisavinglevelstring.field_35623_b = packet201playerinfo.field_35256_c;
        }
    }

    public void func_35784_a(Packet0KeepAlive packet0keepalive)
    {
        func_847_a(new Packet0KeepAlive(packet0keepalive.field_35254_a));
    }
}
