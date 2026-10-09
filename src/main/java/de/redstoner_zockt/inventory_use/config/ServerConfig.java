package de.redstoner_zockt.inventory_use.config;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class ServerConfig {
    public static class Temp {
        public static Map<Player, ClickAction> CLICK_BUTTONS = new HashMap<>();
    }

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue DAMAGE_PER_BLOCK;
    public static final ModConfigSpec.BooleanValue DAMAGE;

    static {
        DAMAGE = BUILDER
                .translation("config.inventory_use.damage")
                .define("damage",true);

        DAMAGE_PER_BLOCK = BUILDER
                .translation("config.inventory_use.damage_per_block")
                .defineInRange("damage_per_block",1,1,10);

        SPEC = BUILDER.build();
    }
}
