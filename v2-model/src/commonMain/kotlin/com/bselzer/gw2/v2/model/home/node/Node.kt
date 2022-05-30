package com.bselzer.gw2.v2.model.home.node

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Node(
    @SerialName("id")
    override val id: NodeId = NodeId()
) : Identifiable<NodeId, String>