package com.mbm.mcoh;

import com.mbm.mcoh.block.BlockRegistry;
import com.mbm.mcoh.item.ItemRegistry;
import com.mbm.mcoh.renderer.RendererRegistry;
import com.mbm.mcoh.tileentity.TileEntityRegistry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	
    	BlockRegistry.init();
    	//BlockReplacement.init();
    	TileEntityRegistry.init();
    	ItemRegistry.init();
    	RendererRegistry.init();
    	
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}