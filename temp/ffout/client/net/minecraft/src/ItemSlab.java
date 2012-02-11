// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, ItemStack, BlockStep, 
//            EntityPlayer, World, StepSound

public class ItemSlab extends ItemBlock
{

    public ItemSlab(int i)
    {
        super(i);
        func_21013_d(0);
        func_21015_a(true);
    }

    public int func_27009_a(int i)
    {
        return Block.field_410_al.func_232_a(2, i);
    }

    public int func_21012_a(int i)
    {
        return i;
    }

    public String func_21011_b(ItemStack itemstack)
    {
        int i = itemstack.func_21181_i();
        if(i < 0 || i >= BlockStep.field_22037_a.length)
        {
            i = 0;
        }
        return (new StringBuilder()).append(super.func_20009_a()).append(".").append(BlockStep.field_22037_a[i]).toString();
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l == 1);
        if(itemstack.field_1615_a == 0)
        {
            return false;
        }
        if(!entityplayer.func_35190_e(i, j, k))
        {
            return false;
        }
        int i1 = world.func_600_a(i, j, k);
        int j1 = world.func_602_e(i, j, k);
        if(l == 1 && i1 == Block.field_410_al.field_376_bc && j1 == itemstack.func_21181_i())
        {
            if(world.func_688_b(i, j, k, Block.field_411_ak.field_376_bc, j1))
            {
                world.func_684_a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, Block.field_411_ak.field_358_bl.func_1145_d(), (Block.field_411_ak.field_358_bl.func_1147_b() + 1.0F) / 2.0F, Block.field_411_ak.field_358_bl.func_1144_c() * 0.8F);
                itemstack.field_1615_a--;
            }
            return true;
        } else
        {
            return super.func_192_a(itemstack, entityplayer, world, i, j, k, l);
        }
    }
}
