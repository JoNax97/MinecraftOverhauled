package com.mbm.mcoh.renderer;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.mbm.mcoh.block.BlockRegistry;
import com.mbm.mcoh.tileentity.TileEntityCampfire;
import com.mbm.mcoh.tileentity.TileEntityGiantFern;
import com.mbm.mcoh.tileentity.TileEntityLeatherWing;
import com.mbm.mcoh.tileentity.TileEntityLeatherWorkbench;

import cpw.mods.fml.client.registry.ClientRegistry;

public class RendererRegistry {
	
	public static final void init() {
		
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new RendererCampfire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGiantFern.class, new RendererGiantFern());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeatherWorkbench.class, new RendererLeatherWorkbench());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeatherWing.class, new RendererLeatherWing());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.campfireOn), new RendererCampfireInHand());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.campfireOff), new RendererCampfireInHand());
		
		
		

		
	}
}
