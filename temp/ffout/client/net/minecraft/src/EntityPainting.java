// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, EnumArt, AxisAlignedBB, World, 
//            EntityItem, ItemStack, Item, MathHelper, 
//            Material, NBTTagCompound, DamageSource

public class EntityPainting extends Entity
{

    private int field_695_c;
    public int field_691_a;
    public int field_9322_d;
    public int field_9321_e;
    public int field_9320_f;
    public EnumArt field_690_b;

    public EntityPainting(World world)
    {
        super(world);
        field_695_c = 0;
        field_691_a = 0;
        field_9292_aO = 0.0F;
        func_371_a(0.5F, 0.5F);
    }

    public EntityPainting(World world, int i, int j, int k, int l)
    {
        this(world);
        field_9322_d = i;
        field_9321_e = j;
        field_9320_f = k;
        ArrayList arraylist = new ArrayList();
        EnumArt aenumart[] = EnumArt.values();
        int i1 = aenumart.length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            EnumArt enumart = aenumart[j1];
            field_690_b = enumart;
            func_412_b(l);
            if(func_410_i())
            {
                arraylist.add(enumart);
            }
        }

        if(arraylist.size() > 0)
        {
            field_690_b = (EnumArt)arraylist.get(field_9312_bd.nextInt(arraylist.size()));
        }
        func_412_b(l);
    }

    public EntityPainting(World world, int i, int j, int k, int l, String s)
    {
        this(world);
        field_9322_d = i;
        field_9321_e = j;
        field_9320_f = k;
        EnumArt aenumart[] = EnumArt.values();
        int i1 = aenumart.length;
        int j1 = 0;
        do
        {
            if(j1 >= i1)
            {
                break;
            }
            EnumArt enumart = aenumart[j1];
            if(enumart.field_1624_y.equals(s))
            {
                field_690_b = enumart;
                break;
            }
            j1++;
        } while(true);
        func_412_b(l);
    }

    protected void func_21057_b()
    {
    }

    public void func_412_b(int i)
    {
        field_691_a = i;
        field_603_as = field_605_aq = i * 90;
        float f = field_690_b.field_1623_z;
        float f1 = field_690_b.field_1636_A;
        float f2 = field_690_b.field_1623_z;
        if(i == 0 || i == 2)
        {
            f2 = 0.5F;
        } else
        {
            f = 0.5F;
        }
        f /= 32F;
        f1 /= 32F;
        f2 /= 32F;
        float f3 = (float)field_9322_d + 0.5F;
        float f4 = (float)field_9321_e + 0.5F;
        float f5 = (float)field_9320_f + 0.5F;
        float f6 = 0.5625F;
        if(i == 0)
        {
            f5 -= f6;
        }
        if(i == 1)
        {
            f3 -= f6;
        }
        if(i == 2)
        {
            f5 += f6;
        }
        if(i == 3)
        {
            f3 += f6;
        }
        if(i == 0)
        {
            f3 -= func_411_c(field_690_b.field_1623_z);
        }
        if(i == 1)
        {
            f5 += func_411_c(field_690_b.field_1623_z);
        }
        if(i == 2)
        {
            f3 += func_411_c(field_690_b.field_1623_z);
        }
        if(i == 3)
        {
            f5 -= func_411_c(field_690_b.field_1623_z);
        }
        f4 += func_411_c(field_690_b.field_1636_A);
        func_347_a(f3, f4, f5);
        float f7 = -0.00625F;
        field_601_au.func_1165_c(f3 - f - f7, f4 - f1 - f7, f5 - f2 - f7, f3 + f + f7, f4 + f1 + f7, f5 + f2 + f7);
    }

    private float func_411_c(int i)
    {
        if(i == 32)
        {
            return 0.5F;
        }
        return i != 64 ? 0.0F : 0.5F;
    }

    public void func_370_e_()
    {
        if(field_695_c++ == 100 && !field_615_ag.field_1026_y)
        {
            field_695_c = 0;
            if(!func_410_i())
            {
                func_395_F();
                field_615_ag.func_674_a(new EntityItem(field_615_ag, field_611_ak, field_610_al, field_609_am, new ItemStack(Item.field_270_aq)));
            }
        }
    }

    public boolean func_410_i()
    {
        if(field_615_ag.func_697_a(this, field_601_au).size() > 0)
        {
            return false;
        }
        int i = field_690_b.field_1623_z / 16;
        int j = field_690_b.field_1636_A / 16;
        int k = field_9322_d;
        int l = field_9321_e;
        int i1 = field_9320_f;
        if(field_691_a == 0)
        {
            k = MathHelper.func_1108_b(field_611_ak - (double)((float)field_690_b.field_1623_z / 32F));
        }
        if(field_691_a == 1)
        {
            i1 = MathHelper.func_1108_b(field_609_am - (double)((float)field_690_b.field_1623_z / 32F));
        }
        if(field_691_a == 2)
        {
            k = MathHelper.func_1108_b(field_611_ak - (double)((float)field_690_b.field_1623_z / 32F));
        }
        if(field_691_a == 3)
        {
            i1 = MathHelper.func_1108_b(field_609_am - (double)((float)field_690_b.field_1623_z / 32F));
        }
        l = MathHelper.func_1108_b(field_610_al - (double)((float)field_690_b.field_1636_A / 32F));
        for(int j1 = 0; j1 < i; j1++)
        {
            for(int k1 = 0; k1 < j; k1++)
            {
                Material material;
                if(field_691_a == 0 || field_691_a == 2)
                {
                    material = field_615_ag.func_599_f(k + j1, l + k1, field_9320_f);
                } else
                {
                    material = field_615_ag.func_599_f(field_9322_d, l + k1, i1 + j1);
                }
                if(!material.func_878_a())
                {
                    return false;
                }
            }

        }

        List list = field_615_ag.func_659_b(this, field_601_au);
        for(int l1 = 0; l1 < list.size(); l1++)
        {
            if(list.get(l1) instanceof EntityPainting)
            {
                return false;
            }
        }

        return true;
    }

    public boolean func_401_c_()
    {
        return true;
    }

    public boolean func_396_a(DamageSource damagesource, int i)
    {
        if(!field_646_aA && !field_615_ag.field_1026_y)
        {
            func_395_F();
            func_9281_M();
            field_615_ag.func_674_a(new EntityItem(field_615_ag, field_611_ak, field_610_al, field_609_am, new ItemStack(Item.field_270_aq)));
        }
        return true;
    }

    public void func_352_a(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.func_761_a("Dir", (byte)field_691_a);
        nbttagcompound.func_754_a("Motive", field_690_b.field_1624_y);
        nbttagcompound.func_758_a("TileX", field_9322_d);
        nbttagcompound.func_758_a("TileY", field_9321_e);
        nbttagcompound.func_758_a("TileZ", field_9320_f);
    }

    public void func_357_b(NBTTagCompound nbttagcompound)
    {
        field_691_a = nbttagcompound.func_746_c("Dir");
        field_9322_d = nbttagcompound.func_756_e("TileX");
        field_9321_e = nbttagcompound.func_756_e("TileY");
        field_9320_f = nbttagcompound.func_756_e("TileZ");
        String s = nbttagcompound.func_755_i("Motive");
        EnumArt aenumart[] = EnumArt.values();
        int i = aenumart.length;
        for(int j = 0; j < i; j++)
        {
            EnumArt enumart = aenumart[j];
            if(enumart.field_1624_y.equals(s))
            {
                field_690_b = enumart;
            }
        }

        if(field_690_b == null)
        {
            field_690_b = EnumArt.Kebab;
        }
        func_412_b(field_691_a);
    }

    public void func_349_c(double d, double d1, double d2)
    {
        if(!field_615_ag.field_1026_y && d * d + d1 * d1 + d2 * d2 > 0.0D)
        {
            func_395_F();
            field_615_ag.func_674_a(new EntityItem(field_615_ag, field_611_ak, field_610_al, field_609_am, new ItemStack(Item.field_270_aq)));
        }
    }

    public void func_348_f(double d, double d1, double d2)
    {
        if(!field_615_ag.field_1026_y && d * d + d1 * d1 + d2 * d2 > 0.0D)
        {
            func_395_F();
            field_615_ag.func_674_a(new EntityItem(field_615_ag, field_611_ak, field_610_al, field_609_am, new ItemStack(Item.field_270_aq)));
        }
    }
}
