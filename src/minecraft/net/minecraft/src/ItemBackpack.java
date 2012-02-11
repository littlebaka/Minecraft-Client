package net.minecraft.src;

public class ItemBackpack extends Item
{
	
	public final int backpackType;
	public final int renderIndex;
	private final EnumBackpackMaterial material;
	
	public static final String backpackColorNames[] = {
        "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", 
        "lime", "yellow", "lightBlue", "magenta", "orange", "white"
    };
    public static final int backpackColors[] = {
        0x1e1b1b, 0xb3312c, 0x3b511a, 0x51301a, 0x253192, 0x7b2fbe, 0x287697, 0x287697, 0x434343, 0xd88198, 
        0x41cd34, 0xdecf2a, 0x6689d3, 0xc354cd, 0xeb8844, 0xf0f0f0
    };

	public ItemBackpack(int i, EnumBackpackMaterial enumbackpackmaterial, int j, int k)
	{
	    super(i);
	    material = enumbackpackmaterial;
	    backpackType = k;
	    renderIndex = j;
	    maxStackSize = 1;
	}
	
    public int getColorFromDamage(int i)
    {
        if(i < 16 && i >= 0)
        {
            return backpackColors[i];
        }
        int j = i / 1000;
        if(j < 0 || j > 16)
        {
            return backpackColors[16];
        } else
        {
            return backpackColors[j];
        }
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = MathHelper.func_41084_a(itemstack.getItemDamage(), 0, 15);
        return (new StringBuilder()).append(super.getItemName()).append(".").append(backpackColorNames[i]).toString();
    }


}

