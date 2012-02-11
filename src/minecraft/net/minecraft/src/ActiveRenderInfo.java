package net.minecraft.src;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ActiveRenderInfo
{
    public static float objectX = 0.0F;
    public static float objectY = 0.0F;
    public static float objectZ = 0.0F;
    private static IntBuffer viewport = GLAllocation.createDirectIntBuffer(16);
    private static FloatBuffer modelview = GLAllocation.createDirectFloatBuffer(16);
    private static FloatBuffer projection = GLAllocation.createDirectFloatBuffer(16);
    private static FloatBuffer objectCoords = GLAllocation.createDirectFloatBuffer(3);
    public static float rotationX;
    public static float rotationXZ;
    public static float rotationZ;
    public static float rotationYZ;
    public static float rotationXY;

    public ActiveRenderInfo()
    {
    }

    public static void updateRenderInfo(EntityPlayer entityplayer, boolean flag)
    {
        GL11.glGetFloat(2982 /*GL_MODELVIEW_MATRIX*/, modelview);
        GL11.glGetFloat(2983 /*GL_PROJECTION_MATRIX*/, projection);
        GL11.glGetInteger(2978 /*GL_VIEWPORT*/, viewport);
        float f = (viewport.get(0) + viewport.get(2)) / 2;
        float f1 = (viewport.get(1) + viewport.get(3)) / 2;
        GLU.gluUnProject(f, f1, 0.0F, modelview, projection, viewport, objectCoords);
        objectX = objectCoords.get(0);
        objectY = objectCoords.get(1);
        objectZ = objectCoords.get(2);
        int i = flag ? 1 : 0;
        float f2 = entityplayer.rotationPitch;
        float f3 = entityplayer.rotationYaw;
        rotationX = MathHelper.cos((f3 * 3.141593F) / 180F) * (float)(1 - i * 2);
        rotationZ = MathHelper.sin((f3 * 3.141593F) / 180F) * (float)(1 - i * 2);
        rotationYZ = -rotationZ * MathHelper.sin((f2 * 3.141593F) / 180F) * (float)(1 - i * 2);
        rotationXY = rotationX * MathHelper.sin((f2 * 3.141593F) / 180F) * (float)(1 - i * 2);
        rotationXZ = MathHelper.cos((f2 * 3.141593F) / 180F);
    }

    public static Vec3D projectViewFromEntity(EntityLiving entityliving, double d)
    {
        double d1 = entityliving.prevPosX + (entityliving.posX - entityliving.prevPosX) * d;
        double d2 = entityliving.prevPosY + (entityliving.posY - entityliving.prevPosY) * d + (double)entityliving.getEyeHeight();
        double d3 = entityliving.prevPosZ + (entityliving.posZ - entityliving.prevPosZ) * d;
        double d4 = d1 + (double)(objectX * 1.0F);
        double d5 = d2 + (double)(objectY * 1.0F);
        double d6 = d3 + (double)(objectZ * 1.0F);
        return Vec3D.createVector(d4, d5, d6);
    }

    public static int getBlockIdAtEntityViewpoint(World world, EntityLiving entityliving, float f)
    {
        Vec3D vec3d = projectViewFromEntity(entityliving, f);
        ChunkPosition chunkposition = new ChunkPosition(vec3d);
        int i = world.getBlockId(chunkposition.x, chunkposition.y, chunkposition.z);
        if (i != 0 && Block.blocksList[i].blockMaterial.getIsLiquid())
        {
            float f1 = BlockFluid.getFluidHeightPercent(world.getBlockMetadata(chunkposition.x, chunkposition.y, chunkposition.z)) - 0.1111111F;
            float f2 = (float)(chunkposition.y + 1) - f1;
            if (vec3d.yCoord >= (double)f2)
            {
                i = world.getBlockId(chunkposition.x, chunkposition.y + 1, chunkposition.z);
            }
        }
        return i;
    }
}
