package com.mbm.mcoh.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class BlockRoofingStairs extends BlockStairs {

public BlockRoofingStairs(Block BaseBlock, int meta, String unlocalizedName) {
super(BaseBlock, meta);

this.setBlockName(unlocalizedName);
this.setLightOpacity(0);
this.setCreativeTab(CreativeTabs.tabBlock);
}

public boolean isOpaqueCube(){
   return false;
}

}