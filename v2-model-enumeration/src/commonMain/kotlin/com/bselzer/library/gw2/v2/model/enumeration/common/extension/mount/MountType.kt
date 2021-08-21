package com.bselzer.library.gw2.v2.model.enumeration.common.extension.mount

import com.bselzer.library.gw2.v2.model.common.mount.MountType
import com.bselzer.library.gw2.v2.model.enumeration.common.mount.MountName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [MountType.name] as a [MountName]
 */
fun MountType.name(): MountName? = name.enumValueOrNull<MountName>()