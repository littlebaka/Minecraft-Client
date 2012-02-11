// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, World, EntityPlayer, Block, 
//            BlockEndPortalFrame, ItemStack, Direction, MovingObjectPosition, 
//            EnumMovingObjectType, EntityEnderEye, ChunkPosition, PlayerCapabilities

public class ItemEnderEye extends Item
{

    public ItemEnderEye(int i)
    {
        super(i);
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        int i1 = world.func_600_a(i, j, k);
        int j1 = world.func_602_e(i, j, k);
        if(entityplayer.func_35190_e(i, j, k) && i1 == Block.field_40202_bJ.field_376_bc && !BlockEndPortalFrame.func_40212_d(j1))
        {
            if(world.field_1026_y)
            {
                return true;
            }
            world.func_691_b(i, j, k, j1 + 4);
            itemstack.field_1615_a--;
            for(int k1 = 0; k1 < 16; k1++)
            {
                double d = (float)i + (5F + field_4015_b.nextFloat() * 6F) / 16F;
                double d1 = (float)j + 0.8125F;
                double d2 = (float)k + (5F + field_4015_b.nextFloat() * 6F) / 16F;
                double d3 = 0.0D;
                double d4 = 0.0D;
                double d5 = 0.0D;
                world.func_694_a("smoke", d, d1, d2, d3, d4, d5);
            }

            int l1 = j1 & 3;
            int i2 = 0;
            int j2 = 0;
            boolean flag = false;
            boolean flag1 = true;
            int k2 = Direction.field_35867_f[l1];
            for(int l2 = -2; l2 <= 2; l2++)
            {
                int l3 = i + Direction.field_35871_a[k2] * l2;
                int l4 = k + Direction.field_35870_b[k2] * l2;
                int l5 = world.func_600_a(l3, j, l4);
                if(l5 != Block.field_40202_bJ.field_376_bc)
                {
                    continue;
                }
                int l6 = world.func_602_e(l3, j, l4);
                if(!BlockEndPortalFrame.func_40212_d(l6))
                {
                    flag1 = false;
                    break;
                }
                if(!flag)
                {
                    i2 = l2;
                    j2 = l2;
                    flag = true;
                } else
                {
                    j2 = l2;
                }
            }

            if(flag1 && j2 == i2 + 2)
            {
                int i3 = i2;
                do
                {
                    if(i3 > j2)
                    {
                        break;
                    }
                    int i4 = i + Direction.field_35871_a[k2] * i3;
                    int i5 = k + Direction.field_35870_b[k2] * i3;
                    i4 += Direction.field_35871_a[l1] * 4;
                    i5 += Direction.field_35870_b[l1] * 4;
                    int i6 = world.func_600_a(i4, j, i5);
                    int i7 = world.func_602_e(i4, j, i5);
                    if(i6 != Block.field_40202_bJ.field_376_bc || !BlockEndPortalFrame.func_40212_d(i7))
                    {
                        flag1 = false;
                        break;
                    }
                    i3++;
                } while(true);
label0:
                for(int j3 = i2 - 1; j3 <= j2 + 1; j3 += 4)
                {
                    int j4 = 1;
                    do
                    {
                        if(j4 > 3)
                        {
                            continue label0;
                        }
                        int j5 = i + Direction.field_35871_a[k2] * j3;
                        int j6 = k + Direction.field_35870_b[k2] * j3;
                        j5 += Direction.field_35871_a[l1] * j4;
                        j6 += Direction.field_35870_b[l1] * j4;
                        int j7 = world.func_600_a(j5, j, j6);
                        int k7 = world.func_602_e(j5, j, j6);
                        if(j7 != Block.field_40202_bJ.field_376_bc || !BlockEndPortalFrame.func_40212_d(k7))
                        {
                            flag1 = false;
                            continue label0;
                        }
                        j4++;
                    } while(true);
                }

                if(flag1)
                {
                    for(int k3 = i2; k3 <= j2; k3++)
                    {
                        for(int k4 = 1; k4 <= 3; k4++)
                        {
                            int k5 = i + Direction.field_35871_a[k2] * k3;
                            int k6 = k + Direction.field_35870_b[k2] * k3;
                            k5 += Direction.field_35871_a[l1] * k4;
                            k6 += Direction.field_35870_b[l1] * k4;
                            world.func_690_d(k5, j, k6, Block.field_40209_bI.field_376_bc);
                        }

                    }

                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        MovingObjectPosition movingobjectposition = func_40402_a(world, entityplayer, false);
        if(movingobjectposition != null && movingobjectposition.field_1167_a == EnumMovingObjectType.TILE)
        {
            int i = world.func_600_a(movingobjectposition.field_1166_b, movingobjectposition.field_1172_c, movingobjectposition.field_1171_d);
            if(i == Block.field_40202_bJ.field_376_bc)
            {
                return itemstack;
            }
        }
        if(!world.field_1026_y)
        {
            ChunkPosition chunkposition = world.func_40477_b("Stronghold", (int)entityplayer.field_611_ak, (int)entityplayer.field_610_al, (int)entityplayer.field_609_am);
            if(chunkposition != null)
            {
                EntityEnderEye entityendereye = new EntityEnderEye(world, entityplayer.field_611_ak, (entityplayer.field_610_al + 1.6200000000000001D) - (double)entityplayer.field_9292_aO, entityplayer.field_609_am);
                entityendereye.func_40090_a(chunkposition.field_1111_a, chunkposition.field_1110_b, chunkposition.field_1112_c);
                world.func_674_a(entityendereye);
                world.func_623_a(entityplayer, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
                world.func_28107_a(null, 1002, (int)entityplayer.field_611_ak, (int)entityplayer.field_610_al, (int)entityplayer.field_609_am, 0);
                if(!entityplayer.field_35212_aW.field_35756_d)
                {
                    itemstack.field_1615_a--;
                }
            }
        }
        return itemstack;
    }
}
