// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, ItemStack, Block, 
//            EntityLiving, Entity

public class ItemTool extends Item
{

    private Block field_325_aX[];
    protected float field_324_aY;
    private int field_323_aZ;
    protected EnumToolMaterial field_20927_a;

    protected ItemTool(int i, int j, EnumToolMaterial enumtoolmaterial, Block ablock[])
    {
        super(i);
        field_324_aY = 4F;
        field_20927_a = enumtoolmaterial;
        field_325_aX = ablock;
        field_290_aT = 1;
        func_21013_d(enumtoolmaterial.func_21207_a());
        field_324_aY = enumtoolmaterial.func_21206_b();
        field_323_aZ = j + enumtoolmaterial.func_21205_c();
    }

    public float func_204_a(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < field_325_aX.length; i++)
        {
            if(field_325_aX[i] == block)
            {
                return field_324_aY;
            }
        }

        return 1.0F;
    }

    public boolean func_4021_a(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.func_25190_a(2, entityliving1);
        return true;
    }

    public boolean func_25008_a(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.func_25190_a(1, entityliving);
        return true;
    }

    public int func_4020_a(Entity entity)
    {
        return field_323_aZ;
    }

    public boolean func_4017_a()
    {
        return true;
    }

    public int func_40399_b()
    {
        return field_20927_a.func_40731_e();
    }
}
