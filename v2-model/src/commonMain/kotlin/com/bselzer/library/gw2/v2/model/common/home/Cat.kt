package com.bselzer.library.gw2.v2.model.common.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("id")
    val id: Int = 0,

    /**
     * The hint for unlocking this cat.
     */
    @SerialName("hint")
    val hint: String = ""
)