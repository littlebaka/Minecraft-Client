// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Block, World, ItemStack, EntityPlayer, 
//            InventoryPlayer, PlayerControllerCreative, EntityPlayerSP, WorldProvider, 
//            Container, Entity

public abstract class PlayerController
{

    protected final Minecraft field_1065_a;
    public boolean field_1064_b;

    public PlayerController(Minecraft minecraft)
    {
        field_1064_b = false;
        field_1065_a = minecraft;
    }

    public void func_717_a(World world)
    {
    }

    public abstract void func_719_a(int i, int j, int k, int l);

    public boolean func_729_b(int i, int j, int k, int l)
    {
        World world = field_1065_a.field_6324_e;
        Block block = Block.field_345_n[world.func_600_a(i, j, k)];
        if(block == null)
        {
            return false;
        }
        world.func_28106_e(2001, i, j, k, block.field_376_bc + world.func_602_e(i, j, k) * 256);
        int i1 = world.func_602_e(i, j, k);
        boolean flag = world.func_690_d(i, j, k, 0);
        if(block != null && flag)
        {
            block.func_252_b(world, i, j, k, i1);
        }
        return flag;
    }

    public abstract void func_6470_c(int i, int j, int k, int l);

    public abstract void func_6468_a();

    public void func_6467_a(float f)
    {
    }

    public abstract float func_727_b();

    public boolean func_6471_a(EntityPlayer entityplayer, World world, ItemStack itemstack)
    {
        int i = itemstack.field_1615_a;
        ItemStack itemstack1 = itemstack.func_1093_a(world, entityplayer);
        if(itemstack1 != itemstack || itemstack1 != null && itemstack1.field_1615_a != i)
        {
            entityplayer.field_778_b.field_843_a[entityplayer.field_778_b.field_847_d] = itemstack1;
            if(itemstack1.field_1615_a == 0)
            {
                entityplayer.field_778_b.field_843_a[entityplayer.field_778_b.field_847_d] = null;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void func_6476_a(EntityPlayer entityplayer)
    {
    }

    public void func_6474_c()
    {
    }

    public abstract boolean func_6469_d();

    public void func_6473_b(EntityPlayer entityplayer)
    {
        PlayerControllerCreative.func_35645_e(entityplayer);
    }

    public abstract boolean func_722_a(EntityPlayer entityplayer, World world, ItemStack itemstack, int i, int j, int k, int l);

    public EntityPlayer func_4087_b(World world)
    {
        return new EntityPlayerSP(field_1065_a, world, field_1065_a.field_6320_i, world.field_4209_q.field_4218_e);
    }

    public void func_6475_a(EntityPlayer entityplayer, Entity entity)
    {
        entityplayer.func_6415_a_(entity);
    }

    public void func_6472_b(EntityPlayer entityplayer, Entity entity)
    {
        entityplayer.func_463_a(entity);
    }

    public ItemStack func_27174_a(int i, int j, int k, boolean flag, EntityPlayer entityplayer)
    {
        return entityplayer.field_20068_h.func_27280_a(j, k, flag, entityplayer);
    }

    public void func_20086_a(int i, EntityPlayer entityplayer)
    {
        entityplayer.field_20068_h.func_1104_a(entityplayer);
        entityplayer.field_20068_h = entityplayer.field_20069_g;
    }

    public void func_40593_a(int i, int j)
    {
    }

    public boolean func_35643_e()
    {
        return false;
    }

    public void func_35638_c(EntityPlayer entityplayer)
    {
        entityplayer.func_35206_ab();
    }

    public boolean func_35642_f()
    {
        return false;
    }

    public boolean func_35641_g()
    {
        return true;
    }

    public boolean func_35640_h()
    {
        return false;
    }

    public boolean func_35636_i()
    {
        return false;
    }

    public void func_35637_a(ItemStack itemstack, int i)
    {
    }

    public void func_35639_a(ItemStack itemstack)
    {
    }
}
