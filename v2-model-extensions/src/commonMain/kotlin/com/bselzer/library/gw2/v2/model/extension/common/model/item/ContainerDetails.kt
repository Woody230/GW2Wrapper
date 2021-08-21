package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.ContainerDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ContainerDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ContainerDetails.type] as a [ContainerDetailType]
 */
fun ContainerDetails.type(): ContainerDetailType? = type.enumValueOrNull<ContainerDetailType>()