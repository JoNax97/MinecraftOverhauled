package com.mbm.mcoh.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.gui.GuiRegistry;
import com.mbm.mcoh.tileentity.TileEntityLeatherWorkbench;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockLeatherWorkbench extends BlockContainer{
	
	

	protected BlockLeatherWorkbench(String unlocalizedName, String textureName, Material material) {
		super(material);
		
		this.setBlockName(unlocalizedName);
        this.setHardness(0.3F);
        this.setResistance(0.1F);
        this.setStepSound(soundTypeCloth);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockBounds(0, 0, 0, 1, 0.0625F, 1); 
             
        
	}       
	
        @SideOnly(Side.CLIENT)
    	@Override
    	public void registerBlockIcons(IIconRegister iconRegister){
    		this.blockIcon = iconRegister.registerIcon(Main.MODID + ":leather_workbench_packed");
    	}
    	
    	@SideOnly(Side.CLIENT)
    	public IIcon getIcon(int side, int meta){
    		return this.blockIcon;
    	}
    	
    	public Item getItemDropped(int i, Random random, int j)
        {
            return Item.getItemFromBlock(this);
        }
    	
    	public int getRenderType(){
    		return -1;
    	}
    	
    	public boolean isOpaqueCube(){
    		return false;
    	}
    	
    	public boolean renderAsNormalBlock(){
    		return false;
    	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityLeatherWorkbench();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
    {
        if(world.getBlock(x+1, y, z) == Blocks.air && 
           world.getBlock(x-1, y, z) == Blocks.air && 
           world.getBlock(x, y, z+1) == Blocks.air && 
           world.getBlock(x, y, z-1) == Blocks.air){
        	
        	if( world.getBlock(x+1, y-1, z).isOpaqueCube() && 
           world.getBlock(x-1, y-1, z).isOpaqueCube() && 
           world.getBlock(x, y-1, z+1).isOpaqueCube() && 
           world.getBlock(x, y-1, z-1).isOpaqueCube() &&
           world.getBlock(x, y-1, z).isOpaqueCube()){
        	
        	world.setBlock(x+1, y, z, BlockRegistry.leatherWingRight);
        	world.setBlock(x-1, y, z, BlockRegistry.leatherWingLeft);
        	world.setBlock(x, y, z+1, BlockRegistry.leatherWingBottom);
        	world.setBlock(x, y, z-1, BlockRegistry.leatherWingTop);
        	}else{world.func_147480_a(x, y, z, true);
        	}
        }else{
        	world.func_147480_a(x, y, z, true);
        }
        
           
    }
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
		world.func_147480_a(x, y, z, true);
		
		if(world.getBlock(x+1, y, z) == BlockRegistry.leatherWingRight)
		world.setBlockToAir(x+1, y, z);
		if(world.getBlock(x-1, y, z) == BlockRegistry.leatherWingLeft)
		world.setBlockToAir(x-1, y, z);
		if(world.getBlock(x, y, z+1) == BlockRegistry.leatherWingTop)
		world.setBlockToAir(x, y, z+1);
		if(world.getBlock(x, y, z-1) == BlockRegistry.leatherWingBottom)
		world.setBlockToAir(x, y, z-1);
	
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!player.isSneaking()){
			player.openGui(Main.instance, GuiRegistry.guiIDLeatherWorkbench, world, x, y, z);
			return true;
			}else{
				return false;
			}
	 
	}
}

