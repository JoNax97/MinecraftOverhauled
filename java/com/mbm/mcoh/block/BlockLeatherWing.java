package com.mbm.mcoh.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.gui.GuiRegistry;
import com.mbm.mcoh.tileentity.TileEntityLeatherWing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockLeatherWing extends BlockContainer{
	
	

	protected BlockLeatherWing(String unlocalizedName, String textureName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setHardness(0.3F);
        this.setResistance(0.1F);
        this.setStepSound(soundTypeCloth);
        this.setBlockBounds(0, 0, 0, 1, 0, 1); 	
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
        return Item.getItemFromBlock(BlockRegistry.leatherWorkbench);
    }
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
		return new ItemStack(Item.getItemFromBlock(BlockRegistry.leatherWorkbench));
		
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
	
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityLeatherWing();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
		
		if(block == BlockRegistry.leatherWingBottom){
		world.setBlockToAir(x, y, z);
		world.setBlockToAir(x, y, z-1);
		world.setBlockToAir(x, y, z-2);
		world.setBlockToAir(x+1, y, z-1);
		world.setBlockToAir(x-1, y, z-1);
		}
		
		if(block == BlockRegistry.leatherWingTop){
			world.setBlockToAir(x, y, z);
			world.setBlockToAir(x, y, z+1);
			world.setBlockToAir(x, y, z+2);
			world.setBlockToAir(x+1, y, z+1);
			world.setBlockToAir(x-1, y, z+1);
			}
		
		if(block == BlockRegistry.leatherWingRight){
			world.setBlockToAir(x, y, z);
			world.setBlockToAir(x-1, y, z);
			world.setBlockToAir(x-2, y, z);
			world.setBlockToAir(x-1, y, z-1);
			world.setBlockToAir(x-1, y, z+1);
			}
		
		if(block == BlockRegistry.leatherWingLeft){
			world.setBlockToAir(x, y, z);
			world.setBlockToAir(x+1, y, z);
			world.setBlockToAir(x+2, y, z);
			world.setBlockToAir(x+1, y, z-1);
			world.setBlockToAir(x+1, y, z+1);
			}
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!player.isSneaking()){
			
			if(world.getBlock(x, y, z) == BlockRegistry.leatherWingTop){
				player.openGui(Main.instance, GuiRegistry.guiIDLeatherWorkbench, world, x, y, z+1);
			}
			
			if(world.getBlock(x, y, z) == BlockRegistry.leatherWingBottom){
				player.openGui(Main.instance, GuiRegistry.guiIDLeatherWorkbench, world, x, y, z-1);				
			}
			if(world.getBlock(x, y, z) == BlockRegistry.leatherWingLeft){
				player.openGui(Main.instance, GuiRegistry.guiIDLeatherWorkbench, world, x+1, y, z);	
			}
			
			if(world.getBlock(x, y, z) == BlockRegistry.leatherWingRight){
				player.openGui(Main.instance, GuiRegistry.guiIDLeatherWorkbench, world, x-1, y, z);	
			}
		return true; 
		}else{
			return false;
			}	
		}
	}
