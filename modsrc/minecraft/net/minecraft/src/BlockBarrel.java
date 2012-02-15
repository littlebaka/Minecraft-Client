package net.minecraft.src;

import java.util.Random;

public class BlockBarrel extends Block
{
	public BlockBarrel(int i, int j)
	{
		super(i, j, Material.wood);
	}

	public int getBlockTextureFromSide(int i)
	{
		if(i == 0 || i == 1)
		{
			return blockIndexInTexture +1;
		} else
		{
			return blockIndexInTexture;
		}
	}
	
	public int idDropped(int i, Random random)
	{
		return Block.barrel.blockID;
	}
}
