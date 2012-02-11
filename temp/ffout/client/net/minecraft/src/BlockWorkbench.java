// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityPlayer

public class BlockWorkbench extends Block
{

    protected BlockWorkbench(int i)
    {
        super(i, Material.field_1335_c);
        field_378_bb = 59;
    }

    public int func_218_a(int i)
    {
        if(i == 1)
        {
            return field_378_bb - 16;
        }
        if(i == 0)
        {
            return Block.field_334_y.func_218_a(0);
        }
        if(i == 2 || i == 4)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        } else
        {
            entityplayer.func_445_l(i, j, k);
            return true;
        }
    }
}
