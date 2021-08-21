package com.bselzer.library.gw2.v2.model.enumeration.common.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponType
{
    @SerialName("Nothing")
    NOTHING,

    @SerialName("None")
    NONE,

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

    @SerialName("Longbow")
    LONGBOW,

    @SerialName("Rifle")
    RIFLE,

    @SerialName("Shortbow")
    SHORTBOW,

    @SerialName("Staff")
    STAFF,

    @SerialName("Speargun")
    HARPOON_GUN,

    @SerialName("Spear")
    SPEAR,

    @SerialName("Trident")
    TRIDENT;
}