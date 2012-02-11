// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, Block, TileEntityPiston, Tessellator, 
//            RenderHelper, RenderBlocks, BlockPistonBase, BlockPistonExtension, 
//            World, TileEntity

public class TileEntityRendererPiston extends TileEntitySpecialRenderer
{

    private RenderBlocks field_31071_b;

    public TileEntityRendererPiston()
    {
    }

    public void func_31070_a(TileEntityPiston tileentitypiston, double d, double d1, double d2, 
            float f)
    {
        Block block = Block.field_345_n[tileentitypiston.func_31016_a()];
        if(block != null && tileentitypiston.func_31008_a(f) < 1.0F)
        {
            Tessellator tessellator = Tessellator.field_1512_a;
            func_6507_a("/terrain.png");
            RenderHelper.func_1159_a();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            if(Minecraft.func_22005_v())
            {
                GL11.glShadeModel(7425);
            } else
            {
                GL11.glShadeModel(7424);
            }
            tessellator.func_977_b();
            tessellator.func_984_b(((float)d - (float)tileentitypiston.field_823_f) + tileentitypiston.func_31017_b(f), ((float)d1 - (float)tileentitypiston.field_822_g) + tileentitypiston.func_31014_c(f), ((float)d2 - (float)tileentitypiston.field_821_h) + tileentitypiston.func_31013_d(f));
            tessellator.func_979_a(1, 1, 1);
            if(block == Block.field_9269_aa && tileentitypiston.func_31008_a(f) < 0.5F)
            {
                field_31071_b.func_31079_a(block, tileentitypiston.field_823_f, tileentitypiston.field_822_g, tileentitypiston.field_821_h, false);
            } else
            if(tileentitypiston.func_31012_k() && !tileentitypiston.func_31015_b())
            {
                Block.field_9269_aa.func_31052_a_(((BlockPistonBase)block).func_31040_i());
                field_31071_b.func_31079_a(Block.field_9269_aa, tileentitypiston.field_823_f, tileentitypiston.field_822_g, tileentitypiston.field_821_h, tileentitypiston.func_31008_a(f) < 0.5F);
                Block.field_9269_aa.func_31051_a();
                tessellator.func_984_b((float)d - (float)tileentitypiston.field_823_f, (float)d1 - (float)tileentitypiston.field_822_g, (float)d2 - (float)tileentitypiston.field_821_h);
                field_31071_b.func_31078_d(block, tileentitypiston.field_823_f, tileentitypiston.field_822_g, tileentitypiston.field_821_h);
            } else
            {
                field_31071_b.func_31075_a(block, tileentitypiston.field_823_f, tileentitypiston.field_822_g, tileentitypiston.field_821_h);
            }
            tessellator.func_984_b(0.0D, 0.0D, 0.0D);
            tessellator.func_982_a();
            RenderHelper.func_1158_b();
        }
    }

    public void func_31069_a(World world)
    {
        field_31071_b = new RenderBlocks(world);
    }

    public void func_930_a(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        func_31070_a((TileEntityPiston)tileentity, d, d1, d2, f);
    }
}
