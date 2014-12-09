package com.mbm.mcoh.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mbm.mcoh.block.BlockRegistry;
import com.mbm.mcoh.container.ContainerClayOven;
import com.mbm.mcoh.container.ContainerLeatherWorkbench;
import com.mbm.mcoh.gui.GuiClayOven;
import com.mbm.mcoh.gui.GuiLeatherWorkbench;
import com.mbm.mcoh.gui.GuiRegistry;
import com.mbm.mcoh.tileentity.TileEntityClayOven;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity !=null){
			switch (ID) {
			case GuiRegistry.guiIDClayOven:
				
				if(entity instanceof TileEntityClayOven){
					return  new ContainerClayOven(player.inventory, (TileEntityClayOven) entity);
				}
				return null;
			}
		}
		
		if(ID == GuiRegistry.guiIDLeatherWorkbench){
			return ID == GuiRegistry.guiIDLeatherWorkbench && world.getBlock(x, y, z) == BlockRegistry.leatherWorkbench? new ContainerLeatherWorkbench(player.inventory, world, x, y, z): null;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity !=null){
			switch (ID) {
			case GuiRegistry.guiIDClayOven:
				
				if(entity instanceof TileEntityClayOven){
					return  new GuiClayOven(player.inventory, (TileEntityClayOven) entity);
				}
				return null;
			}
		}
			
		if(ID == GuiRegistry.guiIDLeatherWorkbench){
			return ID == GuiRegistry.guiIDLeatherWorkbench && world.getBlock(x, y, z) == BlockRegistry.leatherWorkbench? new GuiLeatherWorkbench(player.inventory, world, x, y, z): null;
		}
			
			return null;
		}
	}
