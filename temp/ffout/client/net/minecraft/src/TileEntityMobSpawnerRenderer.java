// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, TileEntityMobSpawner, Entity, EntityList, 
//            RenderManager, TileEntity

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer
{

    private Map field_1412_b;

    public TileEntityMobSpawnerRenderer()
    {
        field_1412_b = new HashMap();
    }

    public void func_931_a(TileEntityMobSpawner tileentitymobspawner, double d, double d1, double d2, 
            float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5F, (float)d1, (float)d2 + 0.5F);
        Entity entity = (Entity)field_1412_b.get(tileentitymobspawner.func_21099_a());
        if(entity == null)
        {
            entity = EntityList.func_1079_a(tileentitymobspawner.func_21099_a(), null);
            field_1412_b.put(tileentitymobspawner.func_21099_a(), entity);
        }
        if(entity != null)
        {
            entity.func_398_a(tileentitymobspawner.field_824_e);
            float f1 = 0.4375F;
            GL11.glTranslatef(0.0F, 0.4F, 0.0F);
            GL11.glRotatef((float)(tileentitymobspawner.field_830_d + (tileentitymobspawner.field_831_c - tileentitymobspawner.field_830_d) * (double)f) * 10F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-30F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.4F, 0.0F);
            GL11.glScalef(f1, f1, f1);
            entity.func_365_c(d, d1, d2, 0.0F, 0.0F);
            RenderManager.field_1233_a.func_853_a(entity, 0.0D, 0.0D, 0.0D, 0.0F, f);
        }
        GL11.glPopMatrix();
    }

    public void func_930_a(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        func_931_a((TileEntityMobSpawner)tileentity, d, d1, d2, f);
    }
}
