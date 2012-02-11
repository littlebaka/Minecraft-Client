// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillageRoadPiece, StructureBoundingBox, ComponentVillageStartPiece, StructureComponent, 
//            StructureVillagePieces, MathHelper, World, Block

public class ComponentVillagePathGen extends ComponentVillageRoadPiece
{

    private int field_35088_a;

    public ComponentVillagePathGen(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
        field_35088_a = Math.max(structureboundingbox.func_35744_b(), structureboundingbox.func_35739_d());
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        boolean flag = false;
        for(int i = random.nextInt(5); i < field_35088_a - 8; i += 2 + random.nextInt(5))
        {
            StructureComponent structurecomponent1 = func_35077_a((ComponentVillageStartPiece)structurecomponent, list, random, 0, i);
            if(structurecomponent1 != null)
            {
                i += Math.max(structurecomponent1.field_35024_g.func_35744_b(), structurecomponent1.field_35024_g.func_35739_d());
                flag = true;
            }
        }

        for(int j = random.nextInt(5); j < field_35088_a - 8; j += 2 + random.nextInt(5))
        {
            StructureComponent structurecomponent2 = func_35076_b((ComponentVillageStartPiece)structurecomponent, list, random, 0, j);
            if(structurecomponent2 != null)
            {
                j += Math.max(structurecomponent2.field_35024_g.func_35744_b(), structurecomponent2.field_35024_g.func_35739_d());
                flag = true;
            }
        }

        if(flag && random.nextInt(3) > 0)
        {
            switch(field_35025_h)
            {
            case 2: // '\002'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c, 1, func_35012_c());
                break;

            case 0: // '\0'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f - 2, 1, func_35012_c());
                break;

            case 3: // '\003'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35749_d - 2, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, func_35012_c());
                break;

            case 1: // '\001'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a, field_35024_g.field_35751_b, field_35024_g.field_35752_c - 1, 2, func_35012_c());
                break;
            }
        }
        if(flag && random.nextInt(3) > 0)
        {
            switch(field_35025_h)
            {
            case 2: // '\002'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, field_35024_g.field_35752_c, 3, func_35012_c());
                break;

            case 0: // '\0'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b, field_35024_g.field_35748_f - 2, 3, func_35012_c());
                break;

            case 3: // '\003'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35749_d - 2, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, func_35012_c());
                break;

            case 1: // '\001'
                StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)structurecomponent, list, random, field_35024_g.field_35753_a, field_35024_g.field_35751_b, field_35024_g.field_35748_f + 1, 0, func_35012_c());
                break;
            }
        }
    }

    public static StructureBoundingBox func_35087_a(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l)
    {
        for(int i1 = 7 * MathHelper.func_35598_a(random, 3, 5); i1 >= 7; i1 -= 7)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 3, 3, i1, l);
            if(StructureComponent.func_35020_a(list, structureboundingbox) == null)
            {
                return structureboundingbox;
            }
        }

        return null;
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        for(int i = field_35024_g.field_35753_a; i <= field_35024_g.field_35749_d; i++)
        {
            for(int j = field_35024_g.field_35752_c; j <= field_35024_g.field_35748_f; j++)
            {
                if(structureboundingbox.func_35742_b(i, 64, j))
                {
                    int k = world.func_4083_e(i, j) - 1;
                    world.func_634_a(i, k, j, Block.field_392_G.field_376_bc);
                }
            }

        }

        return true;
    }
}
