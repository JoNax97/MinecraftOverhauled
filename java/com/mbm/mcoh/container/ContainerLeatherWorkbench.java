package com.mbm.mcoh.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mbm.mcoh.block.BlockRegistry;
import com.mbm.mcoh.manager.TieredCraftingManager;
import com.mbm.mcoh.tileentity.TileEntityLeatherWorkbench;

public class ContainerLeatherWorkbench extends Container{

	public InventoryCrafting craftMatrix;
	private World world;
	private int tier = 1;
	
	public TileEntityLeatherWorkbench tileEntity;
	
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerLeatherWorkbench(InventoryPlayer inventory, World world, int x, int y, int z){
		
		tileEntity = (TileEntityLeatherWorkbench)world.getTileEntity(x, y, z);
		craftMatrix = new InventoryCrafting(this, 3, 3);
			
		this.world = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		
		
		this.addSlotToContainer(new SlotCraftingTool(tileEntity, 0, 11, 13)); // Tools slot 1
		this.addSlotToContainer(new SlotCraftingTool(tileEntity, 1, 11, 31)); // Tools slot 2
		this.addSlotToContainer(new SlotCraftingTool(tileEntity, 2, 11, 49)); // Tools slot 3
		this.addSlotToContainer(new SlotCraftingTool(tileEntity, 3, 11, 67)); // Tools slot 4
		
		this.addSlotToContainer(new SlotCraftingResult(tileEntity, 4, 123, 38, inventory.player)); // Output 1
		this.addSlotToContainer(new SlotCraftingResult(tileEntity, 5, 143, 38, inventory.player)); // Output 2
		
		
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				this.addSlotToContainer(new Slot(craftMatrix, i + j * 3, 40 + i * 18, 20 +  j* 18 ));
			}
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i *9 + 9, 8 + j * 18, 93 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 151));

		}
		
		onCraftMatrixChanged(craftMatrix);
		
	}
	
    public void onCraftMatrixChanged(IInventory iinventory){
    	
    	if(tileEntity.selectedSlot >= 0){
          tileEntity.setInventorySlotContents(4, TieredCraftingManager.getInstance().findMatchingRecipe(craftMatrix, world, this.getSlot(tileEntity.selectedSlot).getStack(), this.tier));
    	}
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotID) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotID);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotID == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotID >= 10 && slotID < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (slotID >= 37 && slotID < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
	
    public void onContainerClosed(EntityPlayer player){
        super.onContainerClosed(player);

        if (!this.world.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    player.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
    
    

		
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(world.getBlock(posX, posY, posZ) != BlockRegistry.leatherWorkbench){
			return false;
		}else{
			return player.getDistanceSq( (double)posX +0.5D, (double)posY +0.5D, (double)posZ +0.5D) <= 64.0D;
		}
	}
	
}