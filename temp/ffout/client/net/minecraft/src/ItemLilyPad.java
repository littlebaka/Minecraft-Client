// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemColored, MovingObjectPosition, EnumMovingObjectType, World, 
//            EntityPlayer, Material, Block, PlayerCapabilities, 
//            ItemStack

public class ItemLilyPad extends ItemColored
{

    public ItemLilyPad(int i)
    {
        super(i, false);
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        MovingObjectPosition movingobjectposition = func_40402_a(world, entityplayer, true);
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
            if(!entityplayer.func_35190_e(i, j, k))
            {
                return itemstack;
            }
            if(world.func_599_f(i, j, k) == Material.field_1332_f && world.func_602_e(i, j, k) == 0 && world.func_20084_d(i, j + 1, k))
            {
                world.func_690_d(i, j + 1, k, Block.field_40200_bA.field_376_bc);
                if(!entityplayer.field_35212_aW.field_35756_d)
                {
                    itemstack.field_1615_a--;
                }
            }
        }
        return itemstack;
    }

    public int func_27010_f(int i, int j)
    {
        return Block.field_40200_bA.func_31030_b(i);
    }
}
