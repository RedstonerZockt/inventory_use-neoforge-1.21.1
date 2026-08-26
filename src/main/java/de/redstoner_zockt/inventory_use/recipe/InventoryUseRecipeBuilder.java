package de.redstoner_zockt.inventory_use.recipe;

import net.minecraft.advancements.Criterion;
import net.minecraft.core.Holder;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

public class InventoryUseRecipeBuilder implements RecipeBuilder {
    RecipeGroup group;
    RecipeCategory category;

    String group_string;

    Ingredient hand;
    Ingredient inventory;
    ItemStack output;

    SoundEvent sound;
    ResourceLocation particle;

    public InventoryUseRecipeBuilder() {
        this.hand = null;
        this.inventory = null;
        this.output = null;

        this.sound = null;
        this.particle = null;

        this.group = null;
        this.category = null;
    }

    public InventoryUseRecipeBuilder group(RecipeGroup group) {
        this.group = group;
        return this;
    }

    public InventoryUseRecipeBuilder category(RecipeCategory category) {
        this.category = category;
        return this;
    }

    public static InventoryUseRecipeBuilder recipe() {
        return new InventoryUseRecipeBuilder();
    }

    public InventoryUseRecipeBuilder ingredients(Ingredient inventory,Ingredient hand) {
        this.inventory = inventory;
        this.hand = hand;
        return this;
    }

    public InventoryUseRecipeBuilder output(ItemStack output) {
        this.output = output;
        return this;
    }

    public InventoryUseRecipeBuilder sound(SoundEvent sound) {
        this.sound = sound;
        return this;
    }

    public InventoryUseRecipeBuilder particle(ResourceLocation particle) {
        this.particle = particle;
        return this;
    }

    public @NotNull InventoryUseRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        return this;
    }

    @Override
    public @NotNull InventoryUseRecipeBuilder group(@Nullable String groupName) {
        this.group_string = groupName;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return output.getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        if (this.group == null) {
            InventoryUseRecipe recipe = new InventoryUseRecipe(hand, inventory, output, particle, Holder.direct(sound));
            recipeOutput.accept(id.withPrefix(this.group_string + "/" + this.category.id + "/"), recipe, null);
        }else {
            InventoryUseRecipe recipe = new InventoryUseRecipe(hand, inventory, output, particle, Holder.direct(sound));
            recipeOutput.accept(id.withPrefix(this.group.id + "/" + this.category.id + "/"), recipe, null);
        }

    }
}
