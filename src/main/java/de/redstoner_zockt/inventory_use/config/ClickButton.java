package de.redstoner_zockt.inventory_use.config;

import net.minecraft.world.inventory.ClickAction;

import java.util.List;

public enum ClickButton {
    PRIMARY(ClickAction.PRIMARY),
    SECONDARY(ClickAction.SECONDARY),
    BOTH(List.of(ClickAction.PRIMARY, ClickAction.SECONDARY)),
    ;

    public final List<ClickAction> map;

    public boolean is(ClickAction clickAction) {
        return map.contains(clickAction);
    }

    public boolean isNot(ClickAction clickAction) {
        return !is(clickAction);
    }

    ClickButton(List<ClickAction> map) {
        this.map = map;
    }

    ClickButton(ClickAction element) {
        this.map = List.of(element);
    }
}
