package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ConsumableDetailType {
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
}