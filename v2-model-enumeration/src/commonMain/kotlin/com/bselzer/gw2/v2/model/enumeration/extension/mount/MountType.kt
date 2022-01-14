package com.bselzer.gw2.v2.model.enumeration.extension.mount

import com.bselzer.gw2.v2.model.enumeration.mount.MountName
import com.bselzer.gw2.v2.model.mount.MountType
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [MountType.name] as a [MountName]
 */
fun MountType.name(): MountName? = name.enumValueOrNull<MountName>()