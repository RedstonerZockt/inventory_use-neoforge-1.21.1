package de.redstoner_zockt.inventory_use;

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
        container.registerConfig(ModConfig.Type.CLIENT, Config.SPEC, "inventory_use-client.toml");

        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }

    public static class Config {
        public static final ModConfigSpec SPEC;

        public static final ModConfigSpec.EnumValue<ClickAction> USE_MOUSE_BUTTON;

        public static final ModConfigSpec.BooleanValue SHOW_PARTICLES;
        public static final ModConfigSpec.IntValue PARTICLE_COUNT;

        public static final ModConfigSpec.IntValue USE_SOUNDS;

        static {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

            builder.comment("General").push("general");

            USE_MOUSE_BUTTON = builder
                    .translation("config.inventory_use.use_mouse_button")
                    .defineEnum("use_mouse_button",ClickAction.SECONDARY);

            builder.pop();

            builder.comment("Graphics").push("graphics");

            SHOW_PARTICLES = builder
                    .translation("config.inventory_use.show_particles")
                    .define("show_particles",true);

            PARTICLE_COUNT = builder
                    .translation("config.inventory_use.particle_count")
                    .defineInRange("particle_count",30,1,100);

            builder.pop();

            builder.comment("Sound").push("sounds");

            USE_SOUNDS = builder
                    .translation("config.inventory_use.use_sounds")
                    .defineInRange("use_sounds",50,0,100);

            builder.pop();

            SPEC = builder.build();
        }
    }
}
