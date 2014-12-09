package com.mbm.mcoh.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mbm.mcoh.block.BlockRegistry;
import com.mbm.mcoh.handler.PlayerInteractionHandler;
import com.mbm.mcoh.tileentity.TileEntityCampfire;

public class ItemImpaledFood extends Item32x{
	
	private int cookingTime = 0;
	
	public static int hitX, hitY, hitZ;
	
	public TileEntityCampfire tileEntity;
	
	public ItemImpaledFood() {
		       
		this.maxStackSize = 1;
	}
	
	 public EnumAction getItemUseAction(ItemStack itemStack)
	    {
	        return EnumAction.block;
	    }
	 
	
	 

	    
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
		tileEntity = (TileEntityCampfire)world.getTileEntity(x, y, z);
		
		hitX = PlayerInteractionHandler.hitX;
		hitY = PlayerInteractionHandler.hitY;
		hitZ = PlayerInteractionHandler.hitZ;
		
		player.setItemInUse(itemStack, 200);		
		if(world.getBlock(x, y, z) == BlockRegistry.campfireOn){
			
		cookingTime++;
		
		if (cookingTime == 4){
			player.destroyCurrentEquippedItem();
			
			switch(this.getUnlocalizedName()){
			
			case "item.impaledFish": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(Items.cooked_fished));
			break;
			
			case "item.impaledBeef": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(Items.cooked_beef));
			break;
			
			case "item.impaledTuna": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedTuna));
			break;
			
			case "item.impaledRottenFlesh": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedFlesh));
			break;
			
			case "item.impaledPotato": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(Items.baked_potato));
			break;
			
			case "item.impaledPorkchop": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(Items.cooked_porkchop));
			break;
			
			case "item.impaledMutton": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedMutton));
			break;
			
			case "item.impaledMantaray": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedMantaray));
			break;
				
			case "item.impaledCorn": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedCorn));
			break;
			
			case "item.impaledChicken": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(Items.cooked_chicken));
			break;
			
			case "item.impaledCarrot": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedCarrot));
			break;
			
			case "item.impaledCacti": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedCactusMeat));
			break;
			
			case "item.impaledBacon": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedBacon));
			break;
			
			case "item.impaledSquid": player.inventory.setInventorySlotContents
			(player.inventory.currentItem, new ItemStack(ItemRegistry.cookedSquid));
			break;
			
			default: player.inventory.setInventorySlotContents(
					player.inventory.currentItem, new ItemStack(Items.apple));
			break;
				
			}
				
			cookingTime = 0;
			
		}
	}
		return true;
    
}
	
public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int i) {
		cookingTime = 0; 
	} 
}
