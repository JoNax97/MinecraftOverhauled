package com.mbm.mcoh.block;

import java.util.List;

import com.mbm.mcoh.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockRoofing extends Block {
	
	public IIcon iconTilePale;
	public IIcon iconTileRed;
	public String textureName;

	public BlockRoofing(String unlocalizedName, String textureName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + textureName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2F);
        this.setResistance(3.0F);
        this.setHarvestLevel("pickaxe", 0);
        this.setStepSound(soundTypeStone);
        this.textureName = textureName;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconTilePale = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_pale");
		this.iconTileRed = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_red");
		
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		
		switch(meta){
		case 0: return this.iconTilePale;
		case 1: return this.iconTileRed;
		default: return null;
		}
		
	}
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < 2; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
}
