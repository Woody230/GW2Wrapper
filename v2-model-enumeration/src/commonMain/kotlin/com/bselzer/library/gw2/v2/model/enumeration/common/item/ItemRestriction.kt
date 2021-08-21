package com.bselzer.library.gw2.v2.model.enumeration.common.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemRestriction
{
    @SerialName("Asura")
    ASURA,

    @SerialName("Charr")
    CHARR,

    @SerialName("Human")
    HUMAN,

    @SerialName("Norn")
    NORN,

    @SerialName("Sylvari")
    SYLVARI,

    @SerialName("Necromancer")
    NECROMANCER,

    @SerialName("Mesmer")
    MESMER,

    @SerialName("Elementalist")
    ELEMENTALIST,

    @SerialName("Warrior")
    WARRIOR,

    @SerialName("Guardian")
    GUARDIAN,

    @SerialName("Revenant")
    REVENANT,

    @SerialName("Engineer")
    ENGINEER,

    @SerialName("Ranger")
    RANGER,

    @SerialName("Thief")
    THIEF,

    @SerialName("Female")
    FEMALE,

    @SerialName("Male")
    MALE;
}