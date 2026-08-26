package de.redstoner_zockt.inventory_use.datagen;

import de.redstoner_zockt.inventory_use.InventoryUse;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    HolderLookup.Provider lookupProvider;
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InventoryUse.MOD_ID, existingFileHelper);
        try {
            this.lookupProvider = lookupProvider.get();
        }catch (Exception e){
            InventoryUse.LOGGER.warn("Failed to load block tags for ModBlockTagProvider");
        }
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }

    public HolderGetter.Provider getterLookup() {
        return this.lookupProvider.asGetterLookup();
    }
}
