package com.bselzer.library.gw2.v2.model.extension.common.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemDetailUnlockType
{
    //Consumable
    @SerialName("BagSlot")
    BAG_SLOT,

    @SerialName("BankTab")
    BANK_TAB,

    @SerialName("Champion")
    MIST_CHAMPION,

    @SerialName("CollectibleCapacity")
    STORAGE_EXPANDER,

    @SerialName("Content")
    CONTENT,

    @SerialName("CraftingRecipe")
    CRAFTING_RECIPE,

    @SerialName("Dye")
    DYE,

    @SerialName("GliderSkin")
    GLIDER_SKIN,

    @SerialName("Minipet")
    MINIATURE,

    @SerialName("Ms")
    MOUNT_SKIN,

    @SerialName("Outfit")
    OUTFIT,

    @SerialName("RandomUnlock")
    RANDOM_UNLOCK,

    @SerialName("SharedSlot")
    SHARED_SLOT;
}