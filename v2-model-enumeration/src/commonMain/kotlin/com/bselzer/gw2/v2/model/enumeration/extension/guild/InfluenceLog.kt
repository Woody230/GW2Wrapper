package com.bselzer.gw2.v2.model.enumeration.extension.guild

import com.bselzer.gw2.v2.model.enumeration.guild.InfluenceActivity
import com.bselzer.gw2.v2.model.guild.log.InfluenceLog
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [InfluenceLog.activity] as an [InfluenceActivity]
 */
fun InfluenceLog.activity(): InfluenceActivity? = activity.enumValueOrNull<InfluenceActivity>()