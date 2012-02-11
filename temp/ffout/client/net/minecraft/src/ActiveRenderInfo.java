// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MathHelper, EntityLiving, Vec3D, 
//            ChunkPosition, World, Block, Material, 
//            BlockFluid, GLAllocation

public class ActiveRenderInfo
{

    public static float field_41074_a = 0.0F;
    public static float field_41072_b = 0.0F;
    public static float field_41073_c = 0.0F;
    private static IntBuffer field_41079_i = GLAllocation.func_1125_c(16);
    private static FloatBuffer field_41076_j = GLAllocation.func_1123_d(16);
    private static FloatBuffer field_41077_k = GLAllocation.func_1123_d(16);
    private static FloatBuffer field_41075_l = GLAllocation.func_1123_d(3);
    public static float field_41070_d;
    public static float field_41071_e;
    public static float field_41068_f;
    public static float field_41069_g;
    public static float field_41078_h;

    public ActiveRenderInfo()
    {
    }

    public static void func_41067_a(EntityPlayer entityplayer, boolean flag)
    {
        GL11.glGetFloat(2982, field_41076_j);
        GL11.glGetFloat(2983, field_41077_k);
        GL11.glGetInteger(2978, field_41079_i);
        float f = (field_41079_i.get(0) + field_41079_i.get(2)) / 2;
        float f1 = (field_41079_i.get(1) + field_41079_i.get(3)) / 2;
        GLU.gluUnProject(f, f1, 0.0F, field_41076_j, field_41077_k, field_41079_i, field_41075_l);
        field_41074_a = field_41075_l.get(0);
        field_41072_b = field_41075_l.get(1);
        field_41073_c = field_41075_l.get(2);
        int i = flag ? 1 : 0;
        float f2 = entityplayer.field_604_ar;
        float f3 = entityplayer.field_605_aq;
        field_41070_d = MathHelper.func_1114_b((f3 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_41068_f = MathHelper.func_1106_a((f3 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_41069_g = -field_41068_f * MathHelper.func_1106_a((f2 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_41078_h = field_41070_d * MathHelper.func_1106_a((f2 * 3.141593F) / 180F) * (float)(1 - i * 2);
        field_41071_e = MathHelper.func_1114_b((f2 * 3.141593F) / 180F);
    }

    public static Vec3D func_41065_a(EntityLiving entityliving, double d)
    {
        double d1 = entityliving.field_9285_at + (entityliving.field_611_ak - entityliving.field_9285_at) * d;
        double d2 = entityliving.field_9284_au + (entityliving.field_610_al - entityliving.field_9284_au) * d + (double)entityliving.func_373_s();
        double d3 = entityliving.field_9283_av + (entityliving.field_609_am - entityliving.field_9283_av) * d;
        double d4 = d1 + (double)(field_41074_a * 1.0F);
        double d5 = d2 + (double)(field_41072_b * 1.0F);
        double d6 = d3 + (double)(field_41073_c * 1.0F);
        return Vec3D.func_1248_b(d4, d5, d6);
    }

    public static int func_41066_a(World world, EntityLiving entityliving, float f)
    {
        Vec3D vec3d = func_41065_a(entityliving, f);
        ChunkPosition chunkposition = new ChunkPosition(vec3d);
        int i = world.func_600_a(chunkposition.field_1111_a, chunkposition.field_1110_b, chunkposition.field_1112_c);
        if(i != 0 && Block.field_345_n[i].field_356_bn.func_879_d())
        {
            float f1 = BlockFluid.func_288_b(world.func_602_e(chunkposition.field_1111_a, chunkposition.field_1110_b, chunkposition.field_1112_c)) - 0.1111111F;
            float f2 = (float)(chunkposition.field_1110_b + 1) - f1;
            if(vec3d.field_1775_b >= (double)f2)
            {
                i = world.func_600_a(chunkposition.field_1111_a, chunkposition.field_1110_b + 1, chunkposition.field_1112_c);
            }
        }
        return i;
    }

}
