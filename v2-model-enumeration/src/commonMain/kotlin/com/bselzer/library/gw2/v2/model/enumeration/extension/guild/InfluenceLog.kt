package com.bselzer.library.gw2.v2.model.enumeration.extension.guild

import com.bselzer.library.gw2.v2.model.enumeration.guild.InfluenceActivity
import com.bselzer.library.gw2.v2.model.guild.log.InfluenceLog
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [InfluenceLog.activity] as an [InfluenceActivity]
 */
fun InfluenceLog.activity(): InfluenceActivity? = activity.enumValueOrNull<InfluenceActivity>()