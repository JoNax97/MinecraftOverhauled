package com.mbm.mcoh.manager;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ITieredRecipe {
	
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(InventoryCrafting inventory, World world, ItemStack usedTool, int tier);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack usedTool);

    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();

    ItemStack getRecipeOutput();

}
