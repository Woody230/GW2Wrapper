package com.bselzer.gw2.v2.model.enumeration.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SabUnlockName {
    @SerialName("chain_stick")
    CHAIN_STICK,

    @SerialName("slingshot")
    SLINGSHOT,

    @SerialName("whip")
    WHIP,

    @SerialName("mini_bomb")
    MINI_BOMB,

    @SerialName("candle")
    CANDLE,

    @SerialName("torch")
    TORCH,

    @SerialName("wooden_whistle")
    WOODEN_WHISTLE,

    @SerialName("digger")
    DIGGER,

    @SerialName("nice_scoop")
    NICE_SCOOP,

    @SerialName("glove_of_wisdom")
    GLOVE_OF_WISDOM,

    @SerialName("bauble_purse")
    BAUBLE_PURSE,

    @SerialName("bauble_tote_bag")
    BAUBLE_TOTE_BAG,

    @SerialName("moto_breath")
    MOTO_BREATH,

    @SerialName("moto_finger")
    MOTO_FINER,

    @SerialName("health_vessel_1")
    HEALTH_VESSEL1,

    @SerialName("health_vessel_2")
    HEALTH_VESSEL2,

    @SerialName("medium_health_potion")
    MEDIUM_HEALTH_POTION
}