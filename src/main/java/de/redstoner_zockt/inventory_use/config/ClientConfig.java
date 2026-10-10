package de.redstoner_zockt.inventory_use.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.EnumValue<ClickButton> USE_MOUSE_BUTTON;

    public static final ModConfigSpec.BooleanValue SHOW_PARTICLES;
    public static final ModConfigSpec.IntValue PARTICLE_COUNT;

    public static final ModConfigSpec.IntValue USE_SOUNDS;

    static {
        BUILDER.comment("General").push("general");

        USE_MOUSE_BUTTON = BUILDER
                .translation("config.inventory_use.use_mouse_button")
                .defineEnum("use_mouse_button", ClickButton.SECONDARY);

        BUILDER.pop();

        BUILDER.comment("Graphics").push("graphics");

        SHOW_PARTICLES = BUILDER
                .translation("config.inventory_use.show_particles")
                .define("show_particles",true);

        PARTICLE_COUNT = BUILDER
                .translation("config.inventory_use.particle_count")
                .defineInRange("particle_count",30,10,100);

        BUILDER.pop();

        BUILDER.comment("Sound").push("sounds");

        USE_SOUNDS = BUILDER
                .translation("config.inventory_use.use_sounds")
                .defineInRange("use_sounds",50,0,100);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
