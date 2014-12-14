package com.mbm.mcoh.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.item.ItemRegistry;
import com.mbm.mcoh.renderer.RenderRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBambooPlant extends Block implements IPlantable
{
	public IIcon textureSingle;
	public IIcon textureBase;
	public IIcon textureMiddle;
	public IIcon textureTop;
	
	int posX, posY, posZ;
	
	World world;

    protected BlockBambooPlant()
    {
        super(Material.plants);
        float f = 0.375F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setTickRandomly(true);
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
    	
    	this.posX = x;
    	this.posY = y;
    	this.posZ = z;
       	this.world = world;
    	
        if (world.getBlock(x, y - 1, z) == BlockRegistry.bamboo || this.checkNeighborsAndDrop(world, x, y, z))
        {
            if (world.isAirBlock(x, y + 1, z))
            {
                int l;

                for (l = 1; world.getBlock(x, y - l, z) == this; ++l)
                {
                    ;
                }

                if (l < 4)
                {
                    int i1 = world.getBlockMetadata(x, y, z);

                    if (i1 == 15)
                    {
                        world.setBlock(x, y + 1, z, this);
                        world.setBlockMetadataWithNotify(x, y, z, 0, 4);
                    }
                    else
                    {
                        world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
                    }
                }
            }
        }
    }
    
    
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		textureSingle = iconRegister.registerIcon(Main.MODID + ":bamboo_alone");
		textureBase = iconRegister.registerIcon(Main.MODID + ":bamboo_bottom");
		textureMiddle = iconRegister.registerIcon(Main.MODID + ":bamboo_middle");
		textureTop = iconRegister.registerIcon(Main.MODID + ":bamboo_top");
	}
	
	@Override
	 public IIcon getIcon(int side, int meta) {

		return textureSingle;
	}

    	
    public Item getItem(World world, int x, int y, int z) {
    	return ItemRegistry.bambooItem;    	
    }
    

	public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return this.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP);
    }
	
	
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction)
    {
    	if(world.getBlock(x, y, z) == Blocks.grass || world.getBlock(x, y, z) == Blocks.dirt || world.getBlock(x, y, z) == BlockRegistry.bamboo){
    		return true;
    	}
    	
    	return false;

    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
    {
       	this.posX = x;
    	this.posY = y;
    	this.posZ = z;
       	this.world = world;
    	
        this.checkNeighborsAndDrop(world, x, y, z);
    }

    protected final boolean checkNeighborsAndDrop(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return this.canPlaceBlockAt(world, x, y, z);
    }


    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }

    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return ItemRegistry.bambooItem;
    }

    @Override
    public int getRenderType()
    {
    return RenderRegistry.TallPlantRenderID;
    }
    
	@Override
    public boolean renderAsNormalBlock()
	{
    return false; 
	}
	
	@Override
    public int getRenderBlockPass()
	{
            return 0;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
    
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Plains;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return this;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
}