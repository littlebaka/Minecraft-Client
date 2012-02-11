// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiMultiplayer, GuiButton, ServerNBTStorage, 
//            ThreadPollServers, FontRenderer, RenderEngine, Tessellator

class GuiSlotServer extends GuiSlot
{

    final GuiMultiplayer field_35410_a; /* synthetic field */

    public GuiSlotServer(GuiMultiplayer guimultiplayer)
    {
        field_35410_a = guimultiplayer;
        super(guimultiplayer.field_945_b, guimultiplayer.field_951_c, guimultiplayer.field_950_d, 32, guimultiplayer.field_950_d - 64, 36);
    }

    protected int func_22249_a()
    {
        return GuiMultiplayer.func_35320_a(field_35410_a).size();
    }

    protected void func_22247_a(int i, boolean flag)
    {
        GuiMultiplayer.func_35326_a(field_35410_a, i);
        boolean flag1 = GuiMultiplayer.func_35333_b(field_35410_a) >= 0 && GuiMultiplayer.func_35333_b(field_35410_a) < func_22249_a();
        GuiMultiplayer.func_35329_c(field_35410_a).field_937_g = flag1;
        GuiMultiplayer.func_35334_d(field_35410_a).field_937_g = flag1;
        GuiMultiplayer.func_35339_e(field_35410_a).field_937_g = flag1;
        if(flag && flag1)
        {
            GuiMultiplayer.func_35332_b(field_35410_a, i);
        }
    }

    protected boolean func_22246_a(int i)
    {
        return i == GuiMultiplayer.func_35333_b(field_35410_a);
    }

    protected int func_22245_b()
    {
        return GuiMultiplayer.func_35320_a(field_35410_a).size() * 36;
    }

    protected void func_22248_c()
    {
        field_35410_a.func_578_i();
    }

    protected void func_22242_a(int i, int j, int k, int l, Tessellator tessellator)
    {
        ServerNBTStorage servernbtstorage = (ServerNBTStorage)GuiMultiplayer.func_35320_a(field_35410_a).get(i);
        synchronized(GuiMultiplayer.func_35321_g())
        {
            if(GuiMultiplayer.func_35338_m() < 5 && !servernbtstorage.field_35790_f)
            {
                servernbtstorage.field_35790_f = true;
                servernbtstorage.field_35792_e = -2L;
                servernbtstorage.field_35791_d = "";
                servernbtstorage.field_35794_c = "";
                GuiMultiplayer.func_35331_n();
                (new ThreadPollServers(this, servernbtstorage)).start();
            }
        }
        field_35410_a.func_547_b(field_35410_a.field_6451_g, servernbtstorage.field_35795_a, j + 2, k + 1, 0xffffff);
        field_35410_a.func_547_b(field_35410_a.field_6451_g, servernbtstorage.field_35791_d, j + 2, k + 12, 0x808080);
        field_35410_a.func_547_b(field_35410_a.field_6451_g, servernbtstorage.field_35794_c, (j + 215) - field_35410_a.field_6451_g.func_871_a(servernbtstorage.field_35794_c), k + 12, 0x808080);
        field_35410_a.func_547_b(field_35410_a.field_6451_g, servernbtstorage.field_35793_b, j + 2, k + 12 + 11, 0x303030);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_35410_a.field_945_b.field_6315_n.func_1076_b(field_35410_a.field_945_b.field_6315_n.func_1070_a("/gui/icons.png"));
        int i1 = 0;
        int j1 = 0;
        String s = "";
        if(servernbtstorage.field_35790_f && servernbtstorage.field_35792_e != -2L)
        {
            i1 = 0;
            j1 = 0;
            if(servernbtstorage.field_35792_e < 0L)
            {
                j1 = 5;
            } else
            if(servernbtstorage.field_35792_e < 150L)
            {
                j1 = 0;
            } else
            if(servernbtstorage.field_35792_e < 300L)
            {
                j1 = 1;
            } else
            if(servernbtstorage.field_35792_e < 600L)
            {
                j1 = 2;
            } else
            if(servernbtstorage.field_35792_e < 1000L)
            {
                j1 = 3;
            } else
            {
                j1 = 4;
            }
            if(servernbtstorage.field_35792_e < 0L)
            {
                s = "(no connection)";
            } else
            {
                s = (new StringBuilder()).append(servernbtstorage.field_35792_e).append("ms").toString();
            }
        } else
        {
            i1 = 1;
            j1 = (int)(System.currentTimeMillis() / 100L + (long)(i * 2) & 7L);
            if(j1 > 4)
            {
                j1 = 8 - j1;
            }
            s = "Polling..";
        }
        field_35410_a.func_550_b(j + 205, k, 0 + i1 * 10, 176 + j1 * 8, 10, 8);
        byte byte0 = 4;
        if(field_35409_k >= (j + 205) - byte0 && field_35408_l >= k - byte0 && field_35409_k <= j + 205 + 10 + byte0 && field_35408_l <= k + 8 + byte0)
        {
            GuiMultiplayer.func_35327_a(field_35410_a, s);
        }
    }
}
