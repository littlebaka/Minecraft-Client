// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

// Referenced classes of package net.minecraft.src:
//            PanelCrashReport, UnexpectedThrowable

public final class MinecraftImpl extends Minecraft
{

    final Frame field_20919_a; /* synthetic field */

    public MinecraftImpl(Component component, Canvas canvas, MinecraftApplet minecraftapplet, int i, int j, boolean flag, Frame frame)
    {
        field_20919_a = frame;
        super(component, canvas, minecraftapplet, i, j, flag);
    }

    public void func_4007_a(UnexpectedThrowable unexpectedthrowable)
    {
        field_20919_a.removeAll();
        field_20919_a.add(new PanelCrashReport(unexpectedthrowable), "Center");
        field_20919_a.validate();
    }
}
