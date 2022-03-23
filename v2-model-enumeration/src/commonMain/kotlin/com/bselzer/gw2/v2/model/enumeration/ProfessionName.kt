package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProfessionName {
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
    THIEF;
}