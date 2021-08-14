package com.bselzer.library.gw2.v2.model.extension.common.enumeration.recipe

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RecipeType
{
    @SerialName("Axe")
    AXE,

    @SerialName("Dagger")
    DAGGER,

    @SerialName("Focus")
    FOCUS,

    @SerialName("Greatsword")
    GREATSWORD,

    @SerialName("Hammer")
    HAMMER,

    @SerialName("Harpoon")
    SPEAR,

    @SerialName("LongBow")
    LONGBOW,

    @SerialName("Mace")
    MACE,

    @SerialName("Pistol")
    PISTOL,

    @SerialName("Rifle")
    RIFLE,

    @SerialName("Scepter")
    SCEPTER,

    @SerialName("Shield")
    SHIELD,

    @SerialName("ShortBow")
    SHORTBOW,

    @SerialName("Speargun")
    HARPOON_GUN,

    @SerialName("Staff")
    STAFF,

    @SerialName("Sword")
    SWORD,

    @SerialName("Torch")
    TORCH,

    @SerialName("Trident")
    TRIDENT,

    @SerialName("Warhorn")
    WARHORN,

    @SerialName("Boots")
    BOOTS,

    @SerialName("Coat")
    CHEST,

    @SerialName("Gloves")
    GLOVES,

    @SerialName("Helm")
    HELM,

    @SerialName("HelmAquatic")
    BREATHER,

    @SerialName("Leggings")
    LEGGINGS,

    @SerialName("Shoulders")
    SHOULDERS,

    @SerialName("Earring")
    ACCESSORY,

    @SerialName("Amulet")
    AMULET,

    @SerialName("Ring")
    RING,

    @SerialName("Dessert")
    DESSERT,

    @SerialName("Feast")
    FEAST,

    @SerialName("IngredientCooking")
    INGREDIENT_COOKING,

    @SerialName("Meal")
    MEAL,

    @SerialName("Seasoning")
    SEASONING,

    @SerialName("Snack")
    SNACK,

    @SerialName("Soup")
    SOUP,

    @SerialName("Food")
    FOOD,

    @SerialName("Component")
    COMPONENT,

    @SerialName("Inscription")
    INSCRIPTION,

    @SerialName("Insignia")
    INSIGNIA,

    @SerialName("LegendaryComponent")
    LEGENDARY_COMPONENT,

    @SerialName("Refinement")
    REFINEMENT,

    @SerialName("RefinementEctoplasm")
    REFINEMENT_ECTOPLASM,

    @SerialName("RefinementObsidian")
    REFINEMENT_OBSIDIAN,

    @SerialName("GuildConsumable")
    GUILD_CONSUMABLE,

    @SerialName("GuildDecoration")
    GUILD_DECORATION,

    @SerialName("GuildConsumableWvw")
    GUILD_CONSUMBABLE_WVW,

    @SerialName("Backpack")
    BACKPACK,

    @SerialName("Bag")
    BAG,

    @SerialName("Bulk")
    BULK,

    @SerialName("Consumable")
    CONSUMABLE,

    @SerialName("Dye")
    DYE,

    @SerialName("Potion")
    POTION,

    @SerialName("UpgradeComponent")
    UPGRADE_COMPONENT
}