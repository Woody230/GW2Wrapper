package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.GizmoDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.GizmoDetailType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [GizmoDetails.type] as a [GizmoDetailType]
 */
fun GizmoDetails.type(): GizmoDetailType? = type.enumValueOrNull<GizmoDetailType>()