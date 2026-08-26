package de.redstoner_zockt.inventory_use.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record InventoryUseRecipe(
        Ingredient handItem,
        Ingredient inventoryItem,
        ItemStack outputItem,
        ResourceLocation particleTexture,
        Holder<SoundEvent> sound
) implements Recipe<InventoryUseRecipeInput> {

    @Override
    public boolean matches(InventoryUseRecipeInput input, Level level) {
        return handItem.test(input.getItem(0))
                && inventoryItem.test(input.getItem(1));
    }

    @Override
    public ItemStack assemble(
            InventoryUseRecipeInput input,
            HolderLookup.Provider provider
    ) {
        return outputItem.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return outputItem;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(handItem);
        ingredients.add(inventoryItem);
        return ingredients;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.INVENTORY_USE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.INVENTORY_USE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<InventoryUseRecipe> {

        public static final MapCodec<InventoryUseRecipe> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(

                        Ingredient.CODEC_NONEMPTY
                                .fieldOf("hand")
                                .forGetter(InventoryUseRecipe::handItem),

                        Ingredient.CODEC_NONEMPTY
                                .fieldOf("inventory")
                                .forGetter(InventoryUseRecipe::inventoryItem),

                        ItemStack.CODEC
                                .fieldOf("result")
                                .forGetter(InventoryUseRecipe::outputItem),

                        ResourceLocation.CODEC
                                .fieldOf("particle")
                                .forGetter(InventoryUseRecipe::particleTexture),

                        SoundEvent.CODEC
                                .fieldOf("sound")
                                .forGetter(InventoryUseRecipe::sound)

                ).apply(inst, InventoryUseRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, InventoryUseRecipe> STREAM_CODEC =
                StreamCodec.composite(

                        Ingredient.CONTENTS_STREAM_CODEC,
                        InventoryUseRecipe::handItem,

                        Ingredient.CONTENTS_STREAM_CODEC,
                        InventoryUseRecipe::inventoryItem,

                        ItemStack.STREAM_CODEC,
                        InventoryUseRecipe::outputItem,

                        ResourceLocation.STREAM_CODEC,
                        InventoryUseRecipe::particleTexture,

                        SoundEvent.STREAM_CODEC,
                        InventoryUseRecipe::sound,

                        InventoryUseRecipe::new
                );

        @Override
        public MapCodec<InventoryUseRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, InventoryUseRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}