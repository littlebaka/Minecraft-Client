// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerController, EntityPlayer, PlayerCapabilities, InventoryPlayer, 
//            ItemStack, Session, Block, World

public class PlayerControllerCreative extends PlayerController
{

    private int field_35647_c;

    public PlayerControllerCreative(Minecraft minecraft)
    {
        super(minecraft);
        field_1064_b = true;
    }

    public static void func_35646_d(EntityPlayer entityplayer)
    {
        entityplayer.field_35212_aW.field_35758_c = true;
        entityplayer.field_35212_aW.field_35756_d = true;
        entityplayer.field_35212_aW.field_35759_a = true;
    }

    public static void func_35645_e(EntityPlayer entityplayer)
    {
        entityplayer.field_35212_aW.field_35758_c = false;
        entityplayer.field_35212_aW.field_35757_b = false;
        entityplayer.field_35212_aW.field_35756_d = false;
        entityplayer.field_35212_aW.field_35759_a = false;
    }

    public void func_6473_b(EntityPlayer entityplayer)
    {
        func_35646_d(entityplayer);
        for(int i = 0; i < 9; i++)
        {
            if(entityplayer.field_778_b.field_843_a[i] == null)
            {
                entityplayer.field_778_b.field_843_a[i] = new ItemStack((Block)Session.field_1667_a.get(i));
            }
        }

    }

    public static void func_35644_a(Minecraft minecraft, PlayerController playercontroller, int i, int j, int k, int l)
    {
        minecraft.field_6324_e.func_612_i(minecraft.field_6322_g, i, j, k, l);
        playercontroller.func_729_b(i, j, k, l);
    }

    public boolean func_722_a(EntityPlayer entityplayer, World world, ItemStack itemstack, int i, int j, int k, int l)
    {
        int i1 = world.func_600_a(i, j, k);
        if(i1 > 0 && Block.field_345_n[i1].func_250_a(world, i, j, k, entityplayer))
        {
            return true;
        }
        if(itemstack == null)
        {
            return false;
        } else
        {
            int j1 = itemstack.func_21181_i();
            int k1 = itemstack.field_1615_a;
            boolean flag = itemstack.func_1090_a(entityplayer, world, i, j, k, l);
            itemstack.func_28156_b(j1);
            itemstack.field_1615_a = k1;
            return flag;
        }
    }

    public void func_719_a(int i, int j, int k, int l)
    {
        func_35644_a(field_1065_a, this, i, j, k, l);
        field_35647_c = 5;
    }

    public void func_6470_c(int i, int j, int k, int l)
    {
        field_35647_c--;
        if(field_35647_c <= 0)
        {
            field_35647_c = 5;
            func_35644_a(field_1065_a, this, i, j, k, l);
        }
    }

    public void func_6468_a()
    {
    }

    public boolean func_6469_d()
    {
        return false;
    }

    public void func_717_a(World world)
    {
        super.func_717_a(world);
    }

    public float func_727_b()
    {
        return 5F;
    }

    public boolean func_35641_g()
    {
        return false;
    }

    public boolean func_35640_h()
    {
        return true;
    }

    public boolean func_35636_i()
    {
        return true;
    }
}
