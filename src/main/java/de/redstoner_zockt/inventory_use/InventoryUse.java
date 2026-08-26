package de.redstoner_zockt.inventory_use;

import de.redstoner_zockt.inventory_use.recipe.ModRecipes;
import net.minecraft.world.inventory.ClickAction;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.ModConfigSpec;
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
            container.registerConfig(ModConfig.Type.SERVER, InventoryUse.Config.SPEC, "inventory_use-server.toml");

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

    public static class Config {
        public static final ModConfigSpec SPEC;

        public static final ModConfigSpec.IntValue DAMAGE_PER_BLOCK;
        public static final ModConfigSpec.BooleanValue DAMAGE;

        static {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

            DAMAGE = builder
                    .translation("config.inventory_use.damage")
                    .define("damage",true);

            DAMAGE_PER_BLOCK = builder
                    .translation("config.inventory_use.damage_per_block")
                    .defineInRange("damage_per_block",1,1,10);

            SPEC = builder.build();
        }
    }

}
