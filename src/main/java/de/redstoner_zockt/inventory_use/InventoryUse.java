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

    public static void spawnParticles(Screen screen, ResourceLocation texture) {
        ParticleWidget particleWidget;

        double rawX = Minecraft.getInstance().mouseHandler.xpos();
        double rawY = Minecraft.getInstance().mouseHandler.ypos();

        int mouseX = (int)(rawX * (double)Minecraft.getInstance().getWindow().getGuiScaledWidth() / (double)Minecraft.getInstance().getWindow().getWidth());
        int mouseY = (int)(rawY * (double)Minecraft.getInstance().getWindow().getGuiScaledHeight() / (double)Minecraft.getInstance().getWindow().getHeight());


        int textureWidth = 16;
        int textureHeight = 16;
        int widgetWidth = textureWidth * 2;
        int widgetHeight = textureHeight * 2;
        int x = mouseX - textureWidth / 2;
        int y = mouseY - textureHeight;

        particleWidget = new ParticleWidget(x, y, widgetWidth, widgetHeight, textureWidth , textureHeight, texture, ClientConfig.PARTICLE_COUNT.get(),30);

        screen.renderables.add(particleWidget);
    }

    public static void particlesTick(Screen screen) {
        for (Renderable renderable : screen.renderables) {
            if (renderable instanceof ParticleWidget particleWidget) {
                particleWidget.tickParticles(1.5f);
            }
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {}
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
