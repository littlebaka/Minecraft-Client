// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySign, TileEntitySignRenderer, TileEntityMobSpawner, TileEntityMobSpawnerRenderer, 
//            TileEntityPiston, TileEntityRendererPiston, TileEntityChest, TileEntityChestRenderer, 
//            TileEntityEnchantmentTable, RenderEnchantmentTable, TileEntityEndPortal, RenderEndPortal, 
//            TileEntitySpecialRenderer, TileEntity, EntityLiving, World, 
//            OpenGlHelper, FontRenderer, RenderEngine

public class TileEntityRenderer
{

    private Map field_6517_m;
    public static TileEntityRenderer field_1554_a = new TileEntityRenderer();
    private FontRenderer field_1541_n;
    public static double field_1553_b;
    public static double field_1552_c;
    public static double field_1551_d;
    public RenderEngine field_1550_e;
    public World field_1549_f;
    public EntityLiving field_22270_g;
    public float field_22269_h;
    public float field_22268_i;
    public double field_1545_j;
    public double field_1544_k;
    public double field_1543_l;

    private TileEntityRenderer()
    {
        field_6517_m = new HashMap();
        field_6517_m.put(net.minecraft.src.TileEntitySign.class, new TileEntitySignRenderer());
        field_6517_m.put(net.minecraft.src.TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        field_6517_m.put(net.minecraft.src.TileEntityPiston.class, new TileEntityRendererPiston());
        field_6517_m.put(net.minecraft.src.TileEntityChest.class, new TileEntityChestRenderer());
        field_6517_m.put(net.minecraft.src.TileEntityEnchantmentTable.class, new RenderEnchantmentTable());
        field_6517_m.put(net.minecraft.src.TileEntityEndPortal.class, new RenderEndPortal());
        TileEntitySpecialRenderer tileentityspecialrenderer;
        for(Iterator iterator = field_6517_m.values().iterator(); iterator.hasNext(); tileentityspecialrenderer.func_928_a(this))
        {
            tileentityspecialrenderer = (TileEntitySpecialRenderer)iterator.next();
        }

    }

    public TileEntitySpecialRenderer func_4144_a(Class class1)
    {
        TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer)field_6517_m.get(class1);
        if(tileentityspecialrenderer == null && class1 != (net.minecraft.src.TileEntity.class))
        {
            tileentityspecialrenderer = func_4144_a(class1.getSuperclass());
            field_6517_m.put(class1, tileentityspecialrenderer);
        }
        return tileentityspecialrenderer;
    }

    public boolean func_1028_a(TileEntity tileentity)
    {
        return func_1031_b(tileentity) != null;
    }

    public TileEntitySpecialRenderer func_1031_b(TileEntity tileentity)
    {
        if(tileentity == null)
        {
            return null;
        } else
        {
            return func_4144_a(tileentity.getClass());
        }
    }

    public void func_22267_a(World world, RenderEngine renderengine, FontRenderer fontrenderer, EntityLiving entityliving, float f)
    {
        if(field_1549_f != world)
        {
            func_31072_a(world);
        }
        field_1550_e = renderengine;
        field_22270_g = entityliving;
        field_1541_n = fontrenderer;
        field_22269_h = entityliving.field_603_as + (entityliving.field_605_aq - entityliving.field_603_as) * f;
        field_22268_i = entityliving.field_602_at + (entityliving.field_604_ar - entityliving.field_602_at) * f;
        field_1545_j = entityliving.field_638_aI + (entityliving.field_611_ak - entityliving.field_638_aI) * (double)f;
        field_1544_k = entityliving.field_637_aJ + (entityliving.field_610_al - entityliving.field_637_aJ) * (double)f;
        field_1543_l = entityliving.field_636_aK + (entityliving.field_609_am - entityliving.field_636_aK) * (double)f;
    }

    public void func_40742_a()
    {
    }

    public void func_1030_a(TileEntity tileentity, float f)
    {
        if(tileentity.func_480_a(field_1545_j, field_1544_k, field_1543_l) < 4096D)
        {
            int i = field_1549_f.func_35451_b(tileentity.field_823_f, tileentity.field_822_g, tileentity.field_821_h, 0);
            int j = i % 0x10000;
            int k = i / 0x10000;
            OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            func_1032_a(tileentity, (double)tileentity.field_823_f - field_1553_b, (double)tileentity.field_822_g - field_1552_c, (double)tileentity.field_821_h - field_1551_d, f);
        }
    }

    public void func_1032_a(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        TileEntitySpecialRenderer tileentityspecialrenderer = func_1031_b(tileentity);
        if(tileentityspecialrenderer != null)
        {
            tileentityspecialrenderer.func_930_a(tileentity, d, d1, d2, f);
        }
    }

    public void func_31072_a(World world)
    {
        field_1549_f = world;
        Iterator iterator = field_6517_m.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer)iterator.next();
            if(tileentityspecialrenderer != null)
            {
                tileentityspecialrenderer.func_31069_a(world);
            }
        } while(true);
    }

    public FontRenderer func_6516_a()
    {
        return field_1541_n;
    }

}
