// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IntHashMap, GLAllocation, TexturePackList, TexturePackBase, 
//            GameSettings, ThreadDownloadImageData, TextureFX, ImageBuffer

public class RenderEngine
{

    public static boolean field_1609_a = false;
    private HashMap field_6528_b;
    private HashMap field_28151_c;
    private IntHashMap field_1607_c;
    private IntBuffer field_1606_d;
    private ByteBuffer field_1605_e;
    private java.util.List field_1604_f;
    private Map field_1603_g;
    private GameSettings field_1602_h;
    public boolean field_4281_i;
    public boolean field_4280_j;
    private TexturePackList field_6527_k;
    private BufferedImage field_25189_l;

    public RenderEngine(TexturePackList texturepacklist, GameSettings gamesettings)
    {
        field_6528_b = new HashMap();
        field_28151_c = new HashMap();
        field_1607_c = new IntHashMap();
        field_1606_d = GLAllocation.func_1125_c(1);
        field_1605_e = GLAllocation.func_1127_b(0x1000000);
        field_1604_f = new ArrayList();
        field_1603_g = new HashMap();
        field_4281_i = false;
        field_4280_j = false;
        field_25189_l = new BufferedImage(64, 64, 2);
        field_6527_k = texturepacklist;
        field_1602_h = gamesettings;
        Graphics g = field_25189_l.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 64, 64);
        g.setColor(Color.BLACK);
        g.drawString("missingtex", 1, 10);
        g.dispose();
    }

    public int[] func_28149_a(String s)
    {
        TexturePackBase texturepackbase = field_6527_k.field_6534_a;
        int ai[] = (int[])field_28151_c.get(s);
        if(ai != null)
        {
            return ai;
        }
        try
        {
            int ai1[] = null;
            if(s.startsWith("##"))
            {
                ai1 = func_28148_b(func_1069_b(func_6526_a(texturepackbase.func_6481_a(s.substring(2)))));
            } else
            if(s.startsWith("%clamp%"))
            {
                field_4281_i = true;
                ai1 = func_28148_b(func_6526_a(texturepackbase.func_6481_a(s.substring(7))));
                field_4281_i = false;
            } else
            if(s.startsWith("%blur%"))
            {
                field_4280_j = true;
                field_4281_i = true;
                ai1 = func_28148_b(func_6526_a(texturepackbase.func_6481_a(s.substring(6))));
                field_4281_i = false;
                field_4280_j = false;
            } else
            {
                InputStream inputstream = texturepackbase.func_6481_a(s);
                if(inputstream == null)
                {
                    ai1 = func_28148_b(field_25189_l);
                } else
                {
                    ai1 = func_28148_b(func_6526_a(inputstream));
                }
            }
            field_28151_c.put(s, ai1);
            return ai1;
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        int ai2[] = func_28148_b(field_25189_l);
        field_28151_c.put(s, ai2);
        return ai2;
    }

    private int[] func_28148_b(BufferedImage bufferedimage)
    {
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        int ai[] = new int[i * j];
        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
        return ai;
    }

    private int[] func_28147_a(BufferedImage bufferedimage, int ai[])
    {
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
        return ai;
    }

    public int func_1070_a(String s)
    {
        TexturePackBase texturepackbase = field_6527_k.field_6534_a;
        Integer integer = (Integer)field_6528_b.get(s);
        if(integer != null)
        {
            return integer.intValue();
        }
        try
        {
            field_1606_d.clear();
            GLAllocation.func_1128_a(field_1606_d);
            int i = field_1606_d.get(0);
            if(s.startsWith("##"))
            {
                func_1068_a(func_1069_b(func_6526_a(texturepackbase.func_6481_a(s.substring(2)))), i);
            } else
            if(s.startsWith("%clamp%"))
            {
                field_4281_i = true;
                func_1068_a(func_6526_a(texturepackbase.func_6481_a(s.substring(7))), i);
                field_4281_i = false;
            } else
            if(s.startsWith("%blur%"))
            {
                field_4280_j = true;
                func_1068_a(func_6526_a(texturepackbase.func_6481_a(s.substring(6))), i);
                field_4280_j = false;
            } else
            if(s.startsWith("%blurclamp%"))
            {
                field_4280_j = true;
                field_4281_i = true;
                func_1068_a(func_6526_a(texturepackbase.func_6481_a(s.substring(11))), i);
                field_4280_j = false;
                field_4281_i = false;
            } else
            {
                InputStream inputstream = texturepackbase.func_6481_a(s);
                if(inputstream == null)
                {
                    func_1068_a(field_25189_l, i);
                } else
                {
                    func_1068_a(func_6526_a(inputstream), i);
                }
            }
            field_6528_b.put(s, Integer.valueOf(i));
            return i;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        GLAllocation.func_1128_a(field_1606_d);
        int j = field_1606_d.get(0);
        func_1068_a(field_25189_l, j);
        field_6528_b.put(s, Integer.valueOf(j));
        return j;
    }

    private BufferedImage func_1069_b(BufferedImage bufferedimage)
    {
        int i = bufferedimage.getWidth() / 16;
        BufferedImage bufferedimage1 = new BufferedImage(16, bufferedimage.getHeight() * i, 2);
        Graphics g = bufferedimage1.getGraphics();
        for(int j = 0; j < i; j++)
        {
            g.drawImage(bufferedimage, -j * 16, j * bufferedimage.getHeight(), null);
        }

        g.dispose();
        return bufferedimage1;
    }

    public int func_1074_a(BufferedImage bufferedimage)
    {
        field_1606_d.clear();
        GLAllocation.func_1128_a(field_1606_d);
        int i = field_1606_d.get(0);
        func_1068_a(bufferedimage, i);
        field_1607_c.func_1061_a(i, bufferedimage);
        return i;
    }

    public void func_1068_a(BufferedImage bufferedimage, int i)
    {
        GL11.glBindTexture(3553, i);
        if(field_1609_a)
        {
            GL11.glTexParameteri(3553, 10241, 9986);
            GL11.glTexParameteri(3553, 10240, 9728);
        } else
        {
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
        if(field_4280_j)
        {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if(field_4281_i)
        {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else
        {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        int j = bufferedimage.getWidth();
        int k = bufferedimage.getHeight();
        int ai[] = new int[j * k];
        byte abyte0[] = new byte[j * k * 4];
        bufferedimage.getRGB(0, 0, j, k, ai, 0, j);
        for(int l = 0; l < ai.length; l++)
        {
            int j1 = ai[l] >> 24 & 0xff;
            int l1 = ai[l] >> 16 & 0xff;
            int j2 = ai[l] >> 8 & 0xff;
            int l2 = ai[l] & 0xff;
            if(field_1602_h != null && field_1602_h.field_1578_g)
            {
                int j3 = (l1 * 30 + j2 * 59 + l2 * 11) / 100;
                int l3 = (l1 * 30 + j2 * 70) / 100;
                int j4 = (l1 * 30 + l2 * 70) / 100;
                l1 = j3;
                j2 = l3;
                l2 = j4;
            }
            abyte0[l * 4 + 0] = (byte)l1;
            abyte0[l * 4 + 1] = (byte)j2;
            abyte0[l * 4 + 2] = (byte)l2;
            abyte0[l * 4 + 3] = (byte)j1;
        }

        field_1605_e.clear();
        field_1605_e.put(abyte0);
        field_1605_e.position(0).limit(abyte0.length);
        GL11.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, field_1605_e);
        if(field_1609_a)
        {
            for(int i1 = 1; i1 <= 4; i1++)
            {
                int k1 = j >> i1 - 1;
                int i2 = j >> i1;
                int k2 = k >> i1;
                for(int i3 = 0; i3 < i2; i3++)
                {
                    for(int k3 = 0; k3 < k2; k3++)
                    {
                        int i4 = field_1605_e.getInt((i3 * 2 + 0 + (k3 * 2 + 0) * k1) * 4);
                        int k4 = field_1605_e.getInt((i3 * 2 + 1 + (k3 * 2 + 0) * k1) * 4);
                        int l4 = field_1605_e.getInt((i3 * 2 + 1 + (k3 * 2 + 1) * k1) * 4);
                        int i5 = field_1605_e.getInt((i3 * 2 + 0 + (k3 * 2 + 1) * k1) * 4);
                        int j5 = func_1077_b(func_1077_b(i4, k4), func_1077_b(l4, i5));
                        field_1605_e.putInt((i3 + k3 * i2) * 4, j5);
                    }

                }

                GL11.glTexImage2D(3553, i1, 6408, i2, k2, 0, 6408, 5121, field_1605_e);
            }

        }
    }

    public void func_28150_a(int ai[], int i, int j, int k)
    {
        GL11.glBindTexture(3553, k);
        if(field_1609_a)
        {
            GL11.glTexParameteri(3553, 10241, 9986);
            GL11.glTexParameteri(3553, 10240, 9728);
        } else
        {
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
        if(field_4280_j)
        {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if(field_4281_i)
        {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else
        {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        byte abyte0[] = new byte[i * j * 4];
        for(int l = 0; l < ai.length; l++)
        {
            int i1 = ai[l] >> 24 & 0xff;
            int j1 = ai[l] >> 16 & 0xff;
            int k1 = ai[l] >> 8 & 0xff;
            int l1 = ai[l] & 0xff;
            if(field_1602_h != null && field_1602_h.field_1578_g)
            {
                int i2 = (j1 * 30 + k1 * 59 + l1 * 11) / 100;
                int j2 = (j1 * 30 + k1 * 70) / 100;
                int k2 = (j1 * 30 + l1 * 70) / 100;
                j1 = i2;
                k1 = j2;
                l1 = k2;
            }
            abyte0[l * 4 + 0] = (byte)j1;
            abyte0[l * 4 + 1] = (byte)k1;
            abyte0[l * 4 + 2] = (byte)l1;
            abyte0[l * 4 + 3] = (byte)i1;
        }

        field_1605_e.clear();
        field_1605_e.put(abyte0);
        field_1605_e.position(0).limit(abyte0.length);
        GL11.glTexSubImage2D(3553, 0, 0, 0, i, j, 6408, 5121, field_1605_e);
    }

    public void func_1078_a(int i)
    {
        field_1607_c.func_1052_b(i);
        field_1606_d.clear();
        field_1606_d.put(i);
        field_1606_d.flip();
        GL11.glDeleteTextures(field_1606_d);
    }

    public int func_1071_a(String s, String s1)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_1603_g.get(s);
        if(threaddownloadimagedata != null && threaddownloadimagedata.field_1706_a != null && !threaddownloadimagedata.field_1707_d)
        {
            if(threaddownloadimagedata.field_1708_c < 0)
            {
                threaddownloadimagedata.field_1708_c = func_1074_a(threaddownloadimagedata.field_1706_a);
            } else
            {
                func_1068_a(threaddownloadimagedata.field_1706_a, threaddownloadimagedata.field_1708_c);
            }
            threaddownloadimagedata.field_1707_d = true;
        }
        if(threaddownloadimagedata == null || threaddownloadimagedata.field_1708_c < 0)
        {
            if(s1 == null)
            {
                return -1;
            } else
            {
                return func_1070_a(s1);
            }
        } else
        {
            return threaddownloadimagedata.field_1708_c;
        }
    }

    public ThreadDownloadImageData func_1075_a(String s, ImageBuffer imagebuffer)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_1603_g.get(s);
        if(threaddownloadimagedata == null)
        {
            field_1603_g.put(s, new ThreadDownloadImageData(s, imagebuffer));
        } else
        {
            threaddownloadimagedata.field_1705_b++;
        }
        return threaddownloadimagedata;
    }

    public void func_1073_b(String s)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_1603_g.get(s);
        if(threaddownloadimagedata != null)
        {
            threaddownloadimagedata.field_1705_b--;
            if(threaddownloadimagedata.field_1705_b == 0)
            {
                if(threaddownloadimagedata.field_1708_c >= 0)
                {
                    func_1078_a(threaddownloadimagedata.field_1708_c);
                }
                field_1603_g.remove(s);
            }
        }
    }

    public void func_1066_a(TextureFX texturefx)
    {
        field_1604_f.add(texturefx);
        texturefx.func_783_a();
    }

    public void func_1067_a()
    {
        int i = -1;
        for(int j = 0; j < field_1604_f.size(); j++)
        {
            TextureFX texturefx = (TextureFX)field_1604_f.get(j);
            texturefx.field_1131_c = field_1602_h.field_1578_g;
            texturefx.func_783_a();
            field_1605_e.clear();
            field_1605_e.put(texturefx.field_1127_a);
            field_1605_e.position(0).limit(texturefx.field_1127_a.length);
            if(texturefx.field_1126_b != i)
            {
                texturefx.func_782_a(this);
                i = texturefx.field_1126_b;
            }
            for(int k = 0; k < texturefx.field_1129_e; k++)
            {
                for(int l = 0; l < texturefx.field_1129_e; l++)
                {
                    GL11.glTexSubImage2D(3553, 0, (texturefx.field_1126_b % 16) * 16 + k * 16, (texturefx.field_1126_b / 16) * 16 + l * 16, 16, 16, 6408, 5121, field_1605_e);
                }

            }

        }

    }

    private int func_1077_b(int i, int j)
    {
        int k = (i & 0xff000000) >> 24 & 0xff;
        int l = (j & 0xff000000) >> 24 & 0xff;
        char c = '\377';
        if(k + l == 0)
        {
            k = 1;
            l = 1;
            c = '\0';
        }
        int i1 = (i >> 16 & 0xff) * k;
        int j1 = (i >> 8 & 0xff) * k;
        int k1 = (i & 0xff) * k;
        int l1 = (j >> 16 & 0xff) * l;
        int i2 = (j >> 8 & 0xff) * l;
        int j2 = (j & 0xff) * l;
        int k2 = (i1 + l1) / (k + l);
        int l2 = (j1 + i2) / (k + l);
        int i3 = (k1 + j2) / (k + l);
        return c << 24 | k2 << 16 | l2 << 8 | i3;
    }

    public void func_1065_b()
    {
        TexturePackBase texturepackbase = field_6527_k.field_6534_a;
        int i;
        BufferedImage bufferedimage;
        for(Iterator iterator = field_1607_c.func_35860_b().iterator(); iterator.hasNext(); func_1068_a(bufferedimage, i))
        {
            i = ((Integer)iterator.next()).intValue();
            bufferedimage = (BufferedImage)field_1607_c.func_1057_a(i);
        }

        for(Iterator iterator1 = field_1603_g.values().iterator(); iterator1.hasNext();)
        {
            ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)iterator1.next();
            threaddownloadimagedata.field_1707_d = false;
        }

        for(Iterator iterator2 = field_6528_b.keySet().iterator(); iterator2.hasNext();)
        {
            String s = (String)iterator2.next();
            try
            {
                BufferedImage bufferedimage1;
                if(s.startsWith("##"))
                {
                    bufferedimage1 = func_1069_b(func_6526_a(texturepackbase.func_6481_a(s.substring(2))));
                } else
                if(s.startsWith("%clamp%"))
                {
                    field_4281_i = true;
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s.substring(7)));
                } else
                if(s.startsWith("%blur%"))
                {
                    field_4280_j = true;
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s.substring(6)));
                } else
                if(s.startsWith("%blurclamp%"))
                {
                    field_4280_j = true;
                    field_4281_i = true;
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s.substring(11)));
                } else
                {
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s));
                }
                int j = ((Integer)field_6528_b.get(s)).intValue();
                func_1068_a(bufferedimage1, j);
                field_4280_j = false;
                field_4281_i = false;
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        for(Iterator iterator3 = field_28151_c.keySet().iterator(); iterator3.hasNext();)
        {
            String s1 = (String)iterator3.next();
            try
            {
                BufferedImage bufferedimage2;
                if(s1.startsWith("##"))
                {
                    bufferedimage2 = func_1069_b(func_6526_a(texturepackbase.func_6481_a(s1.substring(2))));
                } else
                if(s1.startsWith("%clamp%"))
                {
                    field_4281_i = true;
                    bufferedimage2 = func_6526_a(texturepackbase.func_6481_a(s1.substring(7)));
                } else
                if(s1.startsWith("%blur%"))
                {
                    field_4280_j = true;
                    bufferedimage2 = func_6526_a(texturepackbase.func_6481_a(s1.substring(6)));
                } else
                {
                    bufferedimage2 = func_6526_a(texturepackbase.func_6481_a(s1));
                }
                func_28147_a(bufferedimage2, (int[])field_28151_c.get(s1));
                field_4280_j = false;
                field_4281_i = false;
            }
            catch(IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
        }

    }

    private BufferedImage func_6526_a(InputStream inputstream)
        throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(inputstream);
        inputstream.close();
        return bufferedimage;
    }

    public void func_1076_b(int i)
    {
        if(i < 0)
        {
            return;
        } else
        {
            GL11.glBindTexture(3553, i);
            return;
        }
    }

}
