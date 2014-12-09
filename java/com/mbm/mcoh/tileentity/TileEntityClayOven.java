package com.mbm.mcoh.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.mbm.mcoh.block.BlockClayOven;
import com.mbm.mcoh.item.ItemRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityClayOven extends TileEntity implements ISidedInventory {
	
private String localizedName;
	
	private static final int[] slots_top = new int[]{0,3,1};
	private static final int[] slots_bottom = new int[]{5};
	private static final int[] slots_side = new int[]{2,4,1};
	
	private ItemStack[] slots = new ItemStack [6];
	
	public int furnaceSpeed = 350;
	/**
     * The number of ticks that the furnace will keep burning
     */
	public int burnTime;
	/**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
	public int currentItemBurnTime;
	/**
     * The number of ticks that the current item has been cooking for
     */
	public int cookTime;

	/**
     * The fuel that just burnt out
     */
	
	public ItemStack lastFuel = null;
	
	
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}
	
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.localizedName : "container.clayOven";
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
		if(this.slots[slot]!= null) {
			ItemStack itemstack = this.slots[slot];
			this.slots[slot] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.slots[slot] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openInventory() {}
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return slot == 2 ? false : (slot == 1 ? isItemFuel(itemstack) : true);
	}
	
	public static boolean isItemFuel (ItemStack itemstack) {
		return getItemBurnTime(itemstack) > 0;
	}

	private static int getItemBurnTime(ItemStack itemstack) {
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);
				
					if(block == Blocks.sapling) return 350;
					if(block == Blocks.coal_block) return 0;
					if(block == Blocks.log) return 2500;
					if(block == Blocks.log2)return 2500;
					if(block == Blocks.planks) return 600;
					
					if(block == Blocks.hay_block) return 1000;
					if(block == Blocks.wool) return 500;
					if(block == Blocks.carpet) return 200;
					
					
				}
			
				
			
				if(item == Items.coal && itemstack.getItemDamage() == 1) return 300;
				if(item == Items.coal && itemstack.getItemDamage() == 0) return 0;
				if(item == Items.lava_bucket) return 0;
				if(item == Items.blaze_rod) return 0;
						
				if(item == Items.stick) return 150;
				if(item == Items.string) return 50;
				if(item == Items.feather) return 50;
				if(item == Items.paper) return 100;
				
				if(item == ItemRegistry.woodenPlankOak) return 300;
				if(item == ItemRegistry.woodenPlankBirch) return 300;
				if(item == ItemRegistry.woodenPlankSpruce) return 300;
				if(item == ItemRegistry.woodenPlankAcacia) return 300;
				if(item == ItemRegistry.woodenPlankJungle) return 300;
				if(item == ItemRegistry.woodenPlankBigOak) return 300;
				
				
				
			}
		return GameRegistry.getFuelValue(itemstack);
	}
	
	public boolean isBurning() {
		return this.burnTime > 0;
	}
	
	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		
		if(this.isBurning()) {
			this.burnTime--;
		}
		if(!this.worldObj.isRemote) {
			if(this.burnTime == 0 && this.canSmeltSlot1() && this.canSmeltSlot2()) {
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				if(this.isBurning()) {
					flag1 = true;
					
						if(this.slots[1] != null) {
						
						if(slots[5] == null){
							this.slots[5] = this.getFuelResult(lastFuel);
						}
						
						if(this.slots[5] != null && lastFuel != null) {
						if(slots[5].getItem() == this.getFuelResult(lastFuel).getItem()){
							this.slots[5].stackSize = this.slots[5].stackSize + this.getFuelResult(lastFuel).stackSize;
							}
						}
						if(lastFuel == null){
							slots[5] = null;
							
						}
					}
					if(this.slots[1] != null) {
						this.slots[1].stackSize--;
						this.lastFuel = slots[1];
						
						if(this.slots[1].stackSize == 0) {
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}
			if(this.isBurning() && this.canSmeltSlot1() && this.canSmeltSlot2()) {
			this.cookTime++;
			
			if(this.cookTime == this.furnaceSpeed) {
				this.cookTime = 0;
				this.smeltItemSlot1();
				this.smeltItemSlot2();
				flag1 = true;
				}
			}else{
				this.cookTime = 0;
			}
			
			if(flag != this.isBurning()) {
				flag1 = true;
				BlockClayOven.updateState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if(flag1) {
			this.markDirty();
		}	
	}
	
	
	private ItemStack getFuelResult(ItemStack itemstack) {
		if(itemstack == null){
			return null;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);
				
					if(block == Blocks.log) return new ItemStack(Items.coal, 5, 1);
					if(block == Blocks.log2) return new ItemStack(Items.coal, 5, 1);
					if(block == Blocks.planks) return new ItemStack(ItemRegistry.ashes, 5, 1);
					
										
					if(block == Blocks.hay_block) return new ItemStack(ItemRegistry.ashes, 10, 0);
					if(block == Blocks.wool) return new ItemStack(ItemRegistry.ashes, 10, 0);
					
				}
				
				if(item == Items.coal && itemstack.getItemDamage() == 1) return new ItemStack(ItemRegistry.ashes, 5, 0);
				if(item == ItemRegistry.woodenPlankOak) return new ItemStack(Items.coal, 1, 1);
				if(item == ItemRegistry.woodenPlankBirch) return new ItemStack(Items.coal, 1, 1);
				if(item == ItemRegistry.woodenPlankSpruce) return new ItemStack(Items.coal, 1, 1);
				if(item == ItemRegistry.woodenPlankAcacia) return new ItemStack(Items.coal, 1, 1);
				if(item == ItemRegistry.woodenPlankJungle) return new ItemStack(Items.coal, 1, 1);
				if(item == ItemRegistry.woodenPlankBigOak) return new ItemStack(Items.coal, 1, 1);
				
				
			}
		return new ItemStack(ItemRegistry.ashes, 1, 1);
	}

	public boolean canSmeltSlot1() {
		if (this.slots[0] == null) {
			return false;
		}else{
			
			ItemStack itemstack = this.getSmeltingResult(this.slots[0]);
			
			if(itemstack == null) return false;
			if(this.slots[2] == null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize + itemstack.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}
	
	public boolean canSmeltSlot2() {
		if (this.slots[3] == null) {
			return false;
		}else{
			
			ItemStack itemstack = this.getSmeltingResult(this.slots[3]);
			
			if(itemstack == null) return false;
			if(this.slots[4] == null) return true;
			if(!this.slots[4].isItemEqual(itemstack)) return false;
			
			int result = this.slots[4].stackSize + itemstack.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}
	

	public ItemStack getSmeltingResult(ItemStack itemStack) {

			if(itemStack.getItem() == Items.beef) return  new ItemStack(Items.cooked_beef);
			if(itemStack.getItem() == Items.potato) return  new ItemStack(Items.baked_potato);
			if(itemStack.getItem() == Items.chicken) return  new ItemStack(Items.cooked_chicken);
			if(itemStack.getItem() == Items.porkchop) return  new ItemStack(Items.cooked_porkchop);
			if(itemStack.getItem() == Items.fish) return  new ItemStack(Items.cooked_fished);
			
			if(itemStack.getItem() == ItemRegistry.bacon) return  new ItemStack(ItemRegistry.cookedBacon);
			if(itemStack.getItem() == ItemRegistry.tuna) return  new ItemStack(ItemRegistry.cookedTuna);
			if(itemStack.getItem() == ItemRegistry.squid) return  new ItemStack(ItemRegistry.cookedSquid);
			if(itemStack.getItem() == ItemRegistry.mantaray) return  new ItemStack(ItemRegistry.cookedMantaray);
			if(itemStack.getItem() == ItemRegistry.corn) return  new ItemStack(ItemRegistry.cookedCorn);
			if(itemStack.getItem() == ItemRegistry.cactusMeat) return  new ItemStack(ItemRegistry.cookedCactusMeat);
			
			if(itemStack.getItem() == Items.carrot) return  new ItemStack(ItemRegistry.cookedCarrot);
			if(itemStack.getItem() == Items.rotten_flesh) return  new ItemStack(ItemRegistry.cookedFlesh);
			
			return null;
	}

	public void smeltItemSlot1() {
		if(this.canSmeltSlot1()) {
			ItemStack itemstack = this.getSmeltingResult(this.slots[0]);
			
			if(this.slots[2] == null) {
				this.slots[2] = itemstack.copy();
			}else if(this.slots[2].isItemEqual(itemstack)) {
				this.slots[2].stackSize += itemstack.stackSize;
			}
			
			this.slots[0].stackSize--;
			
			if(this.slots[0].stackSize <= 0) {
				this.slots[0] = null;
			}
		}
	}
	
	public void smeltItemSlot2() {
		if(this.canSmeltSlot1()) {
			ItemStack itemstack = this.getSmeltingResult(this.slots[3]);
			
			if(this.slots[4] == null) {
				this.slots[4] = itemstack.copy();
			}else if(this.slots[4].isItemEqual(itemstack)) {
				this.slots[4].stackSize += itemstack.stackSize;
			}
			
			this.slots[3].stackSize--;
			
			if(this.slots[3].stackSize <= 0) {
				this.slots[3] = null;
			}
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int slot) {
		return slot == 0 ? slots_bottom : (slot == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		return this.isItemValidForSlot(slot, itemstack);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		return side != 0 || slot != 1 || itemstack.getItem() == Items.bucket;
	}
	
	public int getBurnTimeRemainingScaled(int i) {
		if(this.currentItemBurnTime ==0) {
			this.currentItemBurnTime = this.furnaceSpeed;
		}
		return this.burnTime * i / this.currentItemBurnTime;
	}
	
	public int getCookProgressScaled(int i) {
		return this.cookTime * i / this.furnaceSpeed;
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");
			
			if(b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		
		this.burnTime = (int)nbt.getShort("BurnTime");
		this.cookTime = (int)nbt.getShort("CookTime");
		this.currentItemBurnTime = (int)nbt.getShort("CurrentBurnTime");
		
		if(nbt.hasKey("CustomName")) {
			this.localizedName = nbt.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		nbt.setShort("BurnTime", (short)this.burnTime);
		nbt.setShort("CookTime", (short)this.cookTime);
		nbt.setShort("CurrentBurnTime", (short)this.currentItemBurnTime);
		
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < this.slots.length; i++) {
			if(this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
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