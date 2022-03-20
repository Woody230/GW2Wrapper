package com.bselzer.gw2.v2.model.home.cat

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("id")
    override val id: CatId = CatId(),

    /**
     * The hint for unlocking this cat.
     */
    @SerialName("hint")
    val hint: String = ""
) : Identifiable<Int>