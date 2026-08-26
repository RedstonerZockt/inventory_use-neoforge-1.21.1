package de.redstoner_zockt.inventory_use.mixin;

import de.redstoner_zockt.inventory_use.screen.ParticleScreen;
import de.redstoner_zockt.inventory_use.screen.widget.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractContainerEventHandler implements Renderable, ParticleScreen {

    @Shadow
    @Final
    public List<Renderable> renderables;

    @Shadow
    protected abstract <T extends Renderable> T addRenderableOnly(T renderable);

    @Inject(method = "render",at = @At("TAIL"))
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        for (Renderable renderable : this.renderables) {
            if (renderable instanceof ParticleWidget particleWidget) {
                particleWidget.render(guiGraphics, mouseX, mouseY, partialTick);
            }
        }
    }

    @Override
    public void $addRenderableOnly(AbstractWidget widget) {
        this.addRenderableOnly(widget);
    }

    @Override
    public void $tick() {
        for (Renderable renderable : this.renderables) {
            if (renderable instanceof ParticleWidget particleWidget) {
                particleWidget.tickParticles(1.5f);
            }
        }
    }
}
