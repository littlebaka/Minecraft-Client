// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, EnumDoorHelper, EnumDoor, Block, 
//            StructureBoundingBox, StructureStrongholdPieces, World, ComponentStrongholdStairs2

abstract class ComponentStronghold extends StructureComponent
{

    protected ComponentStronghold(int i)
    {
        super(i);
    }

    protected void func_35033_a(World world, Random random, StructureBoundingBox structureboundingbox, EnumDoor enumdoor, int i, int j, int k)
    {
        switch(EnumDoorHelper.field_35619_a[enumdoor.ordinal()])
        {
        case 1: // '\001'
        default:
            func_35011_a(world, structureboundingbox, i, j, k, (i + 3) - 1, (j + 3) - 1, k, 0, 0, false);
            break;

        case 2: // '\002'
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i, j, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 1, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 2, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 2, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 2, j, k, structureboundingbox);
            func_35018_a(world, Block.field_442_aF.field_376_bc, 0, i + 1, j, k, structureboundingbox);
            func_35018_a(world, Block.field_442_aF.field_376_bc, 8, i + 1, j + 1, k, structureboundingbox);
            break;

        case 3: // '\003'
            func_35018_a(world, 0, 0, i + 1, j, k, structureboundingbox);
            func_35018_a(world, 0, 0, i + 1, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i, j, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i + 1, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i + 2, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i + 2, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35288_bq.field_376_bc, 0, i + 2, j, k, structureboundingbox);
            break;

        case 4: // '\004'
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i, j, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 1, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 2, j + 2, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 2, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_35285_bn.field_376_bc, 0, i + 2, j, k, structureboundingbox);
            func_35018_a(world, Block.field_435_aM.field_376_bc, 0, i + 1, j, k, structureboundingbox);
            func_35018_a(world, Block.field_435_aM.field_376_bc, 8, i + 1, j + 1, k, structureboundingbox);
            func_35018_a(world, Block.field_4064_aS.field_376_bc, func_35009_c(Block.field_4064_aS.field_376_bc, 4), i + 2, j + 1, k + 1, structureboundingbox);
            func_35018_a(world, Block.field_4064_aS.field_376_bc, func_35009_c(Block.field_4064_aS.field_376_bc, 3), i + 2, j + 1, k - 1, structureboundingbox);
            break;
        }
    }

    protected EnumDoor func_35031_a(Random random)
    {
        int i = random.nextInt(5);
        switch(i)
        {
        case 0: // '\0'
        case 1: // '\001'
        default:
            return EnumDoor.OPENING;

        case 2: // '\002'
            return EnumDoor.WOOD_DOOR;

        case 3: // '\003'
            return EnumDoor.GRATES;

        case 4: // '\004'
            return EnumDoor.IRON_DOOR;
        }
    }

    protected StructureComponent func_35028_a(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a + i, field_35024_g.field_35751_b + j, field_35024_g.field_35752_c - 1, field_35025_h, func_35012_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a + i, field_35024_g.field_35751_b + j, field_35024_g.field_35748_f + 1, field_35025_h, func_35012_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + j, field_35024_g.field_35752_c + i, field_35025_h, func_35012_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + j, field_35024_g.field_35752_c + i, field_35025_h, func_35012_c());
        }
        return null;
    }

    protected StructureComponent func_35032_b(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 1, func_35012_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 1, func_35012_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c - 1, 2, func_35012_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c - 1, 2, func_35012_c());
        }
        return null;
    }

    protected StructureComponent func_35029_c(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 3, func_35012_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 3, func_35012_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35748_f + 1, 0, func_35012_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_35850_a(componentstrongholdstairs2, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35748_f + 1, 0, func_35012_c());
        }
        return null;
    }

    protected static boolean func_35030_a(StructureBoundingBox structureboundingbox)
    {
        return structureboundingbox != null && structureboundingbox.field_35751_b > 10;
    }
}
