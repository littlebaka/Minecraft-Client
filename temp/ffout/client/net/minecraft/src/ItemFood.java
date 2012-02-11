// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, EntityPlayer, FoodStats, 
//            World, PotionEffect, EnumAction

public class ItemFood extends Item
{

    public final int field_35430_a = 32;
    private final int field_20921_a;
    private final float field_35428_c;
    private final boolean field_25013_bi;
    private boolean field_35431_bw;
    private int field_35433_bx;
    private int field_35432_by;
    private int field_35427_bz;
    private float field_35429_bA;

    public ItemFood(int i, int j, float f, boolean flag)
    {
        super(i);
        field_20921_a = j;
        field_25013_bi = flag;
        field_35428_c = f;
    }

    public ItemFood(int i, int j, boolean flag)
    {
        this(i, j, 0.6F, flag);
    }

    public ItemStack func_35413_b(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.field_1615_a--;
        entityplayer.func_35191_at().func_35761_a(this);
        world.func_623_a(entityplayer, "random.burp", 0.5F, world.field_1037_n.nextFloat() * 0.1F + 0.9F);
        if(!world.field_1026_y && field_35433_bx > 0 && world.field_1037_n.nextFloat() < field_35429_bA)
        {
            entityplayer.func_35165_a(new PotionEffect(field_35433_bx, field_35432_by * 20, field_35427_bz));
        }
        return itemstack;
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 32;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.eat;
    }

    public ItemStack func_193_a(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.func_35197_b(field_35431_bw))
        {
            entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
        }
        return itemstack;
    }

    public int func_25011_l()
    {
        return field_20921_a;
    }

    public float func_35426_m()
    {
        return field_35428_c;
    }

    public boolean func_25012_m()
    {
        return field_25013_bi;
    }

    public ItemFood func_35425_a(int i, int j, int k, float f)
    {
        field_35433_bx = i;
        field_35432_by = j;
        field_35427_bz = k;
        field_35429_bA = f;
        return this;
    }

    public ItemFood func_35424_o()
    {
        field_35431_bw = true;
        return this;
    }

    public Item func_20011_a(String s)
    {
        return super.func_20011_a(s);
    }
}
