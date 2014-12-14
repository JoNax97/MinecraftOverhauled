package com.mbm.mcoh.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemCustomLog extends ItemBlockWithMetadata{

	public ItemCustomLog(Block block) {
		super(block, block);

	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    switch (stack.getItemDamage()) {
	    case 0:
	        return "logOlive";
	    case 1:
	        return "logResineSpruce";
	    case 2:
	        return "logOlive";
	    }
		return "logResineSpruce";
	}

}
