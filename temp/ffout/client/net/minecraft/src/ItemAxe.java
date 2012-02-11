// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, Material, EnumToolMaterial, 
//            ItemStack

public class ItemAxe extends ItemTool
{

    private static Block field_327_aX[];

    protected ItemAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, field_327_aX);
    }

    public float func_204_a(ItemStack itemstack, Block block)
    {
        if(block != null && block.field_356_bn == Material.field_1335_c)
        {
            return field_324_aY;
        } else
        {
            return super.func_204_a(itemstack, block);
        }
    }

    static 
    {
        field_327_aX = (new Block[] {
            Block.field_334_y, Block.field_407_ao, Block.field_385_K, Block.field_396_av, Block.field_411_ak, Block.field_410_al, Block.field_4055_bb, Block.field_4045_bg
        });
    }
}
