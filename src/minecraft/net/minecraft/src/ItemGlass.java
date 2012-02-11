package net.minecraft.src;

public class ItemGlass extends ItemBlock
{

    public ItemGlass(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        return Block.glass.getBlockTextureFromSideAndMetadata(2, BlockGlass.getBlockFromDye(i));
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(ItemDye.dyeColorNames[BlockGlass.getBlockFromDye(itemstack.getItemDamage())]).toString();
    }
}
