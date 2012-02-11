// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, World, TileEntityNote, 
//            EntityPlayer, TileEntity

public class BlockNote extends BlockContainer
{

    public BlockNote(int i)
    {
        super(i, 74, Material.field_1335_c);
    }

    public int func_218_a(int i)
    {
        return field_378_bb;
    }

    public void func_226_a(World world, int i, int j, int k, int l)
    {
        if(l > 0)
        {
            boolean flag = world.func_625_o(i, j, k);
            TileEntityNote tileentitynote = (TileEntityNote)world.func_603_b(i, j, k);
            if(tileentitynote != null && tileentitynote.field_21096_b != flag)
            {
                if(flag)
                {
                    tileentitynote.func_21094_a(world, i, j, k);
                }
                tileentitynote.field_21096_b = flag;
            }
        }
    }

    public boolean func_250_a(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return true;
        }
        TileEntityNote tileentitynote = (TileEntityNote)world.func_603_b(i, j, k);
        if(tileentitynote != null)
        {
            tileentitynote.func_21095_a();
            tileentitynote.func_21094_a(world, i, j, k);
        }
        return true;
    }

    public void func_233_b(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.field_1026_y)
        {
            return;
        }
        TileEntityNote tileentitynote = (TileEntityNote)world.func_603_b(i, j, k);
        if(tileentitynote != null)
        {
            tileentitynote.func_21094_a(world, i, j, k);
        }
    }

    public TileEntity func_283_a_()
    {
        return new TileEntityNote();
    }

    public void func_21024_a(World world, int i, int j, int k, int l, int i1)
    {
        float f = (float)Math.pow(2D, (double)(i1 - 12) / 12D);
        String s = "harp";
        if(l == 1)
        {
            s = "bd";
        }
        if(l == 2)
        {
            s = "snare";
        }
        if(l == 3)
        {
            s = "hat";
        }
        if(l == 4)
        {
            s = "bassattack";
        }
        world.func_684_a((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, (new StringBuilder()).append("note.").append(s).toString(), 3F, f);
        world.func_694_a("note", (double)i + 0.5D, (double)j + 1.2D, (double)k + 0.5D, (double)i1 / 24D, 0.0D, 0.0D);
    }
}
