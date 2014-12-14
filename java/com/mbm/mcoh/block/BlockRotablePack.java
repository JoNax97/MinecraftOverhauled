package com.mbm.mcoh.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import com.mbm.mcoh.Main;

import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockRotablePack extends BlockLog{
	
	private IIcon iconBambooSide;
	private IIcon iconBambooTop;
	
	public BlockRotablePack() {
		
		super();
	
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs crativeTab, List list)
    {
        list.add(new ItemStack(item, 1, 0));

    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	iconBambooSide = iconRegister.registerIcon(Main.MODID + ":bamboo_block_side");
    	iconBambooTop = iconRegister.registerIcon(Main.MODID + ":bamboo_block_top");

    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int meta)
    {
        switch(meta){
        case 0: return iconBambooSide;
        default: return iconBambooSide;
        }
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int meta)
    {
        switch(meta){
        case 0: return iconBambooTop;
        default: return iconBambooTop;
        }
    }
    
    @Override
    public int damageDropped(int meta) {
       if(meta <1){
    	   return meta;
       }else{
    	   return 0;
       }
    }
    
    

}