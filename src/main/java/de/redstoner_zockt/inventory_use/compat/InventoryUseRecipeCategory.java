package de.redstoner_zockt.inventory_use.compat;

import de.redstoner_zockt.inventory_use.InventoryUse;
import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomModelData;
import org.jetbrains.annotations.NotNull;

public class InventoryUseRecipeCategory
        implements IRecipeCategory<InventoryUseRecipe> {

    public static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(
                    InventoryUse.MOD_ID,
                    "inventory_use"
            );

    public static final ResourceLocation BACKGROUND =
            ResourceLocation.fromNamespaceAndPath(
                    InventoryUse.MOD_ID,
                    "textures/jei/back.png"
            );

    public static final ResourceLocation ICON =
            ResourceLocation.fromNamespaceAndPath(
                    InventoryUse.MOD_ID,
                    "textures/item/icon.png"
            );

    public static final RecipeType<InventoryUseRecipe> INVENTORY_USE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(
                    UID,
                    InventoryUseRecipe.class
            );

    private static final int WIDTH = 129;
    private static final int HEIGHT = 56;

    private final IDrawable icon;

    public InventoryUseRecipeCategory(IGuiHelper helper) {
        ItemStack stack = new ItemStack(Items.STICK);

        stack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(6905717));
        stack.set(DataComponents.ITEM_NAME, Component.literal(InventoryUse.MOD_NAME));

        this.icon = helper.createDrawableItemStack(stack);
    }

    @Override
    public @NotNull RecipeType<InventoryUseRecipe> getRecipeType() {
        return INVENTORY_USE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal(InventoryUse.MOD_NAME);
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(
            IRecipeLayoutBuilder builder,
            InventoryUseRecipe recipe,
            IFocusGroup focuses
    ) {
        builder.addSlot(
                RecipeIngredientRole.INPUT,
                16,
                20
        ).addIngredients(
                recipe.getIngredients().get(1)
        );

        builder.addSlot(
                RecipeIngredientRole.INPUT,
                20,
                26
        ).addIngredients(
                recipe.getIngredients().get(0)
        );

        builder.addSlot(
                RecipeIngredientRole.OUTPUT,
                92,
                20
        ).addItemStack(
                recipe.getResultItem(null)
        );
    }



    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public void draw(
            InventoryUseRecipe recipe,
            IRecipeSlotsView recipeSlotsView,
            GuiGraphics guiGraphics,
            double mouseX,
            double mouseY
    ) {
        guiGraphics.blit(
                BACKGROUND,
                0,
                0,
                0,
                0,
                WIDTH,
                HEIGHT,
                WIDTH,
                HEIGHT
        );
        IRecipeCategory.super.draw(
                recipe,
                recipeSlotsView,
                guiGraphics,
                mouseX,
                mouseY
        );

    }
}