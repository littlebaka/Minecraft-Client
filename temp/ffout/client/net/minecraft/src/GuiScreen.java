// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, GuiButton, SoundManager, GuiParticle, 
//            Tessellator, RenderEngine, FontRenderer

public class GuiScreen extends Gui
{

    protected Minecraft field_945_b;
    public int field_951_c;
    public int field_950_d;
    protected List field_949_e;
    public boolean field_948_f;
    protected FontRenderer field_6451_g;
    public GuiParticle field_25091_h;
    private GuiButton field_946_a;

    public GuiScreen()
    {
        field_949_e = new ArrayList();
        field_948_f = false;
        field_946_a = null;
    }

    public void func_571_a(int i, int j, float f)
    {
        for(int k = 0; k < field_949_e.size(); k++)
        {
            GuiButton guibutton = (GuiButton)field_949_e.get(k);
            guibutton.func_561_a(field_945_b, i, j);
        }

    }

    protected void func_580_a(char c, int i)
    {
        if(i == 1)
        {
            field_945_b.func_6272_a(null);
            field_945_b.func_6259_e();
        }
    }

    public static String func_574_c()
    {
        try
        {
            java.awt.datatransfer.Transferable transferable = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if(transferable != null && transferable.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.stringFlavor))
            {
                String s = (String)transferable.getTransferData(java.awt.datatransfer.DataFlavor.stringFlavor);
                return s;
            }
        }
        catch(Exception exception) { }
        return null;
    }

    protected void func_565_a(int i, int j, int k)
    {
        if(k == 0)
        {
            for(int l = 0; l < field_949_e.size(); l++)
            {
                GuiButton guibutton = (GuiButton)field_949_e.get(l);
                if(guibutton.func_562_c(field_945_b, i, j))
                {
                    field_946_a = guibutton;
                    field_945_b.field_6301_A.func_337_a("random.click", 1.0F, 1.0F);
                    func_572_a(guibutton);
                }
            }

        }
    }

    protected void func_573_b(int i, int j, int k)
    {
        if(field_946_a != null && k == 0)
        {
            field_946_a.func_559_a(i, j);
            field_946_a = null;
        }
    }

    protected void func_572_a(GuiButton guibutton)
    {
    }

    public void func_6447_a(Minecraft minecraft, int i, int j)
    {
        field_25091_h = new GuiParticle(minecraft);
        field_945_b = minecraft;
        field_6451_g = minecraft.field_6314_o;
        field_951_c = i;
        field_950_d = j;
        field_949_e.clear();
        func_6448_a();
    }

    public void func_6448_a()
    {
    }

    public void func_564_d()
    {
        for(; Mouse.next(); func_566_e()) { }
        for(; Keyboard.next(); func_569_f()) { }
    }

    public void func_566_e()
    {
        if(Mouse.getEventButtonState())
        {
            int i = (Mouse.getEventX() * field_951_c) / field_945_b.field_6326_c;
            int k = field_950_d - (Mouse.getEventY() * field_950_d) / field_945_b.field_6325_d - 1;
            func_565_a(i, k, Mouse.getEventButton());
        } else
        {
            int j = (Mouse.getEventX() * field_951_c) / field_945_b.field_6326_c;
            int l = field_950_d - (Mouse.getEventY() * field_950_d) / field_945_b.field_6325_d - 1;
            func_573_b(j, l, Mouse.getEventButton());
        }
    }

    public void func_569_f()
    {
        if(Keyboard.getEventKeyState())
        {
            if(Keyboard.getEventKey() == 87)
            {
                field_945_b.func_6270_h();
                return;
            }
            func_580_a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }
    }

    public void func_570_g()
    {
    }

    public void func_6449_h()
    {
    }

    public void func_578_i()
    {
        func_567_a(0);
    }

    public void func_567_a(int i)
    {
        if(field_945_b.field_6324_e != null)
        {
            func_549_a(0, 0, field_951_c, field_950_d, 0xc0101010, 0xd0101010);
        } else
        {
            func_579_b(i);
        }
    }

    public void func_579_b(int i)
    {
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, field_945_b.field_6315_n.func_1070_a("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32F;
        tessellator.func_977_b();
        tessellator.func_990_b(0x404040);
        tessellator.func_983_a(0.0D, field_950_d, 0.0D, 0.0D, (float)field_950_d / f + (float)i);
        tessellator.func_983_a(field_951_c, field_950_d, 0.0D, (float)field_951_c / f, (float)field_950_d / f + (float)i);
        tessellator.func_983_a(field_951_c, 0.0D, 0.0D, (float)field_951_c / f, 0 + i);
        tessellator.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, 0 + i);
        tessellator.func_982_a();
    }

    public boolean func_6450_b()
    {
        return true;
    }

    public void func_568_a(boolean flag, int i)
    {
    }

    public void func_27108_j()
    {
    }
}
