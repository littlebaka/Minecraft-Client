package net.minecraft.src;

import java.util.Random;

public class BlockJump extends Block
{

	public BlockJump(int i, int j)
	{
		super(i, j, Material.wood);
		setBlockBounds (0.0F, 0.0F, 0.0F, 1.0F, 0.90F, 1.0F);
	}
	
	public boolean isOpaqueCube()
	{
	    return false;
	}
	
	public int getBlockTextureFromSide(int i)
	{
		if(i == 1)
		{
			return blockIndexInTexture +1;
		} else
		{
			return blockIndexInTexture;
		}
	}
	
	public void jump(Entity entity)
	{
		if ((entity instanceof EntityPlayer)) {
			entity.motionY = 0;
			entity.fallDistance = 0;
			entity.addVelocity(0, 0.8, 0); 
		}	
	}

	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
		if (entity.posY > j)
    	{
    		jump(entity);
    	}
	}
	    
    public void onEntityWalking(World world, int i, int j, int k, Entity entity) 
    {
    	jump(entity);
    }  

	
	public int idDropped(int i, Random random)
	{
		return Block.jump.blockID;
	}
}
