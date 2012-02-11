// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Block, World, EntityPlayer, 
//            ItemStack, StepSound

public class ItemReed extends Item
{

    private int field_320_a;

    public ItemReed(int i, Block block)
    {
        super(i);
        field_320_a = block.field_376_bc;
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        int i1 = world.func_600_a(i, j, k);
        if(i1 == Block.field_428_aT.field_376_bc)
        {
            l = 0;
        } else
        if(i1 != Block.field_35278_bv.field_376_bc)
        {
            if(l == 0)
            {
                j--;
            }
            if(l == 1)
            {
                j++;
            }
            if(l == 2)
            {
                k--;
            }
            if(l == 3)
            {
                k++;
            }
            if(l == 4)
            {
                i--;
            }
            if(l == 5)
            {
                i++;
            }
        }
        if(!entityplayer.func_35190_e(i, j, k))
        {
            return false;
        }
        if(itemstack.field_1615_a == 0)
        {
            return false;
        }
        if(world.func_695_a(field_320_a, i, j, k, false, l))
        {
            Block block = Block.field_345_n[field_320_a];
            if(world.func_690_d(i, j, k, field_320_a))
            {
                if(world.func_600_a(i, j, k) == field_320_a)
                {
                    Block.field_345_n[field_320_a].func_258_d(world, i, j, k, l);
                    Block.field_345_n[field_320_a].func_4026_a(world, i, j, k, entityplayer);
                }
                world.func_684_a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.field_358_bl.func_1145_d(), (block.field_358_bl.func_1147_b() + 1.0F) / 2.0F, block.field_358_bl.func_1144_c() * 0.8F);
                itemstack.field_1615_a--;
            }
        }
        return true;
    }
}
