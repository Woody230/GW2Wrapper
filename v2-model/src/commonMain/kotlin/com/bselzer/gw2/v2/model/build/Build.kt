package com.bselzer.gw2.v2.model.build

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Build(
    @SerialName("id")
    override val id: BuildId = BuildId()
) : Identifiable<Int>
