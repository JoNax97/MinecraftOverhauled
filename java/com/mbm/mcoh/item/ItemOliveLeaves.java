package com.mbm.mcoh.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemOliveLeaves extends ItemBlockWithMetadata{

	public ItemOliveLeaves(Block block) {
		super(block, block);

	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    switch (stack.getItemDamage()) {
	    case 0:
	        return "leavesOlive";
	    case 1:
	        return "leavesOliveFull";
	    }
		return "leavesOlive";
	}

}
