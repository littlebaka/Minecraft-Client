// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, WorldProvider, 
//            EntityPlayer, ChunkCoordinates, EnumStatus, Direction, 
//            Item, IBlockAccess

public class BlockBed extends Block
{

    public static final int field_22033_a[][] = {
        {
            0, 1
        }, {
            -1, 0
        }, {
            0, -1
        }, {
            1, 0
        }
    };

    public BlockBed(int i)
    {
        super(i, 134, Material.field_4264_k);
        func_22027_j();
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        int l = world.func_602_e(i, j, k);
        if(!func_22032_d(l))
        {
            int i1 = func_22030_c(l);
            i += field_22033_a[i1][0];
            k += field_22033_a[i1][1];
            if(world.func_600_a(i, j, k) != field_376_bc)
            {
                return true;
            }
            l = world.func_602_e(i, j, k);
        }
        if(!world.field_4209_q.func_6477_d())
        {
            double d = (double)i + 0.5D;
            double d1 = (double)j + 0.5D;
            double d2 = (double)k + 0.5D;
            world.func_690_d(i, j, k, 0);
            int j1 = func_22030_c(l);
            i += field_22033_a[j1][0];
            k += field_22033_a[j1][1];
            if(world.func_600_a(i, j, k) == field_376_bc)
            {
                world.func_690_d(i, j, k, 0);
                d = (d + (double)i + 0.5D) / 2D;
                d1 = (d1 + (double)j + 0.5D) / 2D;
                d2 = (d2 + (double)k + 0.5D) / 2D;
            }
            world.func_12244_a(null, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, 5F, true);
            return true;
        }
        if(func_22029_f(l))
        {
            EntityPlayer entityplayer1 = null;
            Iterator iterator = world.field_1040_k.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                EntityPlayer entityplayer2 = (EntityPlayer)iterator.next();
                if(entityplayer2.func_22051_K())
                {
                    ChunkCoordinates chunkcoordinates = entityplayer2.field_21908_b;
                    if(chunkcoordinates.field_22395_a == i && chunkcoordinates.field_22394_b == j && chunkcoordinates.field_22396_c == k)
                    {
                        entityplayer1 = entityplayer2;
                    }
                }
            } while(true);
            if(entityplayer1 == null)
            {
                func_22031_a(world, i, j, k, false);
            } else
            {
                entityplayer.func_22055_b("tile.bed.occupied");
                return true;
            }
        }
        EnumStatus enumstatus = entityplayer.func_22053_b(i, j, k);
        if(enumstatus == EnumStatus.OK)
        {
            func_22031_a(world, i, j, k, true);
            return true;
        }
        if(enumstatus == EnumStatus.NOT_POSSIBLE_NOW)
        {
            entityplayer.func_22055_b("tile.bed.noSleep");
        } else
        if(enumstatus == EnumStatus.NOT_SAFE)
        {
            entityplayer.func_22055_b("tile.bed.notSafe");
        }
        return true;
    }

    public int func_232_a(int i, int j)
    {
        if(i == 0)
        {
            return Block.field_334_y.field_378_bb;
        }
        int k = func_22030_c(j);
        int l = Direction.field_22281_c[k][i];
        if(func_22032_d(j))
        {
            if(l == 2)
            {
                return field_378_bb + 2 + 16;
            }
            if(l == 5 || l == 4)
            {
                return field_378_bb + 1 + 16;
            } else
            {
                return field_378_bb + 1;
            }
        }
        if(l == 3)
        {
            return (field_378_bb - 1) + 16;
        }
        if(l == 5 || l == 4)
        {
            return field_378_bb + 16;
        } else
        {
            return field_378_bb;
        }
    }

    public int func_210_f()
    {
        return 14;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public void func_238_a(IBlockAccess iblockaccess, int i, int j, int k)
    {
        func_22027_j();
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        int i1 = world.func_602_e(i, j, k);
        int j1 = func_22030_c(i1);
        if(func_22032_d(i1))
        {
            if(world.func_600_a(i - field_22033_a[j1][0], j, k - field_22033_a[j1][1]) != field_376_bc)
            {
                world.func_690_d(i, j, k, 0);
            }
        } else
        if(world.func_600_a(i + field_22033_a[j1][0], j, k + field_22033_a[j1][1]) != field_376_bc)
        {
            world.func_690_d(i, j, k, 0);
            if(!world.field_1026_y)
            {
                func_259_b_(world, i, j, k, i1, 0);
            }
        }
    }

    public int func_240_a(int i, Random random, int j)
    {
        if(func_22032_d(i))
        {
            return 0;
        } else
        {
            return Item.field_22019_aY.field_291_aS;
        }
    }

    private void func_22027_j()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }

    public static int func_22030_c(int i)
    {
        return i & 3;
    }

    public static boolean func_22032_d(int i)
    {
        return (i & 8) != 0;
    }

    public static boolean func_22029_f(int i)
    {
        return (i & 4) != 0;
    }

    public static void func_22031_a(World world, int i, int j, int k, boolean flag)
    {
        int l = world.func_602_e(i, j, k);
        if(flag)
        {
            l |= 4;
        } else
        {
            l &= -5;
        }
        world.func_691_b(i, j, k, l);
    }

    public static ChunkCoordinates func_22028_g(World world, int i, int j, int k, int l)
    {
        int i1 = world.func_602_e(i, j, k);
        int j1 = func_22030_c(i1);
        for(int k1 = 0; k1 <= 1; k1++)
        {
            int l1 = i - field_22033_a[j1][0] * k1 - 1;
            int i2 = k - field_22033_a[j1][1] * k1 - 1;
            int j2 = l1 + 2;
            int k2 = i2 + 2;
            for(int l2 = l1; l2 <= j2; l2++)
            {
                for(int i3 = i2; i3 <= k2; i3++)
                {
                    if(!world.func_28100_h(l2, j - 1, i3) || !world.func_20084_d(l2, j, i3) || !world.func_20084_d(l2, j + 1, i3))
                    {
                        continue;
                    }
                    if(l > 0)
                    {
                        l--;
                    } else
                    {
                        return new ChunkCoordinates(l2, j, i3);
                    }
                }

            }

        }

        return null;
    }

    public void func_216_a(World world, int i, int j, int k, int l, float f, int i1)
    {
        if(!func_22032_d(l))
        {
            super.func_216_a(world, i, j, k, l, f, 0);
        }
    }

    public int func_31029_h()
    {
        return 1;
    }

}
