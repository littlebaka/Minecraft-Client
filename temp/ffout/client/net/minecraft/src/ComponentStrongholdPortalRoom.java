// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, World, 
//            TileEntityMobSpawner

public class ComponentStrongholdPortalRoom extends ComponentStronghold
{

    private boolean field_40015_a;

    public ComponentStrongholdPortalRoom(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        if(structurecomponent != null)
        {
            ((ComponentStrongholdStairs2)structurecomponent).field_40009_b = this;
        }
    }

    public static ComponentStrongholdPortalRoom func_40014_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -4, -1, 0, 11, 8, 16, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdPortalRoom(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35022_a(world, structureboundingbox, 0, 0, 0, 10, 7, 15, false, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, EnumDoor.GRATES, 4, 1, 0);
        byte byte0 = 6;
        func_35022_a(world, structureboundingbox, 1, byte0, 1, 1, byte0, 14, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 9, byte0, 1, 9, byte0, 14, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 2, byte0, 1, 8, byte0, 2, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 2, byte0, 14, 8, byte0, 14, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 1, 1, 1, 2, 1, 4, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 8, 1, 1, 9, 1, 4, false, random, StructureStrongholdPieces.func_35852_b());
        func_35011_a(world, structureboundingbox, 1, 1, 1, 1, 1, 3, Block.field_397_D.field_376_bc, Block.field_397_D.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 9, 1, 1, 9, 1, 3, Block.field_397_D.field_376_bc, Block.field_397_D.field_376_bc, false);
        func_35022_a(world, structureboundingbox, 3, 1, 8, 7, 1, 12, false, random, StructureStrongholdPieces.func_35852_b());
        func_35011_a(world, structureboundingbox, 4, 1, 9, 6, 1, 11, Block.field_397_D.field_376_bc, Block.field_397_D.field_376_bc, false);
        for(int j = 3; j < 14; j += 2)
        {
            func_35011_a(world, structureboundingbox, 0, 3, j, 0, 4, j, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
            func_35011_a(world, structureboundingbox, 10, 3, j, 10, 4, j, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
        }

        for(int k = 2; k < 9; k += 2)
        {
            func_35011_a(world, structureboundingbox, k, 3, 15, k, 4, 15, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
        }

        int l = func_35009_c(Block.field_35279_by.field_376_bc, 3);
        func_35022_a(world, structureboundingbox, 4, 1, 5, 6, 1, 7, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 4, 2, 6, 6, 2, 7, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 4, 3, 7, 6, 3, 7, false, random, StructureStrongholdPieces.func_35852_b());
        for(int i1 = 4; i1 <= 6; i1++)
        {
            func_35018_a(world, Block.field_35279_by.field_376_bc, l, i1, 1, 4, structureboundingbox);
            func_35018_a(world, Block.field_35279_by.field_376_bc, l, i1, 2, 5, structureboundingbox);
            func_35018_a(world, Block.field_35279_by.field_376_bc, l, i1, 3, 6, structureboundingbox);
        }

        byte byte1 = 2;
        byte byte2 = 0;
        byte byte3 = 3;
        byte byte4 = 1;
        switch(field_35025_h)
        {
        case 0: // '\0'
            byte1 = 0;
            byte2 = 2;
            break;

        case 3: // '\003'
            byte1 = 3;
            byte2 = 1;
            byte3 = 0;
            byte4 = 2;
            break;

        case 1: // '\001'
            byte1 = 1;
            byte2 = 3;
            byte3 = 0;
            byte4 = 2;
            break;
        }
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte1 + (random.nextFloat() <= 0.9F ? 0 : 4), 4, 3, 8, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte1 + (random.nextFloat() <= 0.9F ? 0 : 4), 5, 3, 8, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte1 + (random.nextFloat() <= 0.9F ? 0 : 4), 6, 3, 8, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte2 + (random.nextFloat() <= 0.9F ? 0 : 4), 4, 3, 12, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte2 + (random.nextFloat() <= 0.9F ? 0 : 4), 5, 3, 12, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte2 + (random.nextFloat() <= 0.9F ? 0 : 4), 6, 3, 12, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte3 + (random.nextFloat() <= 0.9F ? 0 : 4), 3, 3, 9, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte3 + (random.nextFloat() <= 0.9F ? 0 : 4), 3, 3, 10, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte3 + (random.nextFloat() <= 0.9F ? 0 : 4), 3, 3, 11, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte4 + (random.nextFloat() <= 0.9F ? 0 : 4), 7, 3, 9, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte4 + (random.nextFloat() <= 0.9F ? 0 : 4), 7, 3, 10, structureboundingbox);
        func_35018_a(world, Block.field_40202_bJ.field_376_bc, byte4 + (random.nextFloat() <= 0.9F ? 0 : 4), 7, 3, 11, structureboundingbox);
        if(!field_40015_a)
        {
            int i = func_35008_a(3);
            int j1 = func_35017_a(5, 6);
            int k1 = func_35006_b(5, 6);
            if(structureboundingbox.func_35742_b(j1, i, k1))
            {
                field_40015_a = true;
                world.func_690_d(j1, i, k1, Block.field_400_at.field_376_bc);
                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.func_603_b(j1, i, k1);
                if(tileentitymobspawner != null)
                {
                    tileentitymobspawner.func_21098_a("Silverfish");
                }
            }
        }
        return true;
    }
}
