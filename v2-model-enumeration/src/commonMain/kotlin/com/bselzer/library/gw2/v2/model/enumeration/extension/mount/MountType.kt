package com.bselzer.library.gw2.v2.model.enumeration.extension.mount

import com.bselzer.library.gw2.v2.model.enumeration.mount.MountName
import com.bselzer.library.gw2.v2.model.mount.MountType
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [MountType.name] as a [MountName]
 */
fun MountType.name(): MountName? = name.enumValueOrNull<MountName>()