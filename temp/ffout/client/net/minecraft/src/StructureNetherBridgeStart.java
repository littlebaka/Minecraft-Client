// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, ComponentNetherBridgeStartPiece, StructureComponent, World

class StructureNetherBridgeStart extends StructureStart
{

    public StructureNetherBridgeStart(World world, Random random, int i, int j)
    {
        ComponentNetherBridgeStartPiece componentnetherbridgestartpiece = new ComponentNetherBridgeStartPiece(random, (i << 4) + 2, (j << 4) + 2);
        field_35717_a.add(componentnetherbridgestartpiece);
        componentnetherbridgestartpiece.func_35004_a(componentnetherbridgestartpiece, field_35717_a, random);
        StructureComponent structurecomponent;
        for(ArrayList arraylist = componentnetherbridgestartpiece.field_40034_d; !arraylist.isEmpty(); structurecomponent.func_35004_a(componentnetherbridgestartpiece, field_35717_a, random))
        {
            int k = random.nextInt(arraylist.size());
            structurecomponent = (StructureComponent)arraylist.remove(k);
        }

        func_35714_b();
        func_40559_a(world, random, 48, 70);
    }
}
