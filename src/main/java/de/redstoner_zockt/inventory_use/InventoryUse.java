package de.redstoner_zockt.inventory_use;

import de.redstoner_zockt.inventory_use.config.ClientConfig;
import de.redstoner_zockt.inventory_use.config.ServerConfig;
import de.redstoner_zockt.inventory_use.recipe.ModRecipes;
import de.redstoner_zockt.inventory_use.widget.ParticleWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(InventoryUse.MOD_ID)
public class InventoryUse {
    public static final String MOD_ID = "inventory_use";
    public static final String MOD_NAME = MOD_ID.toLowerCase().replace("_", " ");
    public static final Logger LOGGER = LogUtils.getLogger();

    public InventoryUse(IEventBus modEventBus, ModContainer container) {
        LOGGER.info("Loading: {}", MOD_NAME);
        try {
            container.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC, "inventory_use-server.toml");

            NeoForge.EVENT_BUS.register(this);
            modEventBus.addListener(this::addCreative);
            ModRecipes.register(modEventBus);
        }catch (Exception e){
            e.printStackTrace();
        }
        LOGGER.info("Loaded: {}", MOD_NAME);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {}
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
