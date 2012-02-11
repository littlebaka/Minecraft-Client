// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntitySpider, RenderSpider, EntityCaveSpider, EntityPig, 
//            RenderPig, ModelPig, EntitySheep, RenderSheep, 
//            ModelSheep2, ModelSheep1, EntityCow, RenderCow, 
//            ModelCow, EntityMooshroom, RenderMooshroom, EntityWolf, 
//            RenderWolf, ModelWolf, EntityChicken, RenderChicken, 
//            ModelChicken, EntitySilverfish, RenderSilverfish, EntityCreeper, 
//            RenderCreeper, EntityEnderman, RenderEnderman, EntitySnowman, 
//            RenderSnowMan, EntitySkeleton, RenderBiped, ModelSkeleton, 
//            EntityBlaze, RenderBlaze, EntityZombie, ModelZombie, 
//            EntitySlime, RenderSlime, ModelSlime, EntityMagmaCube, 
//            RenderMagmaCube, EntityPlayer, RenderPlayer, EntityGiantZombie, 
//            RenderGiantZombie, EntityGhast, RenderGhast, EntitySquid, 
//            RenderSquid, ModelSquid, EntityVillager, RenderVillager, 
//            EntityLiving, RenderLiving, ModelBiped, EntityDragon, 
//            RenderDragon, EntityEnderCrystal, RenderEnderCrystal, Entity, 
//            RenderEntity, EntityPainting, RenderPainting, EntityArrow, 
//            RenderArrow, EntitySnowball, RenderSnowball, Item, 
//            EntityEnderPearl, EntityEnderEye, EntityEgg, EntityPotion, 
//            EntityFireball, RenderFireball, EntitySmallFireball, EntityItem, 
//            RenderItem, EntityXPOrb, RenderXPOrb, EntityTNTPrimed, 
//            RenderTNTPrimed, EntityFallingSand, RenderFallingSand, EntityMinecart, 
//            RenderMinecart, EntityBoat, RenderBoat, EntityFishHook, 
//            RenderFish, EntityLightningBolt, RenderLightningBolt, Render, 
//            MathHelper, World, Block, GameSettings, 
//            OpenGlHelper, FontRenderer, RenderEngine, ItemRenderer

public class RenderManager
{

    private Map field_6501_o;
    public static RenderManager field_1233_a = new RenderManager();
    private FontRenderer field_1218_p;
    public static double field_1232_b;
    public static double field_1231_c;
    public static double field_1230_d;
    public RenderEngine field_1229_e;
    public ItemRenderer field_4236_f;
    public World field_1227_g;
    public EntityLiving field_22188_h;
    public float field_1225_i;
    public float field_1224_j;
    public GameSettings field_1223_k;
    public double field_1222_l;
    public double field_1221_m;
    public double field_1220_n;

    private RenderManager()
    {
        field_6501_o = new HashMap();
        field_6501_o.put(net.minecraft.src.EntitySpider.class, new RenderSpider());
        field_6501_o.put(net.minecraft.src.EntityCaveSpider.class, new RenderSpider());
        field_6501_o.put(net.minecraft.src.EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
        field_6501_o.put(net.minecraft.src.EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        field_6501_o.put(net.minecraft.src.EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
        field_6501_o.put(net.minecraft.src.EntityMooshroom.class, new RenderMooshroom(new ModelCow(), 0.7F));
        field_6501_o.put(net.minecraft.src.EntityWolf.class, new RenderWolf(new ModelWolf(), 0.5F));
        field_6501_o.put(net.minecraft.src.EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
        field_6501_o.put(net.minecraft.src.EntitySilverfish.class, new RenderSilverfish());
        field_6501_o.put(net.minecraft.src.EntityCreeper.class, new RenderCreeper());
        field_6501_o.put(net.minecraft.src.EntityEnderman.class, new RenderEnderman());
        field_6501_o.put(net.minecraft.src.EntitySnowman.class, new RenderSnowMan());
        field_6501_o.put(net.minecraft.src.EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5F));
        field_6501_o.put(net.minecraft.src.EntityBlaze.class, new RenderBlaze());
        field_6501_o.put(net.minecraft.src.EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
        field_6501_o.put(net.minecraft.src.EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
        field_6501_o.put(net.minecraft.src.EntityMagmaCube.class, new RenderMagmaCube());
        field_6501_o.put(net.minecraft.src.EntityPlayer.class, new RenderPlayer());
        field_6501_o.put(net.minecraft.src.EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6F));
        field_6501_o.put(net.minecraft.src.EntityGhast.class, new RenderGhast());
        field_6501_o.put(net.minecraft.src.EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
        field_6501_o.put(net.minecraft.src.EntityVillager.class, new RenderVillager());
        field_6501_o.put(net.minecraft.src.EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5F));
        field_6501_o.put(net.minecraft.src.EntityDragon.class, new RenderDragon());
        field_6501_o.put(net.minecraft.src.EntityEnderCrystal.class, new RenderEnderCrystal());
        field_6501_o.put(net.minecraft.src.Entity.class, new RenderEntity());
        field_6501_o.put(net.minecraft.src.EntityPainting.class, new RenderPainting());
        field_6501_o.put(net.minecraft.src.EntityArrow.class, new RenderArrow());
        field_6501_o.put(net.minecraft.src.EntitySnowball.class, new RenderSnowball(Item.field_308_aB.func_27009_a(0)));
        field_6501_o.put(net.minecraft.src.EntityEnderPearl.class, new RenderSnowball(Item.field_35416_bo.func_27009_a(0)));
        field_6501_o.put(net.minecraft.src.EntityEnderEye.class, new RenderSnowball(Item.field_40420_bA.func_27009_a(0)));
        field_6501_o.put(net.minecraft.src.EntityEgg.class, new RenderSnowball(Item.field_296_aN.func_27009_a(0)));
        field_6501_o.put(net.minecraft.src.EntityPotion.class, new RenderSnowball(154));
        field_6501_o.put(net.minecraft.src.EntityFireball.class, new RenderFireball(2.0F));
        field_6501_o.put(net.minecraft.src.EntitySmallFireball.class, new RenderFireball(0.5F));
        field_6501_o.put(net.minecraft.src.EntityItem.class, new RenderItem());
        field_6501_o.put(net.minecraft.src.EntityXPOrb.class, new RenderXPOrb());
        field_6501_o.put(net.minecraft.src.EntityTNTPrimed.class, new RenderTNTPrimed());
        field_6501_o.put(net.minecraft.src.EntityFallingSand.class, new RenderFallingSand());
        field_6501_o.put(net.minecraft.src.EntityMinecart.class, new RenderMinecart());
        field_6501_o.put(net.minecraft.src.EntityBoat.class, new RenderBoat());
        field_6501_o.put(net.minecraft.src.EntityFishHook.class, new RenderFish());
        field_6501_o.put(net.minecraft.src.EntityLightningBolt.class, new RenderLightningBolt());
        Render render;
        for(Iterator iterator = field_6501_o.values().iterator(); iterator.hasNext(); render.func_4009_a(this))
        {
            render = (Render)iterator.next();
        }

    }

    public Render func_4117_a(Class class1)
    {
        Render render = (Render)field_6501_o.get(class1);
        if(render == null && class1 != (net.minecraft.src.Entity.class))
        {
            render = func_4117_a(class1.getSuperclass());
            field_6501_o.put(class1, render);
        }
        return render;
    }

    public Render func_855_a(Entity entity)
    {
        return func_4117_a(entity.getClass());
    }

    public void func_22187_a(World world, RenderEngine renderengine, FontRenderer fontrenderer, EntityLiving entityliving, GameSettings gamesettings, float f)
    {
        field_1227_g = world;
        field_1229_e = renderengine;
        field_1223_k = gamesettings;
        field_22188_h = entityliving;
        field_1218_p = fontrenderer;
        if(entityliving.func_22051_K())
        {
            int i = world.func_600_a(MathHelper.func_1108_b(entityliving.field_611_ak), MathHelper.func_1108_b(entityliving.field_610_al), MathHelper.func_1108_b(entityliving.field_609_am));
            if(i == Block.field_9262_S.field_376_bc)
            {
                int j = world.func_602_e(MathHelper.func_1108_b(entityliving.field_611_ak), MathHelper.func_1108_b(entityliving.field_610_al), MathHelper.func_1108_b(entityliving.field_609_am));
                int k = j & 3;
                field_1225_i = k * 90 + 180;
                field_1224_j = 0.0F;
            }
        } else
        {
            field_1225_i = entityliving.field_603_as + (entityliving.field_605_aq - entityliving.field_603_as) * f;
            field_1224_j = entityliving.field_602_at + (entityliving.field_604_ar - entityliving.field_602_at) * f;
        }
        if(gamesettings.field_1560_x == 2)
        {
            field_1225_i += 180F;
        }
        field_1222_l = entityliving.field_638_aI + (entityliving.field_611_ak - entityliving.field_638_aI) * (double)f;
        field_1221_m = entityliving.field_637_aJ + (entityliving.field_610_al - entityliving.field_637_aJ) * (double)f;
        field_1220_n = entityliving.field_636_aK + (entityliving.field_609_am - entityliving.field_636_aK) * (double)f;
    }

    public void func_854_a(Entity entity, float f)
    {
        double d = entity.field_638_aI + (entity.field_611_ak - entity.field_638_aI) * (double)f;
        double d1 = entity.field_637_aJ + (entity.field_610_al - entity.field_637_aJ) * (double)f;
        double d2 = entity.field_636_aK + (entity.field_609_am - entity.field_636_aK) * (double)f;
        float f1 = entity.field_603_as + (entity.field_605_aq - entity.field_603_as) * f;
        int i = entity.func_35115_a(f);
        if(entity.func_21062_U())
        {
            i = 0xf000f0;
        }
        int j = i % 0x10000;
        int k = i / 0x10000;
        OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        func_853_a(entity, d - field_1232_b, d1 - field_1231_c, d2 - field_1230_d, f1, f);
    }

    public void func_853_a(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        Render render = func_855_a(entity);
        if(render != null)
        {
            render.func_147_a(entity, d, d1, d2, f, f1);
            render.func_141_b(entity, d, d1, d2, f, f1);
        }
    }

    public void func_852_a(World world)
    {
        field_1227_g = world;
    }

    public double func_851_a(double d, double d1, double d2)
    {
        double d3 = d - field_1222_l;
        double d4 = d1 - field_1221_m;
        double d5 = d2 - field_1220_n;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public FontRenderer func_6500_a()
    {
        return field_1218_p;
    }

}
