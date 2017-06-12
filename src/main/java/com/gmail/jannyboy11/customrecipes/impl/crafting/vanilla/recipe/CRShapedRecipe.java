package com.gmail.jannyboy11.customrecipes.impl.crafting.vanilla.recipe;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftNamespacedKey;

import com.gmail.jannyboy11.customrecipes.api.crafting.vanilla.recipe.ShapedRecipe;
import com.gmail.jannyboy11.customrecipes.impl.crafting.CRCraftingIngredient;
import com.gmail.jannyboy11.customrecipes.impl.crafting.vanilla.ingredient.CRChoiceIngredient;
import com.gmail.jannyboy11.customrecipes.util.ReflectionUtil;

import net.minecraft.server.v1_12_R1.NonNullList;
import net.minecraft.server.v1_12_R1.RecipeItemStack;
import net.minecraft.server.v1_12_R1.ShapedRecipes;

public class CRShapedRecipe<R extends ShapedRecipes> extends CRVanillaRecipe<R> implements ShapedRecipe {

	public CRShapedRecipe(R nmsRecipe) {
		super(nmsRecipe, nmsRecipe.key);
	}
	
	@Override
	public int getWidth() {
		return (int) ReflectionUtil.getDeclaredFieldValue(nmsRecipe, "width");
	}
	
	@Override
	public int getHeight() {
		return (int) ReflectionUtil.getDeclaredFieldValue(nmsRecipe, "height");
	}
	
	@Override
	public List<CRChoiceIngredient> getIngredients() {
		return nmsIngredients().stream().map(CRCraftingIngredient::getVanilla).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	private NonNullList<RecipeItemStack> nmsIngredients() {
		return (NonNullList<RecipeItemStack>) ReflectionUtil.getDeclaredFieldValue(nmsRecipe, "items");
	}
	
	@Override
	public NamespacedKey getKey() {
		return CraftNamespacedKey.fromMinecraft(nmsRecipe.key);
	}

	@Override
	public String getGroup() {
		return (String) ReflectionUtil.getDeclaredFieldValue(nmsRecipe, "e");
	}

}
