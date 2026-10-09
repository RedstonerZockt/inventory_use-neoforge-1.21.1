package de.redstoner_zockt.inventory_use.event;

import de.redstoner_zockt.inventory_use.InventoryUse;
import de.redstoner_zockt.inventory_use.config.ClientConfig;
import de.redstoner_zockt.inventory_use.config.ServerConfig;
import de.redstoner_zockt.inventory_use.networking.ClientPayloadHandler;
import de.redstoner_zockt.inventory_use.networking.packet.ClickButtonPacketC2S;
import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipe;
import de.redstoner_zockt.inventory_use.recipe.InventoryUseRecipeInput;
import de.redstoner_zockt.inventory_use.recipe.ModRecipes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemStackedOnOtherEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.Optional;

@EventBusSubscriber(
        modid = InventoryUse.MOD_ID
)
public class ModEvents {

    @SubscribeEvent
    public static void onItemStacked(ItemStackedOnOtherEvent event) {
        Player player = event.getPlayer();
        ItemStack carriedItem = event.getCarriedItem();
        ItemStack targetItem = event.getStackedOnItem();

        Optional<RecipeHolder<InventoryUseRecipe>> recipe = getCurrentRecipe(event);
        if (recipe.isEmpty()) return;
        if (ServerConfig.Temp.CLICK_BUTTONS.get(player).isNot(event.getClickAction())) return;

        ItemStack result = recipe.get().value().outputItem();
        if (result == null) return;
        int amountToConvert = targetItem.getCount();
        int damage = amountToConvert * ServerConfig.DAMAGE_PER_BLOCK.get();
        if (!ServerConfig.DAMAGE.get()){
            damage = 0;
        }
        if (carriedItem.isDamageableItem()) {
            int remainingDurability = carriedItem.getMaxDamage() - carriedItem.getDamageValue();
            if (damage > remainingDurability) {
                return;
            }
            carriedItem.hurtAndBreak(
                    damage,
                    player,
                    event.getCarriedSlotAccess().get().getEquipmentSlot()
            );
        }
        else {
            if (damage > carriedItem.getCount()) {
                return;
            }
            carriedItem.shrink(damage);
        }
        ItemStack newStack = result.copy();
        newStack.setCount(amountToConvert);
        event.getSlot().set(newStack);
        event.setCanceled(true);
    }

    private static Optional<RecipeHolder<InventoryUseRecipe>> getCurrentRecipe(ItemStackedOnOtherEvent event) {
        return event.getPlayer().level().getRecipeManager().getRecipeFor(ModRecipes.INVENTORY_USE_TYPE.get(), new InventoryUseRecipeInput(event.getCarriedItem(), event.getStackedOnItem()), event.getPlayer().level());
    }

    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");

        registrar.playToServer(ClickButtonPacketC2S.TYPE, ClickButtonPacketC2S.STREAM_CODEC, ClientPayloadHandler::handleClickButtonPacket);
    }
}