package com.bselzer.gw2.v2.model.enumeration.extension.guild

import com.bselzer.gw2.v2.model.enumeration.guild.StashOperation
import com.bselzer.gw2.v2.model.guild.log.StashLog
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [StashLog.operation] as a [StashOperation]
 */
fun StashLog.operation(): StashOperation? = operation.enumValueOrNull<StashOperation>()