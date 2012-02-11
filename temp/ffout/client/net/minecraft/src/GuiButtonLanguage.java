// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, RenderEngine

public class GuiButtonLanguage extends GuiButton
{

    public GuiButtonLanguage(int i, int j, int k)
    {
        super(i, j, k, 20, 20, "");
    }

    public void func_561_a(Minecraft minecraft, int i, int j)
    {
        if(!field_936_h)
        {
            return;
        }
        GL11.glBindTexture(3553, minecraft.field_6315_n.func_1070_a("/gui/gui.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = i >= field_941_c && j >= field_940_d && i < field_941_c + field_935_a && j < field_940_d + field_934_b;
        int k = 106;
        if(flag)
        {
            k += field_934_b;
        }
        func_550_b(field_941_c, field_940_d, 0, k, field_935_a, field_934_b);
    }
}
