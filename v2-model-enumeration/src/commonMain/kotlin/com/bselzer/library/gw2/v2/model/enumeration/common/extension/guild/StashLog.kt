package com.bselzer.library.gw2.v2.model.enumeration.common.extension.guild

import com.bselzer.library.gw2.v2.model.common.guild.log.StashLog
import com.bselzer.library.gw2.v2.model.enumeration.common.guild.StashOperation
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [StashLog.operation] as a [StashOperation]
 */
fun StashLog.operation(): StashOperation? = operation.enumValueOrNull<StashOperation>()