package de.redstoner_zockt.inventory_use.config;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.util.StringRepresentable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ClickButton implements StringRepresentable {
    PRIMARY(ClickAction.PRIMARY),
    SECONDARY(ClickAction.SECONDARY),
    BOTH(ClickAction.PRIMARY, ClickAction.SECONDARY);

    private final List<ClickAction> clickActions;

    ClickButton(ClickAction... clickActions) {
        this.clickActions = new ArrayList<>();
        this.clickActions.addAll(Arrays.asList(clickActions));
    }

    public boolean is(ClickAction clickAction) {
        return clickActions.contains(clickAction);
    }

    public boolean isNot(ClickAction clickAction) {
        return !is(clickAction);
    }

    @Override
    public String getSerializedName() {
        return this.name().toLowerCase();
    }
}
