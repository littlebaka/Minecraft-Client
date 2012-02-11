// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, StructureStrongholdPieces, ComponentStrongholdStairs2, StructureComponent, 
//            World

class StructureStrongholdStart extends StructureStart
{

    public StructureStrongholdStart(World world, Random random, int i, int j)
    {
        StructureStrongholdPieces.func_35849_a();
        ComponentStrongholdStairs2 componentstrongholdstairs2 = new ComponentStrongholdStairs2(0, random, (i << 4) + 2, (j << 4) + 2);
        field_35717_a.add(componentstrongholdstairs2);
        componentstrongholdstairs2.func_35004_a(componentstrongholdstairs2, field_35717_a, random);
        StructureComponent structurecomponent;
        for(ArrayList arraylist = componentstrongholdstairs2.field_35037_b; !arraylist.isEmpty(); structurecomponent.func_35004_a(componentstrongholdstairs2, field_35717_a, random))
        {
            int k = random.nextInt(arraylist.size());
            structurecomponent = (StructureComponent)arraylist.remove(k);
        }

        func_35714_b();
        func_35713_a(world, random, 10);
    }
}
