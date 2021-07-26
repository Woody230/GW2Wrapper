package com.bselzer.library.gw2.model.extension.common.enumerations.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemType
{
    @SerialName("Armor")
    ARMOR,

    @SerialName("Back")
    BACK_ITEM,

    @SerialName("Bag")
    BAG,

    @SerialName("Consumable")
    CONSUMABLE,

    @SerialName("Container")
    CONTAINER,

    @SerialName("CraftingMaterial")
    CRAFTING_MATERIAL,

    @SerialName("Gathering")
    GATHERING_TOOL,

    @SerialName("Gizmo")
    GIZMO,

    @SerialName("MiniPet")
    MINIATURE,

    @SerialName("Tool")
    SALVAGE_KIT,

    @SerialName("Trait")
    TRAIT_GUIDE,

    @SerialName("Trinket")
    TRINKET,

    @SerialName("Trophy")
    TROPHY,

    @SerialName("UpgradeComponent")
    UPGRADE_COMPONENT,

    @SerialName("Weapon")
    WEAPON,

    @SerialName("Key")
    KEY;
}