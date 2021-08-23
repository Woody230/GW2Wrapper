package com.bselzer.library.gw2.v2.model.enumeration.extension.character

import com.bselzer.library.gw2.v2.model.character.superadventurebox.SabUnlock
import com.bselzer.library.gw2.v2.model.enumeration.character.SabUnlockName
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [SabUnlock.name] as a [SabUnlockName]
 */
fun SabUnlock.name(): SabUnlockName? = name.enumValueOrNull<SabUnlockName>()