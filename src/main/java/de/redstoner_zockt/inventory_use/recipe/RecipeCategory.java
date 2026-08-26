package de.redstoner_zockt.inventory_use.recipe;

public enum RecipeCategory {
    MISC("misc"),
    DIRT("dirt"),
    WOOD("wood"),
    COPPER("copper")
    ;


    public String id;
    RecipeCategory(String id) {
        this.id = id;
    }
}
