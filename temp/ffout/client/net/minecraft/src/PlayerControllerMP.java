// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerController, PlayerControllerCreative, EntityPlayer, World, 
//            EntityPlayerSP, ItemStack, Packet14BlockDig, NetClientHandler, 
//            Block, StepSound, SoundManager, GuiIngame, 
//            RenderGlobal, InventoryPlayer, Packet16BlockItemSwitch, Packet15Place, 
//            EntityClientPlayerMP, Packet7UseEntity, Entity, Container, 
//            Packet102WindowClick, Packet108EnchantItem, Packet107CreativeSetSlot

public class PlayerControllerMP extends PlayerController
{

    private int field_9445_c;
    private int field_9444_d;
    private int field_9443_e;
    private float field_9442_f;
    private float field_1080_g;
    private float field_9441_h;
    private int field_9440_i;
    private boolean field_9439_j;
    private boolean field_35649_k;
    private NetClientHandler field_9438_k;
    private int field_1075_l;

    public PlayerControllerMP(Minecraft minecraft, NetClientHandler netclienthandler)
    {
        super(minecraft);
        field_9445_c = -1;
        field_9444_d = -1;
        field_9443_e = -1;
        field_9442_f = 0.0F;
        field_1080_g = 0.0F;
        field_9441_h = 0.0F;
        field_9440_i = 0;
        field_9439_j = false;
        field_1075_l = 0;
        field_9438_k = netclienthandler;
    }

    public void func_35648_a(boolean flag)
    {
        field_35649_k = flag;
        if(field_35649_k)
        {
            PlayerControllerCreative.func_35646_d(field_1065_a.field_6322_g);
        } else
        {
            PlayerControllerCreative.func_35645_e(field_1065_a.field_6322_g);
        }
    }

    public void func_6476_a(EntityPlayer entityplayer)
    {
        entityplayer.field_605_aq = -180F;
    }

    public boolean func_6469_d()
    {
        return !field_35649_k;
    }

    public boolean func_729_b(int i, int j, int k, int l)
    {
        if(field_35649_k)
        {
            return super.func_729_b(i, j, k, l);
        }
        int i1 = field_1065_a.field_6324_e.func_600_a(i, j, k);
        boolean flag = super.func_729_b(i, j, k, l);
        ItemStack itemstack = field_1065_a.field_6322_g.func_6416_v();
        if(itemstack != null)
        {
            itemstack.func_25191_a(i1, i, j, k, field_1065_a.field_6322_g);
            if(itemstack.field_1615_a == 0)
            {
                itemstack.func_1097_a(field_1065_a.field_6322_g);
                field_1065_a.field_6322_g.func_448_u();
            }
        }
        return flag;
    }

    public void func_719_a(int i, int j, int k, int l)
    {
        if(field_35649_k)
        {
            field_9438_k.func_847_a(new Packet14BlockDig(0, i, j, k, l));
            PlayerControllerCreative.func_35644_a(field_1065_a, this, i, j, k, l);
            field_9440_i = 5;
        } else
        if(!field_9439_j || i != field_9445_c || j != field_9444_d || k != field_9443_e)
        {
            field_9438_k.func_847_a(new Packet14BlockDig(0, i, j, k, l));
            int i1 = field_1065_a.field_6324_e.func_600_a(i, j, k);
            if(i1 > 0 && field_9442_f == 0.0F)
            {
                Block.field_345_n[i1].func_233_b(field_1065_a.field_6324_e, i, j, k, field_1065_a.field_6322_g);
            }
            if(i1 > 0 && Block.field_345_n[i1].func_225_a(field_1065_a.field_6322_g) >= 1.0F)
            {
                func_729_b(i, j, k, l);
            } else
            {
                field_9439_j = true;
                field_9445_c = i;
                field_9444_d = j;
                field_9443_e = k;
                field_9442_f = 0.0F;
                field_1080_g = 0.0F;
                field_9441_h = 0.0F;
            }
        }
    }

    public void func_6468_a()
    {
        field_9442_f = 0.0F;
        field_9439_j = false;
    }

    public void func_6470_c(int i, int j, int k, int l)
    {
        func_730_e();
        if(field_9440_i > 0)
        {
            field_9440_i--;
            return;
        }
        if(field_35649_k)
        {
            field_9440_i = 5;
            field_9438_k.func_847_a(new Packet14BlockDig(0, i, j, k, l));
            PlayerControllerCreative.func_35644_a(field_1065_a, this, i, j, k, l);
            return;
        }
        if(i == field_9445_c && j == field_9444_d && k == field_9443_e)
        {
            int i1 = field_1065_a.field_6324_e.func_600_a(i, j, k);
            if(i1 == 0)
            {
                field_9439_j = false;
                return;
            }
            Block block = Block.field_345_n[i1];
            field_9442_f += block.func_225_a(field_1065_a.field_6322_g);
            if(field_9441_h % 4F == 0.0F && block != null)
            {
                field_1065_a.field_6301_A.func_336_b(block.field_358_bl.func_1145_d(), (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, (block.field_358_bl.func_1147_b() + 1.0F) / 8F, block.field_358_bl.func_1144_c() * 0.5F);
            }
            field_9441_h++;
            if(field_9442_f >= 1.0F)
            {
                field_9439_j = false;
                field_9438_k.func_847_a(new Packet14BlockDig(2, i, j, k, l));
                func_729_b(i, j, k, l);
                field_9442_f = 0.0F;
                field_1080_g = 0.0F;
                field_9441_h = 0.0F;
                field_9440_i = 5;
            }
        } else
        {
            func_719_a(i, j, k, l);
        }
    }

    public void func_6467_a(float f)
    {
        if(field_9442_f <= 0.0F)
        {
            field_1065_a.field_6308_u.field_6446_b = 0.0F;
            field_1065_a.field_6323_f.field_1450_i = 0.0F;
        } else
        {
            float f1 = field_1080_g + (field_9442_f - field_1080_g) * f;
            field_1065_a.field_6308_u.field_6446_b = f1;
            field_1065_a.field_6323_f.field_1450_i = f1;
        }
    }

    public float func_727_b()
    {
        return !field_35649_k ? 4.5F : 5F;
    }

    public void func_717_a(World world)
    {
        super.func_717_a(world);
    }

    public void func_6474_c()
    {
        func_730_e();
        field_1080_g = field_9442_f;
        field_1065_a.field_6301_A.func_4033_c();
    }

    private void func_730_e()
    {
        int i = field_1065_a.field_6322_g.field_778_b.field_847_d;
        if(i != field_1075_l)
        {
            field_1075_l = i;
            field_9438_k.func_847_a(new Packet16BlockItemSwitch(field_1075_l));
        }
    }

    public boolean func_722_a(EntityPlayer entityplayer, World world, ItemStack itemstack, int i, int j, int k, int l)
    {
        func_730_e();
        field_9438_k.func_847_a(new Packet15Place(i, j, k, l, entityplayer.field_778_b.func_494_a()));
        int i1 = world.func_600_a(i, j, k);
        if(i1 > 0 && Block.field_345_n[i1].func_250_a(world, i, j, k, entityplayer))
        {
            return true;
        }
        if(itemstack == null)
        {
            return false;
        }
        if(field_35649_k)
        {
            int j1 = itemstack.func_21181_i();
            int k1 = itemstack.field_1615_a;
            boolean flag = itemstack.func_1090_a(entityplayer, world, i, j, k, l);
            itemstack.func_28156_b(j1);
            itemstack.field_1615_a = k1;
            return flag;
        } else
        {
            return itemstack.func_1090_a(entityplayer, world, i, j, k, l);
        }
    }

    public boolean func_6471_a(EntityPlayer entityplayer, World world, ItemStack itemstack)
    {
        func_730_e();
        field_9438_k.func_847_a(new Packet15Place(-1, -1, -1, 255, entityplayer.field_778_b.func_494_a()));
        boolean flag = super.func_6471_a(entityplayer, world, itemstack);
        return flag;
    }

    public EntityPlayer func_4087_b(World world)
    {
        return new EntityClientPlayerMP(field_1065_a, world, field_1065_a.field_6320_i, field_9438_k);
    }

    public void func_6472_b(EntityPlayer entityplayer, Entity entity)
    {
        func_730_e();
        field_9438_k.func_847_a(new Packet7UseEntity(entityplayer.field_620_ab, entity.field_620_ab, 1));
        entityplayer.func_463_a(entity);
    }

    public void func_6475_a(EntityPlayer entityplayer, Entity entity)
    {
        func_730_e();
        field_9438_k.func_847_a(new Packet7UseEntity(entityplayer.field_620_ab, entity.field_620_ab, 0));
        entityplayer.func_6415_a_(entity);
    }

    public ItemStack func_27174_a(int i, int j, int k, boolean flag, EntityPlayer entityplayer)
    {
        short word0 = entityplayer.field_20068_h.func_20111_a(entityplayer.field_778_b);
        ItemStack itemstack = super.func_27174_a(i, j, k, flag, entityplayer);
        field_9438_k.func_847_a(new Packet102WindowClick(i, j, k, flag, itemstack, word0));
        return itemstack;
    }

    public void func_40593_a(int i, int j)
    {
        field_9438_k.func_847_a(new Packet108EnchantItem(i, j));
    }

    public void func_35637_a(ItemStack itemstack, int i)
    {
        if(field_35649_k)
        {
            field_9438_k.func_847_a(new Packet107CreativeSetSlot(i, itemstack));
        }
    }

    public void func_35639_a(ItemStack itemstack)
    {
        if(field_35649_k && itemstack != null)
        {
            field_9438_k.func_847_a(new Packet107CreativeSetSlot(-1, itemstack));
        }
    }

    public void func_20086_a(int i, EntityPlayer entityplayer)
    {
        if(i == -9999)
        {
            return;
        } else
        {
            return;
        }
    }

    public void func_35638_c(EntityPlayer entityplayer)
    {
        func_730_e();
        field_9438_k.func_847_a(new Packet14BlockDig(5, 0, 0, 0, 255));
        super.func_35638_c(entityplayer);
    }

    public boolean func_35642_f()
    {
        return true;
    }

    public boolean func_35641_g()
    {
        return !field_35649_k;
    }

    public boolean func_35640_h()
    {
        return field_35649_k;
    }

    public boolean func_35636_i()
    {
        return field_35649_k;
    }
}
