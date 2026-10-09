package de.redstoner_zockt.inventory_use.config;

import java.util.List;

public enum ClickAction {
    PRIMARY(List.of(net.minecraft.world.inventory.ClickAction.PRIMARY)),
    SECONDARY(List.of(net.minecraft.world.inventory.ClickAction.SECONDARY)),
    BOTH(List.of(net.minecraft.world.inventory.ClickAction.PRIMARY, net.minecraft.world.inventory.ClickAction.SECONDARY)),
    ;

    public final List<net.minecraft.world.inventory.ClickAction> map;

    public boolean is(net.minecraft.world.inventory.ClickAction clickAction) {
        return map.contains(clickAction);
    }

    public boolean isNot(net.minecraft.world.inventory.ClickAction clickAction) {
        return !is(clickAction);
    }

    ClickAction(List<net.minecraft.world.inventory.ClickAction> map) {
        this.map = map;
    }
}
