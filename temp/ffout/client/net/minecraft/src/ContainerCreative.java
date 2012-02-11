// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Container, Block, ItemStack, Item, 
//            ItemPotion, EntityList, EntityPlayer, Slot, 
//            GuiContainerCreative, InventoryBasic

class ContainerCreative extends Container
{

    public List field_35375_a;

    public ContainerCreative(EntityPlayer entityplayer)
    {
        field_35375_a = new ArrayList();
        Block ablock[] = {
            Block.field_335_x, Block.field_338_u, Block.field_391_ax, Block.field_390_H, Block.field_388_I, Block.field_386_J, Block.field_9267_N, Block.field_433_aO, Block.field_35285_bn, Block.field_35285_bn, 
            Block.field_35285_bn, Block.field_424_aX, Block.field_389_ay, Block.field_413_ai, Block.field_412_aj, Block.field_403_A, Block.field_9266_O, Block.field_409_am, Block.field_406_ap, Block.field_410_al, 
            Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_405_aq, Block.field_4053_bc, Block.field_4051_bd, Block.field_4049_be, Block.field_385_K, 
            Block.field_385_K, Block.field_385_K, Block.field_384_L, Block.field_384_L, Block.field_384_L, Block.field_336_w, Block.field_337_v, Block.field_393_F, Block.field_9264_Q, Block.field_392_G, 
            Block.field_9258_W, Block.field_334_y, Block.field_333_z, Block.field_333_z, Block.field_333_z, Block.field_9256_Y, Block.field_383_M, Block.field_4063_aU, Block.field_426_aV, Block.field_417_ae, 
            Block.field_416_af, Block.field_415_ag, Block.field_414_ah, Block.field_425_aW, Block.field_35281_bs, Block.field_4055_bb, Block.field_4045_bg, Block.field_35278_bv, Block.field_35288_bq, Block.field_35282_br, 
            Block.field_40206_bB, Block.field_40207_bC, Block.field_40204_bD, Block.field_40203_bK, Block.field_40199_bz, Block.field_40200_bA, Block.field_9257_X, Block.field_9257_X, Block.field_396_av, Block.field_387_az, 
            Block.field_382_N, Block.field_408_an, Block.field_407_ao, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, 
            Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_9265_P, 
            Block.field_445_aC, Block.field_9263_R, Block.field_422_aZ, Block.field_9259_V, Block.field_9255_Z, Block.field_4057_ba, Block.field_35277_bw, Block.field_441_aG, Block.field_440_aH, Block.field_9261_T, 
            Block.field_9260_U, Block.field_404_ar, Block.field_4059_au, Block.field_4069_aI, Block.field_35280_bx, Block.field_35279_by, Block.field_4067_aK, Block.field_4066_aL, Block.field_4065_aN, Block.field_430_aR, 
            Block.field_4064_aS, Block.field_28033_bl, Block.field_40210_bF
        };
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 1;
        for(int l1 = 0; l1 < ablock.length; l1++)
        {
            int k2 = 0;
            if(ablock[l1] == Block.field_419_ac)
            {
                k2 = i++;
            } else
            if(ablock[l1] == Block.field_410_al)
            {
                k2 = j++;
            } else
            if(ablock[l1] == Block.field_385_K)
            {
                k2 = k++;
            } else
            if(ablock[l1] == Block.field_333_z)
            {
                k2 = l++;
            } else
            if(ablock[l1] == Block.field_35285_bn)
            {
                k2 = i1++;
            } else
            if(ablock[l1] == Block.field_9257_X)
            {
                k2 = k1++;
            } else
            if(ablock[l1] == Block.field_384_L)
            {
                k2 = j1++;
            }
            field_35375_a.add(new ItemStack(ablock[l1], 1, k2));
        }

        for(int i2 = 256; i2 < Item.field_233_c.length; i2++)
        {
            if(Item.field_233_c[i2] != null && Item.field_233_c[i2].field_291_aS != Item.field_40413_bs.field_291_aS && Item.field_233_c[i2].field_291_aS != Item.field_44019_bC.field_291_aS)
            {
                field_35375_a.add(new ItemStack(Item.field_233_c[i2]));
            }
        }

        for(int j2 = 1; j2 < 16; j2++)
        {
            field_35375_a.add(new ItemStack(Item.field_21021_aU.field_291_aS, 1, j2));
        }

        Integer integer;
        for(Iterator iterator = EntityList.field_44041_a.keySet().iterator(); iterator.hasNext(); field_35375_a.add(new ItemStack(Item.field_44019_bC.field_291_aS, 1, integer.intValue())))
        {
            integer = (Integer)iterator.next();
        }

        InventoryPlayer inventoryplayer = entityplayer.field_778_b;
        for(int l2 = 0; l2 < 9; l2++)
        {
            for(int j3 = 0; j3 < 8; j3++)
            {
                func_20117_a(new Slot(GuiContainerCreative.func_35310_g(), j3 + l2 * 8, 8 + j3 * 18, 18 + l2 * 18));
            }

        }

        for(int i3 = 0; i3 < 9; i3++)
        {
            func_20117_a(new Slot(inventoryplayer, i3, 8 + i3 * 18, 184));
        }

        func_35374_a(0.0F);
    }

    public boolean func_20120_b(EntityPlayer entityplayer)
    {
        return true;
    }

    public void func_35374_a(float f)
    {
        int i = (field_35375_a.size() / 8 - 8) + 1;
        int j = (int)((double)(f * (float)i) + 0.5D);
        if(j < 0)
        {
            j = 0;
        }
        for(int k = 0; k < 9; k++)
        {
            for(int l = 0; l < 8; l++)
            {
                int i1 = l + (k + j) * 8;
                if(i1 >= 0 && i1 < field_35375_a.size())
                {
                    GuiContainerCreative.func_35310_g().func_472_a(l + k * 8, (ItemStack)field_35375_a.get(i1));
                } else
                {
                    GuiContainerCreative.func_35310_g().func_472_a(l + k * 8, null);
                }
            }

        }

    }

    protected void func_35373_b(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
    }
}
