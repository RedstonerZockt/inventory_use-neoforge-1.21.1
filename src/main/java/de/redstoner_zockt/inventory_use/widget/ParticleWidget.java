package de.redstoner_zockt.inventory_use.widget;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;

public class ParticleWidget extends AbstractWidget {

    private final ResourceLocation texture;
    private final ArrayList<ParticleDataManager> particles = new ArrayList<>();

    private final int particleCount;
    private final int textureWidth;
    private final int textureHeight;
    private int spawnTicks = 1;
    private final int maxSpawnTicks;

    public ParticleWidget(
            int x,
            int y,
            int width,
            int height,
            int textureWidth,
            int textureHeight,
            ResourceLocation texture,
            int particleCount,
            int maxSpawnTicks
    ) {
        super(x, y, width, height, Component.literal("Particle"));

        this.texture = texture;
        this.particleCount = particleCount;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;

        this.maxSpawnTicks = maxSpawnTicks;

        for (int i = 0; i < particleCount; i++) {
            particles.add(createParticle());
        }
    }

    private ParticleDataManager createParticle() {

        int coMaxU = textureWidth - 2;
        int coMaxV = textureHeight - 2;

        int t_u = (int) (Math.random() * coMaxU) + 1;
        int t_v = (int) (Math.random() * coMaxV) + 1;

        float startX = (float) (Math.random() * this.width);
        float startY = (float) (Math.random() * this.height);

        return new ParticleDataManager(t_u, t_v, startX, startY);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        for (ParticleDataManager particle : particles) {
            if (!particle.visible) continue;
            float x = getX() + particle.x_o;
            float y = getY() + particle.y_o;
            float size = 2.0f * particle.scale;
            int alpha = (int) (particle.alpha * 255.0f);
            if (alpha <= 0) continue;
            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(x + size / 2f, y + size / 2f, 0);
            guiGraphics.pose().mulPose(com.mojang.math.Axis.ZP.rotation(particle.rotation));
            guiGraphics.pose().scale(particle.scale, particle.scale, 1.0f);
            guiGraphics.pose().translate(-1, -1, 0);
            guiGraphics.setColor(1.0f, 1.0f, 1.0f, particle.alpha);
            guiGraphics.blit(
                    texture,
                    0,
                    0,
                    particle.t_u,
                    particle.t_v,
                    2,
                    2,
                    textureWidth,
                    textureHeight
            );
            guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            guiGraphics.pose().popPose();
        }
    }

    public void tickParticles(float multiplier) {
        if (spawnTicks < maxSpawnTicks) {
            for (int i = 0; i < particles.size(); i++) {
                ParticleDataManager particle = particles.get(i);
                if (!particle.visible) particles.set(i, createParticle());
            }
            spawnTicks++;
        }

        for (ParticleDataManager particle : particles) {
            if (particle.visible) {
                particle.tick(multiplier);
            }
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
    }
}