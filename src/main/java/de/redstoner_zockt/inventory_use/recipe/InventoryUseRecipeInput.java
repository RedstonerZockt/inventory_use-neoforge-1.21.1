package de.redstoner_zockt.inventory_use.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record InventoryUseRecipeInput(ItemStack hnd, ItemStack inv) implements RecipeInput {

    @Override
    public ItemStack getItem(int i) {
        return switch (i) {
            case 0 -> hnd;
            case 1 -> inv;
            default -> throw new IndexOutOfBoundsException("Index: " + i);
        };
    }

    @Override
    public int size() {
        return 2;
    }
}