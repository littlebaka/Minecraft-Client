package net.minecraft.src;

public interface ICamera
{
    public abstract boolean isBoundingBoxInFrustum(AxisAlignedBB axisalignedbb);

    public abstract void setPosition(double d, double d1, double d2);
}
