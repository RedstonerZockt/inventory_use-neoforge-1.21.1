package de.redstoner_zockt.inventory_use.config;

import net.minecraft.world.inventory.ClickAction;
import java.util.List;

public enum ClickButton {
    PRIMARY(ClickAction.PRIMARY),
    SECONDARY(ClickAction.SECONDARY),
    BOTH(ClickAction.PRIMARY, ClickAction.SECONDARY);

    private final List<ClickAction> clickActions;

    ClickButton(ClickAction... clickActions) {
        this.clickActions = List.of(clickActions);
    }

    public boolean is(ClickAction clickAction) {
        return clickActions.contains(clickAction);
    }

    public boolean isNot(ClickAction clickAction) {
        return !is(clickAction);
    }
}