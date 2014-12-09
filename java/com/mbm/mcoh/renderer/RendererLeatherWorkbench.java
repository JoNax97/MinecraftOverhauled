package com.mbm.mcoh.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.model.ModelLeatherWorkbench;

public class RendererLeatherWorkbench extends TileEntitySpecialRenderer  {

	public IBlockAccess blockAccess;
    
	private final ModelLeatherWorkbench modelWorkbench;   
	
  	public RendererLeatherWorkbench() {
            this.modelWorkbench = new ModelLeatherWorkbench();
       
            
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
    	        
            GL11.glPushMatrix();
    
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
    
            ResourceLocation textureWorkbench = (new ResourceLocation( Main.MODID + ":textures/model/leather_workbench.png"));
            Minecraft.getMinecraft().renderEngine.bindTexture(textureWorkbench);
          
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
    
            this.modelWorkbench.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    
            GL11.glPopMatrix();
            GL11.glPopMatrix();
           
    
     }
	}

