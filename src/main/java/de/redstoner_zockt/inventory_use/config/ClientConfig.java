package de.redstoner_zockt.inventory_use.config;

import net.minecraft.world.inventory.ClickAction;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
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
