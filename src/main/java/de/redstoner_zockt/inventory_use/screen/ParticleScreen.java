package de.redstoner_zockt.inventory_use.screen;

import de.redstoner_zockt.inventory_use.InventoryUseClient;
import de.redstoner_zockt.inventory_use.screen.widget.ParticleWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.resources.ResourceLocation;

public interface ParticleScreen {
    default void inventoryUseSpawnParticles(ResourceLocation PARTICLE_TEXTURE) {
        ParticleWidget particleWidget;

        double rawX = Minecraft.getInstance().mouseHandler.xpos();
        double rawY = Minecraft.getInstance().mouseHandler.ypos();

        int mouseX = (int)(rawX * (double)Minecraft.getInstance().getWindow().getGuiScaledWidth() / (double)Minecraft.getInstance().getWindow().getWidth());
        int mouseY = (int)(rawY * (double)Minecraft.getInstance().getWindow().getGuiScaledHeight() / (double)Minecraft.getInstance().getWindow().getHeight());


        int textureWidth = 16;
        int textureHeight = 16;
        int widgetWidth = textureWidth * 2;
        int widgetHeight = textureHeight * 2;
        int x = mouseX - textureWidth / 2;
        int y = mouseY - textureHeight;

        particleWidget = new ParticleWidget(x, y, widgetWidth, widgetHeight, textureWidth , textureHeight, PARTICLE_TEXTURE, InventoryUseClient.Config.PARTICLE_COUNT.get(),30);

        $addRenderableOnly(particleWidget);
    }

    void $addRenderableOnly(AbstractWidget widget);

    void $tick();
}
