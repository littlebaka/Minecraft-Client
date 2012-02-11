// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ThreadSleepForever extends Thread
{

    final Minecraft field_1588_a; /* synthetic field */

    public ThreadSleepForever(Minecraft minecraft, String s)
    {
        field_1588_a = minecraft;
        super(s);
        setDaemon(true);
        start();
    }

    public void run()
    {
        while(field_1588_a.field_6293_H) 
        {
            try
            {
                Thread.sleep(0x7fffffffL);
            }
            catch(InterruptedException interruptedexception) { }
        }
    }
}
