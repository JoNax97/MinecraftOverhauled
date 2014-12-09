package com.mbm.mcoh.block;

import com.mbm.mcoh.Main;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCheeseMold extends BlockContainer{

	protected BlockCheeseMold(String unlocalizedName, String textureName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + textureName);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}

}
