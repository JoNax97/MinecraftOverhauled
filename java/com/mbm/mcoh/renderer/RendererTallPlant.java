package com.mbm.mcoh.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.mbm.mcoh.block.BlockBambooPlant;
import com.mbm.mcoh.block.BlockRegistry;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererTallPlant implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

		 IIcon  texture = block.getIcon(0, 0);
		
		  if(block instanceof BlockBambooPlant) {

			  BlockBambooPlant b = (BlockBambooPlant)block;
			  Block blockBelow = world.getBlock(x, y -1, z);
		      Block blockAbove = world.getBlock(x, y +1, z);
		      		    	
		      if(blockBelow == Blocks.grass || blockBelow == Blocks.dirt){
		    		
		    		if(blockAbove !=BlockRegistry.bamboo){
		    			texture = b.textureSingle;
		    		}else{
		    			texture = b.textureBase;
		    		}
		    		
		    	}
		    	
		    	if(blockBelow == BlockRegistry.bamboo){
		    		if(blockAbove !=BlockRegistry.bamboo){
		    			texture = b.textureTop;
		    		}else{
		    			texture = b.textureMiddle;
		    		}
		    	}
			
		  }

		renderer.drawCrossedSquares(texture, x, y, z, 1F);
	
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return RenderRegistry.TallPlantRenderID;
	}
	

}
