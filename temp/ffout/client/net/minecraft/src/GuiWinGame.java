// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, World, EntityClientPlayerMP, Packet9Respawn, 
//            WorldInfo, NetClientHandler, Session, FontRenderer, 
//            Tessellator, RenderEngine, GuiButton

public class GuiWinGame extends GuiScreen
{

    private int field_41046_a;
    private List field_41044_b;
    private int field_41045_c[];
    private int field_41042_d;
    private float field_41043_e;

    public GuiWinGame()
    {
        field_41046_a = 0;
        field_41042_d = 0;
        field_41043_e = 0.5F;
    }

    public void func_570_g()
    {
        field_41046_a++;
        float f = (float)(field_41042_d + field_950_d + field_950_d + 24) / field_41043_e;
        if((float)field_41046_a > f)
        {
            func_41041_e();
        }
    }

    protected void func_580_a(char c, int i)
    {
        if(i == 1)
        {
            func_41041_e();
        }
    }

    private void func_41041_e()
    {
        if(field_945_b.field_6324_e.field_1026_y)
        {
            EntityClientPlayerMP entityclientplayermp = (EntityClientPlayerMP)field_945_b.field_6322_g;
            entityclientplayermp.func_9375_Q();
            entityclientplayermp.field_797_bg.func_847_a(new Packet9Respawn((byte)entityclientplayermp.field_4129_m, (byte)field_945_b.field_6324_e.field_1039_l, field_945_b.field_6324_e.func_22138_q(), field_945_b.field_6324_e.func_22144_v().func_46133_t(), field_945_b.field_6324_e.field_35472_c, 0));
        } else
        {
            field_945_b.func_6272_a(null);
            field_945_b.func_6239_p(field_945_b.field_6324_e.field_1026_y, 0, true);
        }
    }

    public boolean func_6450_b()
    {
        return true;
    }

    public void func_6448_a()
    {
        if(field_41044_b != null)
        {
            return;
        }
        field_41044_b = new ArrayList();
        try
        {
            String s = "";
            String s1 = "\247f\247k\247a\247b";
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiWinGame.class).getResourceAsStream("/title/win.txt"), Charset.forName("UTF-8")));
            Random random = new Random(0x7bf7d3L);
            while((s = bufferedreader.readLine()) != null) 
            {
                String s2;
                String s3;
                for(s = s.replaceAll("PLAYERNAME", field_945_b.field_6320_i.field_1666_b); s.indexOf(s1) >= 0; s = (new StringBuilder()).append(s2).append("\247f\247k").append("XXXXXXXX".substring(0, random.nextInt(4) + 3)).append(s3).toString())
                {
                    int i = s.indexOf(s1);
                    s2 = s.substring(0, i);
                    s3 = s.substring(i + s1.length());
                }

                if(s.length() == 0)
                {
                    field_41044_b.add(s);
                }
                field_41044_b.add(s);
            }
            for(int j = 0; j < 16; j++)
            {
                field_41044_b.add("");
            }

            bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiWinGame.class).getResourceAsStream("/title/credits.txt"), Charset.forName("UTF-8")));
            while((s = bufferedreader.readLine()) != null) 
            {
                s = s.replaceAll("PLAYERNAME", field_945_b.field_6320_i.field_1666_b);
                s = s.replaceAll("\t", "    ");
                if(s.length() == 0)
                {
                    field_41044_b.add(s);
                }
                field_41044_b.add(s);
            }
            field_41045_c = new int[field_41044_b.size()];
            char c = '\u0112';
            field_6451_g.field_41063_b = 12;
            for(int k = 0; k < field_41044_b.size(); k++)
            {
                field_41042_d += field_41045_c[k] = field_6451_g.func_27277_a((String)field_41044_b.get(k), c);
            }

            field_6451_g.field_41063_b = 8;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void func_572_a(GuiButton guibutton)
    {
    }

    private void func_41040_b(int i, int j, float f)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, field_945_b.field_6315_n.func_1070_a("%blur%/gui/background.png"));
        tessellator.func_977_b();
        tessellator.func_986_a(1.0F, 1.0F, 1.0F, 1.0F);
        int k = field_951_c;
        float f1 = 0.0F - ((float)field_41046_a + f) * 0.5F * field_41043_e;
        float f2 = (float)field_950_d - ((float)field_41046_a + f) * 0.5F * field_41043_e;
        float f3 = 0.015625F;
        float f4 = (((float)field_41046_a + f) - 0.0F) * 0.02F;
        float f5 = (float)(field_41042_d + field_950_d + field_950_d + 24) / field_41043_e;
        float f6 = (f5 - 20F - ((float)field_41046_a + f)) * 0.005F;
        if(f6 < f4)
        {
            f4 = f6;
        }
        if(f4 > 1.0F)
        {
            f4 = 1.0F;
        }
        f4 *= f4;
        f4 = (f4 * 96F) / 255F;
        tessellator.func_987_a(f4, f4, f4);
        tessellator.func_983_a(0.0D, field_950_d, field_923_k, 0.0D, f1 * f3);
        tessellator.func_983_a(k, field_950_d, field_923_k, (float)k * f3, f1 * f3);
        tessellator.func_983_a(k, 0.0D, field_923_k, (float)k * f3, f2 * f3);
        tessellator.func_983_a(0.0D, 0.0D, field_923_k, 0.0D, f2 * f3);
        tessellator.func_982_a();
    }

    public void func_571_a(int i, int j, float f)
    {
        func_41040_b(i, j, f);
        Tessellator tessellator = Tessellator.field_1512_a;
        char c = '\u0112';
        int k = field_951_c / 2 - c / 2;
        int l = field_950_d + 50;
        float f1 = -((float)field_41046_a + f) * field_41043_e;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, f1, 0.0F);
        GL11.glBindTexture(3553, field_945_b.field_6315_n.func_1070_a("/title/mclogo.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        func_550_b(k + 0, l + 0, 0, 0, 155, 44);
        func_550_b(k + 155, l + 0, 0, 45, 155, 44);
        tessellator.func_990_b(0xffffff);
        field_6451_g.field_41063_b = 12;
        int i1 = l + 200;
        for(int j1 = 0; j1 < field_41044_b.size(); j1++)
        {
            int l1 = field_41045_c[j1];
            if(j1 == field_41044_b.size() - 1)
            {
                float f2 = ((float)i1 + f1) - (float)(field_950_d / 2 - l1 / 2);
                if(f2 < 0.0F)
                {
                    GL11.glTranslatef(0.0F, -f2, 0.0F);
                }
            }
            if((float)i1 + f1 + (float)l1 + 8F > 0.0F && (float)i1 + f1 < (float)field_950_d)
            {
                String s = (String)field_41044_b.get(j1);
                if(s.startsWith("[C]"))
                {
                    field_6451_g.func_874_a(s.substring(3), k + (c - field_6451_g.func_871_a(s.substring(3))) / 2, i1, 0xffffff);
                } else
                {
                    field_6451_g.field_41064_c.setSeed((long)j1 * 0xfca99533L + (long)(field_41046_a / 4));
                    field_6451_g.func_40609_a(s, k + 1, i1 + 1, c, 0xffffff, true);
                    field_6451_g.field_41064_c.setSeed((long)j1 * 0xfca99533L + (long)(field_41046_a / 4));
                    field_6451_g.func_40609_a(s, k, i1, c, 0xffffff, false);
                }
            }
            i1 += l1;
        }

        field_6451_g.field_41063_b = 8;
        GL11.glPopMatrix();
        GL11.glBindTexture(3553, field_945_b.field_6315_n.func_1070_a("%blur%/misc/vignette.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(0, 769);
        tessellator.func_977_b();
        tessellator.func_986_a(1.0F, 1.0F, 1.0F, 1.0F);
        int k1 = field_951_c;
        int i2 = field_950_d;
        tessellator.func_983_a(0.0D, i2, field_923_k, 0.0D, 1.0D);
        tessellator.func_983_a(k1, i2, field_923_k, 1.0D, 1.0D);
        tessellator.func_983_a(k1, 0.0D, field_923_k, 1.0D, 0.0D);
        tessellator.func_983_a(0.0D, 0.0D, field_923_k, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glDisable(3042);
        super.func_571_a(i, j, f);
    }
}
