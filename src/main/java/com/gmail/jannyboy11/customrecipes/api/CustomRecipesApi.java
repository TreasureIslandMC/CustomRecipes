package com.gmail.jannyboy11.customrecipes.api;

import com.gmail.jannyboy11.customrecipes.api.crafting.CraftingManager;
import com.gmail.jannyboy11.customrecipes.api.crafting.CraftingRecipe;
import com.gmail.jannyboy11.customrecipes.api.crafting.vanilla.recipe.ShapedRecipe;
import com.gmail.jannyboy11.customrecipes.api.crafting.vanilla.recipe.ShapelessRecipe;
import com.gmail.jannyboy11.customrecipes.api.furnace.FurnaceManager;
import com.gmail.jannyboy11.customrecipes.api.furnace.FurnaceRecipe;

/**
 * The Custom Recipes application programming interface.
 *
 * This interface is implemented by the CustomRecipes plugin's main class,
 * so the instance can easily be acquired using Bukkit's PluginManager API.
 * <pre>
 * {@code
 * Plugin customRecipesPlugin = Bukkit.getPluginManager().getPlugin("CustomRecipes");
 * CustomRecipesApi api = (CustomRecipesApi) customRecipesPlugin;
 * }
 * </pre> 
 * 
 * @author Jan
 *
 */
public interface CustomRecipesApi {

	/**
	 * Translate a bukkit shaped recipe to a CustomRecipes shaped recipe.
	 * 
	 * @param bukkitRecipe the bukkit recipe
	 * @return the CustomRecipes variant
	 */
	public ShapedRecipe asCustomRecipesMirror(org.bukkit.inventory.ShapedRecipe bukkitRecipe);

	/**
	 * Translate a bukkit shapeless recipe to a CustomRecipes shapeless recipe.
	 * 
	 * @param bukkitRecipe the bukkit recipe
	 * @return the CustomRecipes variant
	 */
	public ShapelessRecipe asCustomRecipesMirror(org.bukkit.inventory.ShapelessRecipe bukkitRecipe);
	
	/**
	 * Translate a bukkit furnace recipe to a CustomRecipes furnace recipe.
	 * 
	 * @param bukkitRecipe the bukkit recipe
	 * @return the CustomRecipes variant
	 */
	public FurnaceRecipe asCustomRecipesMirror(org.bukkit.inventory.FurnaceRecipe bukkitRecipe);

	/**
	 * Tests whether the crafting recipe is a vanilla kind.
	 * 
	 * @param recipe the recipe
	 * @return whether it's implementation is a vanilla implementation
	 * @deprecated weird method to put in the API, also, there is no equivalent for furnace recipes.
	 */
	@Deprecated
	public boolean isVanillaRecipeType(CraftingRecipe recipe);

	/**
	 * Get the furnace manager
	 * @return the furnace manager
	 */
	public FurnaceManager getFurnaceManager();

	/**
	 * Get the crafting manager
	 * @return the crafting manager
	 */
	public CraftingManager getCraftingManager();
	
	
}
