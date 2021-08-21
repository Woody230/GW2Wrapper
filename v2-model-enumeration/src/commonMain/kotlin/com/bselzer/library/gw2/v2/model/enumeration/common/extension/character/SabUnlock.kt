package com.bselzer.library.gw2.v2.model.enumeration.common.extension.character

import com.bselzer.library.gw2.v2.model.common.character.superadventurebox.SabUnlock
import com.bselzer.library.gw2.v2.model.enumeration.common.character.SabUnlockName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [SabUnlock.name] as a [SabUnlockName]
 */
fun SabUnlock.name(): SabUnlockName? = name.enumValueOrNull<SabUnlockName>()