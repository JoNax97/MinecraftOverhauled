package com.mbm.mcoh.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.mbm.mcoh.Main;

public class BlockLoose extends BlockFalling{
	
	public BlockLoose(String unlocalizedName, String textureName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + textureName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setHarvestLevel("shovel", 1);
        this.setStepSound(soundTypeSand);
        
		}
        	
	}

