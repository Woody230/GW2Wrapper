package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.mount.MountSkin
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.mount.MountName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [MountSkin.name] as a [MountName]
 */
fun MountSkin.name(): MountName? = name.enumValueOrNull<MountName>()