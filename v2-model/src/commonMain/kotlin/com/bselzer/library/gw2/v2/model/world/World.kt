package com.bselzer.library.gw2.v2.model.world

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class World(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("population")
    val population: String = ""
) : Identifiable<Int>