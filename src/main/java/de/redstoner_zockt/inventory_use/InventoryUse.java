package de.redstoner_zockt.inventory_use;

import com.mojang.logging.LogUtils;
import de.redstoner_zockt.inventory_use.config.ServerConfig;
import de.redstoner_zockt.inventory_use.recipe.ModRecipes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(InventoryUse.MOD_ID)
public class InventoryUse {
    public static final String MOD_ID = "inventory_use";
    public static final String MOD_NAME = MOD_ID.toLowerCase().replace("_", " ");
    public static final Logger LOGGER = LogUtils.getLogger();

    public InventoryUse(IEventBus modEventBus, ModContainer container) {
        try {
            container.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC, "inventory_use-server.toml");

            NeoForge.EVENT_BUS.register(this);
            ModRecipes.register(modEventBus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
