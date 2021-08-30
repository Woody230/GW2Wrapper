package com.bselzer.library.gw2.v2.model.mount

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountSkill(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("slot")
    val slot: String = ""
) : Identifiable<Int>