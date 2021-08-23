package com.bselzer.library.gw2.v2.model.home

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Node(
    @SerialName("id")
    override val id: String = ""
) : Identifiable<String>