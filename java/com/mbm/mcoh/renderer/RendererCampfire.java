package com.mbm.mcoh.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.handler.TickEventHandler;
import com.mbm.mcoh.model.ModelCampfire;
import com.mbm.mcoh.tileentity.TileEntityCampfire;

public class RendererCampfire extends TileEntitySpecialRenderer {
	
		public IBlockAccess blockAccess;
		public TileEntityCampfire tileEntity;
        
        //The model of your block
        private final ModelCampfire modelCampfire;
                    
        
        public RendererCampfire() {
                this.modelCampfire = new ModelCampfire();
           
                
        }
        
        @SuppressWarnings("unused")
		private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
        		int meta = world.getBlockMetadata(x, y, z);
        		GL11.glPushMatrix();
                GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
                GL11.glPopMatrix();
        }
        
        @Override
        public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        	    
        		tileEntity = (TileEntityCampfire)te;
        	
                GL11.glPushMatrix();
       
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        
                ResourceLocation textureCampfire = (new ResourceLocation( Main.MODID + ":textures/model/campfire.png"));
                Minecraft.getMinecraft().renderEngine.bindTexture(textureCampfire);
              
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
                this.modelCampfire.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                
                               
        if(tileEntity.isActive){
                
        	Tessellator tess = Tessellator.instance;
            	
        	   	ResourceLocation textureBonfire = (new ResourceLocation( Main.MODID + ":textures/model/bonfire.png"));
            	Minecraft.getMinecraft().renderEngine.bindTexture(textureBonfire);
            	  
            	int i = TickEventHandler.clientTicks % 320;
            	
            		tess.setBrightness(15728880); 
            		
            	    // Side 1        		
            		tess.startDrawingQuads();
            		
            			tess.addVertexWithUV(x+0.15, y+0.2, z+0.15,   (double)0,   (double)((i*16)+16)/512); //INF IZQ
            			tess.addVertexWithUV(x+0.85, y+0.2, z+0.85,   (double)0.5, (double)((i*16)+16)/512); //INF DER
            			tess.addVertexWithUV(x+0.85, y+1.3, z+0.85,   (double)0.5, (double)((i*16))/512); //SUP DER
            			tess.addVertexWithUV(x+0.15, y+1.3, z+0.15,   (double)0,   (double)((i*16))/512); //SUP IZQ
            		
            		tess.draw(); 
            		
            		tess.startDrawingQuads();
            		
        			tess.addVertexWithUV(x+0.85, y+0.2, z+0.85,   (double)0,   (double)((i*16)+16)/512); //INF IZQ
        			tess.addVertexWithUV(x+0.15, y+0.2, z+0.15,   (double)0.5, (double)((i*16)+16)/512); //INF DER
        			tess.addVertexWithUV(x+0.15, y+1.3, z+0.15,   (double)0.5, (double)((i*16))/512); //SUP DER
        			tess.addVertexWithUV(x+0.85, y+1.3, z+0.85,   (double)0,   (double)((i*16))/512); //SUP IZQ
        		
        			tess.draw(); 
        			
        			// Side 2        		
            		tess.startDrawingQuads();
            		
            			tess.addVertexWithUV(x+0.85, y+0.2, z+0.15,   (double)0,   (double)((i*16)+16)/512); //INF IZQ
            			tess.addVertexWithUV(x+0.15, y+0.2, z+0.85,   (double)0.5, (double)((i*16)+16)/512); //INF DER
            			tess.addVertexWithUV(x+0.15, y+1.3, z+0.85,   (double)0.5, (double)((i*16))/512); //SUP DER
            			tess.addVertexWithUV(x+0.85, y+1.3, z+0.15,   (double)0,   (double)((i*16))/512); //SUP IZQ
            		
            		tess.draw(); 
            		
            		tess.startDrawingQuads();
            		
        			tess.addVertexWithUV(x+0.15, y+0.2, z+0.85,   (double)0,   (double)((i*16)+16)/512); //INF IZQ
        			tess.addVertexWithUV(x+0.85, y+0.2, z+0.15,   (double)0.5, (double)((i*16)+16)/512); //INF DER
        			tess.addVertexWithUV(x+0.85, y+1.3, z+0.15,   (double)0.5, (double)((i*16))/512); //SUP DER
        			tess.addVertexWithUV(x+0.15, y+1.3, z+0.85,   (double)0,   (double)((i*16))/512); //SUP IZQ
        		
        			tess.draw(); 
        			
        			tess.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        	        tess.setBrightness(15728880);
           	}
         }
        
    }
