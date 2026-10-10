package de.redstoner_zockt.inventory_use.config;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.ClickAction;

import java.util.List;

public enum ClickButton {
    PRIMARY(ClickAction.PRIMARY, Component.translatable("config.inventory_use.use_mouse_button.primary")),
    SECONDARY(ClickAction.SECONDARY, Component.translatable("config.inventory_use.use_mouse_button.secondary")),
    BOTH(List.of(ClickAction.PRIMARY, ClickAction.SECONDARY), Component.translatable("config.inventory_use.use_mouse_button.both")),
    ;

    private final List<ClickAction> clickActions;
    private final Component translation_key;

    public Component getTranslationKey() {
        return translation_key;
    }

    public boolean is(ClickAction clickAction) {
        return clickActions.contains(clickAction);
    }

    public boolean isNot(ClickAction clickAction) {
        return !is(clickAction);
    }

    ClickButton(List<ClickAction> clickActions, Component translationKey) {
        this.clickActions = clickActions;
        translation_key = translationKey;
    }

    ClickButton(ClickAction clickAction, Component translationKey) {
        this.clickActions = List.of(clickAction);
        translation_key = translationKey;
    }
}
