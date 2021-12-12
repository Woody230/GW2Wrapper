package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.ContainerDetailType
import com.bselzer.gw2.v2.model.item.detail.ContainerDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [ContainerDetails.type] as a [ContainerDetailType]
 */
fun ContainerDetails.type(): ContainerDetailType? = type.enumValueOrNull<ContainerDetailType>()