package com.bselzer.library.gw2.v2.model.enumeration.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender
{
    @SerialName("Male")
    MALE,

    @SerialName("Female")
    FEMALE
}