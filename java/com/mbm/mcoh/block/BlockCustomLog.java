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

public class BlockCustomLog extends BlockLog{
	
	private IIcon iconOliveSide;
	private IIcon iconOliveTop;
	private IIcon iconSpruceSide;
	private IIcon iconSpruceTop;
	private IIcon iconSpruceEmpty;
	
	public BlockCustomLog() {
		
		super();
	
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs crativeTab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
    	iconOliveSide = iconRegister.registerIcon(Main.MODID + ":log_olive");
    	iconOliveTop = iconRegister.registerIcon(Main.MODID + ":log_olive_top");
    	iconSpruceSide = iconRegister.registerIcon(Main.MODID + ":log_spruce_resin");
    	iconSpruceTop = Blocks.log.getIcon(0, 1);
    	iconSpruceEmpty = Blocks.log.getIcon(2, 1);
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int meta)
    {
        switch(meta){
        case 0: return iconOliveSide;
        case 1: return iconSpruceSide;
        case 2: return iconOliveSide;
        default: return iconOliveSide;
        }
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int meta)
    {
        switch(meta){
        case 0: return iconOliveTop;
        case 1: return iconSpruceTop;
        case 2: return iconOliveSide;
        default: return iconOliveSide;
        }
    }
    
    @Override
    public int damageDropped(int meta) {
       if(meta <2){
    	   return meta;
       }else{
    	   return 0;
       }
    }
    
    

}