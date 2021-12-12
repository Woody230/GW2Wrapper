package com.bselzer.gw2.v2.model.enumeration.extension.guild

import com.bselzer.gw2.v2.model.enumeration.guild.UpgradeAction
import com.bselzer.gw2.v2.model.guild.log.UpgradeLog
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [UpgradeLog.action] as an [UpgradeAction]
 */
fun UpgradeLog.action(): UpgradeAction? = action.enumValueOrNull<UpgradeAction>()