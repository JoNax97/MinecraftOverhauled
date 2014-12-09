package com.mbm.mcoh.container;

import com.mbm.mcoh.item.ItemHammer;
import com.mbm.mcoh.item.ItemKnife;
import com.mbm.mcoh.item.ItemSaw;
import com.mbm.mcoh.item.ItemTool;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SlotCraftingTool extends Slot{
	
	public boolean isSelected;

	public SlotCraftingTool(IInventory inventory, int i,int j, int k) {
		super(inventory, i, j, k);
		}
	
	   @Override
	   public boolean isItemValid(ItemStack itemstack) {
	      return isItemTool(itemstack);
	   }

	   @Override
	   public int getSlotStackLimit() {
	      return 1;
	   }

	   private boolean isItemTool(ItemStack itemstack) {
	
		   if(itemstack.getItem() instanceof ItemBlock){
			   return false;
		   }else{
			   Item item = itemstack.getItem();
		
			   if(item instanceof ItemAxe) return true;
			   if(item instanceof ItemSaw) return true;
			   if(item instanceof ItemHammer) return true;
			   if(item instanceof ItemTool) return true;
			if(item instanceof ItemKnife) return true;
			if(item == Items.shears) return true;

			
		
			return false;
		
		}
	}	
}

