package com.gmail.jannyboy11.customrecipes.impl.crafting.vanilla.nms;

import com.gmail.jannyboy11.customrecipes.impl.crafting.vanilla.recipe.CRBannerAddPatternRecipe;

import net.minecraft.server.v1_12_R1.ItemStack;
import net.minecraft.server.v1_12_R1.Items;
import net.minecraft.server.v1_12_R1.RecipesBanner;

public class NMSBannerAdd extends NMSShapelessRecipe<RecipesBanner.AddRecipe> {

    public NMSBannerAdd(RecipesBanner.AddRecipe delegate) {
        super(delegate);
    }

    @Override
    protected CRBannerAddPatternRecipe createBukkitRecipe() {
        return new CRBannerAddPatternRecipe(this);
    }
    
    @Override
    public ItemStack b() {
        return new ItemStack(Items.BANNER);
    }

}
