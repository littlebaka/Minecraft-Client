// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, World, Packet130UpdateSign, 
//            TileEntitySign, NetClientHandler, Block, TileEntityRenderer, 
//            ChatAllowedCharacters

public class GuiEditSign extends GuiScreen
{

    protected String field_999_a;
    private TileEntitySign field_1002_h;
    private int field_4189_i;
    private int field_1000_j;
    private static final String field_20083_l;

    public GuiEditSign(TileEntitySign tileentitysign)
    {
        field_999_a = "Edit sign message:";
        field_1000_j = 0;
        field_1002_h = tileentitysign;
    }

    public void func_6448_a()
    {
        field_949_e.clear();
        Keyboard.enableRepeatEvents(true);
        field_949_e.add(new GuiButton(0, field_951_c / 2 - 100, field_950_d / 4 + 120, "Done"));
    }

    public void func_6449_h()
    {
        Keyboard.enableRepeatEvents(false);
        if(field_945_b.field_6324_e.field_1026_y)
        {
            field_945_b.func_20001_q().func_847_a(new Packet130UpdateSign(field_1002_h.field_823_f, field_1002_h.field_822_g, field_1002_h.field_821_h, field_1002_h.field_826_a));
        }
    }

    public void func_570_g()
    {
        field_4189_i++;
    }

    protected void func_572_a(GuiButton guibutton)
    {
        if(!guibutton.field_937_g)
        {
            return;
        }
        if(guibutton.field_938_f == 0)
        {
            field_1002_h.func_474_j_();
            field_945_b.func_6272_a(null);
        }
    }

    protected void func_580_a(char c, int i)
    {
        if(i == 200)
        {
            field_1000_j = field_1000_j - 1 & 3;
        }
        if(i == 208 || i == 28)
        {
            field_1000_j = field_1000_j + 1 & 3;
        }
        if(i == 14 && field_1002_h.field_826_a[field_1000_j].length() > 0)
        {
            field_1002_h.field_826_a[field_1000_j] = field_1002_h.field_826_a[field_1000_j].substring(0, field_1002_h.field_826_a[field_1000_j].length() - 1);
        }
        if(field_20083_l.indexOf(c) < 0 || field_1002_h.field_826_a[field_1000_j].length() >= 15) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        field_1002_h.field_826_a;
        field_1000_j;
        JVM INSTR dup2_x1 ;
        JVM INSTR aaload ;
        append();
        c;
        append();
        toString();
        JVM INSTR aastore ;
_L2:
    }

    public void func_571_a(int i, int j, float f)
    {
        func_578_i();
        func_548_a(field_6451_g, field_999_a, field_951_c / 2, 40, 0xffffff);
        GL11.glPushMatrix();
        GL11.glTranslatef(field_951_c / 2, 0.0F, 50F);
        float f1 = 93.75F;
        GL11.glScalef(-f1, -f1, -f1);
        GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
        Block block = field_1002_h.func_478_g();
        if(block == Block.field_443_aE)
        {
            float f2 = (float)(field_1002_h.func_479_f() * 360) / 16F;
            GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
        } else
        {
            int k = field_1002_h.func_479_f();
            float f3 = 0.0F;
            if(k == 2)
            {
                f3 = 180F;
            }
            if(k == 4)
            {
                f3 = 90F;
            }
            if(k == 5)
            {
                f3 = -90F;
            }
            GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
        }
        if((field_4189_i / 6) % 2 == 0)
        {
            field_1002_h.field_825_b = field_1000_j;
        }
        TileEntityRenderer.field_1554_a.func_1032_a(field_1002_h, -0.5D, -0.75D, -0.5D, 0.0F);
        field_1002_h.field_825_b = -1;
        GL11.glPopMatrix();
        super.func_571_a(i, j, f);
    }

    static 
    {
        field_20083_l = ChatAllowedCharacters.field_20157_a;
    }
}
