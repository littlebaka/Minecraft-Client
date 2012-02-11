// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerController, EntityPlayer, World, EntityPlayerSP, 
//            Block, ItemStack, StepSound, SoundManager, 
//            GuiIngame, RenderGlobal

public class PlayerControllerSP extends PlayerController
{

    private int field_1074_c;
    private int field_1073_d;
    private int field_1072_e;
    private float field_1071_f;
    private float field_1070_g;
    private float field_1069_h;
    private int field_1068_i;

    public PlayerControllerSP(Minecraft minecraft)
    {
        super(minecraft);
        field_1074_c = -1;
        field_1073_d = -1;
        field_1072_e = -1;
        field_1071_f = 0.0F;
        field_1070_g = 0.0F;
        field_1069_h = 0.0F;
        field_1068_i = 0;
    }

    public void func_6476_a(EntityPlayer entityplayer)
    {
        entityplayer.field_605_aq = -180F;
    }

    public boolean func_6469_d()
    {
        return true;
    }

    public boolean func_729_b(int i, int j, int k, int l)
    {
        int i1 = field_1065_a.field_6324_e.func_600_a(i, j, k);
        int j1 = field_1065_a.field_6324_e.func_602_e(i, j, k);
        boolean flag = super.func_729_b(i, j, k, l);
        ItemStack itemstack = field_1065_a.field_6322_g.func_6416_v();
        boolean flag1 = field_1065_a.field_6322_g.func_454_b(Block.field_345_n[i1]);
        if(itemstack != null)
        {
            itemstack.func_25191_a(i1, i, j, k, field_1065_a.field_6322_g);
            if(itemstack.field_1615_a == 0)
            {
                itemstack.func_1097_a(field_1065_a.field_6322_g);
                field_1065_a.field_6322_g.func_448_u();
            }
        }
        if(flag && flag1)
        {
            Block.field_345_n[i1].func_220_a_(field_1065_a.field_6324_e, field_1065_a.field_6322_g, i, j, k, j1);
        }
        return flag;
    }

    public void func_719_a(int i, int j, int k, int l)
    {
        if(!field_1065_a.field_6322_g.func_35190_e(i, j, k))
        {
            return;
        }
        field_1065_a.field_6324_e.func_612_i(field_1065_a.field_6322_g, i, j, k, l);
        int i1 = field_1065_a.field_6324_e.func_600_a(i, j, k);
        if(i1 > 0 && field_1071_f == 0.0F)
        {
            Block.field_345_n[i1].func_233_b(field_1065_a.field_6324_e, i, j, k, field_1065_a.field_6322_g);
        }
        if(i1 > 0 && Block.field_345_n[i1].func_225_a(field_1065_a.field_6322_g) >= 1.0F)
        {
            func_729_b(i, j, k, l);
        }
    }

    public void func_6468_a()
    {
        field_1071_f = 0.0F;
        field_1068_i = 0;
    }

    public void func_6470_c(int i, int j, int k, int l)
    {
        if(field_1068_i > 0)
        {
            field_1068_i--;
            return;
        }
        if(i == field_1074_c && j == field_1073_d && k == field_1072_e)
        {
            int i1 = field_1065_a.field_6324_e.func_600_a(i, j, k);
            if(!field_1065_a.field_6322_g.func_35190_e(i, j, k))
            {
                return;
            }
            if(i1 == 0)
            {
                return;
            }
            Block block = Block.field_345_n[i1];
            field_1071_f += block.func_225_a(field_1065_a.field_6322_g);
            if(field_1069_h % 4F == 0.0F && block != null)
            {
                field_1065_a.field_6301_A.func_336_b(block.field_358_bl.func_1145_d(), (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, (block.field_358_bl.func_1147_b() + 1.0F) / 8F, block.field_358_bl.func_1144_c() * 0.5F);
            }
            field_1069_h++;
            if(field_1071_f >= 1.0F)
            {
                func_729_b(i, j, k, l);
                field_1071_f = 0.0F;
                field_1070_g = 0.0F;
                field_1069_h = 0.0F;
                field_1068_i = 5;
            }
        } else
        {
            field_1071_f = 0.0F;
            field_1070_g = 0.0F;
            field_1069_h = 0.0F;
            field_1074_c = i;
            field_1073_d = j;
            field_1072_e = k;
        }
    }

    public void func_6467_a(float f)
    {
        if(field_1071_f <= 0.0F)
        {
            field_1065_a.field_6308_u.field_6446_b = 0.0F;
            field_1065_a.field_6323_f.field_1450_i = 0.0F;
        } else
        {
            float f1 = field_1070_g + (field_1071_f - field_1070_g) * f;
            field_1065_a.field_6308_u.field_6446_b = f1;
            field_1065_a.field_6323_f.field_1450_i = f1;
        }
    }

    public float func_727_b()
    {
        return 4F;
    }

    public void func_717_a(World world)
    {
        super.func_717_a(world);
    }

    public EntityPlayer func_4087_b(World world)
    {
        EntityPlayer entityplayer = super.func_4087_b(world);
        return entityplayer;
    }

    public void func_6474_c()
    {
        field_1070_g = field_1071_f;
        field_1065_a.field_6301_A.func_4033_c();
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
            return itemstack.func_1090_a(entityplayer, world, i, j, k, l);
        }
    }

    public boolean func_35642_f()
    {
        return true;
    }
}
