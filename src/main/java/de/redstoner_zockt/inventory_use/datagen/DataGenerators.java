package de.redstoner_zockt.inventory_use.datagen;

import de.redstoner_zockt.inventory_use.InventoryUse;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = InventoryUse.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelProvider(packOutput, existingFileHelper));

        BlockTagsProvider modBlockTagProvider = new ModBlockTagProvider(packOutput,lookupProvider, existingFileHelper);

        generator.addProvider(event.includeServer(), modBlockTagProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput,lookupProvider, modBlockTagProvider.contentsGetter(),existingFileHelper));

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput,lookupProvider));
    }
}
