package com.mbm.mcoh.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.mbm.mcoh.item.ItemBuriedTrash;
import com.mbm.mcoh.item.ItemRoofing;
import com.mbm.mcoh.item.ItemRoofingSlab;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {
	
	public static Block cheeseMold;
	
	public static Block clayOvenOn;
	public static Block clayOvenOff;
	
	public static Block campfireOn;
	public static Block campfireOff;
	
	public static Block leatherWorkbench;
	public static Block leatherWingTop;
	public static Block leatherWingRight;
	public static Block leatherWingBottom;
	public static Block leatherWingLeft;
	
	public static Block tileRoofing;
	public static Block slabRoofing;
	public static Block doubleSlabRoofing;
	public static Block stairsRoofingPale;
	public static Block stairsRoofingRed;
	
	public static Block refractoryBrick;
	
	public static Block coarseDirt;
	public static Block wetSand;
	public static Block buriedTrash;
	public static Block dust;
	
	public static Block giantFern;
	

	
	public static final void init() {
		
		GameRegistry.registerBlock(tileRoofing= new BlockRoofing("tileRoofing", "tile_roofing", Material.rock), ItemRoofing.class, "tileRoofing")
		.setHardness(1.0F);
		
		GameRegistry.registerBlock(buriedTrash= new BlockBuriedTrash("wetSand", "wet_sand", Material.sand), ItemBuriedTrash.class, "buriedTrash")
		.setHardness(0.5F);
		
		GameRegistry.registerBlock(wetSand= new BlockSimple("wetSand", "wet_sand", Material.sand), "wetSand")
		.setHardness(0.5F);
		
		GameRegistry.registerBlock(dust= new BlockLoose("dust", "dust", Material.sand), "dust")
		.setHardness(0.5F);
		
		slabRoofing = new BlockRoofingSlab(false, Material.rock, slabRoofing, tileRoofing).setBlockName("slabRoofing");
		doubleSlabRoofing = new BlockRoofingSlab(true, Material.rock, slabRoofing, tileRoofing) .setBlockName("doubleSlabRoofing");
		 		
		GameRegistry.registerBlock(slabRoofing, ItemRoofingSlab.class, "slabRoofing");
		GameRegistry.registerBlock(doubleSlabRoofing, ItemRoofingSlab.class, "doubleSlabRoofing");
		
		GameRegistry.registerBlock(refractoryBrick= new BlockSimple("refractoryBrick", "refractory_brick", Material.rock), "refractoryBrick")
			.setHardness(3.3F)
			.setHardness(0.5F)
			.setHarvestLevel("pickaxe", 1);
		
		GameRegistry.registerBlock(coarseDirt= new BlockSimple("coarseDirt", "coarse_dirt", Material.ground), "coarseDirt")
			.setHardness(2F)
			.setResistance(2.0F)
			.setHarvestLevel("shovel", 1);
				
		GameRegistry.registerBlock(stairsRoofingPale = new BlockRoofingStairs(tileRoofing, 0, "stairsRoofingPale"), "stairsRoofingPale");
		GameRegistry.registerBlock(stairsRoofingRed = new BlockRoofingStairs(tileRoofing, 1, "stairsRoofingRed"), "stairsRoofingRed");
		
		GameRegistry.registerBlock(cheeseMold = new BlockCheeseMold("cheeseMold", "cheese_mold", Material.rock), "cheeseMold");
		
		GameRegistry.registerBlock(giantFern = new BlockGiantFern(), "giantFern");
		
		GameRegistry.registerBlock(clayOvenOn = new BlockClayOven("clayOvenOn", "clay_oven_on", Material.rock, true), "clayOvenOn");
		GameRegistry.registerBlock(clayOvenOff = new BlockClayOven("clayOvenOff", "clay_oven_off", Material.rock, false), "clayOvenOff");
		
		GameRegistry.registerBlock(campfireOn = new BlockCampfire("campfireOn", "campfire", Material.wood, true), "campfireOn");
		GameRegistry.registerBlock(campfireOff = new BlockCampfire("campfireOff", "campfire", Material.wood, false), "campfireOff");
		
		GameRegistry.registerBlock(leatherWorkbench = new BlockLeatherWorkbench("leatherWorkbench", "leather_workbench_packed", Material.cloth), "leatherWorkbench");
		
		GameRegistry.registerBlock(leatherWingTop = new BlockLeatherWing("leatherWingTop", "leather_workbench_top", Material.cloth), "leatherWingTop");
   		GameRegistry.registerBlock(leatherWingRight = new BlockLeatherWing("leatherWingRight", "leather_workbench_right", Material.cloth), "leatherWingRight");
		GameRegistry.registerBlock(leatherWingBottom = new BlockLeatherWing("leatherWingBottom", "leather_workbench_bottom", Material.cloth), "leatherWingBottom");
		GameRegistry.registerBlock(leatherWingLeft = new BlockLeatherWing("leatherWingLeft", "leather_workbench_left", Material.cloth), "leatherWingLeft");
	}
}
