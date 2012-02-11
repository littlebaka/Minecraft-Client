// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            NetworkReaderThread, NetworkWriterThread, Packet, NetHandler, 
//            NetworkMasterThread, ThreadCloseConnection

public class NetworkManager
{

    public static final Object field_1478_a = new Object();
    public static int field_1477_b;
    public static int field_1476_c;
    private Object field_1475_d;
    private Socket field_12258_e;
    private final SocketAddress field_1474_e;
    private DataInputStream field_1473_f;
    private DataOutputStream field_1472_g;
    private boolean field_1471_h;
    private List field_1470_i;
    private List field_1469_j;
    private List field_1468_k;
    private NetHandler field_1467_l;
    private boolean field_1466_m;
    private Thread field_1465_n;
    private Thread field_1464_o;
    private boolean field_1463_p;
    private String field_1462_q;
    private Object field_20101_t[];
    private int field_1461_r;
    private int field_1460_s;
    public static int field_28145_d[] = new int[256];
    public static int field_28144_e[] = new int[256];
    public int field_1459_t;
    private int field_20100_w;

    public NetworkManager(Socket socket, String s, NetHandler nethandler)
        throws IOException
    {
        field_1475_d = new Object();
        field_1471_h = true;
        field_1470_i = Collections.synchronizedList(new ArrayList());
        field_1469_j = Collections.synchronizedList(new ArrayList());
        field_1468_k = Collections.synchronizedList(new ArrayList());
        field_1466_m = false;
        field_1463_p = false;
        field_1462_q = "";
        field_1461_r = 0;
        field_1460_s = 0;
        field_1459_t = 0;
        field_20100_w = 50;
        field_12258_e = socket;
        field_1474_e = socket.getRemoteSocketAddress();
        field_1467_l = nethandler;
        try
        {
            socket.setSoTimeout(30000);
            socket.setTrafficClass(24);
        }
        catch(SocketException socketexception)
        {
            System.err.println(socketexception.getMessage());
        }
        field_1473_f = new DataInputStream(socket.getInputStream());
        field_1472_g = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream(), 5120));
        field_1464_o = new NetworkReaderThread(this, (new StringBuilder()).append(s).append(" read thread").toString());
        field_1465_n = new NetworkWriterThread(this, (new StringBuilder()).append(s).append(" write thread").toString());
        field_1464_o.start();
        field_1465_n.start();
    }

    public void func_972_a(Packet packet)
    {
        if(field_1466_m)
        {
            return;
        }
        synchronized(field_1475_d)
        {
            field_1460_s += packet.func_329_a() + 1;
            if(packet.field_472_j)
            {
                field_1468_k.add(packet);
            } else
            {
                field_1469_j.add(packet);
            }
        }
    }

    private boolean func_964_b()
    {
        boolean flag = false;
        try
        {
            if(!field_1469_j.isEmpty() && (field_1459_t == 0 || System.currentTimeMillis() - ((Packet)field_1469_j.get(0)).field_20018_j >= (long)field_1459_t))
            {
                Packet packet;
                synchronized(field_1475_d)
                {
                    packet = (Packet)field_1469_j.remove(0);
                    field_1460_s -= packet.func_329_a() + 1;
                }
                Packet.func_328_a(packet, field_1472_g);
                field_28144_e[packet.func_326_b()] += packet.func_329_a() + 1;
                flag = true;
            }
            if(field_20100_w-- <= 0 && !field_1468_k.isEmpty() && (field_1459_t == 0 || System.currentTimeMillis() - ((Packet)field_1468_k.get(0)).field_20018_j >= (long)field_1459_t))
            {
                Packet packet1;
                synchronized(field_1475_d)
                {
                    packet1 = (Packet)field_1468_k.remove(0);
                    field_1460_s -= packet1.func_329_a() + 1;
                }
                Packet.func_328_a(packet1, field_1472_g);
                field_28144_e[packet1.func_326_b()] += packet1.func_329_a() + 1;
                field_20100_w = 0;
                flag = true;
            }
        }
        catch(Exception exception)
        {
            if(!field_1463_p)
            {
                func_970_a(exception);
            }
            return false;
        }
        return flag;
    }

    public void func_28139_a()
    {
        field_1464_o.interrupt();
        field_1465_n.interrupt();
    }

    private boolean func_973_c()
    {
        boolean flag = false;
        try
        {
            Packet packet = Packet.func_324_b(field_1473_f, field_1467_l.func_27247_c());
            if(packet != null)
            {
                field_28145_d[packet.func_326_b()] += packet.func_329_a() + 1;
                field_1470_i.add(packet);
                flag = true;
            } else
            {
                func_974_a("disconnect.endOfStream", new Object[0]);
            }
        }
        catch(Exception exception)
        {
            if(!field_1463_p)
            {
                func_970_a(exception);
            }
            return false;
        }
        return flag;
    }

    private void func_970_a(Exception exception)
    {
        exception.printStackTrace();
        func_974_a("disconnect.genericReason", new Object[] {
            (new StringBuilder()).append("Internal exception: ").append(exception.toString()).toString()
        });
    }

    public void func_974_a(String s, Object aobj[])
    {
        if(!field_1471_h)
        {
            return;
        }
        field_1463_p = true;
        field_1462_q = s;
        field_20101_t = aobj;
        (new NetworkMasterThread(this)).start();
        field_1471_h = false;
        try
        {
            field_1473_f.close();
            field_1473_f = null;
        }
        catch(Throwable throwable) { }
        try
        {
            field_1472_g.close();
            field_1472_g = null;
        }
        catch(Throwable throwable1) { }
        try
        {
            field_12258_e.close();
            field_12258_e = null;
        }
        catch(Throwable throwable2) { }
    }

    public void func_967_a()
    {
        if(field_1460_s > 0x100000)
        {
            func_974_a("disconnect.overflow", new Object[0]);
        }
        if(field_1470_i.isEmpty())
        {
            if(field_1461_r++ == 1200)
            {
                func_974_a("disconnect.timeout", new Object[0]);
            }
        } else
        {
            field_1461_r = 0;
        }
        Packet packet;
        for(int i = 1000; !field_1470_i.isEmpty() && i-- >= 0; packet.func_323_a(field_1467_l))
        {
            packet = (Packet)field_1470_i.remove(0);
        }

        func_28139_a();
        if(field_1463_p && field_1470_i.isEmpty())
        {
            field_1467_l.func_823_a(field_1462_q, field_20101_t);
        }
    }

    public void func_28142_c()
    {
        if(field_1466_m)
        {
            return;
        } else
        {
            func_28139_a();
            field_1466_m = true;
            field_1464_o.interrupt();
            (new ThreadCloseConnection(this)).start();
            return;
        }
    }

    static boolean func_971_a(NetworkManager networkmanager)
    {
        return networkmanager.field_1471_h;
    }

    static boolean func_968_b(NetworkManager networkmanager)
    {
        return networkmanager.field_1466_m;
    }

    static boolean func_966_c(NetworkManager networkmanager)
    {
        return networkmanager.func_973_c();
    }

    static boolean func_965_d(NetworkManager networkmanager)
    {
        return networkmanager.func_964_b();
    }

    static DataOutputStream func_28140_f(NetworkManager networkmanager)
    {
        return networkmanager.field_1472_g;
    }

    static boolean func_28138_e(NetworkManager networkmanager)
    {
        return networkmanager.field_1463_p;
    }

    static void func_30005_a(NetworkManager networkmanager, Exception exception)
    {
        networkmanager.func_970_a(exception);
    }

    static Thread func_969_e(NetworkManager networkmanager)
    {
        return networkmanager.field_1464_o;
    }

    static Thread func_963_f(NetworkManager networkmanager)
    {
        return networkmanager.field_1465_n;
    }

}
