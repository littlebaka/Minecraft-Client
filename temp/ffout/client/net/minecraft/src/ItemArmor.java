// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, EnumArmorMaterial

public class ItemArmor extends Item
{

    private static final int field_314_bb[] = {
        11, 16, 15, 13
    };
    public final int field_313_aX;
    public final int field_312_aY;
    public final int field_311_aZ;
    private final EnumArmorMaterial field_40437_bT;

    public ItemArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i);
        field_40437_bT = enumarmormaterial;
        field_313_aX = k;
        field_311_aZ = j;
        field_312_aY = enumarmormaterial.func_40574_b(k);
        func_21013_d(enumarmormaterial.func_40576_a(k));
        field_290_aT = 1;
    }

    public int func_40399_b()
    {
        return field_40437_bT.func_40575_a();
    }

    static int[] func_40436_c()
    {
        return field_314_bb;
    }

}
