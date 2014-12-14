package com.mbm.mcoh.block;

import com.mbm.mcoh.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockStone extends Block {
	
	public IIcon texture;

	protected BlockStone(String unlocalizedName, String textureName) {
		super(Material.rock);
		this.setBlockName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setResistance(15F);
        this.setStepSound(soundTypeStone);
        this.setBlockTextureName(textureName);
        this.texture = texture;
		
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		texture = iconRegister.registerIcon(Main.MODID + ":" + textureName);
	}
	
	@Override
	 public IIcon getIcon(int side, int meta){
		return texture;
	}


}
