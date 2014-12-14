package com.mbm.mcoh.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.mbm.mcoh.Main;
import com.mbm.mcoh.item.ItemRegistry;
import com.mbm.mcoh.renderer.RenderRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetalOre extends Block {

	public String textureName;
	public IIcon texture;
	
	
	public BlockMetalOre(String unlocalizedName, String textureName, int harvestLevel) {
		super(Material.rock);
		this.setBlockName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setResistance(15F);
        this.setHardness(3F);
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.setStepSound(soundTypeStone);
        this.textureName = textureName;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		texture = iconRegister.registerIcon(Main.MODID + ":" + textureName);
	}
	
	@Override
	 public IIcon getIcon(int side, int meta){
		return texture;
	}
	
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public Item getItemDropped(int meta, Random random, int fortune)
    {
    	switch(this.textureName){
    	case "silver_ore": return ItemRegistry.silverChunk;
    	case "nickel_ore": return ItemRegistry.nickelChunk;
    	case "manganese_ore": return ItemRegistry.manganeseChunk;
    	case "lead_ore": return ItemRegistry.leadChunk;
    	case "aluminum_ore": return ItemRegistry.aluminumChunk;
    	case "tin_ore": return ItemRegistry.tinChunk;
    	case "iron_ore": return ItemRegistry.ironChunk;
    	case "gold_ore": return ItemRegistry.goldChunk;
    	case "copper_ore": return ItemRegistry.copperChunk;
    	
    	}
		return ItemRegistry.rock;
    }
    
	
    @Override
    public int getRenderType()
    {
    return RenderRegistry.MetalOreRenderID;
    }
    
	@Override
    public boolean renderAsNormalBlock()
	{
    return false; 
	}
	
	@Override
    public int getRenderBlockPass()
	{
            return 1;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
    	switch(this.textureName){
    	case "silver_ore": return ItemRegistry.silverChunk;
    	case "nickel_ore": return ItemRegistry.nickelChunk;
    	case "manganese_ore": return ItemRegistry.manganeseChunk;
    	case "lead_ore": return ItemRegistry.leadChunk;
    	case "aluminum_ore": return ItemRegistry.aluminumChunk;
    	case "tin_ore": return ItemRegistry.tinChunk;
    	case "iron_ore": return ItemRegistry.ironChunk;
    	case "gold_ore": return ItemRegistry.goldChunk;
    	case "copper_ore": return ItemRegistry.copperChunk;
    	
    	}
		return ItemRegistry.rock;
    }
	
    @Override
    public boolean canRenderInPass(int pass) {

    	RenderRegistry.renderPass = pass;
    	return true;
	}

	public Block getOverlayBlock(IBlockAccess world, int x, int y, int z) {

	int largest;	
	
	int counterSlate = 0, counterBasalt = 0, counterPumice = 0, counterMudstone = 0, counterMarble = 0,
	counterLimestone = 0, counterDunite = 0, counterConglomerate = 0,counterGraniteWhite = 0, counterGraniteRed = 0;
	
	 Block[] adjacentBlockRegistry = new Block[6];
	 adjacentBlockRegistry[0] = world.getBlock(x+1, y, z);
	 adjacentBlockRegistry[1] = world.getBlock(x-1, y, z);
	 adjacentBlockRegistry[2] = world.getBlock(x, y+1, z);
	 adjacentBlockRegistry[3] = world.getBlock(x, y-1, z);
	 adjacentBlockRegistry[4] = world.getBlock(x, y, z+1);
	 adjacentBlockRegistry[5] = world.getBlock(x, y, z-1);
	 
	 for(int i = 0; i < 6; i++){
		 if (adjacentBlockRegistry[i] == BlockRegistry.slate) counterSlate++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.basalt) counterBasalt++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.pumice) counterPumice++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.mudstone) counterMudstone++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.marble) counterMarble++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.limestone) counterLimestone++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.dunite) counterDunite++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.conglomerate) counterConglomerate++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.graniteWhite) counterGraniteWhite++;
		 if (adjacentBlockRegistry[i] == BlockRegistry.graniteRed) counterGraniteRed++;
	 }
	 
	 ArrayList<Integer> inputs = new ArrayList<Integer>(10);
	 inputs.add(counterSlate);
	 inputs.add(counterBasalt);
	 inputs.add(counterPumice);
	 inputs.add(counterMudstone);
	 inputs.add(counterMarble);
	 inputs.add(counterDunite);
	 inputs.add(counterLimestone);
	 inputs.add(counterConglomerate);
	 inputs.add(counterGraniteWhite);
	 inputs.add(counterGraniteRed);
	 
	 
	 largest = Collections.max(inputs);
	 
	 System.out.println(largest);
	 
	 if(largest != 0){
		 if(largest == counterGraniteWhite){ return BlockRegistry.graniteWhite;}
		 if(largest == counterGraniteRed){ return BlockRegistry.graniteRed;}
		 if(largest == counterSlate){ return BlockRegistry.slate;}
		 if(largest == counterMarble){ return BlockRegistry.marble;}
		 if(largest == counterBasalt){ return BlockRegistry.basalt;}
		 if(largest == counterDunite){ return BlockRegistry.dunite;}
		 if(largest == counterLimestone){ return BlockRegistry.limestone;}
		 if(largest == counterMudstone){ return BlockRegistry.mudstone;}
		 if(largest == counterPumice){ return BlockRegistry.pumice;}
		 if(largest == counterConglomerate){ return BlockRegistry.conglomerate;}
	 }
	 
	 return Blocks.stone;
	 	 
	}
	
}
