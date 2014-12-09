package com.mbm.mcoh.gui;

import java.io.PrintStream;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.tileentity.TileEntityClayOven;
import com.mbm.mcoh.container.ContainerClayOven;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiClayOven extends GuiContainer{
	
	public static final ResourceLocation bkground = new ResourceLocation(Main.MODID + ":textures/gui/clay_oven_simple.png");
	
	public TileEntityClayOven clayOven;

	public GuiClayOven(InventoryPlayer inventory, TileEntityClayOven entity){
		super(new ContainerClayOven(inventory, entity));
		
		this.clayOven = entity;
		this.xSize = 175;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int i, int j){
		String name = I18n.format(this.clayOven.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float i, int k, int l){
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bkground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if (this.clayOven.isBurning())
        {
            int progress = this.clayOven.getBurnTimeRemainingScaled(14);
            this.drawTexturedModalRect(guiLeft + 53, guiTop + 37 + 12 - progress, 176, 12 - progress, 14, progress + 1);
            
            progress = this.clayOven.getCookProgressScaled(24);
            this.drawTexturedModalRect(guiLeft + 89, guiTop + 17, 176, 14, progress + 1, 16);
            
            progress = this.clayOven.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(guiLeft + 38 + progress , guiTop + 55, 176 + progress, 31, 16, 16);
        }
	}

	@SuppressWarnings("unused")
	private PrintStream println(int progress) {
		// TODO Auto-generated method stub
		return null;
	}
}