package com.bselzer.library.gw2.v2.model.common.item

import com.bselzer.library.gw2.v2.model.common.item.detail.GizmoDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Gizmo")
data class GizmoItem(
    @SerialName("details")
    val details: GizmoDetails = GizmoDetails()
) : Item()