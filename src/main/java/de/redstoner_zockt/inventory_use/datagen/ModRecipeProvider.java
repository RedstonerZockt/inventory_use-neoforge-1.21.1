package de.redstoner_zockt.inventory_use.datagen;

import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipe;
import de.redstoner_zockt.inventory_use.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //======================
        //dirt
        //======================

        InventoryUseRecipe.Builder.recipe()
                .inventory(ModTags.Items.ALL_DIRT)
                .hand(ItemTags.SHOVELS)
                .output(Items.DIRT_PATH)
                .sound(SoundEvents.SHOVEL_FLATTEN)
                .particle("textures/block/dirt.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(ModTags.Items.OTHER_DIRT)
                .hand(ItemTags.HOES)
                .output(Items.DIRT)
                .sound(SoundEvents.HOE_TILL)
                .particle("textures/block/dirt.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(ModTags.Items.DIRT)
                .hand(ItemTags.HOES)
                .output(Items.FARMLAND)
                .sound(SoundEvents.HOE_TILL)
                .particle("textures/block/dirt.png")
                .save(recipeOutput);

        //======================
        //misc
        //======================

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.PUMPKIN)
                .hand(Items.SHEARS)
                .output(Items.CARVED_PUMPKIN)
                .sound(SoundEvents.PUMPKIN_CARVE)
                .particle("textures/block/pumpkin_side.png")
                .save(recipeOutput);

        //======================
        //wood
        //======================

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.ACACIA_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_ACACIA_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/acacia_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.ACACIA_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_ACACIA_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/acacia_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.BAMBOO_BLOCK)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_BAMBOO_BLOCK)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/bamboo_block.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.BIRCH_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_BIRCH_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/birch_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.BIRCH_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_BIRCH_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/birch_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.CHERRY_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_CHERRY_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/cherry_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.CHERRY_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_CHERRY_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/cherry_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.CRIMSON_STEM)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_CRIMSON_STEM)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/crimson_stem.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.CRIMSON_HYPHAE)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_CRIMSON_HYPHAE)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/crimson_stem.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.DARK_OAK_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_DARK_OAK_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/dark_oak_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.DARK_OAK_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_DARK_OAK_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/dark_oak_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.JUNGLE_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_JUNGLE_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/jungle_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.JUNGLE_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_JUNGLE_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/jungle_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.MANGROVE_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_MANGROVE_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/mangrove_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.MANGROVE_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_MANGROVE_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/mangrove_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.OAK_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_OAK_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/oak_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.OAK_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_OAK_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/oak_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.SPRUCE_LOG)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_SPRUCE_LOG)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/spruce_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.SPRUCE_WOOD)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_SPRUCE_WOOD)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/spruce_log.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.WARPED_STEM)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_WARPED_STEM)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/warped_stem.png")
                .save(recipeOutput);

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.WARPED_HYPHAE)
                .hand(ItemTags.AXES)
                .output(Items.STRIPPED_WARPED_HYPHAE)
                .sound(SoundEvents.AXE_STRIP)
                .particle("textures/block/warped_stem.png")
                .save(recipeOutput);

        //======================
        //copper
        //======================

        //TODO : add copper Recipes

        InventoryUseRecipe.Builder.recipe()
                .inventory(Items.WAXED_COPPER_BLOCK)
                .hand(ItemTags.AXES)
                .output(Items.COPPER_BLOCK)
                .sound(SoundEvents.AXE_WAX_OFF)
                .particle("textures/block/honeycomb_block.png")
                .save(recipeOutput);
    }
}