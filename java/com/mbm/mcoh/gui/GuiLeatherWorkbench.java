package com.mbm.mcoh.gui;

import org.lwjgl.opengl.GL11;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.container.ContainerLeatherWorkbench;
import com.mbm.mcoh.tileentity.TileEntityLeatherWorkbench;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiLeatherWorkbench extends InventoryEffectRenderer{
	
	public static final ResourceLocation bkground = new ResourceLocation(Main.MODID + ":textures/gui/table_1.png");
	public TileEntityLeatherWorkbench tileEntity;

	private GuiButton selectedButton = null;
	private boolean crafterIsPressed;
	
	public GuiLeatherWorkbench(InventoryPlayer inventory, World world, int x, int y, int z) {
		super(new ContainerLeatherWorkbench(inventory, world, x, y, z));
		
		this.tileEntity = (TileEntityLeatherWorkbench)world.getTileEntity(x, y, z);
		this.xSize = 176;
		this.ySize = 175;
	}
	
	public void initGui(){
		super.initGui();
	this.buttonList.add(new GuiSlotSelectionButton(0, guiLeft+ 28, guiTop + 17, ""));
	this.buttonList.add(new GuiSlotSelectionButton(1, guiLeft+ 28, guiTop + 35, ""));
	this.buttonList.add(new GuiSlotSelectionButton(2, guiLeft+ 28, guiTop + 53, ""));
	this.buttonList.add(new GuiSlotSelectionButton(3, guiLeft+ 28, guiTop + 70, ""));
	
	this.buttonList.add(new GuiCraftButton(4, guiLeft+ 108, guiTop + 63, ""));
	}
	
	protected void actionPerformed(GuiButton button) {
	 super.actionPerformed(button);
	 this.getContainer();
		if(button.id == 0)
		 {tileEntity.selectedSlot = 0; this.getContainer().onCraftMatrixChanged(this.getContainer().craftMatrix);}
		
		if(button.id == 1)
		 {tileEntity.selectedSlot = 1;this.getContainer().onCraftMatrixChanged(this.getContainer().craftMatrix);}
		
		if(button.id == 2)
		 {tileEntity.selectedSlot = 2;this.getContainer().onCraftMatrixChanged(this.getContainer().craftMatrix);}
		
		if(button.id == 3)
		 {tileEntity.selectedSlot = 3;this.getContainer().onCraftMatrixChanged(this.getContainer().craftMatrix);}
		
		if(button.id == 4)
		 {crafterIsPressed = true;
		  if(tileEntity.workApplied == tileEntity.workNeeded){
			  tileEntity.workApplied = 0;
			  tileEntity.isReady = true;
		  }else{
		  tileEntity.workApplied ++;
		  }
		}
		
		this.selectedButton = button;
	}
	
	private ContainerLeatherWorkbench getContainer() {
			return (ContainerLeatherWorkbench) this.inventorySlots;
		
	}

	@Override
	protected void mouseMovedOrUp(int mouseX, int mouseY, int action){
		super.mouseMovedOrUp(mouseX, mouseY, action);
        if (this.selectedButton != null && this.selectedButton.id == 4)
        {
        	crafterIsPressed = false;
        }
    }
	     

	public void onGuiClosed(){
		super.onGuiClosed();
		tileEntity.selectedSlot = -1;
	}
	
	public void drawGuiContainerForegroundLayer(int i, int j){
		String name = I18n.format(this.tileEntity.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 45, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float i, int k, int l){
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bkground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		switch (tileEntity.selectedSlot){
		case 0:
			drawTexturedModalRect(guiLeft + 28, guiTop + 16, 195, 4, 6, 11); break;
		case 1:
			drawTexturedModalRect(guiLeft + 28, guiTop + 34, 195, 4, 6, 11); break;
		case 2:
			drawTexturedModalRect(guiLeft + 28, guiTop + 52, 195, 4, 6, 11); break;
		case 3:
			drawTexturedModalRect(guiLeft + 28, guiTop + 70, 195, 4, 6, 11); break;
		}
		
		if(crafterIsPressed){
			drawTexturedModalRect(guiLeft + 108, guiTop + 63, 184, 36, 16, 16);
		}
		
		drawTexturedModalRect(guiLeft + 128, guiTop + 69, 181, 56 + tileEntity.workApplied/3 * 4, 32, 4);
	    
	}
}