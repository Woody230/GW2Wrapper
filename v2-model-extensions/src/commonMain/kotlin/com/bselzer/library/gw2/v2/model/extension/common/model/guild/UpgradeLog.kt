package com.bselzer.library.gw2.v2.model.extension.common.model.guild

import com.bselzer.library.gw2.v2.model.common.guild.log.UpgradeLog
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.guild.UpgradeAction
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [UpgradeLog.action] as an [UpgradeAction]
 */
fun UpgradeLog.action(): UpgradeAction? = action.enumValueOrNull<UpgradeAction>()