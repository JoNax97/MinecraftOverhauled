package com.mbm.mcoh.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.item.ItemRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOliveLeaves extends BlockLeavesBase{
	
	private IIcon iconFull;
	private IIcon iconEmpty;
	private IIcon iconFullOpaque;
	private IIcon iconEmptyOpaque;

	
	public BlockOliveLeaves() {

		super(Material.leaves, false);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setStepSound(soundTypeGrass);
	
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs crativeTab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	iconEmpty = iconRegister.registerIcon(Main.MODID + ":leaves_olive_empty");
    	iconFull = iconRegister.registerIcon(Main.MODID + ":leaves_olive_full");
    	iconEmptyOpaque = iconRegister.registerIcon(Main.MODID + ":leaves_olive_empty_opaque");
    	iconFullOpaque = iconRegister.registerIcon(Main.MODID + ":leaves_olive_full_opaque");
    }

    @Override
    public IIcon getIcon(int side, int meta){

    	if(Minecraft.getMinecraft().gameSettings.fancyGraphics){
    		if(meta == 0){
    			this.setOpaqueCube(false);
    			return iconEmpty;
    		}
    		
    		if(meta == 1){
    			this.setOpaqueCube(false);
    			return iconFull;
    		}
    	}
    	
    	if(! Minecraft.getMinecraft().gameSettings.fancyGraphics){
    		if(meta == 0){
    			this.setOpaqueCube(true);
    			return iconEmptyOpaque;
    		}
    		
    		if(meta == 1){
    			this.setOpaqueCube(true);
    			return iconFullOpaque;
    		}
    	}
    	return iconEmptyOpaque;
    }
   
    private void setOpaqueCube(boolean opaque) {
		super.field_150121_P = opaque;
		
	}
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
    	
    	 ArrayList<ItemStack> drops = new  ArrayList<ItemStack>();
    	 
    	 if(meta == 0){

    		 	if(world.rand.nextBoolean()){
    	 			drops.add(new ItemStack(Blocks.sapling,1));
    	 		}
    	 	}

    	 
    	 if (meta == 1){

     	 		if(world.rand.nextBoolean()){
     	 			drops.add(new ItemStack(Blocks.sapling,1));
     	 		}
     	 		drops.add(new ItemStack(ItemRegistry.olives, world.rand.nextInt(5)));
     	 	}
    	     	 
    	 return drops;
    }
    
    @Override
    public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if(player.getCurrentEquippedItem() == null){
        	
        	EntityItem entityitem = new EntityItem(world, posX, posY, posZ, new ItemStack(ItemRegistry.olives, world.rand.nextInt(5)+1));
        	entityitem.delayBeforeCanPickup = 10;
        	world.spawnEntityInWorld(entityitem);
        	world.setBlock(posX, posY, posZ, BlockRegistry.leavesOlive, 0, 2);
        	
        }
        
        return true;
    }

}