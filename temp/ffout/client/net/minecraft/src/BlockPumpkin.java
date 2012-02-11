// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntitySnowman, 
//            EntityLiving, MathHelper

public class BlockPumpkin extends Block
{

    private boolean field_4072_a;

    protected BlockPumpkin(int i, int j, boolean flag)
    {
        super(i, Material.field_4261_w);
        field_378_bb = j;
        func_253_b(true);
        field_4072_a = flag;
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1)
        {
            return field_378_bb;
        }
        if(i == 0)
        {
            return field_378_bb;
        }
        int k = field_378_bb + 1 + 16;
        if(field_4072_a)
        {
            k++;
        }
        if(j == 2 && i == 2)
        {
            return k;
        }
        if(j == 3 && i == 5)
        {
            return k;
        }
        if(j == 0 && i == 3)
        {
            return k;
        }
        if(j == 1 && i == 4)
        {
            return k;
        } else
        {
            return field_378_bb + 16;
        }
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb;
        }
        if(i == 0)
        {
            return field_378_bb;
        }
        if(i == 3)
        {
            return field_378_bb + 1 + 16;
        } else
        {
            return field_378_bb + 16;
        }
    }

    public void func_235_e(World world, int i, int j, int k)
    {
        super.func_235_e(world, i, j, k);
        if(world.func_600_a(i, j - 1, k) == Block.field_426_aV.field_376_bc && world.func_600_a(i, j - 2, k) == Block.field_426_aV.field_376_bc)
        {
            if(!world.field_1026_y)
            {
                world.func_690_d(i, j, k, 0);
                world.func_690_d(i, j - 1, k, 0);
                world.func_690_d(i, j - 2, k, 0);
                EntitySnowman entitysnowman = new EntitySnowman(world);
                entitysnowman.func_365_c((double)i + 0.5D, (double)j - 1.95D, (double)k + 0.5D, 0.0F, 0.0F);
                world.func_674_a(entitysnowman);
            }
            for(int l = 0; l < 120; l++)
            {
                world.func_694_a("snowshovel", (double)i + world.field_1037_n.nextDouble(), (double)(j - 2) + world.field_1037_n.nextDouble() * 2.5D, (double)k + world.field_1037_n.nextDouble(), 0.0D, 0.0D, 0.0D);
            }

        }
    }

    public boolean func_243_a(World world, int i, int j, int k)
    {
        int l = world.func_600_a(i, j, k);
        return (l == 0 || Block.field_345_n[l].field_356_bn.func_27283_g()) && world.func_28100_h(i, j - 1, k);
    }

    public void func_4026_a(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.func_1108_b((double)((entityliving.field_605_aq * 4F) / 360F) + 2.5D) & 3;
        world.func_691_b(i, j, k, l);
    }
}
