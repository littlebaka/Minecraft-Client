// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            ShapelessRecipes, ShapedRecipes, IRecipe, CraftingManager

class RecipeSorter
    implements Comparator
{

    final CraftingManager field_1557_a; /* synthetic field */

    RecipeSorter(CraftingManager craftingmanager)
    {
        field_1557_a = craftingmanager;
        super();
    }

    public int func_1040_a(IRecipe irecipe, IRecipe irecipe1)
    {
        if((irecipe instanceof ShapelessRecipes) && (irecipe1 instanceof ShapedRecipes))
        {
            return 1;
        }
        if((irecipe1 instanceof ShapelessRecipes) && (irecipe instanceof ShapedRecipes))
        {
            return -1;
        }
        if(irecipe1.func_1184_a() < irecipe.func_1184_a())
        {
            return -1;
        }
        return irecipe1.func_1184_a() <= irecipe.func_1184_a() ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return func_1040_a((IRecipe)obj, (IRecipe)obj1);
    }
}
