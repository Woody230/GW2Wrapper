package com.bselzer.library.gw2.v2.model.extension.common.model.character

import com.bselzer.library.gw2.v2.model.common.character.superadventurebox.SabUnlock
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.SabUnlockName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [SabUnlock.name] as a [SabUnlockName]
 */
fun SabUnlock.name(): SabUnlockName? = name.enumValueOrNull<SabUnlockName>()