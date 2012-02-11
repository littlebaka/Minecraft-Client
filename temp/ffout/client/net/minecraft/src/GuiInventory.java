// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, EntityPlayer, AchievementList, PlayerController, 
//            GuiContainerCreative, EntityPlayerSP, FontRenderer, RenderEngine, 
//            RenderHelper, RenderManager, GuiButton, GuiAchievements, 
//            GuiStats, PotionEffect, Potion, StatCollector

public class GuiInventory extends GuiContainer
{

    private float field_976_l;
    private float field_975_m;

    public GuiInventory(EntityPlayer entityplayer)
    {
        super(entityplayer.field_20069_g);
        field_948_f = true;
        entityplayer.func_25058_a(AchievementList.field_25195_b, 1);
    }

    public void func_570_g()
    {
        if(field_945_b.field_6327_b.func_35640_h())
        {
            field_945_b.func_6272_a(new GuiContainerCreative(field_945_b.field_6322_g));
        }
    }

    public void func_6448_a()
    {
        field_949_e.clear();
        if(field_945_b.field_6327_b.func_35640_h())
        {
            field_945_b.func_6272_a(new GuiContainerCreative(field_945_b.field_6322_g));
        } else
        {
            super.func_6448_a();
            if(!field_945_b.field_6322_g.func_40118_aO().isEmpty())
            {
                field_40216_e = 160 + (field_951_c - field_971_a - 200) / 2;
            }
        }
    }

    protected void func_587_j()
    {
        field_6451_g.func_873_b("Crafting", 86, 16, 0x404040);
    }

    public void func_571_a(int i, int j, float f)
    {
        super.func_571_a(i, j, f);
        field_976_l = i;
        field_975_m = j;
    }

    protected void func_589_a(float f, int i, int j)
    {
        int k = field_945_b.field_6315_n.func_1070_a("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_945_b.field_6315_n.func_1076_b(k);
        int l = field_40216_e;
        int i1 = field_40215_f;
        func_550_b(l, i1, 0, 0, field_971_a, field_974_h);
        func_40218_g();
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(l + 51, i1 + 75, 50F);
        float f1 = 30F;
        GL11.glScalef(-f1, f1, f1);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        float f2 = field_945_b.field_6322_g.field_735_n;
        float f3 = field_945_b.field_6322_g.field_605_aq;
        float f4 = field_945_b.field_6322_g.field_604_ar;
        float f5 = (float)(l + 51) - field_976_l;
        float f6 = (float)((i1 + 75) - 50) - field_975_m;
        GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(float)Math.atan(f6 / 40F) * 20F, 1.0F, 0.0F, 0.0F);
        field_945_b.field_6322_g.field_735_n = (float)Math.atan(f5 / 40F) * 20F;
        field_945_b.field_6322_g.field_605_aq = (float)Math.atan(f5 / 40F) * 40F;
        field_945_b.field_6322_g.field_604_ar = -(float)Math.atan(f6 / 40F) * 20F;
        GL11.glTranslatef(0.0F, field_945_b.field_6322_g.field_9292_aO, 0.0F);
        RenderManager.field_1233_a.field_1225_i = 180F;
        RenderManager.field_1233_a.func_853_a(field_945_b.field_6322_g, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        field_945_b.field_6322_g.field_735_n = f2;
        field_945_b.field_6322_g.field_605_aq = f3;
        field_945_b.field_6322_g.field_604_ar = f4;
        GL11.glPopMatrix();
        RenderHelper.func_1159_a();
        GL11.glDisable(32826);
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(guibutton.field_938_f == 0)
        {
            field_945_b.func_6272_a(new GuiAchievements(field_945_b.field_25001_G));
        }
        if(guibutton.field_938_f == 1)
        {
            field_945_b.func_6272_a(new GuiStats(this, field_945_b.field_25001_G));
        }
    }

    private void func_40218_g()
    {
        int i = field_40216_e - 124;
        int j = field_40215_f;
        int k = field_945_b.field_6315_n.func_1070_a("/gui/inventory.png");
        Collection collection = field_945_b.field_6322_g.func_40118_aO();
        if(collection.isEmpty())
        {
            return;
        }
        int l = 33;
        if(collection.size() > 5)
        {
            l = 132 / (collection.size() - 1);
        }
        for(Iterator iterator = field_945_b.field_6322_g.func_40118_aO().iterator(); iterator.hasNext();)
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            Potion potion = Potion.field_35678_a[potioneffect.func_35799_a()];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            field_945_b.field_6315_n.func_1076_b(k);
            func_550_b(i, j, 0, field_974_h, 140, 32);
            if(potion.func_40617_d())
            {
                int i1 = potion.func_40611_e();
                func_550_b(i + 6, j + 7, 0 + (i1 % 8) * 18, field_974_h + 32 + (i1 / 8) * 18, 18, 18);
            }
            String s = StatCollector.func_25200_a(potion.func_40623_c());
            if(potioneffect.func_35801_c() == 1)
            {
                s = (new StringBuilder()).append(s).append(" II").toString();
            } else
            if(potioneffect.func_35801_c() == 2)
            {
                s = (new StringBuilder()).append(s).append(" III").toString();
            } else
            if(potioneffect.func_35801_c() == 3)
            {
                s = (new StringBuilder()).append(s).append(" IV").toString();
            }
            field_6451_g.func_874_a(s, i + 10 + 18, j + 6, 0xffffff);
            String s1 = Potion.func_40620_a(potioneffect);
            field_6451_g.func_874_a(s1, i + 10 + 18, j + 6 + 10, 0x7f7f7f);
            j += l;
        }

    }
}
