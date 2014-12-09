package com.mbm.mcoh.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.block.BlockRegistry;

public class RendererLeatherWing extends TileEntitySpecialRenderer {
	
		public IBlockAccess blockAccess;
		private ResourceLocation textureLeatherWing;
        
        public RendererLeatherWing() {
        
        }
        
        
        public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        	     
             	Tessellator tess = Tessellator.instance;
        	
        	   	if(te.getBlockType() == BlockRegistry.leatherWingTop){
        	   		textureLeatherWing = new ResourceLocation(Main.MODID + ":textures/blocks/leather_workbench_top.png");
        	   		}
        	   	if(te.getBlockType() == BlockRegistry.leatherWingRight){
        	   		textureLeatherWing = new ResourceLocation(Main.MODID + ":textures/blocks/leather_workbench_right.png");
        	   		}
        	   	if(te.getBlockType() == BlockRegistry.leatherWingBottom){
        	   		textureLeatherWing = new ResourceLocation(Main.MODID + ":textures/blocks/leather_workbench_bottom.png");
        	   		}
        	   	if(te.getBlockType() == BlockRegistry.leatherWingLeft){
        	   		textureLeatherWing = new ResourceLocation(Main.MODID + ":textures/blocks/leather_workbench_left.png");
        	   		}
             	
        	   	Minecraft.getMinecraft().renderEngine.bindTexture(textureLeatherWing);
            	  
              		tess.startDrawingQuads();
            		
        			tess.addVertexWithUV(x,   y+0.001,   z, 0D, 0D);
        			tess.addVertexWithUV(x, y+0.001,   z+1,   0D, 1D);
        			tess.addVertexWithUV(x+1, y+0.001, z+1,   1D, 1D);
        			tess.addVertexWithUV(x+1,   y+0.001, z, 1D, 0D);
        		
        			tess.draw(); 
        			
        			
           	}
         }
    