package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RaceGender {
    @SerialName("AsuraMale")
    ASURA_MALE,

    @SerialName("AsuraFemale")
    ASURA_FEMALE,

    @SerialName("CharrMale")
    CHARR_MALE,

    @SerialName("CharrFemale")
    CHARR_FEMALE,

    @SerialName("HumanMale")
    HUMAN_MALE,

    @SerialName("HumanFemale")
    HUMAN_FEMALE,

    @SerialName("NornMale")
    NORN_MALE,

    @SerialName("NornFemale")
    NORN_FEMALE,

    @SerialName("SylvariMale")
    SYLVARI_MALE,

    @SerialName("SylvariFemale")
    SYLVARI_FEMALE
}