package com.mbm.mcoh.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

 public class SlotCraftingResult extends Slot {
	EntityPlayer player;
	
	private int slotID;
	private IInventory inventory;
	
	public SlotCraftingResult(IInventory i, int id, int x, int y, EntityPlayer p) {
		super(i, id, x, y);
		this.player = p;
		this.slotID = id;
		this.inventory = i;
	}

	//Decides which items can be placed inside the slot by the player.
	public boolean isItemValid(ItemStack itemStack) {
		return false;
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)	{

	}

	public boolean canInteractWith(EntityPlayer var1){

		return false;
	}
	
    public void putStack(ItemStack itemStack)
    {
        this.inventory.setInventorySlotContents(this.slotID, itemStack);
        super.onSlotChanged();
    }

 }
