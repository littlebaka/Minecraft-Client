// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack, Block, BlockCloth, Item, 
//            CraftingManager

public class RecipesDyes
{

    public RecipesDyes()
    {
    }

    public void func_21157_a(CraftingManager craftingmanager)
    {
        for(int i = 0; i < 16; i++)
        {
            craftingmanager.func_21187_b(new ItemStack(Block.field_419_ac, 1, BlockCloth.func_21035_d(i)), new Object[] {
                new ItemStack(Item.field_21021_aU, 1, i), new ItemStack(Item.field_233_c[Block.field_419_ac.field_376_bc], 1, 0)
            });
        }

        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 11), new Object[] {
            Block.field_417_ae
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 1), new Object[] {
            Block.field_416_af
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 3, 15), new Object[] {
            Item.field_21020_aV
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 9), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 15)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 14), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 11)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 10), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 2), new ItemStack(Item.field_21021_aU, 1, 15)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 8), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 0), new ItemStack(Item.field_21021_aU, 1, 15)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 7), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 8), new ItemStack(Item.field_21021_aU, 1, 15)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 3, 7), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 0), new ItemStack(Item.field_21021_aU, 1, 15), new ItemStack(Item.field_21021_aU, 1, 15)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 12), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 15)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 6), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 2)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 5), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 1)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 13), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 5), new ItemStack(Item.field_21021_aU, 1, 9)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 3, 13), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 9)
        });
        craftingmanager.func_21187_b(new ItemStack(Item.field_21021_aU, 4, 13), new Object[] {
            new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 15)
        });
    }
}
