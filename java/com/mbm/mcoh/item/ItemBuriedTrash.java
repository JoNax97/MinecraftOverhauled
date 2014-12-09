package com.mbm.mcoh.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBuriedTrash extends ItemBlockWithMetadata {

    public ItemBuriedTrash(Block block) {
            super(block, block);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (stack.getItemDamage()) {
        case 0:
            return this.getUnlocalizedName() + "WithFish";
        case 1:
            return this.getUnlocalizedName() + "WithClownfish";
        case 2:
            return this.getUnlocalizedName() + "WithBranch";
        case 3:
            return this.getUnlocalizedName() + "WithSeashell";
        case 4:
            return this.getUnlocalizedName() + "WithBone";
        case 5:
            return this.getUnlocalizedName() + "WithAlgae";
        
        default:
            return this.getUnlocalizedName();
        }
    }
}
