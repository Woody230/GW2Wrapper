package com.bselzer.gw2.v2.model.enumeration.extension.character

import com.bselzer.gw2.v2.model.enumeration.character.SabUnlockName
import com.bselzer.gw2.v2.model.superadventurebox.unlock.SabUnlock
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SabUnlock.name] as a [SabUnlockName]
 */
fun SabUnlock.name(): SabUnlockName? = name.enumValueOrNull<SabUnlockName>()