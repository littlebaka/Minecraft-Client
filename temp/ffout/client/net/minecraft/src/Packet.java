// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IntHashMap, PacketCount, ItemStack, Item, 
//            CompressedStreamTools, Packet0KeepAlive, Packet1Login, Packet2Handshake, 
//            Packet3Chat, Packet4UpdateTime, Packet5PlayerInventory, Packet6SpawnPosition, 
//            Packet7UseEntity, Packet8UpdateHealth, Packet9Respawn, Packet10Flying, 
//            Packet11PlayerPosition, Packet12PlayerLook, Packet13PlayerLookMove, Packet14BlockDig, 
//            Packet15Place, Packet16BlockItemSwitch, Packet17Sleep, Packet18Animation, 
//            Packet19EntityAction, Packet20NamedEntitySpawn, Packet21PickupSpawn, Packet22Collect, 
//            Packet23VehicleSpawn, Packet24MobSpawn, Packet25EntityPainting, Packet26EntityExpOrb, 
//            Packet28EntityVelocity, Packet29DestroyEntity, Packet30Entity, Packet31RelEntityMove, 
//            Packet32EntityLook, Packet33RelEntityMoveLook, Packet34EntityTeleport, Packet38EntityStatus, 
//            Packet39AttachEntity, Packet40EntityMetadata, Packet41EntityEffect, Packet42RemoveEntityEffect, 
//            Packet43Experience, Packet50PreChunk, Packet51MapChunk, Packet52MultiBlockChange, 
//            Packet53BlockChange, Packet54PlayNoteBlock, Packet60Explosion, Packet61DoorChange, 
//            Packet70Bed, Packet71Weather, Packet100OpenWindow, Packet101CloseWindow, 
//            Packet102WindowClick, Packet103SetSlot, Packet104WindowItems, Packet105UpdateProgressbar, 
//            Packet106Transaction, Packet107CreativeSetSlot, Packet108EnchantItem, Packet130UpdateSign, 
//            Packet131MapData, Packet200Statistic, Packet201PlayerInfo, Packet250CustomPayload, 
//            Packet254ServerPing, Packet255KickDisconnect, NetHandler, NBTTagCompound

public abstract class Packet
{

    public static IntHashMap field_471_a = new IntHashMap();
    private static Map field_470_b = new HashMap();
    private static Set field_26906_c = new HashSet();
    private static Set field_26905_d = new HashSet();
    public final long field_20018_j = System.currentTimeMillis();
    public boolean field_472_j;

    public Packet()
    {
        field_472_j = false;
    }

    static void func_321_a(int i, boolean flag, boolean flag1, Class class1)
    {
        if(field_471_a.func_35858_b(i))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet id:").append(i).toString());
        }
        if(field_470_b.containsKey(class1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet class:").append(class1).toString());
        }
        field_471_a.func_1061_a(i, class1);
        field_470_b.put(class1, Integer.valueOf(i));
        if(flag)
        {
            field_26906_c.add(Integer.valueOf(i));
        }
        if(flag1)
        {
            field_26905_d.add(Integer.valueOf(i));
        }
    }

    public static Packet func_325_a(int i)
    {
        try
        {
            Class class1 = (Class)field_471_a.func_1057_a(i);
            if(class1 == null)
            {
                return null;
            } else
            {
                return (Packet)class1.newInstance();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        System.out.println((new StringBuilder()).append("Skipping packet with id ").append(i).toString());
        return null;
    }

    public final int func_326_b()
    {
        return ((Integer)field_470_b.get(getClass())).intValue();
    }

    public static Packet func_324_b(DataInputStream datainputstream, boolean flag)
        throws IOException
    {
        int i = 0;
        Packet packet = null;
        try
        {
            i = datainputstream.read();
            if(i == -1)
            {
                return null;
            }
            if(flag && !field_26905_d.contains(Integer.valueOf(i)) || !flag && !field_26906_c.contains(Integer.valueOf(i)))
            {
                throw new IOException((new StringBuilder()).append("Bad packet id ").append(i).toString());
            }
            packet = func_325_a(i);
            if(packet == null)
            {
                throw new IOException((new StringBuilder()).append("Bad packet id ").append(i).toString());
            }
            packet.func_327_a(datainputstream);
        }
        catch(EOFException eofexception)
        {
            System.out.println("Reached end of stream");
            return null;
        }
        PacketCount.func_40561_a(i, packet.func_329_a());
        return packet;
    }

    public static void func_328_a(Packet packet, DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.write(packet.func_326_b());
        packet.func_322_a(dataoutputstream);
    }

    public static void func_27049_a(String s, DataOutputStream dataoutputstream)
        throws IOException
    {
        if(s.length() > 32767)
        {
            throw new IOException("String too big");
        } else
        {
            dataoutputstream.writeShort(s.length());
            dataoutputstream.writeChars(s);
            return;
        }
    }

    public static String func_27048_a(DataInputStream datainputstream, int i)
        throws IOException
    {
        short word0 = datainputstream.readShort();
        if(word0 > i)
        {
            throw new IOException((new StringBuilder()).append("Received string length longer than maximum allowed (").append(word0).append(" > ").append(i).append(")").toString());
        }
        if(word0 < 0)
        {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        StringBuilder stringbuilder = new StringBuilder();
        for(int j = 0; j < word0; j++)
        {
            stringbuilder.append(datainputstream.readChar());
        }

        return stringbuilder.toString();
    }

    public abstract void func_327_a(DataInputStream datainputstream)
        throws IOException;

    public abstract void func_322_a(DataOutputStream dataoutputstream)
        throws IOException;

    public abstract void func_323_a(NetHandler nethandler);

    public abstract int func_329_a();

    protected ItemStack func_40187_b(DataInputStream datainputstream)
        throws IOException
    {
        ItemStack itemstack = null;
        short word0 = datainputstream.readShort();
        if(word0 >= 0)
        {
            byte byte0 = datainputstream.readByte();
            short word1 = datainputstream.readShort();
            itemstack = new ItemStack(word0, byte0, word1);
            if(Item.field_233_c[word0].func_25007_g() || Item.field_233_c[word0].func_46056_k())
            {
                itemstack.field_40715_d = func_40186_c(datainputstream);
            }
        }
        return itemstack;
    }

    protected void func_40188_a(ItemStack itemstack, DataOutputStream dataoutputstream)
        throws IOException
    {
        if(itemstack == null)
        {
            dataoutputstream.writeShort(-1);
        } else
        {
            dataoutputstream.writeShort(itemstack.field_1617_c);
            dataoutputstream.writeByte(itemstack.field_1615_a);
            dataoutputstream.writeShort(itemstack.func_21181_i());
            if(itemstack.func_1091_a().func_25007_g() || itemstack.func_1091_a().func_46056_k())
            {
                func_40189_a(itemstack.field_40715_d, dataoutputstream);
            }
        }
    }

    protected NBTTagCompound func_40186_c(DataInputStream datainputstream)
        throws IOException
    {
        short word0 = datainputstream.readShort();
        if(word0 < 0)
        {
            return null;
        } else
        {
            byte abyte0[] = new byte[word0];
            datainputstream.readFully(abyte0);
            return CompressedStreamTools.func_40592_a(abyte0);
        }
    }

    protected void func_40189_a(NBTTagCompound nbttagcompound, DataOutputStream dataoutputstream)
        throws IOException
    {
        if(nbttagcompound == null)
        {
            dataoutputstream.writeShort(-1);
        } else
        {
            byte abyte0[] = CompressedStreamTools.func_40591_a(nbttagcompound);
            dataoutputstream.writeShort((short)abyte0.length);
            dataoutputstream.write(abyte0);
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static 
    {
        func_321_a(0, true, true, net.minecraft.src.Packet0KeepAlive.class);
        func_321_a(1, true, true, net.minecraft.src.Packet1Login.class);
        func_321_a(2, true, true, net.minecraft.src.Packet2Handshake.class);
        func_321_a(3, true, true, net.minecraft.src.Packet3Chat.class);
        func_321_a(4, true, false, net.minecraft.src.Packet4UpdateTime.class);
        func_321_a(5, true, false, net.minecraft.src.Packet5PlayerInventory.class);
        func_321_a(6, true, false, net.minecraft.src.Packet6SpawnPosition.class);
        func_321_a(7, false, true, net.minecraft.src.Packet7UseEntity.class);
        func_321_a(8, true, false, net.minecraft.src.Packet8UpdateHealth.class);
        func_321_a(9, true, true, net.minecraft.src.Packet9Respawn.class);
        func_321_a(10, true, true, net.minecraft.src.Packet10Flying.class);
        func_321_a(11, true, true, net.minecraft.src.Packet11PlayerPosition.class);
        func_321_a(12, true, true, net.minecraft.src.Packet12PlayerLook.class);
        func_321_a(13, true, true, net.minecraft.src.Packet13PlayerLookMove.class);
        func_321_a(14, false, true, net.minecraft.src.Packet14BlockDig.class);
        func_321_a(15, false, true, net.minecraft.src.Packet15Place.class);
        func_321_a(16, false, true, net.minecraft.src.Packet16BlockItemSwitch.class);
        func_321_a(17, true, false, net.minecraft.src.Packet17Sleep.class);
        func_321_a(18, true, true, net.minecraft.src.Packet18Animation.class);
        func_321_a(19, false, true, net.minecraft.src.Packet19EntityAction.class);
        func_321_a(20, true, false, net.minecraft.src.Packet20NamedEntitySpawn.class);
        func_321_a(21, true, false, net.minecraft.src.Packet21PickupSpawn.class);
        func_321_a(22, true, false, net.minecraft.src.Packet22Collect.class);
        func_321_a(23, true, false, net.minecraft.src.Packet23VehicleSpawn.class);
        func_321_a(24, true, false, net.minecraft.src.Packet24MobSpawn.class);
        func_321_a(25, true, false, net.minecraft.src.Packet25EntityPainting.class);
        func_321_a(26, true, false, net.minecraft.src.Packet26EntityExpOrb.class);
        func_321_a(28, true, false, net.minecraft.src.Packet28EntityVelocity.class);
        func_321_a(29, true, false, net.minecraft.src.Packet29DestroyEntity.class);
        func_321_a(30, true, false, net.minecraft.src.Packet30Entity.class);
        func_321_a(31, true, false, net.minecraft.src.Packet31RelEntityMove.class);
        func_321_a(32, true, false, net.minecraft.src.Packet32EntityLook.class);
        func_321_a(33, true, false, net.minecraft.src.Packet33RelEntityMoveLook.class);
        func_321_a(34, true, false, net.minecraft.src.Packet34EntityTeleport.class);
        func_321_a(38, true, false, net.minecraft.src.Packet38EntityStatus.class);
        func_321_a(39, true, false, net.minecraft.src.Packet39AttachEntity.class);
        func_321_a(40, true, false, net.minecraft.src.Packet40EntityMetadata.class);
        func_321_a(41, true, false, net.minecraft.src.Packet41EntityEffect.class);
        func_321_a(42, true, false, net.minecraft.src.Packet42RemoveEntityEffect.class);
        func_321_a(43, true, false, net.minecraft.src.Packet43Experience.class);
        func_321_a(50, true, false, net.minecraft.src.Packet50PreChunk.class);
        func_321_a(51, true, false, net.minecraft.src.Packet51MapChunk.class);
        func_321_a(52, true, false, net.minecraft.src.Packet52MultiBlockChange.class);
        func_321_a(53, true, false, net.minecraft.src.Packet53BlockChange.class);
        func_321_a(54, true, false, net.minecraft.src.Packet54PlayNoteBlock.class);
        func_321_a(60, true, false, net.minecraft.src.Packet60Explosion.class);
        func_321_a(61, true, false, net.minecraft.src.Packet61DoorChange.class);
        func_321_a(70, true, false, net.minecraft.src.Packet70Bed.class);
        func_321_a(71, true, false, net.minecraft.src.Packet71Weather.class);
        func_321_a(100, true, false, net.minecraft.src.Packet100OpenWindow.class);
        func_321_a(101, true, true, net.minecraft.src.Packet101CloseWindow.class);
        func_321_a(102, false, true, net.minecraft.src.Packet102WindowClick.class);
        func_321_a(103, true, false, net.minecraft.src.Packet103SetSlot.class);
        func_321_a(104, true, false, net.minecraft.src.Packet104WindowItems.class);
        func_321_a(105, true, false, net.minecraft.src.Packet105UpdateProgressbar.class);
        func_321_a(106, true, true, net.minecraft.src.Packet106Transaction.class);
        func_321_a(107, true, true, net.minecraft.src.Packet107CreativeSetSlot.class);
        func_321_a(108, false, true, net.minecraft.src.Packet108EnchantItem.class);
        func_321_a(130, true, true, net.minecraft.src.Packet130UpdateSign.class);
        func_321_a(131, true, false, net.minecraft.src.Packet131MapData.class);
        func_321_a(200, true, false, net.minecraft.src.Packet200Statistic.class);
        func_321_a(201, true, false, net.minecraft.src.Packet201PlayerInfo.class);
        func_321_a(250, true, true, net.minecraft.src.Packet250CustomPayload.class);
        func_321_a(254, false, true, net.minecraft.src.Packet254ServerPing.class);
        func_321_a(255, true, true, net.minecraft.src.Packet255KickDisconnect.class);
    }
}
