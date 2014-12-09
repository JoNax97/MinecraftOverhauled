package com.mbm.mcoh.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class TickEventHandler {
	
	public static int clientTicks = 0;
	
	
	@Instance
	private Minecraft instance;
	
		
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event){
	 if(event.phase == Phase.END){
	 GuiScreen gui = Minecraft.getMinecraft().currentScreen;
	 if(gui == null || !gui.doesGuiPauseGame()){
		 clientTicks++;
	 	}
	 }
	 
	 
	 
	 
	
	}
}
