// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Block, BlockLeaves, BlockTallGrass, 
//            ItemStack, EntityLiving

public class ItemShears extends Item
{

    public ItemShears(int i)
    {
        super(i);
        func_21009_c(1);
        func_21013_d(238);
    }

    public boolean func_25008_a(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        if(i == Block.field_384_L.field_376_bc || i == Block.field_9258_W.field_376_bc || i == Block.field_9257_X.field_376_bc || i == Block.field_35278_bv.field_376_bc)
        {
            itemstack.func_25190_a(1, entityliving);
            return true;
        } else
        {
            return super.func_25008_a(itemstack, i, j, k, l, entityliving);
        }
    }

    public boolean func_4018_a(Block block)
    {
        return block.field_376_bc == Block.field_9258_W.field_376_bc;
    }

    public float func_204_a(ItemStack itemstack, Block block)
    {
        if(block.field_376_bc == Block.field_9258_W.field_376_bc || block.field_376_bc == Block.field_384_L.field_376_bc)
        {
            return 15F;
        }
        if(block.field_376_bc == Block.field_419_ac.field_376_bc)
        {
            return 5F;
        } else
        {
            return super.func_204_a(itemstack, block);
        }
    }
}
