package de.redstoner_zockt.inventory_use.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
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
