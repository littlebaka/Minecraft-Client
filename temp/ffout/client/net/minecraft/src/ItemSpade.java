// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemSpade extends ItemTool
{

    private static Block field_326_aX[];

    public ItemSpade(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, field_326_aX);
    }

    public boolean func_4018_a(Block block)
    {
        if(block == Block.field_428_aT)
        {
            return true;
        }
        return block == Block.field_426_aV;
    }

    static 
    {
        field_326_aX = (new Block[] {
            Block.field_337_v, Block.field_336_w, Block.field_393_F, Block.field_392_G, Block.field_428_aT, Block.field_426_aV, Block.field_424_aX, Block.field_446_aB, Block.field_4051_bd, Block.field_40199_bz
        });
    }
}
