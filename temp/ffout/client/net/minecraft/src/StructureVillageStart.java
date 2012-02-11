// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, StructureVillagePieces, ComponentVillageStartPiece, World, 
//            StructureComponent, ComponentVillageRoadPiece

class StructureVillageStart extends StructureStart
{

    private boolean field_35718_c;

    public StructureVillageStart(World world, Random random, int i, int j, int k)
    {
        field_35718_c = false;
        int l = k;
        ArrayList arraylist = StructureVillagePieces.func_35705_a(random, l);
        ComponentVillageStartPiece componentvillagestartpiece = new ComponentVillageStartPiece(world.func_4075_a(), 0, random, (i << 4) + 2, (j << 4) + 2, arraylist, l);
        field_35717_a.add(componentvillagestartpiece);
        componentvillagestartpiece.func_35004_a(componentvillagestartpiece, field_35717_a, random);
        ArrayList arraylist1 = componentvillagestartpiece.field_35106_f;
        for(ArrayList arraylist2 = componentvillagestartpiece.field_35108_e; !arraylist1.isEmpty() || !arraylist2.isEmpty();)
        {
            if(!arraylist1.isEmpty())
            {
                int i1 = random.nextInt(arraylist1.size());
                StructureComponent structurecomponent = (StructureComponent)arraylist1.remove(i1);
                structurecomponent.func_35004_a(componentvillagestartpiece, field_35717_a, random);
            } else
            {
                int j1 = random.nextInt(arraylist2.size());
                StructureComponent structurecomponent1 = (StructureComponent)arraylist2.remove(j1);
                structurecomponent1.func_35004_a(componentvillagestartpiece, field_35717_a, random);
            }
        }

        func_35714_b();
        int k1 = 0;
        Iterator iterator = field_35717_a.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureComponent structurecomponent2 = (StructureComponent)iterator.next();
            if(!(structurecomponent2 instanceof ComponentVillageRoadPiece))
            {
                k1++;
            }
        } while(true);
        field_35718_c = k1 > 2;
    }

    public boolean func_35715_c()
    {
        return field_35718_c;
    }
}
