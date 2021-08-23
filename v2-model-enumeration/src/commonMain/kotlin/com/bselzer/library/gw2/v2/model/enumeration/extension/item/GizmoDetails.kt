package com.bselzer.library.gw2.v2.model.enumeration.extension.item

import com.bselzer.library.gw2.v2.model.enumeration.item.GizmoDetailType
import com.bselzer.library.gw2.v2.model.item.detail.GizmoDetails
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [GizmoDetails.type] as a [GizmoDetailType]
 */
fun GizmoDetails.type(): GizmoDetailType? = type.enumValueOrNull<GizmoDetailType>()