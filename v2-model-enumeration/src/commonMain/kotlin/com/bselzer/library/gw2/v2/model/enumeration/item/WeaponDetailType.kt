package com.bselzer.library.gw2.v2.model.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponDetailType
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

    @SerialName("LargeBundle")
    LARGE_BUNDLE,

    @SerialName("SmallBundle")
    SMALL_BUNDLE,

    @SerialName("Toy")
    TOY,

    @SerialName("ToyTwoHanded")
    TWO_HANDED_TOY
}