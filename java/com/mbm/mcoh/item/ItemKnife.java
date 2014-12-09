package com.mbm.mcoh.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import com.google.common.collect.Sets;

public class ItemKnife extends net.minecraft.item.ItemTool{

	private static final Set<Block> breakingSet = Sets.newHashSet(new Block[] {Blocks.double_plant, Blocks.vine, Blocks.brown_mushroom_block, Blocks.red_mushroom_block});
	
	protected ItemKnife(float baseDamage, ToolMaterial material, Set<?> set) {
		super(baseDamage, material, breakingSet);
	}

}
