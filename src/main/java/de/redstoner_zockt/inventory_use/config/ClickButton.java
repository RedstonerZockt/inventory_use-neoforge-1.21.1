package de.redstoner_zockt.inventory_use.config;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.ClickAction;

import java.util.List;

public enum ClickButton {
    PRIMARY(ClickAction.PRIMARY, Component.translatable("config.inventory_use.use_mouse_button.primary")),
    SECONDARY(ClickAction.SECONDARY, Component.translatable("config.inventory_use.use_mouse_button.secondary")),
    BOTH(List.of(ClickAction.PRIMARY, ClickAction.SECONDARY), Component.translatable("config.inventory_use.use_mouse_button.both")),
    ;

    public final List<ClickAction> map;
    public final Component translation_key;

    public boolean is(ClickAction clickAction) {
        return map.contains(clickAction);
    }

    public boolean isNot(ClickAction clickAction) {
        return !is(clickAction);
    }

    ClickButton(List<ClickAction> map, Component translationKey) {
        this.map = map;
        translation_key = translationKey;
    }

    ClickButton(ClickAction element, Component translationKey) {
        this.map = List.of(element);
        translation_key = translationKey;
    }
}
