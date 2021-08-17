package com.bselzer.library.gw2.v2.model.common.build

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Build(
    @SerialName("id")
    override val id: Int
) : Identifiable<Int>
