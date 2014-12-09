package com.mbm.mcoh.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLeatherWorkbench extends TileEntity implements
		ISidedInventory {

	private String localizedName;
	private static final int[] slots_top = new int[] { 0, 3, 1 };
	private static final int[] slots_bottom = new int[] { 5 };
	private static final int[] slots_side = new int[] { 2, 4, 1 };

	private ItemStack[] slots = new ItemStack[6];

	public int workNeeded = 10;

	public int craftProgress;

	public int workApplied;

	public boolean isReady;

	public byte selectedSlot = -1;

	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}

	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.localizedName
				: "container.leatherWorkbench";
	}

	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(this.slots[slot] != null){
			ItemStack itemstack;
			
			if(this.slots[slot].stackSize <= amount ){
				itemstack = this.slots[slot];
				this.slots[slot] = null;
				return itemstack;
			}else{
				itemstack = this.slots[slot].splitStack(amount);
				
				if(this.slots[slot].stackSize == 0) {
					this.slots[slot] = null;
				}
				
				return itemstack;
			}
		}else{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.slots[slot] != null) {
			ItemStack itemstack = this.slots[slot];
			this.slots[slot] = null;
			return itemstack;

		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		
		this.slots[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	

	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int slot) {
		return slot == 0 ? slots_bottom : (slot == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		return false;
	}

	public int getCraftProgressScaled(int i) {

		return this.craftProgress * i / this.workNeeded;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");

			if (b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}

		this.craftProgress = (int) nbt.getShort("craftProgress");
		this.workNeeded = (int) nbt.getShort("workNeeded");

		if (nbt.hasKey("CustomName")) {
			this.localizedName = nbt.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setShort("craftProgress", (short) this.craftProgress);
		nbt.setShort("workNeeded", (short) this.workNeeded);

		NBTTagList list = new NBTTagList();

		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}

		nbt.setTag("Items", list);

		if (this.hasCustomInventoryName()) {
			nbt.setString("CustomName", this.localizedName);
		}
	}

}