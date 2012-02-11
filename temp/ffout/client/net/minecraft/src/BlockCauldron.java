// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityPlayer, 
//            InventoryPlayer, ItemStack, Item, PlayerCapabilities, 
//            EntityItem, AxisAlignedBB

public class BlockCauldron extends Block
{

    public BlockCauldron(int i)
    {
        super(i, Material.field_1333_e);
        field_378_bb = 154;
    }

    public int func_232_a(int i, int j)
    {
        if(i == 1)
        {
            return 138;
        }
        return i != 0 ? 154 : 155;
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        float f = 0.125F;
        func_213_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        func_213_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        func_213_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        func_237_e();
    }

    public void func_237_e()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public boolean func_217_b()
    {
        return false;
    }

    public int func_210_f()
    {
        return 24;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        ItemStack itemstack = entityplayer.field_778_b.func_494_a();
        if(itemstack == null)
        {
            return true;
        }
        int l = world.func_602_e(i, j, k);
        if(itemstack.field_1617_c == Item.field_4016_av.field_291_aS)
        {
            if(l < 3)
            {
                if(!entityplayer.field_35212_aW.field_35756_d)
                {
                    entityplayer.field_778_b.func_472_a(entityplayer.field_778_b.field_847_d, new ItemStack(Item.field_262_au));
                }
                world.func_691_b(i, j, k, 3);
            }
            return true;
        }
        if(itemstack.field_1617_c == Item.field_40416_bt.field_291_aS && l > 0)
        {
            ItemStack itemstack1 = new ItemStack(Item.field_40413_bs, 1, 0);
            if(!entityplayer.field_778_b.func_504_a(itemstack1))
            {
                world.func_674_a(new EntityItem(world, (double)i + 0.5D, (double)j + 1.5D, (double)k + 0.5D, itemstack1));
            }
            itemstack.field_1615_a--;
            if(itemstack.field_1615_a <= 0)
            {
                entityplayer.field_778_b.func_472_a(entityplayer.field_778_b.field_847_d, null);
            }
            world.func_691_b(i, j, k, l - 1);
        }
        return true;
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_40408_bz.field_291_aS;
    }
}
