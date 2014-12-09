package com.mbm.mcoh.handler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.block.BlockRegistry;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerInteractionHandler {
	
	public Item itemInHand;	
	public Block blockClicked;
	
	public static int hitX;
	public static int hitY;
	public static int hitZ;
	
	
	
	@Instance
	private Minecraft instance;
	
	
	@SubscribeEvent
	public void setItemInHand(PlayerInteractEvent event){
		
		if(event.entityPlayer.getCurrentEquippedItem() != null){
			this.itemInHand = event.entityPlayer.getCurrentEquippedItem().getItem();
		}else{
			this.itemInHand = Item.getItemFromBlock(Blocks.air);

		}
	}
	
	@SubscribeEvent
	public void setBlockClicked(PlayerInteractEvent event){
		
		if(Minecraft.getMinecraft().objectMouseOver != null){
		
		PlayerInteractionHandler.hitX = Minecraft.getMinecraft().objectMouseOver.blockX;
		PlayerInteractionHandler.hitY = Minecraft.getMinecraft().objectMouseOver.blockY;
		PlayerInteractionHandler.hitZ = Minecraft.getMinecraft().objectMouseOver.blockZ;
	    
		this.blockClicked = event.world.getBlock(hitX, hitY, hitZ);
		}

	}

	@SubscribeEvent
	public void litCampfire(PlayerInteractEvent event)
	{   
		
		if(event.action == Action.RIGHT_CLICK_BLOCK && 
								(itemInHand == Items.flint_and_steel || itemInHand == Item.getItemFromBlock(Blocks.torch))
								&& blockClicked == BlockRegistry.campfireOff){
			
			event.useItem = Result.DENY;
			event.world.setBlock(hitX, hitY, hitZ, BlockRegistry.campfireOn);
			event.world.playSoundEffect((double)hitX + 0.5D, (double)hitY + 0.5D, (double)hitZ + 0.5D, "fire.ignite", 1.0F, 1.0F);
		
			
		if(itemInHand == Items.flint_and_steel ){
				event.entityPlayer.getCurrentEquippedItem().damageItem(1, event.entityPlayer);;
			}
		}
		
	   				
		if(event.action == Action.LEFT_CLICK_BLOCK 
								&& itemInHand == Item.getItemFromBlock(Blocks.air)
								&& blockClicked == BlockRegistry.campfireOn){	
				
			event.world.setBlock(hitX, hitY, hitZ, BlockRegistry.campfireOff);
			
			}
			
		if(event.action == Action.RIGHT_CLICK_BLOCK 
					&& itemInHand == Items.record_11
					&& blockClicked == BlockRegistry.campfireOn){	
	
				event.world.playSound(hitX, hitY, hitZ,  Main.MODID + ":" + "campfireSongSong", 1.0F, 1.0F, false);;
							
		}
	}
}
	
