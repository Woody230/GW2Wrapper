package com.bselzer.library.gw2.v2.model.common.home

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The hint for unlocking this cat.
     */
    @SerialName("hint")
    val hint: String = ""
) : Identifiable<Int>