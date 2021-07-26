package com.bselzer.library.gw2.model.extension.common.enumerations.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemDetailFlag
{
    @SerialName("Axe")
    AXE,

    @SerialName("Dagger")
    DAGGER,

    @SerialName("Mace")
    MACE,

    @SerialName("Pistol")
    PISTOL,

    @SerialName("Sword")
    SWORD,

    @SerialName("Scepter")
    SCEPTER,

    @SerialName("Focus")
    FOCUS,

    @SerialName("Shield")
    SHIELD,

    @SerialName("Torch")
    TORCH,

    @SerialName("Warhorn")
    WARHORN,

    @SerialName("Greatsword")
    GREATSWORD,

    @SerialName("Hammer")
    HAMMER,

    @SerialName("LongBow")
    LONGBOW,

    @SerialName("Rifle")
    RIFLE,

    @SerialName("ShortBow")
    SHORTBOW,

    @SerialName("Staff")
    STAFF,

    @SerialName("Harpoon")
    SPEAR,

    @SerialName("Speargun")
    HARPOON_GUN,

    @SerialName("Trident")
    TRIDENT,

    @SerialName("HeavyArmor")
    HEAVY_ARMOR,

    @SerialName("MediumArmor")
    MEDIUM_ARMOR,

    @SerialName("LightArmor")
    LIGHT_ARMOR,

    @SerialName("Trinket")
    TRINKET;
}