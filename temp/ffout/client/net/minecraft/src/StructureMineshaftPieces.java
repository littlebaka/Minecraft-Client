// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentMineshaftCross, ComponentMineshaftStairs, ComponentMineshaftCorridor, StructureComponent, 
//            StructureBoundingBox, StructurePieceTreasure, Item, Block

public class StructureMineshaftPieces
{

    private static final StructurePieceTreasure field_35589_a[];

    public StructureMineshaftPieces()
    {
    }

    private static StructureComponent func_35586_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        int j1 = random.nextInt(100);
        if(j1 >= 80)
        {
            StructureBoundingBox structureboundingbox = ComponentMineshaftCross.func_35071_a(list, random, i, j, k, l);
            if(structureboundingbox != null)
            {
                return new ComponentMineshaftCross(i1, random, structureboundingbox, l);
            }
        } else
        if(j1 >= 70)
        {
            StructureBoundingBox structureboundingbox1 = ComponentMineshaftStairs.func_35027_a(list, random, i, j, k, l);
            if(structureboundingbox1 != null)
            {
                return new ComponentMineshaftStairs(i1, random, structureboundingbox1, l);
            }
        } else
        {
            StructureBoundingBox structureboundingbox2 = ComponentMineshaftCorridor.func_35066_a(list, random, i, j, k, l);
            if(structureboundingbox2 != null)
            {
                return new ComponentMineshaftCorridor(i1, random, structureboundingbox2, l);
            }
        }
        return null;
    }

    private static StructureComponent func_35587_b(StructureComponent structurecomponent, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 8)
        {
            return null;
        }
        if(Math.abs(i - structurecomponent.func_35021_b().field_35753_a) > 80 || Math.abs(k - structurecomponent.func_35021_b().field_35752_c) > 80)
        {
            return null;
        }
        StructureComponent structurecomponent1 = func_35586_a(list, random, i, j, k, l, i1 + 1);
        if(structurecomponent1 != null)
        {
            list.add(structurecomponent1);
            structurecomponent1.func_35004_a(structurecomponent, list, random);
        }
        return structurecomponent1;
    }

    static StructureComponent func_35585_a(StructureComponent structurecomponent, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35587_b(structurecomponent, list, random, i, j, k, l, i1);
    }

    static StructurePieceTreasure[] func_35588_a()
    {
        return field_35589_a;
    }

    static 
    {
        field_35589_a = (new StructurePieceTreasure[] {
            new StructurePieceTreasure(Item.field_223_m.field_291_aS, 0, 1, 5, 10), new StructurePieceTreasure(Item.field_222_n.field_291_aS, 0, 1, 3, 5), new StructurePieceTreasure(Item.field_309_aA.field_291_aS, 0, 4, 9, 5), new StructurePieceTreasure(Item.field_21021_aU.field_291_aS, 4, 4, 9, 5), new StructurePieceTreasure(Item.field_224_l.field_291_aS, 0, 1, 2, 3), new StructurePieceTreasure(Item.field_225_k.field_291_aS, 0, 3, 8, 10), new StructurePieceTreasure(Item.field_242_S.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_231_e.field_291_aS, 0, 1, 1, 1), new StructurePieceTreasure(Block.field_440_aH.field_376_bc, 0, 4, 8, 1), new StructurePieceTreasure(Item.field_35423_bi.field_291_aS, 0, 2, 4, 10), 
            new StructurePieceTreasure(Item.field_35422_bh.field_291_aS, 0, 2, 4, 10)
        });
    }
}
