package com.mbm.mcoh.renderer;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.mbm.mcoh.block.BlockRegistry;
import com.mbm.mcoh.tileentity.TileEntityCampfire;
import com.mbm.mcoh.tileentity.TileEntityLeatherWing;
import com.mbm.mcoh.tileentity.TileEntityLeatherWorkbench;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderRegistry {
	
	public static int MetalOreRenderID;
	public static int TallPlantRenderID;
    public static int renderPass;
    
   public static void init() {
		setCustomRenderers();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new RendererCampfire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeatherWorkbench.class, new RendererLeatherWorkbench());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLeatherWing.class, new RendererLeatherWing());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.campfireOn), new RendererCampfireInHand());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.campfireOff), new RendererCampfireInHand());
	}
   
   public static void setCustomRenderers()
    {
    		MetalOreRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new RendererMetalOre());
            
            TallPlantRenderID = RenderingRegistry.getNextAvailableRenderId();
            RenderingRegistry.registerBlockHandler(new RendererTallPlant());
    }

	
    
}

