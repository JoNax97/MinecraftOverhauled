package com.mbm.mcoh.block;

import com.mbm.mcoh.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSimple extends Block{

	public BlockSimple(String unlocalizedName, String textureName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + textureName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        
        if(material == Material.rock)this.setStepSound(Block.soundTypeStone);
        if(material == Material.ground)this.setStepSound(Block.soundTypeGravel);
        if(material == Material.sand)this.setStepSound(Block.soundTypeSand);
        
	}
}
