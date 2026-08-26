package de.redstoner_zockt.inventory_use.recipe;

import de.redstoner_zockt.inventory_use.InventoryUse;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, InventoryUse.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, InventoryUse.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>,RecipeSerializer<InventoryUseRecipe>> INVENTORY_USE_SERIALIZER =
            SERIALIZERS.register("inventory_use",InventoryUseRecipe.Serializer::new);

    public static final DeferredHolder<RecipeType<?>,RecipeType<InventoryUseRecipe>> INVENTORY_USE_TYPE =
            TYPES.register("inventory_use",() -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "inventory_use";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
