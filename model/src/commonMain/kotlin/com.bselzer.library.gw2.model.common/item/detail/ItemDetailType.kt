package com.bselzer.library.gw2.model.common.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemDetailType
{
    //Consumable
    @SerialName("AppearanceChange")
    APPEARANCE_CHANGE,

    @SerialName("Booze")
    BOOZE,

    @SerialName("ContractNpc")
    CONTRACT_NPC,

    @SerialName("Currency")
    CURRENCY,

    @SerialName("Food")
    FOOD,

    @SerialName("Generic")
    GENERIC,

    @SerialName("Halloween")
    HALLOWEEN,

    @SerialName("Immediate")
    IMMEDIATE_EFFECT,

    @SerialName("MountRandomUnlock")
    MOUNT_RANDOM_UNLOCK,

    @SerialName("RandomUnlock")
    RANDOM_UNLOCK,

    @SerialName("Transmutation")
    SKIN,

    @SerialName("Unlock")
    UNLOCK,

    @SerialName("UpgradeRemoval")
    UPGRADE_REMOVAL,

    @SerialName("Utility")
    UTILITY,

    @SerialName("TeleportToFriend")
    TELEPORT_TO_FRIEND,

    //Upgrade component
    @SerialName("Default")
    DEFAULT, //Infusion, jewels, historial PvP runes/sigils

    @SerialName("Gem")
    UNIVERSAL_UPGRADE, //Gemstones, crests, doubloons

    @SerialName("Rune")
    RUNE,

    @SerialName("Sigil")
    SIGIL,

    // Other
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

    @SerialName("GiftBox")
    GIFT,

    @SerialName("OpenUI")
    CONTAINER_WITH_UI,

    @SerialName("Foraging")
    FORAGING_TOOL,

    @SerialName("Logging")
    LOGGING_TOOL,

    @SerialName("Mining")
    MINING_TOOL,

    @SerialName("ContainerKey")
    CONTAINER_KEY,

    @SerialName("RentableContractNpc")
    RENTABLE_NPC,

    @SerialName("UnlimitedConsumable")
    UNLIMITED_CONSUMABLE,

    @SerialName("Salvage")
    SALVAGE,

    @SerialName("Accessory")
    ACCESSORY,

    @SerialName("Amulet")
    AMULET,

    @SerialName("Ring")
    RING,

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

    @SerialName("LargeBundle")
    LARGE_BUNDLE,

    @SerialName("SmallBundle")
    SMALL_BUNDLE,

    @SerialName("Toy")
    TOY,

    @SerialName("ToyTwoHanded")
    TWO_HANDED_TOY
}