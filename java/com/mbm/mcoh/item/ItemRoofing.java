package com.mbm.mcoh.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemRoofing extends ItemBlockWithMetadata {

    public ItemRoofing(Block block) {
            super(block, block);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (stack.getItemDamage()) {
        case 0:
            return this.getUnlocalizedName() + "Pale";
        case 1:
            return this.getUnlocalizedName() + "Red";
        default:
            return this.getUnlocalizedName();
        }
    }
}
