// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IProgressUpdate, MinecraftError, ScaledResolution, Tessellator, 
//            RenderEngine, FontRenderer

public class LoadingScreenRenderer
    implements IProgressUpdate
{

    private String field_1004_a;
    private Minecraft field_1003_b;
    private String field_1007_c;
    private long field_1006_d;
    private boolean field_1005_e;

    public LoadingScreenRenderer(Minecraft minecraft)
    {
        field_1004_a = "";
        field_1007_c = "";
        field_1006_d = System.currentTimeMillis();
        field_1005_e = false;
        field_1003_b = minecraft;
    }

    public void func_596_a(String s)
    {
        field_1005_e = false;
        func_597_c(s);
    }

    public void func_594_b(String s)
    {
        field_1005_e = true;
        func_597_c(field_1007_c);
    }

    public void func_597_c(String s)
    {
        if(!field_1003_b.field_6293_H)
        {
            if(field_1005_e)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        } else
        {
            field_1007_c = s;
            ScaledResolution scaledresolution = new ScaledResolution(field_1003_b.field_6304_y, field_1003_b.field_6326_c, field_1003_b.field_6325_d);
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, scaledresolution.field_25121_a, scaledresolution.field_25120_b, 0.0D, 100D, 300D);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200F);
            return;
        }
    }

    public void func_595_d(String s)
    {
        if(!field_1003_b.field_6293_H)
        {
            if(field_1005_e)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        } else
        {
            field_1006_d = 0L;
            field_1004_a = s;
            func_593_a(-1);
            field_1006_d = 0L;
            return;
        }
    }

    public void func_593_a(int i)
    {
        if(!field_1003_b.field_6293_H)
        {
            if(field_1005_e)
            {
                return;
            } else
            {
                throw new MinecraftError();
            }
        }
        long l = System.currentTimeMillis();
        if(l - field_1006_d < 20L)
        {
            return;
        }
        field_1006_d = l;
        ScaledResolution scaledresolution = new ScaledResolution(field_1003_b.field_6304_y, field_1003_b.field_6326_c, field_1003_b.field_6325_d);
        int j = scaledresolution.func_903_a();
        int k = scaledresolution.func_902_b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.field_25121_a, scaledresolution.field_25120_b, 0.0D, 100D, 300D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glClear(16640);
        Tessellator tessellator = Tessellator.field_1512_a;
        int i1 = field_1003_b.field_6315_n.func_1070_a("/gui/background.png");
        GL11.glBindTexture(3553, i1);
        float f = 32F;
        tessellator.func_977_b();
        tessellator.func_990_b(0x404040);
        tessellator.func_983_a(0.0D, k, 0.0D, 0.0D, (float)k / f);
        tessellator.func_983_a(j, k, 0.0D, (float)j / f, (float)k / f);
        tessellator.func_983_a(j, 0.0D, 0.0D, (float)j / f, 0.0D);
        tessellator.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.func_982_a();
        if(i >= 0)
        {
            byte byte0 = 100;
            byte byte1 = 2;
            int j1 = j / 2 - byte0 / 2;
            int k1 = k / 2 + 16;
            GL11.glDisable(3553);
            tessellator.func_977_b();
            tessellator.func_990_b(0x808080);
            tessellator.func_991_a(j1, k1, 0.0D);
            tessellator.func_991_a(j1, k1 + byte1, 0.0D);
            tessellator.func_991_a(j1 + byte0, k1 + byte1, 0.0D);
            tessellator.func_991_a(j1 + byte0, k1, 0.0D);
            tessellator.func_990_b(0x80ff80);
            tessellator.func_991_a(j1, k1, 0.0D);
            tessellator.func_991_a(j1, k1 + byte1, 0.0D);
            tessellator.func_991_a(j1 + i, k1 + byte1, 0.0D);
            tessellator.func_991_a(j1 + i, k1, 0.0D);
            tessellator.func_982_a();
            GL11.glEnable(3553);
        }
        field_1003_b.field_6314_o.func_874_a(field_1007_c, (j - field_1003_b.field_6314_o.func_871_a(field_1007_c)) / 2, k / 2 - 4 - 16, 0xffffff);
        field_1003_b.field_6314_o.func_874_a(field_1004_a, (j - field_1003_b.field_6314_o.func_871_a(field_1004_a)) / 2, (k / 2 - 4) + 8, 0xffffff);
        Display.update();
        try
        {
            Thread.yield();
        }
        catch(Exception exception) { }
    }
}
