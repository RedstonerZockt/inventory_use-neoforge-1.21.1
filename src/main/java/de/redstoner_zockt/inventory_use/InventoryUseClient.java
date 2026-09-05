package de.redstoner_zockt.inventory_use;

import de.redstoner_zockt.inventory_use.config.ClientConfig;
import net.minecraft.world.inventory.ClickAction;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.ModConfigSpec;

@Mod(value = InventoryUse.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = InventoryUse.MOD_ID, value = Dist.CLIENT)
public class InventoryUseClient {
    public InventoryUseClient(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, "inventory_use-client.toml");

        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }
}
