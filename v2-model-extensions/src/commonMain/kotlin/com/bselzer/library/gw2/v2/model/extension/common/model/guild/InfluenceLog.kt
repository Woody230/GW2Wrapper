package com.bselzer.library.gw2.v2.model.extension.common.model.guild

import com.bselzer.library.gw2.v2.model.common.guild.log.InfluenceLog
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.guild.InfluenceActivity
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [InfluenceLog.activity] as an [InfluenceActivity]
 */
fun InfluenceLog.activity(): InfluenceActivity? = activity.enumValueOrNull<InfluenceActivity>()