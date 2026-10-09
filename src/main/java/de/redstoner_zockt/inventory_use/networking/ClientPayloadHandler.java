package de.redstoner_zockt.inventory_use.networking;

import de.redstoner_zockt.inventory_use.config.ClickAction;
import de.redstoner_zockt.inventory_use.config.ServerConfig;
import de.redstoner_zockt.inventory_use.networking.packet.ClickButtonPacketC2S;
import net.neoforged.neoforge.network.handling.IPayloadContext;

//client -> >server<
//>< : our position
public class ClientPayloadHandler {
    //on server
    public static void handleClickButtonPacket(ClickButtonPacketC2S clickButtonPacketC2S, IPayloadContext iPayloadContext) {
        ServerConfig.Temp.add(iPayloadContext.player(), ClickAction.valueOf(clickButtonPacketC2S.clickButton()));
    }
}
