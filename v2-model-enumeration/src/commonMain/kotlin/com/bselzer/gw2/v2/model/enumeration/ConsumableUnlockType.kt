package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ConsumableUnlockType {
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