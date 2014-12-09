package com.mbm.mcoh.block;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.tileentity.TileEntityGiantFern;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGiantFern extends BlockContainer implements IPlantable
{

   public BlockGiantFern()
    {
    	super(Material.plants);
    	this.setBlockName("giantFern");
        this.setTickRandomly(true);
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 2.5F, 0.5F + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(1.0F);
        this.setResistance(0.7F);
        this.setHarvestLevel("axe", 1);
        this.setStepSound(soundTypeGrass);
    }

   
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntityGiantFern();
	}
	

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Main.MODID + ":fern_giant");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return this.blockIcon;
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
       return -1;
   	}	
   
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
    }

    protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.grass || block == Blocks.dirt || block == Blocks.leaves  || block == Blocks.leaves2;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
        this.checkAndDropBlock(world, x, y, z);
    }

    public void updateTick(World world, int x, int y, int z, Random random)
    {
        this.checkAndDropBlock(world, x, y, z);
        
    }

    protected void checkAndDropBlock(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlock(x, y, z, getBlockById(0), 0, 2);
        }
    }

    public boolean canBlockStay(World world, int x, int y, int z)
    {
       Block block = world.getBlock(x, y - 1, z);
       
       return block == Blocks.grass || block == Blocks.dirt || block == Blocks.leaves  || block == Blocks.leaves2;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
	return Plains;
    }
    
    public void randomDisplayTick(World world, int x, int y, int z, Random random){
    	float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 2F, 0.5F + f);
    }

@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
	return this;
}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
	return 0;
	}
}