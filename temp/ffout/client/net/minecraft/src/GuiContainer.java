// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, EntityPlayerSP, RenderHelper, OpenGlHelper, 
//            Container, Slot, InventoryPlayer, RenderItem, 
//            ItemStack, FontRenderer, EnumRarity, RenderEngine, 
//            PlayerController, GameSettings, KeyBinding

public abstract class GuiContainer extends GuiScreen
{

    protected static RenderItem field_972_j = new RenderItem();
    protected int field_971_a;
    protected int field_974_h;
    public Container field_973_i;
    protected int field_40216_e;
    protected int field_40215_f;

    public GuiContainer(Container container)
    {
        field_971_a = 176;
        field_974_h = 166;
        field_973_i = container;
    }

    public void func_6448_a()
    {
        super.func_6448_a();
        field_945_b.field_6322_g.field_20068_h = field_973_i;
        field_40216_e = (field_951_c - field_971_a) / 2;
        field_40215_f = (field_950_d - field_974_h) / 2;
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        int k = field_40216_e;
        int l = field_40215_f;
        func_589_a(f, i, j);
        RenderHelper.func_41089_c();
        GL11.glPushMatrix();
        GL11.glTranslatef(k, l, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826);
        Slot slot = null;
        int i1 = 240;
        int k1 = 240;
        OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)i1 / 1.0F, (float)k1 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        for(int j1 = 0; j1 < field_973_i.field_20122_e.size(); j1++)
        {
            Slot slot1 = (Slot)field_973_i.field_20122_e.get(j1);
            func_590_a(slot1);
            if(func_20081_a(slot1, i, j))
            {
                slot = slot1;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                int l1 = slot1.field_20006_b;
                int i2 = slot1.field_20008_c;
                func_549_a(l1, i2, l1 + 16, i2 + 16, 0x80ffffff, 0x80ffffff);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
        }

        InventoryPlayer inventoryplayer = field_945_b.field_6322_g.field_778_b;
        if(inventoryplayer.func_20075_i() != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, 32F);
            field_923_k = 200F;
            field_972_j.field_40268_b = 200F;
            field_972_j.func_161_a(field_6451_g, field_945_b.field_6315_n, inventoryplayer.func_20075_i(), i - k - 8, j - l - 8);
            field_972_j.func_164_b(field_6451_g, field_945_b.field_6315_n, inventoryplayer.func_20075_i(), i - k - 8, j - l - 8);
            field_923_k = 0.0F;
            field_972_j.field_40268_b = 0.0F;
        }
        GL11.glDisable(32826);
        RenderHelper.func_1159_a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        func_587_j();
        if(inventoryplayer.func_20075_i() == null && slot != null && slot.func_20005_c())
        {
            ItemStack itemstack = slot.func_777_b();
            List list = itemstack.func_40712_q();
            if(list.size() > 0)
            {
                int j2 = 0;
                for(int k2 = 0; k2 < list.size(); k2++)
                {
                    int i3 = field_6451_g.func_871_a((String)list.get(k2));
                    if(i3 > j2)
                    {
                        j2 = i3;
                    }
                }

                int l2 = (i - k) + 12;
                int j3 = j - l - 12;
                int k3 = j2;
                int l3 = 8;
                if(list.size() > 1)
                {
                    l3 += 2 + (list.size() - 1) * 10;
                }
                field_923_k = 300F;
                field_972_j.field_40268_b = 300F;
                int i4 = 0xf0100010;
                func_549_a(l2 - 3, j3 - 4, l2 + k3 + 3, j3 - 3, i4, i4);
                func_549_a(l2 - 3, j3 + l3 + 3, l2 + k3 + 3, j3 + l3 + 4, i4, i4);
                func_549_a(l2 - 3, j3 - 3, l2 + k3 + 3, j3 + l3 + 3, i4, i4);
                func_549_a(l2 - 4, j3 - 3, l2 - 3, j3 + l3 + 3, i4, i4);
                func_549_a(l2 + k3 + 3, j3 - 3, l2 + k3 + 4, j3 + l3 + 3, i4, i4);
                int j4 = 0x505000ff;
                int k4 = (j4 & 0xfefefe) >> 1 | j4 & 0xff000000;
                func_549_a(l2 - 3, (j3 - 3) + 1, (l2 - 3) + 1, (j3 + l3 + 3) - 1, j4, k4);
                func_549_a(l2 + k3 + 2, (j3 - 3) + 1, l2 + k3 + 3, (j3 + l3 + 3) - 1, j4, k4);
                func_549_a(l2 - 3, j3 - 3, l2 + k3 + 3, (j3 - 3) + 1, j4, j4);
                func_549_a(l2 - 3, j3 + l3 + 2, l2 + k3 + 3, j3 + l3 + 3, k4, k4);
                for(int l4 = 0; l4 < list.size(); l4++)
                {
                    String s = (String)list.get(l4);
                    if(l4 == 0)
                    {
                        s = (new StringBuilder()).append("\247").append(Integer.toHexString(itemstack.func_40707_s().field_40535_e)).append(s).toString();
                    } else
                    {
                        s = (new StringBuilder()).append("\2477").append(s).toString();
                    }
                    field_6451_g.func_874_a(s, l2, j3, -1);
                    if(l4 == 0)
                    {
                        j3 += 2;
                    }
                    j3 += 10;
                }

                field_923_k = 0.0F;
                field_972_j.field_40268_b = 0.0F;
            }
        }
        GL11.glPopMatrix();
        super.func_571_a(i, j, f);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    protected void func_587_j()
    {
    }

    protected abstract void func_589_a(float f, int i, int j);

    private void func_590_a(Slot slot)
    {
        int i = slot.field_20006_b;
        int j = slot.field_20008_c;
        ItemStack itemstack = slot.func_777_b();
        boolean flag = false;
        int k = i;
        int i1 = j;
        field_923_k = 100F;
        field_972_j.field_40268_b = 100F;
        if(itemstack == null)
        {
            int j1 = slot.func_775_c();
            if(j1 >= 0)
            {
                GL11.glDisable(2896);
                field_945_b.field_6315_n.func_1076_b(field_945_b.field_6315_n.func_1070_a("/gui/items.png"));
                func_550_b(k, i1, (j1 % 16) * 16, (j1 / 16) * 16, 16, 16);
                GL11.glEnable(2896);
                flag = true;
            }
        }
        if(!flag)
        {
            field_972_j.func_161_a(field_6451_g, field_945_b.field_6315_n, itemstack, k, i1);
            field_972_j.func_164_b(field_6451_g, field_945_b.field_6315_n, itemstack, k, i1);
        }
        field_972_j.field_40268_b = 0.0F;
        field_923_k = 0.0F;
        if(this == null)
        {
            field_923_k = 100F;
            field_972_j.field_40268_b = 100F;
            if(itemstack == null)
            {
                int l = slot.func_775_c();
                if(l >= 0)
                {
                    GL11.glDisable(2896);
                    field_945_b.field_6315_n.func_1076_b(field_945_b.field_6315_n.func_1070_a("/gui/items.png"));
                    func_550_b(i, j, (l % 16) * 16, (l / 16) * 16, 16, 16);
                    GL11.glEnable(2896);
                    flag = true;
                }
            }
            if(!flag)
            {
                field_972_j.func_161_a(field_6451_g, field_945_b.field_6315_n, itemstack, i, j);
                field_972_j.func_164_b(field_6451_g, field_945_b.field_6315_n, itemstack, i, j);
            }
            field_972_j.field_40268_b = 0.0F;
            field_923_k = 0.0F;
        }
    }

    private Slot func_588_a(int i, int j)
    {
        for(int k = 0; k < field_973_i.field_20122_e.size(); k++)
        {
            Slot slot = (Slot)field_973_i.field_20122_e.get(k);
            if(func_20081_a(slot, i, j))
            {
                return slot;
            }
        }

        return null;
    }

    protected void func_565_a(int i, int j, int k)
    {
        super.func_565_a(i, j, k);
        if(k == 0 || k == 1)
        {
            Slot slot = func_588_a(i, j);
            int l = field_40216_e;
            int i1 = field_40215_f;
            boolean flag = i < l || j < i1 || i >= l + field_971_a || j >= i1 + field_974_h;
            int j1 = -1;
            if(slot != null)
            {
                j1 = slot.field_20007_a;
            }
            if(flag)
            {
                j1 = -999;
            }
            if(j1 != -1)
            {
                boolean flag1 = j1 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                func_35309_a(slot, j1, k, flag1);
            }
        }
    }

    private boolean func_20081_a(Slot slot, int i, int j)
    {
        int k = field_40216_e;
        int l = field_40215_f;
        i -= k;
        j -= l;
        return i >= slot.field_20006_b - 1 && i < slot.field_20006_b + 16 + 1 && j >= slot.field_20008_c - 1 && j < slot.field_20008_c + 16 + 1;
    }

    protected void func_35309_a(Slot slot, int i, int j, boolean flag)
    {
        if(slot != null)
        {
            i = slot.field_20007_a;
        }
        field_945_b.field_6327_b.func_27174_a(field_973_i.field_1618_c, i, j, flag, field_945_b.field_6322_g);
    }

    protected void func_580_a(char c, int i)
    {
        if(i == 1 || i == field_945_b.field_6304_y.field_1570_o.field_1370_b)
        {
            field_945_b.field_6322_g.func_20059_m();
        }
    }

    public void func_6449_h()
    {
        if(field_945_b.field_6322_g == null)
        {
            return;
        } else
        {
            field_973_i.func_1104_a(field_945_b.field_6322_g);
            field_945_b.field_6327_b.func_20086_a(field_973_i.field_1618_c, field_945_b.field_6322_g);
            return;
        }
    }

    public boolean func_6450_b()
    {
        return false;
    }

    public void func_570_g()
    {
        super.func_570_g();
        if(!field_945_b.field_6322_g.func_354_B() || field_945_b.field_6322_g.field_646_aA)
        {
            field_945_b.field_6322_g.func_20059_m();
        }
    }

}
