package com.mbm.mcoh.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

import com.mbm.mcoh.block.BlockMetalOre;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererMetalOre implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

			renderer.renderBlockAsItem(Blocks.iron_ore, 0, 1.0F);  
			
	}


	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

		if(RenderRegistry.renderPass == 0)
        {
			
			BlockMetalOre blockBase = (BlockMetalOre)block;
            Block overlay = blockBase.getOverlayBlock(world, x, y, z); 
			renderer.renderStandardBlock(overlay, x, y, z); 
			
			
        }
		
		if(RenderRegistry.renderPass == 1) {                
       		
           renderer.renderStandardBlock(block, x, y, z); 
        }
        
        return true;
	}


	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderRegistry.MetalOreRenderID;
	}

}
