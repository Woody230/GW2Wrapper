package com.bselzer.library.gw2.v2.model.enumeration.common.extension.guild

import com.bselzer.library.gw2.v2.model.common.guild.log.UpgradeLog
import com.bselzer.library.gw2.v2.model.enumeration.common.guild.UpgradeAction
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [UpgradeLog.action] as an [UpgradeAction]
 */
fun UpgradeLog.action(): UpgradeAction? = action.enumValueOrNull<UpgradeAction>()