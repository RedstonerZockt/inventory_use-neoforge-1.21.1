package de.redstoner_zockt.inventory_use.util;

import de.redstoner_zockt.inventory_use.InventoryUse;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> DIRT = createTag("dirt");
        public static final TagKey<Item> OTHER_DIRT = createTag("other_dirt");
        public static final TagKey<Item> ALL_DIRT = createTag("all_dirt");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(InventoryUse.MOD_ID, name));
        }
    }
}
