// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStrongholdLeftTurn, ComponentStrongholdStairs2, StructureStrongholdPieces, StructureBoundingBox, 
//            StructureComponent, World

public class ComponentStrongholdRightTurn extends ComponentStrongholdLeftTurn
{

    public ComponentStrongholdRightTurn(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i, random, structureboundingbox, j);
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        if(field_35025_h == 2 || field_35025_h == 3)
        {
            func_35029_c((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
        } else
        {
            func_35032_b((ComponentStrongholdStairs2)structurecomponent, list, random, 1, 1);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35022_a(world, structureboundingbox, 0, 0, 0, 4, 4, 4, true, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, field_35046_a, 1, 1, 0);
        if(field_35025_h == 2 || field_35025_h == 3)
        {
            func_35011_a(world, structureboundingbox, 4, 1, 1, 4, 3, 3, 0, 0, false);
        } else
        {
            func_35011_a(world, structureboundingbox, 0, 1, 1, 0, 3, 3, 0, 0, false);
        }
        return true;
    }
}
