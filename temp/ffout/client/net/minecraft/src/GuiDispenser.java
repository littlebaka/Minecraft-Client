// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerDispenser, FontRenderer, RenderEngine, 
//            InventoryPlayer, TileEntityDispenser

public class GuiDispenser extends GuiContainer
{

    public GuiDispenser(InventoryPlayer inventoryplayer, TileEntityDispenser tileentitydispenser)
    {
        super(new ContainerDispenser(inventoryplayer, tileentitydispenser));
    }

    protected void func_587_j()
    {
        field_6451_g.func_873_b("Dispenser", 60, 6, 0x404040);
        field_6451_g.func_873_b("Inventory", 8, (field_974_h - 96) + 2, 0x404040);
    }

    protected void func_589_a(float f, int i, int j)
    {
        int k = field_945_b.field_6315_n.func_1070_a("/gui/trap.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_945_b.field_6315_n.func_1076_b(k);
        int l = (field_951_c - field_971_a) / 2;
        int i1 = (field_950_d - field_974_h) / 2;
        func_550_b(l, i1, 0, 0, field_971_a, field_974_h);
    }
}
