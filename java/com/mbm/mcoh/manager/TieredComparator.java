package com.mbm.mcoh.manager;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class TieredComparator implements Comparator {
	
	final TieredCraftingManager manager;
	
	public TieredComparator(TieredCraftingManager tieredCraftingManager){
		  this.manager = tieredCraftingManager;
		  
	}
	
	public int compareRecipes(ITieredRecipe recipe1, ITieredRecipe recipe2){
		if(recipe1 instanceof TieredShapelessRecipes && recipe2 instanceof TieredRecipes){
			return 1;
			}
		
		if(recipe2 instanceof TieredShapelessRecipes && recipe1 instanceof TieredRecipes){
			return -1;
			}
		
		if(recipe2.getRecipeSize() < recipe1.getRecipeSize()){
			return -1;
			}
		
		if(recipe2.getRecipeSize() > recipe1.getRecipeSize()){
			return 1;
			}
		
		return 0;
	
	}

	@Override
	public int compare(Object o1, Object o2) {
		 return this.compareRecipes((ITieredRecipe)o1,(ITieredRecipe)o2);
	}

}
