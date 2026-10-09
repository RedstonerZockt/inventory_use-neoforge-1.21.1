package de.redstoner_zockt.inventory_use.networking.packet;

import de.redstoner_zockt.inventory_use.InventoryUse;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ClickButtonPacketC2S(String clickButton) implements CustomPacketPayload {
    public static final Type<ClickButtonPacketC2S> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, "inventory_use_packet"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ClickButtonPacketC2S> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            ClickButtonPacketC2S::clickButton,

            ClickButtonPacketC2S::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
