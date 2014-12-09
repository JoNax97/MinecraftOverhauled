package com.mbm.mcoh.item;

import com.mbm.mcoh.block.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class ItemRoofingSlab extends ItemSlab
{
    public ItemRoofingSlab(Block block)
    {
	    super(block, (BlockSlab)BlockRegistry.slabRoofing, (BlockSlab)BlockRegistry.doubleSlabRoofing, false);
	    this.setMaxDamage(0);
	    this.setHasSubtypes(true);
    }
}