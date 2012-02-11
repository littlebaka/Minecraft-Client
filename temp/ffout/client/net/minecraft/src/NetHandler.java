// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Packet51MapChunk, Packet, Packet255KickDisconnect, Packet1Login, 
//            Packet10Flying, Packet52MultiBlockChange, Packet14BlockDig, Packet53BlockChange, 
//            Packet50PreChunk, Packet20NamedEntitySpawn, Packet30Entity, Packet34EntityTeleport, 
//            Packet15Place, Packet16BlockItemSwitch, Packet29DestroyEntity, Packet21PickupSpawn, 
//            Packet22Collect, Packet3Chat, Packet23VehicleSpawn, Packet18Animation, 
//            Packet19EntityAction, Packet2Handshake, Packet24MobSpawn, Packet4UpdateTime, 
//            Packet6SpawnPosition, Packet28EntityVelocity, Packet40EntityMetadata, Packet39AttachEntity, 
//            Packet7UseEntity, Packet38EntityStatus, Packet8UpdateHealth, Packet9Respawn, 
//            Packet60Explosion, Packet100OpenWindow, Packet101CloseWindow, Packet102WindowClick, 
//            Packet103SetSlot, Packet104WindowItems, Packet130UpdateSign, Packet105UpdateProgressbar, 
//            Packet5PlayerInventory, Packet106Transaction, Packet25EntityPainting, Packet54PlayNoteBlock, 
//            Packet200Statistic, Packet17Sleep, Packet70Bed, Packet71Weather, 
//            Packet131MapData, Packet61DoorChange, Packet254ServerPing, Packet41EntityEffect, 
//            Packet42RemoveEntityEffect, Packet201PlayerInfo, Packet0KeepAlive, Packet43Experience, 
//            Packet107CreativeSetSlot, Packet26EntityExpOrb, Packet108EnchantItem, Packet250CustomPayload

public abstract class NetHandler
{

    public NetHandler()
    {
    }

    public abstract boolean func_27247_c();

    public void func_833_a(Packet51MapChunk packet51mapchunk)
    {
    }

    public void func_4114_b(Packet packet)
    {
    }

    public void func_823_a(String s, Object aobj[])
    {
    }

    public void func_844_a(Packet255KickDisconnect packet255kickdisconnect)
    {
        func_4114_b(packet255kickdisconnect);
    }

    public void func_4115_a(Packet1Login packet1login)
    {
        func_4114_b(packet1login);
    }

    public void func_837_a(Packet10Flying packet10flying)
    {
        func_4114_b(packet10flying);
    }

    public void func_824_a(Packet52MultiBlockChange packet52multiblockchange)
    {
        func_4114_b(packet52multiblockchange);
    }

    public void func_821_a(Packet14BlockDig packet14blockdig)
    {
        func_4114_b(packet14blockdig);
    }

    public void func_822_a(Packet53BlockChange packet53blockchange)
    {
        func_4114_b(packet53blockchange);
    }

    public void func_826_a(Packet50PreChunk packet50prechunk)
    {
        func_4114_b(packet50prechunk);
    }

    public void func_820_a(Packet20NamedEntitySpawn packet20namedentityspawn)
    {
        func_4114_b(packet20namedentityspawn);
    }

    public void func_827_a(Packet30Entity packet30entity)
    {
        func_4114_b(packet30entity);
    }

    public void func_829_a(Packet34EntityTeleport packet34entityteleport)
    {
        func_4114_b(packet34entityteleport);
    }

    public void func_819_a(Packet15Place packet15place)
    {
        func_4114_b(packet15place);
    }

    public void func_841_a(Packet16BlockItemSwitch packet16blockitemswitch)
    {
        func_4114_b(packet16blockitemswitch);
    }

    public void func_839_a(Packet29DestroyEntity packet29destroyentity)
    {
        func_4114_b(packet29destroyentity);
    }

    public void func_832_a(Packet21PickupSpawn packet21pickupspawn)
    {
        func_4114_b(packet21pickupspawn);
    }

    public void func_834_a(Packet22Collect packet22collect)
    {
        func_4114_b(packet22collect);
    }

    public void func_4113_a(Packet3Chat packet3chat)
    {
        func_4114_b(packet3chat);
    }

    public void func_835_a(Packet23VehicleSpawn packet23vehiclespawn)
    {
        func_4114_b(packet23vehiclespawn);
    }

    public void func_825_a(Packet18Animation packet18animation)
    {
        func_4114_b(packet18animation);
    }

    public void func_21147_a(Packet19EntityAction packet19entityaction)
    {
        func_4114_b(packet19entityaction);
    }

    public void func_838_a(Packet2Handshake packet2handshake)
    {
        func_4114_b(packet2handshake);
    }

    public void func_828_a(Packet24MobSpawn packet24mobspawn)
    {
        func_4114_b(packet24mobspawn);
    }

    public void func_846_a(Packet4UpdateTime packet4updatetime)
    {
        func_4114_b(packet4updatetime);
    }

    public void func_845_a(Packet6SpawnPosition packet6spawnposition)
    {
        func_4114_b(packet6spawnposition);
    }

    public void func_6498_a(Packet28EntityVelocity packet28entityvelocity)
    {
        func_4114_b(packet28entityvelocity);
    }

    public void func_21148_a(Packet40EntityMetadata packet40entitymetadata)
    {
        func_4114_b(packet40entitymetadata);
    }

    public void func_6497_a(Packet39AttachEntity packet39attachentity)
    {
        func_4114_b(packet39attachentity);
    }

    public void func_6499_a(Packet7UseEntity packet7useentity)
    {
        func_4114_b(packet7useentity);
    }

    public void func_9447_a(Packet38EntityStatus packet38entitystatus)
    {
        func_4114_b(packet38entitystatus);
    }

    public void func_9446_a(Packet8UpdateHealth packet8updatehealth)
    {
        func_4114_b(packet8updatehealth);
    }

    public void func_9448_a(Packet9Respawn packet9respawn)
    {
        func_4114_b(packet9respawn);
    }

    public void func_12245_a(Packet60Explosion packet60explosion)
    {
        func_4114_b(packet60explosion);
    }

    public void func_20087_a(Packet100OpenWindow packet100openwindow)
    {
        func_4114_b(packet100openwindow);
    }

    public void func_20092_a(Packet101CloseWindow packet101closewindow)
    {
        func_4114_b(packet101closewindow);
    }

    public void func_20091_a(Packet102WindowClick packet102windowclick)
    {
        func_4114_b(packet102windowclick);
    }

    public void func_20088_a(Packet103SetSlot packet103setslot)
    {
        func_4114_b(packet103setslot);
    }

    public void func_20094_a(Packet104WindowItems packet104windowitems)
    {
        func_4114_b(packet104windowitems);
    }

    public void func_20093_a(Packet130UpdateSign packet130updatesign)
    {
        func_4114_b(packet130updatesign);
    }

    public void func_20090_a(Packet105UpdateProgressbar packet105updateprogressbar)
    {
        func_4114_b(packet105updateprogressbar);
    }

    public void func_843_a(Packet5PlayerInventory packet5playerinventory)
    {
        func_4114_b(packet5playerinventory);
    }

    public void func_20089_a(Packet106Transaction packet106transaction)
    {
        func_4114_b(packet106transaction);
    }

    public void func_21146_a(Packet25EntityPainting packet25entitypainting)
    {
        func_4114_b(packet25entitypainting);
    }

    public void func_21145_a(Packet54PlayNoteBlock packet54playnoteblock)
    {
        func_4114_b(packet54playnoteblock);
    }

    public void func_27245_a(Packet200Statistic packet200statistic)
    {
        func_4114_b(packet200statistic);
    }

    public void func_22186_a(Packet17Sleep packet17sleep)
    {
        func_4114_b(packet17sleep);
    }

    public void func_25118_a(Packet70Bed packet70bed)
    {
        func_4114_b(packet70bed);
    }

    public void func_27246_a(Packet71Weather packet71weather)
    {
        func_4114_b(packet71weather);
    }

    public void func_28116_a(Packet131MapData packet131mapdata)
    {
        func_4114_b(packet131mapdata);
    }

    public void func_28115_a(Packet61DoorChange packet61doorchange)
    {
        func_4114_b(packet61doorchange);
    }

    public void func_35782_a(Packet254ServerPing packet254serverping)
    {
        func_4114_b(packet254serverping);
    }

    public void func_35780_a(Packet41EntityEffect packet41entityeffect)
    {
        func_4114_b(packet41entityeffect);
    }

    public void func_35783_a(Packet42RemoveEntityEffect packet42removeentityeffect)
    {
        func_4114_b(packet42removeentityeffect);
    }

    public void func_35779_a(Packet201PlayerInfo packet201playerinfo)
    {
        func_4114_b(packet201playerinfo);
    }

    public void func_35784_a(Packet0KeepAlive packet0keepalive)
    {
        func_4114_b(packet0keepalive);
    }

    public void func_35777_a(Packet43Experience packet43experience)
    {
        func_4114_b(packet43experience);
    }

    public void func_35781_a(Packet107CreativeSetSlot packet107creativesetslot)
    {
        func_4114_b(packet107creativesetslot);
    }

    public void func_35778_a(Packet26EntityExpOrb packet26entityexporb)
    {
        func_4114_b(packet26entityexporb);
    }

    public void func_40599_a(Packet108EnchantItem packet108enchantitem)
    {
    }

    public void func_44028_a(Packet250CustomPayload packet250custompayload)
    {
    }
}
