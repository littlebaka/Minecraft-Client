package net.minecraft.src;

public class SlotBackpack extends Slot
{

	    final int backpackType; /* synthetic field */
	    final ContainerPlayer inventory; /* synthetic field */

	    SlotBackpack(ContainerPlayer containerplayer, IInventory iinventory, int i, int j, int k, int l)
	    {
	        super(iinventory, i, j, k);
	        inventory = containerplayer;
	        backpackType = l;
	    }

	    public int getSlotStackLimit()
	    {
	        return 1;
	    }

	    public boolean isItemValid(ItemStack itemstack)
	    {
	        if(itemstack.getItem() instanceof ItemBackpack)
	        {
	            return ((ItemBackpack)itemstack.getItem()).backpackType == backpackType;
	        } else
	        {
	            return false;
	        }
	    }
	
}
