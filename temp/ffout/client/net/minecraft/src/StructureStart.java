// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, World

public abstract class StructureStart
{

    protected LinkedList field_35717_a;
    protected StructureBoundingBox field_35716_b;

    protected StructureStart()
    {
        field_35717_a = new LinkedList();
    }

    public StructureBoundingBox func_35712_a()
    {
        return field_35716_b;
    }

    public LinkedList func_40560_b()
    {
        return field_35717_a;
    }

    public void func_35711_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        Iterator iterator = field_35717_a.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            if(structurecomponent.func_35021_b().func_35740_a(structureboundingbox) && !structurecomponent.func_35023_a(world, random, structureboundingbox))
            {
                iterator.remove();
            }
        } while(true);
    }

    protected void func_35714_b()
    {
        field_35716_b = StructureBoundingBox.func_35741_a();
        StructureComponent structurecomponent;
        for(Iterator iterator = field_35717_a.iterator(); iterator.hasNext(); field_35716_b.func_35738_b(structurecomponent.func_35021_b()))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }

    protected void func_35713_a(World world, Random random, int i)
    {
        int j = world.field_35470_e - i;
        int k = field_35716_b.func_35743_c() + 1;
        if(k < j)
        {
            k += random.nextInt(j - k);
        }
        int l = k - field_35716_b.field_35750_e;
        field_35716_b.func_35745_a(0, l, 0);
        StructureComponent structurecomponent;
        for(Iterator iterator = field_35717_a.iterator(); iterator.hasNext(); structurecomponent.func_35021_b().func_35745_a(0, l, 0))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }

    protected void func_40559_a(World world, Random random, int i, int j)
    {
        int k = ((j - i) + 1) - field_35716_b.func_35743_c();
        int l = 1;
        if(k > 1)
        {
            l = i + random.nextInt(k);
        } else
        {
            l = i;
        }
        int i1 = l - field_35716_b.field_35751_b;
        field_35716_b.func_35745_a(0, i1, 0);
        StructureComponent structurecomponent;
        for(Iterator iterator = field_35717_a.iterator(); iterator.hasNext(); structurecomponent.func_35021_b().func_35745_a(0, i1, 0))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }

    public boolean func_35715_c()
    {
        return true;
    }
}
