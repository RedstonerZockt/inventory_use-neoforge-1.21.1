package de.redstoner_zockt.inventory_use.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "minecraft", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(Items.STICK)
                .override()
                .predicate(ResourceLocation.withDefaultNamespace("custom_model_data"), 6905717)
                .model(getExistingFile(
                        ResourceLocation.fromNamespaceAndPath("inventory_use", "icon")
                ));
    }
}
