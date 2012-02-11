// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillageWell, WorldChunkManager, StructureVillagePieceWeight

public class ComponentVillageStartPiece extends ComponentVillageWell
{

    public WorldChunkManager field_35111_a;
    public int field_35109_b;
    public StructureVillagePieceWeight field_35110_c;
    public ArrayList field_35107_d;
    public ArrayList field_35108_e;
    public ArrayList field_35106_f;

    public ComponentVillageStartPiece(WorldChunkManager worldchunkmanager, int i, Random random, int j, int k, ArrayList arraylist, int l)
    {
        super(0, random, j, k);
        field_35108_e = new ArrayList();
        field_35106_f = new ArrayList();
        field_35111_a = worldchunkmanager;
        field_35107_d = arraylist;
        field_35109_b = l;
    }

    public WorldChunkManager func_35105_a()
    {
        return field_35111_a;
    }
}
