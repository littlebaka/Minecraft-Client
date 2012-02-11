// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, TileEntityBrewingStand, World, 
//            EntityPlayer, ItemStack, EntityItem, Item, 
//            TileEntity, AxisAlignedBB

public class BlockBrewingStand extends BlockContainer
{

    private Random field_40214_a;

    public BlockBrewingStand(int i)
    {
        super(i, Material.field_1333_e);
        field_40214_a = new Random();
        field_378_bb = 157;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public int func_210_f()
    {
        return 25;
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityBrewingStand();
    }

    public boolean func_242_c()
    {
        return false;
    }

    public void func_230_a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        func_213_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
        func_237_e();
        super.func_230_a(world, i, j, k, axisalignedbb, arraylist);
    }

    public void func_237_e()
    {
        func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)world.func_603_b(i, j, k);
        if(tileentitybrewingstand != null)
        {
            entityplayer.func_40180_a(tileentitybrewingstand);
        }
        return true;
    }

    public void func_247_b(World world, int i, int j, int k, Random random)
    {
        double d = (float)i + 0.4F + random.nextFloat() * 0.2F;
        double d1 = (float)j + 0.7F + random.nextFloat() * 0.3F;
        double d2 = (float)k + 0.4F + random.nextFloat() * 0.2F;
        world.func_694_a("smoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    public void func_214_b(World world, int i, int j, int k)
    {
        TileEntity tileentity = world.func_603_b(i, j, k);
        if(tileentity != null && (tileentity instanceof TileEntityBrewingStand))
        {
            TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)tileentity;
label0:
            for(int l = 0; l < tileentitybrewingstand.func_469_c(); l++)
            {
                ItemStack itemstack = tileentitybrewingstand.func_468_c(l);
                if(itemstack == null)
                {
                    continue;
                }
                float f = field_40214_a.nextFloat() * 0.8F + 0.1F;
                float f1 = field_40214_a.nextFloat() * 0.8F + 0.1F;
                float f2 = field_40214_a.nextFloat() * 0.8F + 0.1F;
                do
                {
                    if(itemstack.field_1615_a <= 0)
                    {
                        continue label0;
                    }
                    int i1 = field_40214_a.nextInt(21) + 10;
                    if(i1 > itemstack.field_1615_a)
                    {
                        i1 = itemstack.field_1615_a;
                    }
                    itemstack.field_1615_a -= i1;
                    EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.field_1617_c, i1, itemstack.func_21181_i()));
                    float f3 = 0.05F;
                    entityitem.field_608_an = (float)field_40214_a.nextGaussian() * f3;
                    entityitem.field_607_ao = (float)field_40214_a.nextGaussian() * f3 + 0.2F;
                    entityitem.field_606_ap = (float)field_40214_a.nextGaussian() * f3;
                    world.func_674_a(entityitem);
                } while(true);
            }

        }
        super.func_214_b(world, i, j, k);
    }

    public int func_240_a(int i, Random random, int j)
    {
        return Item.field_40411_by.field_291_aS;
    }
}
