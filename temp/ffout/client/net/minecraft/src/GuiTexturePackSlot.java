// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiTexturePacks, TexturePackList, TexturePackBase, 
//            RenderEngine, Tessellator

class GuiTexturePackSlot extends GuiSlot
{

    final GuiTexturePacks field_22265_a; /* synthetic field */

    public GuiTexturePackSlot(GuiTexturePacks guitexturepacks)
    {
        field_22265_a = guitexturepacks;
        super(GuiTexturePacks.func_22124_a(guitexturepacks), guitexturepacks.field_951_c, guitexturepacks.field_950_d, 32, (guitexturepacks.field_950_d - 55) + 4, 36);
    }

    protected int func_22249_a()
    {
        List list = GuiTexturePacks.func_22126_b(field_22265_a).field_6298_C.func_6530_b();
        return list.size();
    }

    protected void func_22247_a(int i, boolean flag)
    {
        List list = GuiTexturePacks.func_22119_c(field_22265_a).field_6298_C.func_6530_b();
        try
        {
            GuiTexturePacks.func_22122_d(field_22265_a).field_6298_C.func_6531_a((TexturePackBase)list.get(i));
            GuiTexturePacks.func_22117_e(field_22265_a).field_6315_n.func_1065_b();
        }
        catch(Exception exception)
        {
            GuiTexturePacks.func_35307_f(field_22265_a).field_6298_C.func_6531_a((TexturePackBase)list.get(0));
            GuiTexturePacks.func_35308_g(field_22265_a).field_6315_n.func_1065_b();
        }
    }

    protected boolean func_22246_a(int i)
    {
        List list = GuiTexturePacks.func_22118_f(field_22265_a).field_6298_C.func_6530_b();
        return GuiTexturePacks.func_22116_g(field_22265_a).field_6298_C.field_6534_a == list.get(i);
    }

    protected int func_22245_b()
    {
        return func_22249_a() * 36;
    }

    protected void func_22248_c()
    {
        field_22265_a.func_578_i();
    }

    protected void func_22242_a(int i, int j, int k, int l, Tessellator tessellator)
    {
        TexturePackBase texturepackbase = (TexturePackBase)GuiTexturePacks.func_22121_h(field_22265_a).field_6298_C.func_6530_b().get(i);
        texturepackbase.func_6483_c(GuiTexturePacks.func_22123_i(field_22265_a));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.func_977_b();
        tessellator.func_990_b(0xffffff);
        tessellator.func_983_a(j, k + l, 0.0D, 0.0D, 1.0D);
        tessellator.func_983_a(j + 32, k + l, 0.0D, 1.0D, 1.0D);
        tessellator.func_983_a(j + 32, k, 0.0D, 1.0D, 0.0D);
        tessellator.func_983_a(j, k, 0.0D, 0.0D, 0.0D);
        tessellator.func_982_a();
        field_22265_a.func_547_b(GuiTexturePacks.func_22127_j(field_22265_a), texturepackbase.field_6487_a, j + 32 + 2, k + 1, 0xffffff);
        field_22265_a.func_547_b(GuiTexturePacks.func_22120_k(field_22265_a), texturepackbase.field_6486_b, j + 32 + 2, k + 12, 0x808080);
        field_22265_a.func_547_b(GuiTexturePacks.func_22125_l(field_22265_a), texturepackbase.field_6489_c, j + 32 + 2, k + 12 + 10, 0x808080);
    }
}
