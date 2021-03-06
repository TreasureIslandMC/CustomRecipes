package com.gmail.jannyboy11.customrecipes.api.crafting.custom.ingredient;

import java.util.Collections;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

import com.gmail.jannyboy11.customrecipes.api.crafting.CraftingIngredient;

/**
 * This ingredient will accept ItemStacks that are similar to the given ItemStack using {@link org.bukkit.inventory.ItemStack#isSimilar(ItemStack)}
 * 
 * @author Jan
 *
 */
public class SimilarIngredient implements CraftingIngredient {
	
	private final ItemStack itemStack;
	
	/**
	 * Constructs the SimilarIngredient with the given ItemStack as similarity checker.
	 * 
	 * @param itemStack the ItemStack that is used for similarity checks, can be null
	 */
	public SimilarIngredient(ItemStack itemStack) {
		this.itemStack = itemStack == null ? null : itemStack.clone();
	}
	
	/**
	 * Constructor for deserialization.
	 * @param map the map with contents
	 */
	public SimilarIngredient(Map<String, Object> map) {
		this.itemStack = (ItemStack) map.get("similarTo");
	}
	
	/**
	 * Serialize method for the ConfigurationSerializable interface.
	 * @return a singleton map with key "similarTo" and value the corresponding ItemStack
	 */
	@Override
	public Map<String, Object> serialize() {
		return Collections.singletonMap("similarTo", itemStack);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isIngredient(ItemStack itemStack) {
		return this.itemStack == null ? itemStack == null : this.itemStack.isSimilar(itemStack);
	}
	
	/**
	 * Gets the item that is used for similarity checks.
	 * 
	 * @return the checker ItemStack, or null if no ItemStack was present
	 */
	public ItemStack getCheckingItem() {
		return itemStack == null ? null : itemStack.clone();
	}

}
