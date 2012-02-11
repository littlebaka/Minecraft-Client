// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, World

public class ComponentStrongholdStraight extends ComponentStronghold
{

    private final EnumDoor field_35050_a;
    private final boolean field_35048_b;
    private final boolean field_35049_c;

    public ComponentStrongholdStraight(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35050_a = func_35031_a(random);
        field_35024_g = structureboundingbox;
        field_35048_b = random.nextInt(2) == 0;
        field_35049_c = random.nextInt(2) == 0;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_35028_a((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
        if(field_35048_b)
        {
            func_35032_b((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 2);
        }
        if(field_35049_c)
        {
            func_35029_c((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 2);
        }
    }

    public static ComponentStrongholdStraight func_35047_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -1, -1, 0, 5, 5, 7, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdStraight(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35022_a(world, structureboundingbox, 0, 0, 0, 4, 4, 6, true, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, field_35050_a, 1, 1, 0);
        func_35033_a(world, random, structureboundingbox, EnumDoor.OPENING, 1, 1, 6);
        func_35014_a(world, structureboundingbox, random, 0.1F, 1, 2, 1, Block.field_404_ar.field_376_bc, 0);
        func_35014_a(world, structureboundingbox, random, 0.1F, 3, 2, 1, Block.field_404_ar.field_376_bc, 0);
        func_35014_a(world, structureboundingbox, random, 0.1F, 1, 2, 5, Block.field_404_ar.field_376_bc, 0);
        func_35014_a(world, structureboundingbox, random, 0.1F, 3, 2, 5, Block.field_404_ar.field_376_bc, 0);
        if(field_35048_b)
        {
            func_35011_a(world, structureboundingbox, 0, 1, 2, 0, 3, 4, 0, 0, false);
        }
        if(field_35049_c)
        {
            func_35011_a(world, structureboundingbox, 4, 1, 2, 4, 3, 4, 0, 0, false);
        }
        return true;
    }
}
