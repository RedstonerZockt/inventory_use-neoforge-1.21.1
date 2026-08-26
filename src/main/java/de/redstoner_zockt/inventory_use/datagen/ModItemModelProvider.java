package de.redstoner_zockt.inventory_use.datagen;

import de.redstoner_zockt.inventory_use.InventoryUse;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, InventoryUse.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ResourceLocation.fromNamespaceAndPath(this.modid,"icon"));
    }
}
