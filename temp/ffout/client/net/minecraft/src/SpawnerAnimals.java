// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.reflect.Constructor;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, ChunkPosition, EntityPlayer, MathHelper, 
//            ChunkCoordIntPair, EnumCreatureType, ChunkCoordinates, SpawnListEntry, 
//            EntityLiving, Material, EntitySpider, EntitySkeleton, 
//            EntitySheep, BiomeGenBase, WeightedRandom, EntityZombie

public final class SpawnerAnimals
{

    private static HashMap field_6544_a = new HashMap();
    protected static final Class field_22391_a[];

    public SpawnerAnimals()
    {
    }

    protected static ChunkPosition func_4153_a(World world, int i, int j)
    {
        int k = i + world.field_1037_n.nextInt(16);
        int l = world.field_1037_n.nextInt(world.field_35472_c);
        int i1 = j + world.field_1037_n.nextInt(16);
        return new ChunkPosition(k, l, i1);
    }

    public static final int func_4154_a(World world, boolean flag, boolean flag1)
    {
        int j;
        ChunkCoordinates chunkcoordinates;
        EnumCreatureType aenumcreaturetype[];
        int i1;
        int j1;
        if(!flag && !flag1)
        {
            return 0;
        }
        field_6544_a.clear();
        for(int i = 0; i < world.field_1040_k.size(); i++)
        {
            EntityPlayer entityplayer = (EntityPlayer)world.field_1040_k.get(i);
            int k = MathHelper.func_1108_b(entityplayer.field_611_ak / 16D);
            int l = MathHelper.func_1108_b(entityplayer.field_609_am / 16D);
            byte byte0 = 8;
            for(int k1 = -byte0; k1 <= byte0; k1++)
            {
                for(int l1 = -byte0; l1 <= byte0; l1++)
                {
                    boolean flag2 = k1 == -byte0 || k1 == byte0 || l1 == -byte0 || l1 == byte0;
                    ChunkCoordIntPair chunkcoordintpair1 = new ChunkCoordIntPair(k1 + k, l1 + l);
                    if(!flag2)
                    {
                        field_6544_a.put(chunkcoordintpair1, Boolean.valueOf(false));
                        continue;
                    }
                    if(!field_6544_a.containsKey(chunkcoordintpair1))
                    {
                        field_6544_a.put(chunkcoordintpair1, Boolean.valueOf(true));
                    }
                }

            }

        }

        j = 0;
        chunkcoordinates = world.func_22137_s();
        aenumcreaturetype = EnumCreatureType.values();
        i1 = aenumcreaturetype.length;
        j1 = 0;
_L10:
        if(j1 >= i1) goto _L2; else goto _L1
_L1:
        EnumCreatureType enumcreaturetype;
        Iterator iterator;
        enumcreaturetype = aenumcreaturetype[j1];
        if(enumcreaturetype.func_21168_d() && !flag1 || !enumcreaturetype.func_21168_d() && !flag || world.func_621_b(enumcreaturetype.func_21170_a()) > (enumcreaturetype.func_21169_b() * field_6544_a.size()) / 256)
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator = field_6544_a.keySet().iterator();
_L4:
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        do
        {
            ChunkCoordIntPair chunkcoordintpair;
            do
            {
                if(!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            } while(((Boolean)field_6544_a.get(chunkcoordintpair)).booleanValue());
            ChunkPosition chunkposition = func_4153_a(world, chunkcoordintpair.field_189_a * 16, chunkcoordintpair.field_188_b * 16);
            i2 = chunkposition.field_1111_a;
            j2 = chunkposition.field_1110_b;
            k2 = chunkposition.field_1112_c;
        } while(world.func_28100_h(i2, j2, k2) || world.func_599_f(i2, j2, k2) != enumcreaturetype.func_21171_c());
        l2 = 0;
        i3 = 0;
_L9:
        if(i3 >= 3) goto _L4; else goto _L3
_L3:
        int j3;
        int k3;
        int l3;
        byte byte1;
        SpawnListEntry spawnlistentry;
        int i4;
        j3 = i2;
        k3 = j2;
        l3 = k2;
        byte1 = 6;
        spawnlistentry = null;
        i4 = 0;
_L8:
        if(i4 >= 4) goto _L6; else goto _L5
_L5:
        EntityLiving entityliving;
        j3 += world.field_1037_n.nextInt(byte1) - world.field_1037_n.nextInt(byte1);
        k3 += world.field_1037_n.nextInt(1) - world.field_1037_n.nextInt(1);
        l3 += world.field_1037_n.nextInt(byte1) - world.field_1037_n.nextInt(byte1);
        if(!func_21203_a(enumcreaturetype, world, j3, k3, l3))
        {
            continue; /* Loop/switch isn't completed */
        }
        float f = (float)j3 + 0.5F;
        float f1 = k3;
        float f2 = (float)l3 + 0.5F;
        if(world.func_683_a(f, f1, f2, 24D) != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f3 = f - (float)chunkcoordinates.field_22395_a;
        float f4 = f1 - (float)chunkcoordinates.field_22394_b;
        float f5 = f2 - (float)chunkcoordinates.field_22396_c;
        float f6 = f3 * f3 + f4 * f4 + f5 * f5;
        if(f6 < 576F)
        {
            continue; /* Loop/switch isn't completed */
        }
        if(spawnlistentry == null)
        {
            spawnlistentry = world.func_40474_a(enumcreaturetype, j3, k3, l3);
            if(spawnlistentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        try
        {
            entityliving = (EntityLiving)spawnlistentry.field_25212_a.getConstructor(new Class[] {
                net.minecraft.src.World.class
            }).newInstance(new Object[] {
                world
            });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return j;
        }
        entityliving.func_365_c(f, f1, f2, world.field_1037_n.nextFloat() * 360F, 0.0F);
        if(!entityliving.func_433_a())
        {
            break; /* Loop/switch isn't completed */
        }
        l2++;
        world.func_674_a(entityliving);
        func_21204_a(entityliving, world, f, f1, f2);
        if(l2 < entityliving.func_6391_i()) goto _L7; else goto _L4
_L7:
        j += l2;
        i4++;
          goto _L8
_L6:
        i3++;
          goto _L9
        j1++;
          goto _L10
_L2:
        return j;
    }

    private static boolean func_21203_a(EnumCreatureType enumcreaturetype, World world, int i, int j, int k)
    {
        if(enumcreaturetype.func_21171_c() == Material.field_1332_f)
        {
            return world.func_599_f(i, j, k).func_879_d() && !world.func_28100_h(i, j + 1, k);
        } else
        {
            return world.func_28100_h(i, j - 1, k) && !world.func_28100_h(i, j, k) && !world.func_599_f(i, j, k).func_879_d() && !world.func_28100_h(i, j + 1, k);
        }
    }

    private static void func_21204_a(EntityLiving entityliving, World world, float f, float f1, float f2)
    {
        if((entityliving instanceof EntitySpider) && world.field_1037_n.nextInt(100) == 0)
        {
            EntitySkeleton entityskeleton = new EntitySkeleton(world);
            entityskeleton.func_365_c(f, f1, f2, entityliving.field_605_aq, 0.0F);
            world.func_674_a(entityskeleton);
            entityskeleton.func_6377_h(entityliving);
        } else
        if(entityliving instanceof EntitySheep)
        {
            ((EntitySheep)entityliving).func_21071_b_(EntitySheep.func_21070_a(world.field_1037_n));
        }
    }

    public static void func_35957_a(World world, BiomeGenBase biomegenbase, int i, int j, int k, int l, Random random)
    {
        List list = biomegenbase.func_25063_a(EnumCreatureType.creature);
        if(list.isEmpty())
        {
            return;
        }
        while(random.nextFloat() < biomegenbase.func_4119_a()) 
        {
            SpawnListEntry spawnlistentry = (SpawnListEntry)WeightedRandom.func_35733_a(world.field_1037_n, list);
            int i1 = spawnlistentry.field_35591_b + random.nextInt((1 + spawnlistentry.field_35592_c) - spawnlistentry.field_35591_b);
            int j1 = i + random.nextInt(k);
            int k1 = j + random.nextInt(l);
            int l1 = j1;
            int i2 = k1;
            int j2 = 0;
            while(j2 < i1) 
            {
                boolean flag = false;
                for(int k2 = 0; !flag && k2 < 4; k2++)
                {
                    int l2 = world.func_4083_e(j1, k1);
                    if(func_21203_a(EnumCreatureType.creature, world, j1, l2, k1))
                    {
                        float f = (float)j1 + 0.5F;
                        float f1 = l2;
                        float f2 = (float)k1 + 0.5F;
                        EntityLiving entityliving;
                        try
                        {
                            entityliving = (EntityLiving)spawnlistentry.field_25212_a.getConstructor(new Class[] {
                                net.minecraft.src.World.class
                            }).newInstance(new Object[] {
                                world
                            });
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                            continue;
                        }
                        entityliving.func_365_c(f, f1, f2, random.nextFloat() * 360F, 0.0F);
                        world.func_674_a(entityliving);
                        func_21204_a(entityliving, world, f, f1, f2);
                        flag = true;
                    }
                    j1 += random.nextInt(5) - random.nextInt(5);
                    for(k1 += random.nextInt(5) - random.nextInt(5); j1 < i || j1 >= i + k || k1 < j || k1 >= j + k; k1 = (i2 + random.nextInt(5)) - random.nextInt(5))
                    {
                        j1 = (l1 + random.nextInt(5)) - random.nextInt(5);
                    }

                }

                j2++;
            }
        }
    }

    static 
    {
        field_22391_a = (new Class[] {
            net.minecraft.src.EntitySpider.class, net.minecraft.src.EntityZombie.class, net.minecraft.src.EntitySkeleton.class
        });
    }
}
