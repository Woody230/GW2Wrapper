package com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WeaponName
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