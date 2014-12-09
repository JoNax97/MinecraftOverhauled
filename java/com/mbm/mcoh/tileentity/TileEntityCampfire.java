package com.mbm.mcoh.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityCampfire extends TileEntity{
	
	public boolean isActive;
	
	public TileEntityCampfire(boolean isActive){
		this.isActive = isActive;
	}
	
}