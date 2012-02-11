// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.*;

// Referenced classes of package net.minecraft.src:
//            ImageBuffer

public class ImageBufferDownload
    implements ImageBuffer
{

    private int field_1343_a[];
    private int field_1342_b;
    private int field_1344_c;

    public ImageBufferDownload()
    {
    }

    public BufferedImage func_883_a(BufferedImage bufferedimage)
    {
        if(bufferedimage == null)
        {
            return null;
        }
        field_1342_b = 64;
        field_1344_c = 32;
        BufferedImage bufferedimage1 = new BufferedImage(field_1342_b, field_1344_c, 2);
        Graphics g = bufferedimage1.getGraphics();
        g.drawImage(bufferedimage, 0, 0, null);
        g.dispose();
        field_1343_a = ((DataBufferInt)bufferedimage1.getRaster().getDataBuffer()).getData();
        func_884_b(0, 0, 32, 16);
        func_885_a(32, 0, 64, 32);
        func_884_b(0, 16, 64, 32);
        boolean flag = false;
        for(int i = 32; i < 64; i++)
        {
            for(int k = 0; k < 16; k++)
            {
                int i1 = field_1343_a[i + k * 64];
                if((i1 >> 24 & 0xff) < 128)
                {
                    flag = true;
                }
            }

        }

        if(!flag)
        {
            for(int j = 32; j < 64; j++)
            {
                for(int l = 0; l < 16; l++)
                {
                    int j1 = field_1343_a[j + l * 64];
                    boolean flag1;
                    if((j1 >> 24 & 0xff) < 128)
                    {
                        flag1 = true;
                    }
                }

            }

        }
        return bufferedimage1;
    }

    private void func_885_a(int i, int j, int k, int l)
    {
        if(func_886_c(i, j, k, l))
        {
            return;
        }
        for(int i1 = i; i1 < k; i1++)
        {
            for(int j1 = j; j1 < l; j1++)
            {
                field_1343_a[i1 + j1 * field_1342_b] &= 0xffffff;
            }

        }

    }

    private void func_884_b(int i, int j, int k, int l)
    {
        for(int i1 = i; i1 < k; i1++)
        {
            for(int j1 = j; j1 < l; j1++)
            {
                field_1343_a[i1 + j1 * field_1342_b] |= 0xff000000;
            }

        }

    }

    private boolean func_886_c(int i, int j, int k, int l)
    {
        for(int i1 = i; i1 < k; i1++)
        {
            for(int j1 = j; j1 < l; j1++)
            {
                int k1 = field_1343_a[i1 + j1 * field_1342_b];
                if((k1 >> 24 & 0xff) < 128)
                {
                    return true;
                }
            }

        }

        return false;
    }
}
