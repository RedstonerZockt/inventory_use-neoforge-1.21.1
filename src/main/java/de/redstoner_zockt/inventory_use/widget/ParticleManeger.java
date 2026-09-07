package de.redstoner_zockt.inventory_use.widget;

import de.redstoner_zockt.inventory_use.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;

public class ParticleManeger {
    public static void spawnParticles(Screen screen, ResourceLocation texture) {
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

        particleWidget = new ParticleWidget(x, y, widgetWidth, widgetHeight, textureWidth , textureHeight, texture, ClientConfig.PARTICLE_COUNT.get(),30);

        screen.renderables.add(particleWidget);
    }

    public static void particlesTick(Screen screen) {
        for (Renderable renderable : screen.renderables) {
            if (renderable instanceof ParticleWidget particleWidget) {
                particleWidget.tickParticles(1.5f);
            }
        }
    }
}
