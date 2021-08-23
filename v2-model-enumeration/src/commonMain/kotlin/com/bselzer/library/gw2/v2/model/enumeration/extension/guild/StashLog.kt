package com.bselzer.library.gw2.v2.model.enumeration.extension.guild

import com.bselzer.library.gw2.v2.model.enumeration.guild.StashOperation
import com.bselzer.library.gw2.v2.model.guild.log.StashLog
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [StashLog.operation] as a [StashOperation]
 */
fun StashLog.operation(): StashOperation? = operation.enumValueOrNull<StashOperation>()