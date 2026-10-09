package de.redstoner_zockt.inventory_use.config;

import de.redstoner_zockt.inventory_use.networking.packet.ClickButtonPacketC2S;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.HashMap;
import java.util.Map;

public class ClickButtons {
    public static Map<Player, ClickButton> CLICK_BUTTONS = new HashMap<>();

    public static void put(ClickButtonPacketC2S clickButtonPacket, IPayloadContext payloadContext) {
        CLICK_BUTTONS.put(payloadContext.player(), ClickButton.valueOf(clickButtonPacket.clickButton()));
    }

    public static void put(Player player, ClickButton clickButton) {
        CLICK_BUTTONS.put(player, clickButton);
    }

    public static ClickButton get(Player player) {
        return CLICK_BUTTONS.get(player);
    }
}
