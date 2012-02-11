// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, GameSettings, EnumOptions

public class GuiSlider extends GuiButton
{

    public float field_944_i;
    public boolean field_943_j;
    private EnumOptions field_942_l;

    public GuiSlider(int i, int j, int k, EnumOptions enumoptions, String s, float f)
    {
        super(i, j, k, 150, 20, s);
        field_944_i = 1.0F;
        field_943_j = false;
        field_942_l = null;
        field_942_l = enumoptions;
        field_944_i = f;
    }

    protected int func_558_a(boolean flag)
    {
        return 0;
    }

    protected void func_560_b(Minecraft minecraft, int i, int j)
    {
        if(!field_936_h)
        {
            return;
        }
        if(field_943_j)
        {
            field_944_i = (float)(i - (field_941_c + 4)) / (float)(field_935_a - 8);
            if(field_944_i < 0.0F)
            {
                field_944_i = 0.0F;
            }
            if(field_944_i > 1.0F)
            {
                field_944_i = 1.0F;
            }
            minecraft.field_6304_y.func_1048_a(field_942_l, field_944_i);
            field_939_e = minecraft.field_6304_y.func_1043_a(field_942_l);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        func_550_b(field_941_c + (int)(field_944_i * (float)(field_935_a - 8)), field_940_d, 0, 66, 4, 20);
        func_550_b(field_941_c + (int)(field_944_i * (float)(field_935_a - 8)) + 4, field_940_d, 196, 66, 4, 20);
    }

    public boolean func_562_c(Minecraft minecraft, int i, int j)
    {
        if(super.func_562_c(minecraft, i, j))
        {
            field_944_i = (float)(i - (field_941_c + 4)) / (float)(field_935_a - 8);
            if(field_944_i < 0.0F)
            {
                field_944_i = 0.0F;
            }
            if(field_944_i > 1.0F)
            {
                field_944_i = 1.0F;
            }
            minecraft.field_6304_y.func_1048_a(field_942_l, field_944_i);
            field_939_e = minecraft.field_6304_y.func_1043_a(field_942_l);
            field_943_j = true;
            return true;
        } else
        {
            return false;
        }
    }

    public void func_559_a(int i, int j)
    {
        field_943_j = false;
    }
}
