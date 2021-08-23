package com.bselzer.library.gw2.v2.model.enumeration.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class EquipmentSlot
{
    /**
     * The breathing apparatus for aquatic environments.
     */
    @SerialName("HelmAquatic")
    BREATHING_APPARATUS,

    /**
     * The back trinket.
     */
    @SerialName("Backpack")
    BACK,

    /**
     * The coat armor.
     */
    @SerialName("Coat")
    COAT,

    /**
     * The boot armor.
     */
    @SerialName("Boots")
    BOOTS,

    /**
     * The glove armor.
     */
    @SerialName("Gloves")
    GLOVES,

    /**
     * The helm armor.
     */
    @SerialName("Helm")
    HELM,

    /**
     * The legging armor.
     */
    @SerialName("Leggings")
    LEGGINGS,

    /**
     * The shoulder armor.
     */
    @SerialName("Shoulders")
    SHOULDERS,

    /**
     * The first accessory trinket.
     */
    @SerialName("Accessory1")
    ACCESSORY1,

    /**
     * The second accessory trinket.
     */
    @SerialName("Accessory2")
    ACCESSORY2,

    /**
     * The first ring trinket.
     */
    @SerialName("Ring1")
    RING1,

    /**
     * The second ring trinket.
     */
    @SerialName("Ring2")
    RING2,

    /**
     * The amulet trinket.
     */
    @SerialName("Amulet")
    AMULET,

    /**
     * The first (and only) weapon in the first set for aquatic environments.
     */
    @SerialName("WeaponAquaticA")
    AQUATIC_WEAPON1_SET1,

    /**
     * The first (and only) weapon in the second set for aquatic environments.
     */
    @SerialName("WeaponAquaticB")
    AQUATIC_WEAPON1_SET2,

    /**
     * The first weapon in the first set for terrestrial environments.
     */
    @SerialName("WeaponA1")
    WEAPON1_SET1,

    /**
     * The second weapon in the first set for terrestrial environments.
     */
    @SerialName("WeaponA2")
    WEAPON2_SET1,

    /**
     * The first weapon in the second set for terrestrial environments.
     */
    @SerialName("WeaponB1")
    WEAPON1_SET2,

    /**
     * The second weapon in the second set for terrestrial environments.
     */
    @SerialName("WeaponB2")
    WEAPON2_SET2,

    /**
     * The forging gathering tool.
     */
    @SerialName("Sickle")
    FORGING_TOOL,

    /**
     * The logging gathering tool.
     */
    @SerialName("Axe")
    LOGGING_TOOL,

    /**
     * The mining gathering tool.
     */
    @SerialName("Pick")
    MINING_TOOL
}