package com.bselzer.library.gw2.v2.model.enumeration.extension.mount

import com.bselzer.library.gw2.v2.model.enumeration.mount.MountName
import com.bselzer.library.gw2.v2.model.mount.MountSkin
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [MountSkin.name] as a [MountName]
 */
fun MountSkin.name(): MountName? = name.enumValueOrNull<MountName>()