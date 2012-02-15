package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class EntityList
{
    private static Map stringToClassMapping = new HashMap();
    private static Map classToStringMapping = new HashMap();
    private static Map IDtoClassMapping = new HashMap();
    private static Map classToIDMapping = new HashMap();
    public static HashMap field_44041_a = new HashMap();

    public EntityList()
    {
    }

    private static void addMapping(Class class1, String s, int i)
    {
        stringToClassMapping.put(s, class1);
        classToStringMapping.put(class1, s);
        IDtoClassMapping.put(Integer.valueOf(i), class1);
        classToIDMapping.put(class1, Integer.valueOf(i));
    }

    private static void func_46152_a(Class class1, String s, int i, int j, int k)
    {
        addMapping(class1, s, i);
        field_44041_a.put(Integer.valueOf(i), new EntityEggInfo(i, j, k));
    }

    public static Entity createEntityInWorld(String s, World world)
    {
        Entity entity = null;
        try
        {
            Class class1 = (Class)stringToClassMapping.get(s);
            if (class1 != null)
            {
                entity = (Entity)class1.getConstructor(new Class[]
                        {
                            net.minecraft.src.World.class
                        }).newInstance(new Object[]
                                {
                                    world
                                });
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return entity;
    }

    public static Entity createEntityFromNBT(NBTTagCompound nbttagcompound, World world)
    {
        Entity entity = null;
        try
        {
            Class class1 = (Class)stringToClassMapping.get(nbttagcompound.getString("id"));
            if (class1 != null)
            {
                entity = (Entity)class1.getConstructor(new Class[]
                        {
                            net.minecraft.src.World.class
                        }).newInstance(new Object[]
                                {
                                    world
                                });
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        if (entity != null)
        {
            entity.readFromNBT(nbttagcompound);
        }
        else
        {
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(nbttagcompound.getString("id")).toString());
        }
        return entity;
    }

    public static Entity createEntity(int i, World world)
    {
        Entity entity = null;
        try
        {
            Class class1 = (Class)IDtoClassMapping.get(Integer.valueOf(i));
            if (class1 != null)
            {
                entity = (Entity)class1.getConstructor(new Class[]
                        {
                            net.minecraft.src.World.class
                        }).newInstance(new Object[]
                                {
                                    world
                                });
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        if (entity == null)
        {
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(i).toString());
        }
        return entity;
    }

    public static int getEntityID(Entity entity)
    {
        return ((Integer)classToIDMapping.get(entity.getClass())).intValue();
    }

    public static String getEntityString(Entity entity)
    {
        return (String)classToStringMapping.get(entity.getClass());
    }

    public static String func_44040_a(int i)
    {
        Class class1 = (Class)IDtoClassMapping.get(Integer.valueOf(i));
        if (class1 != null)
        {
            return (String)classToStringMapping.get(class1);
        }
        else
        {
            return null;
        }
    }

    static
    {
        addMapping(net.minecraft.src.EntityItem.class, "Item", 1);
        addMapping(net.minecraft.src.EntityXPOrb.class, "XPOrb", 2);
        addMapping(net.minecraft.src.EntityPainting.class, "Painting", 9);
        addMapping(net.minecraft.src.EntityArrow.class, "Arrow", 10);
        addMapping(net.minecraft.src.EntitySnowball.class, "Snowball", 11);
        addMapping(net.minecraft.src.EntityFireball.class, "Fireball", 12);
        addMapping(net.minecraft.src.EntitySmallFireball.class, "SmallFireball", 13);
        addMapping(net.minecraft.src.EntityEnderPearl.class, "ThrownEnderpearl", 14);
        addMapping(net.minecraft.src.EntityEnderEye.class, "EyeOfEnderSignal", 15);
        addMapping(net.minecraft.src.EntityTNTPrimed.class, "PrimedTnt", 20);
        addMapping(net.minecraft.src.EntityFallingSand.class, "FallingSand", 21);
        addMapping(net.minecraft.src.EntityMinecart.class, "Minecart", 40);
        addMapping(net.minecraft.src.EntityBoat.class, "Boat", 41);
        addMapping(net.minecraft.src.EntityLiving.class, "Mob", 48);
        addMapping(net.minecraft.src.EntityMob.class, "Monster", 49);
        func_46152_a(net.minecraft.src.EntityCreeper.class, "Creeper", 50, 0xda70b, 0);
        func_46152_a(net.minecraft.src.EntitySkeleton.class, "Skeleton", 51, 0xc1c1c1, 0x494949);
        func_46152_a(net.minecraft.src.EntitySpider.class, "Spider", 52, 0x342d27, 0xa80e0e);
        addMapping(net.minecraft.src.EntityGiantZombie.class, "Giant", 53);
        func_46152_a(net.minecraft.src.EntityZombie.class, "Zombie", 54, 44975, 0x799c65);
        func_46152_a(net.minecraft.src.EntitySlime.class, "Slime", 55, 0x51a03e, 0x7ebf6e);
        func_46152_a(net.minecraft.src.EntityGhast.class, "Ghast", 56, 0xf9f9f9, 0xbcbcbc);
        func_46152_a(net.minecraft.src.EntityPigZombie.class, "PigZombie", 57, 0xea9393, 0x4c7129);
        func_46152_a(net.minecraft.src.EntityEnderman.class, "Enderman", 58, 0x161616, 0);
        func_46152_a(net.minecraft.src.EntityCaveSpider.class, "CaveSpider", 59, 0xc424e, 0xa80e0e);
        func_46152_a(net.minecraft.src.EntitySilverfish.class, "Silverfish", 60, 0x6e6e6e, 0x303030);
        func_46152_a(net.minecraft.src.EntityBlaze.class, "Blaze", 61, 0xf6b201, 0xfff87e);
        func_46152_a(net.minecraft.src.EntityMagmaCube.class, "LavaSlime", 62, 0x340000, 0xfcfc00);
        addMapping(net.minecraft.src.EntityDragon.class, "EnderDragon", 63);
        func_46152_a(net.minecraft.src.EntityPig.class, "Pig", 90, 0xf0a5a2, 0xdb635f);
        func_46152_a(net.minecraft.src.EntitySheep.class, "Sheep", 91, 0xe7e7e7, 0xffb5b5);
        func_46152_a(net.minecraft.src.EntityCow.class, "Cow", 92, 0x443626, 0xa1a1a1);
        func_46152_a(net.minecraft.src.EntityChicken.class, "Chicken", 93, 0xa1a1a1, 0xff0000);
        func_46152_a(net.minecraft.src.EntitySquid.class, "Squid", 94, 0x223b4d, 0x708899);
        func_46152_a(net.minecraft.src.EntityWolf.class, "Wolf", 95, 0xd7d3d3, 0xceaf96);
        func_46152_a(net.minecraft.src.EntityMooshroom.class, "MushroomCow", 96, 0xa00f10, 0xb7b7b7);
        addMapping(net.minecraft.src.EntitySnowman.class, "SnowMan", 97);
        func_46152_a(net.minecraft.src.EntityVillager.class, "Villager", 120, 0x563c33, 0xbd8b72);
        addMapping(net.minecraft.src.EntityEnderCrystal.class, "EnderCrystal", 200);
        //iCraftEvo Begin TODO
        addMapping(net.minecraft.src.EntityDummy.class, "Dummy", 400);
        //iCraftEvo End
    }
}
