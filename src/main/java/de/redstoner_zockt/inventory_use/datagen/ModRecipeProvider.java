package de.redstoner_zockt.inventory_use.datagen;

import de.redstoner_zockt.inventory_use.InventoryUse;
import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipeBuilder;
import de.redstoner_zockt.inventory_use.recipe.RecipeCategory;
import de.redstoner_zockt.inventory_use.recipe.RecipeGroup;
import de.redstoner_zockt.inventory_use.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.DIRT)
                .ingredients(Ingredient.of(ModTags.Items.DIRT),Ingredient.of(ItemTags.SHOVELS))
                .output(new ItemStack(Items.DIRT_PATH))
                .sound(SoundEvents.SHOVEL_FLATTEN)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/dirt.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "dirt_path_1"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.DIRT)
                .ingredients(Ingredient.of(ModTags.Items.OTHER_DIRT),Ingredient.of(ItemTags.SHOVELS))
                .output(new ItemStack(Items.DIRT_PATH))
                .sound(SoundEvents.SHOVEL_FLATTEN)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/dirt.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "dirt_path_2"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.DIRT)
                .ingredients(Ingredient.of(ModTags.Items.OTHER_DIRT),Ingredient.of(ItemTags.HOES))
                .output(new ItemStack(Items.DIRT))
                .sound(SoundEvents.HOE_TILL)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/dirt.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "dirt"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.DIRT)
                .ingredients(Ingredient.of(ModTags.Items.DIRT),Ingredient.of(ItemTags.HOES))
                .output(new ItemStack(Items.FARMLAND))
                .sound(SoundEvents.HOE_TILL)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/dirt.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "farmland"));

        //======================
        //misc
        //======================

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.MISC)
                .ingredients(Ingredient.of(Items.PUMPKIN),Ingredient.of(Items.SHEARS))
                .output(new ItemStack(Items.CARVED_PUMPKIN))
                .sound(SoundEvents.PUMPKIN_CARVE)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/pumpkin_side.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "carved_pumpkin"));

        //======================
        //wood
        //======================

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.ACACIA_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_ACACIA_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/acacia_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_acacia_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.ACACIA_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_ACACIA_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/acacia_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_acacia_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.BAMBOO_BLOCK),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_BAMBOO_BLOCK))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/bamboo_block.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_bamboo_block"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.BIRCH_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_BIRCH_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/birch_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_birch_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.BIRCH_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_BIRCH_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/birch_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_birch_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.CHERRY_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_CHERRY_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/cherry_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_cherry_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.CHERRY_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_CHERRY_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/cherry_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_cherry_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.CRIMSON_STEM),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_CRIMSON_STEM))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/crimson_stem.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_crimson_stem"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.CRIMSON_HYPHAE),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_CRIMSON_HYPHAE))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/crimson_stem.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_crimson_hyphae"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.DARK_OAK_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_DARK_OAK_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/dark_oak_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_dark_oak_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.DARK_OAK_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_DARK_OAK_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/dark_oak_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_dark_oak_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.JUNGLE_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_JUNGLE_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/jungle_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_jungle_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.JUNGLE_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_JUNGLE_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/jungle_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_jungle_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.MANGROVE_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_MANGROVE_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/mangrove_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_mangrove_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.MANGROVE_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_MANGROVE_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/mangrove_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_mangrove_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.OAK_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_OAK_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/oak_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_oak_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.OAK_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_OAK_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/oak_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_oak_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.SPRUCE_LOG),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_SPRUCE_LOG))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/spruce_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_spruce_log"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.SPRUCE_WOOD),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_SPRUCE_WOOD))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/spruce_log.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_spruce_wood"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.WARPED_STEM),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_WARPED_STEM))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/warped_stem.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_warped_stem"));

        InventoryUseRecipeBuilder.recipe()
                .group(RecipeGroup.VANILLA).category(RecipeCategory.WOOD)
                .ingredients(Ingredient.of(Items.WARPED_HYPHAE),Ingredient.of(ItemTags.AXES))
                .output(new ItemStack(Items.STRIPPED_WARPED_HYPHAE))
                .sound(SoundEvents.AXE_STRIP)
                .particle(ResourceLocation.withDefaultNamespace("textures/block/warped_stem.png"))
                .save(recipeOutput,ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "stripped_warped_hyphae"));
    }
}