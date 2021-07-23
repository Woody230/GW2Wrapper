package com.bselzer.library.gw2.model.common.mechanics.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemFlag
{
    @SerialName("AccountBindOnUse")
    ACCOUNT_BOUND_ON_USE,

    @SerialName("AccountBound")
    ACCOUNT_BOUND_ON_ACQUIRE,

    @SerialName("Attuned")
    IS_ATTUNED,

    @SerialName("BulkConsume")
    CAN_BULK_CONSUME,

    @SerialName("DeleteWarning")
    PROMPT_WARNING_ON_DELETE,

    @SerialName("HideSuffix")
    HIDE_UPGRADE_COMPONENT_SUFFIX,

    @SerialName("Infused")
    IS_INFUSED,

    @SerialName("MonsterOnly")
    MONSTER_ONLY,

    @SerialName("NoMysticForge")
    NO_MYSTIC_FORGE,

    @SerialName("NoSalvage")
    NO_SALVAGE,

    @SerialName("NoSell")
    NO_SELL,

    @SerialName("NotUpgradeable")
    NOT_UPGRADEABLE,

    @SerialName("NoUnderwater")
    NO_UNDERWATER,

    @SerialName("SoulbindOnAcquire")
    SOULBIND_ON_ACQUIRE,

    @SerialName("SoulBindOnUse")
    SOULBIND_ON_USE,

    @SerialName("Tonic")
    IS_TONIC,

    @SerialName("Unique")
    IS_UNIQUE;
}