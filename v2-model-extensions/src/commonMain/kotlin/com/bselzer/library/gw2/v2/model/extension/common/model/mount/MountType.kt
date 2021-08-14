package com.bselzer.library.gw2.v2.model.extension.common.model.mount

import com.bselzer.library.gw2.v2.model.common.mount.MountType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.mount.MountName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [MountType.name] as a [MountName]
 */
fun MountType.name(): MountName? = name.enumValueOrNull<MountName>()