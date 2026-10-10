package de.redstoner_zockt.inventory_use.config;

import net.minecraft.world.inventory.ClickAction;

public enum ClickButtonConfig {
    primary(ClickButton.PRIMARY),
    secondary(ClickButton.SECONDARY),
    both(ClickButton.BOTH);

    private final ClickButton button;

    ClickButtonConfig(ClickButton button) {
        this.button = button;
    }

    public ClickButton getButton() {
        return button;
    }
}
