// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, Material, Block, EntityPlayer, 
//            MathHelper, ItemStack, World

public class ItemDoor extends Item
{

    private Material field_321_a;

    public ItemDoor(int i, Material material)
    {
        super(i);
        field_321_a = material;
        field_290_aT = 1;
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(l != 1)
        {
            return false;
        }
        j++;
        Block block;
        if(field_321_a == Material.field_1335_c)
        {
            block = Block.field_442_aF;
        } else
        {
            block = Block.field_435_aM;
        }
        if(!entityplayer.func_35190_e(i, j, k) || !entityplayer.func_35190_e(i, j + 1, k))
        {
            return false;
        }
        if(!block.func_243_a(world, i, j, k))
        {
            return false;
        } else
        {
            int i1 = MathHelper.func_1108_b((double)(((entityplayer.field_605_aq + 180F) * 4F) / 360F) - 0.5D) & 3;
            func_35434_a(world, i, j, k, i1, block);
            itemstack.field_1615_a--;
            return true;
        }
    }

    public static void func_35434_a(World world, int i, int j, int k, int l, Block block)
    {
        byte byte0 = 0;
        byte byte1 = 0;
        if(l == 0)
        {
            byte1 = 1;
        }
        if(l == 1)
        {
            byte0 = -1;
        }
        if(l == 2)
        {
            byte1 = -1;
        }
        if(l == 3)
        {
            byte0 = 1;
        }
        int i1 = (world.func_28100_h(i - byte0, j, k - byte1) ? 1 : 0) + (world.func_28100_h(i - byte0, j + 1, k - byte1) ? 1 : 0);
        int j1 = (world.func_28100_h(i + byte0, j, k + byte1) ? 1 : 0) + (world.func_28100_h(i + byte0, j + 1, k + byte1) ? 1 : 0);
        boolean flag = world.func_600_a(i - byte0, j, k - byte1) == block.field_376_bc || world.func_600_a(i - byte0, j + 1, k - byte1) == block.field_376_bc;
        boolean flag1 = world.func_600_a(i + byte0, j, k + byte1) == block.field_376_bc || world.func_600_a(i + byte0, j + 1, k + byte1) == block.field_376_bc;
        boolean flag2 = false;
        if(flag && !flag1)
        {
            flag2 = true;
        } else
        if(j1 > i1)
        {
            flag2 = true;
        }
        if(flag2)
        {
            l = l - 1 & 3;
            l += 4;
        }
        world.field_1043_h = true;
        world.func_688_b(i, j, k, block.field_376_bc, l);
        world.func_688_b(i, j + 1, k, block.field_376_bc, l + 8);
        world.field_1043_h = false;
        world.func_611_g(i, j, k, block.field_376_bc);
        world.func_611_g(i, j + 1, k, block.field_376_bc);
    }
}
