package net.minecraft.src;

public class BlockMuret extends Block
{

   private Block modelBlock;
    public BlockMuret(int i, Block block)
    {
        super(i, block.blockIndexInTexture, block.blockMaterial);
        modelBlock = stoneBrick;
        setHardness(block.blockHardness);
        setResistance(block.blockResistance / 3F);
        setStepSound(block.stepSound);
        setLightOpacity(0);
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
       return modelBlock.getBlockTextureFromSideAndMetadata(i, 0);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 28;
    }

    public boolean isFenceAt(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockId(i, j, k);
        if(l == blockID || l == Block.fenceGate.blockID)
        {
            return true;
        } else
        {
            return false;
        }
    }
}