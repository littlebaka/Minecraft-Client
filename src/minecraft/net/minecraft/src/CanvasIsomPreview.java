package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class CanvasIsomPreview extends Canvas
    implements KeyListener, MouseListener, MouseMotionListener, Runnable
{
    private int field_1793_a;
    private int field_1792_b;
    private boolean field_1791_c;
    private World field_1790_d;
    private File field_1789_e;
    private boolean field_1788_f;
    private java.util.List field_1787_g;
    private IsoImageBuffer field_1786_h[][];
    private int field_1785_i;
    private int field_1784_j;
    private int field_1783_k;
    private int field_1782_l;

    public File func_1263_a()
    {
        if (field_1789_e == null)
        {
            field_1789_e = func_1264_a("minecraft");
        }
        return field_1789_e;
    }

    public File func_1264_a(String s)
    {
        String s1 = System.getProperty("user.home", ".");
        File file;
        switch (OsMap.field_1193_a[func_1269_e().ordinal()])
        {
            case 1:
            case 2:
                file = new File(s1, (new StringBuilder()).append('.').append(s).append('/').toString());
                break;

            case 3:
                String s2 = System.getenv("APPDATA");
                if (s2 != null)
                {
                    file = new File(s2, (new StringBuilder()).append(".").append(s).append('/').toString());
                }
                else
                {
                    file = new File(s1, (new StringBuilder()).append('.').append(s).append('/').toString());
                }
                break;

            case 4:
                file = new File(s1, (new StringBuilder()).append("Library/Application Support/").append(s).toString());
                break;

            default:
                file = new File(s1, (new StringBuilder()).append(s).append('/').toString());
                break;
        }
        if (!file.exists() && !file.mkdirs())
        {
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(file).toString());
        }
        else
        {
            return file;
        }
    }

    private static EnumOS1 func_1269_e()
    {
        String s = System.getProperty("os.name").toLowerCase();
        if (s.contains("win"))
        {
            return EnumOS1.windows;
        }
        if (s.contains("mac"))
        {
            return EnumOS1.macos;
        }
        if (s.contains("solaris"))
        {
            return EnumOS1.solaris;
        }
        if (s.contains("sunos"))
        {
            return EnumOS1.solaris;
        }
        if (s.contains("linux"))
        {
            return EnumOS1.linux;
        }
        if (s.contains("unix"))
        {
            return EnumOS1.linux;
        }
        else
        {
            return EnumOS1.unknown;
        }
    }

    public CanvasIsomPreview()
    {
        field_1793_a = 0;
        field_1792_b = 2;
        field_1791_c = true;
        field_1788_f = true;
        field_1787_g = Collections.synchronizedList(new LinkedList());
        field_1786_h = new IsoImageBuffer[64][64];
        field_1789_e = func_1263_a();
        for (int i = 0; i < 64; i++)
        {
            for (int j = 0; j < 64; j++)
            {
                field_1786_h[i][j] = new IsoImageBuffer(null, i, j);
            }
        }

        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        setBackground(Color.red);
    }

    public void func_1270_b(String s)
    {
        field_1785_i = field_1784_j = 0;
        field_1790_d = new World(new SaveHandler(new File(field_1789_e, "saves"), s, false), s, new WorldSettings((new Random()).nextLong(), 0, true, false, EnumWorldType.DEFAULT));
        field_1790_d.skylightSubtracted = 0;
        synchronized (field_1787_g)
        {
            field_1787_g.clear();
            for (int i = 0; i < 64; i++)
            {
                for (int j = 0; j < 64; j++)
                {
                    field_1786_h[i][j].func_888_a(field_1790_d, i, j);
                }
            }
        }
    }

    private void func_1266_a(int i)
    {
        synchronized (field_1787_g)
        {
            field_1790_d.skylightSubtracted = i;
            field_1787_g.clear();
            for (int j = 0; j < 64; j++)
            {
                for (int k = 0; k < 64; k++)
                {
                    field_1786_h[j][k].func_888_a(field_1790_d, j, k);
                }
            }
        }
    }

    public void func_1272_b()
    {
        (new ThreadRunIsoClient(this)).start();
        for (int i = 0; i < 8; i++)
        {
            (new Thread(this)).start();
        }
    }

    public void func_1273_c()
    {
        field_1788_f = false;
    }

    private IsoImageBuffer func_1267_a(int i, int j)
    {
        int k = i & 0x3f;
        int l = j & 0x3f;
        IsoImageBuffer isoimagebuffer = field_1786_h[k][l];
        if (isoimagebuffer.field_1354_c == i && isoimagebuffer.field_1353_d == j)
        {
            return isoimagebuffer;
        }
        synchronized (field_1787_g)
        {
            field_1787_g.remove(isoimagebuffer);
        }
        isoimagebuffer.func_889_a(i, j);
        return isoimagebuffer;
    }

    public void run()
    {
        TerrainTextureManager terraintexturemanager = new TerrainTextureManager();
        while (field_1788_f)
        {
            IsoImageBuffer isoimagebuffer = null;
            synchronized (field_1787_g)
            {
                if (field_1787_g.size() > 0)
                {
                    isoimagebuffer = (IsoImageBuffer)field_1787_g.remove(0);
                }
            }
            if (isoimagebuffer != null)
            {
                if (field_1793_a - isoimagebuffer.field_1350_g < 2)
                {
                    terraintexturemanager.func_799_a(isoimagebuffer);
                    repaint();
                }
                else
                {
                    isoimagebuffer.field_1349_h = false;
                }
            }
            try
            {
                Thread.sleep(2L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
    }

    public void update(Graphics g)
    {
    }

    public void paint(Graphics g)
    {
    }

    public void func_1265_d()
    {
        BufferStrategy bufferstrategy = getBufferStrategy();
        if (bufferstrategy == null)
        {
            createBufferStrategy(2);
            return;
        }
        else
        {
            func_1268_a((Graphics2D)bufferstrategy.getDrawGraphics());
            bufferstrategy.show();
            return;
        }
    }

    public void func_1268_a(Graphics2D graphics2d)
    {
        field_1793_a++;
        java.awt.geom.AffineTransform affinetransform = graphics2d.getTransform();
        graphics2d.setClip(0, 0, getWidth(), getHeight());
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics2d.translate(getWidth() / 2, getHeight() / 2);
        graphics2d.scale(field_1792_b, field_1792_b);
        graphics2d.translate(field_1785_i, field_1784_j);
        if (field_1790_d != null)
        {
            ChunkCoordinates chunkcoordinates = field_1790_d.getSpawnPoint();
            graphics2d.translate(-(chunkcoordinates.posX + chunkcoordinates.posZ), -(-chunkcoordinates.posX + chunkcoordinates.posZ) + 64);
        }
        Rectangle rectangle = graphics2d.getClipBounds();
        graphics2d.setColor(new Color(0xff101020));
        graphics2d.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        byte byte0 = 16;
        byte byte1 = 3;
        int i = rectangle.x / byte0 / 2 - 2 - byte1;
        int j = (rectangle.x + rectangle.width) / byte0 / 2 + 1 + byte1;
        int k = rectangle.y / byte0 - 1 - byte1 * 2;
        int l = (rectangle.y + rectangle.height + 16 + field_1790_d.worldHeight) / byte0 + 1 + byte1 * 2;
        for (int i1 = k; i1 <= l; i1++)
        {
            for (int k1 = i; k1 <= j; k1++)
            {
                int l1 = k1 - (i1 >> 1);
                int i2 = k1 + (i1 + 1 >> 1);
                IsoImageBuffer isoimagebuffer = func_1267_a(l1, i2);
                isoimagebuffer.field_1350_g = field_1793_a;
                if (!isoimagebuffer.field_1352_e)
                {
                    if (!isoimagebuffer.field_1349_h)
                    {
                        isoimagebuffer.field_1349_h = true;
                        field_1787_g.add(isoimagebuffer);
                    }
                    continue;
                }
                isoimagebuffer.field_1349_h = false;
                if (!isoimagebuffer.field_1351_f)
                {
                    int j2 = k1 * byte0 * 2 + (i1 & 1) * byte0;
                    int k2 = i1 * byte0 - field_1790_d.worldHeight - 16;
                    graphics2d.drawImage(isoimagebuffer.field_1348_a, j2, k2, null);
                }
            }
        }

        if (field_1791_c)
        {
            graphics2d.setTransform(affinetransform);
            int j1 = getHeight() - 32 - 4;
            graphics2d.setColor(new Color(0x80000000, true));
            graphics2d.fillRect(4, getHeight() - 32 - 4, getWidth() - 8, 32);
            graphics2d.setColor(Color.WHITE);
            String s = "F1 - F5: load levels   |   0-9: Set time of day   |   Space: return to spawn   |   Double click: zoom   |   Escape: hide this text";
            graphics2d.drawString(s, getWidth() / 2 - graphics2d.getFontMetrics().stringWidth(s) / 2, j1 + 20);
        }
        graphics2d.dispose();
    }

    public void mouseDragged(MouseEvent mouseevent)
    {
        int i = mouseevent.getX() / field_1792_b;
        int j = mouseevent.getY() / field_1792_b;
        field_1785_i += i - field_1783_k;
        field_1784_j += j - field_1782_l;
        field_1783_k = i;
        field_1782_l = j;
        repaint();
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
        if (mouseevent.getClickCount() == 2)
        {
            field_1792_b = 3 - field_1792_b;
            repaint();
        }
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }

    public void mousePressed(MouseEvent mouseevent)
    {
        int i = mouseevent.getX() / field_1792_b;
        int j = mouseevent.getY() / field_1792_b;
        field_1783_k = i;
        field_1782_l = j;
    }

    public void mouseReleased(MouseEvent mouseevent)
    {
    }

    public void keyPressed(KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 48)
        {
            func_1266_a(11);
        }
        if (keyevent.getKeyCode() == 49)
        {
            func_1266_a(10);
        }
        if (keyevent.getKeyCode() == 50)
        {
            func_1266_a(9);
        }
        if (keyevent.getKeyCode() == 51)
        {
            func_1266_a(7);
        }
        if (keyevent.getKeyCode() == 52)
        {
            func_1266_a(6);
        }
        if (keyevent.getKeyCode() == 53)
        {
            func_1266_a(5);
        }
        if (keyevent.getKeyCode() == 54)
        {
            func_1266_a(3);
        }
        if (keyevent.getKeyCode() == 55)
        {
            func_1266_a(2);
        }
        if (keyevent.getKeyCode() == 56)
        {
            func_1266_a(1);
        }
        if (keyevent.getKeyCode() == 57)
        {
            func_1266_a(0);
        }
        if (keyevent.getKeyCode() == 112)
        {
            func_1270_b("World1");
        }
        if (keyevent.getKeyCode() == 113)
        {
            func_1270_b("World2");
        }
        if (keyevent.getKeyCode() == 114)
        {
            func_1270_b("World3");
        }
        if (keyevent.getKeyCode() == 115)
        {
            func_1270_b("World4");
        }
        if (keyevent.getKeyCode() == 116)
        {
            func_1270_b("World5");
        }
        if (keyevent.getKeyCode() == 32)
        {
            field_1785_i = field_1784_j = 0;
        }
        if (keyevent.getKeyCode() == 27)
        {
            field_1791_c = !field_1791_c;
        }
        repaint();
    }

    public void keyReleased(KeyEvent keyevent)
    {
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    static boolean func_1271_a(CanvasIsomPreview canvasisompreview)
    {
        return canvasisompreview.field_1788_f;
    }
}
