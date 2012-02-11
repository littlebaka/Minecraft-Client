// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, MovingObjectPosition, EnumMovingObjectType, 
//            World, Material, PlayerCapabilities, ItemStack, 
//            WorldProvider, Block, EntityCow

public class ItemBucket extends Item
{

    private int field_331_a;

    public ItemBucket(int i, int j)
    {
        super(i);
        field_290_aT = 1;
        field_331_a = j;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        float f = 1.0F;
        double d = entityplayer.field_9285_at + (entityplayer.field_611_ak - entityplayer.field_9285_at) * (double)f;
        double d1 = (entityplayer.field_9284_au + (entityplayer.field_610_al - entityplayer.field_9284_au) * (double)f + 1.6200000000000001D) - (double)entityplayer.field_9292_aO;
        double d2 = entityplayer.field_9283_av + (entityplayer.field_609_am - entityplayer.field_9283_av) * (double)f;
        boolean flag = field_331_a == 0;
        MovingObjectPosition movingobjectposition = func_40402_a(world, entityplayer, flag);
        if(movingobjectposition == null)
        {
            return itemstack;
        }
        if(movingobjectposition.field_1167_a == EnumMovingObjectType.TILE)
        {
            int i = movingobjectposition.field_1166_b;
            int j = movingobjectposition.field_1172_c;
            int k = movingobjectposition.field_1171_d;
            if(!world.func_6466_a(entityplayer, i, j, k))
            {
                return itemstack;
            }
            if(field_331_a == 0)
            {
                if(!entityplayer.func_35190_e(i, j, k))
                {
                    return itemstack;
                }
                if(world.func_599_f(i, j, k) == Material.field_1332_f && world.func_602_e(i, j, k) == 0)
                {
                    world.func_690_d(i, j, k, 0);
                    if(entityplayer.field_35212_aW.field_35756_d)
                    {
                        return itemstack;
                    } else
                    {
                        return new ItemStack(Item.field_4016_av);
                    }
                }
                if(world.func_599_f(i, j, k) == Material.field_1331_g && world.func_602_e(i, j, k) == 0)
                {
                    world.func_690_d(i, j, k, 0);
                    if(entityplayer.field_35212_aW.field_35756_d)
                    {
                        return itemstack;
                    } else
                    {
                        return new ItemStack(Item.field_258_aw);
                    }
                }
            } else
            {
                if(field_331_a < 0)
                {
                    return new ItemStack(Item.field_262_au);
                }
                if(movingobjectposition.field_1170_e == 0)
                {
                    j--;
                }
                if(movingobjectposition.field_1170_e == 1)
                {
                    j++;
                }
                if(movingobjectposition.field_1170_e == 2)
                {
                    k--;
                }
                if(movingobjectposition.field_1170_e == 3)
                {
                    k++;
                }
                if(movingobjectposition.field_1170_e == 4)
                {
                    i--;
                }
                if(movingobjectposition.field_1170_e == 5)
                {
                    i++;
                }
                if(!entityplayer.func_35190_e(i, j, k))
                {
                    return itemstack;
                }
                if(world.func_20084_d(i, j, k) || !world.func_599_f(i, j, k).func_878_a())
                {
                    if(world.field_4209_q.field_6479_d && field_331_a == Block.field_401_B.field_376_bc)
                    {
                        world.func_684_a(d + 0.5D, d1 + 0.5D, d2 + 0.5D, "random.fizz", 0.5F, 2.6F + (world.field_1037_n.nextFloat() - world.field_1037_n.nextFloat()) * 0.8F);
                        for(int l = 0; l < 8; l++)
                        {
                            world.func_694_a("largesmoke", (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
                        }

                    } else
                    {
                        world.func_688_b(i, j, k, field_331_a, 0);
                    }
                    if(entityplayer.field_35212_aW.field_35756_d)
                    {
                        return itemstack;
                    } else
                    {
                        return new ItemStack(Item.field_262_au);
                    }
                }
            }
        } else
        if(field_331_a == 0 && (movingobjectposition.field_1168_g instanceof EntityCow))
        {
            return new ItemStack(Item.field_305_aE);
        }
        return itemstack;
    }
}
