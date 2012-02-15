package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

public class RenderManager
{
    private Map entityRenderMap;
    public static RenderManager instance = new RenderManager();
    private FontRenderer fontRenderer;
    public static double renderPosX;
    public static double renderPosY;
    public static double renderPosZ;
    public RenderEngine renderEngine;
    public ItemRenderer itemRenderer;
    public World worldObj;
    public EntityLiving livingPlayer;
    public float playerViewY;
    public float playerViewX;
    public GameSettings options;
    public double field_1222_l;
    public double field_1221_m;
    public double field_1220_n;

    private RenderManager()
    {
        entityRenderMap = new HashMap();
        entityRenderMap.put(net.minecraft.src.EntitySpider.class, new RenderSpider());
        entityRenderMap.put(net.minecraft.src.EntityCaveSpider.class, new RenderSpider());
        entityRenderMap.put(net.minecraft.src.EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
        entityRenderMap.put(net.minecraft.src.EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        entityRenderMap.put(net.minecraft.src.EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
        entityRenderMap.put(net.minecraft.src.EntityMooshroom.class, new RenderMooshroom(new ModelCow(), 0.7F));
        entityRenderMap.put(net.minecraft.src.EntityWolf.class, new RenderWolf(new ModelWolf(), 0.5F));
        entityRenderMap.put(net.minecraft.src.EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
        entityRenderMap.put(net.minecraft.src.EntitySilverfish.class, new RenderSilverfish());
        entityRenderMap.put(net.minecraft.src.EntityCreeper.class, new RenderCreeper());
        entityRenderMap.put(net.minecraft.src.EntityEnderman.class, new RenderEnderman());
        entityRenderMap.put(net.minecraft.src.EntitySnowman.class, new RenderSnowMan());
        entityRenderMap.put(net.minecraft.src.EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5F));
        entityRenderMap.put(net.minecraft.src.EntityBlaze.class, new RenderBlaze());
        entityRenderMap.put(net.minecraft.src.EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
        entityRenderMap.put(net.minecraft.src.EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
        entityRenderMap.put(net.minecraft.src.EntityMagmaCube.class, new RenderMagmaCube());
        entityRenderMap.put(net.minecraft.src.EntityPlayer.class, new RenderPlayer());
        entityRenderMap.put(net.minecraft.src.EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6F));
        entityRenderMap.put(net.minecraft.src.EntityGhast.class, new RenderGhast());
        entityRenderMap.put(net.minecraft.src.EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
        entityRenderMap.put(net.minecraft.src.EntityVillager.class, new RenderVillager());
        entityRenderMap.put(net.minecraft.src.EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5F));
        entityRenderMap.put(net.minecraft.src.EntityDragon.class, new RenderDragon());
        entityRenderMap.put(net.minecraft.src.EntityEnderCrystal.class, new RenderEnderCrystal());
        entityRenderMap.put(net.minecraft.src.Entity.class, new RenderEntity());
        entityRenderMap.put(net.minecraft.src.EntityPainting.class, new RenderPainting());
        entityRenderMap.put(net.minecraft.src.EntityArrow.class, new RenderArrow());
        entityRenderMap.put(net.minecraft.src.EntitySnowball.class, new RenderSnowball(Item.snowball.getIconFromDamage(0)));
        entityRenderMap.put(net.minecraft.src.EntityEnderPearl.class, new RenderSnowball(Item.enderPearl.getIconFromDamage(0)));
        entityRenderMap.put(net.minecraft.src.EntityEnderEye.class, new RenderSnowball(Item.eyeOfEnder.getIconFromDamage(0)));
        entityRenderMap.put(net.minecraft.src.EntityEgg.class, new RenderSnowball(Item.egg.getIconFromDamage(0)));
        entityRenderMap.put(net.minecraft.src.EntityPotion.class, new RenderSnowball(154));
        entityRenderMap.put(net.minecraft.src.EntityFireball.class, new RenderFireball(2.0F));
        entityRenderMap.put(net.minecraft.src.EntitySmallFireball.class, new RenderFireball(0.5F));
        entityRenderMap.put(net.minecraft.src.EntityItem.class, new RenderItem());
        entityRenderMap.put(net.minecraft.src.EntityXPOrb.class, new RenderXPOrb());
        entityRenderMap.put(net.minecraft.src.EntityTNTPrimed.class, new RenderTNTPrimed());
        entityRenderMap.put(net.minecraft.src.EntityFallingSand.class, new RenderFallingSand());
        entityRenderMap.put(net.minecraft.src.EntityMinecart.class, new RenderMinecart());
        entityRenderMap.put(net.minecraft.src.EntityBoat.class, new RenderBoat());
        entityRenderMap.put(net.minecraft.src.EntityFishHook.class, new RenderFish());
        entityRenderMap.put(net.minecraft.src.EntityLightningBolt.class, new RenderLightningBolt());
        //iCraftEvo Begin TODO
        entityRenderMap.put(net.minecraft.src.EntityDummy.class, new RenderDummy());
        //icraftEvo End
        Render render;
        for (Iterator iterator = entityRenderMap.values().iterator(); iterator.hasNext(); render.setRenderManager(this))
        {
            render = (Render)iterator.next();
        }
    }

    public Render getEntityClassRenderObject(Class class1)
    {
        Render render = (Render)entityRenderMap.get(class1);
        if (render == null && class1 != (net.minecraft.src.Entity.class))
        {
            render = getEntityClassRenderObject(class1.getSuperclass());
            entityRenderMap.put(class1, render);
        }
        return render;
    }

    public Render getEntityRenderObject(Entity entity)
    {
        return getEntityClassRenderObject(entity.getClass());
    }

    public void cacheActiveRenderInfo(World world, RenderEngine renderengine, FontRenderer fontrenderer, EntityLiving entityliving, GameSettings gamesettings, float f)
    {
        worldObj = world;
        renderEngine = renderengine;
        options = gamesettings;
        livingPlayer = entityliving;
        fontRenderer = fontrenderer;
        if (entityliving.isPlayerSleeping())
        {
            int i = world.getBlockId(MathHelper.floor_double(entityliving.posX), MathHelper.floor_double(entityliving.posY), MathHelper.floor_double(entityliving.posZ));
            if (i == Block.bed.blockID)
            {
                int j = world.getBlockMetadata(MathHelper.floor_double(entityliving.posX), MathHelper.floor_double(entityliving.posY), MathHelper.floor_double(entityliving.posZ));
                int k = j & 3;
                playerViewY = k * 90 + 180;
                playerViewX = 0.0F;
            }
        }
        else
        {
            playerViewY = entityliving.prevRotationYaw + (entityliving.rotationYaw - entityliving.prevRotationYaw) * f;
            playerViewX = entityliving.prevRotationPitch + (entityliving.rotationPitch - entityliving.prevRotationPitch) * f;
        }
        if (gamesettings.thirdPersonView == 2)
        {
            playerViewY += 180F;
        }
        field_1222_l = entityliving.lastTickPosX + (entityliving.posX - entityliving.lastTickPosX) * (double)f;
        field_1221_m = entityliving.lastTickPosY + (entityliving.posY - entityliving.lastTickPosY) * (double)f;
        field_1220_n = entityliving.lastTickPosZ + (entityliving.posZ - entityliving.lastTickPosZ) * (double)f;
    }

    public void renderEntity(Entity entity, float f)
    {
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d1 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d2 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        float f1 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f;
        int i = entity.getEntityBrightnessForRender(f);
        if (entity.isBurning())
        {
            i = 0xf000f0;
        }
        int j = i % 0x10000;
        int k = i / 0x10000;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapEnabled, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        renderEntityWithPosYaw(entity, d - renderPosX, d1 - renderPosY, d2 - renderPosZ, f1, f);
    }

    public void renderEntityWithPosYaw(Entity entity, double d, double d1, double d2,
            float f, float f1)
    {
        Render render = getEntityRenderObject(entity);
        if (render != null)
        {
            render.doRender(entity, d, d1, d2, f, f1);
            render.doRenderShadowAndFire(entity, d, d1, d2, f, f1);
        }
    }

    public void set(World world)
    {
        worldObj = world;
    }

    public double getDistanceToCamera(double d, double d1, double d2)
    {
        double d3 = d - field_1222_l;
        double d4 = d1 - field_1221_m;
        double d5 = d2 - field_1220_n;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public FontRenderer getFontRenderer()
    {
        return fontRenderer;
    }
}
