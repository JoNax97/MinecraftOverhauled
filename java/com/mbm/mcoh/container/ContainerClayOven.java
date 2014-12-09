package com.mbm.mcoh.container;

import com.mbm.mcoh.tileentity.TileEntityClayOven;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerClayOven extends Container{
	
	private TileEntityClayOven clayOven;
	
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	
	public ContainerClayOven(InventoryPlayer inventory, TileEntityClayOven tileentity) {
		this.clayOven = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 43, 17)); // imput 1
		this.addSlotToContainer(new Slot(tileentity, 1, 53, 53)); // imput fuel
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 121, 17)); // output 1
		this.addSlotToContainer(new Slot(tileentity, 3, 63, 17)); // imput 2
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 4, 141, 17)); // output 2
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 5, 19, 53)); // output ashes
		
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters (ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.clayOven.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.clayOven.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.clayOven.currentItemBurnTime);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.clayOven.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.clayOven.cookTime);
			}
			
			if(this.lastBurnTime != this.clayOven.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.clayOven.burnTime);
			}
			
			if(this.lastCurrentItemBurnTime != this.clayOven.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.clayOven.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.clayOven.cookTime;
		this.lastBurnTime = this.clayOven.burnTime;
		this.lastCurrentItemBurnTime = this.clayOven.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0) {
            this.clayOven.cookTime = par2;
        }

        if (par1 == 1) {
            this.clayOven.burnTime = par2;
        }

        if (par1 == 2) {
            this.clayOven.currentItemBurnTime = par2;
        }
    }
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }else if (TileEntityClayOven.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (par2 >= 3 && par2 < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }


	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}