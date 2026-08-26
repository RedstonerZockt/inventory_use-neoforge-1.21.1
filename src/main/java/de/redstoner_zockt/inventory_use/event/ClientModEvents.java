package de.redstoner_zockt.inventory_use.event;

import de.redstoner_zockt.inventory_use.InventoryUse;
import de.redstoner_zockt.inventory_use.InventoryUseClient;
import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipe;
import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipeInput;
import de.redstoner_zockt.inventory_use.recipe.ModRecipes;
import de.redstoner_zockt.inventory_use.screen.ParticleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.ItemStackedOnOtherEvent;

import java.util.Optional;

@EventBusSubscriber(modid = InventoryUse.MOD_ID,value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onItemStacked(ItemStackedOnOtherEvent event) {
        Optional<RecipeHolder<InventoryUseRecipe>> recipe = getCurrentRecipe(event);
        if (recipe.isEmpty()) return;
        if (event.getClickAction() != InventoryUseClient.Config.USE_MOUSE_BUTTON.get()) {
            return;
        }
        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(
                        recipe.get().value().sound().value(),
                        1.0F,
                        0.022f * InventoryUseClient.Config.USE_SOUNDS.get()
                )
        );

        if (InventoryUseClient.Config.SHOW_PARTICLES.get()) {
            if (Minecraft.getInstance().screen instanceof ParticleScreen screen) {
                screen.inventoryUseSpawnParticles(
                        recipe.get().value().particleTexture()
                );
            }
        }
    }

    private static Optional<RecipeHolder<InventoryUseRecipe>> getCurrentRecipe(ItemStackedOnOtherEvent event) {
        return event.getPlayer().level().getRecipeManager().getRecipeFor(ModRecipes.INVENTORY_USE_TYPE.get(),new InventoryUseRecipeInput(event.getCarriedItem(),event.getStackedOnItem()),event.getPlayer().level());
    }

    @SubscribeEvent
    public static void onClientTickPost(ClientTickEvent.Post event) {
        if (Minecraft.getInstance().screen instanceof ParticleScreen screen) {
            screen.$tick();
        }
    }
}
