package com.mbm.mcoh.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
	
	
	public static final void init() {
		
		GameRegistry.registerTileEntity(TileEntityClayOven.class, "ClayOven");
		GameRegistry.registerTileEntity(TileEntityCampfire.class, "Campfire");
		GameRegistry.registerTileEntity(TileEntityLeatherWorkbench.class, "LeatherWorkbench");
		
    }

}
