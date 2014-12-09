package com.mbm.mcoh.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.item.ItemRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBuriedTrash extends Block {
	
	public String textureName;
	private IIcon iconFish;
	private IIcon iconClownfish;
	private IIcon iconBranch;
	private IIcon iconSeashell;
	private IIcon iconBone;
	private IIcon iconAlgae;
	private IIcon iconSand;
	
	private int meta = 0;

	public BlockBuriedTrash(String unlocalizedName, String textureName, Material material) {
		super(material);
		this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + textureName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(1F);
        this.setResistance(3.0F);
        this.setHarvestLevel("pickaxe", 0);
        this.setStepSound(soundTypeSand);
        this.textureName = textureName;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconSand = iconRegister.registerIcon(Main.MODID + ":" + textureName);
		this.iconFish = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_fish");
		this.iconClownfish = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_clownfish");
		this.iconBranch = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_branch");
		this.iconSeashell = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_seashell");
		this.iconBone = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_bone");
		this.iconAlgae = iconRegister.registerIcon(Main.MODID + ":" + textureName + "_algae");
		
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		if(side == 1){
		switch(meta){
		case 0: return this.iconFish;
		case 1: return this.iconClownfish;
		case 2: return this.iconBranch;
		case 3: return this.iconSeashell;
		case 4: return this.iconBone;
		case 5: return this.iconAlgae;

		default: return null;
		}
	}else{
		return this.iconSand;
	}
		
}
	
	@Override
	public int damageDropped(int meta) {
		this.meta = meta;
	    if(meta == 1) return 2;
	    return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < 6; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortuneLevel){
			switch (meta){
			case 0: return Items.fish;
			case 1: return Items.fish;
			case 2: return ItemRegistry.branch;
			case 3: return ItemRegistry.seashell;
			case 4: return Items.bone;
			case 5: return ItemRegistry.algae;
			default: return null;
			}
		}
	
	
	@Override
	public int quantityDropped(Random random){ 
		return random.nextInt(3) +1;
    }
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z){
		return new ItemStack(this,1,this.meta);
		
	}
	
}
	
