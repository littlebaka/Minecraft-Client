// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, EntityPlayer, World, 
//            Block, BlockGrass, StepSound, ItemStack

public class ItemHoe extends Item
{

    public ItemHoe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i);
        field_290_aT = 1;
        func_21013_d(enumtoolmaterial.func_21207_a());
    }

    public boolean func_192_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(!entityplayer.func_35190_e(i, j, k))
        {
            return false;
        }
        int i1 = world.func_600_a(i, j, k);
        int j1 = world.func_600_a(i, j + 1, k);
        if(l != 0 && j1 == 0 && i1 == Block.field_337_v.field_376_bc || i1 == Block.field_336_w.field_376_bc)
        {
            Block block = Block.field_446_aB;
            world.func_684_a((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.field_358_bl.func_1145_d(), (block.field_358_bl.func_1147_b() + 1.0F) / 2.0F, block.field_358_bl.func_1144_c() * 0.8F);
            if(world.field_1026_y)
            {
                return true;
            } else
            {
                world.func_690_d(i, j, k, block.field_376_bc);
                itemstack.func_25190_a(1, entityplayer);
                return true;
            }
        } else
        {
            return false;
        }
    }

    public boolean func_4017_a()
    {
        return true;
    }
}
