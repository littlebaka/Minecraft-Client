// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderManager, Entity, FontRenderer, 
//            mod_splashFX, SplashEffects, EntityDSplashFX

public class RenderDSplashFX extends Render
{

    mod_splashFX splash;

    public RenderDSplashFX()
    {
    }

    protected void renderLivingLabel(Entity entity, String s, double d, double d1, double d2, int i, int j, int k)
    {
        float f = entity.getDistanceToEntity(renderManager.livingPlayer);
        if(f > (float)i)
        {
            return;
        } else
        {
            FontRenderer fontrenderer = getFontRendererFromRenderManager();
            float f1 = 1.6F;
            float f2 = 0.01666667F * f1;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.0F, (float)d1, (float)d2);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-f2, -f2, f2);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
            GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
            GL11.glDepthMask(true);
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glBlendFunc(770, 771);
            fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2 + 1, 0, j);
            fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2 - 1, 0, j);
            fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, 1, j);
            fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, -1, j);
            fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, 0, k);
            GL11.glDepthMask(false);
            GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
            GL11.glEnable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
            GL11.glDisable(3042 /*GL_BLEND*/);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            return;
        }
    }

    public void func_35438_a(EntityDSplashFX entitydsplashfx, double d, double d1, double d2, 
            float f, float f1)
    {
        SplashEffects _tmp = mod_splashFX.effects;
        if(SplashEffects.toggleMain)
        {
            renderLivingLabel(entitydsplashfx, entitydsplashfx.typePassed, d, d1, d2, 15, entitydsplashfx.colorBackgroundPassed + entitydsplashfx.fadeout, entitydsplashfx.colorForegroundPassed + entitydsplashfx.fadeout);
        }
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_35438_a((EntityDSplashFX)entity, d, d1, d2, f, f1);
    }
}
