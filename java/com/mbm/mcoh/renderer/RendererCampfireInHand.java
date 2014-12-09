package com.mbm.mcoh.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.model.ModelCampfire;

public class RendererCampfireInHand implements IItemRenderer {
	
	private ModelCampfire modelCampfire;
	
	public RendererCampfireInHand() {
        this.modelCampfire = new ModelCampfire();
        
}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	
	
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
				
				switch (type){
				case EQUIPPED:
					{
						GL11.glPushMatrix();
	                      
						ResourceLocation textureCampfire = (new ResourceLocation( Main.MODID + ":textures/model/campfire.png"));
		                Minecraft.getMinecraft().renderEngine.bindTexture(textureCampfire);

		                             
		                GL11.glPushMatrix();
		                
		                GL11.glTranslatef(0.5F,2F, 0.5F);
	                	GL11.glRotatef(180F, 0F, 0F, 1F);
	                	GL11.glScalef(1F, 1F, 1F);
		                	this.modelCampfire.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		                	
		                GL11.glPopMatrix();
		                GL11.glPopMatrix();
		                
		                break;
					}
				case EQUIPPED_FIRST_PERSON:
				{
					GL11.glPushMatrix();
                      
					ResourceLocation textureCampfire = (new ResourceLocation( Main.MODID + ":textures/model/campfire.png"));
	                Minecraft.getMinecraft().renderEngine.bindTexture(textureCampfire);

	                             
	                GL11.glPushMatrix();
	                
	                GL11.glTranslatef(0.5F,2F, 0.5F);
                	GL11.glRotatef(180F, 0F, 0F, 1F);
                	GL11.glScalef(1F, 1F, 1F);
	                	this.modelCampfire.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	                	
	                GL11.glPopMatrix();
	                GL11.glPopMatrix();
	                
	                break;
				}
				case INVENTORY: {
					GL11.glPushMatrix();
                    
					ResourceLocation textureCampfire = (new ResourceLocation( Main.MODID + ":textures/model/campfire.png"));
	                Minecraft.getMinecraft().renderEngine.bindTexture(textureCampfire);

	                             
	                GL11.glPushMatrix();
	                
	                GL11.glTranslatef(0F, 1.3F, 0F);
                	GL11.glRotatef(180F, 0F, 0F, 1F);
                	GL11.glScalef(1.1F, 1.1F, 1.1F);
	                	this.modelCampfire.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	                	
	                GL11.glPopMatrix();
	                GL11.glPopMatrix();
	                
	                break;
				}
				default: {
					GL11.glPushMatrix();
                    
					ResourceLocation textureCampfire = (new ResourceLocation( Main.MODID + ":textures/model/campfire.png"));
	                Minecraft.getMinecraft().renderEngine.bindTexture(textureCampfire);

	                             
	                GL11.glPushMatrix();
	                
	                GL11.glTranslatef(0F, 1F, 0F);
                	GL11.glRotatef(180F, 0F, 0F, 1F);
                	GL11.glScalef(1F, 1F, 1F);
	                	this.modelCampfire.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	                	
	                GL11.glPopMatrix();
	                GL11.glPopMatrix();
	                
	                break;
				}
									
				}         

	}





}
