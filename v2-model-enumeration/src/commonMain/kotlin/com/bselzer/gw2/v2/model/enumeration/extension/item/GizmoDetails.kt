package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.GizmoDetailType
import com.bselzer.gw2.v2.model.item.detail.GizmoDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [GizmoDetails.type] as a [GizmoDetailType]
 */
fun GizmoDetails.type(): GizmoDetailType? = type.enumValueOrNull<GizmoDetailType>()