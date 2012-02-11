package net.minecraft.src;

import java.util.Random;

public class BiomeGenSwamp extends BiomeGenBase
{
    protected BiomeGenSwamp(int i)
    {
        super(i);
        biomeDecorator.treesPerChunk = 2;
        biomeDecorator.flowersPerChunk = -999;
        biomeDecorator.deadBushPerChunk = 1;
        biomeDecorator.mushroomsPerChunk = 8;
        biomeDecorator.reedsPerChunk = 10;
        biomeDecorator.clayPerChunk = 1;
        biomeDecorator.waterlilyPerChunk = 4;
        waterColorMultiplier = 0xe0ffae;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return worldGenSwamp;
    }

    public int getGrassColorAtCoords(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.getWorldChunkManager().getTemperature(i, j, k);
        double d1 = iblockaccess.getWorldChunkManager().getRainfall(i, k);
        return ((ColorizerGrass.getGrassColor(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }

    public int getFoliageColorAtCoords(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.getWorldChunkManager().getTemperature(i, j, k);
        double d1 = iblockaccess.getWorldChunkManager().getRainfall(i, k);
        return ((ColorizerFoliage.getFoliageColor(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }
}
