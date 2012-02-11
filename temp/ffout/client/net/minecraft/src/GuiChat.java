// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, EntityPlayerSP, GuiIngame, ChatAllowedCharacters

public class GuiChat extends GuiScreen
{

    protected String field_985_a;
    private int field_986_h;
    private static final String field_20082_i;

    public GuiChat()
    {
        field_985_a = "";
        field_986_h = 0;
    }

    public void func_6448_a()
    {
        Keyboard.enableRepeatEvents(true);
    }

    public void func_6449_h()
    {
        Keyboard.enableRepeatEvents(false);
    }

    public void func_570_g()
    {
        field_986_h++;
    }

    protected void func_580_a(char c, int i)
    {
        if(i == 1)
        {
            field_945_b.func_6272_a(null);
            return;
        }
        if(i == 28)
        {
            String s = field_985_a.trim();
            if(s.length() > 0)
            {
                String s1 = field_985_a.trim();
                if(!field_945_b.func_22003_b(s1))
                {
                    field_945_b.field_6322_g.func_461_a(s1);
                }
            }
            field_945_b.func_6272_a(null);
            return;
        }
        if(i == 14 && field_985_a.length() > 0)
        {
            field_985_a = field_985_a.substring(0, field_985_a.length() - 1);
        }
        if(field_20082_i.indexOf(c) < 0 && c <= ' ' || field_985_a.length() >= 100) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_985_a;
        append();
        c;
        append();
        toString();
        field_985_a;
_L2:
    }

    public void func_571_a(int i, int j, float f)
    {
        func_551_a(2, field_950_d - 14, field_951_c - 2, field_950_d - 2, 0x80000000);
        func_547_b(field_6451_g, (new StringBuilder()).append("> ").append(field_985_a).append((field_986_h / 6) % 2 != 0 ? "" : "_").toString(), 4, field_950_d - 12, 0xe0e0e0);
        super.func_571_a(i, j, f);
    }

    protected void func_565_a(int i, int j, int k)
    {
        if(k != 0)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if(field_945_b.field_6308_u.field_933_a == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if(field_985_a.length() <= 0 || field_985_a.endsWith(" ")) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_985_a;
        append();
        " ";
        append();
        toString();
        field_985_a;
_L2:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_985_a;
        append();
        field_945_b.field_6308_u.field_933_a;
        append();
        toString();
        field_985_a;
        byte byte0 = 100;
        if(field_985_a.length() > byte0)
        {
            field_985_a = field_985_a.substring(0, byte0);
        }
        break MISSING_BLOCK_LABEL_139;
        super.func_565_a(i, j, k);
    }

    static 
    {
        field_20082_i = ChatAllowedCharacters.field_20157_a;
    }
}
