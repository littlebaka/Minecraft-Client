// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, Block, ItemStack, 
//            EnumAction, EntityPlayer, EntityLiving, Entity, 
//            World

public class ItemSword extends Item
{

    private int field_319_a;
    private final EnumToolMaterial field_40439_b;

    public ItemSword(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i);
        field_40439_b = enumtoolmaterial;
        field_290_aT = 1;
        func_21013_d(enumtoolmaterial.func_21207_a());
        field_319_a = 4 + enumtoolmaterial.func_21205_c();
    }

    public float func_204_a(ItemStack itemstack, Block block)
    {
        return block.field_376_bc != Block.field_9258_W.field_376_bc ? 1.5F : 15F;
    }

    public boolean func_4021_a(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.func_25190_a(1, entityliving1);
        return true;
    }

    public boolean func_25008_a(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.func_25190_a(2, entityliving);
        return true;
    }

    public int func_4020_a(Entity entity)
    {
        return field_319_a;
    }

    public boolean func_4017_a()
    {
        return true;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.block;
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 0x11940;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
        return itemstack;
    }

    public boolean func_4018_a(Block block)
    {
        return block.field_376_bc == Block.field_9258_W.field_376_bc;
    }

    public int func_40399_b()
    {
        return field_40439_b.func_40731_e();
    }
}
