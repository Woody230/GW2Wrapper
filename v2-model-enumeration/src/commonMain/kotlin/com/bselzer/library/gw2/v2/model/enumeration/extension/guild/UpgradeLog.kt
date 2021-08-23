package com.bselzer.library.gw2.v2.model.enumeration.extension.guild

import com.bselzer.library.gw2.v2.model.enumeration.guild.UpgradeAction
import com.bselzer.library.gw2.v2.model.guild.log.UpgradeLog
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [UpgradeLog.action] as an [UpgradeAction]
 */
fun UpgradeLog.action(): UpgradeAction? = action.enumValueOrNull<UpgradeAction>()