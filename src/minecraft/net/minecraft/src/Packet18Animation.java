package net.minecraft.src;

import java.io.*;

public class Packet18Animation extends Packet
{
    public int entityId;
    public int animate;

    public Packet18Animation()
    {
    }

    public Packet18Animation(Entity entity, int i)
    {
        entityId = entity.entityId;
        animate = i;
    }

    public void readPacketData(DataInputStream datainputstream)
    throws IOException
    {
        entityId = datainputstream.readInt();
        animate = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
    throws IOException
    {
        dataoutputstream.writeInt(entityId);
        dataoutputstream.writeByte(animate);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.handleArmAnimation(this);
    }

    public int getPacketSize()
    {
        return 5;
    }
}
