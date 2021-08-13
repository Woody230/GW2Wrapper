package com.bselzer.library.gw2.v2.model.extension.common.model.guild

import com.bselzer.library.gw2.v2.model.common.guild.log.StashLog
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.guild.StashOperation
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [StashLog.operation] as a [StashOperation]
 */
fun StashLog.operation(): StashOperation? = operation.enumValueOrNull<StashOperation>()