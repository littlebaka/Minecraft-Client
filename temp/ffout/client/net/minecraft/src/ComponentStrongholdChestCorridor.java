// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, StructurePieceTreasure, 
//            Item, World

public class ComponentStrongholdChestCorridor extends ComponentStronghold
{

    private static final StructurePieceTreasure field_40013_a[];
    private final EnumDoor field_40011_b;
    private boolean field_40012_c;

    public ComponentStrongholdChestCorridor(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_40011_b = func_35031_a(random);
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_35028_a((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
    }

    public static ComponentStrongholdChestCorridor func_40010_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 5, 5, 7, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdChestCorridor(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35022_a(world, structureboundingbox, 0, 0, 0, 4, 4, 6, true, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, field_40011_b, 1, 1, 0);
        func_35033_a(world, random, structureboundingbox, EnumDoor.OPENING, 1, 1, 6);
        func_35011_a(world, structureboundingbox, 3, 1, 2, 3, 1, 4, Block.field_35285_bn.field_376_bc, Block.field_35285_bn.field_376_bc, false);
        func_35018_a(world, Block.field_410_al.field_376_bc, 5, 3, 1, 1, structureboundingbox);
        func_35018_a(world, Block.field_410_al.field_376_bc, 5, 3, 1, 5, structureboundingbox);
        func_35018_a(world, Block.field_410_al.field_376_bc, 5, 3, 2, 2, structureboundingbox);
        func_35018_a(world, Block.field_410_al.field_376_bc, 5, 3, 2, 4, structureboundingbox);
        for(int i = 2; i <= 4; i++)
        {
            func_35018_a(world, Block.field_410_al.field_376_bc, 5, 2, 1, i, structureboundingbox);
        }

        if(!field_40012_c)
        {
            int j = func_35008_a(2);
            int k = func_35017_a(3, 3);
            int l = func_35006_b(3, 3);
            if(structureboundingbox.func_35742_b(k, j, l))
            {
                field_40012_c = true;
                func_35003_a(world, structureboundingbox, random, 3, 2, 3, field_40013_a, 2 + random.nextInt(2));
            }
        }
        return true;
    }

    static 
    {
        field_40013_a = (new StructurePieceTreasure[] {
            new StructurePieceTreasure(Item.field_35416_bo.field_291_aS, 0, 1, 1, 10), new StructurePieceTreasure(Item.field_224_l.field_291_aS, 0, 1, 3, 3), new StructurePieceTreasure(Item.field_223_m.field_291_aS, 0, 1, 5, 10), new StructurePieceTreasure(Item.field_222_n.field_291_aS, 0, 1, 3, 5), new StructurePieceTreasure(Item.field_309_aA.field_291_aS, 0, 4, 9, 5), new StructurePieceTreasure(Item.field_242_S.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_228_h.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_231_e.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_221_o.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_284_ac.field_291_aS, 0, 1, 1, 5), 
            new StructurePieceTreasure(Item.field_285_ab.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_283_ad.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_282_ae.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_269_ar.field_291_aS, 0, 1, 1, 1)
        });
    }
}
